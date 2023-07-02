package Viewer;

import java.util.Scanner;

/**
 * This class represents a menu utility that can be used to print menus and
 * prompt user input.
 */
public class Menu {

    /**
     * Prints the given options as a menu and prompts the user for input.
     *
     * @param options The options to be displayed in the menu.
     */
    public static void printMenu(Object[] options) {
        for (int i = 0; i < options.length; i++) {
            System.out.println(options[i]);
        }
        System.out.print("Your options from 1 - " + (options.length - 4) + ": ");
    }

}
