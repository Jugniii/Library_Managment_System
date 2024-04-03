package library;

import java.util.Scanner;

public class WelcomeLogin {
public static void main(String[] args) throws Exception {
	Scanner scanner=new Scanner(System.in);
	
	System.out.println("Welcome user!!!\n1.SignUp person \n2.Login person \n3.bookAdd \n4.bookDelete \n5.bookFetchById \n6.BookFetchByName \n7.BookFetchByAuthor \n8.BookFetchGenre \n9.UpdateBook \n10.exit");
	User ref=new User();
	Book book=new Book();
	UserConnection ref1= new UserConnection();
	LoginConnection ref2=new LoginConnection();
	
	
	switch(scanner.nextInt()) {
	case 1:{
		System.out.println("Enter the id");
		int id=scanner.nextInt();
		
		System.out.println("Enter the name");
		String name=scanner.next();
		
		System.out.println("Enter the phone");
		Long phone=scanner.nextLong();
		
		System.out.println("Enter the email");
		String email=scanner.next();
		
		System.out.println("Enter the password");
		String password=scanner.next();
		
		ref.setId(id);
		ref.setName(name);
		ref.setPhone(phone);
		ref.setEmail(email);
		ref.setPassword(password);
		ref1.signUp(ref);
		
		
	}
	   break;
	case 2:
	{
		
		System.out.println("Enter the email");
		String email=scanner.next();
		
		System.out.println("Enter the password");
		String password=scanner.next();
		
		ref.setEmail(email);
		ref.setPassword(password);
		
		ref2.login(ref);
	
	}
	break;
	case 3:{
		System.out.println("Enter the id");
		int id=scanner.nextInt();
		
		System.out.println("Enter the name");
		String name=scanner.next();
		
		System.out.println("Enter the author");
		String author=scanner.next();
		
		System.out.println("Enter the price");
        double price=scanner.nextDouble();
        
        System.out.println("Enter the genre");
		String genre=scanner.next();
		
		book.setId(id);
		book.setName(name);
		book.setAuthor(author);
		book.setPrice(price);
		book.setGenre(genre);
		ref2.bookAdd(book);
	}
	break;
	case 4:{
		System.out.println("Enter the id");
		int id=scanner.nextInt();
		
		book.setId(id);
		ref2.bookDelete(book);
	}
	break;
	case 5:{
		System.out.println("Enter the id");
		int id=scanner.nextInt();
		
		book.setId(id);
		ref2.bookFetchById(book);
	}
	break;
	case 6:{
		System.out.println("Enter the name");
		String name=scanner.next();
		
		book.setName(name);
		ref2.bookFetchByName(book);
	}
	break;
	case 7:{
		System.out.println("Enter the author");
		String author=scanner.next();
		
		book.setAuthor(author);
		ref2.bookFetchByAuthor(book);
	}
	break;
	case 8:{
		 System.out.println("Enter the genre");
			String genre=scanner.next();
			
			book.setGenre(genre);
			ref2.bookFetchByGenre(book);
	}
	break;
	case 9:{
		System.out.println("Enter the id");
		int id=scanner.nextInt();
		
		System.out.println("Enter the name");
		String name=scanner.next();
		
		book.setId(id);
		book.setName(name);
		ref2.updateBook(book);
	}
	break;
	 default:
		 
		 break;

}
}}
