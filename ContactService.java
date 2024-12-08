package dev.cfh.contact;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * ContactService
 *
 * @author creatorfromhell
 */
public class ContactService {

  //Initialize the AtomicInteger to generate IDs for contacts.
  public static AtomicInteger idGenerator = new AtomicInteger();

  //Map to hold our contacts in format of ContactID, Contact Object
  final Map<String, Contact> contacts = new HashMap<>();

  public void displayContacts() {
    for(final Map.Entry<String, Contact> entry : contacts.entrySet()) {

      System.out.println("Contact ID: " + entry.getKey());
      System.out.println("Contact firstName: " + entry.getValue().getFirstName());
      System.out.println("Contact lastName: " + entry.getValue().getLastName());
      System.out.println("Contact number: " + entry.getValue().getNumber());
      System.out.println("Contact address: " + entry.getValue().getAddress());
      System.out.println();
    }
  }

  public void addContact(final String firstName, final String lastName, final String number, final String address) {

    final Contact contact = new Contact(firstName, lastName, number, address);
    addContact(contact);
  }

  public void addContact(final String contactID, final String firstName, final String lastName, final String number, final String address) {

    final Contact contact = new Contact(contactID, firstName, lastName, number, address);
    addContact(contact);
  }

  public void addContact(final Contact contact) {

    contacts.put(contact.getContactID(), contact);
  }

  public Contact getContact(final String contactID) {

    return contacts.get(contactID);
  }

  public void deleteContact(final String contactID) {

    contacts.remove(contactID);
  }

  public void updateFirstName(final String contactID, final String newFirstName) {

    if(contacts.containsKey(contactID)) {

      contacts.get(contactID).setFirstName(newFirstName);
    }
  }

  public void updateLastName(final String contactID, final String newLastName) {

    if(contacts.containsKey(contactID)) {

      contacts.get(contactID).setLastName(newLastName);
    }
  }

  public void updateNumber(final String contactID, final String newNumber) {

    if(contacts.containsKey(contactID)) {

      contacts.get(contactID).setNumber(newNumber);
    }
  }

  public void updateAddress(final String contactID, final String newAddress) {

    if(contacts.containsKey(contactID)) {

      contacts.get(contactID).setAddress(newAddress);
    }
  }
}