package a1125.bank;

import java.util.Scanner;

public class BankApplication {
    private static Account[] accountArray = new Account[100];
    // 모든 계좌 정보 저장 - 하나의 배열에 저장하므로 새로운 배열을 만들 필요가 없으므로 static을 쓴다
    private static Scanner scanner = new Scanner(System.in);


    public static void main(String[] args) {
        boolean run = true;
        
        while (run) {
            System.out.println("--------------------------------------------------");
            System.out.println("1.계좌생성 | 2.계좌목록 | 3.예금 | 4.출금 | 5.종료");
            System.out.println("--------------------------------------------------");
            System.out.print("선택>");

            int selectNo = Integer.parseInt(scanner.nextLine());
            if(selectNo == 1){
                createAccount();
            }else if(selectNo == 2){
                accountList();
            }else if(selectNo == 3){
                deposit(); // 예금
            }else if(selectNo == 4){
                withdraw();
            }else if(selectNo == 5){
                run = false;
            }
    }
        System.out.println("프로그램 종료");
     }             
                                 
                    
                            
                           
                                     
                            
                                
                    
                
                
                
                
                
                
                
                            // 계좌생성
            private static void createAccount() {
                System.out.println("--------------");
                System.out.println(" 계좌생성 ");
                System.out.println("--------------");
                System.out.print("계좌번호: " );
                String ano = scanner.nextLine();

                System.out.print("계좌주:");
                String owner = scanner.nextLine();

                System.out.println("초기입금액:");
                int balance = Integer.parseInt(scanner.nextLine());

                Account newAccount = new Account(ano, owner, balance);
                for(int i = 0; i < accountArray.length; i++){ // 0번부터 100까지 순회하면서
                    if(accountArray[i] == null){ // 비어있는 방이 있으면
                        accountArray[i] = newAccount;
                        System.out.println("결과 : 계좌가 생성 되었습니다.");
                        break; // 이 for문에서 break의 유무는 상관이 없다 break가 없는 경우에는
                               // 배열에 값이 들어가 null이 값으로 채워지는 순간 배열을 순회 할 필요가 없어지기 때문에 순회를 멈춘다.
                               // 하지만 break를 쓰면 좀 더 안정적인 코딩이 되기 때문에 break의 유무는 이 코드를 작동 시키는데 상관이 없다.
                    }
                }
                // accountArray[0] = newAccount("110-110","홍길동",10000)
                // accountArray[1] = newAccount("110-110","홍길동",10000)
            }        
            private static void accountList() {
                System.out.println("--------------");
                System.out.println(" 계좌목록 ");
                System.out.println("--------------");
                for(int i = 0; i < accountArray.length; i++){
                   Account account = accountArray[i];
                   if(account != null){
                        System.out.print(account.getAno()); // 계좌번호
                        System.out.print("      ");
                        System.out.print(account.getOwner()); // 계좌 주
                        System.out.print("      ");
                        System.out.print(account.getBalance()); // 예금액
                        System.out.println();
                   }
                }
            }
            // 예금하기
            private static void deposit() {
                System.out.println("--------------");
                System.out.println(" 예금 ");
                System.out.println("--------------");
                System.out.print("계좌번호: ");
                String ano = scanner.nextLine();
                System.out.println("예금액: ");
                int money = Integer.parseInt(scanner.nextLine());
                Account account = findAcoount(ano);
                if(account == null){
                    System.out.println("결과 : 없는 계좌 입니다.");
                    return;
                }
                account.setBalance(account.getBalance() + money);
                // 현재 계좌 잔액을 getter로 불러와서 예금액 (money)를 더한 후
                //  setBalance로 더한 금액을 넣기

            }
               
               
               
            private static Account findAcoount(String ano) {
                Account account = null; //비어있는 객체를 만든다.(반환되는 내용을 담아갈객체)
                for(int i = 0; i < accountArray.length; i++){
                    if(accountArray[i] != null){ //배열에 내용이 있으면
                    String dbAno = accountArray[i].getAno();
                    if(dbAno.equals(ano)){
                        account = accountArray[i];
                        break;
                    }
                }
                }
                return account;
            }
            // 출금하기
            private static void withdraw() {
                System.out.println("--------------");
                System.out.println(" 출금 ");
                System.out.println("--------------");
                System.out.print("계좌번호: ");
                String ano = scanner.nextLine();
                System.out.println("출금액: ");
                int money = Integer.parseInt(scanner.nextLine());
                Account account = findAcoount1(ano);
                if(account == null){
                    System.out.println("결과 : 없는 계좌 입니다.");
                    return;
                }
                account.setBalance(account.getBalance() - money);
            }
            private static Account findAcoount1(String ano) {
                Account account = null; //비어있는 객체를 만든다.(반환되는 내용을 담아갈객체)
                for(int i = 0; i < accountArray.length; i++){
                    if(accountArray[i] != null){ //배열에 내용이 있으면
                    String dbAno = accountArray[i].getAno();
                    if(dbAno.equals(ano)){
                        account = accountArray[i];
                        break;
                    }
                }
                }
                return account;
            }
}
