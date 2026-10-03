import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int x = 0;

        Boolean exitSwitch = false;


        BankAccount[] banks = new BankAccount[3];

        while (x != 3) {
            try {
                System.out.print("Enter account %d number: ".formatted(x));
                String accNum = input.nextLine();

                System.out.print("Enter account %d name: ".formatted(x));
                String accName = input.nextLine();

                System.out.print("Enter account %d balance: ".formatted(x));
                double accBal = input.nextDouble();
                input.nextLine();

                banks[x] = new BankAccount(accNum, accName, accBal);

                x++;
            }

            catch (IllegalArgumentException e) {
                System.out.println("Error: " + e.getMessage());
                System.out.println("Please try again");
            }
        }

        while (true) {
            try {
                System.out.print("Enter account id (3 to exit) [0, 1, 2, 3]");
                int choice = input.nextInt();

                switch (choice) {
                    case 0:
                        System.out.print("Deposit, withdraw or print account info? (3 to exit) [0, 1, 2, 3]:");
                        int depoOrWith = input.nextInt();

                        if (depoOrWith == 0) {
                            System.out.print("Select amount to deposit: ");
                            double amount = input.nextDouble();

                            banks[0].deposit(amount);
                        }
                        else if (depoOrWith == 1) {
                            System.out.print("Select amount to withdraw: ");
                            double amount = input.nextDouble();

                            banks[0].withdraw(amount);
                        }
                        else if (depoOrWith == 2) {
                            System.out.println(banks[0]);
                        }
                        else if (depoOrWith == 3) {
                            break;
                        }
                        else {
                            System.out.println("Invalid choice. Try again");
                            break;
                        }

                    case 1:
                        System.out.print("Deposit, withdraw or print account info? (3 to exit) [0, 1, 2, 3]:");
                        int depoOrWith2 = input.nextInt();

                        if (depoOrWith2 == 0) {
                            System.out.print("Select amount to deposit: ");
                            double amount = input.nextDouble();

                            banks[1].deposit(amount);
                        }
                        else if (depoOrWith2 == 1) {
                            System.out.print("Select amount to withdraw: ");
                            double amount = input.nextDouble();

                            banks[1].withdraw(amount);
                        }
                        else if (depoOrWith2 == 2) {
                            System.out.println(banks[1]);
                        }
                        else if (depoOrWith2 == 3) {
                            break;
                        }
                        else {
                            System.out.println("Invalid choice. Try again");
                            continue;
                        }

                    case 2:
                        System.out.print("Deposit, withdraw or print account info? (3 to exit) [0, 1, 2, 3]:");
                        int depoOrWith3 = input.nextInt();

                        if (depoOrWith3 == 0) {
                            System.out.print("Select amount to deposit: ");
                            double amount = input.nextDouble();

                            banks[2].deposit(amount);
                        }
                        else if (depoOrWith3 == 1) {
                            System.out.print("Select amount to withdraw: ");
                            double amount = input.nextDouble();

                            banks[2].withdraw(amount);
                        }
                        else if (depoOrWith3 == 2) {
                            System.out.println(banks[2]);
                        }
                        else if (depoOrWith3 == 3) {
                            break;
                        }
                        else {
                            System.out.println("Invalid input. Try again.");
                            continue;
                        }
                    case 3:
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

            catch (WithdrawalGreater e) {
                System.out.println(e.getMessage());
            }

            finally {
                System.out.println("Transaction has been processed.");
            }

        }


    }
}
