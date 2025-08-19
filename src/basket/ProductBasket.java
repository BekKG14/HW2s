package basket;
import product.Product;

import java.util.LinkedList;
import java.util.List;

public class ProductBasket<P extends Product> {
    private final LinkedList<P> products;

    public ProductBasket() {
        this.products = new LinkedList<>();
    }


    public void addProduct(P product) {
        products.add(product);
    }

    public int isSpecialCount() {
        int count = 0;
        for (P product : products) {
            if (product.isSpecial()) {
                count = count + 1;
            }
        }
        return count;
    }

    public double totalCost() {
        double amount = 0;
        int place = 0;
        for (P product : products) {
                amount = amount + product.getCost();
                place++;
        }
        return amount;
    }

    public void printAllProducts() {
        if (products.isEmpty()) {
            System.out.println("Корзина пуста");
        } else {
            for (P product : products) {
                System.out.println(product.toString());
            }
        }
    }

    public boolean checkProduct(Product p) {
        for (P product : products) {
            if (product != null && product.equals(p)) {
                return true;
            }
        }
        return false;
    }

    public void clearBasket() {
            products.clear();
        }
    public Product getProduct(int index) {
        if (index < 0 || index >= products.size()) {
            throw new IndexOutOfBoundsException("Неверный индекс " + index);
        }
        return products.get(index);
    }

    public List<P> removeByName(String name) {
        List<P> removedList = new LinkedList<>();
        String prod = "";
        for (int i = 0; i < products.size(); i++) {
            prod = products.get(i).getName();
            if ( prod.equalsIgnoreCase(name)){
                removedList.add(products.get(i));
                products.remove(i);
                i--;
            }
        }
        return removedList;
    }
}