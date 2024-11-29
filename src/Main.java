import java.util.ArrayList;
import java.util.Objects;

public class Main {
    public static void main(String[] args) {
        int score = 0;
        System.out.println("Welcome to QuizWizz");
        ArrayList<String> alreadyPlayedSubjects = new ArrayList<>();
        while (true) {
            Game game = new Game();
            String type = game.selectSubject(alreadyPlayedSubjects);
            alreadyPlayedSubjects.add(type);
            int playerDesNoQuestions = game.selectLength();
            score = score + game.game(type ,playerDesNoQuestions, score);
            if (alreadyPlayedSubjects.size() == 2){
                break;
            }
            System.out.println("Your score: " + score);
            System.out.println("play more? Y/N");
            if (Objects.equals(game.tryAgain().toUpperCase(), "N")) {
                break;
            }
        }

        System.out.println("Thank you for playing");
        System.out.println("Final score: " + score);
    }
}