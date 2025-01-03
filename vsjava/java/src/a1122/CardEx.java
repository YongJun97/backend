package a1122;

public class CardEx {
    public static void main(String[] args) {

        System.out.println("카드의 넓이: " + Card.width);
        System.out.println("카드의 높이: " + Card.height);
        // 클래스변수 (static변수) 는 객체 생성 없이
        // '클래스이름.클래스변수' 로 직접 사용 가능
        // 이 방식으로 접근하는게 좋음



        Card c1 = new Card();
        c1.kind = "heart"; // 인스턴스 변수의 값을 변경
        c1.number = 7;

        Card c2 = new Card();
        c2.kind = "spade";
        c2.number = 4;
        
        System.out.println("c1은"+ c1.kind + "모양이다.");
        System.out.println("c1은"+ c1.number + "숫자이다.");
        System.out.println("c1은"+ c1.width + "넓이이다.");
        System.out.println("c1은"+ c1.height + "높이이다.");
                                    //  노란줄은 추천하지 않는 방법 이라는 뜻(주소에 접근 방법이 좋지 않음, 혼선발생 위험)
        System.out.println("c2은"+ c2.kind + "모양이다.");
        System.out.println("c2은"+ c2.number + "숫자이다.");
        System.out.println("c2은"+ c2.width + "넓이이다.");
        System.out.println("c2은"+ c2.height + "높이이다.");

        // c1.width = 50; 를 썼을때 width는 같은 공간을 쓰고 있기 때문에 밑의 c1.width 와 c2.width는 넓이가 50으로 바뀐다 

        // System.out.println("c1은"+ c1.kind + "모양이다.");
        // System.out.println("c1은"+ c1.number + "숫자이다.");
        // System.out.println("c1은"+ c1.width + "넓이이다.");
        // System.out.println("c1은"+ c1.height + "높이이다.");

        // System.out.println("c2은"+ c2.kind + "모양이다.");
        // System.out.println("c2은"+ c2.number + "숫자이다.");
        // System.out.println("c2은"+ c2.width + "넓이이다.");
        // System.out.println("c2은"+ c2.height + "높이이다.");
    }
}
class Card{
    String kind;
    int number;
    static int width = 100; // 클래스 변수(static 변수 - 정적변수)
    static int height = 250; // 
}
// Card의 인스턴스인 c1과 c2는 클래스(static) 변수인 width, height를 공유하기 때문에
// c1의 width, height를 변경하면 c2의 width , height 값도 바뀐것과 같은 결과를 얻는다.
// Card.width, c1.width, c2.width는 모두 같은 저장공간을 참조하므로 항상 같은 값이다.