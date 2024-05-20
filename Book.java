package libarySysytemWithMap;

import java.util.*;

public class Book {

	// book_id - must be unique,book_name,book_genre,book_cost,copies.

	private int book_id;
	private String book_name;
	private String book_genre;
	private double book_cost;
	private int book_copies;

	public Book(int book_id, String book_name, String book_genre, double book_cost, int book_copies) {
		super();
		this.book_id = book_id;
		this.book_name = book_name;
		this.book_genre = book_genre;
		this.book_cost = book_cost;
		this.book_copies = book_copies;
	}

	@Override
	public String toString() {
		return book_id + " \t" + book_name + "\t" + "\t" + book_genre + "\t" + book_cost + "    \t  " + book_copies;
	}

	public int getBook_id() {
		return book_id;

	}

	public void setBook_id(int book_id) {
		this.book_id = book_id;

	}

	public String getBook_name() {
		return book_name;
	}

	public void setBook_name(String book_name) {
		this.book_name = book_name;

	}

	public String getBook_genre() {
		return book_genre;
	}

	public void setBook_genre(String book_genre) {
		this.book_genre = book_genre;

	}

	public double getBook_cost() {
		return book_cost;
	}

	public void setBook_cost(double book_cost) {
		this.book_cost = book_cost;

	}

	public int getBook_copies() {
		return book_copies;
	}

	public void setBook_copies(int book_copies) {
		this.book_copies = book_copies;
	}

	public static void issueBook() {
		Scanner scan = new Scanner(System.in);

		System.out.println("Enter book_id to issue a book ");
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
						if (book.getBook_copies() != 0) {

							for (Customer customer : LibrarySystem.addcust.values()) {
								if (customer.getCustomer_id() == cid) {
									if (customer.getNumberofborrowedbook() < 3) {

										// Adding books to customer's borrowed books
										String a = book.getBook_name();
										String borrowed_books = book.getBook_name() + ","+ customer.getBorrowed_books();//adding the old book from the customer and new book borrowed by the customer
										if (customer.getBorrowed_books().contains(a)) {
											System.out.println("book copy of " + a + " already issue by the customer");
											LibrarySystem.menu();
										} else {
											customer.setBorrowed_books(borrowed_books);

										}

										int numberOfBorrowedBooks = customer.getNumberofborrowedbook() + 1; // Update
																											// customer's
																											// number of
																											// borrowed
																											// books
										customer.setNumberofborrowedbook(numberOfBorrowedBooks);

										int book_copies = book.getBook_copies() - 1; // Update book's number of copies
										book.setBook_copies(book_copies);

										System.out.println(
												customer.getCustomer_Name() + " borrowed " + book.getBook_name());
									} else {
										System.out.println("Already has 3 books by the customer");
									}
								}
							}
						} else {
							System.out.println("Copies Not Available for the book");
							LibrarySystem.menu();
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
