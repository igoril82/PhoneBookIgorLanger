package PhoneBookIgorLanger;

import java.util.List;
import java.util.Map;
import java.util.Scanner;


import static PhoneBookIgorLanger.SaveContactsToFile.saveContactsToFile;

/**
 * This is a function that deletes a number from the phone book.
 * There is a validation check to see if the name exists in the phone book.
 */
public class DeleteContactFromFile {


    public static void deleteContactFromFile(Map<String, List<String>> contacts, Scanner input) {
        System.out.println("Enter name of the contact to be deleted:");
        String name = input.nextLine().trim();

        if (contacts.containsKey(name)) {
            System.out.printf("Contact '%s' will be deleted. Are you sure? [Y/N]:\n", name);
            String confirmation = input.nextLine().trim().toLowerCase();
            confirm:
            while (true) {
                switch (confirmation) {
                    case "y":
                        contacts.remove(name);
                        saveContactsToFile(contacts);
                        System.out.printf("Contact '%s' was deleted successfully from phone book.\n", name);
                        break confirm;
                    case "n":
                        System.out.printf("Contact '%s' was not deleted from phone book.\n", name);
                        break confirm;
                    default:
                        System.out.printf("Delete contact '%s' ?:\n", name);
                        break;
                }
                confirmation = input.nextLine().trim().toLowerCase();
            }

        } else {
            System.out.printf("Sorry, the name '%s' not found in the phone book:\n", name);

        }

        System.out.println();
        System.out.println("Type a command or 'exit' to quit. For a list of valid commands use 'help':");
    }
}


