package PhoneBookIgorLanger;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static PhoneBookIgorLanger.Main.PatchToFile;

public class LoadContactsFromFile {

    /**
     * This is a function that loads the data from an external file.
     * During the process, the integrity of the file is also checked
     */
    public static void loadContactsFromFile(Map<String, List<String>> contacts) {
        try (BufferedReader reader = new BufferedReader(new FileReader(PatchToFile))) {
            Pattern pattern = Pattern.compile("^([^,\"]{4,30}),\"([0-9+, ]+)\"$");
            while (true) {
                String line = reader.readLine();
                if (line == null) {
                    break;
                }

                Matcher matcher = pattern.matcher(line);
                if (matcher.find()) {
                    String[] numbers = matcher.group(2).split(",\\s*");
                    contacts.put(matcher.group(1), Arrays.asList(numbers));
                }
            }

        } catch (IOException ioex) {
            System.err.println("Could not load contacts, phone book is empty!");
        }
    }
}


