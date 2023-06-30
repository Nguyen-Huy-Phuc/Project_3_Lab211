package Controller;

import Model.Program;
import Model.Student;
import Tool.Input;
import Tool.Validation;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.HashMap;

/**
 * Class responsible for registering a student for a program.
 */
public class Register {

    private static final String DATE_FORMAT = "dd/MM/yyyy";
    Input input = new Input();

    /**
     * Registers a student for a program.
     *
     * @param mp HashMap containing programs (programId -> Program)
     * @param ms HashMap containing students (studentId -> Student)
     * @param programId ID of the program to register for
     * @param studentId ID of the student to register
     */
    public void registerStudent(HashMap<String, Program> mp, HashMap<String, Student> ms, String programId, String studentId) {
        if (mp.containsKey(programId) && ms.containsKey(studentId)) {
            Program program = mp.get(programId);
            Student student = ms.get(studentId);
            String registrationDate = "";
            boolean c = true;
            do {
                registrationDate = input.inputRegistrationDate();
                LocalDate date = LocalDate.parse(registrationDate, DateTimeFormatter.ofPattern(DATE_FORMAT));
                c = validateRegistration(program, date);
                if (!c) {
                    System.out.println("   (!) Invalid registration data.");
                }
            } while (!c);
            String parentEmail = input.inputEmailParents();
            String parentPhone = input.inputPhone();
            String filename = studentId + "_" + programId + ".doc";
            saveRegistrationResult(filename, student, program, registrationDate, parentEmail, parentPhone);
            System.out.println("Registration successful!");
        }
    }

    /**
     * Validates if the registration date is within the program's registration
     * period.
     *
     * @param program The program to validate against
     * @param registrationDate The registration date to validate
     * @return true if the registration date is valid, false otherwise
     */
    private boolean validateRegistration(Program program, LocalDate registrationDate) {
        LocalDate startDate = program.getFromRegistrationDate();
        LocalDate endDate = program.getEndRegistrationDate();
        return registrationDate.isAfter(startDate) && registrationDate.isBefore(endDate);
    }

    /**
     * Saves the registration result to a file.
     *
     * @param filename The filename to save the registration result to
     * @param student The student who registered
     * @param program The program the student registered for
     * @param registrationDate The registration date
     * @param parentEmail The email of the student's parent
     * @param parentPhone The phone number of the student's parent
     */
    private void saveRegistrationResult(String filename, Student student, Program program, String registrationDate, String parentEmail, String parentPhone) {
        String filePath = System.getProperty("user.dir") + "src/File/" + filename;
        try (FileWriter fileWriter = new FileWriter(filePath)) {
            // Write student information
            String studentInformation = String.format("Student id: %-20sStudent name: %-20s%n", student.getId(), student.getName());
            String studentDetails = String.format("Major: %-20sEmail: %-20sPhone: %-15sPassport: %-15s%n", student.getMajor(), student.getEmail(), student.getPhone(), student.getPassport());
            String parentInformation = String.format("Address: %-20sEmail of the Parents: %-20sPhone of the Parents: %-20s%n", student.getAddress(), parentEmail, parentPhone);

            // Write program information
            String programInformation = String.format("Program's id: %-20sProgram's name: %-20s%n", program.getId(), program.getName());
            String programDetails = String.format("Time: %-20sDays: %-10sLocation: %-10sCost: %-10s%n", program.getTime(), program.getDays(), program.getLocation(), program.getCost());

            // Write registration information
            fileWriter.write("                                      Aboard Program Registration Form\n");
            fileWriter.write("Information Student:\n");
            fileWriter.write(studentInformation);
            fileWriter.write(studentDetails);
            fileWriter.write(parentInformation);
            fileWriter.write("Information of the aboard program:\n");
            fileWriter.write(programInformation);
            fileWriter.write(programDetails);
            fileWriter.write("Information of the registration:\n");
            fileWriter.write("Registration Date: " + registrationDate + "\n");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
