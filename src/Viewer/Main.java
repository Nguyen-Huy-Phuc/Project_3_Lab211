package Viewer;

import Controller.ManageAboardProgram;
import Controller.ManageStudents;
import Controller.Register;
import Controller.Report;
import Model.Program;
import Model.Student;
import Tool.Input;
import Tool.Validation;

/**
 * The main class of the program.
 */
public class Main {

    public static void main(String[] args) {
        // Create instances of various controller classes and utility classes
        ManageAboardProgram mp = new ManageAboardProgram();
        ManageStudents ms = new ManageStudents();
        Register rg = new Register();
        Report rp = new Report();
        Menu menu = new Menu();
        Input input = new Input();
        Validation validation = new Validation();

        // Create instances of sample Program and Student objects
        Program program1 = new Program("P1", "Program 1", "January", "01/07/2023", "05/07/2023", "35", "Location 1", "100", "Program.doc");
        Program program2 = new Program("P2", "Program 2", "March", "10/07/2023", "15/07/2023", "37", "Location 2", "150", "Program2.doc");
        Program program3 = new Program("P3", "Program 3", "May", "20/07/2023", "25/07/2023", "31", "Location 3", "120", "Program3.doc");
        Program program4 = new Program("P4", "Program 4", "July", "05/08/2023", "10/08/2023", "32", "Location 4", "130", "Program4.doc");
        Program program5 = new Program("P5", "Program 5", "September", "15/08/2023", "20/08/2023", "36", "Location 5", "110", "Program5.doc");
        mp.addProgram(program1);
        mp.addProgram(program2);
        mp.addProgram(program3);
        mp.addProgram(program4);
        mp.addProgram(program5);
        Student student1 = new Student("SE01", "Tran Nguyen Nhat Minh", "SE", "Minhtnn@fpt.edu.vn", "123456789", "AB123456", "123 ABC Street");
        Student student2 = new Student("SB02", "Doan Duong Minh Tri", "SB", "Triddm@fpt.edu.vn", "987654321", "CD789012", "456 XYZ Street");
        Student student3 = new Student("GD03", "Nguyen Huy Hoang", "GD", "Hoangnh@fpt.edu.vn", "555555555", "EF345678", "789 PQR Street");
        Student student4 = new Student("MC04", "Nguyen Minh Phuc", "MC", "Phucnm@fpt.edu.vn", "111111111", "GH901234", "987 MNO Street");
        Student student5 = new Student("SE05", "Nguyen Huy Phuc", "SE", "Phucnh@fpt.edu.vn", "999999999", "IJ567890", "654 LMN Street");
        ms.addStudent(student1);
        ms.addStudent(student2);
        ms.addStudent(student3);
        ms.addStudent(student4);
        ms.addStudent(student5);

        int c = -1;
        do {
            menu.printMenu();
            String check_ = input.inputString();
            if (!validation.CheckValidateNumber(check_)) {
                System.out.println("   (!) Try Again");
            } else {
                c = Integer.parseInt(check_);
                switch (c) {
                    case 1:
                        // Manage Aboard Programs
                        int c1 = -1;
                        do {
                            menu.printMenuManageAboardPrograms();
                            String check1 = input.inputString();
                            if (!validation.CheckValidateNumber(check1)) {
                                System.out.println("   (!) Try Again");
                            } else {
                                c1 = Integer.parseInt(check1);
                                switch (c1) {
                                    case 1:
                                        mp.DisplaysAllAboardPrograms();
                                        break;
                                    case 2:
                                        mp.addNewProgram();
                                        break;
                                    case 3:
                                        // Edit Aboard Program
                                        System.out.print("       Enter program id : ");
                                        String idEdit = input.inputString();
                                        boolean checkExistEdit = mp.isExistID(idEdit);
                                        if (checkExistEdit) {
                                            boolean edit = true;
                                            do {
                                                menu.printMenuEditManageAboardPrograms();
                                                String choose = input.inputString();
                                                edit = mp.editInformationByID(choose, edit, idEdit);
                                            } while (edit);
                                        } else {
                                            System.out.println("   (!) ID does not exist");
                                        }
                                        break;
                                    case 4:
                                        // Search Aboard Program by ID
                                        System.out.print("       Enter program id : ");
                                        String idSearch = input.inputString();
                                        boolean checkExistSearch = mp.isExistID(idSearch);
                                        if (checkExistSearch) {
                                            System.out.printf("       %-15s%-25s%-10s%-30s%-30s%-15s%-20s%-10s%-20s\n", "ID", "NAME", "TIME", "FROM REGISTRATION DATE", "END REGISTRATION DATE", "DAYS", "LOACTION", "COST", "CONTENT");
                                            System.out.println(mp.searchAProgramByID(idSearch));
                                        } else {
                                            System.out.println("   (!) ID does not exist");
                                        }
                                        break;
                                    case 5:
                                        System.out.println("       Exit");
                                        break;
                                    default:
                                        System.out.println("   (!) Try Again");
                                }
                            }
                        } while (c1 != 5);
                        break;
                    case 2:
                        // Manage Students
                        int c2 = -1;
                        do {
                            menu.printMenuManageStudents();
                            String check2 = input.inputString();
                            if (!validation.CheckValidateNumber(check2)) {
                                System.out.println("   (!) Try Again");
                            } else {
                                c2 = Integer.parseInt(check2);
                                switch (c2) {
                                    case 1:
                                        ms.displayAllStudents();
                                        break;
                                    case 2:
                                        ms.addNewStudent();
                                        break;
                                    case 3:
                                        // Edit Student
                                        System.out.print("       Enter student id : ");
                                        String idEdit = input.inputString();
                                        boolean checkExistEdit = ms.isExistID(idEdit);
                                        if (checkExistEdit) {
                                            boolean edit = true;
                                            do {
                                                menu.printMenuEditManageStudents();
                                                edit = ms.editInformationByID(edit, idEdit);
                                            } while (edit);
                                        } else {
                                            System.out.println("   (!) ID does not exist");
                                        }
                                        break;
                                    case 4:
                                        System.out.println("       Exit");
                                        break;
                                    default:
                                        System.out.println("   (!) Try Again");
                                }
                            }
                        } while (c2 != 4);
                        break;
                    case 3:
                        // Register Student for a Program
                        String programId = "";
                        boolean cProgramId = true;
                        do {
                            System.out.print("       Enter program id : ");
                            programId = input.inputString();
                            if (mp.isExistID(programId)) {
                                cProgramId = false;
                            } else {
                                System.out.println("   (!) ID does not exist");
                            }
                        } while (cProgramId);
                        String studentId = "";
                        boolean cStudentId = true;
                        do {
                            System.out.print("       Enter student id : ");
                            studentId = input.inputString();
                            if (ms.isExistID(studentId)) {
                                cStudentId = false;
                            } else {
                                System.out.println("   (!) ID does not exist");
                            }
                        } while (cStudentId);

                        rg.registerStudent(mp, ms, programId, studentId);
                        break;
                    case 4:
                        // Manage Reports
                        int c4 = -1;
                        do {
                            menu.printMenuManageReport();
                            String check4 = input.inputString();
                            if (!validation.CheckValidateNumber(check4)) {
                                System.out.println("   (!) Try Again");
                            } else {
                                c4 = Integer.parseInt(check4);
                                switch (c4) {
                                    case 1:
                                        // Print Registration by Student ID
                                        System.out.print("       Enter student id : ");
                                        String id = input.inputString();
                                        boolean checkExist = ms.isExistID(id);
                                        if (checkExist) {
                                            rp.printRegistrationByStudentId(id);
                                        } else {
                                            System.out.println("   (!) ID does not exist");
                                        }
                                        break;
                                    case 2:
                                        // Find Students with Multiple Registrations
                                        String find = rp.findStudentsWithMultipleRegistrations();
                                        if (!find.isEmpty()) {
                                            Student st = ms.findByID(find);
                                            System.out.printf("       %-15s%-25s%-10s%-20s%-15s%-15s%-20s\n", "ID", "NAME", "MAJOR", "EMAIL", "PHONE", "PASSPORT", "ADDRESS");
                                            System.out.println(st.toString());
                                        } else {
                                            System.out.println("   (!) No Multiple Enrolled Students");
                                        }
                                        break;
                                    case 3:
                                        // Count Students Registered for a Program
                                        System.out.print("       Enter program id : ");
                                        String program = input.inputString();
                                        boolean checkExist_ = mp.isExistID(program);
                                        if (checkExist_) {
                                            rp.countStudentsRegisteredForProgram(program);
                                        } else {
                                            System.out.println("   (!) ID does not exist");
                                        }
                                        break;
                                    case 4:
                                        System.out.println("       Exit");
                                        break;
                                    default:
                                        System.out.println("   (!) Try Again");
                                }
                            }
                        } while (c4 != 4);
                        break;
                    case 5:
                        System.out.println("       Exit");
                        break;
                    default:
                        System.out.println("   (!) Try Again");
                }

            }
        } while (c != 5);
    }

}
