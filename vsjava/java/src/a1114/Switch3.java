package a1114;

public class Switch3 {
    public static void main(String[] args) {
       char grade = 'A';
    switch(grade){
      case 'A','a'->{
        System.out.println("우수회원입니다");
    }
      case 'B','b'->{
        System.out.println("일반회원 입니다");
    }
    default ->{
        System.out.println("손님 입니다");
    }
      }
    }
    // case 문은 하나 뿐 아니라 여러가지로 선택이 가능
}
