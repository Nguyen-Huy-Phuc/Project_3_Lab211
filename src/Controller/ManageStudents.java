package Controller;

import Model.Student;
import Tool.Input;
import Tool.Validation;
import java.util.HashMap;

/**
 * Class for managing students.
 *
 * @see Model.Student
 * @see Tool.Input
 * @see Tool.Validation
 */
public class ManageStudents extends HashMap<String, Student> {

    Input input = new Input();
    Validation validation = new Validation();

    /**
     * Displays all students.
     */
    public void displayAllStudents() {
        System.out.printf("       %-15s%-25s%-10s%-20s%-15s%-15s%-20s\n", "ID", "NAME", "MARJO", "EMAIL", "PHONE", "PASSPORT", "ADDRESS");
        for (Student s : this.values()) {
            System.out.println(s);
        }
    }

    /**
     * Checks if the given ID is present as a key in the map.
     *
     * @param id the ID to check
     * @return true if the ID exists, false otherwise
     * @see #isExistID(String)
     */
    public boolean containKey(String id) {
        for (String s : this.keySet()) {
            if (s.trim().equalsIgnoreCase(id)) {
                return true;
            }
        }
        return false;
    }

    /**
     * Checks if the given ID exists in the map.
     *
     * @param id the ID to check
     * @return true if the ID exists, false otherwise
     */
    public boolean isExistID(String id) {
        for (String s : this.keySet()) {
            if (s.trim().equalsIgnoreCase(id)) {
                return true;
            }
        }
        return false;
    }

    /**
     * Prompts the user to input a valid student ID.
     *
     * @return the valid student ID
     */
    public String inputID() {
        boolean c = false;
        String id = null;
        do {
            System.out.print("       Enter student id : ");
            id = input.inputString();
            c = validation.CheckValidateID(id);
            if (this.isExistID(id)) {
                System.out.println("   (!) ID already exists");
                c = false;
            } else if (!c) {
                System.out.println("   (!) ID is not true !!! try again.");
            }
        } while (!c);
        return id;
    }

    /**
     * Adds a student to the map.
     *
     * @param s the student to add
     */
    public void addStudent(Student s) {
        this.put(s.getId(), s);
    }

    /**
     * Adds a new student to the map.
     */
    public void addNewStudent() {
        String id = this.inputID();
        String name = input.inputName();
        String major = input.inputMajor();
        String email = input.inputEmail();
        String phone = input.inputPhone();
        String passport = input.inputPassport();
        String address = input.inputAddress();
        Student s = new Student(id, name, major, email, phone, passport, address);
        this.addStudent(s);
    }

    /**
     * Edits the name of a student.
     *
     * @param s the student to edit
     */
    public void editName(Student s) {
        String name = input.inputName();
        s.setName(name);
        System.out.println("       Edit Success");
    }

    /**
     * Edits the major of a student.
     *
     * @param s the student to edit
     */
    public void editMajor(Student s) {
        String major = input.inputMajor();
        s.setMajor(major);
        System.out.println("       Edit Success");
    }

    /**
     * Edits the email of a student.
     *
     * @param s the student to edit
     */
    public void editEmail(Student s) {
        String email = input.inputEmail();
        s.setEmail(email);
        System.out.println("       Edit Success");
    }

    /**
     * Edits the phone number of a student.
     *
     * @param s the student to edit
     */
    public void editPhone(Student s) {
        String phone = input.inputPhone();
        s.setPhone(phone);
        System.out.println("       Edit Success");
    }

    /**
     * Edits the passport number of a student.
     *
     * @param s the student to edit
     */
    public void editPassport(Student s) {
        String passport = input.inputPassport();
        s.setPassport(passport);
        System.out.println("       Edit Success");
    }

    /**
     * Edits the address of a student.
     *
     * @param s the student to edit
     */
    public void editAddress(Student s) {
        String address = input.inputAddress();
        s.setAddress(address);
        System.out.println("       Edit Success");
    }

    /**
     * Finds a student by ID.
     *
     * @param id the ID to search for
     * @return the found student or null if not found
     */
    public Student findByID(String id) {
        for (String s : this.keySet()) {
            if (s.trim().equalsIgnoreCase(id)) {
                return this.get(s);
            }
        }
        return null;
    }

    /**
     * Edits the information of a student by ID.
     *
     * @param edit the current edit status
     * @param id the ID of the student to edit
     * @return the updated edit status
     */
    public boolean editInformationByID(boolean edit, String id) {
        String choose = input.inputString();
        if (!validation.CheckValidateNumber(choose)) {
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
