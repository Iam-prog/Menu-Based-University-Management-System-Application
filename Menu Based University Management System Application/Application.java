
import java.util.*;
import java.io.*;
import java.lang.*;

public class Application {

    public static Scanner input = new Scanner(System.in);
    public static int studentId, facultyId, option, option1;
    public static String studentName, courseId, courseTitel, facultyName, facultyPosition;
    public static double studentCGPA, credit;
    public static Student[] students = new Student[1000];
    public static Faculty[] facultys = new Faculty[1000];
    public static Course[] courses = new Course[1000];

    public static void main(String[] args) {

        System.out.println("Welcome");
        System.out.println("How many Courses To add : ");
        int n = input.nextInt();
        for (int i = 0; i < n; i++) {
            System.out.println("Adding Course");
            System.out.println("Input Course Id : ");
            courseId = input.next();
            System.out.println("Input Course Title : ");
            input.nextLine();
            courseTitel = input.nextLine();
            System.out.println("Input Course Credit : ");
            credit = input.nextDouble();
            courses[i] = new Course(courseId, courseTitel, credit);

        }
        System.out.println("How many Facultys To add : ");
        int n1 = input.nextInt();
        for (int i = 0; i < n1; i++) {
            System.out.println("Adding Faculty");
            System.out.println("Input Faculty  Id : ");
            facultyId = input.nextInt();
            System.out.println("Input Faculty Name : ");
            input.nextLine();
            facultyName = input.nextLine();
            System.out.println("Input Faculty Position : ");
            facultyPosition = input.nextLine();
            facultys[i] = new Faculty(facultyId, facultyName, facultyPosition);
        }
        System.out.println("Adding Faculty and Courses are Complete.");
        System.out.print("Welcome To ");

        initialMenu();

    }

    public static void initialMenu() {
        System.out.println("Main Manu");
        System.out.println("(1). Add");
        System.out.println("(2). Delete");
        System.out.println("(3). Update");
        System.out.println("(4). Print");
        System.out.println("(5). Search");
        System.out.println("(6). Exit");

        option = input.nextInt();
        switch (option) {
            case 1:
                add();
            case 2:
                delete();
            case 3:
                update();
            case 4:
                print();
            case 5:
                search();
            case 6:
                exit();
            default:
                System.out.println("Invalid Option Try Again.");
                initialMenu();
        }
    }

    public static void add() {
        addMenu();
        option = input.nextInt();
        switch (option) {
            case 1:
                addStudent();
                initialMenu();
            case 2:
                addFaculty();
                initialMenu();
            case 3:
                addCourse();
                initialMenu();
            case 4:
                addStudentToACourse();
                initialMenu();
            case 5:
                addFacultyToACourse();
                initialMenu();
            case 6:
                initialMenu();
            case 7:
                exit();
            default:
                System.out.println("Invalid Option Try Again.");
                add();
        }
    }

    public static void addMenu() {
        System.out.println("(1). Add a Student");
        System.out.println("(2). Add a Faculty");
        System.out.println("(3). Add a Course");
        System.out.println("(4). Add a Student into a Course");
        System.out.println("(5). Add a Faculty into a Course");
        System.out.println("(6). Go Back");
        System.out.println("(7). Exit");
    }

    public static void addStudent() {
        System.out.println("Adding Student");
        boolean found = false;
        System.out.println("Input Student Id : ");
        studentId = input.nextInt();
        for (int i = 0; i < Student.getCount(); i++) {
            if (studentId == students[i].getStudentId()) {
                System.out.println("This Id is not available.This id already given Try different number for id.");
                found = true;
            }
        }
        if (found == false) {
            System.out.println("Input Student Name : ");
            input.nextLine();
            studentName = input.nextLine();
            System.out.println("Input Student CGPA : ");
            studentCGPA = input.nextDouble();
            students[Student.getCount()] = new Student(studentId, studentName, studentCGPA);
        }

    }

