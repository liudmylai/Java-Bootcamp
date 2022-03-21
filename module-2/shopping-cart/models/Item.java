package models;

public class Item {
    private String name;
    private double price;

    public Item (String name, double price) {
        if (name == null || name.isBlank()) {
            throw new IllegalArgumentException("Name cannot be null or blank");
        }
        this.name = name;
        if (price < 0) {
            throw new IllegalArgumentException("Price cannot be less than 0");
        }
        this.price = price;
    }
    public Item(Item source) {
        this.name = source.name;
        this.price = source.price;
    }

    public String getName() {
        return this.name;
    }
    public double getPrice() {
        return this.price;
    }
    public void setName(String name) {
        if (name == null || name.isBlank()) {
            throw new IllegalArgumentException("Name cannot be null or blank");
        }
        this.name = name;
    }
    public void setPrice(double price) {
        if (price < 0) {
            throw new IllegalArgumentException("Price cannot be less than 0");
        }
        this.price = price;
    }

    public String toString() {
        return name + ": $" + price + " ";
    }
    // customized equals() method
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (!(obj instanceof Item)) {
            return false;
        }
        // typecast a parameter to the type Item
        Item item = (Item)obj;
        // compare every field of both objects and return boolean result
        return this.name.equals(item.name) && this.price == item.price;
    }



}