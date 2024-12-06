package Book;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Scanner;

public class InputTest implements Serializable {

	public static void main(String[] args) {
		ObjectInputStream in = null;
		ObjectOutputStream out = null;
		try {
			ArrayList<Book> bookList = null;
			try {
				in = new ObjectInputStream(new FileInputStream("data.bin"));
				bookList = (ArrayList<Book>) in.readObject();
			} catch (IOException e) {
				bookList = new ArrayList<Book>();
			}
			int num;

			do {
				Scanner scan = new Scanner(System.in);

				System.out.println("-----------------");
				System.out.println("번호를 입력하세요");
				System.out.println("-----------------");
				System.out.println("1.도서추가      ");
				System.out.println("2.도서삭제      ");
				System.out.println("3.도서조회      ");
				System.out.println("4.도서대여      ");
				System.out.println("5.도서반납      ");
				System.out.println("6.종료          ");
				System.out.println("-----------------");

				num = scan.nextInt();
				scan.nextLine();
				switch (num) {

				case 1:
					System.out.println("id 입력");
					int id = scan.nextInt();
					scan.nextLine();

					System.out.println("책 이름 입력");
					String name = scan.nextLine();

					System.out.println("저자 입력");
					String author = scan.nextLine();

					System.out.println("1.소설책 2.과학책 3.시");
					int category = scan.nextInt();
					scan.nextLine();

					Book b;

					switch (category) {
					case 1:
						b = new Novel();
						b.setId(id);
						b.setName(name);
						b.setAuthor(author);
						bookList.add(b);
						break;

					case 2:
						b = new ScienceFiction();
						b.setId(id);
						b.setName(name);
						b.setAuthor(author);
						bookList.add(b);
						break;

					case 3:
						b = new Poet();
						b.setId(id);
						b.setName(name);
						b.setAuthor(author);
						bookList.add(b);
						break;
					}
					System.out.println("저장되었습니다");

					break;

				case 2:

					System.out.println("삭제할 책의 id를 입력하세요");
					int s = scan.nextInt();
					for (int i = 0; i < bookList.size(); i++) {
						if (s == bookList.get(i).getId())
							bookList.remove(i);
					}
					System.out.println("삭제 되었습니다.");
					break;

				case 3:

					for (Book bo : bookList)
						System.out.println(bo);
					break;

				case 4:

					System.out.println("대여할 책 아이디를 입력하세요");
					int q = scan.nextInt();
					scan.nextLine();
					boolean isExist = false;

					for (int i = 0; i < bookList.size(); i++) {
						if (q == bookList.get(i).getId())
							if (bookList.get(i).isRental()) {
								System.out.println("이미 대여중입니다");
							} else if ((!bookList.get(i).isRental())) {
								System.out.println("정상적으로 대여 되었습니다");
								bookList.get(i).setRental(true);
							}
					}
					// if (!isExist)
					// System.out.println("해당 도서가 존재하지 않습니다");
					break;

				case 5:

					System.out.println("반납할 책 아이디를 입력하세요");
					int w = scan.nextInt();
					scan.nextLine();
					boolean isExist2 = false;

					for (int i = 0; i < bookList.size(); i++) {
						if (w == bookList.get(i).getId())
							if (!bookList.get(i).isRental()) {
								System.out.println("대여중이 아닙니다");
							} else if (bookList.get(i).isRental()) {
								System.out.println("정상적으로 반납 되었습니다");
								bookList.get(i).setRental(false);
								System.out.println("연체료 :" + bookList.get(i).getLateFees(3));
							}

					}
					// if (!isExist2)
					// System.out.println("해당 도서가 존재하지 않습니다");
					break;

				case 6:
					out = new ObjectOutputStream(new FileOutputStream("data.bin"));
					out.writeObject(bookList);
					out.flush();
					System.exit(1);
					break;
				}
			} while (num != 6);

		} catch (IOException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {

		} finally {
			try {
				if (out != null)

					out.close();
				if (in != null)
					in.close();
			} catch (IOException e) {

			}
		}
	}
}
