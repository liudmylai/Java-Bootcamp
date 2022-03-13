import java.text.ParseException;

import models.Contact;

public class Main {

    public static void main(String[] args) {
        Contact contact;
        try {
            contact = new Contact("Dima", "5133060054", "10/08/1980");
            System.out.println(contact);
        } catch (ParseException e) {
            e.printStackTrace();
        } finally {
            System.out.println("Process Complete");
        }
    }
}
