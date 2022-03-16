import models.*;

public class Main {
    public static void main(String[] args) {
        Item item1 = new Item("Celery", 0.99);
        Item item2 = new Item("Spinach", 0.99);
        Item item3 = new Item("Coriander", 1.29);
        
        System.out.println(item1 + " " + item2 + " " + item3); 

    }


}
