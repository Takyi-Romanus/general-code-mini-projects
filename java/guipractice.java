import javax.swing.*;
public class guipractice {
    public static void main(String[] args) {
        String name;
        String indexNumber;
        String program;
        String gpa;
        double GPA;

        name = JOptionPane.showInputDialog("Enter your full name: ");
        indexNumber = JOptionPane.showInputDialog("Enter your Index Number: ");
        program = JOptionPane.showInputDialog("Enter your Program: ");
        gpa = JOptionPane.showInputDialog("Enter your expected GPA: ");

        JOptionPane.showMessageDialog(null,
            "my name is " + name +" index number " + indexNumber + " oferring " + program +" I expect to have " + gpa + " GPA at the end of the academic year. ",
            "Student Information", JOptionPane.PLAIN_MESSAGE
        );

    }
}