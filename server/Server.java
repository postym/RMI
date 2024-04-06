import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;

public class Server {
    public static void main(String[] args) {
        try {

            System.setProperty("java.rmi.server.hostname", "127.0.0.1");
            System.out.println("Server has been started...");

            Product Laptop = new Product("PD1", "Laptop", "Lenovo", 3740.91, 6740.00, 100);
            Product MobilePhone = new Product("PD2", "Mobile Phone", "iPhone", 441.72, 900.00, 100);
            Product Charger = new Product("PD3", "Charger", "Lenovo Charger", 841.55, 1700.00, 100);
            Product powerBank = new Product("PD4", "PowerBank", "Panasonic", 44.12, 90.00, 100);
            Product keyboard = new Product("PD5", "keyBoard", "blah...", 500.00, 1000.00, 100);

            Laptop.ViewProducts();
            MobilePhone.ViewProducts();
            Charger.ViewProducts();
            powerBank.ViewProducts();
            keyboard.ViewProducts();

            // Cart.viewAddedProducts();

            ProductInterface stub_laptop = (ProductInterface) UnicastRemoteObject.exportObject(Laptop, 0);
            ProductInterface stub_mobilePhone = (ProductInterface) UnicastRemoteObject.exportObject(MobilePhone, 0);
            ProductInterface stub_charger = (ProductInterface) UnicastRemoteObject.exportObject(Charger, 0);
            ProductInterface stub_powerBank = (ProductInterface) UnicastRemoteObject.exportObject(powerBank, 0);
            ProductInterface stub_keyboard = (ProductInterface) UnicastRemoteObject.exportObject(keyboard, 0);

            // Create and export the Cart as a remote object
            Cart cart = new Cart();
            CartInterface stubCart = (CartInterface) UnicastRemoteObject.exportObject(cart, 0);

            Registry registry = LocateRegistry.getRegistry("127.0.0.1", 9100);

            registry.rebind("laptop", stub_laptop);
            registry.rebind("mobilePhone", stub_mobilePhone);
            registry.rebind("charger", stub_charger);
            registry.rebind("powerBank", stub_powerBank);
            registry.rebind("keyboard", stub_keyboard);
            registry.rebind("cart", stubCart);

            System.out.println("Exporting and binding of Objects has been completed...");

        } catch (Exception e) {
            System.out.println("Some server error..." + e);
        }

    }
}

// CLI Server - start rmiregistry 9100
// CLI Server - compile and run
// CLI Client - compile and run

