package a1201.book;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        BookDAO test = new BookDAO();
        Scanner sc = new Scanner(System.in);

        while (true) {
            System.out.println("1. 책 정보 입력");
            System.out.println("2. 책 정보 삭제");
            System.out.println("3. 책 정보 검색");
            System.out.println("4. 책 정보 수정");
            System.out.println("5. 책 목록 보기");
            System.out.println("0. 종료");
            System.out.println(">>");
            int choice;
            try{
                choice = sc.nextInt();
            }catch(Exception e){
                choice = -1;
            }

            if(choice == 1){
                test.bookInsert();
            }else if(choice==2){
                test.bookDelete();
            // }else if(choice==3){
            //     test.bookSelect();
            // }else if(choice==4){
            //     test.bookUpdate();
            // }else if(choice==5){
            //     test.printAll();
            }else if(choice == 0){
                System.out.println("종료합니다.");
                sc.close();
                System.exit(0);
            }
        }


    }
}
