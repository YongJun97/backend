package a1126.Doseo;

public class LibaryEx {
    public static void main(String[] args) {
        EBook eBook = new EBook("이것이 자바다", "신용권", "2015-0123", 500, "ㅁㅁ");
        PrintedBook printedBook = new PrintedBook("첨만난 리액트", "이인제", "2016-0124", 464, 0.8);


        System.out.println("EBook Information:");
        eBook.displayInfo();
        System.out.println();
        System.out.println("Printed Book Information");
        printedBook.displayInfo();



    }
}
