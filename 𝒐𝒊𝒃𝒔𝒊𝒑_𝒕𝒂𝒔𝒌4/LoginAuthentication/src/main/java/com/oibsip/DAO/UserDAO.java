package com.oibsip.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.mysql.cj.protocol.Resultset;
import com.oibsip.entity.*;

public class UserDAO {

	private Connection connection;

	public UserDAO(Connection connection) {
		super();
		this.connection = connection;
	}

	public boolean userRegister( User user) {
			
			boolean f =false;
			
			try {
					
				String query = "insert into user(name,email,password) values(?,?,?)";
				PreparedStatement preparedStatement = connection.prepareStatement(query);
				preparedStatement.setString(1, user.getName());
				preparedStatement.setString(2, user.getEmail());
				preparedStatement.setString(3, user.getPassword());
				
				preparedStatement.executeUpdate();
				f=true;
				
			} catch (Exception e) {
				e.printStackTrace();
			}
			return f;
		}
	
		public User getLogin(String email, String password) {
						
				User user =null;
				try {
					
						String query = "select * from user where email=? and password=?";
						PreparedStatement preparedStatement = connection.prepareStatement(query);
						preparedStatement.setString(1, email);
						preparedStatement.setString(2, password);
						
						ResultSet resultset = preparedStatement.executeQuery();
						
						if ( resultset.next()) {

							user=new User(resultset.getInt(1), resultset.getString(2), resultset.getString(3), resultset.getString(4));
						}
						
					
				} catch (Exception e) {
					e.printStackTrace();
				}
				return user;
		}

}
