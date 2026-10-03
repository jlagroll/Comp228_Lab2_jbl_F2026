import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int x = 0;
        int accountNum = 1;

        Boolean exitSwitch = false;


        BankAccount[] banks = new BankAccount[3];

        while (x != 3) {
            try {
                System.out.print("Enter account %d number: ".formatted(accountNum));
                String accNum = input.nextLine();

                System.out.print("Enter account %d name: ".formatted(accountNum));
                String accName = input.nextLine();

                System.out.print("Enter account %d balance: $".formatted(accountNum));
                double accBal = input.nextDouble();
                input.nextLine();

                banks[x] = new BankAccount(accNum, accName, accBal);

                x++;
                accountNum++;
            }

            catch (IllegalArgumentException e) {
                System.out.println("Error: " + e.getMessage());
                System.out.println("Please try again");
            }
        }

        while (true) {
            try {
                System.out.print("Enter account id (4 to exit) [1, 2, 3, 4] ");
                int choice = input.nextInt();

                switch (choice) {
                    case 1:
                        System.out.print("Deposit, withdraw or print account info? (4 to exit) [1, 2, 3, 4]: ");
                        int depoOrWith = input.nextInt();

                        if (depoOrWith == 1) {
                            System.out.print("Type amount to deposit: $");
                            double amount = input.nextDouble();

                            banks[0].deposit(amount);
                            break;
                        }
                        else if (depoOrWith == 2) {
                            System.out.print("Type amount to withdraw: $");
                            double amount = input.nextDouble();

                            banks[0].withdraw(amount);
                            break;
                        }
                        else if (depoOrWith == 3) {
                            System.out.println(banks[0]);
                            continue;
                        }
                        else if (depoOrWith == 4) {
                            break;
                        }
                        else {
                            System.out.println("Invalid choice. Try again");
                            break;
                        }

                    case 2:
                        System.out.print("Deposit, withdraw or print account info? (4 to exit) [1, 2, 3, 4]: ");
                        int depoOrWith2 = input.nextInt();

                        if (depoOrWith2 == 1) {
                            System.out.print("Type amount to deposit: $");
                            double amount = input.nextDouble();

                            banks[1].deposit(amount);
                            break;
                        }
                        else if (depoOrWith2 == 2) {
                            System.out.print("Type amount to withdraw: $");
                            double amount = input.nextDouble();

                            banks[1].withdraw(amount);
                            break;
                        }
                        else if (depoOrWith2 == 3) {
                            System.out.println(banks[1]);
                            continue;
                        }
                        else if (depoOrWith2 == 4) {
                            break;
                        }
                        else {
                            System.out.println("Invalid choice. Try again");
                            continue;
                        }

                    case 3:
                        System.out.print("Deposit, withdraw or print account info? (4 to exit) [1, 2, 3, 4]: ");
                        int depoOrWith3 = input.nextInt();

                        if (depoOrWith3 == 1) {
                            System.out.print("Type amount to deposit: $");
                            double amount = input.nextDouble();

                            banks[2].deposit(amount);
                            break;
                        }
                        else if (depoOrWith3 == 2) {
                            System.out.print("Type amount to withdraw: $");
                            double amount = input.nextDouble();

                            banks[2].withdraw(amount);
                            break;
                        }
                        else if (depoOrWith3 == 3) {
                            System.out.println(banks[2]);
                            continue;
                        }
                        else if (depoOrWith3 == 4) {
                            break;
                        }
                        else {
                            System.out.println("Invalid input. Try again.");
                            continue;
                        }

                    case 4:
                        exitSwitch = true;
                        break;

                    default:
                        System.out.println("Invalid input. Try again.");
                }

                if (exitSwitch) {
                    break;
                }

            }

            catch (NegativeAmount e) {
                System.out.println(e.getMessage());
            }

            catch (WithdrawalGreater err) {
                System.out.println(err.getMessage());
            }

            finally {
                System.out.println("Transaction has been processed.");
            }

        }


    }
}
