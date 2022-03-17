import models.*;

public class Main {
    public static void main(String[] args) {
       Cart cart = new Cart();
        
       cart.add(new Item("Celery", 0.99));

       cart.add(new Item("Celery", 0.99));
       
       cart.add(new Item("Spinach", 0.99));
       
       cart.add(new Item("Coriander", 1.29));

       System.out.println(cart);

    }


}
