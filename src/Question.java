import java.util.ArrayList;
import java.util.List;

public class Question {
    private final String question;
    private final List<Answer> answers;
    private int answersTotal;
    private int answersCorrectTotal;

    public Question(String question) {
        this.question = question;
        this.answers = new ArrayList<>();
    }

    public void setAnswersCorrectTotal(int answersCorrectTotal) {
        this.answersCorrectTotal = answersCorrectTotal;
    }

    public int getAnswersCorrectTotal() {
       return this.answersCorrectTotal;
    }

    public void setAnswersTotal(int answersTotal){
        this.answersTotal = answersTotal;
    }

    public void printQuestion(){
        System.out.println(question);
    }

    public void addAnswer(Answer answer){
        this.answers.add(answer);
    }

    public boolean checkAnswers(int answerToNumber){
        for (Answer answer: answers) {
            if (answers.get(answerToNumber-1).isCorrect()){
                return true;
            }
        }
        return false;
    }

    public void printAnswer(){
        int i = 0;
        for (Answer answer: answers) {
            switch (i) {
                case 0:
                    System.out.println("A: " + answer.getAnswer());
                    break;
                case 1:
                    System.out.println("B: " + answer.getAnswer());
                    break;
                case 2:
                    System.out.println("C: " + answer.getAnswer());
                    break;
                case 3:
                    System.out.println("D: " + answer.getAnswer());
                    break;
                case 4:
                    System.out.println("E: " + answer.getAnswer());
                    break;
                case 5:
                    System.out.println("F: " + answer.getAnswer());
                    break;
            }
            i++;
        }
    }
}
