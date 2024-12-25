package src;

import java.io.*;
import java.util.*;

public class ContactManager {
    private static final String FILE_PATH = "data.txt";

    public void run() {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("Choose an option:");
            System.out.println("1. Add Contact");
            System.out.println("2. Search Contact");
            System.out.println("3. Delete Contact");
            System.out.println("4. Update Contact");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");

            String option = scanner.nextLine();

            switch (option) {
                case "1" -> addContact(scanner);
                case "2" -> searchContact(scanner);
                case "3" -> deleteContact(scanner);
                case "4" -> updateContact(scanner);
                case "5" -> {
                    System.out.println("Exiting...");
                    scanner.close();
                    return;
                }
                default -> System.out.println("Invalid option. Please try again.");
            }
        }
    }

    private void addContact(Scanner scanner) {
        Contact contact = createContact(scanner);

        try (BufferedWriter writer = new BufferedWriter(new FileWriter(FILE_PATH, true))) {
            writer.write(contact.toString());
            writer.newLine();
            System.out.println("Contact added successfully.");
        } catch (IOException e) {
            System.err.println("Error writing to file: " + e.getMessage());
        }
    }

    private void searchContact(Scanner scanner) {
        System.out.print("Enter contact name/number/email to search: ");
        String keyword = scanner.nextLine();

        List<String> matches = findLinesContaining(keyword);

        if (matches.isEmpty()) {
            System.out.println("No contact found matching the keyword.");
        } else {
            System.out.println("Matching contacts:");
            for (String line : matches) {
                String[] parts = line.split(",");
                System.out.printf("Name: %s, Number: %s, Email: %s%n", parts[0], parts[1], parts[2]);
            }
        }
    }

    private void deleteContact(Scanner scanner) {
        System.out.print("Enter contact name/number/email to delete: ");
        String keyword = scanner.nextLine();

        List<String> allLines = readFile();
        List<String> matchingLines = findLinesContaining(keyword);

        if (matchingLines.isEmpty()) {
            System.out.println("No contact found to delete.");
        } else {
            for (int i = 0; i < matchingLines.size(); i++) {
                System.out.printf("%d. %s%n", i + 1, matchingLines.get(i));
            }

            System.out.print("Enter the number of the contact to delete: ");
            int choice = Integer.parseInt(scanner.nextLine());

            if (choice > 0 && choice <= matchingLines.size()) {
                String selectedContact = matchingLines.get(choice - 1);
                allLines.remove(selectedContact);
                writeFile(allLines);
                System.out.println("Contact deleted successfully.");
            } else {
                System.out.println("Invalid choice.");
            }
        }
    }

    private void updateContact(Scanner scanner) {
        System.out.print("Enter contact name/number/email to update: ");
        String keyword = scanner.nextLine();

        List<String> allLines = readFile();
        List<String> matchingLines = findLinesContaining(keyword);

        if (matchingLines.isEmpty()) {
            System.out.println("No contact found to update.");
        } else {
            for (int i = 0; i < matchingLines.size(); i++) {
                System.out.printf("%d. %s%n", i + 1, matchingLines.get(i));
            }

            System.out.print("Enter the number of the contact to update: ");
            int choice = Integer.parseInt(scanner.nextLine());

            if (choice > 0 && choice <= matchingLines.size()) {
                String selectedContact = matchingLines.get(choice - 1);
                allLines.remove(selectedContact);
                System.out.printf("Updating contact: %s%n", selectedContact);

                Contact updatedContact = createContact(scanner);
                allLines.add(updatedContact.toString());
                writeFile(allLines);
                System.out.println("Contact updated successfully.");
            } else {
                System.out.println("Invalid choice.");
            }
        }
    }

    private Contact createContact(Scanner scanner) {
        System.out.print("Enter name: ");
        String name = scanner.nextLine();

        System.out.print("Enter number: ");
        String number = scanner.nextLine();

        System.out.print("Enter email: ");
        String email = scanner.nextLine();

        return new Contact(name, number, email);
    }

    private List<String> readFile() {
        List<String> lines = new ArrayList<>();

        try (BufferedReader reader = new BufferedReader(new FileReader(FILE_PATH))) {
            String line;
            while ((line = reader.readLine()) != null) {
                lines.add(line);
            }
        } catch (FileNotFoundException e) {
            System.out.println("File not found. Starting fresh.");
        } catch (IOException e) {
            System.err.println("Error reading file: " + e.getMessage());
        }

        return lines;
    }

    private void writeFile(List<String> lines) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(FILE_PATH))) {
            for (String line : lines) {
                writer.write(line);
                writer.newLine();
            }
        } catch (IOException e) {
            System.err.println("Error writing to file: " + e.getMessage());
        }
    }

    private List<String> findLinesContaining(String keyword) {
        List<String> allLines = readFile();
        List<String> matchingLines = new ArrayList<>();

        for (String line : allLines) {
            if (line.toLowerCase().contains(keyword.toLowerCase())) {
                matchingLines.add(line);
            }
        }

        return matchingLines;
    }
}
