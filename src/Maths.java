public class Maths {

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
            "Which well known theorem that the sum of the squares on the legs of a right triangle is equal to the square on the hypotenuse",
            "The sum of the inner angles in any triangle is equal to how many degrees",
            "180 degrees is equal to how many radians?",
            "The PEMDAS acronym is used to help with:",
            "The symbol ∩ is used to express:",
            "The square root of one is equal to:",
            "The value of cos 360° is:",
            "Angle greater than 180 degrees but less than 360 degrees are called?",
            "What is the average of the first 50 natural numbers?",
            "From the product of 9 and 10, subtract 48; then divide the result by 7. What is your final answer?"
    };
    private static  final String[][] answers = {
            // up to 6 answers, first entry is the total number of answers
            {"4", "Godel's Incompleteness", "the Intermediate Value ", "Pythagorean", "Unprovability of choice", "", ""},
            {"4", "360", "180", "90", "420", "", ""},
            {"4", "3.14159", "3.33 repeating", "π", "0.5π", "", ""},
            {"4", "Integrals", "Factorials", "Calculating the angle of a vector", "The order of operations", "", ""},
            {"4", "Intersection", "Union", "Division", "Subset", "", ""},
            {"4", "1", "-1", "0.5", "0", "", ""},
            {"4", "0.5", "1", "0", "π", "", ""},
            {"4", "Accute angle", "Right angle", "Reflex Angle", "Long angle", "", ""},
            {"4", "25", "50", "25.5", "26", "", ""},
            {"4", "5", "6", "7", "8", "", ""},
    };
    private static  final int[][] answersCorrect = {
            // up to 3 possible correct answers expressed as numbers, 1=A 2=B 3=C 4=D
            {3,0,0},
            {2,0,0},
            {1,3,0},
            {4,0,0},
            {1,0,0},
            {1,2,0},
            {2,0,0},
            {3,0,0},
            {3,0,0},
            {2,0,0}
    };
}
