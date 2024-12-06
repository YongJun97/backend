package out;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class FileControl {
    ExcuteApp excuter = new ExcuteApp();
    ArrayList<WorkDTO> works = new ArrayList<WorkDTO>();

    public void readFile() {
        try {
            FileInputStream input = new FileInputStream("out\\out.txt");
            InputStreamReader reader = new InputStreamReader(input, "UTF-8");
            BufferedReader br = new BufferedReader(reader);
            // 한글 깨짐 현상 해결
            String line;
            ArrayList<String> f = new ArrayList<String>();
            ArrayList<Integer> saveN = new ArrayList<Integer>();
            ArrayList<Integer> saveNN = new ArrayList<Integer>();

            while ((line = br.readLine()) != null) {
                String[] str = line.split("\n");
                for (String string : str) {
                    f.add(string);
                }
            }
            // 여기부터 처리를 시작.
            for (int i = 0; i < f.size(); i++) {
                if (f.get(i).equals("")) {
                    saveN.add(i);
                    // System.out.println(i);
                }
            } // 빈줄 있는거 싹느.
            saveNN.add(0);
            saveNN.add(0);
            for (int i = 0; i < saveN.size(); i++) {
                if (i > 0 && (saveN.get(i - 1) + 1 == saveN.get(i))) {
                    saveNN.add(saveN.get(i));
                    //System.out.println(saveN.get(i));
                }
            } // 두줄 빈줄있는것 중 마지막 빈줄의 위치를 느. 1-12

            WorkDTO work = null;
            int month = 0;
            int day = 0;
            boolean am = false;
            String strLine;
            String place;
            int category;// 복사인지 아닌지

            // int id;사원번호
            // int month;월
            // int day;날짜
            // String place;장소
            // int category;카테고리
            //System.out.println( saveNN.size()-1);
            for (int i = 0; i < saveNN.size()-1; i++) {
                int a = -1;
                int b = 0; // 비어있는 줄의 라인번호 +1인 오전 오후 를 뽑는다.
                //System.out.println(i+1);
                //System.out.println(saveNN.get(i+1)-1);
                for (int j = (saveNN.get(i) + 1); j < saveNN.get(i + 1)-1 ; j++) {
                    ++a;
                    //System.out.println(f.get(j));
                    //System.out.print(++a + "\t");
                    if (a == 0) {
                        // 날짜
                        // 7. 1. (월)
                        strLine = f.get(j);
                        String[] date = strLine.split(". ");
                        month = Integer.parseInt(date[0]);
                        day = Integer.parseInt(date[1]);
                     } else if (a == 1) {
                        // 오전
                        am = true;
                     } else if (f.get(j).equals("")) {
                         b = j + 1;
                    } else if (b == j) {
                        am = false;
                    }else {
                        strLine = f.get(j);
                        strLine = strLine.replaceAll("현출", "");
                        strLine = strLine.replaceAll("현퇴", "");
                        strLine = strLine.replaceAll("1", "");
                        strLine = strLine.replaceAll("0", "");
                        strLine = strLine.replaceAll(":", "");
                        strLine = strLine.replaceAll("2", "");
                        strLine = strLine.replaceAll("3", "");
                        strLine = strLine.replaceAll("4", "");
                        strLine = strLine.replaceAll("5", "");
                        strLine = strLine.replaceAll("6", "");
                        strLine = strLine.replaceAll("7", "");
                        strLine = strLine.replaceAll("8", "");
                        strLine = strLine.replaceAll("9", "");
                        strLine = strLine.replaceAll(" ", "");
                        strLine = strLine.replaceAll("선고등", "선고");
                        strLine = strLine.replaceAll("제출등", "제출");
                        strLine = strLine.replaceAll("수령등", "제출");
                        strLine = strLine.replaceAll("발급등", "제출");
                        strLine = strLine.replaceAll("회수등", "제출");
                        strLine = strLine.replaceAll("복사등", "복사");
                        strLine = strLine.replaceAll("확인등", "제출");
                        strLine = strLine.replaceAll("이후복사", "복사");
                        strLine = strLine.replaceAll("배당금수령", "제출");
                        strLine = strLine.replaceAll("공탁금회수", "제출");
                        strLine = strLine.replaceAll("공탁금", "");
                        strLine = strLine.replaceAll("수령", "제출");
                        strLine = strLine.replaceAll("신청", "제출");
                        strLine = strLine.replaceAll("전달", "제출");
                        strLine = strLine.replaceAll("회수", "제출");
                        strLine = strLine.replaceAll("발급", "제출");
                        strLine = strLine.replaceAll("확인", "제출");
                        strLine = strLine.replaceAll("협의", "제출");
                        strLine = strLine.replaceAll("청취", "선고");
                        strLine = strLine.replaceAll("\\)", "");
                        strLine = strLine.replaceAll("\\(", "-");
                        strLine = strLine.replaceAll("--", "-");
                        strLine = strLine.replaceAll("\\?", "-");
                        strLine = strLine.replaceAll("건", "");
                        String[] workData = strLine.split("-");

                        if (workData.length>4&&workData[1].contains(",")) {
                            String[] names = workData[1].split(",");
                            works.add(new WorkDTO(names[0], month, day, workData[0], workData[2], am));
                            works.add(new WorkDTO(names[1], month, day, workData[0], workData[2], am));
                            // System.out.printf("%s %2d.%2d %s %s %b \n",names[0], month, day, workData[0], workData[2], am);
                            // System.out.printf("%s %2d.%2d %s %s %b \n",names[1], month, day, workData[0], workData[2], am);
                        } else if (workData.length>4&&workData[2].contains(",")) {
                            String[] cates = workData[2].split(",");
                            works.add(new WorkDTO(workData[1], month, day, workData[0], cates[0], am));
                            works.add(new WorkDTO(workData[1], month, day, workData[0], cates[1], am));
                            // System.out.printf("%s %2d.%2d %s %s %b\n",workData[1], month, day, workData[0], cates[0], am);
                            // System.out.printf("%s %2d.%2d %s %s %b\n",workData[1], month, day, workData[0], cates[1], am);
                        } else if(workData.length>4){
                            works.add(new WorkDTO(workData[1], month, day, workData[0], workData[2], am));
                            //System.out.printf("%s %2d.%2d %s %s %b\n",workData[1], month, day, workData[0], workData[2], am);
                        }
                    }
                }
            }

            System.out.println("파일 불러오기에 성공했습니다");
            br.close();
        } catch (FileNotFoundException e) {
            System.out.println("파일을 찾을 수 없습니다.");

        } catch (IOException e) {
            System.out.println("파일 읽어오기에 실패했습니다.");
        }
    }

    public void runFile() {
        // 복사 오전 = 1
        // 복사 오후 = 2
        // 선고 오전 = 3
        // 선고 오후 = 4
        // 제출 오전 = 5
        // 제출 오후 = 6
        // 집행 = 7

        int i = 0;

        for (WorkDTO work : works) {

            String cateStr = work.getStrCategory();
            Boolean am = work.isAm();
            String place = work.getPlace();
            int category;
            if (cateStr.equals("복사") && place.contains("고등")) {
                category = 1;
            } else if (cateStr.equals("복사")) {
                category = 2;
            } else if (cateStr.equals("선고") && am == true) {
                category = 3;
            } else if (cateStr.equals("선고") && am == false) {
                category = 4;
            } else if (cateStr.equals("제출") && am == true) {
                category = 5;
            } else if (cateStr.equals("제출") && am == false) {
                category = 6;
            } else {
                category = 7;// 집행
            }
            work.setCategory(category);
            works.set(i, work);
            i = i + 1;
        }
        // for(WorkDTO w :works){
        //     System.out.println(w.getName() +" "+ w.getMonth()+"."+w.getDay()+ " "+w.getPlace()+" "+w.getCategory());
        // }

    }

    public void printFile(ExcuteApp e) {
        
        try {
            File file = new File("out\\outPrint.txt");
            BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(file));
            for (WorkDTO work : works) {
                String p = work.getName() + "\t" +
                        work.getMonth() + "월" +
                        work.getDay() + "일\t" +
                        work.getCategory() + "\t" +
                        work.getPlace()+"\n";
                if (file.isFile() && file.canWrite()) {
                    bufferedWriter.write(p);
                    bufferedWriter.flush();
                }
            }
            
            System.out.println("파일 저장을 완료했습니다");

            bufferedWriter.close();

        } catch (IOException exception) {
            System.out.println("파일 저장을 실패했습니다");
        }
        
        // int id =0;
        // Map<Integer, EmployeeWorkDTO> ewList = new HashMap<>();
        // Map<Integer, EmployeeDTO> employeeList = e.getEmployees();
        // for(int i =1;i<employeeList.size();i++){
        //     id = employeeList.get(i).getId();
        // }

    }
}
