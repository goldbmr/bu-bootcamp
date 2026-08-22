// Michael Goldblatt - U98235562
// Module 3: Contact Manager v1.0 - 2026.08.21
import java.util.*; 
 
public class ContactManager { 
 
    public static void main(String[] args) { 
 
        HashMap<String, Contact> contacts = new HashMap<>(); 
 
        // Step 4: add contacts here 
        contacts.put("Jim Antunes", new Contact("Jim Antunes", "+1 617 534 0221"));
        contacts.put("Nelson Livingston", new Contact("Nelson Livingston", "+1 617 619 3322"));
        contacts.put("Sam Haque", new Contact("Sam Haque", "+1 860 634 2534"));
        contacts.put("Rocky Samson", new Contact("Rocky Samson", "+1 860 412 7179"));
        contacts.put("Ada Lovelace", new Contact("Ada Lovelace", "+1 617 555 0101")); 

        // Step 5: look up a contact 
        contacts.get("Ada Lovelace");

        if (contacts.containsKey("Ada Lovelace")) {
            System.out.println(contacts.get("Ada Lovelace"));
        } else {
            System.out.println("Contact not found.");
        }
        
        // Step 6: print sorted list 
        System.out.println("=== All Contacts ===");
        ArrayList<Contact> sorted = new ArrayList<>(contacts.values());
        sorted.sort((a, b) -> a.getName().compareTo(b.getName()));  

        for (Contact c : sorted) {
            System.out.println(c);
        }
    } 
}