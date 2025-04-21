public class ProjectMid {
    
    static Scanner in = new Scanner(System.in);
    static final String FILENAME = ("C:\\Users\\W10\\Desktop\\midprojhandling.txt.");
    static final int KEY = 3;

    public static void main(String[] args) throws FileNotFoundException {
        boolean isLoggedIn = false;
        int choice;
        System.out.println("Welcome to the Chill Sip Restaw Ordering System!");

  do {
            System.out.println("\n[1] L o g i n");
            System.out.println("[2] C r e a t e  A c c o u n t");
            System.out.print("Enter choice: ");
            choice = in.nextInt();
            in.nextLine();

            if (choice == 2) {
                createAccount();
            }

            if (choice == 1) {
                isLoggedIn = login();
                if (!isLoggedIn) {
                    System.out.println("Login failed. Try again.");
                }
            }

        } while (choice != 0 && !isLoggedIn);

        if (isLoggedIn) {
            orderMenu();
        }
    }
Thrisha Mae
Thrisha Mae Martizano
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
        System.out.println("\nThank you for ordering!Come Again");
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