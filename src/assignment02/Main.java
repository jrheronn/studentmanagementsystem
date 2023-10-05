package assignment02;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Header header = null;

        boolean fileInputted = false;

        int option;
        do {
            System.out.println("CS3353 Assignment 2 Main Menu:");
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

            option = scanner.nextInt();

            switch (option) {
                case 1:
                    // Read the input data
                    header = readInputFile();
                    fileInputted = true;
                    displayHeaderSummary(); // Display header summary
                    break;

                case 2:
                    // Delete a course
                    if (fileInputted) {
                        System.out.print("Enter the course number to delete: ");
                        String courseNumber = scanner.next(); // Get inputted course number
                        header.deleteCourse(courseNumber);
                        displayHeaderSummary(); // Display updated summary
                    } else {
                        System.out.println("Input file data first");
                    }
                    break;

                case 3:
                    // Insert a new course
                    if (fileInputted) {
                        System.out.print("Enter the new course number to add: ");
                        String courseNumber = scanner.nextLine();

                        if (!courseNumber.isEmpty()) {
                            System.out.print("Enter the new course name for " + courseNumber + ":");
                            String courseName = scanner.nextLine(); // Get inputted course name

                            header.insertCourse(courseNumber, courseName);
                            displayHeaderSummary(); // Display updated summary
                        } else {
                            System.out.println("Course number must be entered");
                        }
                    } else {
                        System.out.println("Input file data first");
                    }
                    break;

                case 4:
                    // Delete a student
                    if (fileInputted) {
                        System.out.print("Enter the student ID number to delete: ");
                        String studentID = scanner.nextLine();

                        System.out.print("Enter the course number from which the student is the be dropped from: ");
                        String courseNumber = scanner.nextLine();

                        boolean studentDeleted = header.deleteStudent(courseNumber, studentID);

                        if (studentDeleted) {
                            displayHeaderSummary();
                        } else {
                            System.out.println("Cannot locate student");
                        }
                    } else {
                        System.out.println("Input file data first");
                    }
                    break;

                case 5:
                    // Insert a new student
                    break;

                case 6:
                    // Transfer a student from one course to another
                    break;

                case 7:
                    // Display Course List
                    if (fileInputted) {
                        header.displayCourseList();
                    } else {
                        System.out.println("Input file data first");
                    }
                    break;

                case 8:
                    // Display Student List
                    if (fileInputted) {
                        System.out.print("Enter the course number: ");
                        String courseNumber = scanner.next();
                        header.displayStudentList(courseNumber);
                    } else {
                        System.out.println("Input file data first");
                    }
                    break;

                case 9:
                    System.out.println("Exiting");
                    System.exit(0);
                    break;

                default:
                    System.out.println("Invalid option. Must enter a number between 1 and 9.");


            }
        } while (option != 9);
    }

    private static Header readInputFile() {
        Header header = new Header();

        try (BufferedReader fileReader = new BufferedReader(new FileReader("inputFile_1.txt"))) {
            String line;
            boolean firstline = true;

            while ((line = fileReader.readLine()) != null) {
                // Skip the first line of inputFile_1.txt
                if (firstline) {
                    firstline = false;
                    continue;
                }

                // Split line data with tabs
                String[] categories = line.split("\t");

                if (categories.length == 6) {
                    String courseNumber = categories[0].replaceAll("\\s", ""); // Remove space in course number
                    String courseName = categories[1];
                    String studentName = categories[2];
                    String studentID = categories[3];
                    String email = categories[4];
                    String address = categories[5];

                    Courses currentCourse = header.getCourse(courseNumber);

                    if (currentCourse == null) {
                        currentCourse = new Courses(courseName, courseNumber, 0);
                        header.addCourse(currentCourse);
                    }

                    Students student = new Students(studentName, studentID, email, address);
                    currentCourse.addStudent(header, student);

                    // Increment student count for the current course
                    currentCourse.incrementStudentCount();

                }
            }
        } catch (IOException e) {
            System.out.println("Error inputting file");
        }
        return header;
    }

    private static void displayHeaderSummary () {
        Header header = new Header();
        if (header != null) {
            System.out.println("Summary of the record:");
            System.out.println("Number of courses registered: " + header.getCourseCount());
            System.out.println("Number of total students: " + header.getTotalStudentCount());
            System.out.println();
        }
    }
}
