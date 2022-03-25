package bankInterface;

public abstract class BankAccount {
	private int ID; // For each account this should only go up to 5, so don't put a static variable here, just ensure it just gets the position its in in the array passed in to set the ID. - jack
	private double balance;
	private AccountType accountType;
	
	public BankAccount(AccountType accountType, int idInArray) {
		this.accountType = accountType;
		this.ID = idInArray;
		this.balance = 0;
	}
	
	public int getID() {
		return ID;
	}
	public void setID(int iD) {
		this.ID = iD;
	}
	public double getBalance() {
		return balance;
	}
	
	public void setBalance(double Balance) {
		this.balance = Balance;
	}
	
	public void addBalance(double amount) {
		this.balance += amount;
	}
	
	public void lowerBalance(double amount) {
		this.balance -= amount;
	}
	
	public AccountType getAccountType() {
		return accountType;
	}

}