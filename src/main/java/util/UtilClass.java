package main.java.util;


import main.java.entity.Person;
import main.java.entity.Student;

import java.util.Scanner;

import static java.lang.System.out;

public class UtilClass {
    private static final String[] MESSAGE_ARR = new String[]{"Add student", "Edit student", "Delete student", "Find student", "Get all students", "Exit"};
    private static final String[] SCHOOL_NAMES = {"1. DIV academy", "2. British school", "3. Cambridge"};
    private static final Student[] STUDENTS = new Student[100];

    public String getStringFromScanner(String message) {
        Scanner sc = new Scanner(System.in); // Nəyə görə fieldə qaldıranda final ilə find edəndə özbaşına emtry
                                             // string əlavə edib geri göndərir
        if (message.equals("Please choose school: ")) {
            return selectSchoolName(message);
        }
        out.println(message);
        return sc.nextLine();
    }

    public int getIntFromScanner(String message) {
        Scanner sc = new Scanner(System.in);
        out.println(message);
        return sc.nextInt();
    }

    private String selectSchoolName(String message) {
        for (int i = 0; i < SCHOOL_NAMES.length; i++) {
            out.println(SCHOOL_NAMES[i]);
        }
        while (true) {
            int intFromScanner = getIntFromScanner(message);
            String result = switch (intFromScanner) {
                case 1 -> SCHOOL_NAMES[0];
                case 2 -> SCHOOL_NAMES[1];
                case 3 -> SCHOOL_NAMES[2];
                default -> "Choose correct school";
            };
            if (intFromScanner == 1 || intFromScanner == 2 || intFromScanner == 3) {
                return result;
            }
        }

    }

    public static Person[] getStudents() {
        return STUDENTS;
    }

    public static String[] getMessageArr(){
        return MESSAGE_ARR;
    }

}
