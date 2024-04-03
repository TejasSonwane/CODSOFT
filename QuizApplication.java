import java.util.Scanner;

public class QuizApplication {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Quiz Questions, Options, and Answers
        String[] questions = {
                "What is the capital of India?",
                "Which planet is known as the Red Planet?",
                "Whhich is national bird of India?",
                "What is the chemical symbol for oxygen?"
        };

        String[][] options = {
                { "A) delhi", "B) mumbai", "C) kolhapur", "D) pune" },
                { "A) Jupiter", "B) Mars", "C) Venus", "D) Saturn" },
                { "A) sparrow", "B) peacock", "C) parrot", "D) duck" },
                { "A) H2O", "B) CO2", "C) NaCl", "D) O2" }
        };

        char[] answers = { 'A', 'B', 'B', 'D' };

        // Timer for each question (in seconds)
        int[] timers = { 5, 5, 5, 5 };

        // User's score
        int score = 0;

        // Quiz starts
        System.out.println("Welcome to the Quiz Application!");

        for (int i = 0; i < questions.length; i++) {
            System.out.println("\nQuestion " + (i + 1) + ": " + questions[i]);
            for (String option : options[i]) {
                System.out.println(option);
            }

            // Start timer
            int timeLeft = timers[i];
            while (timeLeft > 0) {
                System.out.println("Time left: " + timeLeft + " seconds");
                try {
                    Thread.sleep(1000); // Wait for 1 second
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                timeLeft--;
            }

            // Get user's answer
            System.out.print("Your answer: ");
            char userAnswer = Character.toUpperCase(scanner.next().charAt(0));

            // Check if the answer is correct
            if (userAnswer == answers[i]) {
                System.out.println("Correct!");
                score++;
            } else {
                System.out.println("Incorrect! The correct answer is " + answers[i]);
            }
        }

        // Display final score
        System.out.println("\nQuiz completed!");
        System.out.println("Your final score is: " + score + "/" + questions.length);

        scanner.close();
    }
}