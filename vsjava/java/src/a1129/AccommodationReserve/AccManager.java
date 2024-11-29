package a1129.AccommodationReserve;

import java.util.ArrayList;
import java.util.Scanner;

// 숙소를 관리
public class AccManager {
    private ArrayList<Accommodation> accommodations; // 숙소집합
    private ArrayList<Accommodation> bookedAccommodations; // 예약한숙소
    
    public AccManager() {
        accommodations = new ArrayList<>(); // 초기숙소를 저장할 리스트
        this.bookedAccommodations = new ArrayList<>();
        // 초기숙소 추가
        accommodations.add(new Accommodation("호텔A", "서울", 100.0));
        accommodations.add(new Accommodation("호텔B", "부산", 80.0));
        accommodations.add(new Accommodation("호텔C", "제주", 120.0));

    }

    public void disAvailAccommodations() {
        System.out.println("예약가능 숙소보기");
        for(Accommodation accommodation : accommodations){
            if(accommodation.isAvailablel()){
                System.out.println(accommodation);
            }
        }
    }

    public boolean bookedAccommodations(String name) {
        for(Accommodation accommodation : accommodations){
            if(accommodation.getName().equalsIgnoreCase(name) && accommodation.isAvailablel()){  // equalsIgnoreCase 는 영문 비교 할 때 대소문자 상관없이 소문자로 바꿔서 비교 해 준다
                accommodation.book(); // isAvailablel() 에 false를 넣는 메소드
                bookedAccommodations.add(accommodation); // 예약숙소 arraylist 추가
                return true;
            }
        
        }
        return false;
    }

    public void disBookedAccomodation() {
        System.out.println("예약한 숙소: ");
        for(Accommodation accommodation : bookedAccommodations){
            System.out.println(accommodation);
        }
    }

    public void addAccomodation(String newName, String newLocation, Double newPrice) {
        accommodations.add(new Accommodation(newName, newLocation, newPrice));
    }

    public void deleteAccommodation(String dname) {
        boolean result = false;
        for(Accommodation accommodation : accommodations){
            if(accommodation.getName().equalsIgnoreCase(dname)){
                if(accommodation.isAvailablel()){
                    accommodations.remove(accommodation);
                    result = true;
                    break;
                }else{ // 숙소가 예약 중 이면 삭제 불가
                    result = false;
                    break;
                }
            }
        }
        if(result){
            System.out.println("삭제됨");
        }else{
            System.out.println("삭제 안됨");
        }
    }

    public void updateAccommodation(String uname) {
        int i = 0;
        int index = -1;
        int menu = -1;
        boolean flag = true;
        Scanner sc = new Scanner(System.in);
        Accommodation newA = new Accommodation(); // 비어있는 객체를 생성하려면 기본 생성자 필요
        System.out.println(uname);
        for(Accommodation a : accommodations){ // 리스트를 순회하면서 같은 이름이 있는지 확인
            i++;
            if(a.getName().equals(uname)){
                index = i - 1; // 내가 찾는 이름이 있으면 +1 후 index = i -1  > 0 이 되기 때문에 index값이 -1 이 되지는 않음
                newA = a; // 이름이 같으면 객체를 생성해서 해당 객체를 newA에 넣어 놓는다.
            }
            System.out.println(a.getName().equals(uname) + " " + a.getName() + " " + uname);

        }
        if(index != -1){ // 수정 할 호텔이름이 있으면
            System.out.print("무엇을 수정 하시겠습니까? \n 1.숙박업소 이름 \t 2.지역 \t 3.가격\n >>");
            menu = sc.nextInt();
            sc.nextLine();
            while (flag) {
                switch (menu) {
                    case 1:
                        System.out.println("수정할 이름");
                        newA.setName(sc.nextLine());
                        accommodations.set(index, newA);
                        flag = false;
                        break;
                    case 2:
                        System.out.println("수정할 위치");
                        newA.setLocation(sc.nextLine()); // 위치가 수정된 객체
                        accommodations.set(index, newA); // 리스트에 수정
                        flag = false;
                        break;
                    case 3:
                        System.out.println("수정할 가격");
                        newA.setPricePerNight(sc.nextInt());
                        accommodations.set(index, newA);
                        flag = false;
                        break;
                    default:
                        System.out.println("1~3번 중에 입력하세요");
                        break;
                }
            }
        }


    }

    public void showAccommodation(String sname) {
       for(Accommodation a : accommodations){
        if(a.getName().equalsIgnoreCase(sname)){
            System.out.println(a.toString());
        }
       }
    }


    
}
