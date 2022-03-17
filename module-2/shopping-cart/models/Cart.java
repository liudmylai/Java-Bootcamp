package models;

import java.util.ArrayList;

public class Cart {
    ArrayList<Item> items;

    public Cart() {
        this.items = new ArrayList<Item>();
    }
    public Item getItem(int index) {
        return new Item(this.items.get(index));
    }
    public void setItem(Item item, int index) {
        this.items.set(index, new Item(item));
    }
     /**
     * Name: add
    * @param item
    * @return boolean
    *
    * Inside the function:
    *   1. Adds an item to the cart if it wasn't already added.
    */
    public boolean add(Item item) {
            if (this.items.contains(item)) {
                return false;
            }
            this.items.add(new Item(item));
            return true; 
        }
    /**
    * Name: remove
    * @param name
    *
    * Inside the function:
    *   1. Removes the item that matches the name passed in.
    */
    public void remove(String name) {
        for (int i=0; i < this.items.size(); i++) {
            if (this.items.get(i).getName().equals(name)) {
                this.items.remove(i);
            }
        }
    }
    /**
    *  Name: checkout
    *  @return (String)
    *
    *  Inside the function:
    *   1. Calculates the subtotal (price before tax).
    *   2. Calculates the tax (assume tax is 13%).
    *   3. Calculates total: subtotal + tax
    *   4. Returns a String that resembles a receipt. See below.
    */
    public String checkOut() {
        double subtotal = 0;
        for (int i = 0; i < this.items.size(); i++) {
            subtotal += this.items.get(i).getPrice();
        }
        double tax = subtotal * 13 / 100;
        double total = subtotal + tax;
        return  "\tRECEIPT\n\n" +
        "\tSubtotal: $" + subtotal + "\n" +
        "\tTax: $" + tax + "\n" +
        "\tTotal: $" + total + "\n";
    }

    public String toString() {
        String temp = "";
        for (int i = 0; i < this.items.size(); i++) {
            temp += this.items.get(i).toString();
            temp += "\n";
        }
        return temp;
    }



}
