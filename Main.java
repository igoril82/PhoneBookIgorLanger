package PhoneBookIgorLanger;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.*;

public class Main {

    static final String PatchToFile = "D:/Java/contacts.csv"; //Please write here the correct path to contact file in you computer.

    /**
     * This is a main class.
     * It also includes the path where a file with all the data is saved.
     * Here we're calling to other classes, where each class activates a different function
     */
    public static void main(String[] args) {

        MainMenu mainMenu = new MainMenu();
        LoadContactsFromFile loadContactsFromFile = new LoadContactsFromFile();
        ListContactsInFile listContactsInFile = new ListContactsInFile();
        ShowContactInFile showContactInFile = new ShowContactInFile();
        FindContactInFile findContactInFile = new FindContactInFile();
        AddContactToFile addContactToFile = new AddContactToFile();
        EditContactByName editContactByName = new EditContactByName();
        DeleteContactFromFile deleteContactFromFile = new DeleteContactFromFile();


        System.out.println("       The Phone Book main menu:");
        System.out.println("================================================");
        System.out.println("   Please type a command or 'exit' to quit:");
        mainMenu.MainMenu();
        System.out.print("> ");

        Map<String, List<String>> contacts = new TreeMap<>();
        loadContactsFromFile.loadContactsFromFile(contacts);

        Scanner input = new Scanner(System.in);
        String line = input.nextLine().trim();

        while (!line.equals("exit")) {

            switch (line) {
                case "list":
                    listContactsInFile.listContactsInFile(contacts);
                    break;
                case "show":
                    showContactInFile.showContactInFile(contacts, input);
                    break;
                case "find":
                    FindContactInFile.findContactInFile(contacts, input);
                    break;
                case "add":
                    AddContactToFile.addContactToFile(contacts, input);
                    break;
                case "edit":
                    EditContactByName.editContactByName(contacts, input);
                    break;
                case "delete":
                    DeleteContactFromFile.deleteContactFromFile(contacts, input);
                    break;
                case "help":
                    mainMenu.MainMenu();
                    break;
                default:
                    System.out.println("Invalid command!");
                    break;
            }

            System.out.print("\n> ");
            line = input.nextLine().trim();
        }

        System.out.println("Good bay, Phone Book is terminated now.");
    }
}

