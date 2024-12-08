package dev.cfh.contact;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;

/**
 * ContactServiceTest
 *
 * @author creatorfromhell
 */
public class ContactServiceTest {

  private ContactService service;

  @BeforeEach
  void setUp() {
    service = new ContactService();
  }

  @Test
  @DisplayName("Test adding contact to service and retrieving.")
  void testAddAndRetrieveContact() {
    //Reset ID:
    ContactService.idGenerator.set(0);

    //add contact
    service.addContact("John", "Doe", "1234567890", "123 Main St");

    //Retrieve contact
    final Contact contact = service.getContact("0"); // First contact should have ID "0"
    assertNotNull(contact);
    assertEquals("John", contact.getFirstName());
    assertEquals("Doe", contact.getLastName());
  }

  @Test
  @DisplayName("Test updating contact's first name")
  void testUpdateFirstName() {
    //Reset ID:
    ContactService.idGenerator.set(0);

    // Add a new contact with initial details
    service.addContact("John", "Doe", "1234567890", "123 Main St");

    // Update the first name of the contact with ID "0"
    service.updateFirstName("0", "Jane");

    // Retrieve the updated contact
    final Contact contact = service.getContact("0");

    // Assert that the first name was updated correctly
    assertEquals("Jane", contact.getFirstName());
  }

  @Test
  @DisplayName("Test updating contact's last name")
  void testUpdateLastName() {
    //Reset ID:
    ContactService.idGenerator.set(0);

    // Add a new contact with initial details
    service.addContact("John", "Doe", "1234567890", "123 Main St");
    // Update the last name of the contact with ID "0"
    service.updateLastName("0", "Smith");

    // Retrieve the updated contact
    final Contact contact = service.getContact("0");

    // Assert that the last name was updated correctly
    assertEquals("Smith", contact.getLastName());
  }

  @Test
  @DisplayName("Test updating contact's number")
  void testUpdateNumber() {
    //Reset ID:
    ContactService.idGenerator.set(0);

    // Add a new contact with initial details
    service.addContact("John", "Doe", "1234567890", "123 Main St");
    // Update the phone number of the contact with ID "0"
    service.updateNumber("0", "0987654321");

    // Retrieve the updated contact
    final Contact contact = service.getContact("0");

    // Assert that the phone number was updated correctly
    assertEquals("0987654321", contact.getNumber());
  }

  @Test
  @DisplayName("Test updating contact's address")
  void testUpdateAddress() {
    //Reset ID:
    ContactService.idGenerator.set(0);

    // Add a new contact with initial details
    service.addContact("John", "Doe", "1234567890", "123 Main St");
    // Update the address of the contact with ID "0"
    service.updateAddress("0", "456 Elm St");

    // Retrieve the updated contact
    final Contact contact = service.getContact("0");

    // Assert that the address was updated correctly
    assertEquals("456 Elm St", contact.getAddress());
  }

  @Test
  @DisplayName("Test adding contact to service and deleting")
  void testDeleteContact() {
    //Reset ID:
    ContactService.idGenerator.set(0);

    //add contact
    service.addContact("John", "Doe", "1234567890", "123 Main St");
    assertNotNull(service.getContact("0"));

    //Delete contact
    service.deleteContact("0");
    assertNull(service.getContact("0"));
  }

  @Test
  @DisplayName("Test adding contacts to service and displaying.")
  void testDisplayContacts() {
    //Reset ID:
    ContactService.idGenerator.set(0);

    //Add contacts for display test.
    service.addContact("John", "Doe", "1234567890", "123 Main St");
    service.addContact("Jane", "Smith", "0987654321", "456 Elm St");

    // Simple check to ensure no exceptions during display.
    assertDoesNotThrow(() -> service.displayContacts());
  }
}