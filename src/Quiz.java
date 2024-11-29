import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Quiz {
    String type;
    List<Question> questions;

    public Quiz(String type) {
        this.type = type;
        this.questions = new ArrayList<>();
    }

    public void addQuestion(Question question) {
        this.questions.add(question);
    }

    public int quiz() {
        int questionNumber = 0;
        int score = 0;

        for (Question question : questions) {
            ArrayList<String> playerAnswers = new ArrayList<>();
            int answerNumber = 1;
            while (answerNumber <= question.getAnswersCorrectTotal()) {
                printQuizQuestion(question, questionNumber);
                printQuizQuestion2(question, answerNumber, playerAnswers);
                int answer = playerAnswer();
                if (playerAnswers.contains(answerToLetter(answer))) {
                    System.out.println("Cannot select the same answer twice");
                } else if (answer > 0 && answer < 5) {
                    if (question.checkAnswers(answer)) {
                        score++;
                    }
                    playerAnswers.add(answerToLetter(answer));
                    answerNumber++;
                }
            }
            questionNumber++;
        }
        return score;
    }

    public int playerAnswer() {
        Scanner scanner = new Scanner(System.in);
        int answer = 0;
        try {
            String answerPlayer = scanner.nextLine();
            if (answerPlayer.equalsIgnoreCase("A")) {
                answer = 1;
            } else if (answerPlayer.equalsIgnoreCase("B")) {
                answer = 2;
            } else if (answerPlayer.equalsIgnoreCase("C")) {
                answer = 3;
            } else if (answerPlayer.equalsIgnoreCase("D")) {
                answer = 4;
            } else {
                System.out.println("Input a single character A, B, C, or D");
            }
        } catch (Exception e) {
            System.out.println("Input a single character A, B, C, or D");
        }
        return answer;
    }

    public String answerToLetter(int i) {
        return switch (i) {
            case 1 -> "A";
            case 2 -> "B";
            case 3 -> "C";
            case 4 -> "D";
            default -> "";
        };
    }

    public void printQuizQuestion(Question question, int questionNumber) {
        int answersCorrectTotal = question.getAnswersCorrectTotal();
        if (answersCorrectTotal == 1) {
            System.out.println("Question number " + (questionNumber + 1) + " ( " + answersCorrectTotal + " point )");
        } else {
            System.out.println("Question number " + (questionNumber + 1) + " ( " + answersCorrectTotal + " points )");
        }
        question.printQuestion();
        question.printAnswer();
    }

    public void printQuizQuestion2(Question question, int answerNumber, ArrayList<String> answers) {
        String wordNumber = "One";
        switch (question.getAnswersCorrectTotal()) {
            case 1 -> wordNumber = "One";
            case 2 -> wordNumber = "Two";
            case 3 -> wordNumber = "Three";
        }
        String wordSequence = "first";
        switch (answerNumber) {
            case 1 -> wordSequence = "first";
            case 2 -> wordSequence = "second";
            case 3 -> wordSequence = "third";
        }

        if (question.getAnswersCorrectTotal() > 1) {
            switch (answers.size()) {
                case 0 -> System.out.println(wordNumber + " " + "correct answers.");
                case 1 -> System.out.println(wordNumber + " " + " correct answers." + " Selected: " + answers.get(0));
                case 2 ->
                        System.out.println(wordNumber + " " + " correct answers." + " Selected: " + answers.get(0) + ", " + answers.get(1));
            }
            System.out.println("Select " + wordSequence + " answer:");
        } else {
            System.out.println(wordNumber + " " + "correct answer.");
            System.out.println("Select answer:");
        }
    }
}
