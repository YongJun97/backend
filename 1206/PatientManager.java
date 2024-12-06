package Hospital;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class PatientManager {
    private static ArrayList<Patient> patients;  //환자목록
    Loading load = new Loading();
    Scanner sc = new Scanner(System.in);
    public String hospital = "#     #    " + " ###     " + " ####     " + "#####    " + "#####    " + "#####      " + "#        " + "#\n"
                          +"#     #    " + "#   #    " + "#         " + "#   #    " + "  #      " + "  #       " + "# #       " + "#\n"
                          +"#######    " + "#   #    " + "#####     " + "#####    " + "  #      " + "  #      " + "#####      " + "#\n"
                          +"#     #    " + "#   #    " + "    #     " + "#        " + "  #      " + "  #     " + "#     #     " + "#\n"
                          +"#     #    " + " ###     " + "####      " + "#        " + "#####    " + "  #    " + "#       #    " + "#####\n";

    public PatientManager(){    //더미데이터
        patients = new ArrayList<>();
        // patients.add(new Patient("홍길동", "010-1234-1234", "경기도 성남시", "치과", "12:30"));
    }

    public void patientAppointment() {  //환자 등록
        System.out.println("=========== 환자 등록 ===========\n");
        System.out.print("이름: ");
        String name = sc.next();
        sc.nextLine();
        System.out.print("전화번호(-포함): ");
        String phone = sc.next();
        sc.nextLine();
        System.out.print("주소: ");
        String address = sc.nextLine();
        System.out.print("진료 내용: ");
        String disease = sc.next();
        sc.nextLine();
        System.out.print("예약 시간: ");
        String time = sc.next();
        sc.nextLine();
        patients.add(new Patient(name, phone, address, disease, time));
        System.out.println("접수중입니다.");
        load.loading();
        System.out.println("\n"+ name + "님, 진료가 접수되었습니다.");
    }

    public void patientPrint() {
        boolean patientAppoint = false;
        System.out.print("등록된 정보를 보고 싶은 환자의 이름: ");
        String name = sc.next();
        for(Patient list : patients){
            patientAppoint = true;
            if(list.getName().equalsIgnoreCase(name)){
                    System.out.println("등록 정보: "+ list.getDisease() + " " + list.getTime());
            }
        }
        if(!patientAppoint){
            System.out.println("정보가 존재하지 않습니다.");
            return;
        }
        
    }

    public void adminMenu() {
        while (true) {
            System.out.println("\n======= 관리자 메뉴 =======\n");
            System.out.println("1. 환자 등록 목록");
            System.out.println("2. 환자 등록 삭제");
            System.out.println("3. 환자 정보 수정");
            System.out.println("4. 메인으로 돌아가기\n");
            System.out.print("입력 > ");
            
            int choice = -1;
            try {
                choice = sc.nextInt();
            } catch (InputMismatchException e) {
                System.out.println("잘못된 입력입니다. 숫자만 입력하세요.");
                sc.next();
                continue;
            }
            switch (choice) {
                case 1:
                    printAll();
                    break;
                case 2:
                    cancelAppoint();
                    break;
                case 3:
                    updatePatient();
                    break;
                case 4:
                    return;
                default:
                    System.out.println("잘못 입력했습니다. 다시 입력해주세요.");
                    break;
            }
        }
    }

    private void printAll() {
        for(Patient patientList : patients){
            System.out.println(patientList.toString());
        }
        if(patients.isEmpty()){
            System.out.println("존재하지 않습니다.");
            return;
        }
    }

    private void cancelAppoint() {
        System.out.print("등록된 정보를 삭제하고 싶은 환자 이름: ");
        String cancelName = sc.next();
    
        boolean patientFound = false;
        for (Patient patient : patients) {
            if (patient.getName().equalsIgnoreCase(cancelName)) {
                patients.remove(patient);
                System.out.println("삭제중입니다.");
                load.loading();
                System.out.println("\n" + cancelName + "님의 정보가 삭제되었습니다.");
                patientFound = true;
                break;  // Exit the loop once the patient is found and removed
            }
        }
        
        if (!patientFound) {
            System.out.println("존재하지 않습니다.");
        }
    }

    private void updatePatient() {
        boolean patientFound = false;
        System.out.print("정보를 수정할 환자 이름: ");
        String name = sc.next();
        for(Patient list : patients){
            if(list.getName().equals(name)){
                patientFound = true;
                System.out.println("수정하고 싶은 정보를 선택하세요");
                System.out.println("1. 전화번호 | 2. 주소 | 3. 예약 시간");
                System.out.print("입력> ");
                String updateNum = sc.next();
                if(updateNum.equals("1")){
                    System.out.print("수정> ");
                    String updatePhone = sc.next();
                    list.setPhone(updatePhone);
                    System.out.println(name +" 님의 전화번호가 수정되었습니다.");
                }else if(updateNum.equals("2")){
                    System.out.print("수정> ");
                    sc.nextLine();
                    String updateAddress = sc.nextLine();
                    list.setAddress(updateAddress);
                    System.out.println(name +" 님의 주소가 수정되었습니다.");
                    break;
                }else if(updateNum.equals("3")){
                    System.out.print("수정> ");
                    String updateTime = sc.next();
                    list.setTime(updateTime);
                    System.out.println(name +" 님의 예약 시간이 수정되었습니다.");
                    break;
                }else{
                    System.out.println("잘못 입력했습니다.");
                    break;
                }  
            }
        }
        if(!patientFound){
            System.out.println("존재하지 않습니다.");
        }
    }
}
