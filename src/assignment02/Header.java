package assignment02;

import java.util.LinkedList;

// Header class for Course doubly linked list
public class Header {
    private int courseCount;
    private int totalStudentCount;
    private Courses head;
    private Courses tail;

    public Header() {
        this.courseCount = 0;
        this.totalStudentCount = 0;
        this.head = null;
        this.tail = null;
    }

    // Getters and setters
    public int getCourseCount() {
        return courseCount;
    }

    public int getTotalStudentCount() {
        return totalStudentCount;
    }

    public Courses getHead() {
        return head;
    }

    public Courses getTail() {
        return tail;
    }

    public Courses getCourse(String courseNumber) {
        Courses currentCourse = head;
        while (currentCourse != null) {
            if (currentCourse.getCourseNumber().equals(courseNumber)) {
                return currentCourse; // Course exist
            }
            currentCourse = currentCourse.getNext();
        }
        return null; // course does not exist
    }

    public void incrementTotalStudentCount() {
        totalStudentCount++;
    }

    public void incrementCourseCount() {
        courseCount++;
    }

    public void addCourse(Courses course) {
        // Check for same course number
        Courses existingCourse = getCourse(course.getCourseNumber());

        if(existingCourse != null) {
            // update student count if course exist
            existingCourse.incrementStudentCount();
        } else {
            // Add new course to list
            if (head == null) {
                // Create list if empty
                head = course;
                tail = course;
            } else {
                // Add course to the end of the list
                tail.setNext(course);
                course.setPrevious(tail);
                tail = course;
            }
            courseCount++;
        }
    }

    // Method for case 8 to display the course list
    public void displayCourseList() {
        Courses currentCourse = head;

        System.out.println("The list of courses registered are as follows:");
        while (currentCourse != null) {
            System.out.println("Course Number " + currentCourse.getCourseNumber());
            System.out.println("Course Name " + currentCourse.getCourseName());
            System.out.println("Number of students enrolled: " + currentCourse.getStudentCount());
            System.out.println();

            currentCourse = currentCourse.getNext();
        }
    }
    // Case 2 Method to delete a course
    public void deleteCourse(String courseNumber) {
        Courses currentCourse = head;
        Courses previousCourse = null;

        // Locate the course in the doubly linked list
        while (currentCourse != null) {
            // Check if enter course number matches
            if (currentCourse.getCourseNumber().equals(courseNumber)) {
                // Move next to not point to this course
                if (previousCourse != null) {
                    previousCourse.setNext(currentCourse.getNext());
                } else {
                    // If first in the list update head to point to the next one
                    head = currentCourse.getNext();
                }
                // Decrement the course count
                decrementCourseCount();
                return;
            }
            previousCourse = currentCourse;
            currentCourse = currentCourse.getNext();
        }
        System.out.println("Course does not exist"); // Display if the course number is not found
    }

    private void decrementCourseCount() {
        courseCount--;
    }

    public void insertCourse(String courseNumber, String courseName) {
        Courses course = new Courses(courseNumber, courseName, 0);

        if (head != null) {
            tail.setNext(course);
            course.setPrevious(tail);
            tail = course;
        }
        // Increment the course count
        incrementCourseCount();


    }

    public boolean deleteStudent(String courseNumber, String studentID) {
        // Locate course from course number
        Courses course = getCourse(courseNumber);

        if (course != null) {
            // Remove student from the course's student list
            return course.removeStudent(studentID);
        }
        return false;
    }

    // Method for case 5 for adding student to a course
    public void addStudentToCourse(String courseNumberToEnroll, String studentNameEnroll, String studentIDEnroll, String studentEmailEnroll, String studentAddressEnroll) {
        // Locate course
        Courses course = getCourse(courseNumberToEnroll);

        // If the course exist
        if (course != null) {
            // Create new Student
            Students student = new Students(studentNameEnroll, studentIDEnroll, studentEmailEnroll, studentAddressEnroll);

            // Add the student to the course's student list
            course.addStudent(student);

            course.incrementStudentCount();

            totalStudentCount++;
        } else {
            System.out.println("Course not found");
        }

    }
}
