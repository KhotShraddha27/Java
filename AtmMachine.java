package atmInterface;
import java.util.InputMismatchException;
import java.util.Scanner;

class User {
    Scanner sc = new Scanner(System.in);
    private double balance = 10000;

    public void menuList() {
        while (true) {
        	  System.out.println("\n-----------------MENU------------------");
            System.out.println("1. Check Balance");
            System.out.println("2. Deposit");
            System.out.println("3. Withdraw");
            System.out.println("4. Exit");
            System.out.println("\n-----------------------------------");
            System.out.print("\nEnter your choice:");
            int choice;
            try {
                choice = sc.nextInt();
            } catch (InputMismatchException e) {
                System.out.println("Please enter valid number!");
                sc.next(); 
                continue;
            }

            switch (choice) {
                case 1:
                    System.out.println("Balance: " + balance);
                    break;
                case 2:
                    balance = depositAmount(balance);
                    System.out.println("After depositing your balance is : Rs. " + balance);
                    break;
                case 3:
                    balance = withdrawAmount(balance);
                    System.out.println("After withdrawing your current balance is : Rs. " + balance);
                    break;
                case 4:
                    System.out.println("Thank you.");
                    return;
                default:
                    System.out.println("Please choose a valid option!");
            }
        }
    }

    private double depositAmount(double current) {
        System.out.println("Amount to be deposited :");
        double amt = sc.nextDouble();
        if (amt > 0) return current + amt;
        else {
            System.out.println("Enter positive numbers!");
            return current;
        }
    }

    private double withdrawAmount(double current) {
        System.out.println(" Amount to be withdrawed :");
        double amt1 = sc.nextDouble();
        if (amt1 <= 0) {
            System.out.println("Enter positive numbers!");
            return current;
        } else if (amt1 > current) {
            System.out.println("Insufficient funds!");
            return current;
        } else {
            return current - amt1;
        }
    }
}



public class AtmMachine {
	public static void main(String[] args) {
	    System.out.println("Welcome to ATM Machine!");
	    User acc = new User();
	    acc.menuList();
	}

}