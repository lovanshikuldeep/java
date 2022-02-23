package com.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.entities.Product;
import com.entities.User;

public class UserDao {

	private static Connection conn;

	public UserDao(Connection conn) {
		super();
		this.conn = conn;

	}

	public boolean userRegister(User us) {
		boolean f = false;
		try {
			String qu = "insert into user(name,email,contact,password) values(?,?,?,?)";
			PreparedStatement ps = conn.prepareStatement(qu);
			ps.setString(1, us.getName());
			ps.setString(2, us.getEmail());
			ps.setString(3, us.getContact());
			ps.setString(4, us.getPassword());

			ps.executeUpdate();
			f = true;

		} catch (Exception e) {
			e.printStackTrace();
		}
		return f;
	}

	public User getlogin(String em, String ps) {
		User us = null;
		try {
			String qu = "select * from user where email = ? and password = ?";

			PreparedStatement pst = conn.prepareStatement(qu);
			pst.setString(1, em);
			pst.setString(2, ps);

			ResultSet rs = pst.executeQuery();

			if (rs.next()) {
				us = new User();
				us.setName(rs.getString("name"));
				us.setEmail(em);

			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		return us;

	}

	public static boolean insertProduct(Product product) throws SQLException {
		System.out.println("insertProduct method");
		String qu = " INSERT INTO product (type, brand, price, size) VALUES(?, ?,?)";

		PreparedStatement ps = conn.prepareStatement(qu);
		ps.setString(1, product.getType());
		ps.setString(2, product.getBrand());
		ps.setString(3, product.getPrice());
		ps.setString(4, product.getSize());

		boolean rowInserted = ps.executeUpdate() > 0;

		return rowInserted;
	}

	public  static List<Product> listAllProducts() throws SQLException {
     List<Product> listProduct = new ArrayList<>();
     
     String qu="SELECT * FROM product";
     
     Statement statement = conn.createStatement();
     ResultSet resultSet = statement.executeQuery(qu);
     
     while(resultSet.next()) {
    	 int id = resultSet.getInt("product_id");
    	 String type = resultSet.getString("type");
    	 String brand = resultSet.getString("brand");
    	 String price = resultSet.getString("price");
    	 String size =  resultSet.getString("size");
    	 
    	 Product product = new Product(id, type, brand, price, size);
    	 listProduct.add(product);
    	 
     }
     return listProduct;
     
	}
	
	public static boolean deleteProduct(Product product)throws SQLException {
		String qu = "DELETE FROM product where product_id = ? ";
		
		PreparedStatement statement = conn.prepareStatement(qu);
		statement.setInt(1, product.getId());
		
		boolean rowDeleted = statement.executeUpdate()>0;
		statement.close();
		
		return rowDeleted;
		
	}
	
	public static boolean updateProduct(Product product) throws SQLException {
        String sql = "UPDATE product SET type = ?, brand = ?, price = ?, size = ?";
        sql += " WHERE product_id = ?";
      
         
        PreparedStatement statement = conn.prepareStatement(sql);
        statement.setString(1, product.getType());
        statement.setString(2, product.getBrand());
        statement.setString(3, product.getPrice());
        statement.setString(4, product.getSize());
        statement.setInt(5, product.getId());
         
        boolean rowUpdated = statement.executeUpdate() > 0;
        statement.close();
       
        return rowUpdated;     
    }
	
	 public static Product getproduct(String string) throws SQLException {
	        Product product = null;
	        String qu = "SELECT * FROM product WHERE product_id = ?";
	         
	     
	         
	        PreparedStatement statement = conn.prepareStatement(qu);
	        statement.setString(1, string);
	         
	        ResultSet resultSet = statement.executeQuery();
	         
	        if (resultSet.next()) {
	            String type = resultSet.getString("type");
	            String brand = resultSet.getString("brand");
	            float price = resultSet.getFloat("price");
	            String size = resultSet.getString("size");
	             
	          //  product = new Product();
	        }
	         
	        
	         
	        return product;
	    }
	
	

}
