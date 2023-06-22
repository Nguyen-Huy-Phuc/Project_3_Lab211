package Controller;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FilenameFilter;
import java.io.IOException;
import java.util.ArrayList;

/**
 *
 * @author Nguyễn Huy Phúc
 */
public class Report {

    public void printOutTheRegistrationByStudentID(String studentId) {
        ArrayList<String> s = new ArrayList();
        String filenamePattern = studentId + "_*.doc";
        File[] matchingFiles = getMatchingFiles(filenamePattern);
        if (matchingFiles.length > 0) {
            for (File file : matchingFiles) {
                try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
                    String line;
                    while ((line = reader.readLine()) != null) {
                        s.add(line);
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        } else {
            System.out.println("No registration file found for student ID: " + studentId);
        }
        this.displayTheRegistrationByStudentID(s);
    }

    public void displayTheRegistrationByStudentID(ArrayList<String> list) {
        System.out.println(list.size());
        String[] display = new String[list.size()];
        int i = 0;
        for (String s : list) {
            display[i++] = s;
        }
//        System.out.println("                           Aboard Program Registration Form");
//        System.out.printf("%-20s", "Information Student:\n");
//        System.out.printf("%-20s%-20s\n", display[1], display[1]);
//        System.out.printf("%-20s%-20s%-15s%-15s\n", display[2], display[3], display[4], display[5]);
//        System.out.printf("%-20s%-20s%-20s\n", display[6], display[14], display[15]);
//        System.out.printf("Information of the aboard program:\n");
//        System.out.printf("%-20s%-20s\n", display[7], display[8]);
//        System.out.printf("%-20s%-10s%-15s%-10s\n", display[9], display[10], display[11], display[12]);
//        System.out.printf("Information of the registration:\n");
//        System.out.printf("%-20s\n", display[13]);

    }

//    
    public File[] getMatchingFiles(String filenamePattern) {
        File folder = new File("File");
        File[] files = folder.listFiles(new FilenameFilter() {
            @Override
            public boolean accept(File dir, String name) {
                return name.matches(filenamePattern);
            }
        });
        return files != null ? files : new File[0];
    }

}
