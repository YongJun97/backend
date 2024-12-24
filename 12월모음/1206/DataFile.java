package Project2_이슬;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;

public class DataFile {
    private File file;

    // 생성자
    public DataFile(String filename){
        file = new File("C:\\Project2_이슬\\"+filename+".txt");
    }

    // 메서드
    // 파일 확인 메서드
    private boolean checkExist(File f) {
        if (f.exists()) {
            return true;
        }
        return false;
    }
    private boolean checkRead(File f) {
        if (f.isFile() && f.canRead()){
            return true;
        }
        return false;
    }
    private boolean checkWrite(File f){
        if (f.isFile() && f.canWrite()){
            return true;
        }
        return false;
    }
    
    // 파일 생성
    public void createfile(){
        try {
            if(!checkExist(file)){
                if(file.createNewFile()){
                    System.out.println();
                }else{
                    System.out.println("파일 생성 실패");
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // 파일에 Data 저장
    public void saveFile(String[] data){
        try{
            PrintWriter pWriter = new PrintWriter(new BufferedWriter(new FileWriter(file)));
            if (checkExist(file) && checkWrite(file)) {
                for (int i=0; i<data.length; i++){
                    pWriter.println(data[i]);
                }
            }
            System.out.println();
            pWriter.close();
        }catch (IOException e) {
            System.out.println("파일에 저장 실패");
            e.printStackTrace();
        }
    }

    // 파일에서 members Data 불러오기 
    public HashMap<String, Members> memLoadFile () throws Exception{
        HashMap<String, Members> map = new HashMap<>();
        if (checkExist(file) && checkRead(file)) {
            BufferedReader br = new BufferedReader(new FileReader(file));
            String line = "";
            Members members = null;
            
            while ((line = br.readLine()) != null){
                // 파일을 한 줄씩 읽어서 line에 저장
                String attribute[] = line.split(",");
                // 콤마를 기준으로 나눈 후 attribute 변수에 추가
                members = new Members(
                                        attribute[0], 
                                        attribute[1], 
                                        attribute[2], 
                                        attribute[3], 
                                        Boolean.parseBoolean(attribute[4]), 
                                        Integer.parseInt(attribute[5]),
                                        attribute[6], 
                                        attribute[7], 
                                        attribute[8]);
                map.put(members.getId(), members);
            }
            br.close();
        }
        return map;
    }

    // 파일에서 members Data 불러오기 
    public HashMap<String, Programs> prgmLoadFile () throws Exception{
        HashMap<String, Programs> map = new HashMap<>();
        if (checkExist(file) && checkRead(file)) {
            BufferedReader br = new BufferedReader(new FileReader(file));
            String line = "";
            Programs programs = null;
                        
            while ((line = br.readLine()) != null){
                // 파일을 한 줄씩 읽어서 line에 저장
                String attribute[] = line.split("/");
                programs = new Programs(
                                        attribute[0], 
                                        attribute[1], 
                                        attribute[2], 
                                        attribute[3], 
                                        attribute[4], 
                                        Integer.parseInt(attribute[5]),
                                        Boolean.parseBoolean(attribute[6]), 
                                        Boolean.parseBoolean(attribute[7]));
                map.put(programs.getpID(), programs);
            }
            br.close();
        }
        return map;
    }

    // 파일에서 enroll Data 불러오기 
    public HashMap<String, Enrollment> enrollLoadFile () throws Exception{
        HashMap<String, Enrollment> map = new HashMap<>();
        if (checkExist(file) && checkRead(file)) {
            BufferedReader br = new BufferedReader(new FileReader(file));
            String line = "";
            Enrollment enrollment = null;
                        
            while ((line = br.readLine()) != null){
                // 파일을 한 줄씩 읽어서 line에 저장
                String attribute[] = line.split(",");
                enrollment = new Enrollment(
                                        attribute[0], 
                                        attribute[1], 
                                        attribute[2]);
                map.put(enrollment.geteID(), enrollment);
            }
            br.close();
        }
        return map;
    }

}
