package Tool;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Provides validation methods for different types of data. Contains methods to
 * validate numbers, IDs, days, strings, content, email addresses, majors, time,
 * and date format. Also includes a method to check if a string matches a given
 * regular expression pattern. Uses regular expressions and pattern matching for
 * validation. Handles validation of various input formats.
 *
 * @author Nguyễn Huy Phúc
 */
public class Validation {

    private static final String DATE_FORMAT = "dd/mm/yyyy";
    private static final String REGEX_POSITIVE_DECIMAL = "[0-9]{1,13}(\\\\.[0-9]*)?";
    private static final String DATE_MATCHES = "^(0[1-9]|[12][0-9]|3[01])/(0[1-9]|1[0-2])/((19|20)\\d\\d)$";
    private static final String REGEX_DIGIT = "^[0-9]\\d*$";
    private static final String REGEX_ID = "^[a-zA-Z0-9]+$";
    private static final String REGEX_DAYS = "[3-4][0-9]";
    private static final String REGEX_STRING = "[a-zA-Z0-9\\s]+";

    /**
     * Checks if the given string matches the provided regular expression
     * pattern.
     *
     * @param regex the regular expression pattern to match
     * @param str the string to validate
     * @return true if the string matches the pattern, false otherwise
     */
    public static boolean CheckValidateRegexPattern(String regex, String str) {
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(str);
        return matcher.matches();
    }

    /**
     * Validates if the given string is a valid number.
     *
     * @param str the string to validate
     * @return true if the string is a valid number, false otherwise
     */
    public static boolean CheckValidateNumber(String str) {
        return CheckValidateRegexPattern(REGEX_DIGIT, str);
    }

    /**
     * Validates if the given string is a valid ID.
     *
     * @param str the string to validate
     * @return true if the string is a valid ID, false otherwise
     */
    public static boolean CheckValidateID(String str) {
        return CheckValidateRegexPattern(REGEX_ID, str);
    }

    /**
     * Validates if the given string represents a valid number of days.
     *
     * @param str the string to validate
     * @return true if the string represents a valid number of days, false
     * otherwise
     */
    public static boolean CheckValidateDays(String str) {
        return CheckValidateRegexPattern(REGEX_DAYS, str);
    }

    /**
     * Validates if the given string is a positive decimal number.
     *
     * @param str the string to validate
     * @return true if the string is a positive decimal number, false otherwise
     */
    public static boolean CheckValidatePositiveDouble(String str) {
        return CheckValidateRegexPattern(REGEX_POSITIVE_DECIMAL, str);
    }

    /**
     * Validates if the given string is a valid string containing letters,
     * numbers, and spaces.
     *
     * @param str the string to validate
     * @return true if the string is a valid string, false otherwise
     */
    public static boolean CheckValidateString(String str) {
        return CheckValidateRegexPattern(REGEX_STRING, str);
    }

    /**
     * Validates if the given string represents a valid content.
     *
     * @param str the string to validate
     * @return true if the string represents a valid content, false otherwise
     */
    public static boolean CheckValidateContent(String str) {
        if (str.trim().endsWith(".doc") || str.trim().endsWith(".pdf")) {
            return true;
        } else {
            return false;
        }
    }

    /**
     * Validates if the given string is a valid email address ending with
     * "@fpt.edu.vn".
     *
     * @param str the string to validate
     * @return true if the string is a valid email address, false otherwise
     */
    public static boolean CheckValidateEmail(String str) {
        return str.trim().endsWith("@fpt.edu.vn");
    }

    /**
     * Validates if the given string is a valid parent's email address ending
     * with "@gmail.com".
     *
     * @param str the string to validate
     * @return true if the string is a valid parent's email address, false
     * otherwise
     */
    public static boolean CheckValidateEmailParents(String str) {
        return str.trim().endsWith("@gil.com");
    }

    /**
     * Validates if the given string represents a valid major. Valid majors are
     * "se", "sb", "gd", and "mc".
     *
     * @param str the string to validate
     * @return true if the string represents a valid major, false otherwise
     */
    public static boolean CheckValidateMajor(String str) {
        if (str.trim().equalsIgnoreCase("se") || str.trim().equalsIgnoreCase("sb")
                || str.trim().equalsIgnoreCase("gd") || str.trim().equalsIgnoreCase("mc")) {
            return true;
        } else {
            return false;
        }
    }

    /**
     * Validates if the given string represents a valid time. Valid times are
     * "January", "March", "May", "July", "September", and "November".
     *
     * @param str the string to validate
     * @return true if the string represents a valid time, false otherwise
     */
    public static boolean CheckValidateTime(String str) {
        if (str.trim().equalsIgnoreCase("January") || str.trim().equalsIgnoreCase("March")
                || str.trim().equalsIgnoreCase("May") || str.trim().equalsIgnoreCase("July")
                || str.trim().equalsIgnoreCase("September") || str.trim().equalsIgnoreCase("November")) {
            return true;
        } else {
            return false;
        }
    }

    /**
     * Validates if the given string represents a valid date format
     * (dd/MM/yyyy).
     *
     * @param date the string to validate as a date
     * @return true if the string represents a valid date, false otherwise
     */
    public static boolean checkDateFormat(String date) {
        String dateFormatPattern = DATE_FORMAT;
        SimpleDateFormat dateFormate = new SimpleDateFormat(dateFormatPattern);
        dateFormate.setLenient(false);
        try {
            if (date.matches(DATE_MATCHES)) {
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

}
