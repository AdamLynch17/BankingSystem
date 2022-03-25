package bankInterface;

import java.util.Scanner;

public class userInterface {

	static boolean menuEnd = false;
	static Scanner sc = new Scanner(System.in);
	static int currentID; // This will be assigned in the startup.
	static BankClient bankClients[] = new BankClient[1000]; // Initiates the bank client array

	public static void main(String[] args) {
		long startTime = System.currentTimeMillis();
		for (int i = 0; i < bankClients.length; i++) { // Creates a new bank account for each account in the array.

			bankClients[i] = new BankClient(); // Constructs each bank account with a unique ID.

		}
		System.out.println("Registration of Bank Client with ID 0");

		// Creating test accounts with test data.
		bankClients[1].createProfile("John", "Doe", "52 Fake Ave", 22);
		bankClients[1].createAccount(AccountType.BASIC);
		System.out.println("Registration of Bank Client with ID 1");

		bankClients[2].createProfile("Mary", "Sue", "123 Unreal Road", 32);
		bankClients[2].createAccount(AccountType.PREMIUM);
		System.out.println("Registration of Bank Client with ID 2");

		bankClients[3].createProfile("Jerry", "Carrey", "98 Facade Place", 23);
		bankClients[3].createAccount(AccountType.PREMIUM);
		System.out.println("Registration of Bank Client with ID 3");

		bankClients[4].createProfile("Peter", "Griffin", "31 Spooner Street", 46);
		bankClients[4].createAccount(AccountType.PREMIUM);
		bankClients[4].createAccount(AccountType.PREMIUM);
		bankClients[4].createAccount(AccountType.BASIC);
		System.out.println("Registration of Bank Client with ID 4");

		bankClients[5].createProfile("Joe", "Schmoe", "199 Realroad Ave", 27);
		bankClients[5].createAccount(AccountType.PREMIUM);
		System.out.println("Registration of Bank Client with ID 5");

		long endTime = System.currentTimeMillis();
		System.out.println("Bank Clients Array Initialised: \nTime Taken: " + (endTime - startTime) + "ms");

		System.out.print("Please Enter your Bank ID:");
		currentID = sc.nextInt();
		do {
			System.out.println();
			System.out.println("=+=+=+=+=+=+=+=+=+=+=+=+=+");
			System.out.println("=+=+= Bank Interface +=+=+");
			System.out.println("=+=+=+=+=+=+=+=+=+=+=+=+=+");
			System.out.println("1. Create Bank Profile");
			System.out.println("2. Update Bank Profile");
			System.out.println("3. Create Bank Account");
			System.out.println("4. Delete Bank Account");
			System.out.println("5. Transfer Money");
			System.out.println("6. Get Account Details");
			System.out.println("7. Get Profile Details");
			System.out.println("8. Exit.");
			System.out.print("Please Enter Choice:");
			int choice = sc.nextInt();
			processChoice(choice, bankClients, currentID);

		} while (!menuEnd);
	}

	public static void processChoice(int choice, BankClient[] clients, int currentID) {
		switch (choice) {
		case 1:
			createBankProfile(clients, currentID);
			break;
		case 2:
			updateBankProfile(clients, currentID);
			break;
		case 3:
			createBankAccount(clients, currentID);
			break;
		case 4:
			deleteAccount(clients, currentID);
			break;
		case 5:
			transferMoney(clients, currentID);
			break;
		case 6:
			printAccountData(clients, currentID);
			break;
		case 7:
			printProfileData(clients, currentID);
			break;
		case 8:
			menuEnd = true;
			break;
		default:
			System.out.println("Invalid Choice, please enter a valid ID.");
		}
	}

	public static void createBankProfile(BankClient[] clients, int ID) {
		if (clients[ID].profileExists()) {
			System.out.println("Profile already exists!");
		} else {
			boolean validData = false;
			Scanner sc2 = new Scanner(System.in);
			String firstName, lastName, address;
			int age;
			do {
				System.out.print("Please enter your First Name: ");
				firstName = sc2.nextLine();
				if (firstName.equals("")) {
					System.out.println("Name cannot be blank.");
				} else {
					break;
				}
			} while (!validData);

			do {
				System.out.print("Please enter your Last Name: ");
				lastName = sc2.nextLine();
				if (lastName.equals("")) {
					System.out.println("Name cannot be blank.");
				} else {
					break;
				}
			} while (!validData);

			do {
				System.out.print("Please enter your Address: ");
				address = sc2.nextLine();
				if (address.equals("")) {
					System.out.println("Address cannot be blank.");
				} else {
					break;
				}
			} while (!validData);

			do {
				System.out.print("Please enter your age: ");
				age = sc2.nextInt();
				if (age == 0) {
					System.out.println("Age cannot be 0.");
				} else {
					break;
				}
			} while (!validData);
			System.out.println("Profile Successfully Made!");
			clients[ID].createProfile(firstName, lastName, address, age);
		}

	}

