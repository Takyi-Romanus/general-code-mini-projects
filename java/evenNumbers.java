public class evenNumbers {

    public static void main(String[] args) {
        int number = 20;

        System.out.println("Even numbers from 1 to " + number + ":");
        for (int i = 1; i <= number; i++) {
            if (i % 2 == 0) {
                System.out.print(i + " ");
            }
        }
    }
}