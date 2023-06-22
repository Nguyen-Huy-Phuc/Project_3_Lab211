package Controller;

import Model.Student;
import Tool.Add;
import Tool.Check;
import java.util.HashMap;

/**
 *
 * @author Nguyễn Huy Phúc
 */
public class ManageStudents extends HashMap<String, Student> {

    Add add = new Add();
    Check check = new Check();

    public void displayAllStudents() {
        System.out.printf("%-15s%-20s%-10s%-20s%-15s%-15s%-20s\n", "ID", "NAME", "MARJO", "EMAIL", "PHONE", "PASSPORT", "ADDRESS");
        for (Student s : this.values()) {
            System.out.println(s);
        }
    }

    public boolean containKey(String id) {
        for (String s : this.keySet()) {
            if (s.trim().equalsIgnoreCase(id)) {
                return true;
            }
        }
        return false;
    }

    public boolean isExistID(String id) {
        for (String s : this.keySet()) {
            if (s.trim().equalsIgnoreCase(id)) {
                return true;
            }
        }
        return false;
    }

    public String checkID() {
        boolean c = true;
        String id = null;
        do {
            id = add.addStudentID();
            if (id.trim().equals("")) {
                System.out.println("   (!) Please enter a non-null value !!! Try again.");
            } else if (check.checkSpecialCharacters(id) || check.checkWhiteSpace(id)) {
                System.out.println("   (!) ID is not true !!! try again.");
            } else if (this.isExistID(id)) {
                System.out.println("   (!) ID already exists");
            } else {
                c = false;
            }
        } while (c);
        return id;
    }

    public void addStudent(Student s) {
        this.put(s.getId(), s);
    }

    public void addNewStudent() {
        String id = this.checkID();
        String name = check.checkName();
        String major = check.checkMajor();
        String email = check.checkEmail();
        String phone = check.checkPhone();
        String passport = check.checkPassport();
        String address = check.checkAddress();
        Student s = new Student(id, name, major, email, phone, passport, address);
        this.addStudent(s);
    }

    public void editName(Student s) {
        String name = check.checkName();
        s.setName(name);
        System.out.println("       Edit Success");
    }

    public void editMajor(Student s) {
        String major = check.checkMajor();
        s.setMajor(major);
        System.out.println("       Edit Success");
    }

    public void editEmail(Student s) {
        String email = check.checkEmail();
        s.setEmail(email);
        System.out.println("       Edit Success");
    }

    public void editPhone(Student s) {
        String phone = check.checkPhone();
        s.setPhone(phone);
        System.out.println("       Edit Success");
    }

    public void editPassport(Student s) {
        String passport = check.checkPassport();
        s.setPassport(passport);
        System.out.println("       Edit Success");
    }

    public void editAddress(Student s) {
        String address = check.checkAddress();
        s.setAddress(address);
        System.out.println("       Edit Success");
    }

    public Student findByID(String id) {
        for (String s : this.keySet()) {
            if (s.trim().equalsIgnoreCase(id)) {
                return this.get(s);
            }
        }
        return null;
    }

    public boolean editInformationByID(boolean edit, String id) {
        String choose = add.addChoose();
        if (!choose.matches("//d+") || check.checkWhiteSpace(choose.trim())) {
            System.out.println("   (!) Try again");
        } else {
            int c = Integer.parseInt(choose);
            Student s = this.findByID(id);
            switch (c) {
                case 1:
                    this.editName(s);
                    break;
                case 2:
                    this.editMajor(s);
                    break;
                case 3:
                    this.editEmail(s);
                    break;
                case 4:
                    this.editPhone(s);
                    break;
                case 5:
                    this.editPassport(s);
                    break;
                case 6:
                    this.editAddress(s);
                    break;
                case 7:
                    edit = false;
                    System.out.println("       Exit");
                    break;
                default:
                    System.out.println("   (!) Try again");
                    break;
            }
        }
        return edit;
    }
}
