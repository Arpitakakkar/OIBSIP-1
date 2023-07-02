import java.util.Scanner;
public class Task2 {
    public static void main(String[] args) {
        ATMInterface atm = new ATMInterface("1234", "Arpita", 100000.0);
        atm.show();
    }
}
class ATMInterface {
    private String userId;
    private String userPin;
    private double balance;

    public ATMInterface(String userId, String userPin, double balance) {
        this.userId = userId;
        this.userPin = userPin;
        this.balance = balance;
    }

    public void show() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter User ID: ");
        String inputId = scanner.nextLine();
        System.out.print("Enter User PIN: ");
        String inputPin = scanner.nextLine();

        if (userId.equals(inputId) && userPin.equals(inputPin)) {
            System.out.println("Login Successful!");
            showfunctionalities();
        } else {
            System.out.println("Invalid User ID or PIN!");
        }
    }

    private void showfunctionalities() {
        Scanner scanner = new Scanner(System.in);
        int choice;
        do {
            System.out.println("----------------------");
            System.out.println("1. Do Check your Balance \t");
            System.out.println("2. Withdraw");
            System.out.println("3. Deposit \t");
            System.out.println("4. Quit");
            System.out.print("Enter your choice: ");
            choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    System.out.println("Your balance is: $" + balance);
                    break;
                case 2:
                    System.out.print(" Please Enter amount to withdraw: ");
                    double withdrawalAmount = scanner.nextDouble();
                    if (withdrawalAmount <= balance) {
                        balance -= withdrawalAmount;
                        System.out.println("Withdrawal of $ " + withdrawalAmount + " successful.");
                        System.out.println("The new amount is--> " +balance);
                    } else {
                        System.out.println("Oops!Insufficient balance!");
                    }
                    break;
                case 3:
                    System.out.print("Enter amount to deposit: ");
                    double depositAmount = scanner.nextDouble();
                    balance += depositAmount;
                    System.out.println("Deposit of $" + depositAmount + " successful.");
                    System.out.println("The new amount is--> " +balance);
                    break;
                case 4:
                    System.out.println("It's time to Quit");
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        } while (choice != 4);
    }
}



