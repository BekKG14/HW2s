package basket;
import product.Product;

import java.security.Key;
import java.util.*;

public class ProductBasket<P extends Product> {
    private final HashMap<String, List <P>> products;

    public ProductBasket() {
        this.products = new HashMap<>();
    }

    public void addProduct( P p) {
        products.computeIfAbsent(p.getName(), k -> new ArrayList<>()).add(p);
    }

    public int isSpecialCount() {
        int count = 0;
        for(Map.Entry<String, List<P>> entry : products.entrySet()){
        for (P product : entry.getValue()) {
            if (product.isSpecial()) {
                count = count + 1;
            }
        }
        }
        return count;
    }

    public double totalCost() {
        double amount = 0;
        for (Map.Entry<String, List<P>> entry : products.entrySet()) {
            for (P product : entry.getValue()) {
                amount = amount + product.getCost();
            }
        }
        return amount;
    }

    public void printAllProducts() {
        if (products.isEmpty()) {
            System.out.println("Корзина пуста");
        } else {
            for (Map.Entry<String, List<P>> entry : products.entrySet()){
                    for (P product : entry.getValue()) {
                        System.out.println(product.toString());
                    }
        }
        }
    }

    public boolean checkProduct(Product p) {
        for (Map.Entry<String, List<P>> entry : products.entrySet()) {
        for (P product : entry.getValue()) {
            if (product != null && product.equals(p)) {
                return true;
            }
        }
        }
        return false;
    }

    public void clearBasket() {
            products.clear();
        }


//    public Product getProduct(int index) {
//        if (index < 0 || index >= products.size()) {
//            throw new IndexOutOfBoundsException("Неверный индекс " + index);
//        }
//        return products.get(index);
//    }

    public List<P> removeByName(String name) {
        List<P> removedList = products.remove(name);
        if (removedList == null){
            return new LinkedList<>();
        }

        return removedList;
    }
}