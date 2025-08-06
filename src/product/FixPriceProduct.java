package product;

public class FixPriceProduct extends Product {
    private final double fixedCost;

    public FixPriceProduct(String name, double fixedCost) {
        super(name);
        this.fixedCost = fixedCost;
    }

    public double getCost() {
        return fixedCost;
    }

    public String getName() {
        return name;
    }

    public String toString() {
        return "Назавние товара: " + name + " фиксированная стоимость: " + fixedCost;
    }

    @Override
    public boolean isSpecial() {
        return true;
    }

}
