import java.util.Scanner;

public class gpaCalculator {

    public double scoreInput() {

        int numberOfCourses;
        int creditHours;
        double totalGradePoints = 0;

        Scanner input = new Scanner(System.in);

        System.out.println("Enter the number of courses you're offering: ");
        numberOfCourses = input.nextInt();

        int[] scores = new int[numberOfCourses];

        System.out.println("Enter the total credit hours: ");
        creditHours = input.nextInt();

        System.out.println("Enter scores as they appear in your result sheet.");

        for (int i = 0; i < numberOfCourses; i++) {

            System.out.print("Enter score for course " + (i + 1) + ": ");
            double score = input.nextDouble();

            scores[i] = (int) score;

            double gradePoint;

            if (score >= 80)
                gradePoint = 4.0;
            else if (score >= 70)
                gradePoint = 3.0;
            else if (score >= 60)
                gradePoint = 2.0;
            else if (score >= 50)
                gradePoint = 1.0;
            else
                gradePoint = 0.0;

            totalGradePoints += gradePoint * creditHours;
        }

        for (int i = 0; i < numberOfCourses; i++) {
            System.out.println("Score " + (i + 1) + ": " + scores[i]);
        }

        double gpa = totalGradePoints / (creditHours * numberOfCourses);

        System.out.println("GPA = " + gpa);

        return gpa;
    }

    public static void main(String[] args) {
        gpaCalculator calculator = new gpaCalculator();
        calculator.scoreInput();
    }
}