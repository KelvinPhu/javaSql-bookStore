package dataAccessObject;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import database.bookStore;
import model.customer;

public class DAOCustomer implements DAOInterface<customer>{

	public static DAOCustomer getInstance() {
		return new DAOCustomer();
	}
	
	@Override
	public int add(customer t) {
		try {
			Connection c = bookStore.createConnection();
			
			String addQuery = "insert into customer (customerID, fullName, dateOfBirth, address)" +
					"values (?, ?, ?, ?)";
			PreparedStatement ps = c.prepareStatement(addQuery);
			ps.setString(1, t.getCustomerID());
			ps.setString(2, t.getFullName());
			ps.setInt(3, t.getDateOfBirth());
			ps.setString(4, t.getAddress());
			
			int executeQuery = ps.executeUpdate();
			if (executeQuery > 0) {
				System.out.println("new line have been add to database");
			}
			
			bookStore.closeConnecion(c);
		} catch (SQLException e) {
			System.out.println("fail to add new line");
			e.printStackTrace();
		}
		
		return 0;
	}

	@Override
	public int update(customer t) {
		
		try {
			Connection c = bookStore.createConnection();
			
			String updateQuery = "update customer "
			        + "set "
			        + "fullName = ?"
			        + "dateOfBirth = ?"
			        + "address = ?"
			        + "where customerID = ?";
			
			PreparedStatement ps = c.prepareStatement(updateQuery);
			ps.setString(1, t.getCustomerID());
			ps.setString(2, t.getFullName());
			ps.setInt(3, t.getDateOfBirth());
			ps.setString(4, t.getAddress());
			
			int update = ps.executeUpdate();
			if (update > 0) {
				System.out.println("success to updated the line");
			}
			
			
			bookStore.closeConnecion(c);
			
		} catch (SQLException e) {
			System.out.println("fail to updated the line");
			e.printStackTrace();
		}
		
		
		return 0;
	}

	@Override
	public int delete(customer t) {
		try {
			Connection c = bookStore.createConnection();
			
			String deleteQuery = "delete from customer "
			        + "where customerID='" + t.getCustomerID() + "'";
			
			PreparedStatement ps = c.prepareStatement(deleteQuery);
			ps.setString(1, t.getCustomerID());
			
			int update = ps.executeUpdate();
			if (update > 0) {
				System.out.println("success to delete the line");
			}
			
			bookStore.closeConnecion(c);
			
		} catch (SQLException e) {
			System.out.println("fail to delete the line");
			e.printStackTrace();
		}

		return 0;
	}
	
	@Override
	public ArrayList<customer> selectAll() {
		ArrayList<customer> customerResult = new ArrayList<customer>();
		
		try {
			Connection c = bookStore.createConnection();
			
			String selectAllQuery = "select * from customer";
			PreparedStatement ps = c.prepareStatement(selectAllQuery);
			
			ResultSet rs = ps.executeQuery();
			
			while (rs.next()) {
				String customerID = rs.getString("customerID");
				String fullName = rs.getString("fullName");
				int dateOfBirth = rs.getInt("dateOfBirth");
				String address = rs.getString("address");
				
				customer customer = new customer(customerID, fullName, address, dateOfBirth);
				customerResult.add(customer);
			}
			
			bookStore.closeConnecion(c);
			System.out.println("success to get customer");
			
		} catch (SQLException e) {
			System.out.println("Fail to get customer");
			e.printStackTrace();
		}
		
		
		return customerResult;
	}

	@Override
	public customer selectById(customer t) {
		customer customerResult = new customer();
		
		try {
			Connection c = bookStore.createConnection();
			
			String selectAllQuery = "select * from customer "
									+ "where customerID = ?";
			PreparedStatement ps = c.prepareStatement(selectAllQuery);
			ps.setString(1, t.getCustomerID());
			
			ResultSet rs = ps.executeQuery();
			
			while (rs.next()) {
				String customerID = rs.getString("customerID");
				String fullName = rs.getString("fullName");
				int dateOfBirth = rs.getInt("dateOfBirth");
				String address = rs.getString("address");
				
				customerResult = new customer(customerID, fullName, address, dateOfBirth);
			}
			
			bookStore.closeConnecion(c);
			System.out.println("success to get customer");
			
		} catch (SQLException e) {
			System.out.println("Fail to get customer");
			e.printStackTrace();
		}
		
		
		return customerResult;
	}

	@Override
	public ArrayList<customer> selectByCondition(String condition) {
		ArrayList<customer> customerResult = new ArrayList<customer>();
		
		try {
			Connection c = bookStore.createConnection();
			
			String selectAllQuery = "select * from customer "
									+ "where " +condition;
			PreparedStatement ps = c.prepareStatement(selectAllQuery);
			ResultSet rs = ps.executeQuery();
			
			while (rs.next()) {
				String customerID = rs.getString("customerID");
				String fullName = rs.getString("fullName");
				int dateOfBirth = rs.getInt("dateOfBirth");
				String address = rs.getString("address");
				
				customer customer = new customer(customerID, fullName, address, dateOfBirth);
				customerResult.add(customer);
			}
			
			bookStore.closeConnecion(c);
			System.out.println("success to get customer");
			
		} catch (SQLException e) {
			System.out.println("Fail to get customer");
			e.printStackTrace();
		}
		
		return customerResult;
	}
}