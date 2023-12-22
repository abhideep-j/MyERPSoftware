
package myLibrary.shared;

    import java.io.*;

public class UniqueCodeGenerator8ForDesignationMaster {
    
    private static final String COUNTER_FILE = "C:\\Users\\HP\\Documents\\NetBeansProjects\\ErpSoftWare\\src\\myLibrary\\shared\\counter8fordesmaster.txt";

    public static int generateCodeforDesignationMaster() {
        int counter = readCounterFromFile();
        counter++;
        saveCounterToFile(counter);
        return counter;
    }

    private static int readCounterFromFile() {
        int counter = 0;
        try (BufferedReader reader = new BufferedReader(new FileReader(COUNTER_FILE))) {
            String line = reader.readLine();
            if (line != null) {
                counter = Integer.parseInt(line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return counter;
    }

    private static void saveCounterToFile(int counter) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(COUNTER_FILE))) {
            writer.write(Integer.toString(counter));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }



}