    public static void addFaculty() {
        System.out.println("Adding Faculty");
        boolean found = false;
        System.out.println("Input Faculty Id : ");
        facultyId = input.nextInt();
        for (int i = 0; i < Faculty.getCount(); i++) {
            if (facultyId == facultys[i].getFacultyId()) {
                System.out.println("This Id is not available.This id already given Try different number for id.");
                found = true;
            }
        }
        if (found == false) {
            System.out.println("Input Faculty Name : ");
            input.nextLine();
            facultyName = input.nextLine();
            System.out.println("Input Faculty Position : ");
            facultyPosition = input.nextLine();
            facultys[Faculty.getCount()] = new Faculty(facultyId, facultyName, facultyPosition);
        }
    }

    public static void addCourse() {
        System.out.println("Adding Course");
        boolean found = false;
        System.out.println("Input Course Id : ");
        courseId = input.next();
        for (int i = 0; i < Course.getCount(); i++) {
            if (courseId == null ? courses[i].getCourseId() == null : courseId.equals(courses[i].getCourseId())) {
                System.out.println("This Course Id is not available.Try different Course id.");
                found = true;

            }
        }
        if (found == false) {
            System.out.println("Input Course Title : ");
            input.nextLine();
            courseTitel = input.nextLine();
            System.out.println("Input Course Credit : ");
            credit = input.nextDouble();
            courses[Course.getCount()] = new Course(courseId, courseTitel, credit);
        }
    }

    public static void addStudentToACourse() {
        System.out.println("Adding a Student into a Course");
        boolean found = false, found1 = false;
        int index = 0, index1 = 0;
        System.out.println("Enter Student Id : ");
        int id = input.nextInt();
        for (int i = 0; i < Student.getCount(); i++) {
            if (id == students[i].getStudentId()) {
                found = true;
                index = i;
            }
        }
        if (found == true) {
            System.out.println("Enter Course Id : ");
            String id1 = input.next();
            for (int j = 0; j < Course.getCount(); j++) {
                if (id1 == null ? courses[j].getCourseId() == null : id1.equals(courses[j].getCourseId())) {
                    found1 = true;
                    index1 = j;
                }
            }

            if (found1 == true) {
                if (courses[index1].doesNotHaveStudent(id) == true) {
                    courses[index1].addStudent(students[index]);
                } else {
                    System.out.println("This Student already enrolled in this Course .Try another Student.");
                    add();
                }
            } else {
                System.out.println("This Course Id is wrong Try Again.");
                add();
            }
        } else {
            System.out.println("This Student Id is wrong Try Again.");
            add();
        }
    }

    public static void addFacultyToACourse() {
        System.out.println("Adding a Faculty into a Course");
        boolean found, found1;
        found = false;
        int index = 0, index1 = 0, count = 0;
        System.out.println("Enter Faculty Id : ");
        int id = input.nextInt();
        for (int i = 0; i < Faculty.getCount(); i++) {
            if (id == facultys[i].getFacultyId()) {
                found = true;
                index = i;
            }
        }
        for (int i = 0; i < Course.getCount(); i++) {
            if (courses[i].findFacultyId(id) == true) {
                count++;
            }
        }
        if (count < 3) {
            if (found == true) {
                System.out.println("Enter Course Id : ");
                found1 = false;
                String id1 = input.next();
                for (int j = 0; j < Course.getCount(); j++) {
                    if (id1 == null ? courses[j].getCourseId() == null : id1.equals(courses[j].getCourseId())) {
                        found1 = true;
                        index1 = j;
                    }
                }
                if (found1 == true) {
                    if (courses[index1].doesNotHaveFaculty() == true) {
                        courses[index1].addFaculty(facultys[index]);
                    } else {
                        System.out.println("This Course already hava a Faculty.");
                        add();
                    }
                } else {
                    System.out.println("This Course Id is wrong Try Again.");
                    add();
                }
            } else {
                System.out.println("This Faculty Id is wrong Try Again.");
                add();
            }
        } else {
            System.out.println("This Faculty already took 3 Course.Can not add more Course.Try another Faculty.");
            add();
        }
    }

    public static void delete() {
        deleteMenu();
        option = input.nextInt();
        switch (option) {
            case 1:
                deleteaStudent();
                initialMenu();
            case 2:
                deleteaFaculty();
                initialMenu();
            case 3:
                deleteaCourse();
                initialMenu();
            case 4:
                deleteStudentfromACourse();
                initialMenu();
            case 5:
                deleteFacultyfromACourse();
                initialMenu();
            case 6:
                initialMenu();
            case 7:
                exit();
            default:
                System.out.println("Invalid Option Try Again.");
                delete();

        }

    }

