import java.text.ParseException;

import models.Contact;
import models.ContactManager;

public class Main {

    public static void main(String[] args) {
        // Contact contact;
        try {
            // contact = new Contact("Dima", "513666666", "10/08/1980");
            ContactManager manager = new ContactManager();
            manager.addContact(new Contact("Ryan", "6135012424", "11/11/1992"));
            manager.addContact(new Contact("Gio", "6477092344 ", "11/11/1993"));
            manager.addContact(new Contact("Thomas ", "8192256979 ", "11/11/1994"));
            manager.removeContact("Gio");
            System.out.println(manager);

        } catch (ParseException e) {
            e.printStackTrace();
        } finally {
            System.out.println("Process Complete");
        }

    }
}
