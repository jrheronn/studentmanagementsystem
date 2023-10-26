package studentmanagementsystem;

// Class for course
public class Courses {
    private String courseName;
    private String courseNumber;
    private int studentCount;
    private Courses previous;
    private Courses next;
    private Students studentList;

    public Courses(String courseName, String courseNumber, int studentCount) {
        this.courseName = courseName;
        this.courseNumber = courseNumber;
        this.studentCount = studentCount;
        this.previous = null;
        this.next = null;
        this.studentList = null;
    }

    // Get course name
    public String getCourseName() {
        return courseName;
    }

    // Get course number
    public String getCourseNumber() {
        return courseNumber;
    }

    // Get student count.
    public int getStudentCount() {
        return studentCount;
    }

    // Set previous node
    public void setPrevious(Courses previous) {
        this.previous = previous;
    }

    // Get next course in doubly linked list
    public Courses getNext() {
        return next;
    }

    // Set next course node in doubly linked list
    public void setNext(Courses next) {
        this.next = next;
    }

    // Add student when reading the input file
    public void addStudentReader(Header header, Students student) {
        if (student == null) {
            return;
        }
        if (studentList == null) {
            // Create list if list is empty
            studentList = student;
        } else {
            // Find last node
            Students currentStudent = studentList;
            while(currentStudent.getNext() != null) {
                currentStudent = currentStudent.getNext();
            }
            // Add new student to list
            currentStudent.setNext(student);
        }
        // Increment student count for course
        studentCount++;

        // Increment total student count
        header.incrementTotalStudentCount();
    }

    // Increment student count by one
    public void incrementStudentCount() {
        studentCount++;
    }

    // Student removed from course
    public boolean removeStudent(String studentID) {
        Students current = studentList;
        Students previous = null;

        while (current != null) {
            if (current.getStudentID().equals(studentID)) {
                // Remove student from course list
                if (previous != null) {
                    previous.setNext(current.getNext());
                } else {
                    studentList = current.getNext();
                }
                return true; // Student removed from course
            }
            previous = current;
            current = current.getNext();
        }
        return false; // Student ID not found
    }

    // Method to add student to an existing course
    public void addStudent(Students student) {
        if (student == null) {
            // Create student list if this is the first student
            studentList = student;
        } else {
            // Else, add student to the existing list
            Students currentStudent = studentList;
            while (currentStudent.getNext() != null) {
                currentStudent = currentStudent.getNext();
            }
            currentStudent.setNext(student);
        }
    }

    // Locate student by student name
    public Students findStudentName(String studentName) {
        Students student = studentList;

        while (student != null) {
            if (student.getStudentName().equalsIgnoreCase(studentName)) {
                // Look if student's name matches
                return student;
            }
            student = student.getNext();
        }
        return null; // Student not found
    }

    // Case 8 to display the student list for a specific course
    public void displayCoursesStudentList() {
        Students currentStudent = studentList;
        System.out.println("The list of students enrolled in the course " + courseNumber + " are as follows:");
        System.out.println();

        if (studentList == null) {
            // Print if student list is empty
            System.out.println("No students enrolled in this course.");
        }

        // Print the column header
        System.out.printf("%-15s %-30s %-25s %-50s \n", "Student's ID", "Student's Name", "Email", "Address");

        while (currentStudent != null) {
            // Print the student list to align with the header
            System.out.printf("%-15s %-30s %-25s %-50s \n",
                    currentStudent.getStudentID(),
                    currentStudent.getStudentName(),
                    currentStudent.getEmail(),
                    currentStudent.getAddress()
                    );
            // Get next student
            currentStudent = currentStudent.getNext();
        }
    }
}
