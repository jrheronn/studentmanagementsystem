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

    public void incrementCourseCount(String courseNumber) {
        Courses currentCourse = head;

        while (currentCourse != null) {
            if (currentCourse.getCourseNumber().equals(courseNumber)) {
                currentCourse.incrementStudentCount();
                return;
            }
            currentCourse = currentCourse.getNext();
        }
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

    // Method to display student list for case 8
    public void displayStudentList(String courseNumber) {
        Courses currentCourse = head;
        while (currentCourse != null) {
            if (currentCourse.getCourseNumber().equals(courseNumber)) {
                System.out.println("The list of students enrolled in the course " + courseNumber + " are as follows:");
                System.out.println();
                Students enrolledStudents = currentCourse.getStudentList();
                // Student list needs to print in columns
                while (enrolledStudents != null) {

                }
            }
        }

        while ()
    }
}
