package assignment02;
import java.io.IOException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        CourseDoublyLinkedList courseList = new CourseDoublyLinkedList();
        StudentSinglyLinkedList studentList = new StudentSinglyLinkedList();

        boolean fileInputed = false;

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
                    // Read the input data
                    if (!fileInputed) {
                        DataReader dataReader = new DataReader("inputFile_1.txt");
                        dataReader.readData(courseList, studentList);
                        fileInputed = true;
                        System.out.println("File data loaded");
                    } else {
                        System.out.println("File already loaded");
                    }
                    break;

                case 2:
                    // Delete a course
                    break;

                case 3:
                    // Insert a new course
                    break;

                case 4:
                    // Delete a student
                    break;

                case 5:
                    // Insert a new student
                    break;

                case 6:
                    // Transfer a student from one course to another
                    break;

                case 7:
                    // Display Course List
                    if (fileInputed) {
                        courseList.displayCourseList();
                    } else {
                        System.out.println("File has not been loaded");
                    }
                    break;

                case 8:
                    // Display Student List
                    break;

                case 9:
                    System.out.println("Exiting");
                    System.exit(0);
                    break;

                default:
                    System.out.println("Invalid option. Must enter a number between 1 and 9.");


            }
        }
    }
}
