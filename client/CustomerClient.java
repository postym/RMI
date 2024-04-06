import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.Scanner;

public class CustomerClient {
    public static void main(String[] args) {
        try {
            // Get the registry
            Registry registry = LocateRegistry.getRegistry("127.0.0.1", 9100);

            // Look up for Cart interface from the registry
            CartInterface cart = (CartInterface) registry.lookup("cart");

            Scanner scanner = new Scanner(System.in);

            while (true) {
                System.out.println("\nCustomer Client Menu:");
                System.out.println("1. Add item");
                System.out.println("2. View Added Products");
                System.out.println("3. Exit");
                System.out.print("Enter your choice: ");

                int choice = scanner.nextInt();
                scanner.nextLine(); // Consume newline character

                switch (choice) {
                    case 1:
                        addProduct(cart, scanner, registry);
                        break;
                    case 2:
                        viewAddedProducts(cart);
                        break;
                    case 3:
                        System.out.println("Exiting...");
                        scanner.close();
                        return;
                    default:
                        System.out.println("Invalid choice");
                }
            }
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
            e.printStackTrace();
        }
    }

    public static void addProduct(CartInterface cart, Scanner scanner, Registry registry) {
        try {
            System.out.println("Available Products:");
            System.out.println("1. Laptop");
            System.out.println("2. Mobile Phone");
            System.out.println("3. Charger");
            System.out.println("4. Power Bank");
            System.out.println("5. Keyboard");
            System.out.print("Enter product number to add: ");
            int productNumber = scanner.nextInt();
            scanner.nextLine(); // Consume newline character

            ProductInterface product = null;
            switch (productNumber) {
                case 1:
                    product = (ProductInterface) registry.lookup("laptop");
                    break;
                case 2:
                    product = (ProductInterface) registry.lookup("mobilePhone");
                    break;
                case 3:
                    product = (ProductInterface) registry.lookup("charger");
                    break;
                case 4:
                    product = (ProductInterface) registry.lookup("powerBank");
                    break;
                case 5:
                    product = (ProductInterface) registry.lookup("keyboard");
                    break;
                default:
                    System.out.println("Invalid product number");
            }

            if (product != null) {
                cart.addProduct(product);
                System.out.println("Product added to cart successfully.");
            }
        } catch (Exception e) {
            System.out.println("Error adding product: " + e.getMessage());
            e.printStackTrace();
        }
    }

    public static void viewAddedProducts(CartInterface cart) {
        try {
            System.out.println(cart.viewAddedProducts());
        } catch (Exception e) {
            System.out.println("Error viewing added products: " + e.getMessage());
            e.printStackTrace();
        }
    }
}


