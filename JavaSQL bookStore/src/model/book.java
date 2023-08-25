package model;

public class book {
	private String ID, bookName, price;
	private int yearEstablish;
	
	// constructor
	public book() {
		super();
	}

	public book(String iD, String bookName, String price, int yearEstablish) {
		super();
		ID = iD;
		this.bookName = bookName;
		this.price = price;
		this.yearEstablish = yearEstablish;
	}
	
	public book(String ID) {
        this.ID = ID;
    }

	// getter && setter
	public String getID() {
		return ID;
	}

	public void setID(String iD) {
		ID = iD;
	}

	public String getBookName() {
		return bookName;
	}

	public void setBookName(String bookName) {
		this.bookName = bookName;
	}

	public String getPrice() {
		return price;
	}

	public void setPrice(String price) {
		this.price = price;
	}

	public int getYearEstablish() {
		return yearEstablish;
	}

	public void setYearEstablish(int yearEstablish) {
		this.yearEstablish = yearEstablish;
	}

	@Override
	public String toString() {
		return "book [ID=" + ID + ", bookName=" + bookName + ", price=" + price + ", yearEstablish=" + yearEstablish
				+ "]";
	}
	
	
}
