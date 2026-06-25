package searchSort;
import java.util.Scanner;
import java.util.InputMismatchException;
public class normalSearch {
    public static void main(String[] args) {
            int[] element= new int[]{1,2,4,6,9};
            Scanner input= new Scanner(System.in);
            System.out.println("Enter the number to search for :");
            int k=input.nextInt();
            try {
                if (search(element,k)==k) {
                System.out.println("The element:: "+k+" was found");
                } else {
                    System.out.println("The element:: "+k+" was not found");
                }
            } catch (InputMismatchException e) {
                System.out.println("Enter a valid number.");
            }
        input.close();
            
        }


    static int search(int [] a,int k){
        for (int i = 0; i < a.length; i++) {
            if (a[i]==k) {
                return k;
            }
        }
        return k;
    }
}
