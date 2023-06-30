package Model;

import java.text.DecimalFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

/**
 * Represents a program or course. Each program has an ID, name, time,
 * registration dates, days, location, cost, and content.
 */
public class Program {

    private static final String DATE_FORMAT = "dd/MM/yyyy";
    private static final String REGEX_COST = "#######.##$";

    private String id;
    private String name;
    private String time;
    private LocalDate fromRegistrationDate;
    private LocalDate endRegistrationDate;
    private String days;
    private String location;
    private String cost;
    private String content;

    /**
     * Constructs a new Program instance.
     *
     * @param id the ID of the program
     * @param name the name of the program
     * @param time the time of the program
     * @param fromRegistrationDate the starting date for registration
     * @param endRegistrationDate the ending date for registration
     * @param days the days of the program
     * @param location the location of the program
     * @param cost the cost of the program
     * @param content the content of the program
     */
    public Program(String id, String name, String time, String fromRegistrationDate, String EndRegistrationDate, String days, String location, String cost, String content) {
        this.id = id;
        this.name = name;
        this.time = time;
        setFromRegistrationDate(fromRegistrationDate);
        setEndRegistrationDate(EndRegistrationDate);
        this.days = days;
        this.location = location;
        this.cost = cost;
        this.content = content;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getTime() {
        return time;
    }

    public LocalDate getFromRegistrationDate() {
        return fromRegistrationDate;
    }

    public LocalDate getEndRegistrationDate() {
        return endRegistrationDate;
    }

    public String getDays() {
        return days;
    }

    public String getLocation() {
        return location;
    }

    public String getCost() {
        return cost;
    }

    public String getContent() {
        return content;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public void setFromRegistrationDate(String fromRegistrationDate) {
        LocalDate date = LocalDate.parse(fromRegistrationDate, DateTimeFormatter.ofPattern("dd/MM/yyyy"));
        this.fromRegistrationDate = date;
    }

    public void setEndRegistrationDate(String endRegistrationDate) {
        LocalDate date = LocalDate.parse(endRegistrationDate, DateTimeFormatter.ofPattern("dd/MM/yyyy"));
        this.endRegistrationDate = date;
    }

    public void setDays(String days) {
        this.days = days;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public void setCost(String cost) {
        this.cost = cost;
    }

    public void setContent(String content) {
        this.content = content;
    }

    /**
     * Formats the Program instance as a string.
     *
     * @return the formatted string representation of the Program
     */
    @Override
    public String toString() {
        DecimalFormat df = new DecimalFormat(REGEX_COST);
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern(DATE_FORMAT);
        return String.format("       %-15s%-25s%-10s%-30s%-30s%-15s%-20s%-10s%-20s\n", id, name, time, dtf.format(fromRegistrationDate), dtf.format(endRegistrationDate), days, location, df.format(Double.parseDouble(cost)), content);
    }

}
