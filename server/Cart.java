import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.List;

public class Cart implements CartInterface {
    private List<ProductInterface> addedProducts;

    public Cart() {
        this.addedProducts = new ArrayList<>();
    }

    @Override
    public void addProduct(ProductInterface product) throws RemoteException {
        addedProducts.add(product);
    }

    @Override
    public List<ProductInterface> getProducts() throws RemoteException {
        return addedProducts;
    }

    @Override
    public double getTotal() throws RemoteException {
        double total = 0;
        for (ProductInterface product : addedProducts) {
            total += product.StorePrice();
        }
        return total;
    }


    public void updateProductQuantity(String productCode, int newQuantity) throws RemoteException {
        for (ProductInterface product : addedProducts) {
            if (product.ProductCode().equals(productCode)) {
                double currentQuantity = product.Quantity();
                if (newQuantity >= 0 && newQuantity <= currentQuantity) {
                    product.setQuantity(newQuantity); // Assuming a setter for quantity
                    return;
                } else {
                    System.out.println("No more stocks");
                    return;
                }
            }
        }
        return; 
    }

    @Override
    public String viewAddedProducts() throws RemoteException {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Items in Cart:\n");
        for (ProductInterface product : addedProducts) {
            try {
                stringBuilder.append("Product Code: ").append(product.ProductCode()).append("\n");
                stringBuilder.append("Product Name: ").append(product.Name()).append("\n");
                stringBuilder.append("Product Description: ").append(product.Description()).append("\n");
                stringBuilder.append("Product Store Price: ").append(product.StorePrice()).append("\n");
                stringBuilder.append("Product Retail Price: ").append(product.RetailPrice()).append("\n");
                
                int currentQuantity = (int) product.Quantity();
                stringBuilder.append("Product Quantity: ").append(currentQuantity).append("\n");
                stringBuilder.append("\n");
            } catch (RemoteException e) {
                e.printStackTrace();
            }
        }
        stringBuilder.append("Total: ").append(getTotal());
        return stringBuilder.toString();
    }

}

