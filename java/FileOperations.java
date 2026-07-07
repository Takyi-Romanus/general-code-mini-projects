import java.io.File;
import java.io.FileWriter;
import java.io.FileReader;
import java.io.BufferedReader;
import java.io.IOException;

public class FileOperations {

    public static void main(String[] args) {

        String fileName = "example.txt";

        try {
            // 1. Creating a file
            File file = new File(fileName);

            if (file.createNewFile()) {
                System.out.println("File created successfully: " + file.getName());
            } else {
                System.out.println("File already exists.");
            }


            // 2. Writing to the file
            FileWriter writer = new FileWriter(fileName);
            writer.write("Hello, this is the first line in the file.\n");
            writer.write("Java file handling is easy to learn.");
            writer.close();

            System.out.println("Data written successfully.");


            // 3. Appending to the file
            FileWriter appendWriter = new FileWriter(fileName, true);
            appendWriter.write("\nThis line was added using append operation.");
            appendWriter.close();

            System.out.println("Data appended successfully.");


            // 4. Reading the file
            FileReader reader = new FileReader(fileName);
            BufferedReader bufferedReader = new BufferedReader(reader);

            String line;

            System.out.println("\nFile contents:");

            while ((line = bufferedReader.readLine()) != null) {
                System.out.println(line);
            }

            bufferedReader.close();


            // 5. Deleting the file
            if (file.delete()) {
                System.out.println("\nFile deleted successfully.");
            } else {
                System.out.println("\nFailed to delete file.");
            }

        } catch (IOException e) {
            System.out.println("An error occurred: " + e.getMessage());
        }
    }
}