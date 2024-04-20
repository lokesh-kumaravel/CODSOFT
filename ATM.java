import java.util.*;
import java.math.BigDecimal;
public class ATM {
    Scanner scan = new Scanner(System.in);
    private BigDecimal balance;

    public ATM(BigDecimal initialBalance) {
        this.balance = initialBalance;
    }

    public void withdraw(BigDecimal amount) {
        if (amount.compareTo(BigDecimal.ZERO) > 0 && amount.compareTo(balance) <= 0)
        {
            balance = balance.subtract(amount);
            System.out.println("Withdrawal Successful... Do you want to see Current Balance ? YES/NO");
            String choice = scan.nextLine();
            if (choice.equalsIgnoreCase("YES")) {
                System.out.println("Current Balance: $" + balance);
            }
        } else 
        {
            System.out.println("Withdrawal Failed. Insufficient Funds.");
        }
    }

    public void deposit(BigDecimal amount) {    
        if (amount.compareTo(BigDecimal.ZERO)>0) {
            balance = balance.add(amount);
            System.out.println("Deposit successful... Do you want to see current balance ? YES/NO");
            String choice = scan.nextLine();
            if (choice.equalsIgnoreCase("YES")) {
                System.out.println("Current balance: $" + balance);
            }
        } else {
            System.out.println("Invalid deposit amount.");
        }
    }

    public BigDecimal checkBalance() {
        return balance;
    }
    public static void main(String[] args) {
        ATM atm = new ATM(new BigDecimal("1000.0"));
        Scanner scanner = new Scanner(System.in);
        System.out.println("\n\n\n    ----Welcome to ATM----    ");
        while (true) {
            System.out.println("\nChoose an option:");
            System.out.println("1. Check balance");
            System.out.println("2. Withdraw");
            System.out.println("3. Deposit");
            System.out.println("4. Exit");
            System.out.print("Enter your choice: ");

            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    BigDecimal balance = atm.checkBalance();
                    System.out.println("Current Balance: $" + balance);
                    break;
                case 2:
                    System.out.print("Enter withdrawal amount: $");
                    BigDecimal withdrawAmount = scanner.nextBigDecimal();
                    atm.withdraw(withdrawAmount);
                    break;
                case 3:
                    System.out.print("Enter deposit amount: $");
                    BigDecimal depositAmount = scanner.nextBigDecimal();
                    atm.deposit(depositAmount);
                    break;
                case 4:
                    System.out.println("    ----Exiting ATM. Goodbye!----    ");
                    scanner.close();
                    System.exit(0);
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }
}