    public static void deleteMenu() {
        System.out.println("(1). Delete a Student");
        System.out.println("(2). Delete a Faculty");
        System.out.println("(3). Delete a Course");
        System.out.println("(4). Delete a Student from a Course");
        System.out.println("(5). Delete a Faculty from a Course");
        System.out.println("(6). Go Back");
        System.out.println("(7). Exit");
    }

    public static void deleteaStudent() {
        System.out.println("Remove Student ");
        boolean found = false;
        int index = 0;
        System.out.println("Enter Student Id : ");
        int id = input.nextInt();
        for (int i = 0; i < Student.getCount(); i++) {
            if (students[i].getStudentId() == id) {
                found = true;
                index = i;
                break;
            }
        }
        if (found == true) {
            for (int j = index + 1; j < Student.getCount(); j++) {
                students[j - 1] = students[j];
            }
            students[Student.getCount() - 1] = null;
            Student.deleteStudent();
        } else {
            System.out.println("This Id is wrong Try Again.");
            delete();
        }
        for (int i = 0; i < Course.getCount(); i++) {
            if (courses[i].findStudentId(id) == true) {
                courses[i].dropStudent(id);
            }
        }
    }

    public static void deleteaFaculty() {

        System.out.println("Remove Faculty ");
        boolean found = false;
        int index = 0;
        System.out.println("Enter Faculty Id : ");
        int id = input.nextInt();
        for (int i = 0; i < Faculty.getCount(); i++) {
            if (facultys[i].getFacultyId() == id) {
                found = true;
                index = i;
                break;
            }
        }
        if (found == true) {
            for (int j = index + 1; j < Faculty.getCount(); j++) {
                facultys[j - 1] = facultys[j];
            }
            facultys[Faculty.getCount() - 1] = null;
            Faculty.deleteFaculty();
        } else {
            System.out.println("This Id is wrong Try Again.");
            delete();
        }
        for (int i = 0; i < Course.getCount(); i++) {
            if (courses[i].findFacultyId(id) == true) {
                courses[i].dropFaculty();
            }
        }

    }

    public static void deleteaCourse() {
        System.out.println("Remove Course ");
        boolean found = false;
        int index = 0;
        System.out.println("Enter Course Id : ");
        String id = input.next();
        for (int i = 0; i < Course.getCount(); i++) {
            if (courses[i].getCourseId() == null ? id == null : courses[i].getCourseId().equals(id)) {
                found = true;
                index = i;
                break;
            }
        }
        if (found == true) {
            for (int j = index + 1; j < Course.getCount(); j++) {
                courses[j - 1] = courses[j];
            }
            courses[Course.getCount() - 1] = null;
            Course.deleteCourse();
        } else {
            System.out.println("This Id is wrong Try Again.");
            delete();
        }

    }

    public static void deleteStudentfromACourse() {
        System.out.println("Remove Student from a Course ");
        boolean found, found1;
        found = false;
        int index = 0, index1 = 0;
        System.out.println("Enter Student Id : ");
        int id = input.nextInt();
        for (int i = 0; i < Student.getCount(); i++) {
            if (id == students[i].getStudentId()) {
                found = true;
                index = i;
            }
        }
        if (found == true) {
            System.out.println("Enter Course Id : ");
            found1 = false;
            String id1 = input.next();

            for (int j = 0; j < Course.getCount(); j++) {
                if (id1 == null ? courses[j].getCourseId() == null : id1.equals(courses[j].getCourseId())) {
                    found1 = true;
                    index1 = j;
                }
            }
            if (found1 == true) {
                if (courses[index1].findStudentId(id) == true) {
                    courses[index1].dropStudent(id);
                } else {
                    System.out.println("This Student is not in this Course.");
                }
            } else {
                System.out.println("This Course Id is wrong Try Again.");
                delete();
            }

        } else {
            System.out.println("This Student Id is wrong Try Again.");
            delete();
        }
    }

