package a1126.Hak3;

public class Main5 extends Object {
                        //   모든 자바는 눈에 보이지는 않지만 Object 라는 클래스를 상속한다. 보통은 Object 생략
    public static void main(String[] args) {
        Person person = new Person("홍길동", 25);
        // System.out.println(person.toString());
        System.out.println(person);
        // 객체 person -> person.toString() 이 생략된 형태
        // toString() 은 Object 에서 상속 받은 메소드 , 객체의 문자열 표현을 정의하는 메소드

        // getter setter가 없어 출력할 수 없다. person이 main 밖에 있기 때문
        // System.out.println(person.toStr());
            }
        }
        class Person {
            

            private String name;
            private int age;
        
            public Person(String name, int age) {
                this.name = name;
                this.age = age;
            }
        
            // public String toStr() {
            //     return String.format("이름: %s, 나이: %d", name, age);
            // }
            @Override                   // 아주중요
            public String toString() {  // class person 클릭 후 전구에서 toString 클릭하면 자동생성
                return "Person [name=" + name + ", age=" + age + "]";
            }
            // toString()을 오버라이드 하면 객체정보를 사람이 읽을 수 있는 형태로 출력할 수 있어
            // 디버깅, 로깅, 출력 등에 매우 유요함
}
