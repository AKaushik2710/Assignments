package libraryManagementSystemUsingJDBC;
import java.sql.Statement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Scanner;
public class Library_Menu {
	static Book_Schema bs = new Book_Schema();
	static Connection con = bs.useDB("library_db", "books");
	static int bookId=getNewBookId();
	static int getNewBookId() {
	    try {
	        Statement s = con.createStatement();
	        String query = "SELECT id FROM books ORDER BY id DESC LIMIT 1";
	        ResultSet rs = s.executeQuery(query);
	        if (rs.next()) {
	            return rs.getInt("id") + 1;
	        } else {
	            return 1001; 
	        }
	    } catch (Exception e) {
	        System.out.println(e);
	    }
	    return -1;
	}

	void insertData(Scanner sc) {
		String title, author;
		int quantity;
		float price;
		try {
			sc.nextLine();
			System.out.println("Enter the book's title:");
			title = sc.nextLine();
			System.out.println("Enter the book's author name:");
			author = sc.nextLine();
			System.out.println("Enter the book's price:");
			price = sc.nextFloat();
			System.out.println("Enter the book's quantity:");
			quantity = sc.nextInt();
			
			String query = "INSERT INTO books VALUES (?,?,?,?,?)";
			PreparedStatement ps = con.prepareStatement(query);
			ps.setInt(1, bookId);
			bookId++;
			ps.setString(2, title);
			ps.setString(3, author);
			ps.setFloat(4, price);
			ps.setInt(5, quantity);
			
			ps.executeUpdate();
			System.out.println("Records got inserted.");
		}
		catch(Exception e) {
			System.out.println(e);
		}
	}
	
	void retrieveData() {
		try {
			Statement s = con.createStatement();
			String query = "SELECT * FROM books";
			ResultSet rs = s.executeQuery(query);
			
			while(rs.next()) {
				System.out.println("Book Id is:"+rs.getInt("id")
				+"Title is:"+rs.getString("title")
				+"Author is:"+rs.getString("author")
				+"Price is:"+rs.getFloat("price")
				+"Quantity is:"+rs.getInt("quantity"));
			}
		}
		catch(Exception e) {
			System.out.println(e);
		}
	}
	
	void retrieveSingleData(Scanner sc) {
		try {
			String query = "SELECT * FROM books WHERE id=?";
			PreparedStatement ps = con.prepareStatement(query);
			System.out.println("Enter the book id whose data you want to retrieve:");
			ps.setInt(1, sc.nextInt());
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()) {
				System.out.println("Book Id is:"+rs.getInt("id")
				+"Title is:"+rs.getString("title")
				+"Author is:"+rs.getString("author")
				+"Price is:"+rs.getFloat("price")
				+"Quantity is:"+rs.getInt("quantity"));
			}
		}
		catch(Exception e) {
			System.out.println(e);
		}
	}
	void updateData(Scanner sc) {
		boolean exit = false;
		int id;
		String query;
		PreparedStatement ps;
		try {
			while(!exit) {
				System.out.println("Enter the Book Id you want to update data of:");
				id = sc.nextInt();
				System.out.println("What would you like to update:\n"
					+ "1.)Title\t\t2.)Author\n"
					+ "3.)Price\t\t4.)Quantity\n"
					+ "\t\t5.)Exit");
				switch(sc.nextInt()) {
					case 1:
						query = "UPDATE books SET title="+"? WHERE id=?";
						ps = con.prepareStatement(query);
						System.out.println("Enter the new title:");
						sc.nextLine();
						ps.setString(1, sc.nextLine());
						ps.setInt(2, id);
						ps.executeUpdate();
						System.out.println("Record Updated");
						break;
					case 2:
						query = "UPDATE books SET author="+"? WHERE id=?";
						ps = con.prepareStatement(query);
						System.out.println("Enter the new author:");
						sc.nextLine();
						ps.setString(1, sc.nextLine());
						ps.setInt(2, id);
						ps.executeUpdate();
						System.out.println("Record Updated");
						break;
					case 3:
						query = "UPDATE books SET price="+"? WHERE id=?";
						ps = con.prepareStatement(query);
						System.out.println("Enter the new price:");
						ps.setFloat(1, sc.nextFloat());
						ps.setInt(2, id);
						ps.executeUpdate();
						System.out.println("Record Updated");
						break;
					case 4:
						query = "UPDATE books SET quantity="+"? WHERE id=?";
						ps = con.prepareStatement(query);
						System.out.println("Enter the new quantity:");
						ps.setInt(1, sc.nextInt());
						ps.setInt(2, id);
						ps.executeUpdate();
						System.out.println("Record Updated");
						break;
					case 5:
						exit = true;
						break;
				}
			}
		}
		catch(Exception e) {
			System.out.println(e);
		}
	}
	
	void deleteData(Scanner sc) {
		try {
			System.out.println("Enter the book id you want to delete:");
			String query = "DELETE FROM books WHERE id=?";
			PreparedStatement ps = con.prepareStatement(query);
			ps.setInt(1, sc.nextInt());
			ps.executeUpdate();
			System.out.println("Record Deleted Successfully");
		}
		catch(Exception e) {
			System.out.println(e);
		}
	}
	
	void checkAvailability(int id, int requiredQty) {
		try {
			String query = "SELECT * FROM books WHERE id=?";
			PreparedStatement ps = con.prepareStatement(query);
			ps.setInt(1, id);
			ResultSet res = ps.executeQuery();
			
			while(res.next()) {
				int reqQuantity = res.getInt("quantity");
				if(reqQuantity >= requiredQty) System.out.println("Book issued successfully");
				else System.out.println("Insufficient stock");
			}
		}
		catch(Exception e) {
			System.out.println(e);
		}
	}
	
	public static void main(String[] args) {
		Library_Menu lm = new Library_Menu();
		Scanner sc = new Scanner(System.in);
		boolean looping = true;
		while(looping) {
			System.out.println("What operationn would  you like to perform:\n"
					+ "1.)Add Book\t\t2.)View All Books\n"
					+ "3.)Search Book By ID\t4.)Update Book\n"
					+ "5.)Delete Book\t\t6.)Check Availability\n"
					+ "\t\t\t7.)Exit");
			switch(sc.nextInt()) {
				case 1:
					lm.insertData(sc);
					break;
				case 2:
					lm.retrieveData();
					break;
				case 3:
					lm.retrieveSingleData(sc);
					break;
				case 4:
					lm.updateData(sc);
					break;
				case 5:
					lm.deleteData(sc);
					break;
				case 6:
					System.out.println("Enter the book id:");
					int checkId = sc.nextInt();
					System.out.println("Enter the quantity you require:");
					int checkQuant = sc.nextInt();
					lm.checkAvailability(checkId, checkQuant);
					break;
				case 7:
					looping = false;
					break;
				default:
					System.out.println("Invalid choice");
			}
		}
	}
}
