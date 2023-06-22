package Viewer;

import Controller.ManageAboardProgram;
import Controller.ManageStudents;
import Controller.Register;
import Controller.Report;
import Model.Program;
import Model.Student;
import Tool.Add;
import Tool.Check;

/**
 *
 * @author Nguyễn Huy Phúc
 */
public class Main {

    public static void main(String[] args) {
        ManageAboardProgram mp = new ManageAboardProgram();
        ManageStudents ms = new ManageStudents();
        Register rg = new Register();
        Report rp = new Report();
        Menu menu = new Menu();
        Add add = new Add();
        Check check = new Check();
        Program program1 = new Program("P1", "Program 1", "January", "01/07/2023", "05/07/2023", "35", "Location 1", "100", "Program.doc");
        Program program2 = new Program("2", "Program 2", "March", "10/07/2023", "15/07/2023", "37", "Location 2", "150", "Program2.doc");
        Program program3 = new Program("3", "Program 3", "May", "20/07/2023", "25/07/2023", "31", "Location 3", "120", "Program3.doc");
        Program program4 = new Program("4", "Program 4", "July", "05/08/2023", "10/08/2023", "32", "Location 4", "130", "Program4.doc");
        Program program5 = new Program("5", "Program 5", "September", "15/08/2023", "20/08/2023", "36", "Location 5", "110", "Program5.doc");
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
            String check_ = add.addCheck();
            if (!check_.trim().matches("\\d+")) {
                System.out.println("   (!) Try Again");
            } else {
                c = Integer.parseInt(check_);
                switch (c) {
                    case 1:
                        int c1 = -1;
                        do {
                            menu.printMenuManageAboardPrograms();
                            String check1 = add.addCheck();
                            if (!check1.trim().matches("\\d+")) {
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
                                        String idEdit = add.addProgramID();
                                        boolean checkExistEdit = mp.isExistID(idEdit);
                                        if (checkExistEdit) {
                                            boolean edit = true;
                                            do {
                                                menu.printMenuEditManageAboardPrograms();
                                                String choose = add.addChoose();
                                                edit = mp.editInformationByID(choose, edit, idEdit);
                                            } while (edit);
                                        } else {
                                            System.out.println("   (!) ID dose not exists");
                                        }
                                        break;
                                    case 4:
                                        String idSearch = add.addProgramID();
                                        boolean checkExistSearch = mp.isExistID(idSearch);
                                        if (checkExistSearch) {
                                            System.out.println(mp.searchAProgramByID(idSearch));
                                        } else {
                                            System.out.println("   (!) ID dose not exists");
                                        }
                                        break;
                                    case 5:
                                        System.out.println("       Exit");
                                        break;
                                    default:
                                        System.out.println("   (!) Try Again");
                                        break;
                                }
                            }
                        } while (c1 != 5);
                        break;
                    case 2:
                        int c2 = -1;
                        do {
                            menu.printMenuManageStudents();
                            String check2 = add.addCheck();
                            if (!check2.trim().matches("\\d+")) {
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
                                        String idEdit = add.addStudentID();
                                        boolean checkExistEdit = ms.isExistID(idEdit);
                                        if (checkExistEdit) {
                                            boolean edit = true;
                                            do {
                                                menu.printMenuEditManageStudents();
                                                edit = ms.editInformationByID(edit, idEdit);
                                            } while (edit);
                                        } else {
                                            System.out.println("   (!) ID dose not exists");
                                        }
                                        break;
                                    case 4:
                                        System.out.println("       Exit");
                                        break;
                                    default:
                                        System.out.println("   (!) Try Again");
                                        break;
                                }
                            }
                        } while (c2 != 4);
                        break;
                    case 3:
                        rg.registerStudent(mp,ms);
                        break;
                    case 4:
                        int c4 = -1;
                        do {
                            menu.printMenuManageReport();
                            String check4 = add.addCheck();
                            if (!check4.trim().matches("\\d+")) {
                                System.out.println("   (!) Try Again");
                            } else {
                                c4 = Integer.parseInt(check4);
                                switch (c4) {
                                    case 1:
                                        String id = add.addStudentID();
                                        boolean checkExist = ms.isExistID(id);
                                        if (checkExist) {
                                            rp.printOutTheRegistrationByStudentID(id);
                                        } else {
                                            System.out.println("   (!) ID dose not exists");
                                        }
                                        break;
                                    case 2:
                                        break;
                                    case 3:
                                        break;
                                    case 4:
                                        System.out.println("       Exit");
                                        break;
                                    default:
                                        System.out.println("   (!) Try Again");
                                        break;
                                }
                            }
                        } while (c4 != 4);
                        break;
                    default:
                        System.out.println("   (!) Try Again");
                        break;
                }

            }
        } while (c != 5);
    }

}
