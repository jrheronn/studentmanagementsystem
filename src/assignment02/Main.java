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

        while (true) {
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

            int option = scanner.nextInt();

            switch (option) {
                case 1:
                    // Read the input data
                    header = readInputFile();
                    fileInputted = true;
                    displayHeaderSummary(header);
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
                    if (fileInputted) {
                        displayCourseList(header);
                    } else {
                        System.out.println("Input file data first");
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

    private static void displayCourseList(Header header) {
        Courses currentCourse = header.getHead();
        if (currentCourse == null) {
            System.out.println("No courses");
            return;
        }

        System.out.println("The list of courses registered are as follows:");
        while (currentCourse != null) {
            System.out.println("Course Number " + currentCourse.getCourseNumber());
            System.out.println("Course Name " + currentCourse.getCourseName());
            System.out.println("Number of students enrolled: " + currentCourse.getStudentCount());
            System.out.println();

            currentCourse = currentCourse.getNext();
        }
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
                    String courseNumber = categories[0];
                    String courseName = categories[1];
                    String studentName = categories[2];
                    String studentID = categories[3];
                    String email = categories[4];
                    String address = categories[5];

                    Courses currentCourse = header.getCourse(courseNumber);

                    if (currentCourse == null) {
                        currentCourse = new Courses(courseNumber, courseName, 0);
                        header.addCourse(currentCourse);
                    }

                    Students student = new Students(studentName, studentID, email, address);
                    currentCourse.addStudent(student);

                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return header;
    }

    private static void displayHeaderSummary (Header header) {
        if (header != null) {
            System.out.println("Summary of the record:");
            System.out.println("Number of courses registered: " + header.getCourseCount());
            System.out.println("Number of total students: " + header.getTotalStudentCount());
        }
    }
}
