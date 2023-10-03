package assignment02;

import java.io.IOException;
import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;

public class DataReader {
    private String inputFile;

    public DataReader(String inputFile) {
        this.inputFile = inputFile;
    }

    public ArrayList<Course> readCourses() throws IOException {
        ArrayList<Course> courses = new ArrayList<>();

        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(inputFile))) {
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                if (line.startsWith("Course Number")) {
                    continue;
                }
                String[] categories = line.split("\t");

                // Checks if the line has both Course Number and Course Name
                if (categories.length >= 2) {
                    String courseNumber = categories[0].trim();
                    String courseName = categories[1].trim();

                    Course course = new Course(courseNumber, courseName);
                    courses.add(course);
                }
            }
        }

        return courses;
    }

    public ArrayList<Student> readStudents() throws IOException {
        ArrayList<Student> students = new ArrayList<>();

        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(inputFile))) {
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                if (line.startsWith("Course Number")) {
                    continue;
                }
                String[] categories = line.split("\t");

                if (categories.length >= 6) {
                    String studentName = categories[2].trim();
                    String studentID = categories[3].trim();
                    String email = categories[4].trim();
                    String address = categories[5].trim();

                    Student student = new Student(studentName, studentID, email, address);
                    students.add(student);
                }
            }
        }
        return students;
    }
}
