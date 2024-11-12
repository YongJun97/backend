package a1112;

public class String3 {
    public static void main(String[] args) {
        String str1 = "" +
		"{\n" +
		"\t\"id\":\"winter\",\n" +
		"\t\"name\":\"눈송이\"\n" +
		"}";
        System.out.println(str1);
        String str2 = """
        {
            "id":"winter",
            "name":"눈송이"
        }
                """;
                // 텍스트 블록 문법
        System.out.println(str1);
        System.out.println("-------------------------------");
        System.out.println(str2);
        System.out.println("-------------------------------");
    
    String str ="""
    
        나는 자바를 \
        학습합니다.
        나는 자바 고수가 될 겁니다.

    
            """;
            System.out.println(str);
            //  \를 쓰면 줄바꿈을 막을 수 있다
    }    
}
