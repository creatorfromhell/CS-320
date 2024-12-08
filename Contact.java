package dev.cfh.contact;

/**
 * Contact
 *
 * @author creatorfromhell
 */
public class Contact {

  private final String contactID;
  private String firstName;
  private String lastName;
  private String number;
  private String address;

  public Contact(final String firstName, final String lastName, final String number, final String address) {

    this(generateContactID(), firstName, lastName, number, address);
  }

  public Contact(final String contactID, final String firstName, final String lastName, final String number, final String address) {

    //Make sure our contactID is not null, length of 0 or greater than 10 in length. if so generate a new one.
    if(contactID == null || contactID.length() == 0 || contactID.length() > 10) {

      this.contactID = generateContactID();
    } else {

      this.contactID = contactID;
    }

    //make sure firstName isn't null or empty, if so set to default.
    if(firstName == null || firstName.isEmpty()) {

      this.firstName = "First";
    } else if(firstName.length() > 10) {// check if firstName length is greater than 10 and substring

      this.firstName = firstName.substring(0, 10);
    } else {

      this.firstName = firstName;
    }

    //make sure lastName isn't null or empty, if so set to default.
    if(lastName == null || lastName.isEmpty()) {

      this.lastName = "Last";
    } else if(lastName.length() > 10) { // check if lastName length is greater than 10 and substring

      this.lastName = lastName.substring(0, 10);
    } else {

      this.lastName = lastName;
    }

    //make sure number isn't null or length is not equal to 10, if so set to default.
    if(number == null || number.length() != 10) {

      this.number = "0000000000";
    } else {

      this.number = number;
    }

    //make sure address isn't null or empty, if so set to default.
    if(address == null || address.isEmpty()) {

      this.address = "Example Address";
    } else if(address.length() > 30) { // check if address length is greater than 30 and substring

      this.address = address.substring(0, 30);
    } else {

      this.address = address;
    }
  }

  /**
   * Generates a unique contact ID. If the generated ID exceeds 10 characters, it resets to 0.
   *
   * @return a String representing the generated contact ID
   */
  public static String generateContactID() {
    // reset when our id is > 10 characters long
    if(ContactService.idGenerator.get() > 999999999) {

      ContactService.idGenerator.set(0);
    }

    return String.valueOf(ContactService.idGenerator.getAndIncrement());
  }

  public String getContactID() {

    return contactID;
  }

  public String getFirstName() {

    return firstName;
  }

  public void setFirstName(final String firstName) {

    //make sure firstName isn't null or empty, if so set to default.
    if(firstName == null || firstName.isEmpty()) {

      this.firstName = "First";
    } else if(firstName.length() > 10) {// check if firstName length is greater than 10 and substring

      this.firstName = firstName.substring(0, 10);
    } else {

      this.firstName = firstName;
    }
  }

  public String getLastName() {

    return lastName;
  }

  public void setLastName(final String lastName) {

    //make sure lastName isn't null or empty, if so set to default.
    if(lastName == null || lastName.isEmpty()) {

      this.lastName = "Last";
    } else if(lastName.length() > 10) { // check if lastName length is greater than 10 and substring

      this.lastName = lastName.substring(0, 10);
    } else {

      this.lastName = lastName;
    }
  }

  public String getNumber() {

    return number;
  }

  public void setNumber(final String number) {

    //make sure number isn't null or length is not equal to 10, if so set to default.
    if(number == null || number.length() != 10) {

      this.number = "0000000000";
    } else {

      this.number = number;
    }
  }

  public String getAddress() {

    return address;
  }

  public void setAddress(final String address) {

    //make sure address isn't null or empty, if so set to default.
    if(address == null || address.isEmpty()) {

      this.address = "Example Address";
    } else if(address.length() > 30) { // check if address length is greater than 30 and substring

      this.address = address.substring(0, 30);
    } else {

      this.address = address;
    }
  }
}