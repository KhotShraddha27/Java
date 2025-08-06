package game;
import java.util.Random;
import java.util.Scanner;

public class NumberGame {

   public static void main(String[] args)
   {
      Scanner sc = new Scanner(System.in);
      Random random = new Random();
       int randomNo = random.nextInt(100) + 1; 
       int guess = 0;
       int attempts = 0;
       System.out.println("Welcome to the Number Game!");
       System.out.println("Number choosen must be in between 1 to 100.");
       System.out.println("Maximum attempts you need to guess the number: ");
       int Max_Attempts = sc.nextInt();

       while (attempts < Max_Attempts)
       {
            System.out.print("\nEnter your guess: ");
            guess = sc.nextInt();
            attempts++;

            if(attempts<(Max_Attempts/2) & (guess == randomNo)) 
            {
            		System.out.println("Superb!!You guessed in just"+attempts+"attempts.");
            }
            
            else if(attempts>(Max_Attempts/2) & (guess == randomNo))
            {
            		System.out.println("Nice try!!You guessed in "+attempts+"attempts.");
            }
            
            else if (guess < randomNo) 
            {
                System.out.println("The number you guess is too low ):\n Try again.");
            } 
            
            else
            {
                System.out.println("The number you guess is too high ):\n Try again.");
            }
        }

        if (attempts >= Max_Attempts && guess != randomNo)
        {
            System.out.println("\nYour attempts are over!!\n Bad Luck.\nThe correct number was:");
        }

        sc.close();
    }

}
