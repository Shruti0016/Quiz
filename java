import java.util.*;

class Quiz {
    private Map<String, String> questions;
    private Map<String, String> options;
    private Map<String, String> answers;
    private int totalTime; // in seconds
    private int score;

    public Quiz() {
        questions = new HashMap<>();
        options = new HashMap<>();
        answers = new HashMap<>();
        totalTime = 60; // Default time for each question
        score = 0;
    }

    public void addQuestion(String question, String[] options, String correctAnswer) {
        String questionId = "Q" + (questions.size() + 1);
        this.questions.put(questionId, question);
        StringBuilder optionsString = new StringBuilder();
        for (int i = 0; i < options.length; i++) {
            optionsString.append((char) ('A' + i)).append(". ").append(options[i]).append("  ");
        }
        this.options.put(questionId, optionsString.toString());
        this.answers.put(questionId, correctAnswer.toUpperCase());
    }
    public void setTotalTime(int totalTime) {
        this.totalTime = totalTime;
    }

    public void startQuiz() {
        Scanner scanner = new Scanner(System.in);
        for (String questionId : questions.keySet()) {
            System.out.println("Question: " + questions.get(questionId));
            System.out.println("Options: " + options.get(questionId));
            System.out.print("Your answer (A/B/C/D): ");
            String userAnswer = scanner.nextLine().toUpperCase();
            if (userAnswer.equals(answers.get(questionId))) {
                System.out.println("Correct!");
                score++;
            } else {
                System.out.println("Incorrect!");
            }
            try {
                Thread.sleep(totalTime * 1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println("Quiz ended.");
        System.out.println("Your score: " + score + "/" + questions.size());
    }
}
public class ATM {
    public static void main(String[] args) {
        Quiz quiz = new Quiz();
        quiz.addQuestion(" \r\n"
        		+ "Number of primitive data types in Java are?", new String[]{"6", "7", "8", "9"}, "C");
        quiz.addQuestion(" \r\n"
        		+ "What is the size of float and double in java?\r\n"
        		
        		+ "", new String[]{"32 and 64", "42 and 44", "55 ans 32", "23 and 44"}, "A");
        // Add more questions...

        quiz.setTotalTime(10); // Set total time for each question

        quiz.startQuiz();
    }
}
