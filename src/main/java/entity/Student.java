package main.java.entity;

public class Student extends Person {
    private String schoolName;

    public String getSchoolName() {
        return schoolName;
    }

    public void setSchoolName(String schoolName) {
        this.schoolName = schoolName;
    }

    @Override
    public String toString() {
        return super.toString() + "Student{" +
                "schoolName='" + schoolName + '\'' +
                '}';
    }
}
