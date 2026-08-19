package encapsulation;
import java.util.Locale;
import java.util.Scanner;


public class Main {

    public static void main(String[] args) {

        Locale.setDefault(Locale.US);
        Scanner sc = new Scanner(System.in);
        Account account;


        System.out.print("Enter the account number: ");
        int accountNumber = sc.nextInt();
        sc.nextLine();

        System.out.print("Enter the account holder: ");
        String name = sc.nextLine();

        System.out.print("Is there an initial deposit? (y/n): ");
        String choice = sc.nextLine();

        if (choice.equals("y")) {
           System.out.print("Enter the initial deposit: ");
           double initial = sc.nextDouble();
           account = new Account(accountNumber, name, initial);

        }else {
            account = new Account(accountNumber, name);

        }

        System.out.println("Account data: " + account);

        System.out.print("Enter a value to deposit: ");
        double value = sc.nextDouble();
        account.deposit(value);


        System.out.println("Updated account data: " + account);

        System.out.print("Enter a value to withdraw ($5.00 Tax): ");
        value = sc.nextDouble();

        account.withdraw(value);

        System.out.println("Updated account data: " + account);

        sc.close();
    }

}
