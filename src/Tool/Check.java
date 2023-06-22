package Tool;

import java.text.ParseException;
import java.text.SimpleDateFormat;

/**
 *
 * @author Nguyễn Huy Phúc
 */
public class Check {

    Add add = new Add();

    /**
     * Kiểm tra xem một chuỗi có chứa ký tự đặc biệt hay không.
     *
     * @param s chuỗi cần kiểm tra
     * @return true nếu chuỗi chứa ký tự đặc biệt, ngược lại trả về false
     */
    public boolean checkSpecialCharacters(String s) {
        for (char c : s.toCharArray()) {
            if (!Character.isLetterOrDigit(c) && c != ' ') {
                return true;
            }
        }
        return false;
    }

    /**
     * Kiểm tra xem một chuỗi có chứa khoảng trắng hay không.
     *
     * @param s chuỗi cần kiểm tra
     * @return true nếu chuỗi chứa khoảng trắng, ngược lại trả về false
     */
    public boolean checkWhiteSpace(String s) {
        for (char c : s.toCharArray()) {
            if (Character.isWhitespace(c)) {
                return true;
            }
        }
        return false;
    }

    public String checkName() {
        boolean c = true;
        String name = null;
        do {
            name = add.addName();
            if (name.trim().equals("")) {
                System.out.println("   (!) Please enter a non-null value !!! Try again.");
            } else if (this.checkSpecialCharacters(name)) {
                System.out.println("   (!) Name is not true !!! try again.");
            } else {
                c = false;
            }
        } while (c);
        return name;
    }

    public String checkTime() {
        boolean c = true;
        String time = null;
        do {
            time = add.addTime();
            if (time.trim().equals("")) {
                System.out.println("   (!) Please enter a non-null value !!! Try again.");
            } else if (time.trim().equalsIgnoreCase("January") || time.trim().equalsIgnoreCase("March")
                    || time.trim().equalsIgnoreCase("May") || time.trim().equalsIgnoreCase("July")
                    || time.trim().equalsIgnoreCase("September") || time.trim().equalsIgnoreCase("November")) {
                c = false;
            } else {
                System.out.println("   (!) Time is not true !!! try again.");
            }
        } while (c);
        return time;
    }

    public boolean checkDateFormat(String date) {
        String dateFormatPattern = "dd/MM/yyyy";
        SimpleDateFormat dateFormate = new SimpleDateFormat(dateFormatPattern);
        dateFormate.setLenient(false);                          //prevent accepting invalid dateformat.

        try {
            if (date.matches("[0-9]{2}/[0-1][0-9]/[1-9][0-9]{3}")) {
                dateFormate.parse(date);
                return true;
            } else {
                System.out.println("   (!) Please enter correct format (dd/MM/yyyy) !!! Try again.");
                return false;
            }

        } catch (ParseException e) {
            System.out.println("   (!) Error occur: " + e.getMessage());
            return false;
        }
    }

    public String checkFromRegistrationDate() {
        boolean c = true;
        String fromRegistrationDate = null;
        do {
            fromRegistrationDate = add.addFromRegistrationDate();
            if (this.checkDateFormat(fromRegistrationDate)) {
                c = false;
            }
        } while (c);
        return fromRegistrationDate;
    }

    public String checkEndRegistrationDate() {
        boolean c = true;
        String endRegistrationDate = null;
        do {
            endRegistrationDate = add.addEndRegistrationDate();
            if (this.checkDateFormat(endRegistrationDate)) {
                c = false;
            }
        } while (c);
        return endRegistrationDate;
    }

    public String checkRegistrationDate() {
        boolean c = true;
        String registrationDate = null;
        do {
            registrationDate = add.addRegistrationDate();
            if (this.checkDateFormat(registrationDate)) {
                c = false;
            }
        } while (c);
        return registrationDate;
    }

    public String checkDays() {
        boolean c = true;
        String days = null;
        do {
            days = add.addDays();
            if (days.trim().equals("")) {
                System.out.println("   (!) Please enter a non-null value !!! Try again.");
            } else if (!days.matches("\\d+") || this.checkSpecialCharacters(days) || this.checkWhiteSpace(days)) {
                System.out.println("   (!) Days  is not true !!! try again.");
            } else if (Integer.parseInt(days) < 30 || Integer.parseInt(days) > 40) {
                System.out.println("   (!) From 30 to 40 days !!! try again.");
            } else {
                c = false;
            }
        } while (c);
        return days;
    }

