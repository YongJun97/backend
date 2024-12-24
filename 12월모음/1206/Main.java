package mini.chelsea;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Team chelsea = new Team();
        ChelseaNews news = new ChelseaNews();
        TicketPurchase ticketPurchase = new TicketPurchase();
        Scanner scanner = new Scanner(System.in);
        boolean running = true;

        while (running) {
            System.out.println("\n1. 선수 명단보기\n2. 선수 스텟 보기\n3. 선수 입력 (등번호, 포지션)\n4. 선수 삭제\n5. Chelsea News\n6. 티켓 구매\n7. 종료");
            System.out.print("선택: ");
            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    chelsea.listPlayers();
                    break;
                case 2:
                    chelsea.showPlayerStats();
                    break;
                case 3:
                    System.out.print("번호: ");
                    int number = scanner.nextInt();
                    scanner.nextLine(); // buffer clear
                    System.out.print("포지션: ");
                    String position = scanner.nextLine();
                    System.out.print("이름: ");
                    String name = scanner.nextLine();
                    System.out.print("슛: ");
                    int shoot = scanner.nextInt();
                    System.out.print("슛 정확도: ");
                    int shootAccuracy = scanner.nextInt();
                    System.out.print("패스: ");
                    int pass = scanner.nextInt();
                    System.out.print("패스 정확도: ");
                    int passAccuracy = scanner.nextInt();
                    chelsea.addPlayer(number, position, name, shoot, shootAccuracy, pass, passAccuracy);
                    break;
                case 4:
                    System.out.print("삭제할 선수: ");
                    int id = scanner.nextInt();
                    chelsea.removePlayer(id);
                    break;
                case 5:
                    news.showNews();
                    break;
                case 6:
                    ticketPurchase.purchaseTicket();
                    break;
                case 7:
                    running = false;
                    break;
                default:
                    System.out.println("잘못 선택했습니다.");
            }
        }
        scanner.close();
    }
}
