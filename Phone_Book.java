import java.util.Scanner;

class Contact {
    String name;
    String phoneNumber;

    public Contact(String name, String phoneNumber) {
        this.name = name;
        this.phoneNumber = phoneNumber;
    }

    @Override
    public String toString() {
        return "Name: " + name + ", Phone Number: " + phoneNumber;
    }
}

class Node {
    Contact contact;
    Node next;

    public Node(Contact contact) {
        this.contact = contact;
        this.next = null;
    }
}

class PhoneManager {
    Node head;

    public PhoneManager() {
        head = null;
    }

    public void addContact(String name, String phoneNumber) {
        Contact newContact = new Contact(name, phoneNumber);
        Node newNode = new Node(newContact);

        if (head == null) {
            head = newNode;
        } else {
            Node current = head;
            while (current.next != null) {
                current = current.next;
            }
            current.next = newNode;
        }
        System.out.println("Contact added:\n " + newContact);
    }

    public void removeContact(String name) {
        if (head == null) {
            System.out.println("Phone book is empty.");
            return;
        }

        if (head.contact.name.equals(name)) {
            head = head.next;
            System.out.println("Contact removed: " + name);
            return;
        }

        Node current = head;
        Node prev = null;
        while (current != null && !current.contact.name.equals(name)) {
            prev = current;
            current = current.next;
        }

        if (current == null) {
            System.out.println("Contact not found: " + name);
        } else {
            prev.next = current.next;
            System.out.println("Contact removed: " + name);
        }
    }

    public void displayContacts() {
        if (head == null) {
            System.out.println("Phone book is empty.");
            return;
        }

        System.out.println("Phone Book Contacts:");
        Node current = head;
        while (current != null) {
            System.out.println(current.contact);
            current = current.next;
        }
        return;
    }
}

public class Phone_Book {
    public static void main(String[] args) {
        String name,phoneNumber;
        int checkCase=1;
        PhoneManager phoneManager = new PhoneManager();
        Scanner sc = new Scanner(System.in);

    while(checkCase!=0){
        System.out.println("----------Phone Book----------\n");
        System.out.println("1.Add new Conatct\n2.Delete Contact\n3.Display all Contact\n4.Exit");
        System.out.println("\nEnter your choice :");
        int ch=sc.nextInt();

        switch (ch) {
            case 1:System.out.println("\nEnter the Name :");
                   name=sc.next();
                   System.out.println("\nEnter Mobile Number :");
                   phoneNumber=sc.next();
                   phoneManager.addContact(name,phoneNumber);
                   break;

            case 2:System.out.println("\nEnter the Name :");
                   name=sc.next();
                   phoneManager.removeContact(name);
                   break;

            case 3:phoneManager.displayContacts();
                   break;

            case 4:checkCase=0;
                   break;

            default:System.out.println("\nEnter a valid choice...");
                    break;
        }
    }
  }
}
