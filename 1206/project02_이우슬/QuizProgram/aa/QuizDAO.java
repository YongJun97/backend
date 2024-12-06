package aa;

import java.util.ArrayList;
import java.util.List;

public class QuizDAO {

    private List<QuizDTO> questions;
    private int currentQuestionIndex = 0;

    public QuizDAO() {
        // 문제와 보기를 초기화합니다.
        questions = new ArrayList<>();
        questions.add(new QuizDTO(
            "**문제 1번: 자바 언어에서 지원되는 기초 자료형에 포함되지 않는 것은?**",
            new String[]{"int", "char", "String", "float\n"},
            3
        ));
        questions.add(new QuizDTO(
            "**문제 2번: 논리연산자 '||'은 무슨 연산인가?**",
            new String[]{"OR", "NOR", "AND", "NAND"},
            1
        ));
        questions.add(new QuizDTO(
            "**문제 3번: 자바에서 문자를 입력받기 위해 사용하는 클래스는 무엇인가?**",
            new String[]{"Random", "Scanner", "Date", "Calendar"},
            2
        ));
        questions.add(new QuizDTO(
            "**문제 4번: 클래스로부터 만들어지는 객체를 무엇이라고 하는가?**",
            new String[]{"청사진", "생성자", "키워드", "인스턴스"},
            4
        ));
        questions.add(new QuizDTO(
            "**문제 5번: Java에서 String을 비교할 때 사용하는 메소드는 무엇인가?**",
            new String[]{"equals()", "compareTo()", "==", "equalsIgnoreCase()"},
            1
        ));
        questions.add(new QuizDTO(
            "**문제 6번: Java에서 배열의 길이를 구하는 방법은 무엇인가?**",
            new String[]{"array.length()", "array.size()", "array.length", "array.getLength()"},
            3
        ));
        questions.add(new QuizDTO(
            "**문제 7번: Java에서 ArrayList를 생성하려면 어떤 클래스를 사용해야 하는가?**",
            new String[]{"java.util.ArrayList", "java.util.List", "java.util.LinkedList", "java.util.Vector"},
            1
        ));
        questions.add(new QuizDTO(
            "**문제 8번: Java에서 다형성을 구현하기 위해 사용하는 키워드는 무엇인가?**",
            new String[]{"extends", "implements", "super", "this"},
            2
        ));
    }

    public QuizDTO getNextQuestion() {
        if (currentQuestionIndex < questions.size()) {
            return questions.get(currentQuestionIndex++);
        }
        return null; // 모든 문제를 푼 경우 null 반환
    }

    public boolean checkAnswer(int answerIndex) {
        if (currentQuestionIndex == 0) return false; // 문제를 아직 시작하지 않은 경우
        return questions.get(currentQuestionIndex - 1).getCorrectAnswer() == answerIndex;
    }

    public void reset() {
        currentQuestionIndex = 0; // 문제 인덱스를 0으로 리셋하여 문제를 처음부터 다시 제공
    }
}
