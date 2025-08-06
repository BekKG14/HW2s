package product;

public class DiscountProduct extends Product {
    private double baseCost;
    private double discountProcent;

    public DiscountProduct(String name, double baseCost, double discountProcent) {
        super(name);
        if (baseCost < 1 || discountProcent < 0 || discountProcent > 100) {
            throw new IllegalArgumentException();
        }
        this.baseCost = baseCost;
        this.discountProcent = discountProcent;
    }

    public String getName() {
        return name;
    }

    public void setDiscountProcent(double discountProcent) {
        this.discountProcent = discountProcent;
    }

    @Override
    public double getCost() {
        double cost = baseCost;
        if (discountProcent > 0) {
            cost = baseCost * (1 - discountProcent / 100);
            return cost;
        } else {
            throw new IllegalArgumentException("Некоректные цифры");
        }
    }

    public String toString() {
        return "Название: " + name + " стоимость: " + getCost() + " скидка: " + discountProcent + "%";
    }

    public boolean isSpecial() {
        return true;
    }

}

