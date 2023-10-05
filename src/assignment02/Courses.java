package assignment02;

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

    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }
    public String getCourseNumber() {
        return courseNumber;
    }

    public void setCourseNumber(String courseNumber) {
        this.courseNumber = getCourseNumber();
    }

    public int getStudentCount() {
        return studentCount;
    }

    public void setStudentCount(int studentCount) {
        this.studentCount = studentCount;
    }

    public Courses getPrevious() {
        return previous;
    }

    public void setPrevious(Courses previous) {
        this.previous = previous;
    }

    public Courses getNext() {
        return next;
    }

    public void setNext(Courses next) {
        this.next = next;
    }

    public Students getStudentList() {
        return studentList;
    }

    public void setStudentList(Students studentList) {
        this.studentList = studentList;
    }

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

    public void incrementStudentCount() {
        studentCount++;
    }

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
}
