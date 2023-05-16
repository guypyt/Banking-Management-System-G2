package banking2;

import java.util.Random;
import java.util.Scanner;

public class BankingApplication2 {

    public static void main(String[] args) {
        Account account;
        int option = 0; // var for new account 
        int number;
        String name;
        double balance , amount;
        Bank bank = new Bank();
        Scanner scan;
        scan = new Scanner(System.in);
        
        while (option != 6) {
            System.out.println("Main Menu");
            System.out.println("1. Display All account");
            System.out.println("2. Open New Account");
            System.out.println("3. Close Existing Account");
            System.out.println("4. Deposit");
            System.out.println("5. Withdraw");
            System.out.println("6. Exit");
            System.out.println();
            System.out.print("Enter you choice : ");
            option = scan.nextInt();
            scan.nextLine();
            switch (option) {
                case 1:
                    bank.listAccounts();
                    break;
                case 2:
                    System.out.print("Enter Account Name : ");
                    name = scan.nextLine();
                    System.out.print("Enter Initial Balance : ");
                    balance = scan.nextDouble();
                    number = generateAccountNumber();
                    account = new Account(number, name, balance);
                    bank.openAccount(account);
                    System.out.println("");
                    break;
                case 3:
                    System.out.print("Enter Account Number: ");
                    number = scan.nextInt();
                    bank.closeAccount(number);
                    break;
                case 4:
                    System.out.print("Enter Account Number: ");
                    number = scan.nextInt();
                    System.out.print("Enter Amount: ");
                    amount = scan.nextDouble();
                    bank.depositMoney(number, amount);
                    break;
                case 5:
                    System.out.print("Enter Account Number: ");
                    number = scan.nextInt();
                    System.out.print("Enter Amount: ");
                    amount = scan.nextDouble();
                    bank.withdrawMoney(number, amount);
                    break;
            }
            System.out.println("");
        }
    }

    public static int generateAccountNumber() {
        Random rand = new Random();
        int number;
        number = 100000 + rand.nextInt(900000);
        return number;
    }
}
