package basket;
import product.Product;

public class ProductBasket {
    private Product[] products;
    private int size;

    public ProductBasket(int capacity) {
        products = new Product[capacity];
        size = 0;
    }
    int i = 2;

    public void addProduct(Product product) {
        if (size < products.length) {
            products[size++] = product;
        } else {
            System.out.println("КОРЗИНА ПЕРЕПОЛНЕНА");
        }
    }

    public int isSpecialCount() {
        int count = 0;
        for (int i = 0; i < size; i++) {
            if (products[i].isSpecial() == true) {
                count = count + 1;
            }
        }
        return count;
    }

    public double totalCost() {
        double amount = 0;
        for (int i = 0; i < size; i++) {
            if (products[i] != null) {
                amount = amount + products[i].getCost();
            }
        }
        return amount;
    }

    public void printAllProducts() {
        if (size == 0) {
            System.out.println("Корзина пуста");
        } else {
            for (int i = 0; i < size; i++) {
                System.out.println(products[i]);
            }
        }
    }

    public boolean checkProduct(Product product) {
        for (int i = 0; i < size; i++) {
            if (products[i] != null && products[i].equals(product)) {
                return true;
            }
        }
        return false;
    }

    public void clearBasket() {
        for (int i = 0; i < size; i++) {
            products[i] = null;
        }
    }

    public Product getProduct(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Неверный индекс " + index);
        }
        System.out.println(products[index]);
        return products[index];


    }
}