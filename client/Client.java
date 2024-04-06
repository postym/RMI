import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class Client {
    public static void main(String[] args) {
        try {
            // Get the references of exported object from RMI Registry...

            // locate the registry.
            Registry registry = LocateRegistry.getRegistry("127.0.0.1", 9100);

            // Get the references of exported object from the RMI Registry...
            ProductInterface p1 = (ProductInterface) registry.lookup("laptop");
            ProductInterface p2 = (ProductInterface) registry.lookup("mobilePhone");
            ProductInterface p3 = (ProductInterface) registry.lookup("charger");
            ProductInterface p4 = (ProductInterface) registry.lookup("powerBank");
            ProductInterface p5 = (ProductInterface) registry.lookup("keyboard");

            System.out.println("\nProduct Code: " + p1.ProductCode() + "\nProduct Name: " + p1.Name()
                    + "\nProduct Description: " + p1.Description() + "\nStore Price: " + p1.StorePrice()
                    + "\nRetail Price: " + p1.RetailPrice() + "\nQuantity: " + p1.Quantity());

            System.out.println("\nProduct Code: " + p2.ProductCode() + "\nProduct Name: " + p2.Name()
                    + "\nProduct Description: " + p2.Description() + "\nStore Price: " + p2.StorePrice()
                    + "\nRetail Price: " + p2.RetailPrice() + "\nQuantity: " + p2.Quantity());

            System.out.println("\nProduct Code: " + p3.ProductCode() + "\nProduct Name: " + p3.Name()
                    + "\nProduct Description: " + p3.Description() + "\nStore Price: " + p3.StorePrice()
                    + "\nRetail Price: " + p3.RetailPrice() + "\nQuantity: " + p3.Quantity());

            System.out.println("\nProduct Code: " + p4.ProductCode() + "\nProduct Name: " + p4.Name()
                    + "\nProduct Description: " + p4.Description() + "\nStore Price: " + p4.StorePrice()
                    + "\nRetail Price: " + p4.RetailPrice() + "\nQuantity: " + p4.Quantity());

            System.out.println("\nProduct Code: " + p5.ProductCode() + "\nProduct Name: " + p5.Name()
                    + "\nProduct Description: " + p5.Description() + "\nStore Price: " + p5.StorePrice()
                    + "\nRetail Price: " + p5.RetailPrice() + "\nQuantity: " + p5.Quantity());

        } catch (Exception e) {
            System.out.println("Client side error..." + e);
        }
    }
}
