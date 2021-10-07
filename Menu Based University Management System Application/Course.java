
public class Course {

    private String courseId;
    private String courseTitle;
    private double credit;
    private Student[] studentList = new Student[40];
    private int numberOfStudents = 0;
    private Faculty faculty;
    public static int count = 0;

    Course() {
        count++;
    }

    Course(String courseId, String courseTitle, double credit) {
        this.courseId = courseId;
        this.courseTitle = courseTitle;
        this.credit = credit;
        count++;
    }

    public String toString() {
        return "Id : " + this.courseId + "  Title : " + this.courseTitle + "  Credit : " + this.credit;
    }

    public void addStudent(Student s) {
        this.studentList[this.numberOfStudents] = s;
        this.numberOfStudents++;
    }

    public void dropStudent(int sid) {
        boolean found = false;
        int index = 0;
        for (int i = 0; i < this.numberOfStudents; i++) {
            if (studentList[i].getStudentId() == sid) {
                found = true;
                index = i;
                break;
            }
        }
        if (found == true) {
            for (int j = index + 1; j < numberOfStudents; j++) {
                studentList[j - 1] = studentList[j];
            }
            studentList[numberOfStudents - 1] = null;
            numberOfStudents--;
        }
    }

    public void addFaculty(Faculty f) {
        this.faculty = f;
    }

    public void dropFaculty() {
        this.faculty = null;
    }

    public void printStudentList() {
        for (int i = 0; i < this.numberOfStudents; i++) {
            System.out.println(studentList[i].toString());
        }
    }

    public void setCourseId(String courseId) {
        this.courseId = courseId;
    }

    public void setCourseTitle(String courseTitle) {
        this.courseTitle = courseTitle;
    }

    public void setCredit(double credit) {
        this.credit = credit;
    }

    public void setFaculty(Faculty faculty) {
        this.faculty = faculty;
    }

    public String getCourseId() {
        return this.courseId;
    }

    public String getCourseTitle() {
        return this.courseTitle;
    }

    public double getCredit() {
        return this.credit;
    }

    public Faculty getFaculty() {
        return this.faculty;
    }

    public int getNumberOfStudents() {
        return this.numberOfStudents;
    }

    public boolean findStudentId(int id) {

        for (int i = 0; i < this.numberOfStudents; i++) {
            if (studentList[i].getStudentId() == id) {
                return true;
            }
        }
        return false;
    }

    public boolean findFacultyId(int id) {
        if (faculty == null) {
            return false;
        } else if (this.faculty.getFacultyId() == id) {
            return true;
        } else {
            return false;
        }
    }

    public static int getCount() {
        return count;
    }

    public static void deleteCourse() {
        count--;
    }

    public boolean doesNotHaveFaculty() {
        if (faculty == null) {
            return true;
        } else {
            return false;
        }
    }

    public boolean doesNotHaveStudent(int id) {
        for (int i = 0; i < this.numberOfStudents; i++) {
            if (this.studentList[i].getStudentId() == id) {
                return false;
            }
        }
        return true;
    }

}


