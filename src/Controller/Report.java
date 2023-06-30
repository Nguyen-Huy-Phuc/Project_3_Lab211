package Controller;

import Model.Student;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileFilter;
import java.io.FileReader;
import java.io.FilenameFilter;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;

/**
 * Class responsible for generating reports based on registration files.
 */
public class Report {

    /**
     * Prints the registration information for a given student ID.
     *
     * @param studentId The ID of the student to generate the report for
     */
    public void printRegistrationByStudentId(String studentId) {
        File directory = new File(System.getProperty("user.dir") + "src/File/");
        File[] files = directory.listFiles(new FileFilter() {
            @Override
            public boolean accept(File file) {
                return file.getName().startsWith(studentId) && file.getName().endsWith(".doc");
            }
        });

        if (files != null && files.length > 0) {
            for (File file : files) {
                try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
                    String line;
                    while ((line = reader.readLine()) != null) {
                        System.out.println("       " + line);
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        } else {
            System.out.println("   (!) No registration file found for student with ID: " + studentId);
        }
    }

    /**
     * Counts the number of students registered for a given program ID.
     *
     * @param programId The ID of the program to count registrations for
     */
    public void countStudentsRegisteredForProgram(String programId) {
        File directory = new File(System.getProperty("user.dir") + "src/File/");
        File[] files = directory.listFiles(new FileFilter() {
            @Override
            public boolean accept(File file) {
                return file.getName().toLowerCase().contains(programId.toLowerCase()) && file.getName().endsWith(".doc");
            }
        });

        if (files != null) {
            int count = files.length;
            System.out.println("       Number of students registered for program " + programId + ": " + count);
        } else {
            System.out.println("   (!) No registrations found for program " + programId);
        }
    }

    /**
     * Checks if registration files exist in the file directory.
     */
    public void checkFileExist() {
        File directory = new File(System.getProperty("user.dir") + "src/File/");
        File[] files = directory.listFiles();
        if (files != null) {
            for (File file : files) {
                System.out.println(file.getName());
            }
        }
    }

    /**
     * Finds students with multiple registrations.
     *
     * @return The student ID(s) with multiple registrations
     */
    public String findStudentsWithMultipleRegistrations() {
        String s = "";
        File directory = new File(System.getProperty("user.dir") + "src/File/");
        File[] files = directory.listFiles(new FilenameFilter() {
            @Override
            public boolean accept(File dir, String name) {
                return name.endsWith(".doc");
            }
        });

        if (files != null && files.length > 0) {
            HashMap<String, Integer> studentProgramCount = new HashMap<>();

            for (File file : files) {
                String fileName = file.getName();
                String studentId = fileName.substring(0, fileName.indexOf("_"));

                if (studentProgramCount.containsKey(studentId)) {
                    int count = studentProgramCount.get(studentId);
                    studentProgramCount.put(studentId, count + 1);
                } else {
                    studentProgramCount.put(studentId, 1);
                }
            }

            for (String studentId : studentProgramCount.keySet()) {
                int programCount = studentProgramCount.get(studentId);

                if (programCount >= 2) {
                    s = studentId;
                }
            }
        } else {
            System.out.println("No registration files found.");
        }
        return s;
    }

}
