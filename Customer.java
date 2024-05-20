package libarySysytemWithMap;

import java.util.Scanner;

public class Customer {

	// customer_id - must be unique,customer_name,List<BorrowedBooks>
	// boorowedBooks - only 3 books are allowed to borrow ,
	// numberOfBorrowedBooks.
	private int customer_id;
	private String customer_Name;
	private int numberofborrowedbook;
	private String borrowed_books;

	public Customer(int customer_id, String customer_Name, int numberofborrowedbook, String borrowed_books) {
		super();
		this.customer_id = customer_id;
		this.customer_Name = customer_Name;
		this.numberofborrowedbook = numberofborrowedbook;
		this.borrowed_books = borrowed_books;
	}

	@Override
	public String toString() {
		return customer_id + " \t" + " \t" + customer_Name + " \t" + " \t" + " \t" + numberofborrowedbook + " \t"
				+ " \t" + " \t" + borrowed_books;
	}

	public int getCustomer_id() {
		return customer_id;
	}

	public void setCustomer_id(int customer_id) {

		this.customer_id = customer_id;
	}

	public String getCustomer_Name() {
		return customer_Name;
	}

	public void setCustomer_Name(String customer_Name) {
		this.customer_Name = customer_Name;
	}

	public int getNumberofborrowedbook() {
		return numberofborrowedbook;
	}

	public void setNumberofborrowedbook(int numberofborrowedbook) {
		this.numberofborrowedbook = numberofborrowedbook;
	}

	public String getBorrowed_books() {

		if (borrowed_books == null) {
			return "";
		}

		return borrowed_books;
	}

	public void setBorrowed_books(String borrowed_books) {
		this.borrowed_books = borrowed_books;
	}
	
	public static void returnBook() {
		Scanner scan = new Scanner(System.in);

		System.out.println("Enter book_id to return a book ");
		while (!scan.hasNextInt()) {
			System.out.println("Invalid Input ,Id Canot be String .");
			LibrarySystem.menu();
		}
		int bid = scan.nextInt();
		if (LibrarySystem.a.contains(bid)) {
			System.out.println("Enter Customer_Id");
			while (!scan.hasNextInt()) {
				System.out.println("Invalid Input ,Id Canot be String.");
				LibrarySystem.menu();
			}
			int cid = scan.nextInt();

			if (LibrarySystem.c.contains(cid)) {
				for (Book book : LibrarySystem.addbook.values()) {
					if (book.getBook_id() == bid) {						

							for (Customer customer : LibrarySystem.addcust.values()) {
								if (customer.getCustomer_id() == cid) {
									if (customer.getNumberofborrowedbook() ==0) {
										System.out.println("Customer Does not Borrowed any books");
										
									} else {
								    	if(customer.getBorrowed_books().contains(book.getBook_name())) {
									    	String borrowed_books = customer.getBorrowed_books().replace(book.getBook_name(), "").replace(","," ");
									    											//using the 2nd replace to remove the , iun between the string
									    	
									        customer.setBorrowed_books(borrowed_books);

									       
									        int numberOfBorrowedBooks = customer.getNumberofborrowedbook() - 1;	 // Update customer's number of borrowed books
									        customer.setNumberofborrowedbook(numberOfBorrowedBooks);

									       
									        int book_copies = book.getBook_copies() + 1; // Update book's number of copies
									        book.setBook_copies(book_copies);

									        System.out.println(customer.getCustomer_Name() + " returned the book " + book.getBook_name());
									    	}else {
									    		System.out.println("Customer does not borrowed "+book.getBook_name());
									    	}
									    }
								}
							}
						

					}
				}

				LibrarySystem.menu();
			} else {
				System.out.println("Customer Id Does Not Exits");
				LibrarySystem.menu();
			}
		} else {
			System.out.println("Book Id Does Not exits");
			LibrarySystem.menu();
		}

		scan.close();
	}
	
	
}
