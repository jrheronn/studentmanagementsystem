package assignment02;

import java.io.IOException;
import java.io.BufferedReader;
import java.io.FileReader;

public class DataReader {
    private String inputFile;

    public DataReader(String inputFile) {
        this.inputFile = inputFile;
    }

    // Method to read data from inputFile.txt and fill both linked lists
    public void readData(CourseDoublyLinkedList courseList, StudentSinglyLinkedList studentList) {
        try (BufferedReader reader = new BufferedReader(new FileReader(inputFile))) {
            String line;
            boolean categoriesLine = true;

            while ((line = reader.readLine()) != null) {
                if (categoriesLine) {
                    // Skip the categories line
                    categoriesLine = false;
                    continue;
                }

                String[] data = line.split("\t");

                if (data.length == 6) {
                    // Course Number, Course Name, Student Name, Student ID, Email, Address
                    String courseNumber = data[0].trim();
                    String courseName = data[1].trim();
                    String studentName = data[2].trim();
                    String studentID = data[3].trim();
                    String email = data[4].trim();
                    String address = data[5].trim();

                    // Create and fill Course Doubly Linked List
                    Course course = new Course(courseNumber, courseName);
                    courseList.addCourse(course);

                    //Create and fill the Student Singly Linked List
                    Student student = new Student(studentName, studentID, email, address);
                    studentList.addStudent(student);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
