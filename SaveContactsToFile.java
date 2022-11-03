package PhoneBookIgorLanger;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import java.util.Map;

import static PhoneBookIgorLanger.Main.PatchToFile;

public class SaveContactsToFile {

    /**
     * This is a function that saves all data in an external file
     */
    static void saveContactsToFile(Map<String, List<String>> contacts) {
        try (PrintWriter writer = new PrintWriter(PatchToFile)) {
            if (!contacts.isEmpty()) {

                for (Map.Entry<String, List<String>> entry : contacts.entrySet()) {
                    String line = String.format("%s,\"%s\"",
                            entry.getKey(), entry.getValue().toString().replaceAll("\\[|]", ""));
                    writer.println(line);
                }
            }

        } catch (IOException ioex) {
            System.err.println(ioex.getMessage());
        }
    }
}


