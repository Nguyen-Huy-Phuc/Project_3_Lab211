package Controller;

import Model.Program;
import Tool.Input;
import Tool.Validation;
import java.time.LocalDate;
import java.util.HashMap;

/**
 * The ManageAboardProgram class manages a collection of Program objects. It
 * provides methods to add, edit, and search programs. It extends the HashMap
 * class and uses program IDs as keys.
 *
 * @see Model.Program
 * @see Tool.Input
 * @see Tool.Validation
 */
public class ManageAboardProgram extends HashMap<String, Program> {

    Input input = new Input();
    Validation validation = new Validation();

    /**
     * Displays all aboard programs in the collection.
     */
    public void DisplaysAllAboardPrograms() {
        System.out.printf("       %-15s%-25s%-10s%-30s%-30s%-15s%-20s%-10s%-20s\n", "ID", "NAME", "TIME", "FROM REGISTRATION DATE", "END REGISTRATION DATE", "DAYS", "LOACTION", "COST", "CONTENT");
        for (Program p : this.values()) {
            System.out.println(p);
        }
    }

    /**
     * Checks if the collection contains a program with the given ID.
     *
     * @param id the ID to check
     * @return true if the program with the ID exists in the collection, false
     * otherwise
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
     * Checks if a program ID already exists in the collection.
     *
     * @param id the program ID to check
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
     * Prompts the user to input a unique program ID. Validates the ID input and
     * checks if it already exists in the collection.
     *
     * @return the unique program ID
     */
    public String inputProgramID() {
        boolean c = false;
        String id = null;
        do {

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

    public void addProgram(Program p) {
        this.put(p.getId(), p);
    }

    /**
     * Adds a new program to the collection. Prompts the user to input the
     * program details.
     */
    public void addNewProgram() {
        String id = this.inputProgramID();
        String name = input.inputName();
        String time = input.inputTime();
        String fromRegistrationDate = input.inputFromRegistrationDate();
        String endRegistrationDate = input.inputEndRegistrationDate();
        String days = input.inputDays();
        String location = input.inputLocation();
        String cost = input.inputCost();
        String content = input.inputContent();
        Program p = new Program(id, name, time, fromRegistrationDate, endRegistrationDate, days, location, cost, content);
        this.addProgram(p);
    }

    /**
     * Edits the name of a program.
     *
     * @param p the program to edit
     */
    public void editName(Program p) {
        String name = input.inputName();
        p.setName(name);
        System.out.println("       Edit Success");
    }

    /**
     * Edits the time of a program.
     *
     * @param p the program to edit
     */
    public void editTime(Program p) {
        String time = input.inputTime();
        p.setTime(time);
        System.out.println("       Edit Success");
    }

    /**
     * Edits the from registration date of a program.
     *
     * @param p the program to edit
     */
    public void editFromRegistrationDate(Program p) {
        String fromRegistrationDate = input.inputFromRegistrationDate();
        p.setFromRegistrationDate(fromRegistrationDate);
        System.out.println("       Edit Success");
    }

    /**
     * Edits the end registration date of a program.
     *
     * @param p the program to edit
     */
    public void editEndRegistrationDate(Program p) {
        String endRegistrationDate = input.inputFromRegistrationDate();
        p.setEndRegistrationDate(endRegistrationDate);
        System.out.println("       Edit Success");
    }

    /**
     * Edits the number of days of a program.
     *
     * @param p the program to edit
     */
    public void editDays(Program p) {
        String days = input.inputDays();
        p.setDays(days);
        System.out.println("       Edit Success");
    }

    /**
     * Edits the location of a program.
     *
     * @param p the program to edit
     */
    public void editLocation(Program p) {
        String location = input.inputLocation();
        p.setLocation(location);
        System.out.println("       Edit Success");
    }

    /**
     * Edits the cost of a program.
     *
     * @param p the program to edit
     */
    public void editCost(Program p) {
        String cost = input.inputCost();
        p.setCost(cost);
        System.out.println("       Edit Success");
    }

    /**
     * Edits the content of a program.
     *
     * @param p the program to edit
     */
    public void editContent(Program p) {
        String content = input.inputContent();
        p.setContent(content);
        System.out.println("       Edit Success");
    }

    /**
     * Searches for a program by ID.
     *
     * @param id the ID to search for
     * @return the program with the matching ID, or null if not found
     */
    public Program searchAProgramByID(String id) {
        for (String s : this.keySet()) {
            if (s.trim().equalsIgnoreCase(id)) {
                return this.get(s);
            }
        }
        return null;
    }

    /**
     * Edits program information based on the user's input.
     *
     * @param choose the user's choice of information to edit
     * @param edit the current edit status
     * @param id the ID of the program to edit
     * @return the updated edit status
     */
    public boolean editInformationByID(String choose, boolean edit, String id) {
        if (!validation.CheckValidateNumber(choose)) {
            System.out.println("   (!) Try again");
        } else {
            int c = Integer.parseInt(choose);
            Program s = this.searchAProgramByID(id);
            switch (c) {
                case 1:
                    this.editName(s);
                    break;
                case 2:
                    this.editTime(s);
                    break;
                case 3:
                    this.editFromRegistrationDate(s);
                    break;
                case 4:
                    this.editEndRegistrationDate(s);
                    break;
                case 5:
                    this.editDays(s);
                    break;
                case 6:
                    this.editLocation(s);
                    break;
                case 7:
                    this.editCost(s);
                    break;
                case 8:
                    this.editContent(s);
                    break;
                case 9:
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
