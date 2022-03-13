import java.text.ParseException;

import models.Contact;

public class Main {

    public static void main(String[] args) {
        Contact contact;
        try {
            contact = new Contact("Dima", "513666666", "10/08/1980");
            Contact cont = new Contact(contact);

            System.out.println(contact);
            System.out.println(cont);
        } catch (ParseException e) {
            e.printStackTrace();
        } finally {
            System.out.println("Process Complete");
        }
    }
}
