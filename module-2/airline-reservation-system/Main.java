
public class Main {
    public static void main(String[] args) {
        String[] passport = {};
        Person p1 = new Person("Rayan Slim", "Canadian", "01/01/1111", 5, passport);
        p1.chooseSeat();
          



        System.out.println("Name: " + p1.getName() + "\n" + "Nationality: " + p1.getNationality() + "\n" + "Date of Birth: " + p1.getDateOfBirth() + "\n" + "Seat Number: " + p1.getSeatNumber() + "\n");
   

        if (p1.applyPassport() == true) {
            System.out.println("Congratulations" + p1.getName() + ". Your passport was approved!");
        } else {
            System.out.println("We're sorry " + p1.getName() + ". We cannot process your application.");
        }
        
    }
    
}
