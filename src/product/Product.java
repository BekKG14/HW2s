package product;

import search.Searchable;


public abstract class Product implements Searchable {
    protected final String name;

    public Product(String name) {
        if (name == null || name.isBlank()) {
            throw new IllegalArgumentException();
        }

        this.name = name;
    }

    public String getName() {
        return name;
    }

    public abstract double getCost();

    public String toString() {
        return name;
    }

    public abstract boolean isSpecial();

    @Override
    public String getSearchTerm() {
        return name;
    }

    @Override
    public String getSearchType() {
        return "PRODUCT";
    }

}