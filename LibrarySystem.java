package libarySysytemWithMap;

import java.util.*;

public class LibrarySystem {

	static HashMap<Integer, Book> addbook = new HashMap<Integer, Book>();// for book
	static Map<Integer, Customer> addcust = new TreeMap<Integer, Customer>();// for customer
	static Set<Integer> c; // for to store customer id and validate
	static Set<Integer> a; // for store book id and validate the ids

	public static int menu() {
		Scanner scan = new Scanner(System.in);
		Collection<Book> lt;// list for display the books
		Collection<Customer> clt;// list for display the customers

		System.out.println("\n***  CUI menu  ***\n" + "\n1.add a book.\n" + "2.add a customer\n" + "3.View all books\n"
				+ "4.View all customers\n" + "5.issue the book\n" + "6.return a book\n" + "7. exit");
		System.out.print("Enter a option : ");

		while (!scan.hasNextInt()) {
			System.out.println("Invalid input, please enter an integer.");
			scan.next();
		}

		int option = scan.nextInt();
		// Scanner scan=new Scanner(System.in);
		if (option <= 1 || option <= 7) {
			if (option == 1) {
				addBook();
			} else if (option == 2) {
				System.out.println("Customer data");
				addcustomer();
				menu();
			} else if (option == 3) {
				System.out.println("View The Books In the Liabrary");

				lt = addbook.values();
				System.out.println("Book_Id\tBook_Name  Book_Genre  Book_Cost Book_Copies");
				for (Book bb : lt) {
					System.out.println(bb);
				}

				menu();
			} else if (option == 4) {
				System.out.println("View All The Customer");
				clt = addcust.values();
				System.out.println("Customer_id  Customer_name  Customer_NumberofBorrowedBookd  Customerborrowedbooks");
				for (Customer cc : clt) {
					System.out.println(cc);
				}

				System.out.println();
				menu();
			} else if (option == 5) {
				System.out.println();

				Book.issueBook();

				menu();

			} else if (option == 6) {
				Customer.returnBook();
				menu();

			} else if (option == 7) {
				
				exit();

			} else if (option == 0) {
				System.out.println("Invalid Input option should be from 1 - 7");
				menu();
			}
		} if(option>7) {
			System.out.println("You Have Entered Out of option " + option + " option should be from 1 - 7");
			menu();
		}

		scan.close();
		return 0;
	}

	public static void addBook() {
		Scanner scan = new Scanner(System.in);
	

		System.out.print("Enter a Book Id : ");
		while (!scan.hasNextInt()) {
			System.out.println("Invalid input, please enter an integer.");
			menu();
		}
		int id = scan.nextInt();

		a = addbook.keySet();
		if (a.contains(id)) {
			System.out.println("Book Id already exists");
			menu(); // exit the method if the book ID already exists
		}

		System.out.print("Enter A book name : ");
		while (!scan.hasNext("[a-zA-Z/d]+")) { // need to check that the integer is not taking as input
			System.out.println("Invalid input, please enter a String.");
			scan.next();
		}
		String name = scan.next();

		System.out.print("Enter Book genre : ");
		while (!scan.hasNext("[a-zA-Z/d]+")) { // need to check that the integer is not taking as input
			System.out.println("Invalid input, please enter a String.");
			scan.next();
		}
		String genre = scan.next();

		System.out.print("Enter book cost : ");
		while (!scan.hasNextDouble()) {
			System.out.println("Invalid input, please enter an integer or Double.");
			scan.next();
		}
		double cost = scan.nextDouble();

		System.out.print("Enter book Copies : ");
		while (!scan.hasNextInt()) {
			System.out.println("Invalid input, please enter an integer.");
			scan.next();
		}
		int copies = scan.nextInt();

		Book book = new Book(id, genre, genre, cost, copies);
		book.setBook_id(id); // {
		book.setBook_name(name);
		book.setBook_genre(genre); // setting the value in get set
		book.setBook_cost(cost);
		book.setBook_copies(copies); // }
		addbook.put(book.getBook_id(), book); // adding the values to the map

		menu();
		scan.close();
	}

	public static void addcustomer() {
		Scanner scan = new Scanner(System.in);

		System.out.print("Enter a Customer Id : ");
		while (!scan.hasNextInt()) {
			System.out.println("Invalid input, please enter an integer.");
			menu();
		}
		int id = scan.nextInt();

		c = addcust.keySet();

		if (c.contains(id)) {
			System.out.println("Customer Id already exists");
			
			menu(); // exit the method if the book ID already exists
		}

		System.out.print("Enter A customer name : ");
		while (!scan.hasNext("[a-zA-Z/d]+")) { // need to check that the integer is not taking as input
			System.out.println("Invalid input, please enter a String.");
			scan.next();
		}
		String name = scan.next();
		String borrowed_books = null;
		int numberofborrowedbook = 0;

		Customer cust = new Customer(id, name, numberofborrowedbook, borrowed_books);
		cust.setCustomer_id(id);
		cust.setCustomer_Name(name); // adding the values in setters
		cust.setBorrowed_books(borrowed_books);
		cust.setNumberofborrowedbook(numberofborrowedbook);
		addcust.put(cust.getCustomer_id(), cust); // adding the values in the map

		menu();
		scan.close();
	}
	
	public static void exit() {
		System.out.println("***\tThank You\t***");
	}

	public static void main(String[] args) {
		menu();
		
	}

}
