package Model;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

/**
 *
 * @author Nguyễn Huy Phúc
 */
public class Program {

    private String id;
    private String name;
    private String time;
    private LocalDate fromRegistrationDate;
    private LocalDate endRegistrationDate;
    private String days;
    private String location;
    private String cost;
    private String content;

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

    @Override
    public String toString() {
        return "Program{" + '}';
    }
    
}
