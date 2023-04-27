package main.java.repository;


import main.java.entity.Student;
import main.java.util.UtilClass;

import java.util.Objects;

import static java.lang.System.out;

public class StudentRepository {
    private static final String ADD_NAME = "Please add name: ";
    private static final String ADD_SURNAME = "Please add surname: ";
    private static final String CHOOSE_SCHOOL = "Please choose school: ";
    private static final String CHOOSE_STUDENT_ID = "Please select student id: ";
    private static final String EDIT_STUDENT_NAME = "Edit name: ";
    private static final String EDIT_STUDENT_SURNAME = "Edit surname: ";
    private static final String DELETE_STUDENT_BY_ID = "You deleted student by ID ";
    private static final String STUDENT_NOT_FOUND = "----------Student doesn't exist----------";


    private final UtilClass utilClass = new UtilClass();
    private Student[] students = (Student[]) UtilClass.getStudents();


    public boolean addStudent() {
        int studentCell = 0;
        for (int i = 0; i < students.length; i++) {
            if (students[i] == null) {
                studentCell = i;
                break;
            }
        }
        Student student = new Student();
        student.setId(studentCell + 1);
        student.setName(utilClass.getStringFromScanner(ADD_NAME));
        student.setSurname(utilClass.getStringFromScanner(ADD_SURNAME));
        student.setSchoolName(utilClass.getStringFromScanner(CHOOSE_SCHOOL));
        students[studentCell] = student;
        return true;

    }

    public boolean editStudent() {
        int intFromScanner = utilClass.getIntFromScanner(CHOOSE_STUDENT_ID);
        for (int i = 0; i < students.length; i++) {
            if (Objects.nonNull(students[i]) && students[i].getId() == intFromScanner) {
                students[i].setName(utilClass.getStringFromScanner(EDIT_STUDENT_NAME));
                students[i].setSurname(utilClass.getStringFromScanner(EDIT_STUDENT_SURNAME));
                students[i].setSchoolName(utilClass.getStringFromScanner(CHOOSE_SCHOOL));
                return true;
            }
        }
        out.println(STUDENT_NOT_FOUND);
        return true;
    }

    public boolean deleteStudent() {
        int intFromScanner = utilClass.getIntFromScanner(CHOOSE_STUDENT_ID);

        for (int i = 0; i < students.length; i++) {

            if (Objects.nonNull(students[i]) && students[i].getId() == intFromScanner) {
                if (i == students.length - 1) {
                    students[i] = null;
                    out.println(DELETE_STUDENT_BY_ID + intFromScanner);
                    return true;
                }
                for (int j = i; j < students.length; j++) {
                    if (students[j] == null) {
                        continue;
                    }
                    if (j == students.length - 1) {
                        students[j] = null;
                        out.println(DELETE_STUDENT_BY_ID + intFromScanner);
                        return true;
                    }

                    if (students[j + 1] == null) {
                        students[j] = null;
                        out.println(DELETE_STUDENT_BY_ID + intFromScanner);
                        continue;
                    }
                    int id = students[j + 1].getId();
                    students[j] = students[j + 1];
                    students[j].setId(id - 1);
                    students[j + 1] = null;
                }
                out.println(DELETE_STUDENT_BY_ID + intFromScanner);
                return true;
            }
        }
        out.println(STUDENT_NOT_FOUND);
        return true;
    }

    public boolean findStudent() {
        String stringFromScanner = utilClass.getStringFromScanner(ADD_NAME);
        findByName(stringFromScanner);
        return true;

    }

    public boolean getAllStudents() {
        int count = 0;
        for (int i = 0; i < students.length; i++) {
            if (Objects.nonNull(students[i])) {
                count++;
                out.println(students[i].toString());
            }
        }
        if (count == 0) {
            out.println("Student list is empty! ");
        }
        return true;
    }

    public boolean exit() {
        out.println("Bye-bye");
        return false;
    }

    public boolean chooseCorrectNumber() {
        out.println("Choose correct variant! ");
        return true;
    }

    private void findByName(String givenValue) {
        int count = 0;
        for (int i = 0; i < students.length; i++) {
            if (Objects.nonNull(students[i]) && students[i].getName().toLowerCase().contains(givenValue.toLowerCase())) {
                count++;
                out.println(students[i] + " - " + i);
            }
        }
        if (count == 0) {
            out.println(STUDENT_NOT_FOUND);
        }
    }

}
