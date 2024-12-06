package aa;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class QuizMain {

    private static final String FILE_PATH = "quiz_results.csv";

    public static void main(String[] args) {
        QuizDAO quizDAO = new QuizDAO();
        Scanner sc = new Scanner(System.in);
        List<QuizResult> results = loadResultsFromFile(); // 파일에서 기존 결과 불러오기

        while (true) {
            System.out.println("==========퀴즈 프로그램에 오신걸 환영합니다==========");
            System.out.println("1. 퀴즈 풀기");
            System.out.println("2. 정답 순위 확인");
            System.out.println("0. 종료");
            System.out.print("번호 입력> ");
            int choice;

            try {
                choice = sc.nextInt();
                System.out.println();
                sc.nextLine();  // 다음 줄을 읽기 위해 호출
            } catch (Exception e) {
                System.out.println("잘못된 입력입니다. 정수를 입력해주세요.");
                sc.next(); // 잘못된 입력을 처리하기 위해 스캐너를 리셋합니다.
                continue;
            }

            if (choice == 1) {
                System.out.print("사용자의 이름을 입력하세요: ");
                String name = sc.nextLine();
                System.out.println();
                System.out.println(name + "님, 문제를 시작합니다!\n");

                quizDAO.reset(); // 문제 상태를 리셋하여 새로운 사용자가 처음부터 퀴즈 시작

                QuizDTO questionDTO;
                int score = 0;

                while ((questionDTO = quizDAO.getNextQuestion()) != null) {
                    // 문제 출력
                    System.out.println(questionDTO.getQuestion());

                    // 보기 출력
                    String[] options = questionDTO.getOptions();
                    if (options.length == 0) {
                        System.out.println("보기가 없습니다.");
                        continue;
                    }
                    for (int i = 0; i < options.length; i++) {
                        System.out.println((i + 1) + ". " + options[i]);
                    }

                    System.out.println();
                    System.out.print("정답을 입력하세요 (1-" + options.length + "): ");
                    int answer;
                    try {
                        answer = sc.nextInt();
                        System.out.println();
                        sc.nextLine(); // 다음 줄을 읽기 위해 호출
                    } catch (Exception e) {
                        System.out.println("잘못된 입력입니다. 숫자를 입력해주세요.");
                        sc.next(); // 잘못된 입력을 처리하기 위해 스캐너를 리셋합니다.
                        continue;
                    }

                    if (answer < 1 || answer > options.length) {
                        System.out.println("유효한 범위의 숫자를 입력해주세요.");
                        continue;
                    }

                    // 정답 체크
                    if (quizDAO.checkAnswer(answer)) {
                        System.out.println("정답입니다!\n");
                        score++;
                    } else {
                        System.out.println("틀렸습니다.\n");
                    }
                }

                // 결과 저장
                QuizResult result = new QuizResult(name, score);
                results.add(result);
                saveResultsToFile(results); // 파일에 결과 저장
                System.out.println("퀴즈가 모두 끝났습니다! 총 정답 개수: " + score + "\n\n");

            } else if (choice == 2) {
                // 정답 순위 확인
                results.sort((r1, r2) -> Integer.compare(r2.getScore(), r1.getScore())); // 점수 내림차순 정렬
                System.out.println("==========정답 순위==========");

                int rank = 1;
                for (QuizResult result : results) {
                    System.out.println("현재 " + rank + "등: " + result.getName() + " (" + result.getScore() + "정답)");
                    rank++;
                }
            } else if (choice == 0) {
                System.out.println("종료합니다.");
                sc.close();
                System.exit(0);
            } else {
                System.out.println("번호를 잘못 입력했습니다.");
            }
        }
    }

    private static void saveResultsToFile(List<QuizResult> results) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(FILE_PATH))) {
            for (QuizResult result : results) {
                writer.write(result.toCSV());
                writer.newLine();
            }
        } catch (IOException e) {
            System.out.println("결과를 파일에 저장하는 데 오류가 발생했습니다.");
            e.printStackTrace();
        }
    }

    private static List<QuizResult> loadResultsFromFile() {
        List<QuizResult> results = new ArrayList<>();
        File file = new File(FILE_PATH);
        if (!file.exists()) {
            return results;
        }

        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
            String line;
            while ((line = reader.readLine()) != null) {
                results.add(QuizResult.fromCSV(line));
            }
        } catch (IOException e) {
            System.out.println("파일에서 결과를 읽는 데 오류가 발생했습니다.");
            e.printStackTrace();
        }
        return results;
    }
}
