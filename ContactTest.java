package dev.cfh.contact;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.fail;

/**
 * ContactTest
 *
 * @author creatorfromhell
 */
public class ContactTest {

  @Test
  @DisplayName("Contact ID cannot be longer than 10 characters")
  void testContactIDMoreThanTen() {

    final Contact contact = new Contact("First", "Last", "0000000000", "Address");
    if(contact.getContactID().length() > 10) {
      fail("Contact ID is longer than 10 characters");
    }
  }

  @Test
  @DisplayName("Check setters for setting correct values.")
  void testSettersSetting() {
    final Contact contact = new Contact("John", "Doe", "1234567890", "123 Main St");

    contact.setFirstName("Jane");
    assertEquals("Jane", contact.getFirstName());

    contact.setLastName("NotDoe");
    assertEquals("NotDoe", contact.getLastName());

    contact.setNumber("1111111111");
    assertEquals("1111111111", contact.getNumber());

    contact.setAddress("321 Main St");
    assertEquals("321 Main St", contact.getAddress());
  }

  @Test
  @DisplayName("Check setters for value parsing when invalid value passed.")
  void testSettersValidation() {
    final Contact contact = new Contact("John", "Doe", "1234567890", "123 Main St");

    contact.setFirstName("VeryLongFirstName");
    assertEquals("VeryLongFi", contact.getFirstName());

    contact.setLastName(null);
    assertEquals("Last", contact.getLastName());

    contact.setNumber("123");
    assertEquals("0000000000", contact.getNumber());

    contact.setAddress("This address is way too long for the system to handle properly");
    assertEquals("This address is way too long f", contact.getAddress());
  }

  @Test
  @DisplayName("Check Default Values for invalid parameters passed.")
  void testDefaultValuesForInvalidInputs() {

    final Contact contact = new Contact(null, "", "123", null);
    assertEquals("First", contact.getFirstName());
    assertEquals("Last", contact.getLastName());
    assertEquals("0000000000", contact.getNumber());
    assertEquals("Example Address", contact.getAddress());
  }
}