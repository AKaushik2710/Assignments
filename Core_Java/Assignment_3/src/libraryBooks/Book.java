package libraryBooks;

public class Book {
	int bookId;
	String title, author;
	boolean isIssued;
	
	Book(int bookId, String title, String author, boolean isIssued){
		this.bookId = bookId;
		this.title = title;
		this.author = author;
		this.isIssued = isIssued;
	}
	
	public void issueBook() {
		this.isIssued = true;
	}
	
	public void returnBook() {
		this.isIssued = false;
	}
	
	public void availableBooks(Book[] books) {
		for(int i=0; i<books.length; i++) {
			if(!books[i].isIssued) {
				System.out.println("Book titled "+books[i].title+" and written by "+ books[i].author+"is available");
			}
		}
	}
}