    public static void deleteFacultyfromACourse() {
        System.out.println("Remove Faculty from a Course ");
        System.out.println("Enter Faculty Id : ");
        boolean found, found1;
        found = false;
        int index = 0, index1 = 0;
        int id = input.nextInt();
        for (int i = 0; i < Faculty.getCount(); i++) {
            if (id == facultys[i].getFacultyId()) {
                found = true;
                index = i;

            }
        }
        if (found == true) {
            System.out.println("Enter Course Id : ");
            found1 = false;
            String id1 = input.next();

            for (int j = 0; j < Course.getCount(); j++) {
                if (id1 == null ? courses[j].getCourseId() == null : id1.equals(courses[j].getCourseId())) {
                    found1 = true;
                    index1 = j;
                }
            }
            if (found1 == true) {

                if (courses[index1].findFacultyId(id) == true) {

                    courses[index1].dropFaculty();
                } else {
                    System.out.println("This Faculty is not in this Course.");
                }
            } else {
                System.out.println("This Course Id is wrong Try Again.");
                delete();
            }

        } else {
            System.out.println("This Faculty Id is wrong Try Again.");
            delete();
        }
    }

    public static void update() {

        updateMenu();

        option = input.nextInt();
        switch (option) {
            case 1:
                updateAStudentInfo();
                initialMenu();
            case 2:
                updatAFacultyInfo();
                initialMenu();
            case 3:
                updateACourseInfo();
                initialMenu();
            case 4:
                initialMenu();
            case 5:
                exit();
            default:
                System.out.println("Invalid Option Try Again.");
                update();
        }

    }

    public static void updateAStudentInfo() {
        changeStudentMenu();
        option = input.nextInt();
        switch (option) {
            case 1:
                updateaStudentId();
                update();
            case 2:
                updataStudentName();
                update();
            case 3:
                updateaStudentCGPA();
                update();
            case 4:
                update();
            case 5:
                exit();
            default:
                System.out.println("Invalid Option Try Again.");
                update();
        }
    }

    public static void updateaStudentId() {
        System.out.println("Update a Student Id ");
        boolean found = false, found1 = false;
        System.out.println("Enter Student Current Id : ");
        int id = input.nextInt();
        for (int i = 0; i < Student.getCount(); i++) {
            if (id == students[i].getStudentId()) {
                found = true;
                break;
            }
        }
        if (found == true) {
            System.out.println("Enter Student New Id : ");
            int idNew = input.nextInt();
            for (int j = 0; j < Student.getCount(); j++) {
                if (idNew == students[j].getStudentId()) {
                    found1 = true;
                    break;
                }
            }
            if (found1 == false) {
                for (int i = 0; i < Student.getCount(); i++) {
                    if (id == students[i].getStudentId()) {
                        students[i].setStudentId(idNew);
                    }
                }
            } else {
                System.out.println("This new Id is not available.Some one using same id as this.");
            }
        } else {
            System.out.println("This Id is wrong.");
        }
    }

    public static void updataStudentName() {
        System.out.println("Update a Student Name ");
        boolean found = false;
        System.out.println("Enter Student Id : ");
        int id = input.nextInt();
        for (int i = 0; i < Student.getCount(); i++) {
            if (id == students[i].getStudentId()) {
                found = true;
                break;
            }
        }
        if (found == true) {
            System.out.println("Enter Student New Name : ");
            input.nextLine();
            String nameNew = input.nextLine();
            for (int i = 0; i < Student.getCount(); i++) {
                if (id == students[i].getStudentId()) {
                    students[i].setStudentName(nameNew);
                }
            }
        } else {
            System.out.println("This Id is  wrong.");
        }
    }

    public static void updateaStudentCGPA() {
        System.out.println("Update a Student CGPA ");
        boolean found = false;
        System.out.println("Enter Student Id : ");
        int id = input.nextInt();
        for (int i = 0; i < Student.getCount(); i++) {
            if (id == students[i].getStudentId()) {
                found = true;
                break;
            }
        }
        if (found == true) {
            System.out.println("Enter Student New CGPA : ");
            double cgpaNew = input.nextDouble();
            for (int i = 0; i < Student.getCount(); i++) {
                if (id == students[i].getStudentId()) {
                    students[i].setStudentCGPA(cgpaNew);
                }
            }
        } else {
            System.out.println("This Id is  wrong.");
        }
    }

