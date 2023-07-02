package Viewer;

/**
 * This class represents the different menus and prompts for a program
 * management system. It provides arrays of strings that define the options and
 * layout for each menu.
 */
public class Choise {

    /**
     * Represents the main menu of the program management system.
     */
    private static final String[] mainMenu = {
        "      **********************************************************",
        "      *          ABOARD PROGRAMS MANAGEMENT SYSTEM             *",
        "      **********************************************************",
        "      *        1. Manage aboard programs                       *",
        "      *        2. Manage students                              *",
        "      *        3. Register a program for a student             *",
        "      *        4. Report                                       *",
        "      *        5. Quit                                         *",
        "      **********************************************************"
    };
    /**
     * Represents the menu for managing aboard programs.
     */
    private static final String[] manageAboardProgramsMenu = {
        "      ----------------------------------------------------------",
        "      *                MANAGE ABOARD PROGRAMS                  *",
        "      ----------------------------------------------------------",
        "      |        1. Displays all aboard programs                 |",
        "      |        2. Add a new aboard program                     |",
        "      |        3. Edit information a program by id             |",
        "      |        4. Search and display a program by id           |",
        "      |        5. Save                                         |",
        "      |        6. Load                                         |",
        "      |        7. Back to main menu                            |",
        "      ----------------------------------------------------------"
    };
    /**
     * Represents the menu for managing students.
     */
    private static final String[] manageStudentsMenu = {
        "      ----------------------------------------------------------",
        "      |                 MANAGE STUDENTS                        |",
        "      ----------------------------------------------------------",
        "      |        1. Displays all students                        |",
        "      |        2. Add a new student                            |",
        "      |        3. Edit information a student by id             |",
        "      |        4. Save                                         |",
        "      |        5. Load                                         |",
        "      |        6. Back to main menu                            |",
        "      ----------------------------------------------------------"
    };
    /**
     * Represents the menu for editing aboard programs.
     */
    private static final String[] editManageAboardProgramsMenu = {
        "      ----------------------------------------------------------",
        "      |             MANAGE ABOARD PROGRAMS                     |",
        "      ----------------------------------------------------------",
        "      |        1. Edit name                                    |",
        "      |        2. Edit time                                    |",
        "      |        3. Edit FromRegistrationDate                    |",
        "      |        4. Edit EndRegistrationDate                     |",
        "      |        5. Edit days                                    |",
        "      |        6. Edit location                                |",
        "      |        7. Edit cost                                    |",
        "      |        8. Edit content                                 |",
        "      |        9. Back to menu of manage aboard programs       |",
        "      ----------------------------------------------------------"
    };
    /**
     * Represents the menu for editing students.
     */
    private static final String[] editManageStudentsMenu = {
        "      ----------------------------------------------------------",
        "      |             MANAGE STUDENTS                            |",
        "      ----------------------------------------------------------",
        "      |        1. Edit name                                    |",
        "      |        2. Edit major                                   |",
        "      |        3. Edit email                                   |",
        "      |        4. Edit phone                                   |",
        "      |        5. Edit passport                                |",
        "      |        6. Edit address                                 |",
        "      |        7. Back to menu of manage students              |",
        "      ----------------------------------------------------------"
    };
    /**
     * Represents the menu for generating reports.
     */
    private static final String[] manageReportMenu = {
        "      ----------------------------------------------------------------------",
        "      |                   MANAGE REPORT                                    |",
        "       -------------------------------------------------------------------- ",
        "      |    1. Print out the registration by student’s id                   |",
        "      |    2. Print out the students that registered more than 2 programs  |",
        "      |    3. Count students that registered the program                   |",
        "      |    4. Back to main menu                                            |",
        "       -------------------------------------------------------------------- ",};
    /**
     * Represents the menu for exiting the program.
     */
    private static final String[] exitMenu = {
        "       -------------------------------------------------------- ",
        "      |                   Do you want to exit                  |",
        "       -------------------------------------------------------- ",
        "      |                      1 = Yes                           |",
        "      |                      2 = No                            |",
        "       -------------------------------------------------------- ",};
    /**
     * Represents the menu for saving and exiting the program.
     */
    private static final String[] exitAndSaveMenu = {
        "       -------------------------------------------------------- ",
        "      |             Do you want to save and exit               |",
        "       -------------------------------------------------------- ",
        "      |                      1 = Yes                           |",
        "      |                      2 = No                            |",
        "      |                      3 = No exit                       |",
        "       -------------------------------------------------------- ",};

    public static String[] getMainMenu() {
        return mainMenu;
    }

    public static String[] getManageAboardProgramsMenu() {
        return manageAboardProgramsMenu;
    }

    public static String[] getManageStudentsMenu() {
        return manageStudentsMenu;
    }

    public static String[] getEditManageAboardProgramsMenu() {
        return editManageAboardProgramsMenu;
    }

    public static String[] getEditManageStudentsMenu() {
        return editManageStudentsMenu;
    }

    public static String[] getManageReportMenu() {
        return manageReportMenu;
    }

    public static String[] getExitMenu() {
        return exitMenu;
    }

    public static String[] getExitAndSaveMenu() {
        return exitAndSaveMenu;
    }

}
