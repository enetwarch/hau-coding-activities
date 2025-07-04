public class SecureBankAccount {
    private String accountNumber;
    private double balance;
    private String pin;
    private boolean isLocked;
    
    public SecureBankAccount(String accountNumber, double initialBalance, String pin) {
        this.accountNumber = accountNumber;
        this.balance = initialBalance;
        this.pin = pin;
        this.isLocked = false;
    }
    
    public String getAccountNumber() {
        return this.accountNumber;
    }
    
    public double getBalance() {
        return this.balance;
    }
    
    public void deposit(double amount) {
        if (this.isLocked) return;
        this.balance += amount;
    }
    
    public String withdraw(double amount, String enteredPin) {
        if (this.isLocked) return "Account is locked. Withdrawal not allowed.";
        if (this.pin != enteredPin) return "Incorrect PIN.";
        if (this.balance < amount) return "Insufficient balance for withdrawal.";
        
        this.balance -= amount;
        return String.format("Withdrawal successful. New balance: %.1f", this.balance);
    }
    
    public void lockAccount() {
        this.isLocked = true;
    }
    
    @Override
    public String toString() {
        return String.format("%s - P%.2f - %b", this.accountNumber, this.balance, this.isLocked); 
    }
}
