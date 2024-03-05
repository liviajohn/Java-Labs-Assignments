//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
import java.util.ArrayList;
import java.util.Scanner;
class Question {
    private String ques;
    private String ans;
    private int diff;

    Question(String question, String answer, int difficulty) {
        ques = question;
        ans = answer;
        diff = difficulty;
    }

    //getters
    public String getQues() {
        return ques;
    }

    public String getAns() {
        return ans;
    }

    public int getDiff() {
        return diff;
    }

//setters
    public void setQues(String ques1) {
        ques = ques1;
    }

    public void setAns(String ans1) {
        ans = ans1;
    }

    public void setDiff(int diff1) {
        diff = diff1;
    }
}

class Quiz{

    ArrayList<Question> quesList = new ArrayList<>();
    public void add_question() {
        Scanner sc = new Scanner (System.in);


        System.out.println("What is the question text?");
        String newQuestion= sc.nextLine();

        System.out.println("What is the answer?");
        String newAnswer = sc.nextLine();

        System.out.println("How difficult? (1-3)");
        int newDifficulty = sc.nextInt();
        sc.nextLine();

        Question addQuestion = new Question(newQuestion, newAnswer, newDifficulty);
        quesList.add(addQuestion);
    }

    public void remove_question() {
        Scanner sc = new Scanner (System.in);

        System.out.println("Which question number would you like to remove?");
        for (int i = 0; i < quesList.size(); i++) {
            System.out.println(i + ". " + quesList.get(i).getQues());
        }

        int removeQuestion = sc.nextInt();
        sc.nextLine();

        if (removeQuestion >= 0 && removeQuestion < quesList.size()) {
            quesList.remove(removeQuestion);
            System.out.println("Question removed successfully.");
        } else {
            System.out.println("Invalid question number.");
        }
    }

    public void modify_question() {
        Scanner sc = new Scanner (System.in);

        System.out.println("Which question number would you like to modify?");
        for (int i = 0; i < quesList.size(); i++) {
            System.out.println(i + ". " + quesList.get(i).getQues());
        }
        int modifyQuestion = sc.nextInt();
        sc.nextLine();

        if (modifyQuestion >= 0 && modifyQuestion < quesList.size()) {

        System.out.println("What is the new question text?");
        String newQuestion= sc.nextLine();

        System.out.println("What is the new answer?");
        String newAnswer = sc.nextLine();

        System.out.println("What is the new difficulty? (1-3)");
        int newDifficulty = sc.nextInt();
        sc.nextLine();

            Question updatedQuestion = new Question(newQuestion, newAnswer, newDifficulty);
            quesList.set(modifyQuestion, updatedQuestion);
            System.out.println("Question modified successfully.");
        } else {
            System.out.println("Invalid question number.");
        }
    }

    public void give_quiz() {
        Scanner sc = new Scanner(System.in);
        int correctAnswers = 0;

        for (Question question : quesList) {
            System.out.println(question.getQues());
            String userAnswer = sc.nextLine();

            if (userAnswer.equalsIgnoreCase(question.getAns())) {
                System.out.println("Correct");
                correctAnswers++;
            } else {
                System.out.println("Incorrect");
            }
        }

        System.out.println("You got " + correctAnswers + " out of " + quesList.size());
    }
}


public class Main {
    public static void main(String[] args) {
        Quiz quiz = new Quiz();
        Scanner sc = new Scanner(System.in);

        while (true) {
        System.out.println("1. Add a question to the quiz\n2. Remove a question from the quiz \n3. Modify a question in the quiz\n4. Take the quiz\n5. Quit");
        int choice = sc.nextInt();
        sc.nextLine();  // Consume the newline character

        switch (choice) {
            case 1:
                quiz.add_question();
                break;
            case 2:
                quiz.remove_question();
                break;
            case 3:
                quiz.modify_question();
                break;
            case 4:
                quiz.give_quiz();
                break;
            case 5:
                System.out.println("Done");
                System.exit(0);
            default:
                System.out.println("Invalid choice. Please select a valid option.");
        }
    }
}}