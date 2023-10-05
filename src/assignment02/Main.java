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
            // Print the menu options
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

            // Get user input
            option = scanner.nextInt();
            scanner.nextLine();

            switch (option) {
                case 1:
                    // Read the input data
                    header = readInputFile();
                    fileInputted = true;
                    displayHeaderSummary(header); // Display header summary
                    break;

                case 2:
                    // Delete a course
                    if (fileInputted) {
                        System.out.println("Input file data first");
                        break;
                    }
                    System.out.print("Enter the course number to delete: ");
                    String deleteCourseNumber = scanner.next(); // Get inputted course number
                    header.deleteCourse(deleteCourseNumber);
                    displayHeaderSummary(header); // Display updated summary
                    break;

                case 3:
                    // Insert a new course
                    if (!fileInputted) {
                        System.out.println("Input file data first");
                        break;
                    }
                    System.out.print("Enter the new course number to add: ");
                    String newCourseNumber = scanner.nextLine();

                    if (!newCourseNumber.isEmpty()) {
                        System.out.print("Enter the new course name for " + newCourseNumber + ":");
                        String newCourseName = scanner.nextLine(); // Get inputted course name

                        if (!newCourseName.isEmpty()) {
                            assert header != null;
                            header.insertCourse(newCourseNumber, newCourseName);
                            displayHeaderSummary(header); // Display updated summary
                        } else {
                            System.out.println("Course name must not be empty");
                        }
                    } else {
                        System.out.println("Course number must be entered");
                    }
                    break;

                case 4:
                    // Delete a student
                    if (!fileInputted) {
                        System.out.println("Input file data first");
                        break;
                    }

                    System.out.print("Enter the student ID number to delete: ");
                    String studentID = scanner.nextLine();

                    System.out.print("Enter the course number from which the student is the be dropped from: ");
                    String courseNumber = scanner.nextLine();

                    boolean studentDeleted = header.deleteStudent(courseNumber, studentID);

                    if (studentDeleted) {
                        displayHeaderSummary(header);
                    } else {
                        System.out.println("Cannot locate student");
                    }

                    break;

                case 5:
                    // Insert a new student
                    if (!fileInputted) {
                        System.out.println("Input file data first");
                        break;
                    }
                    // Get course number to enroll student
                    System.out.print("Enter the course number the student wants to enroll to: ");
                    String courseNumberToEnroll = scanner.nextLine();

                    // Check if the course exist
                    if (header.getCourse(courseNumberToEnroll) != null) {
                        // Get the student's information
                        System.out.print("Enter the student's name: ");
                        String studentNameEnroll = scanner.nextLine();
                        System.out.print("Enter the student's ID: ");
                        String studentIDEnroll = scanner.nextLine();
                        System.out.print("Enter the student's email");
                        String studentEmailEnroll = scanner.nextLine();
                        System.out.print("Enter the student's emergency contact address: ");
                        String studentAddressEnroll = scanner.nextLine();

                        //Add the student to course
                        header.addStudentToCourse(courseNumberToEnroll, studentNameEnroll, studentIDEnroll, studentEmailEnroll, studentAddressEnroll);

                        // Display updated summary
                        displayHeaderSummary(header);
                    }

                    break;

                case 6:
                    // Transfer a student from one course to another
                    if (!fileInputted) {
                        System.out.println("Input file data first");
                        break;
                    }
                    // Ask for student's name
                    System.out.print("Enter the student's name:");
                    String studentName = scanner.nextLine();

                    // Ask for the course to drop
                    System.out.print("Enter the course number the student wants to drop from:");
                    String droppedCourseNumber = scanner.nextLine();
                    // Find the course from the course number
                    Courses droppedCourse = header.getCourse(droppedCourseNumber);

                    if (droppedCourse != null) {
                        // Locate the student in the dropped course
                        Students transferStudent = droppedCourse.findStudentName(studentName);

                        if (transferStudent != null) {
                            // Ask for the course to add
                            System.out.print("Enter the course number the student wants to enroll in:");
                            String addedCourseNumber = scanner.nextLine();

                            Courses addedCourse = header.getCourse(addedCourseNumber);

                            if (addedCourse != null) {
                                // Remove student from the dropped course
                                droppedCourse.removeStudent(String.valueOf(transferStudent));
                                // Add student to new course
                                addedCourse.addStudent(transferStudent);

                                // Display updated header summary information
                                displayHeaderSummary(header);
                            } else {
                                System.out.println("New course not found");
                            }
                        } else {
                            System.out.println("Student not found in the dropped course");
                        }
                    } else {
                        System.out.println("Dropped course not found");
                    }
                    break;

                case 7:
                    // Display Course List
                    if (!fileInputted) {
                        System.out.println("Input file data first");
                        break;
                    }
                    header.displayCourseList();
                    break;

                case 8:
                    // Display Student List
                    if (!fileInputted) {
                        System.out.println("Input file data first");
                        break;
                    }
                    System.out.print("Enter the course number: ");
                    String courseNumberStudentList = scanner.next();
                    header.displayStudentList(courseNumberStudentList);
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
                    currentCourse.addStudentReader(header, student);

                    // Increment student count for the current course
                    currentCourse.incrementStudentCount();

                }
            }
        } catch (IOException e) {
            System.out.println("Error inputting file");
        }
        return header;
    }

    private static void displayHeaderSummary (Header header) {
        if (header != null) {
            System.out.println("Summary of the record:");
            System.out.println("Number of courses registered: " + header.getCourseCount());
            System.out.println("Number of total students: " + header.getTotalStudentCount());
            System.out.println();
        }
    }
}
