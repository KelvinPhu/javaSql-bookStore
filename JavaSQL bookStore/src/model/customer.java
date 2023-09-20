package model;

public class customer {
	private String customerID, fullName, address;
	private int dateOfBirth;
	
	// constructor
	public customer() {
		super();
	}

	public customer(String customerID) {
		this.customerID = customerID;
	}

	public customer(String customerID, String fullName, String address, int dateOfBirth) {
		super();
		this.customerID = customerID;
		this.fullName = fullName;
		this.address = address;
		this.dateOfBirth = dateOfBirth;
	}

	// getter && setter
	public String getCustomerID() {
		return customerID;
	}

	public void setCustomerID(String customerID) {
		this.customerID = customerID;
	}

	public String getFullName() {
		return fullName;
	}

	public void setFullName(String fullName) {
		this.fullName = fullName;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public int getDateOfBirth() {
		return dateOfBirth;
	}

	public void setDateOfBirth(int dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}

	// toString
	@Override
	public String toString() {
		return "customer [customerID=" + customerID + ", fullName=" + fullName + ", address=" + address
				+ ", dateOfBirth=" + dateOfBirth + "]";
	}
	
	
	
}