    public static void updatAFacultyInfo() {
        changeFacultyMenu();
        option = input.nextInt();
        switch (option) {
            case 1:
                updateaFacultyId();
                update();
            case 2:
                updateaFacultyName();
                update();
            case 3:
                updateaFacultyPosition();
                update();
            case 4:
                update();
            case 5:
                exit();
            default:
                System.out.println("Invalid Option Try Again.");
                update();
        }

    }

    public static void updateaFacultyId() {
        System.out.println("Update a Faculty Id ");
        boolean found = false, found1 = false;
        System.out.println("Enter Faculty Current Id : ");
        int id = input.nextInt();
        for (int i = 0; i < Faculty.getCount(); i++) {
            if (id == facultys[i].getFacultyId()) {
                found = true;
                break;
            }
        }
        if (found == true) {
            System.out.println("Enter Faculty New Id : ");
            int idNew = input.nextInt();
            for (int j = 0; j < Faculty.getCount(); j++) {
                if (idNew == facultys[j].getFacultyId()) {
                    found1 = true;
                    break;
                }
            }
            if (found1 == false) {
                for (int i = 0; i < Faculty.getCount(); i++) {
                    if (id == facultys[i].getFacultyId()) {
                        facultys[i].setFacultyId(idNew);
                    }
                }
            } else {
                System.out.println("This new Id is not available.Some one using same id as this.");
            }
        } else {
            System.out.println("This Id is wrong.");
        }
    }

    public static void updateaFacultyName() {
        System.out.println("Update a Faculty Name ");
        boolean found = false;
        System.out.println("Enter Faculty Id : ");
        int id = input.nextInt();
        for (int i = 0; i < Faculty.getCount(); i++) {
            if (id == facultys[i].getFacultyId()) {
                found = true;
                break;
            }
        }
        if (found == true) {
            System.out.println("Enter Faculty New Name : ");
            input.nextLine();
            String nameNew = input.nextLine();
            for (int i = 0; i < Faculty.getCount(); i++) {
                if (id == facultys[i].getFacultyId()) {
                    facultys[i].setFacultyName(nameNew);
                }
            }
        } else {
            System.out.println("This Id is wrong.");
        }
    }

    public static void updateaFacultyPosition() {
        System.out.println("Update a Faculty Position ");
        boolean found = false;
        System.out.println("Enter Faculty Id : ");
        int id = input.nextInt();
        for (int i = 0; i < Faculty.getCount(); i++) {
            if (id == facultys[i].getFacultyId()) {
                found = true;
                break;
            }
        }
        if (found == true) {
            System.out.println("Enter Faculty New Position : ");
            input.nextLine();
            String positionNew = input.nextLine();
            for (int i = 0; i < Faculty.getCount(); i++) {
                if (id == facultys[i].getFacultyId()) {
                    facultys[i].setFacultyPosition(positionNew);
                }
            }
        } else {
            System.out.println("This Id is wrong.");
        }
    }

    public static void updateACourseInfo() {
        changeCourseMenu();
        option = input.nextInt();
        switch (option) {
            case 1:
                updateaCourseId();
                update();
            case 2:
                updataCourseTitle();
                update();
            case 3:
                updateaCourseCredit();
                update();
            case 4:
                update();
            case 5:
                exit();
            default:
                System.out.println("Invalid Option Try Again.");
                update();
        }
    }

    public static void updateaCourseId() {
        System.out.println("Update a Course Id ");
        boolean found = false, found1 = false;
        int index = 0;
        System.out.println("Enter Course Current Id : ");
        String id = input.next();
        for (int i = 0; i < Course.getCount(); i++) {
            if (courses[i].getCourseId() == null ? id == null : courses[i].getCourseId().equals(id)) {
                found = true;
                index = i;
                break;
            }
        }
        if (found == true) {
            System.out.println("Enter Course New Id : ");
            String idNew = input.next();
            for (int i = 0; i < Course.getCount(); i++) {
                if (courses[i].getCourseId() == null ? idNew == null : courses[i].getCourseId().equals(idNew)) {
                    found1 = true;
                    break;
                }
            }
            if (found1 == false) {
                courses[index].setCourseId(idNew);
            } else {
                System.out.println("This new Id is not available.A course is assign same id as this.");
            }
        } else {
            System.out.println("This Id is wrong.");
        }
    }

