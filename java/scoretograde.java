import java.util.Scanner;

public class scoretograde {

    public static void main(String[] args) {
        String grade = "";
        int PercentScore;

        Scanner input = new Scanner(System.in);
        System.out.println("Please enter your percent score: ");
        PercentScore = input.nextInt();

        if (PercentScore < 0 || PercentScore > 100) {
            System.out.println("Invalid Score!");
        } else if (PercentScore >= 80) {
            grade = "A";
        } else if (PercentScore >= 70) {
            grade = "B";
        } else if (PercentScore >= 60) {
            grade = "C" ;
        } else if (PercentScore >= 50) {
            grade = "D";
        } else if (PercentScore  >= 40) {
            grade = "E";
        } else {
            grade = "F";
        }

        System.out.println("Percent Score: " + PercentScore + "%");
        System.out.println("Grade: " + grade);
    }
}