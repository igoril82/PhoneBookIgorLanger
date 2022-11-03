package PhoneBookIgorLanger;

import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class ShowContactInFile {
    /**
     * This is a function that displays the phone number by contact name
     */
    public static void showContactInFile(Map<String, List<String>> contacts, Scanner input) {
        System.out.println("Enter the name you are looking for:");
        String name = input.nextLine().trim();

        if (contacts.containsKey(name)) {
            for (String number : contacts.get(name)) {
                System.out.println("For name " + name + " was found number " + number + " in the phone book");
            }
        } else {
            System.out.println("Sorry," + name + " not found in the phone book.");
        }

        System.out.println();
        System.out.println("Type a command or 'exit' to quit. For a list of valid commands use 'help':");
    }


}


