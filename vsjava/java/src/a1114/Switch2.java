package a1114;

public class Switch2 {
    public static void main(String[] args) {
       char grade = 'A';
    switch(grade){
      case 'A':
      case 'a':
        System.out.println("우수회원입니다");
        break;
      case 'B':
      case 'b':
        System.out.println("일반회원 입니다");
        break;
      default:
        System.out.println("손님 입니다");
      }
    }
    // case 문은 하나 뿐 아니라 여러가지로 선택이 가능
}
