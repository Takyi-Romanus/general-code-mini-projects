import java.io.FileWriter;
import java.io.FileReader;
import java.io.BufferedReader;
import java.io.IOException;
import java.util.Scanner;

public class searchInFile {

    public static void main(String[] args) {

        String fileName = "data.txt";

        try {
            // Write data to the file
            FileWriter writer = new FileWriter(fileName);
            writer.write("Java is a powerful programming language.\n");
            writer.write("File handling allows programs to store data.\n");
            writer.write("Java supports file input and output operations.\n");
            writer.write("Learning Java is interesting and useful.");
            writer.close();

            System.out.println("Data written to file successfully.");

            // Ask the user for the word/text to search
            Scanner input = new Scanner(System.in);
            System.out.print("Enter the word or text to search: ");
            String searchText = input.nextLine();

            // Read the file and search for the text
            BufferedReader reader = new BufferedReader(new FileReader(fileName));

            String line;
            boolean found = false;

            while ((line = reader.readLine()) != null) {
                if (line.contains(searchText)) {
                    found = true;
                    System.out.println("Found in line: " + line);
                }
            }

            reader.close();

            if (found) {
                System.out.println("\nThe text \"" + searchText + "\" was found in the file.");
            } else {
                System.out.println("\nThe text \"" + searchText + "\" was NOT found in the file.");
            }

            input.close();

        } catch (IOException e) {
            System.out.println("An error occurred: " + e.getMessage());
        }
    }
}