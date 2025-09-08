package hashmap;
import java.util.HashMap;
import java.util.Map;
public class LibraryManagementSystem {
	public static void main(String[] args) {
		Book b1 = new Book(1001, "Two Strangers", "Richard Frank", 450.50);
		Book b2 = new Book(1002, "And then there were none", "Agatha Christie", 200.99);
		Book b3 = new Book(1003, "The new era", "James Kwick", 350.70);
		Book b4 = new Book(1004, "My life lied", "William Penny", 340);
		
		HashMap<Integer, Book> library = new HashMap<>();
		library.put(b1.bookId, b1);
		library.put(b2.bookId, b2);
		library.put(b3.bookId, b3);
		library.put(b4.bookId, b4);
		
		System.out.println("The book you refered to is "+library.get(1002));
		
//		Does a given key exists
		String keyExistence = library.containsKey(1001) ? "exists" : "does not exist";
		System.out.println("This book "+keyExistence);
		
//		Does a given value exists
		String valExistence = library.containsValue(b3) ? "exists" : "does not exist";
		System.out.println("The given book "+valExistence);
		
//		Size of library having number of books
		System.out.println("The number of books present in the library is "+library.size());
		
		for(Map.Entry<Integer, Book> myEntry : library.entrySet()) {
			System.out.println("Book id is "+myEntry.getKey()+", and Books title is "+myEntry.getValue().title+", author is "+myEntry.getValue().author+", and price is "+myEntry.getValue().price);
		}
		
		for(Integer i : library.keySet()) {
			System.out.println(library.get(i));
		}
		
		b4.price+=345;
		library.replace(b4.bookId, b4);
		for(Map.Entry<Integer, Book> myEntry : library.entrySet()) {
			System.out.println("Book id is "+myEntry.getKey()+", and Books title is "+myEntry.getValue().title+", author is "+myEntry.getValue().author+", and price is "+myEntry.getValue().price);
		}
		library.clear();
		
		String emptiness  = library.isEmpty() ? "empty" : "not empty";
		System.out.println("The collection is "+emptiness);
	}
}
