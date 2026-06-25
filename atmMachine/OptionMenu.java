package atmMachine;
import java.io.IOException;
import java.util.HashMap;
import java.util.Scanner;

public class OptionMenu extends Account {
    Scanner menuInput = new Scanner(System.in);
    HashMap < Integer, Integer > data = new HashMap< Integer, Integer>();

    /* Validate customer information, account number and pin */
    public void getLogin() throws IOException {
        int x = 1;

        do {
            try {
                data.put(9876543, 9876);
                data.put(8989898, 1890);

                System.out.println("Welcome to the Archon ATM");

                System.out.println("Enter Your Customer Number: ");
                setCustomerNumber(menuInput.nextInt());
                
                System.out.println("Enter Your Pin Number: ");
                setPinNumber(menuInput.nextInt());

            } catch (Exception e) {
                System.out.println("/n" + "Invalid Character(s). Only Numbers." + "/n");
                x=2;
            }
            
            for (java.util.Map.Entry<Integer, Integer> entry : data.entrySet()) {
                if (entry.getKey() == getCustomerNumber() && entry.getValue() == getPinNumber()){
                    getAccountType();
                }
            }
        } while (x==1);
    }

    public void getAccountType(){
        System.out.println("Select the Account You Want To Access");
        System.out.println("Type 1 - Access Account");
        System.out.println("Type 2 - Savings Account");
        System.out.println("Type 3 -Exit");
        System.out.println("Choice : ");

        selection = menuInput.nextInt();

        switch (selection) {
            case 1:
                getChecking();
                break;

            case 2:
                getSaving();
                break;

            case 3:
                System.out.println("Thank You for using this ATM");
                break;
            
            default:
                System.out.println("/n" + "Invalid Choice." + "/n");
                getAccountType();
        }
    }

    public void getChecking(){
        System.out.println("Checking Account:");
        System.out.println("Type 1 - View Balance");
        System.out.println("Type 2 - Withdraw Funds");
        System.out.println("Type 3 - Deposit Funds");
        System.out.println("Type 4 - Exit");
        System.out.println("Choice : ");

        selection = menuInput.nextInt();

        switch (selection) {
            case 1:
                System.out.println("Checking Account Balance:" + moneyFormat.format(getCheckingBalance()));
                getAccountType();
                break;

            case 2:
                getCheckingWithdrawInput();
                getAccountType();
                break;

            case 3:
                getCheckingDepositInput();
                getAccountType();
                break;

            case 4:
                System.out.println("Thank You for using this ATM");
                break;
            
            default:
                System.out.println("/n" + "Invalid Choice." + "/n");
                getChecking();
        }
    }

    public  void getSaving(){
        System.out.println("Savings Account:");
        System.out.println("Type 1 - View Balance");
        System.out.println("Type 2 - Withdraw Funds");
        System.out.println("Type 3 - Deposit Funds");
        System.out.println("Type 4 - Exit");
        System.out.println("Choice : ");

        selection = menuInput.nextInt();

        switch (selection) {
            case 1:
                System.out.println("Saving Account Balance:" + moneyFormat.format(getSavingBalance()));
                getAccountType();
                break;

            case 2:
                getSavingWithdrawInput();
                getAccountType();
                break;

            case 3:
                getSavingDepositInput();
                getAccountType();
                break;

            case 4:
                System.out.println("Thank You for using this ATM");
                break;
            
            default:
                System.out.println("/n" + "Invalid Choice." + "/n");
                getSaving();
        }
    }
    int selection;
}
