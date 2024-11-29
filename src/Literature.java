public class Literature {

    static public String getQuestions(int i) {
        return questions[i];
    }

    public static String getAnswers(int i, int j) {
        return answers[i][j+1];
    }

    public static int getAnswersCorrect(int i) {
        if (answersCorrect[i][2] > 0) {
            return 3;
        } else if ((answersCorrect[i][1] > 0)) {
            return 2;
        } else {
            return 1;
        }
    }

    public static boolean getAnswerCorrect(int i, int j){
        int n = 0;
        while (n < 3) {
            if (j == 0 && answersCorrect[i][n] == 1) {
                return true;
            } else if (j == 1 && answersCorrect[i][n] == 2) {
                return true;
            } else if (j == 2 && answersCorrect[i][n] == 3) {
                return true;
            } else if (j == 3 && answersCorrect[i][n] == 4) {
                return true;
            } else {
                n++;
            }
        }
        return false;
    }

    public static int getAnswersTotal(int i){
        return Integer.parseInt(answers[i][0]);
    }


    private static  final String[] questions = {
            "Mark Twain wrote about which of these characters?",
            "This character says, \"Please, sir, I want some more.\" Who is it?",
            "Who was the main character in J.D. Salinger's \"Catcher in the Rye\"?",
            "J. R. R. Tolkien's written work includes:",
            "George R. R. Martin's game of the thrones contains the following books:",
            "Where did the story \"White Fang\" take place?",
            "Who wrote \"To Kill a Mockingbird\"?",
            "George Orwell wrote which books?",
            "Stephen King bibliography includes:",
            "This man wrote \"Carrie\" and \"Cujo\" along with many other scary novels. What is his name?"
    };
    private static  final String[][] answers = {
            // up to 6 answers, first entry is the total number of answers
            {"4", "Tom Sawyer", "Red Riding Hood", "Little Boy Blue", "Dennis the Menace", "", ""},
            {"4", "Atticus Finch", "Oliver Twist", "Darth Vader", "Pluto", "", ""},
            {"4", "Huckleberry Finn", "Bart Simpson", "Holden Caulfield", "Clark Kent", "", ""},
            {"4", "Song of ice and fire", "The Hobbit", "The dragon under a hill", "The Silmarillion", "", ""},
            {"4", "A Dance with Dragons", "The Winds of Winter", "Song of dragons and fire", "The crow's ballad", "", ""},
            {"4", "Yukon Territory", "Italy", "Antarctica", "Las Vegas", "", ""},
            {"4", "John Lennon", "Dr. Seuss", "Harper Lee", "Ronald Reagan", "", ""},
            {"4", "Animal farm", "Nineteen Eighty-four", "The lord of the flies", "The Road to Wigan Pier", "", ""},
            {"4", "Roadside picnic", "It", "The Green Mile", "Doctor sleep", "", ""},
            {"4", "Charles Dickens", "Ernest Hemingway", "William Faulkner", "Stephen King", "", ""},
    };
    private static  final int[][] answersCorrect = {
            // up to 3 possible correct answers expressed as numbers, 1=A 2=B 3=C 4=D
            {1,0,0},
            {2,0,0},
            {3,0,0},
            {2,4,0},
            {1,2,0},
            {1,0,0},
            {3,0,0},
            {1,2,4},
            {2,3,4},
            {4,0,0}
    };
}
