package hashmap;

public class Book {
	int bookId;
	String title, author;
	double price;
	Book(int id, String title, String author, double price){
		this.bookId = id;
		this.title = title;
		this.author = author;
		this.price = price;
	}
	
	@Override
	public String toString() {
		return "Book title is "+this.title + ", author is "+this.author+", price  is "+this.price;
	}
}
