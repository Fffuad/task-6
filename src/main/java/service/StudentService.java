package service;

import main.java.repository.StudentRepository;
import main.java.util.UtilClass;

import static java.lang.System.out;

public class StudentService {
    private static final String SELECT = "Please select variant: ";
    private final UtilClass utilClass = new UtilClass();
    private final StudentRepository studentRepository = new StudentRepository();

    public static void main(String[] args) {
        StudentService studentService = new StudentService();
        boolean status = true;
        while (status) {

            if (!studentService.showList()) {
                status = false;
            }
        }
    }

    public boolean showList() {
        String[] messageArr = UtilClass.getMessageArr();
        int pickedNumber;
        for (int i = 0; i < messageArr.length; i++) {
            pickedNumber = i + 1;
            out.println(pickedNumber + ". " + messageArr[i]);
        }

        int intFromScanner = utilClass.getIntFromScanner(SELECT);

        return switch (intFromScanner) {
            case 1 -> studentRepository.addStudent();
            case 2 -> studentRepository.editStudent();
            case 3 -> studentRepository.deleteStudent();
            case 4 -> studentRepository.findStudent();
            case 5 -> studentRepository.getAllStudents();
            case 6 -> studentRepository.exit();
            default -> studentRepository.chooseCorrectNumber();
        };
    }

}
