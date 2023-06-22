package Controller;

import Model.Program;
import Model.Student;
import Tool.Add;
import Tool.Check;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.HashMap;

/**
 *
 * @author Nguyễn Huy Phúc
 */
public class Register {

    Check check = new Check();
    Add add = new Add();

    public void registerStudent(HashMap<String, Program> mp, HashMap<String, Student> ms) {
        String programId = add.addProgramID();
        String studentId = add.addStudentID();
        if (mp.containsKey(programId) && ms.containsKey(studentId)) {
            Program program = mp.get(programId);
            Student student = ms.get(studentId);
            String registrationDate = check.checkRegistrationDate();
            String parentEmail = check.checkEmailParents();
            String parentPhone = check.checkPhoneParents();
            LocalDate date = LocalDate.parse(registrationDate, DateTimeFormatter.ofPattern("dd/MM/yyyy"));
            System.out.println(validateRegistration(program, date));
            if (validateRegistration(program, date) && !parentEmail.isEmpty() && !parentPhone.isEmpty()) {
                String filename = studentId + "_" + programId + ".doc";
                saveRegistrationResult(filename, student, program, registrationDate, parentEmail, parentPhone);
                System.out.println("Registration successful!");
            } else {
                System.out.println("Invalid registration data.");
            }
        } else {
            System.out.println("Invalid program ID or student ID.");
        }
    }

    private boolean validateRegistration(Program program, LocalDate registrationDate) {
        LocalDate startDate = program.getFromRegistrationDate();
        LocalDate endDate = program.getEndRegistrationDate();
        return registrationDate.isAfter(startDate) && registrationDate.isBefore(endDate);
    }

    private void saveRegistrationResult(String filename, Student student, Program program, String registrationDate, String parentEmail, String parentPhone) {
         String filePath = "src/File/" + filename;
        try (FileWriter fileWriter = new FileWriter(filePath)) {
            fileWriter.write("Student id: " + student.getId() + "\n");
            fileWriter.write("Student name: " + student.getName() + "\n");
            fileWriter.write("Student major: " + student.getMajor() + "\n");
            fileWriter.write("Student email: " + student.getEmail() + "\n");
            fileWriter.write("Student phone: " + student.getPhone() + "\n");
            fileWriter.write("Student passport: " + student.getPassport() + "\n");
            fileWriter.write("Student address: " + student.getAddress() + "\n");
            fileWriter.write("Program id: " + program.getId() + "\n");
            fileWriter.write("Program name: " + program.getName() + "\n");
            fileWriter.write("Program time: " + program.getTime() + "\n");
            fileWriter.write("Program days: " + program.getDays() + "\n");
            fileWriter.write("Program location: " + program.getLocation() + "\n");
            fileWriter.write("Program cost: " + program.getCost() + "\n");
            fileWriter.write("Registration Date: " + registrationDate + "\n");
            fileWriter.write("Email of the Parents: " + parentEmail + "\n");
            fileWriter.write("Phone of the Parents: " + parentPhone + "\n");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
