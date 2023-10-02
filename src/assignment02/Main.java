package assignment02;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("CS 3353 Assignment 2 Main Menu:");
            System.out.println("1. Read the input data");
            System.out.println("2. Delete a course");
            System.out.println("3. Insert a new course");
            System.out.println("4. Delete a student");
            System.out.println("5. Insert a new student");
            System.out.println("6. Transfer a student from one course to another");
            System.out.println("7. Display the course list");
            System.out.println("8. Display the student list");
            System.out.println("9. Exit");
            System.out.print("Enter your option: ");

            int option = scanner.nextInt();

            switch (option) {
                case 1:
                    break;

                case 2:
                    break;

                case 3:
                    break;

                case 4:

                    break;

                case 5:
                    break;

                case 6:

                    break;

                case 7:
                    break;

                case 8:
                    break;

                case 9:
                    break;

                default:
                    System.out.println("Invalid option. Must enter a number between 1 and 9.");


            }
        }
    }
}
