package Anascomid;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class MiniProject {

    static Scanner in = new Scanner(System.in);
    static final String FILENAME = ("C:\\Users\\W10\\Desktop\\midprojhandling.txt.");
    static final int KEY = 3;

    public static void main(String[] args) throws FileNotFoundException {
        boolean isLoggedIn = false;
        int choice;
        System.out.println("Welcome to the Chill Sip & Snack Restaw Ordering System!");

        do {
            System.out.println("\n[1] L o g i n");
            System.out.println("[2] C r e a t e  A c c o u n t");
            System.out.print("Enter choice: ");
            choice = in.nextInt();
            in.nextLine();

            if (choice == 2) {
                createAccount();
                System.out.println("Account created successfully!");
                isLoggedIn = login();
                if (!isLoggedIn) {
                    System.out.println("Login failed. Try again.");
                }
            } else if (choice == 1) {
                isLoggedIn = login();
                if (!isLoggedIn) {
                    System.out.println("Login failed. Try again.");
                }
            }

            if (isLoggedIn) {
                orderMenu();
            }

        } while (choice != 0 && !isLoggedIn);
    }

    public static void createAccount() {
        System.out.println("\nCreate a New Account");
        System.out.print("Enter new Username: ");
        String newUser = in.nextLine();

        System.out.print("Enter new Password: ");
        String newPass = in.nextLine();

        String encryptedPass = encryptCaesar(newPass, KEY);

        try (FileWriter fw = new FileWriter(FILENAME, true)) {
            fw.write(newUser + "," + encryptedPass + "\n");
        } catch (IOException e) {
        }
    }

    public static boolean login() throws FileNotFoundException {
        System.out.println("\nLogin to your Account");

        System.out.print("Enter Username: ");
        String inputUser = in.nextLine();
        System.out.print("Enter Password: ");
        String inputPass = in.nextLine();

        try (Scanner fileReader = new Scanner(new File(FILENAME))) {
            while (fileReader.hasNextLine()) {
                String line = fileReader.nextLine();
                String[] parts = line.split(",");
                if (parts.length == 2) {
                    String savedUser = parts[0];
                    String encryptedPass = parts[1];
                    String decryptedPass = decryptCaesar(encryptedPass, KEY);

                    if (inputUser.equals(savedUser) && inputPass.equals(decryptedPass)) {
                        System.out.println("Login successful!");
                        return true;
                    }
                }
            }
        } catch (IOException e) {
            System.out.println("Error reading the accounts file.");
        }
        return false;
    }

    public static void orderMenu() {
        String[] foodItems = {"Fries", "Pizza", "Cheese Burger"};
        double[] foodPrices = {50.00, 95.00, 65.00};
        int[] foodQuantities = new int[foodItems.length];

        String[] drinkItems = {"Choco Milktea", "Iced Coffee", "Float"};
        double[] drinkPrices = {85.00, 90.00, 70.00};
        int[] drinkQuantities = new int[drinkItems.length];
        double total = 0;
        int choice;

        System.out.println("\nWelcome to the Chill Sip & Snack Menu!");

        do {
            System.out.println("\n------FOODS CHOICES------");
            for (int i = 0; i < foodItems.length; i++) {
                System.out.printf("[%d] %s - %.2f%n", i + 1, foodItems[i], foodPrices[i]);
            }
            System.out.println("[0] Exit");

            System.out.print("Choose an item to order: ");
            choice = in.nextInt();

            if (choice > 0 && choice <= foodItems.length) {
                System.out.print("Enter quantity: ");
                int qty = in.nextInt();
                foodQuantities[choice - 1] += qty;
                System.out.println(qty + "x " + foodItems[choice - 1] + " added to your order.");
            } else if (choice != 0) {
                System.out.println("Invalid choice, please try again.");
            }

        } while (choice != 0);
        System.out.print("Proceeding to drinks.......\n");

        do {
            System.out.println("\n------DRINKS CHOICES------");
            for (int i = 0; i < drinkItems.length; i++) {
                System.out.printf("[%d] %s - %.2f%n", i + 1, drinkItems[i], drinkPrices[i]);
            }
            System.out.println("[0] Exit");

            System.out.print("Choose an item to order: ");
            choice = in.nextInt();

            if (choice > 0 && choice <= drinkItems.length) {
                System.out.print("Enter quantity: ");
                int qty = in.nextInt();
                drinkQuantities[choice - 1] += qty;
                System.out.println(qty + "x " + drinkItems[choice - 1] + " added to your order.");
            } else if (choice != 0) {
                System.out.println("Invalid choice, please try again.");
            }

        } while (choice != 0);
        System.out.println("Existing menu.....");

        System.out.println("\n------ Order Summary ------");

        for (int i = 0; i < foodItems.length + drinkItems.length; i++) {
            String item;
            int qty;
            double price;

            if (i < foodItems.length) {
                item = foodItems[i];
                qty = foodQuantities[i];
                price = foodPrices[i];
            } else {
                int index = i - foodItems.length;
                item = drinkItems[index];
                qty = drinkQuantities[index];
                price = drinkPrices[index];
            }

            if (qty > 0) {
                double itemTotal = qty * price;
                System.out.printf("%dx %s - %.2f%n", qty, item, itemTotal);
                total += itemTotal;
            }
        }
        System.out.printf("Total Bill: %.2f%n", total);
        System.out.println("\nThank you for ordering!Have a nice day!.");
    }

    public static String encryptCaesar(String input, int shift) {
        StringBuilder encrypted = new StringBuilder();
        for (char c : input.toCharArray()) {
            if (Character.isLetter(c)) {
                char base = Character.isLowerCase(c) ? 'a' : 'A';
                c = (char) ((c - base + shift) % 26 + base);
            }
            encrypted.append(c);
        }
        return encrypted.toString();
    }

    public static String decryptCaesar(String input, int shift) {
        return encryptCaesar(input, 26 - shift);
    }
}