    public static void updataCourseTitle() {
        System.out.println("Update a Course Title ");
        boolean found = false;
        System.out.println("Enter Course Id : ");
        String id = input.next();
        for (int i = 0; i < Course.getCount(); i++) {
            if (courses[i].getCourseId() == null ? id == null : courses[i].getCourseId().equals(id)) {
                found = true;
                break;
            }
        }
        if (found == true) {
            System.out.println("Enter Course New Title : ");
            input.nextLine();
            String titleNew = input.nextLine();
            for (int i = 0; i < Course.getCount(); i++) {
                if (id == null ? courses[i].getCourseId() == null : id.equals(courses[i].getCourseId())) {
                    courses[i].setCourseTitle(titleNew);
                }
            }
        } else {
            System.out.println("This Id is wrong.");
        }
    }

    public static void updateaCourseCredit() {
        System.out.println("Update a Course Credit ");
        boolean found = false;
        System.out.println("Enter Course Id : ");
        String id = input.next();
        for (int i = 0; i < Course.getCount(); i++) {
            if (courses[i].getCourseId() == null ? id == null : courses[i].getCourseId().equals(id)) {
                found = true;
                break;
            }
        }
        if (found == true) {
            System.out.println("Enter Course New Credit : ");
            double creditNew = input.nextDouble();
            for (int i = 0; i < Course.getCount(); i++) {
                if (id == null ? courses[i].getCourseId() == null : id.equals(courses[i].getCourseId())) {
                    courses[i].setCredit(creditNew);
                }
            }
        } else {
            System.out.println("This Id is wrong.");
        }
    }

    public static void updateMenu() {
        System.out.println("(1). Update a Student Information");
        System.out.println("(2). Update a  Faculty Information");
        System.out.println("(3). Update a Course Information");
        System.out.println("(4). Go Back");
        System.out.println("(5). Exit");
    }

    public static void changeStudentMenu() {
        System.out.println("(1). Update a Student Id");
        System.out.println("(2). Update a Student Name");
        System.out.println("(3). Update a Student CGPA");
        System.out.println("(4). Go Back");
        System.out.println("(5). Exit");
    }

    public static void changeFacultyMenu() {
        System.out.println("(1). Update a Faculty Id ");
        System.out.println("(2). Update a Faculty Name ");
        System.out.println("(3). Update a Faculty Position ");
        System.out.println("(4). Go Back");
        System.out.println("(5). Exit");
    }

    public static void changeCourseMenu() {
        System.out.println("(1). Update a Course Id ");
        System.out.println("(2). Update a Course Title");
        System.out.println("(3). Update a Course Credit ");
        System.out.println("(4). Go Back");
        System.out.println("(5). Exit");
    }

    public static void print() {

        printMenu();
        option = input.nextInt();
        switch (option) {
            case 1:
                printallStudents();
                initialMenu();
            case 2:
                printallFaculties();
                initialMenu();
            case 3:
                printallCourses();
                initialMenu();
            case 4:
                printStudentlistandFacultyinfo();
                initialMenu();
            case 5:
                initialMenu();
            case 6:
                exit();
            default:
                System.out.println("Invalid Option Try Again.");
                print();
        }
    }

    public static void printallStudents() {
        System.out.println("All Students ");
        if (Student.getCount() == 0) {
            System.out.println("There is No Student.Add Few Student.");
        } else {
            for (int i = 0; i < Student.getCount(); i++) {
                System.out.println((i + 1) + " : " + students[i].toString());
            }
        }
    }

    public static void printallFaculties() {
        System.out.println("All Faculties ");
        if (Faculty.getCount() == 0) {
            System.out.println("There is No Faculty.Add Few Faculty.");
        } else {
            for (int i = 0; i < Faculty.getCount(); i++) {
                System.out.println((i + 1) + " : " + facultys[i].toString());
            }
        }
    }

    public static void printallCourses() {
        System.out.println("All  Courses");
        if (Course.getCount() == 0) {
            System.out.println("There is No Course.Add Few Course.");
        } else {
            for (int i = 0; i < Course.getCount(); i++) {
                System.out.println((i + 1) + " : " + courses[i].toString());
            }
        }
    }

