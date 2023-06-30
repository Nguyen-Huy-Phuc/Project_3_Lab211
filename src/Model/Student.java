package Model;

/**
 * Represents a student. Each student has an ID, name, major, email, phone,
 * passport, and address.
 */
public class Student {

    private String id;
    private String name;
    private String major;
    private String email;
    private String phone;
    private String passport;
    private String address;

    /**
     * Constructs a new Student instance.
     *
     * @param id the ID of the student
     * @param name the name of the student
     * @param major the major of the student
     * @param email the email of the student
     * @param phone the phone number of the student
     * @param passport the passport number of the student
     * @param address the address of the student
     */
    public Student(String id, String name, String major, String email, String phone, String passport, String address) {
        this.id = id;
        this.name = name;
        this.major = major;
        this.email = email;
        this.phone = phone;
        this.passport = passport;
        this.address = address;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getMajor() {
        return major;
    }

    public String getEmail() {
        return email;
    }

    public String getPhone() {
        return phone;
    }

    public String getPassport() {
        return passport;
    }

    public String getAddress() {
        return address;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setMajor(String major) {
        this.major = major;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public void setPassport(String passport) {
        this.passport = passport;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    /**
     * Formats the Student instance as a string.
     *
     * @return the formatted string representation of the Student
     */
    @Override
    public String toString() {
        return String.format("       %-15s%-25s%-10s%-20s%-15s%-15s%-20s", id, name, major, email, phone, passport, address);
    }

}
