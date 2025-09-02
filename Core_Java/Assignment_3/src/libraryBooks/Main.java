package libraryBooks;

import java.util.Random;

public class Main {
	public static void main(String[] args) {
		Book[] myBooks = new Book[3];
		Random r = new Random();
		for(int i=0; i<myBooks.length; i++) {
			int book1 = r.nextInt(10000);
			int book2 = r.nextInt(10);
			boolean book3 = r.nextBoolean();
			int book4 = r.nextInt(10);
			myBooks[i] = new Book(book1, "Kaushik's"+book2, "AK"+book4, book3);
		}
		myBooks[1].issueBook();
		myBooks[0].availableBooks(myBooks);
	}
}