    public static void printStudentlistandFacultyinfo() {
        System.out.println("Student list and Faculty information ");
        boolean found = false;
        int index = 0;
        System.out.println("Enter Course Id : ");
        String id = input.next();
        for (int i = 0; i < Course.getCount(); i++) {
            if (id == null ? courses[i].getCourseId() == null : id.equals(courses[i].getCourseId())) {
                found = true;
                index = i;
                break;
            }
        }
        if (found == true) {
            if (courses[index].getNumberOfStudents() == 0) {
                System.out.println("There is no Student.Add Few Student.");
            } else {
                System.out.println("Student list  for Course " + id + " are : ");
                courses[index].printStudentList();
            }
            if (courses[index].getFaculty() == null) {
                System.out.println("There is no Fcaulty.Add a Faculty.");
            } else {
                System.out.println("Faculty information  for Course " + id + " is : ");
                System.out.println(courses[index].getFaculty());
            }
        } else {
            System.out.println("This Course Id is not valid.");
        }
    }

    public static void printMenu() {
        System.out.println("(1). Print all Student");
        System.out.println("(2). Print all Faculty");
        System.out.println("(3). Print all Course");
        System.out.println("(4). Print student list and faculty information of a course");
        System.out.println("(5). Go Back");
        System.out.println("(6). Exit");
    }

    public static void search() {
        searchMenu();
        option = input.nextInt();
        switch (option) {
            case 1:
                searchAStudent();
                initialMenu();
            case 2:
                searchAFacultie();
                initialMenu();
            case 3:
                searchACourses();
                initialMenu();
            case 4:
                searchWhetherAStudenttakesAcourse();
                initialMenu();
            case 5:
                searchWhetherAFacultyteachesacourse();
                initialMenu();
            case 6:
                searchCoursestakenbyAStudent();
                initialMenu();
            case 7:
                searchCoursestaughtbyAFaculty();
                initialMenu();
            case 8:
                initialMenu();
            case 9:
                exit();
            default:
                System.out.println("Invalid Option Try Again.");
                search();
        }
    }

    public static void searchAStudent() {
        System.out.println("Search a Student Information  ");
        boolean found = false;
        System.out.println("Enter Student Id : ");
        int id = input.nextInt();
        for (int i = 0; i < Student.getCount(); i++) {
            if (id == students[i].getStudentId()) {
                System.out.println((i + 1) + " : " + students[i].toString());
                found = true;
                break;
            }
        }
        if (found == false) {
            System.out.println("This Id is wrong.");
        }
    }

    public static void searchAFacultie() {
        System.out.println("Search a Faculty Information ");
        boolean found = false;
        System.out.println("Enter Faculty Id : ");
        int id = input.nextInt();
        for (int i = 0; i < Faculty.getCount(); i++) {
            if (id == facultys[i].getFacultyId()) {
                System.out.println((i + 1) + " : " + facultys[i].toString());
                found = true;
                break;
            }
        }
        if (found == false) {
            System.out.println("This Id is wrong.");
        }
    }

    public static void searchACourses() {
        System.out.println("Search a Course Information ");
        boolean found = false;
        System.out.println("Enter Course Id : ");
        String id = input.next();
        for (int i = 0; i < Course.getCount(); i++) {
            if (id == null ? courses[i].getCourseId() == null : id.equals(courses[i].getCourseId())) {
                System.out.println((i + 1) + " : " + courses[i].toString());
                found = true;
                break;
            }
        }
        if (found == false) {
            System.out.println("This Id is wrong.");
        }
    }

    public static void searchWhetherAStudenttakesAcourse() {
        System.out.println("Search whether a Student takes a course ");
        boolean found = false, found1 = false;
        int index1 = 0;
        System.out.println("Enter Student Id : ");
        int id = input.nextInt();
        for (int i = 0; i < Student.getCount(); i++) {
            if (id == students[i].getStudentId()) {
                found = true;
                break;
            }
        }
        if (found == true) {
            System.out.println("Enter a Course : ");
            String id1 = input.next();
            for (int j = 0; j < Course.getCount(); j++) {
                if (id1 == null ? courses[j].getCourseId() == null : id1.equals(courses[j].getCourseId())) {
                    found1 = true;
                    index1 = j;
                    break;
                }
            }
            if (found1 == true) {
                if (courses[index1].findStudentId(id) == true) {
                    System.out.println("Yes.Student Id  no " + id + " is enrolled in this course.Course Id is : " + courses[index1].getCourseId());
                } else {
                    System.out.println("No.Student Id  no " + id + " is not enrolled in this course.Course Id is : " + courses[index1].getCourseId());
                }
            } else {
                System.out.println("This Course Id is wrong Try Again.");
                search();
            }
        } else {
            System.out.println("This Student Id is wrong Try Again.");
            search();
        }
    }

