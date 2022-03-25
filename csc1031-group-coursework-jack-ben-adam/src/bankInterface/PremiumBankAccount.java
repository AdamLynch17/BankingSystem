package bankInterface;

public class PremiumBankAccount extends BankAccount {
	public PremiumBankAccount(AccountType accountType, int idInArray) {
		super(accountType, idInArray);
		this.fee = 5;
		this.cashbackAmount = 10;
	}

	private float fee;
	private double cashbackAmount;
	
	public float getFee() {
		return fee;
	}
	

	public void setFee(float Fee) {
		this.fee = Fee;
	}
	public double getCashback() {
		return cashbackAmount;
	}

	public void setFirstName(double CashBackAmount) {
		this.cashbackAmount = CashBackAmount;
	}
}

