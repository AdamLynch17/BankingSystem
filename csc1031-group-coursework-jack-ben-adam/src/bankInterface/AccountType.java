package bankInterface;

public enum AccountType {
	BASIC("Basic Account"), PREMIUM("Premium Account");

	private final String label;

	private AccountType(String label) {
		this.label = label;
	}

	/*
	 * This method returns the string attached to each of the enum value types.
	 * 
	 * @return label
	 */
	public String toString() {
		return label;
	}
}
