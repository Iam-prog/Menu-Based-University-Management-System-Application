
public class Faculty {

    private int facultyId;
    private String facultyName;
    private String facultyPosition;
    public static int count = 0;

    Faculty() {
        count++;
    }

    Faculty(int facultyId, String facultyName, String facultyPosition) {
        this.facultyId = facultyId;
        this.facultyName = facultyName;
        this.facultyPosition = facultyPosition;
        count++;
    }

    public String toString() {
        return "Id : " + this.facultyId + "  Name : " + this.facultyName + "  Position : " + this.facultyPosition;
    }

    public void setFacultyId(int facultyId) {
        this.facultyId = facultyId;
    }

    public void setFacultyName(String facultyName) {
        this.facultyName = facultyName;
    }

    public void setFacultyPosition(String facultyPosition) {
        this.facultyPosition = facultyPosition;
    }

    public int getFacultyId() {
        return this.facultyId;
    }

    public String getFacultyName() {
        return this.facultyName;
    }

    public String getFacultyPosition() {
        return this.facultyPosition;
    }

    public static int getCount() {
        return count;
    }

    public static void deleteFaculty() {
        count--;
    }

}