	public static void updateBankProfile(BankClient[] clients, int ID) {
		Scanner sc2 = new Scanner(System.in);
		if (clients[ID].profileExists()) {
			System.out.println("Which would you like to update?");
			System.out.println("1. Address");
			System.out.println("2. Age");
			System.out.println("3. Both");
			System.out.print("Selection: ");
			String address;
			boolean validData = false;
			int age;
			int choice = sc.nextInt();
			switch (choice) {
			case 1:

				do {
					System.out.print("Please enter your Address: ");
					address = sc2.nextLine();
					if (address.equals("")) {
						System.out.println("Address cannot be blank.");
					} else {
						clients[ID].updateProfile(address);
						System.out.println("Profile Updated with new address!");
						break;
					}
				} while (!validData);
				break;
			case 2:
				do {
					System.out.print("Please enter your age: ");
					age = sc2.nextInt();
					if (age == 0) {
						System.out.println("Age cannot be 0.");
					} else {
						System.out.println("Profile Updated with new age!");
						clients[ID].updateProfile(age);
						break;
					}
				} while (!validData);
				break;

			case 3:

				do {
					System.out.print("Please enter your Address: ");
					address = sc2.nextLine();
					if (address.equals("")) {
						System.out.println("Address cannot be blank.");
					} else {
						break;
					}
				} while (!validData);

				do {
					System.out.print("Please enter your age: ");
					age = sc2.nextInt();
					if (age == 0) {
						System.out.println("Age cannot be 0.");
					} else {
						break;
					}
				} while (!validData);
				System.out.println("Profile Updated with new address and age!");
				clients[ID].updateProfile(address, age);
				break;
			default:
				System.out.println("Invalid Option");
			}

		} else {
			System.out.println("This Client does not have a profile yet.");
		}

	}

	public static void createBankAccount(BankClient[] clients, int ID) {
		if (clients[ID].getAccountAmount() == 5) {
			System.out.println("Maximum number of accounts already made.");
		} else {
			System.out.println("Account Types:");
			System.out.println("1. Basic");
			System.out.println("2. Premium");
			int choice = sc.nextInt();
			if (choice == 1) {
				System.out.println(clients[ID].createAccount(AccountType.BASIC));
			} else if (choice == 2) {
				System.out.println(clients[ID].createAccount(AccountType.PREMIUM));
			} else {
				System.out.println("Please choose a valid choice.");
			}
		}

	}

	public static void transferMoney(BankClient[] clients, int ID) {
		System.out.println("What is the ID of the client you wish to transfer to: ");
		int targetID;
		boolean validData = false;
		do {
			System.out.print("Please enter the ID: ");
			targetID = sc.nextInt();
			for (int i = 0; i < clients.length; i++) {
				if (targetID == clients[ID].getID()) {
					System.out.println("ID found in system!\n");
					break;
				} else {
					System.out.println("ID not found in system, please enter valid ID");
				}
			}
			break;
			
		} while (!validData);
		BankClient targetAccount = clients[targetID];
		
		int currentAccountNumber;
		do {
			System.out.println("Which account do you want to transfer the money from?");
			currentAccountNumber = sc.nextInt();
			if (currentAccountNumber <= clients[ID].getAccountAmount()) {
				System.out.println("Account found!\n");
				break;
			} else {
				System.out.println("Account not found, please try again!\n");
			}

		} while (!validData);
		
		
		int targetAccountNumber;
		do {
			System.out.println("Please enter the account number of the recipient: ");
			targetAccountNumber = sc.nextInt();
			if (targetAccountNumber <= targetAccount.getAccountAmount()) {
				System.out.println("Account found!\n");
				break;
			} else {
				System.out.println("Account not found, please try again!\n");
			}
		} while (!validData);

		
		double transferAmount;
		do {
			System.out.println("Please enter the amount you wish to transfer: ");
			transferAmount = sc.nextInt();
			if (transferAmount <= 0) {
				System.out.println("Cannot transfer 0 or less.\n");
			} else {
				System.out.println("Amount confirmed.\n");
				break;
			}
		} while (!validData);
		System.out.println(clients[ID].transferMoney(targetAccount, targetAccountNumber, currentAccountNumber, transferAmount));

	}

	public static void printProfileData(BankClient[] clients, int ID) {
		if (clients[ID].profileExists()) {
			System.out.println(clients[ID].printProfile());
		} else {
			System.out.println("No profile to print!");
		}

	}

	public static void printAccountData(BankClient[] clients, int ID) {
		if (clients[ID].getAccountAmount() > 0 && clients[ID].getAccountAmount() < 5) {

			System.out.println(clients[ID].printAccountDetails());

		} else {
			System.out.println("No Bank Accounts on profile.");
		}

	}

	public static void deleteAccount(BankClient[] clients, int ID) {
		if (clients[ID].getAccountAmount() == 0) {
			System.out.println("No Bank Accounts registered to this client.");
		} else {
			System.out.println("Please enter the ID of the bank account you wish to delete. There are currently: "
					+ clients[ID].getAccountAmount() + " accounts registerred to this client.");
			int choice = sc.nextInt();
			if (choice < clients[ID].getAccountAmount()) {
				clients[ID].deleteAccount(choice);
				System.out.println("Account at position: " + choice + " deleted.");
			}
		}
	}

}
