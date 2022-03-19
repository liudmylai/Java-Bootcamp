package main;

import java.text.DecimalFormat;

public class Main {
    
    static double[] prices = new double[] {2.23, 1.32, 4.32, 11.33};

    public static void main(String[] args) {   


    }
    public static double getSubtotal() {
        double subtotal = 0;
        for (int i = 0; i < prices.length; i++) {
            subtotal += prices[i];
        }
        return subtotal;
    }

    public static double getTax(double subtotal) {
        DecimalFormat formatter = new DecimalFormat("#.##");
        return Double.parseDouble(formatter.format(subtotal * 0.13));
    }

    public static double getTotal(double subtotal, double tax) {
        return subtotal + tax;
    }
}