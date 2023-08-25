package dataAccessObject;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import database.bookStore;
import model.book;

public class DAOBook implements DAOInterface<book>{

	public static DAOBook getInstance() {
		return new DAOBook() ;
	}
	
	
	@Override
	public int add(book t) {
		try {
			Connection c = bookStore.createConnection();
			
//			try {
//				String checkInsertOn = "set IDENTITY_INSERT book on";
//				int update1 = st.executeUpdate(checkInsertOn);
//				System.out.println("IDENTITY_INSERT have been ON");
//			} catch (SQLException e) {
//				System.out.println("fail to on");
//				e.printStackTrace();
//			}
			
			try {
				String addQuery = "INSERT INTO book (ID, bookName, price, yearEstablish) " +
	                      			"VALUES (?, ?, ?, ?)";
				
				PreparedStatement ps = c.prepareStatement(addQuery);
				ps.setString(1, t.getID());
				ps.setString(2, t.getBookName());
				ps.setString(3, t.getPrice());
				ps.setInt(4, t.getYearEstablish());
				
				int update2 = ps.executeUpdate();
					
				if (update2 > 0) {
					System.out.println("success execute a query");
				}
			} catch (Exception e) {
				System.out.println("fail to execute the query");
				e.printStackTrace();
			}
			
			
//			try {
//				String checkInsertOff = "set IDENTITY_INSERT book off";
//				int update3 = st.executeUpdate(checkInsertOff);
//				System.out.println("IDENTITY_INSERT have been Off");
//			} catch (SQLException e) {
//				System.out.println("fail to Off");
//				e.printStackTrace();
//			}
			
			bookStore.closeConnecion(c);
		} catch (Exception e) {
			System.out.println("fail");
			e.printStackTrace();
		}
		
		return 0;
	}

	@Override
	public int update(book t) {
		try {
			Connection c = bookStore.createConnection();
			
//			try {
//				String checkInsertOn = "set IDENTITY_INSERT book on";
//				int update1 = st.executeUpdate(checkInsertOn);
//				System.out.println("IDENTITY_INSERT have been ON");
//			} catch (SQLException e) {
//				System.out.println("fail to on");
//				e.printStackTrace();
//			}
			
			try {
				String updateQuery = "update book "
						+ "set "
						+ "bookName = ? "
						+ "price = ? "
						+ "yearEstablish = ? "
						+ "where id = ? ";
				
				PreparedStatement ps = c.prepareStatement(updateQuery);
				ps.setString(1, t.getID());
				ps.setString(2, t.getBookName());
				ps.setString(3, t.getPrice());
				ps.setInt(4, t.getYearEstablish());

				int update2 = ps.executeUpdate();
				if (update2 > 0) {
					System.out.println("success execute a query");
				}
			} catch (Exception e) {
				System.out.println("fail to execute the query");
				e.printStackTrace();
			}
			
//			try {
//				String checkInsertOff = "set IDENTITY_INSERT book off";
//				int update3 = st.executeUpdate(checkInsertOff);
//				System.out.println("IDENTITY_INSERT have been Off");
//			} catch (SQLException e) {
//				System.out.println("fail to Off");
//				e.printStackTrace();
//			}
			
			bookStore.closeConnecion(c);
		} catch (Exception e) {
			System.out.println("fail");
			e.printStackTrace();
		}
		
		return 0;
	}

	@Override
	public int delete(book t) {
		try {
			Connection c = bookStore.createConnection();
			
			
//			try {
//				String checkInsertOn = "set IDENTITY_INSERT book on";
//				int update1 = st.executeUpdate(checkInsertOn);
//				System.out.println("IDENTITY_INSERT have been ON");
//			} catch (SQLException e) {
//				System.out.println("fail to on");
//				e.printStackTrace();
//			}
			
			try {
				String deleteQuery = "delete from book "
						+ "where id = ?";
				
				
				PreparedStatement ps = c.prepareStatement(deleteQuery);
				ps.setString(1, t.getID());

				int update2 = ps.executeUpdate();
				if (update2 > 0) {
					System.out.println("Success: Book deleted.");
				}
			} catch (Exception e) {
				System.out.println("Error: Book not found.");
				e.printStackTrace();
			}
			
//			try {
//				String checkInsertOff = "set IDENTITY_INSERT book off";
//				int update3 = st.executeUpdate(checkInsertOff);
//				System.out.println("IDENTITY_INSERT have been Off");
//			} catch (SQLException e) {
//				System.out.println("fail to Off");
//				e.printStackTrace();
//			}
			
			bookStore.closeConnecion(c);
		} catch (Exception e) {
			System.out.println("fail");
			e.printStackTrace();
		}
		
		
		return 0;
	}
	
	@Override
	public ArrayList<book> selectAll() {
		ArrayList<book> bookResult = new ArrayList<book>();
		
		try {
			Connection c = bookStore.createConnection();
			
			String selecAlltQuery = "select * from book";
			PreparedStatement ps = c.prepareStatement(selecAlltQuery);
			ResultSet rs = ps.executeQuery();
			
			while (rs.next()) {
				String iD = rs.getString("iD");
				String bookName = rs.getString("bookName");
				String price = rs.getString("price");
				int yearEstablish = rs.getInt("yearEstablish");
				
				book book = new book(iD, bookName, price, yearEstablish);
				bookResult.add(book);
				
			}
			
			bookStore.closeConnecion(c);
			System.out.println("success to get book");
		} catch (SQLException e) {
			System.out.println("fail to get book");
			e.printStackTrace();
		}
		
		return bookResult;
	}

	@Override
	public book selectById(book t) {
		book bookResult = new book();
		
		try {
			Connection c = bookStore.createConnection();
			
			String selectByIDQuery = "select * from book "
								+ "where id = ?";
			PreparedStatement ps = c.prepareStatement(selectByIDQuery);
			ps.setString(1, t.getID());
			ResultSet rs = ps.executeQuery();
			
			while (rs.next()) {
				String iD = rs.getString("iD");
				String bookName = rs.getString("bookName");
				String price = rs.getString("price");
				int yearEstablish = rs.getInt("yearEstablish");
				
				bookResult = new book(iD, bookName, price, yearEstablish);
				
			}
			
			bookStore.closeConnecion(c);
			System.out.println("success to get book");
		} catch (SQLException e) {
			System.out.println("fail to get book");
			e.printStackTrace();
		}
		
		return bookResult;
	}

	@Override
	public ArrayList<book> selectByCondition(String condition) {
		ArrayList<book> bookResult = new ArrayList<book>();
		
		try {
			Connection c = bookStore.createConnection();
			
			String selectAllQuery = "select * from book "
					+ "where " +condition;
			
			PreparedStatement ps = c.prepareStatement(selectAllQuery);

			ResultSet rs = ps.executeQuery();
			
			while (rs.next()) {
				String iD = rs.getString("iD");
				String bookName = rs.getString("bookName");
				String price = rs.getString("price");
				int yearEstablish = rs.getInt("yearEstablish");
				
				book book = new book(iD, bookName, price, yearEstablish);
				bookResult.add(book);
				
			}
			
			bookStore.closeConnecion(c);
			System.out.println("success to get book");
		} catch (SQLException e) {
			System.out.println("fail to get book");
			e.printStackTrace();
		}
		
		return bookResult;
	}
}