    public String checkLocation() {
        boolean c = true;
        String location = null;
        do {
            location = add.addLocation();
            if (location.trim().equals("")) {
                System.out.println("   (!) Please enter a non-null value !!! Try again.");
            } else if (this.checkSpecialCharacters(location)) {
                System.out.println("   (!) Location is not true !!! try again.");
            } else {
                c = false;
            }
        } while (c);
        return location;
    }

    public String checkCost() {
        boolean c = true;
        String cost = null;
        do {
            cost = add.addCost();
            if (cost.trim().equals("")) {
                System.out.println("   (!) Please enter a non-null value !!! Try again.");
            } else if (!cost.matches("\\d+(\\.\\d+)?")) {
                System.out.println("   (!) Cost is not true !!! try again.");
            } else {
                c = false;
            }
        } while (c);
        return cost;
    }

    public String checkContent() {
        boolean c = true;
        String content = null;
        do {
            content = add.addContent();
            if (content.isEmpty()) {
                System.out.println("   (!) Please enter a non-null value !!! Try again.");
            } else if (!content.trim().endsWith(".doc") && !content.trim().endsWith(".pdf")) {
                System.out.println("   (!) Content is not true !!! try again.");
            } else {
                c = false;
            }
        } while (c);
        return content;
    }

    public String checkMajor() {
        boolean c = true;
        String major = null;
        do {
            major = add.addMajor();
            if (major.isEmpty()) {
                System.out.println("   (!) Please enter a non-null value !!! Try again.");
            } else if (!major.trim().equalsIgnoreCase("se") || !major.trim().equalsIgnoreCase("sb")
                    || !major.trim().equalsIgnoreCase("gd") || !major.trim().equalsIgnoreCase("mc")) {
                System.out.println("   (!) Major is not true !!! try again.");
            } else {
                c = false;
            }
        } while (c);
        return major;
    }

    public String checkEmail() {
        boolean c = true;
        String email = null;
        do {
            email = add.addEmail();
            if (email.isEmpty()) {
                System.out.println("   (!) Please enter a non-null value !!! Try again.");
            } else if (!email.trim().endsWith("@fpt.edu.vn")) {
                System.out.println("   (!) Email is not true !!! try again.");
            } else {
                c = false;
            }
        } while (c);
        return email;
    }

    public String checkEmailParents() {
        boolean c = true;
        String email = null;
        do {
            email = add.addEmailParents();
            if (email.isEmpty()) {
                System.out.println("   (!) Please enter a non-null value !!! Try again.");
            } else if (!email.trim().endsWith("@gmail.com")) {
                System.out.println("   (!) Email is not true !!! try again.");
            } else {
                c = false;
            }
        } while (c);
        return email;
    }

    public String checkPhone() {
        boolean c = true;
        String phone = null;
        do {
            phone = add.addPhone();
            if (phone.isEmpty()) {
                System.out.println("   (!) Please enter a non-null value !!! Try again.");
            } else if (!phone.matches("\\d+")) {
                System.out.println("   (!) Phone is not true !!! try again.");
            } else {
                c = false;
            }
        } while (c);
        return phone;
    }

    public String checkPhoneParents() {
        boolean c = true;
        String phone = null;
        do {
            phone = add.addPhoneParents();
            if (phone.isEmpty()) {
                System.out.println("   (!) Please enter a non-null value !!! Try again.");
            } else if (!phone.matches("\\d+")) {
                System.out.println("   (!) Phone is not true !!! try again.");
            } else {
                c = false;
            }
        } while (c);
        return phone;
    }

    public String checkPassport() {
        boolean c = true;
        String passport = null;
        do {
            passport = add.addPassport();
            if (passport.isEmpty()) {
                System.out.println("   (!) Please enter a non-null value !!! Try again.");
            } else if (this.checkSpecialCharacters(passport)) {
                System.out.println("   (!) Passport is not true !!! try again.");
            } else {
                c = false;
            }
        } while (c);
        return passport;
    }

    public String checkAddress() {
        boolean c = true;
        String address = null;
        do {
            address = add.addAddress();
            if (address.isEmpty()) {
                System.out.println("   (!) Please enter a non-null value !!! Try again.");
            } else {
                c = false;
            }
        } while (c);
        return address;
    }

}
