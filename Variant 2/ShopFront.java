import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class ShopFront {

    private static Map<String, Double> productCatalog = new HashMap<>();

    public static void main(String[] args) {
        initializeCatalog();

        Scanner scanner = new Scanner(System.in);

        System.out.println("Welcome to the Shop Front!");

        while (true) {
            displayMenu();
            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    displayCatalog();
                    break;
                case 2:
                    makePurchase(scanner);
                    break;
                case 3:
                    System.out.println("Thank you for shopping with us. Goodbye!");
                    System.exit(0);
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }

    private static void initializeCatalog() {
        productCatalog.put("Item1", 10.0);
        productCatalog.put("Item2", 20.0);
        productCatalog.put("Item3", 30.0);
    }

    private static void displayMenu() {
        System.out.println("\nMenu:");
        System.out.println("1. Display Catalog");
        System.out.println("2. Make a Purchase");
        System.out.println("3. Exit");
        System.out.print("Enter your choice: ");
    }

    private static void displayCatalog() {
        System.out.println("\nProduct Catalog:");
        for (Map.Entry<String, Double> entry : productCatalog.entrySet()) {
            System.out.println(entry.getKey() + " - $" + entry.getValue());
        }
    }

    private static void makePurchase(Scanner scanner) {
        displayCatalog();
        System.out.print("Enter the product name you want to purchase: ");
        String productName = scanner.next();

        if (productCatalog.containsKey(productName)) {
            double price = productCatalog.get(productName);
            System.out.print("Enter the quantity: ");
            int quantity = scanner.nextInt();

            double totalCost = price * quantity;
            System.out.println("Total Cost: $" + totalCost);
        } else {
            System.out.println("Product not found in the catalog.");
        }
    }
}
