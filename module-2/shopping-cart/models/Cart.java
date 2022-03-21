package models;

import java.text.DecimalFormat;
import java.util.ArrayList;

public class Cart {
    private ArrayList<Item> items;

    public Cart() {
        this.items = new ArrayList<Item>();
    }
    public Item getItem(int index) {
        return new Item(this.items.get(index));
    }
    public void setItem(int index, Item item) {
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
    // public boolean add(Item item) {
    //         if (this.items.contains(item)) {
    //             return false;
    //         }
    //         this.items.add(new Item(item));
    //         return true; 
    //     }
    
    // public boolean isEmpty() {
    //     return this.items.isEmpty();
    // }
       
    /**
    * Name: remove
    * @param name
    *
    * Inside the function:
    *   1. Removes the item that matches the name passed in.
    */
    // public void remove(String name) {
    //     if (items.isEmpty()) {
    //         throw new IllegalStateException("Cannot remove from an empty cart");
    //     }
    //     for (int i=0; i < this.items.size(); i++) {
    //         if (this.items.get(i).getName().equals(name)) {
    //             this.items.remove(i);
    //         }
    //     }
    // }
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
    // public String checkOut() {
    //     if (items.isEmpty()) {
    //         throw new IllegalStateException("Cannot checkout an empty cart");
    //     }
    //     double[] measures = new double[3];
    //     // double subtotal = 0;
    //     for (int i = 0; i < this.items.size(); i++) {
    //         measures[0] += this.items.get(i).getPrice();
    //         // subtotal += this.items.get(i).getPrice();
    //     }
    //     measures[1] = measures[0] * 0.13;
    //     // double tax = subtotal * 0.13;
    //     measures[2] = measures[0] + measures[1];
    //     // double total = subtotal + tax;
    //     return  "\tRECEIPT\n\n" +
    //     "\tSubtotal: $" + measures[0] + "\n" +
    //     "\tTax: $" + measures[1] + "\n" +
    //     "\tTotal: $" + measures[2] + "\n";
    // }

    public String toString() {
        String temp = "";
        for (int i = 0; i < this.items.size(); i++) {
            temp += this.items.get(i).toString();
            temp += "\n";
        }
        return temp;
    }

    /**
    * Function name: add
    * @param item 
    * @return (boolean)
    * Inside the function:
    *   1. returns false if item exists.
    *   2. adds an Item object
    *   3. returns true if item gets added
    */
    public boolean add(Item item) {
        if (this.items.contains(item)) {
            return false;
        }
        this.items.add(new Item(item));
        return true;
    }

    /**
     * Function name: contains
    * @param item
    * @return (boolean)
    * 
    * Inside the function:
    *    1. checks if items list contains() item.
    */
    public boolean contains(Item item) {
        return this.items.contains(item);
        
    }

    public void clear() {
        this.items.clear();
    }

      /**
     * Function name: remove
     * @param name
     * 
     * Inside the function:
     *   1. nothing
     */
    public void remove(String name) {
        if (this.items.isEmpty()) {
            throw new IllegalStateException("Invalid state"); 
        }
        this.items.removeIf(item -> item.getName().equals(name));
        // for(int i=0; i < this.items.size(); i++) {
        //     if (this.items.get(i).getName().equals(name)) {
        //         this.items.remove(i);
        //     }
        // }
    }

    /**
    * Function name: getSubtotal
    * @return double
    * 
    * Inside the function:
    *   1. loop runs through the size of the ArrayList.
    *   2. adds the price field of each Item object. 
    *   3. returns the sum
    */
    public double getSubtotal() {
        return this.items.stream()
        .mapToDouble(item -> item.getPrice())
        .sum();
        // double subtotal = 0;
        // for (int i =0; i < this.items.size(); i++) {
        //     subtotal += this.items.get(i).getPrice();
        // }
        // return subtotal;
    }

    /**
    * Function name: getTax
    * @param double (subtotal)
    * @return double
    * 
    * Inside the function:
    *   1. calculates tax
    *   2. rounds to two decimal places
    *   3. returns the result
    */
    public double getTax(double subtotal) {
        DecimalFormat formatter = new DecimalFormat("#.##");
        return Double.parseDouble(formatter.format(subtotal * 0.13)); 
    }

    /**
    * Function name: getTotal
    * @param double (subtotal)
    * @param double (tax)
    * @return (double)
    * 
    * Inside the function:
    *   1. returns subtotal + tax
    */
    public double getTotal(double subtotal, double tax) {
        return subtotal + tax;
    }

    public String checkout() {
        if (this.items.isEmpty()) {
            throw new IllegalStateException("Invalid state"); 
        }
        return "\tRECEIPT\n\n" +
        "\tSubtotal: $" + getSubtotal() + "\n" +
        "\tTax: $" + getTax(getSubtotal()) + "\n" +
        "\tTotal: $" + getTotal(getSubtotal(), getTax(getSubtotal())) + "\n";
    } 





}
