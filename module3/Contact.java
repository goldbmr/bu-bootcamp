// Michael Goldblatt - U98235562
// Module 3: Contact Manager v1.0 - 2026.08.21
public class Contact{ 
 
    // Fields
    private String  name; 
    private String  phone;
   
 
    // Constructor 
    public Contact(String name, String phone) { 
        this.name   = name;     // 'this.name' is the field; 'name' is the parameter 
        this.phone = phone;
    } 
 
    // Getter
    public String  getName()   { return name; } 
    public String  getPhone()   { return phone; } 

 
    // Print to string 
    @Override 
    public String toString() { 
        return name + " | " + phone;
    } 
} 