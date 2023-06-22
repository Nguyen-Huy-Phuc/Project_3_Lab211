package Controller;

import Model.Program;
import Tool.Add;
import Tool.Check;
import java.time.LocalDate;
import java.util.HashMap;

/**
 *
 * @author Nguyễn Huy Phúc
 */
public class ManageAboardProgram extends HashMap<String, Program> {

    Add add = new Add();
    Check check = new Check();

    public void DisplaysAllAboardPrograms() {
        for (Program p : this.values()) {
            System.out.println(p);
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
            id = add.addProgramID();
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

    public void addProgram(Program p) {
        this.put(p.getId(), p);
    }

    public void addNewProgram() {
        String id = this.checkID();
        String name = check.checkName();
        String time = check.checkTime();
        String fromRegistrationDate = check.checkFromRegistrationDate();
        String endRegistrationDate = check.checkEndRegistrationDate();
        String days = check.checkDays();
        String location = check.checkLocation();
        String cost = check.checkCost();
        String content = check.checkContent();
        Program p = new Program(id, name, time, fromRegistrationDate, endRegistrationDate, days, location, cost, content);
        this.addProgram(p);
    }

    public void editName(Program p) {
        String name = check.checkName();
        p.setName(name);
        System.out.println("       Edit Success");
    }

    public void editTime(Program p) {
        String time = check.checkTime();
        p.setTime(time);
        System.out.println("       Edit Success");
    }

    public void editFromRegistrationDate(Program p) {
        String fromRegistrationDate = check.checkFromRegistrationDate();
        p.setFromRegistrationDate(fromRegistrationDate);
        System.out.println("       Edit Success");
    }

    public void editEndRegistrationDate(Program p) {
        String endRegistrationDate = check.checkEndRegistrationDate();
        p.setEndRegistrationDate(endRegistrationDate);
        System.out.println("       Edit Success");
    }

    public void editDays(Program p) {
        String days = check.checkDays();
        p.setDays(days);
        System.out.println("       Edit Success");
    }

    public void editLocation(Program p) {
        String location = check.checkLocation();
        p.setLocation(location);
        System.out.println("       Edit Success");
    }

    public void editCost(Program p) {
        String cost = check.checkCost();
        p.setCost(cost);
        System.out.println("       Edit Success");
    }

    public void editContent(Program p) {
        String content = check.checkContent();
        p.setContent(content);
        System.out.println("       Edit Success");
    }

    public Program searchAProgramByID(String id) {
        for (String s : this.keySet()) {
            if (s.trim().equalsIgnoreCase(id)) {
                return this.get(s);
            }
        }
        return null;
    }

    public boolean editInformationByID(String choose, boolean edit, String id) {
        if (!choose.matches("\\d+")) {
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
