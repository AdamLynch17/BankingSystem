package bankInterface;

public class BankClient {
	private int ID;
	private static int bankID = 0;
	private BankProfile profile;
	private BankAccount[] accounts = new BankAccount[5];
	private int numOfAccounts = 0;

	public BankClient() {
		ID = bankID;
		bankID++;
	}

	public int getID() {
		return this.ID;
	}

	public void createProfile(String firstName, String lastName, String address, int age) {

		// Validation is all done in UI.

		profile = new BankProfile(firstName, lastName, address, age);

	}

	public void updateProfile(String address, int age) {

		// Validation done in UI

		profile.setAddress(address);
		profile.setAge(age);
	}

	public boolean profileExists() {
		return profile != null;
	}

	public void setBalance(double amount, int ID) {
		accounts[ID].setBalance(amount); 
	}

	public double getBalance(int ID) {
		return accounts[ID].getBalance();
	}

	public void addBalance(double amount, int ID) {
		accounts[ID].addBalance(amount);
	}//

	public int getAccountAmount() {
		return numOfAccounts;
	}

	public void updateProfile(String address) {

		// Validation done in UI

		profile.setAddress(address);

	}

	public void updateProfile(int age) {

		// Validation done in UI

		profile.setAge(age);
	}

	public String transferMoney(BankClient account, int targetAccountNum, int accountToTakeFrom, double amount) {
		String str = "";
	
		if (accounts[accountToTakeFrom].getBalance() >= amount) {

			
			int i;
			for(i = 0; i < numOfAccounts;i++) {
				if(accounts[i].getID() == accountToTakeFrom) {
					accounts[i].lowerBalance(amount);				
				}
				if(accounts[i].getID() == targetAccountNum) {
					
					account.addBalance(amount, i);
					str += "\nTRANSFER SUCCESSFUL" + "\n";
					str += "--------------------------\n";
					str += "Bank Account ID: " + targetAccountNum + "\n";
					str += "Amount Transferred: " + amount + "\n";
					str += "New Balance: " + accounts[i].getBalance();
					return str;
				} 
			}	
				str += "TRANSFER UNSUCCESSFUL" + "\n";
				str += "--------------------------\n";
				str += "Bank Account ID: " + accountToTakeFrom + "\n";
				str += "ERROR: Insufficient funds in Account Balance";
				return str;
						
		} else {

			str += "TRANSFER UNSUCCESSFUL" + "\n";
			str += "--------------------------\n";
			str += "Bank Account ID: " + accountToTakeFrom + "\n";
			str += "ERROR: Insufficient funds in Account Balance";

		}
		return str;
	}

	public String printProfile() {

		return profile.getDetails();

	}

	public String printAccountDetails() {
		String details = "";
		for (int i = 0; i < numOfAccounts; i++) {
			if (accounts[i] instanceof PremiumBankAccount) {
				details += "\nBank Account ID: " + accounts[i].getID() + "\n";
				details += "--------------------------\n";
				details += "Account Balance: " + accounts[i].getBalance() + "\n";
				details += "Fee: " + ((PremiumBankAccount) accounts[i]).getFee() + "\n";
				details += "Total Cash Back: " + ((PremiumBankAccount) accounts[i]).getCashback() + "\n";
			} else {
				details += "\nBank Account ID: " + accounts[i].getID() + "\n";
				details += "--------------------------\n";
				details += "Account Balance: " + accounts[i].getBalance() + "\n";
			}
		}
		return details;
	}

	public String createAccount(AccountType accountType) {
		String str = "";
		if (numOfAccounts < 5) {
			switch (accountType) {
			case BASIC:
				accounts[numOfAccounts] = new BasicBankAccount(accountType, numOfAccounts);
				str += "Basic Account Created!";
				accounts[numOfAccounts].setID(numOfAccounts);
				accounts[numOfAccounts].addBalance(1000);
				numOfAccounts++;
				break;
			case PREMIUM:
				accounts[numOfAccounts] = new PremiumBankAccount(accountType, numOfAccounts);
				str+= "Premium Account Created!";
				accounts[numOfAccounts].setID(numOfAccounts);
				accounts[numOfAccounts].addBalance(1000);
				numOfAccounts++;
				break;
			default:
				System.out.println("This error should not be able to occur.");
			}
		}
		return str;
	}

	public void deleteAccount(int ID) {
		BankAccount[] temp = new BankAccount[accounts.length];
		int j = 0;
		for(int i = 0; i < accounts.length; i++) {
			if(i != ID) {
				temp[j] = accounts[i];
				j++;
			}
		}
		temp[temp.length - 1] = null;
		accounts = temp;
		numOfAccounts--;
		
	}
}