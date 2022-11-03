package PhoneBookIgorLanger;

import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class FindContactInFile {

    /**
     * This is a function where you can search a name by user number.
     * And also what a user wants to do with the value that found after a search
     */
    public static void findContactInFile(Map<String, List<String>> contacts, Scanner input) {
        System.out.println("Enter a number to see to whom does it belong:");
        String number = input.nextLine().trim();

        while (!number.matches("^\\+?[0-9 ]{3,25}$")) {
            System.out.println("Invalid number! May contain only digits, spaces and '+'. Min length 3, max length 25.");
            System.out.println("Please enter the number again:");
            number = input.nextLine().trim();
        }

        for (Map.Entry<String, List<String>> entry : contacts.entrySet()) {
            if (entry.getValue().contains(number)) {
                System.out.println("For  number " + number + " was found contact name " + entry.getKey() + " in the phone book");
            }
        }

        System.out.println();
        System.out.println("Type a command or 'exit' to quit. For a list of valid commands use 'help':");
    }
}


