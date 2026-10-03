class NegativeAmount extends Exception {
   public NegativeAmount(double amount) {
      super("Deposit or withdrawal amount must be greater than or not equal to 0");
   }
}

class WithdrawalGreater extends Exception {
   public WithdrawalGreater(double amount, double balance) {
      super("Withdrawal is greater than account balance");
   }
}

public class BankAccount {
   private String accountNumber;
   private double accountBalance;
   private String accountName;

   public BankAccount(String accNum, String accName, double accBal) {
      if (accNum.length() != 9) {
         throw new IllegalArgumentException("Account number must be 9 digits long");
      }

      if (accName.isEmpty()) {
         throw new IllegalArgumentException("Account name cannot be blank");
      }

      if (accBal < 0) {
         throw new IllegalArgumentException("Account Balance cannot be negative");
      }

      this.accountNumber = accNum;
      this.accountName = accName;
      this.accountBalance = accBal;
   }

   public void deposit(double amount) throws NegativeAmount {
      if (amount <= 0) {
         throw new NegativeAmount(amount);
      }
      else {
         accountBalance += amount;
      }
   }

   public void withdraw(double amount) throws NegativeAmount, WithdrawalGreater {
      if (amount <= 0) {
         throw new NegativeAmount(amount);
      }
      else if (amount > accountBalance) {
         throw new WithdrawalGreater(amount, accountBalance);
      }
      else {
         accountBalance -= amount;
      }
   }

   @Override
   public String toString() {
      return "Account Name: %s \nAccount Number: %s \nAccount Balance: $%.2f".formatted(accountName, accountNumber, accountBalance);
   }

}
