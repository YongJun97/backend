package aa;

public class QuizDTO {
    private String question; // 문제
    private String[] options; // 문제의 보기
    private int correctAnswer; // 문제의 정답 (보기 배열의 인덱스)

    // 기본 생성자
    public QuizDTO() {}

    // 매개변수를 받는 생성자
    public QuizDTO(String question, String[] options, int correctAnswer) {
        this.question = question;
        this.options = options;
        this.correctAnswer = correctAnswer;
    }

    // Getter 및 Setter 메소드
    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public String[] getOptions() {
        return options;
    }

    public void setOptions(String[] options) {
        this.options = options;
    }

    public int getCorrectAnswer() {
        return correctAnswer;
    }

    public void setCorrectAnswer(int correctAnswer) {
        this.correctAnswer = correctAnswer;
    }

    @Override
    public String toString() {
        StringBuilder optionsStr = new StringBuilder();
        for (int i = 0; i < options.length; i++) {
            optionsStr.append(i + 1).append(". ").append(options[i]).append("\n");
        }
        return "QuizDTO [question=" + question + ", options=\n" + optionsStr + ", correctAnswer=" + (correctAnswer + 1) + "]";
    }
}