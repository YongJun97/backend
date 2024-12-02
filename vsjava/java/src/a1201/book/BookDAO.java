package a1201.book;

import java.util.ArrayList;
import java.util.Scanner;

public class BookDAO {
    private ArrayList<BookDTO> blist;
    Scanner sc = new Scanner(System.in);
    public BookDAO(){
        blist = new ArrayList<BookDTO>();

        BookDTO b1 = new BookDTO(0,"자바","김자바",2015);
        BookDTO b2 = new BookDTO(0,"리액트","김리액",2016);
        BookDTO b3 = new BookDTO(0,"자바스크립트","김립트",2017);
        BookDTO b4 = new BookDTO(0,"스프링","김프링",2018);
        blist.add(b1);
        blist.add(b2);
        blist.add(b3);
        blist.add(b4);




    }
    public void bookInsert() {
        BookDTO s = new BookDTO();
        s.setId(blist.size());
        System.out.println("<새로운 책 주가하기>");
        System.out.println("제목 : ");
        s.setTitle(sc.next());
        System.out.println("저자 : ");
        s.setAuthor(sc.next());
        System.out.println("출판년도 : ");
        s.setYear(sc.nextInt());
        System.out.println(s+"\n책이 추가 되었습니다.");
    }
    public void bookDelete() {
        System.out.println("<책 정보 삭제>");
        int index = searchIndex();
        if(index == -1){
            System.out.println("찾는 책이 없습니다.");
        }else{
            String title = blist.get(index).getTitle();
            blist.remove(index);
            System.out.println("입력하신 책이 삭제 되었습니다.");
        }
    }
    private int searchIndex() {
        int index = -1;
        System.out.println("책의 제목을 입력 해 주세요");
        System.out.println(">>");
        String title = sc.next();
        for(int i=0; i < blist.size(); i++){
            if(blist.get(i).getTitle().equals(title)){
                index = i;
                break;
            }
        }
        return index;
    }
    
}
