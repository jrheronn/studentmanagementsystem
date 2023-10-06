package assignment02;

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

    public String getStudentName() {
        return studentName;
    }

    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }

    public String getStudentID() {
        return studentID;
    }

    public void getStudentID(String studentID) {
        this.studentID = studentID;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Students getNext() {
        return next;
    }

    public void setNext(Students next) {
        this.next = next;
    }

}
