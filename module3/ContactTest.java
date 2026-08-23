import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*; 
 
public class ContactTest {
 
 private Contact contact; 
 
  @BeforeEach
  void setUp() {
    contact = new Contact("Ada Lovelace", "+1 617 555 0101");
  } 
 
  @Test
  void getName_returnsCorrectName() {
    assertEquals("Ada Lovelace", contact.getName());
  } 
 
  @Test
  void getPhone_returnsCorrectPhone() {
    assertEquals("+1 617 555 0101", contact.getPhone());
  } 
 
  @Test
  void toString_containsBothFields() {
    assertTrue(contact.toString().contains("Ada Lovelace"));
    assertTrue(contact.toString().contains("+1 617 555 0101"));
  }
  //Additional test same contact name against different phone numbers
  @Test
  void twoContacts_sameNameDifferentPhone_areIndependent() {
    Contact contact1 = new Contact("Jim Antunes", "+1 617 502 1021");
    Contact contact2 = new Contact("Jim Antunes", "+1 617 555 0133");
    
    assertNotEquals(contact1.getPhone(), contact2.getPhone());
  }
} 