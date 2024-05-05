import java.util.ArrayList;
import java.util.Scanner;

class Question{
    private String question;
    private String answer;
    private int difficulty;

    public Question(String question, String answer, int difficulty){
        this.question = question;
        this.answer = answer;
        this.difficulty = difficulty;
    }

    public String getQuestion(){
        return question;
    }
    public String getAnswer(){
        return answer;
    }
    public int getDifficulty(){
        return difficulty;
    }

    public void setQuestion(String ques){
        question = ques;
    }

    public void setAnswer(String ans){
        answer = ans;
    }

    public void setDifficulty(int diff){
        difficulty = diff;
    }

}

class Quiz {
    ArrayList<Question> questionList = new ArrayList<>();

    public void add_question() {
        Scanner sc = new Scanner(System.in);
        System.out.println("What is the question you would like to add?");
        String newQues = sc.nextLine();
        System.out.println("What is the answer to the question?");
        String newAns = sc.nextLine();
        System.out.println("What is the level of difficulty? (1-3)");
        int newDiff = sc.nextInt();

        Question newQuestion = new Question(newQues, newAns, newDiff);
        questionList.add(newQuestion);

    }

    public void remove_question() {
        int i = 0;
        Scanner sc = new Scanner(System.in);

        for (Question question : questionList){
            System.out.println(i +". " + question.getQuestion());
            i++;
        }

        System.out.println("Which question would you like to remove?");
        int removeQuestion = sc.nextInt();
        if (removeQuestion < questionList.size() && removeQuestion >= 0) {
            questionList.remove(removeQuestion);
        } else {
            System.out.println("That is an invalid choice");
        }
    }

    public void modify_question() {
        int i = 0;
        Scanner sc = new Scanner(System.in);
        for (Question question: questionList){
            System.out.println(i + ". " + question.getQuestion());
            i++;
        }

        System.out.println("Which question number would you like to modify?");
        int modifyQuestion = sc.nextInt();
        sc.nextLine();

        if (modifyQuestion < questionList.size() && modifyQuestion >= 0) {
            System.out.println("What is the new question text?");
            String modQues = sc.nextLine();
            System.out.println("What is the new answer text?");
            String modAns = sc.nextLine();
            System.out.println("What is the new level of difficulty?");
            int modDiff = sc.nextInt();

            Question modifiedQuestion = new Question(modQues, modAns, modDiff);
            questionList.set(modifyQuestion, modifiedQuestion);
            System.out.println("Question modified successfully");
        } else {
            System.out.println("Invalid question number.");
        }
    }

    public void give_quiz() {
        int points = 0;
        int i =0;
        Scanner sc = new Scanner(System.in);
        for (Question question : questionList) {
            System.out.println(i + ". " + question.getQuestion());
            String userAnswer = sc.nextLine();
            i++;

            if (userAnswer.equalsIgnoreCase(question.getAnswer())) {
                System.out.println("That is correct!");
                points++;
            } else {
                System.out.println("That is incorrect.");
            }
        }
        System.out.println("You correctly answered " + points + " out of " + questionList.size() + " questions.");
    }

}

public class Main{
    public static void main (String[] args){
        Quiz quiz = new Quiz();
        int choice = 0;

        do{
            Scanner sc = new Scanner (System.in);
            System.out.println("What would you like to do?");
            System.out.println("1. Add a question to the quiz.");
            System.out.println("2. Remove a question from the quiz.");
            System.out.println("3. Modify a question in the quiz.");
            System.out.println("4. Take the quiz.");
            System.out.println("5. Quit");

            choice = sc.nextInt();

            switch(choice){
                case 1: //add question
                    quiz.add_question();
                    break;
                case 2: //remove question
                    quiz.remove_question();
                    break;
                case 3: //modify question
                    quiz.modify_question();
                    break;
                case 4: //take quiz
                    quiz.give_quiz();
                    break;
                case 5: //quit
                    System.out.println("Shutting down...");
                    break;
                default:
                    System.out.println("Invalid number.");
                    break;
            }

        } while(choice != 5);
    }
}



