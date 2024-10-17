package bareno_it2b_lab_test;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        NewClass library = new NewClass();
        Scanner sc = new Scanner(System.in);
        int choice;

        do {
            System.out.println("-----------------------------------------------------------");
            System.out.println("\n------------ Library Management System ---------------");
            System.out.println("-----------------------------------------------------------");
            
            System.out.println("1. Add Book");
            System.out.println("2. View Books");
            System.out.println("3. Update Book");
            System.out.println("4. Delete Book");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");
            choice = sc.nextInt();

            switch (choice) {
                case 1:
                    library.addBooks();
                    break;
                case 2:
                    library.viewBooks(); 
                    break;
                case 3:
                    library.Updatebooks();
                    break;
                case 4:
                    library.DeleteBook();
                    break;
                case 5:
                    System.out.println("Exiting the system...");
                    break;
                default:
                    System.out.println("Invalid choice! Please enter a valid option.");
                    break;
            }
        } while (choice != 5);
    }
}
