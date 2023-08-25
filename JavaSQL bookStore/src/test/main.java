package test;

import java.util.ArrayList;
import java.util.Scanner;

import dataAccessObject.DAOBook;
import dataAccessObject.DAOCustomer;
import model.book;
import model.customer;

public class main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int choice = 0;
		do {
			System.out.println("=================== \r\n"
					+ "1. Book \r\n"
					+ "2. customer \r\n");
			choice = sc.nextInt();
			sc.nextLine();
			
			switch (choice) {
			case 1:
				System.out.println("=============== \r\n"
						+ "1. add new Book \r\n"
						+ "2. Update Book \r\n"
						+ "3. Delete Book \r\n"
						+ "4. print all the book detail \r\n"
						+ "5. print book by book ID \r\n"
						+ "6. print book by condition");
				choice = sc.nextInt();
				sc.nextLine();
				
				switch (choice) {
				case 1:
					System.out.println("enter book ID: ");
					String iD = sc.nextLine();
					System.out.println("Enter book name: ");
					String bookName = sc.nextLine();
					System.out.println("Enter Book Price: ");
					String price = sc.nextLine();
					System.out.println("enter year establish: ");
					int yearEstablish = sc.nextInt();
					
					book book1 = new book(iD, bookName, price, yearEstablish);
					DAOBook.getInstance().add(book1);
					break;
					
				case 2:
					System.out.println("enter book ID: ");
					iD = sc.nextLine();
					System.out.println("Enter book name: ");
					bookName = sc.nextLine();
					System.out.println("Enter Book Price: ");
					price = sc.nextLine();
					System.out.println("enter year establish: ");
					yearEstablish = sc.nextInt();
					
					book book2 = new book(iD, bookName, price, yearEstablish);
					DAOBook.getInstance().update(book2);
					break;
					
				case 3:
					System.out.println("Enter ID: ");
					iD = sc.nextLine();
					book book3 = new book(iD);
					DAOBook.getInstance().delete(book3);
					break;
					
				case 4:
					ArrayList<book> bookList = DAOBook.getInstance().selectAll();
					for (book b1 : bookList) {
						System.out.println(b1.toString());
					}
					break;

				case 5:
					System.out.println("Enter Book ID: ");
					iD = sc.nextLine();
					book b2 = new book(iD);
					System.out.println(DAOBook.getInstance().selectById(b2));
					break;
				
				case 6:
					System.out.println("Select book by condition: ");
					String condition = sc.nextLine();
					ArrayList<book> bookList2 = DAOBook.getInstance().selectByCondition(condition);
					for (book b3 : bookList2) {
						System.out.println(b3.toString());
					}
					break;
				default:
					break;
				}
				break;

			case 2:
				System.out.println("=============== \r\n"
						+ "1. add new Customer \r\n"
						+ "2. Update Customer \r\n"
						+ "3. Delete Customer \r\n"
						+ "4. print all the customers detail \r\n"
						+ "5. print customer by customer ID \r\n"
						+ "6. print customer by condition");
				choice = sc.nextInt();
				sc.nextLine();
				
				switch (choice) {
				case 1:
					System.out.println("enter Customer ID: ");
					String customerID = sc.nextLine();
					System.out.println("Enter Customer full name: ");
					String fullName = sc.nextLine();
					System.out.println("enter Customer address: ");
					String address = sc.nextLine();
					System.out.println("Enter Customer date of birth: ");
					int dateOfBirth = sc.nextInt();
					
					customer customer = new customer(customerID, fullName, address, dateOfBirth);
					DAOCustomer.getInstance().add(customer);
					break;
					
				case 2:
					System.out.println("enter Customer ID: ");
					customerID = sc.nextLine();
					System.out.println("Enter Customer full name: ");
					fullName = sc.nextLine();
					System.out.println("enter Customer address: ");
					address = sc.nextLine();
					System.out.println("Enter Customer date of birth: ");
					dateOfBirth = sc.nextInt();
					
					customer customer1 = new customer(customerID, fullName, address, dateOfBirth);
					DAOCustomer.getInstance().update(customer1);
					break;
					
				case 3:
					System.out.println("Enter Customer ID: ");
					customerID = sc.nextLine();
					customer customer2 = new customer(customerID);
					DAOCustomer.getInstance().delete(customer2);
					break;
					
				case 4:
					ArrayList<customer> customerList = DAOCustomer.getInstance().selectAll();
					for (customer c : customerList) {
						System.out.println(c.toString());
					}
					break;
					
				case 5:
					System.out.println("enter customer ID: ");
					customerID = sc.nextLine();
					
					customer c1 = new customer(customerID);
					System.out.println(DAOCustomer.getInstance().selectById(c1));
					break;
					
				case 6:
					System.out.println("Enter customer condition to get the customer detail: ");
					String condition = sc.nextLine();
					ArrayList<customer> customerList2 = DAOCustomer.getInstance().selectByCondition(condition);
					for (customer c2 : customerList2) {
						System.out.println(c2.toString());
					}
					break;
				default:
					break;
				}
				break;
			}
			
		} while (choice !=0);
	}
}
