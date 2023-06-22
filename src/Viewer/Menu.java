package Viewer;

/**
 *
 * @author Nguyễn Huy Phúc
 */
public class Menu {
    public static void printMenu() {
        System.out.println("      **********************************************************");
        System.out.println("      *          ABOARD PROGRAMS MANAGEMENT SYSTEM             *");
        System.out.println("      **********************************************************");
        System.out.println("      *        1. Manage aboard programs                       *");
        System.out.println("      *        2. Manage students                              *");
        System.out.println("      *        3. Register a program for a student             *");
        System.out.println("      *        4. Report                                       *");
        System.out.println("      **********************************************************");
        System.out.println("      |                    5. Quit                             |");
        System.out.println("      **********************************************************");
        System.out.print("      **(Note: Your options from 1 - 5): ");
    }
    public static void printMenuManageAboardPrograms() {
        System.out.println("      ----------------------------------------------------------");
        System.out.println("      |             MANAGE ABOARD PROGRAMS                     |");
        System.out.println("       -------------------------------------------------------- ");
        System.out.println("      |        1. Displays all aboard programs                 |");
        System.out.println("      |        2. Add a new aboard program                     |");
        System.out.println("      |        3. Edit information a program by id             |");
        System.out.println("      |        4. Search and display a program by id           |");
        System.out.println("      |        5. Back to main menu                 |");
        System.out.println("       -------------------------------------------------------- ");
        System.out.print("      **(Note: Your options from 1 - 5): ");
    }
    public static void printMenuEditManageAboardPrograms() {
        System.out.println("      ----------------------------------------------------------");
        System.out.println("      |             MANAGE ABOARD PROGRAMS                     |");
        System.out.println("       -------------------------------------------------------- ");
        System.out.println("      |        1. Edit name                                    |");
        System.out.println("      |        2. Edit time                                    |");
        System.out.println("      |        3. Edit FromRegistrationDate                    |");
        System.out.println("      |        4. Edit EndRegistrationDate                     |");
        System.out.println("      |        5. Edit days                                    |");
        System.out.println("      |        6. Edit location                                |");
        System.out.println("      |        7. Edit cost                                    |");
        System.out.println("      |        8. Edit content                                 |");
        System.out.println("      |        9. Back to menu of manage aboard programs       |");
        System.out.println("       -------------------------------------------------------- ");
        System.out.print("      **(Note: Your options from 1 - 9): ");
    }
    public static void printMenuEditManageStudents() {
        System.out.println("      ----------------------------------------------------------");
        System.out.println("      |             MANAGE STUDENTS                            |");
        System.out.println("       -------------------------------------------------------- ");
        System.out.println("      |        1. Edit name                                    |");
        System.out.println("      |        2. Edit major                                   |");
        System.out.println("      |        3. Edit email                                   |");
        System.out.println("      |        4. Edit phone                                   |");
        System.out.println("      |        5. Edit passport                                |");
        System.out.println("      |        6. Edit address                                 |");
        System.out.println("      |        7. Back to menu of manage students              |");
        System.out.println("       -------------------------------------------------------- ");
        System.out.print("      **(Note: Your options from 1 - 7): ");
    }
    public static void printMenuManageStudents() {
        System.out.println("      ----------------------------------------------------------");
        System.out.println("      |             MANAGE STUDENTS                            |");
        System.out.println("       -------------------------------------------------------- ");
        System.out.println("      |        1. Displays all students                        |");
        System.out.println("      |        2. Add a new student                            |");
        System.out.println("      |        3. Edit information a student by id             |");
        System.out.println("      |        4. Back to main menu                            |");
        System.out.println("       -------------------------------------------------------- ");
        System.out.print("      **(Note: Your options from 1 - 4): ");
    }
    public static void printMenuManageReport() {
        System.out.println("      ----------------------------------------------------------------------");
        System.out.println("      |                   MANAGE REPORT                                    |");
        System.out.println("       -------------------------------------------------------------------- ");
        System.out.println("      |    1. Print out the registration by student’s id                   |");
        System.out.println("      |    2. Print out the students that registered more than 2 programs  |");
        System.out.println("      |    3. Count students that registered the program                   |");
        System.out.println("      |    4. Back to main menu                                            |");
        System.out.println("       -------------------------------------------------------------------- ");
        System.out.print("      **(Note: Your options from 1 - 4): ");
    }

}
