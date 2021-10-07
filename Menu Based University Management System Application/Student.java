
public class Student {

    private int studentId;
    private String studentName;
    private double studentCGPA;
    public static int count = 0;

    Student() {
        count++;
    }

    Student(int studentId, String studentName, double studentCGPA) {
        this.studentId = studentId;
        this.studentName = studentName;
        this.studentCGPA = studentCGPA;
        count++;

    }

    public String toString() {
        return "Id : " + this.studentId + "  Name : " + this.studentName + "  CGPA : " + this.studentCGPA;
    }

    public void setStudentId(int studentId) {
        this.studentId = studentId;
    }

    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }

    public void setStudentCGPA(double studentCGPA) {
        this.studentCGPA = studentCGPA;
    }

    public int getStudentId() {
        return this.studentId;
    }

    public String getStudentName() {
        return this.studentName;
    }

    public double getStudentCGPA() {
        return this.studentCGPA;
    }

    public static int getCount() {
        return count;
    }

    public static void deleteStudent() {
        count--;
    }

}


