import java.util.*;

public class NumberGame {
    public static void main(String[] args) {
        System.out.println("  ****** WELCOME TO THE NUMBER GAME ******  ");
        System.out.println("RULES:\n1.Enter a number between 1 to 100 to guess my number:");
        System.out.println("2.You have only 5 attempts to predict the number");
        Random();
    }
    public static void Random() {
        Random random = new Random();
        int RandomNumber = random.nextInt(100)+1;
        System.out.println("Enter the expected Number:");
        check(RandomNumber);
    }

    public static int check(int RandomNumber) {
        int i = 0;
        @SuppressWarnings("resource")
        Scanner scan = new Scanner(System.in);
        int enteredNum = scan.nextInt();
            for(i = 0;i<5;i++){
            if (RandomNumber == enteredNum) {
                int score = i*20-100;
                score*=-1;
                System.out.println("Your score is :"+score+"%");
                System.out.println("*****  YOU WIN  *****");
                System.out.println("Do you want to continue the game ? : YES/NO");
                String choice = scan.next();
                choice = choice.toUpperCase();
                if (choice.equals("YES")) {
                    Random();
                } else if (choice.equals("NO")) {
                    System.out.println("   *****   Thanks for Playing :)  *****");
                    return 0;
                }
            } else if(i<5-1){
                if (enteredNum > RandomNumber) {
                    System.out.println("Your number is too Long...");
                } else if (enteredNum < RandomNumber) {
                    System.out.println("Your number is too Short...");
                }
                System.out.println("Enter the expected Number:");
                enteredNum = scan.nextInt();
            }
        }
            System.out.println("The attempts are finished");
            System.out.println("The Expected number is: " + RandomNumber);
            System.out.println("----- YOU LOSE -----");
            System.out.println("Do you want to continue the game ? : YES/NO");
            String choice = scan.next();
            choice = choice.toUpperCase();
            if (choice.equals("YES")) {
                Random();
            } else if (choice.equals("NO")) {
                System.out.println("   ***   Thanks for Playing :)  ***");
                return 0;
            }
            return 0;
        }
}
