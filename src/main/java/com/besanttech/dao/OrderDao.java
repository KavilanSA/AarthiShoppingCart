package com.besanttech.dao;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import com.besanttech.entities.Order;
import com.besanttech.entities.Product;

public class OrderDao {
	static Connection con = null;
	static Random rand = new Random();
	static {
		// initialize data source connections
		try {
			Class.forName("com.mysql.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/myshoppingstore", "root", "Kavilan@2022");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public void insertOrder(List<Product> products, String username) {

		// first create a random order id
		try {
			int orderId = rand.nextInt(1000);
			String insertOrderQuery = "insert into orders values(?,?,?)";
			PreparedStatement stmt = con.prepareStatement(insertOrderQuery);

			for (Product product : products) {

				stmt.setInt(1, orderId);
				stmt.setString(2, username);
				stmt.setInt(3, product.getId());
				stmt.executeUpdate();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public List<Order> getUserOrders(String userName) {

		List<Order> ordersList = new ArrayList<>();

		// first get order ids for the user

		try {
			String getOrderIdQuery = "select distinct order_id from orders where user_name=?";
			PreparedStatement stmt1 = con.prepareStatement(getOrderIdQuery);
			stmt1.setString(1, userName);
			ResultSet rs1 = stmt1.executeQuery();
			while (rs1.next()) {

				int orderId = rs1.getInt(1);
				Order order = new Order();
				order.setOrderId(orderId);
				List<Product> productsList = new ArrayList<>();
				String getProductIdsQuery = "select product_id from orders where order_id = ?";
				PreparedStatement stmt2 = con.prepareStatement(getProductIdsQuery);
				stmt2.setInt(1, orderId);
				ResultSet rs2 = stmt2.executeQuery();
				while (rs2.next()) {
					String productsQuery = "select * from products where product_id=?";
					PreparedStatement stmt3 = con.prepareStatement(productsQuery);
					stmt3.setInt(1, rs2.getInt(1));
					ResultSet rs3 = stmt3.executeQuery();
					List<Product> products = new ArrayList<>();
					while (rs3.next()) {
						Product product = new Product();
						product.setId(rs3.getInt(1));
						product.setName(rs3.getString(2));
						product.setColor(rs3.getString(3));
						product.setPrice(rs3.getFloat(4));
						product.setQuantity(rs3.getInt(5));
						productsList.add(product);
					}
				}
				order.setProductList(productsList);
				ordersList.add(order);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		return ordersList;

	}
}

