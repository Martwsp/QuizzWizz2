import java.util.ArrayList;
import java.util.Objects;
import java.util.Scanner;

public class Game {
    private int playerDesNoQuestions;
    private int score;

    public int game(String type, int playerDesNoQuestions, int score) {
        if (Objects.equals(type, "Literature")) {
            score = score + literature(playerDesNoQuestions);
        } else if (Objects.equals(type, "Maths")) {
            score = score + maths(playerDesNoQuestions);
        }
        return score;
    }

    public int literature(int playerDesNoQuestions) {
        this.playerDesNoQuestions = playerDesNoQuestions;
        Quiz literatureQuiz = new Quiz("Literature");
        for (int i = 0; i < playerDesNoQuestions; i++) {
            Question question = new Question(Literature.getQuestions(i));
            for (int j = 0; j < Literature.getAnswersTotal(i); j++) {
                Answer answer = new Answer(Literature.getAnswers(i, j), Literature.getAnswerCorrect(i, j));
                question.addAnswer(answer);
            }
            literatureQuiz.addQuestion(question);
        }
        score = literatureQuiz.quiz();
        return score;
    }

    public int maths(int playerDesNoQuestions) {
        this.playerDesNoQuestions = playerDesNoQuestions;
        Quiz mathsQuiz = new Quiz("Maths");
        for (int i = 0; i < playerDesNoQuestions; i++) {
            Question question = new Question(Maths.getQuestions(i));
            for (int j = 0; j < Maths.getAnswersTotal(i); j++) {
                Answer answer = new Answer(Maths.getAnswers(i, j), Maths.getAnswerCorrect(i, j));
                question.addAnswer(answer);
            }
            mathsQuiz.addQuestion(question);
        }
        score = mathsQuiz.quiz();
        return score;
    }

    public String selectSubject(ArrayList<String> alreadyPlayedSubjects) {
        Scanner scanner = new Scanner(System.in);
        String subject;
        while (true) {
            System.out.println("Select the subject of questions:");
            if (alreadyPlayedSubjects.contains("Literature")) {
                System.out.println("A: ---");
            } else {
                System.out.println("A: Literature");
            }

            if (alreadyPlayedSubjects.contains("Maths")) {
                System.out.println("B: ---");
            } else {
                System.out.println("B: Maths");
            }

            try {
                subject = scanner.nextLine();
                if (subject.equalsIgnoreCase("A") && !alreadyPlayedSubjects.contains("Literature")) {
                    subject = "Literature";
                    break;
                } else if (subject.equalsIgnoreCase("B") && !alreadyPlayedSubjects.contains("Maths")) {
                    subject = "Maths";
                    break;
                } else if (subject.equalsIgnoreCase("A") && alreadyPlayedSubjects.contains("Literature")) {
                    subject = "Already done literature";
                } else if (subject.equalsIgnoreCase("B") && alreadyPlayedSubjects.contains("Maths")) {
                    System.out.println("Already done maths");
                } else {
                    System.out.println("Must input single character, either A or B");
                }
            } catch (Exception e) {
                System.out.println("Must input single character, either A or B");
            }
        }
        return subject;
    }

    public int selectLength() {
        Scanner scanner = new Scanner(System.in);
        int length;
        int MAX_QUESTION = 10;
        System.out.println("Select number of questions 5-" + MAX_QUESTION);
        while (true) {
            try {
                length = Integer.parseInt(scanner.nextLine());
                if (length < 5 && length > 0) {
                    length = 5;
                    System.out.println("Minimum length is 5");
                    break;
                } else if (length >= 5 && length <= MAX_QUESTION) {
                    System.out.println("Number of questions: " + length);
                    break;
                } else {
                    System.out.println("Must be a number from 5 to" + MAX_QUESTION);
                }
            } catch (Exception e) {
                System.out.println("Must be a number from 5 to " + MAX_QUESTION);
            }
        }
        return length;
    }

    public String tryAgain() {
        Scanner scanner = new Scanner(System.in);
        String answer;
        while (true) {
            try {
                answer = scanner.nextLine();
                if (Objects.equals(answer.toUpperCase(), "N")) {
                    break;
                } else if (Objects.equals(answer.toUpperCase(), "Y")) {
                    break;
                } else {
                    System.out.println("Type Y to play more, or N to exit");
                }
            } catch (Exception e) {
                System.out.println("Type Y to play more, or N to exit");
            }
        }
        return answer;
    }


}
