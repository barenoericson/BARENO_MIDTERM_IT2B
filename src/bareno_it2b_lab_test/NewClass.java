package bareno_it2b_lab_test;

import java.util.Scanner;

public class NewClass {

    Scanner sc = new Scanner(System.in);
    config conf = new config();

    
    public void addBooks() {
        int bid = getValidBookId();
        sc.nextLine(); 

        System.out.print("Book Title: ");
        String btitle = getValidStringInput("Book Title");

        System.out.print("Author's Name: ");
        String aname = getValidStringInput("Author's Name");

        int year = getValidYear();

        System.out.print("Status: ");
        String bstat = getValidStringInput("Status");

        String sql = "INSERT INTO tbl_books (b_id, b_title, a_name, b_year, b_status) VALUES (?, ?, ?, ?, ?)";
        conf.addRecord(sql, bid, btitle, aname, year, bstat);
    }

    
    public void Updatebooks() {
        int bookId = getValidBookId();
        sc.nextLine(); 

        System.out.print("Enter new Book Title: ");
        String newTitle = getValidStringInput("Book Title");

        System.out.print("Enter new Author's Name: ");
        String newAuthor = getValidStringInput("Author's Name");

        int newYear = getValidYear();

        System.out.print("Enter new Status: ");
        String newStatus = getValidStringInput("Status");

        String sqlUpdate = "UPDATE tbl_books SET b_title = ?, a_name = ?, b_year = ?, b_status = ? WHERE b_id = ?";
        conf.updateRecord(sqlUpdate, newTitle, newAuthor, newYear, newStatus, bookId);
    }

    // Method to delete a book with validation
    public void DeleteBook() {
        int bookIdToDelete = getValidBookId();

        String sqlDelete = "DELETE FROM tbl_books WHERE b_id = ?";
        conf.deleteRecord(sqlDelete, bookIdToDelete);
    }

    
    private int getValidBookId() {
        int bid = -1;
        while (true) {
            System.out.print("Book ID (positive integer): ");
            if (sc.hasNextInt()) {
                bid = sc.nextInt();
                if (bid > 0) {
                    break;
                } else {
                    System.out.println("Invalid Book ID! Must be a positive integer.");
                }
            } else {
                System.out.println("Invalid input! Please enter a valid integer.");
                sc.next(); 
            }
        }
        return bid;
    }

   
    private int getValidYear() {
        int year = -1;
        while (true) {
            System.out.print("Year Published (positive integer): ");
            if (sc.hasNextInt()) {
                year = sc.nextInt();
                if (year > 0) {
                    break;
                } else {
                    System.out.println("Invalid Year! Must be a positive integer.");
                }
            } else {
                System.out.println("Invalid input! Please enter a valid integer.");
                sc.next(); 
            }
        }
        return year;
    }

   
    private String getValidStringInput(String fieldName) {
        String input;
        while (true) {
            input = sc.nextLine().trim();
            if (!input.isEmpty()) {
                break;
            } else {
                System.out.print(fieldName + " cannot be empty! Please enter a valid value: ");
            }
        }
        return input;
    }

    
    public void viewBooks() {
        String booksQuery = "SELECT * FROM tbl_books";
        String[] booksHeaders = {"Book ID", "Title", "Author", "Year", "Status"};
        String[] booksColumns = {"b_id", "b_title", "a_name", "b_year", "b_status"};

        conf.viewRecords(booksQuery, booksHeaders, booksColumns);
    }
}
