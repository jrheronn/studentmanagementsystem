package studentmanagementsystem;

// Class to represent student info
public class Students {
    private String studentName;
    private String studentID;
    private String email;
    private String address;
    private Students next;

    public Students(String name, String studentID, String email, String address) {
        this.studentName = name;
        this.studentID = studentID;
        this.email = email;
        this.address = address;
        this.next = null;
    }

    // Getters and setters
    public String getStudentName() {
        return studentName;
    }

    public String getStudentID() {
        return studentID;
    }

    public String getEmail() {
        return email;
    }

    public String getAddress() {
        return address;
    }

    public Students getNext() {
        return next;
    }

    public void setNext(Students next) {
        this.next = next;
    }

}
