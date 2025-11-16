import java.util.*;

class Question {
    String question;
    String[] options;
    int correctAnswer; // will store 1,2,3,4

    Question(String question, String[] options, int correctAnswer) {
        this.question = question;
        this.options = options;
        this.correctAnswer = correctAnswer;
    }
}

public class QuizApp {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        ArrayList<Question> questions = new ArrayList<>();

        questions.add(new Question(
                "Which language is used for Android Development?",
                new String[]{"1. Java", "2. Python", "3. Swift", "4. C++"},
                1
        ));

        questions.add(new Question(
                "Which keyword is used to inherit a class in Java?",
                new String[]{"1. extends", "2. implements", "3. inherit", "4. super"},
                1
        ));

        questions.add(new Question(
                "Which collection class does NOT allow duplicates?",
                new String[]{"1. List", "2. Set", "3. ArrayList", "4. Map"},
                2
        ));

        questions.add(new Question(
                "Which OOP concept binds data and methods?",
                new String[]{"1. Abstraction", "2. Polymorphism", "3. Encapsulation", "4. Inheritance"},
                3
        ));

        questions.add(new Question(
                "Which method is the entry point in Java?",
                new String[]{"1. start()", "2. run()", "3. init()", "4. main()"},
                4
        ));

        int score = 0;

        System.out.println("===== Welcome to the Online Quiz =====");

        for (int i = 0; i < questions.size(); i++) {
            Question q = questions.get(i);

            System.out.println("\nQ" + (i + 1) + ". " + q.question);
            for (String opt : q.options) {
                System.out.println(opt);
            }

            System.out.print("Your answer: ");
            String ansInput = sc.next(); // user may enter 1 or Java

            boolean correct = false;

            // 1️⃣ If user enters number (1/2/3/4)
            try {
                int ansNum = Integer.parseInt(ansInput);
                if (ansNum == q.correctAnswer) correct = true;
            }
            catch (NumberFormatException e) {
                // 2️⃣ If user enters text (Java/Python/etc.)
                String correctText = q.options[q.correctAnswer - 1]
                        .substring(3) // remove "1. "
                        .trim()
                        .toLowerCase();

                if (ansInput.toLowerCase().equals(correctText)) {
                    correct = true;
                }
            }

            if (correct) score++;
        }

        System.out.println("\n===== Quiz Finished =====");
        System.out.println("Your Score: " + score + "/" + questions.size());
    }
}
