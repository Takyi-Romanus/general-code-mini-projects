import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class makeFile {

    public static class CreateFile {
        public static void main(String[] args) {
            try {
                File myFile = new File("example.txt");
                if (myFile.createNewFile()) {
                    System.out.println("File created: " + myFile.getName());
                } else {
                    System.out.println("File already exists.");
                }
            } catch (IOException e) {
                System.out.println("An error occurred.");
                e.printStackTrace();
            }
        }
    }

    public static class WriteFile {
        public static void main(String[] args) {
            try {
                FileWriter writer = new FileWriter("example.txt");
                writer.write("Hello, this is a new file!");
                writer.close();
                System.out.println("Successfully wrote to the file.");
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public static class AppendFile {
        public static void main(String[] args) {
            try {
                FileWriter writer = new FileWriter("example.txt", true); // true = append mode
                writer.write("\nThis line is appended.");
                writer.close();
                System.out.println("Successfully appended to the file.");
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public static class ReadFile {
        public static void main(String[] args) {
            try {
                File myFile = new File("example.txt");
                Scanner reader = new Scanner(myFile);
                while (reader.hasNextLine()) {
                    String data = reader.nextLine();
                    System.out.println(data);
                }
                reader.close();
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }
        }
    }

    public static class DeleteFile {
        public static void main(String[] args) {
            File myFile = new File("example.txt");
            if (myFile.delete()) {
                System.out.println("Deleted the file: " + myFile.getName());
            } else {
                System.out.println("Failed to delete the file.");
            }
        }
    }

    CreateFile createFile = new CreateFile();
    WriteFile writeFile = new WriteFile(); 
    AppendFile appendFile = new AppendFile();
    ReadFile readFile = new ReadFile();
    DeleteFile deleteFile = new DeleteFile(); 

}