    public static void searchWhetherAFacultyteachesacourse() {
        System.out.println("Search whether a Faculty teaches a course ");
        boolean found = false, found1 = false;
        int index1 = 0;
        System.out.println("Enter Faculty Id : ");
        int id = input.nextInt();
        for (int i = 0; i < Faculty.getCount(); i++) {
            if (id == facultys[i].getFacultyId()) {
                found = true;
            }
        }
        if (found == true) {
            System.out.println("Enter a Course : ");
            String id1 = input.next();
            for (int j = 0; j < Course.getCount(); j++) {
                if (id1 == null ? courses[j].getCourseId() == null : id1.equals(courses[j].getCourseId())) {
                    found1 = true;
                    index1 = j;
                }
            }
            if (found1 == true) {
                if (courses[index1].findFacultyId(id) == true) {
                    System.out.println("Yes.Faculty Id  no " + id + " is in this course.Course Id is : " + courses[index1].getCourseId());
                } else {
                    System.out.println("No.Faculty Id  no " + id + " is not in this course.Course Id is : " + courses[index1].getCourseId());
                }
            } else {
                System.out.println("This Course Id is wrong Try Again.");
                search();
            }
        } else {
            System.out.println("This Faculty Id is wrong Try Again.");
            search();
        }
    }

    public static void searchCoursestakenbyAStudent() {
        System.out.println("Search Courses taken by a student ");
        boolean found = false, found1 = false;
        System.out.println("Enter Student Id : ");
        int id = input.nextInt();
        for (int i = 0; i < Student.getCount(); i++) {
            if (id == students[i].getStudentId()) {
                found = true;
                break;
            }
        }
        if (found == true) {
            System.out.println("Student enrolled in ");
            for (int i = 0; i < Course.getCount(); i++) {
                if (courses[i].findStudentId(id) == true) {
                    System.out.println((i + 1) + " no course and course Id is : " + courses[i].getCourseId());
                    found1 = true;
                }
            }
            if (found1 == false) {
                System.out.println("This Student not enrolled in any course.");
            }
        } else {
            System.out.println("This Student id is wrong.Try Again");
            search();
        }
    }

    public static void searchCoursestaughtbyAFaculty() {
        System.out.println("Search Courses taught by a Faculty ");
        boolean found = false, found1 = false;
        System.out.println("Enter Faculty Id : ");
        int id = input.nextInt();
        for (int i = 0; i < Faculty.getCount(); i++) {
            if (id == facultys[i].getFacultyId()) {
                found = true;
                break;
            }
        }
        if (found == true) {
            System.out.println("Faculty is in ");
            for (int i = 0; i < Course.getCount(); i++) {
                if (courses[i].findFacultyId(id) == true) {
                    System.out.println((i + 1) + " no course and course Id is : " + courses[i].getCourseId());
                    found1 = true;
                }
            }
            if (found1 == false) {
                System.out.println("This Faculty in not teaching any course.");
            }
        } else {
            System.out.println("This Faculty id is wrong.Try Again.");
            search();
        }
    }

    public static void searchMenu() {
        System.out.println("(1). Search a Student");
        System.out.println("(2). Search a  Faculty");
        System.out.println("(3). Search a Course");
        System.out.println("(4). Search whether a Student takes a course");
        System.out.println("(5). Search whether a Faculty teaches a course");
        System.out.println("(6). Search courses taken by a student");
        System.out.println("(7). Search courses taught by a faculty");
        System.out.println("(8). Go Back");
        System.out.println("(9). Exit");
    }

    public static void exit() {
        System.out.println(" Thank you ");
        System.exit(0);
    }
}

