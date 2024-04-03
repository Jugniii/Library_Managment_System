package library;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.mysql.cj.x.protobuf.MysqlxConnection.Close;

public class LoginConnection {
	
public void login(User ref) throws Exception {
	Connection connection=getConnection();
	String qurey="SELECT * FROM library WHERE email=?";
	PreparedStatement preparedStatement=connection.prepareStatement(qurey);
	preparedStatement.setString(1,ref.getEmail());
//	preparedStatement.setString(2, ref.getPassword());
	ResultSet resultset=preparedStatement.executeQuery();
	if(resultset.next())
	{
		//System.out.println("Login!!!!");
		if(ref.getPassword().equals(resultset.getString("password")))
	{
			System.out.println("Login Successfully");
		}
		else if(!ref.getEmail().equals(resultset.getString("email")) && ref.getPassword().equals(resultset.getString("password")))
		{
			System.out.println("Email not correct");
		}
		else if(!ref.getPassword().equals(resultset.getString("password")) && ref.getEmail().equals(resultset.getString(ref.getEmail())))
		{
			System.out.println("Password not correct");
		}
		else
		{
			System.out.println("Login failed");
		}
	}
	else
	{
		System.out.println("User not register");
	}
	}

//BookAdd
public void bookAdd(Book book) throws Exception
{
	Connection connection=getConnection();
	PreparedStatement preparedStatement=connection.prepareStatement("insert into book(id,name,author,price,genre)values(?,?,?,?,?);");
	preparedStatement.setInt(1, book.getId());
	preparedStatement.setString(2, book.getName());
	preparedStatement.setString(3, book.getAuthor());
	preparedStatement.setDouble(4, book.getPrice());
	preparedStatement.setString(5, book.getGenre());
	int result=preparedStatement.executeUpdate();
	if(result!=0) 
	{
		System.out.println("Addaed Successfully");
	}
	else {
		System.out.println("Please try again");
	}
	
}

//BookDelete
public void bookDelete(Book book) throws Exception {
	Connection connection=getConnection();
	PreparedStatement preparedStatement=connection.prepareStatement("delete from book where id=?;");
	preparedStatement.setInt(1, book.getId());
	int result=preparedStatement.executeUpdate();
	if(result!=0) {
		System.out.println("*****Deleted Successfully****");
	}
	else {
		System.out.println("Please try again");
	}
}

//BookFetchById
public ResultSet bookFetchById(Book book) throws Exception {
	Connection connection=getConnection();
	PreparedStatement preparedStatement=connection.prepareStatement("select * from book where id=?;");
	preparedStatement.setInt(1, book.getId());
	ResultSet result=preparedStatement.executeQuery();
	if(result.next())
	{
		System.out.println("Fetch By ID Successfully");
		System.out.println("ID : "+result.getInt("id"));
		System.out.println("Name : "+result.getString("name"));
		System.out.println("Author : "+result.getString("author"));
		System.out.println("PRICE : "+result.getString("price"));
		System.out.println("GENRE : "+result.getString("genre"));
	}
	else {
		System.out.println("Try Again");
	}
	return result;
}
//BookFetchByName
public ResultSet bookFetchByName(Book book) throws Exception {
	Connection connection=getConnection();
	PreparedStatement preparedStatement=connection.prepareStatement("select * from book where id=?;");
	preparedStatement.setString(1, book.getName());
	ResultSet result=preparedStatement.executeQuery();
	if(result.next())
	{
		System.out.println("Fetch By ID Successfully");
		System.out.println("ID : "+result.getInt("id"));
		System.out.println("Name : "+result.getString("name"));
		System.out.println("Author : "+result.getString("author"));
		System.out.println("PRICE : "+result.getString("price"));
		System.out.println("GENRE : "+result.getString("genre"));
	}
	else {
		System.out.println("Try Again");
	}
	return result;
}
//BookFetchByAuthor
public ResultSet bookFetchByAuthor(Book book) throws Exception {
	Connection connection=getConnection();
	PreparedStatement preparedStatement=connection.prepareStatement("select * from book where author=?;");
	preparedStatement.setString(1, book.getAuthor());
	ResultSet result=preparedStatement.executeQuery();
	if(result.next())
	{
		System.out.println("Fetch By ID Successfully");
		System.out.println("ID : "+result.getInt("id"));
		System.out.println("Name : "+result.getString("name"));
		System.out.println("Author : "+result.getString("author"));
		System.out.println("PRICE : "+result.getString("price"));
		System.out.println("GENRE : "+result.getString("genre"));
	}
	else {
		System.out.println("Try Again");
	}
	return result;
}
//BookFetchGenre
public ResultSet bookFetchByGenre(Book book) throws Exception {
	Connection connection=getConnection();
	PreparedStatement preparedStatement=connection.prepareStatement("select * from book where genre=?;");
	preparedStatement.setString(1, book.getGenre());
	ResultSet result=preparedStatement.executeQuery();
	if(result.next())
	{
		System.out.println("Fetch By ID Successfully");
		System.out.println("ID : "+result.getInt("id"));
		System.out.println("Name : "+result.getString("name"));
		System.out.println("Author : "+result.getString("author"));
		System.out.println("PRICE : "+result.getString("price"));
		System.out.println("GENRE : "+result.getString("genre"));
	}
	else {
		System.out.println("Try Again");
	}
	return result;
}
//UpdateBook
public void updateBook(Book book) throws Exception {
	Connection connection=getConnection();
	PreparedStatement preparedStatement=connection.prepareStatement("update book set name=? where id=? ");
	preparedStatement.setString(1, book.getName());
	preparedStatement.setInt(2, book.getId());
	int result=preparedStatement.executeUpdate();
	if(result!=0)
	{
		System.out.println("Updated");
	}
	else {
		System.out.println("Not updated");
	}
}
public void exit() throws Exception{
	Connection connection=getConnection();
    connection.close();
    System.out.println("exitted");
	
}



 public Connection getConnection() throws Exception {
		 Class.forName("com.mysql.cj.jdbc.Driver");
		 Connection connection=DriverManager.getConnection("jdbc:mysql://localhost:3306/person","root","root");
		 return connection;
		
	
	
}


}
