package Tool;

import java.util.Scanner;

/**
 * Provides methods for user input. Allows input of various data types with
 * validation. Uses the Validation class for input validation. Uses a Scanner
 * object for input reading.
 *
 * @author Nguyễn Huy Phúc
 */
public class Input {

    Scanner sc = new Scanner(System.in);
    Validation validation = new Validation();

    /**
     * Reads and returns a string input from the user.
     *
     * @return the string input
     */
    public String inputString() {
        String id = sc.nextLine();
        return id;
    }

    /**
     * Reads and returns a name input from the user. Validates the name input.
     *
     * @return the name input
     */
    public String inputName() {
        boolean c = false;
        String name = "";
        do {
            System.out.print("       Enter name : ");
            name = this.inputString();
            c = validation.CheckValidateString(name);
            if (!c) {
                System.out.println("   (!) Name is not true !!! try again.");
            }
        } while (!c);
        return name;
    }

    /**
     * Reads and returns a time input from the user. Validates the time input.
     *
     * @return the time input
     */
    public String inputTime() {
        boolean c = false;
        String time = "";
        do {
            System.out.print("       Enter time : ");
            time = this.inputString();
            c = validation.CheckValidateTime(time);
            if (!c) {
                System.out.println("   (!) Time is not true !!! try again.");
            }
        } while (!c);
        return time;
    }

    /**
     * Reads and returns a fromRegistrationDate input from the user. Validates
     * the fromRegistrationDate input format.
     *
     * @return the fromRegistrationDate input
     */
    public String inputFromRegistrationDate() {
        boolean c = false;
        String fromRegistrationDate = "";
        do {
            System.out.print("       Enter From Registration Date : ");
            fromRegistrationDate = this.inputString();
            c = validation.checkDateFormat(fromRegistrationDate);
        } while (!c);
        return fromRegistrationDate;
    }

    /**
     * Reads and returns a registrationDate input from the user. Validates the
     * registrationDate input format.
     *
     * @return the registrationDate input
     */
    public String inputRegistrationDate() {
        boolean c = false;
        String registrationDate = "";
        do {
            System.out.print("       Enter Registration date : ");
            registrationDate = this.inputString();
            c = validation.checkDateFormat(registrationDate);
        } while (!c);
        return registrationDate;
    }

    /**
     * Reads and returns an endRegistrationDate input from the user. Validates
     * the endRegistrationDate input format.
     *
     * @return the endRegistrationDate input
     */
    public String inputEndRegistrationDate() {
        boolean c = false;
        String endRegistrationDate = "";
        do {
            System.out.print("       Enter End Registration Date : ");
            endRegistrationDate = this.inputString();
            c = validation.checkDateFormat(endRegistrationDate);
        } while (!c);
        return endRegistrationDate;
    }

    /**
     * Reads and returns a days input from the user. Validates the days input.
     *
     * @return the days input
     */
    public String inputDays() {
        boolean c = false;
        String days = "";
        do {
            System.out.print("       Enter days : ");
            days = this.inputString();
            c = validation.CheckValidateDays(days);
            if (!c) {
                System.out.println("   (!) Days is not true !!! try again.");
            }
        } while (!c);
        return days;
    }

    /**
     * Reads and returns a location input from the user. Validates the location
     * input.
     *
     * @return the location input
     */
    public String inputLocation() {
        boolean c = false;
        String location = "";
        do {
            System.out.print("       Enter location : ");
            location = this.inputString();
            c = validation.CheckValidateString(location);
            if (!c) {
                System.out.println("   (!) Location is not true !!! try again.");
            }
        } while (!c);
        return location;
    }

    /**
     * Reads and returns a cost input from the user. Validates the cost input.
     *
     * @return the cost input
     */
    public String inputCost() {
        boolean c = false;
        String cost = "";
        do {
            System.out.print("       Enter cost : ");
            cost = this.inputString();
            c = validation.CheckValidatePositiveDouble(cost);
            if (!c) {
                System.out.println("   (!) Cost is not true !!! try again.");
            }
        } while (!c);
        return cost;
    }

    /**
     * Reads and returns a content input from the user. Validates the content
     * input.
     *
     * @return the content input
     */
    public String inputContent() {
        boolean c = false;
        String content = "";
        do {
            System.out.print("       Enter content : ");
            content = this.inputString();
            c = validation.CheckValidateContent(content);
            if (!c) {
                System.out.println("   (!) Content is not true !!! try again.");
            }
        } while (!c);
        return content;
    }

    /**
     * Reads and returns a major input from the user. Validates the major input.
     *
     * @return the major input
     */
    public String inputMajor() {
        boolean c = false;
        String major = "";
        do {
            System.out.print("       Enter major : ");
            major = this.inputString();
            c = validation.CheckValidateMajor(major);
            if (!c) {
                System.out.println("   (!) Major is not true !!! try again.");
            }
        } while (!c);
        return major;
    }

    /**
     * Reads and returns an email input from the user. Validates the email
     * input.
     *
     * @return the email input
     */
    public String inputEmail() {
        boolean c = false;
        String email = "";
        do {
            System.out.print("       Enter email : ");
            email = this.inputString();
            c = validation.CheckValidateEmail(email);
            if (!c) {
                System.out.println("   (!) Email is not true !!! try again.");
            }
        } while (!c);
        return email;
    }

    /**
     * Reads and returns an email input for the parents from the user. Validates
     * the email input.
     *
     * @return the email input for the parents
     */
    public String inputEmailParents() {
        boolean c = false;
        String email = "";
        do {
            System.out.print("       Enter email of the parents: ");
            email = this.inputString();
            c = validation.CheckValidateEmailParents(email);
            if (!c) {
                System.out.println("   (!) Email is not true !!! try again.");
            }
        } while (!c);
        return email;
    }

    /**
     * Reads and returns a phone number input from the user. Validates the phone
     * number input.
     *
     * @return the phone number input
     */
    public String inputPhone() {
        boolean c = false;
        String phone = "";
        do {
            System.out.print("       Enter phone : ");
            phone = this.inputString();
            c = validation.CheckValidateNumber(phone);
            if (!c) {
                System.out.println("   (!) Phone is not true !!! try again.");
            }
        } while (!c);
        return phone;
    }

    /**
     * Reads and returns a passport input from the user. Validates the passport
     * input.
     *
     * @return the passport input
     */
    public String inputPassport() {
        boolean c = false;
        String passport = "";
        do {
            System.out.print("       Enter passport : ");
            passport = this.inputString();
            c = validation.CheckValidateString(passport);
            if (!c) {
                System.out.println("   (!) Passport is not true !!! try again.");
            }
        } while (!c);
        return passport;
    }

    /**
     * Reads and returns an address input from the user. Validates the address
     * input.
     *
     * @return the address input
     */
    public String inputAddress() {
        boolean c = false;
        String address = "";
        do {
            System.out.print("       Enter address : ");
            address = this.inputString();
            c = validation.CheckValidateString(address);
            if (!c) {
                System.out.println("   (!) Address is not true !!! try again.");
            }
        } while (!c);
        return address;
    }
}
