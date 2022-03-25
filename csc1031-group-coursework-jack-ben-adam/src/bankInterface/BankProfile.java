package bankInterface;

public class BankProfile {
	private String firstName;
	private String lastName;
	private String address;
	private int age;
	
	
	public BankProfile(String firstName, String lastName, String address, int age) {
		// Validation done in UI.
		setFirstName(firstName);
		setLastName(lastName);
		setAddress(address);
		setAge(age);
	}

	
	public String getDetails() {
		String details = "";
		
		details += "First Name: " + firstName + "\n";
		details += "Last Name: " + lastName + "\n";
		details += "Address: " + address + "\n";
		details += "Age: " + age + "\n";
		
		return details;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}
}
