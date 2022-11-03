package PhoneBookIgorLanger;

import java.util.*;

import static PhoneBookIgorLanger.SaveContactsToFile.saveContactsToFile;

/**
 * His is a function that adds a new number.
 * At this stage, we check how many characters are in the name
 * In addition, a typed phone number is also checked
 */
public class AddContactToFile {
    public static void addContactToFile(Map<String, List<String>> contacts, Scanner input) {

        System.out.println("You are about to add a new contact to the phone book.");

        String name;
        String number;
        int counterOfName = 0;
        int counterOfNumber = 0;

        while (true) {
            System.out.println("Enter contact name:");
            name = input.nextLine().trim();
            if (name.matches("^.{4,30}$")) {
                break;
            } else {
                counterOfName++;
                System.out.println("Name must be in range 4 - 30 symbols.");
                if (counterOfName >= 3) {
                    System.out.println("You have tried to enter an incorrect name more than 3 times. Phone Book is terminated now");
                    System.exit(0);
                }
            }
        }

        while (true) {
            System.out.println("Enter contact number:");
            number = input.nextLine().trim();
            if (number.matches("^\\+?[0-9 ]{8,15}$")) {
                break;
            } else {
                counterOfNumber++;
                System.out.println("Number may contain only '+', spaces and digits. Min length 8, max length 15.");
                if (counterOfNumber >= 3) {
                    System.out.println("You have tried to enter an incorrect number more than 3 times. Phone Book is terminated now");
                    System.exit(0);
                }
            }
        }

        if (contacts.containsKey(name)) {
            System.out.printf("'%s' already exists in the phone book!\n", name);

            if (contacts.get(name).contains(number)) {
                System.out.printf("Number %s already available for contact '%s'.\n", number, name);
            } else {
                contacts.get(name).add(number);
                saveContactsToFile(contacts);
                System.out.printf("Successfully added number %s for contact '%s'.\n", number, name);
            }

        } else {
            List<String> numbers = new ArrayList<>(Collections.singleton(number));
            contacts.put(name, numbers);
            saveContactsToFile(contacts);
            System.out.printf("Successfully added contact '%s' !\n", name);
        }

        System.out.println();
        System.out.println("Type a command or 'exit' to quit. For a list of valid commands use 'help':");
    }
}


