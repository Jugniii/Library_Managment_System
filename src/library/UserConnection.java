package library;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class UserConnection {

	public void signUp(User ref) throws Exception {
		Connection connection=getConnection();
		
		PreparedStatement preparedStatement=connection.prepareStatement("INSERT INTO library(ID,NAME,PHONE,EMAIL,PASSWORD)VALUES(? ,?, ? ,? ,?)");
		preparedStatement.setInt(1, ref.getId());
		preparedStatement.setString(2, ref.getName());
		preparedStatement.setLong(3, ref.getPhone());
		preparedStatement.setString(4, ref.getEmail());
		preparedStatement.setString(5, ref.getPassword());
		
		int result=preparedStatement.executeUpdate();
		if(result!=0) {
			System.out.println("Inserted");
		}
		else {
			System.out.println("Not");
		}
		connection.close();
	}
	public Connection getConnection() throws Exception  {
		Class.forName("com.mysql.cj.jdbc.Driver");
		
		Connection connection=DriverManager.getConnection("jdbc:mysql://localhost:3306/person","root","root");
		return connection;
	}
	}

	