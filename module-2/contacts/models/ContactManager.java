package models;

import java.util.ArrayList;

public class ContactManager {
    ArrayList<Contact> contacts;

    public ContactManager() {
        this.contacts = new ArrayList<Contact>();
    }

    public Contact getContact(int index) {
        return new Contact(contacts.get(index));
    }

    public void setContact(Contact contact, int index) {
         contacts.set(index, new Contact(contact));
    }
    /**
     * Name: addContact
     * 
     * @param contact
     * 
     * Inside the function:
     * 1. Adds a contact to the ArrayList
     */
    public void addContact(Contact contact) {
        contacts.add(new Contact(contact));
    }
    /**
     * Name: removeContact
     * 
     * @param name
     * 
     * Inside the function:
     * 1. Removes the contact that matches the name passed in
     */
    public void removeContact(String name) {
        for( int i=0; i < contacts.size(); i++) {
            if (contacts.get(i).getName().equals(name)) {
                contacts.remove(i);
            }
        }
    }

    public String toString() {
        String temp = "";
        for (int i=0; i < contacts.size(); i++) {
            temp += contacts.get(i).toString();
            temp += "\n\n";
        }
        return temp;
    }
    
}
