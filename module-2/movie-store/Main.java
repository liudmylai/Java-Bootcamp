import models.*;

public class Main {
        public static void main(String[] args) {
            // Movie movie = new Movie("Gilty", "DVD", 5);
            // System.out.println(movie);
            Store store = new Store();
            Movie movie1 = new Movie("The Shawshank Redemption", "Blue-Ray", 9.2);
            Movie movie2 = new Movie("The Godfather", "Blue-Ray", 9.1);
            Movie movie3 = new Movie("The Godfather: Part II", "DVD", 9.0);

            store.addMovie(movie1);
            store.addMovie(movie2);
            store.addMovie(movie3);

            store.action("The Godfather", "sell");  
            store.action("The Shawshank Redemption", "rent"); 
            store.action("The Shawshank Redemption", "return"); 
           
            System.out.println(store);

            
        }
}
