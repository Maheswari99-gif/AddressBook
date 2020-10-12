import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class AddressBookMain {
	static Scanner sc = new Scanner(System.in);
	public static String bookname;
	public static String name;
	public List<ContactDetails> contacts;
	public Map<String, ContactDetails> nameToContactMap;

	public AddressBookMain(String name) {
		super();
		this.bookname = name;
		this.contacts = new LinkedList<ContactDetails>();
		this.nameToContactMap = new LinkedHashMap<String, ContactDetails>();
	}

	public void addContact() {
		do {
			System.out.println("Enter the contact details in the given order:\nfirstname\nlastname");
			ContactDetails checkContact = new ContactDetails(sc.nextLine(), sc.nextLine());
			if (contacts.stream().anyMatch(contact -> contact.equals(checkContact))) {
				System.out.println("Same entry already present.");
			} else {
				System.out.println(
						"Enter the contact details in the given order:\nfirstname\nlastname\naddress\nstate\nzip\nphone no.\nemail");
				ContactDetails newContact = new ContactDetails(sc.nextLine(), sc.nextLine(), sc.nextLine(),sc.nextLine(),
						Integer.parseInt(sc.nextLine()), Long.parseLong(sc.nextLine()), sc.nextLine());
				this.contacts.add(newContact);
				this.nameToContactMap.put(newContact.getFirstName() + " " + newContact.getLastName(), newContact);
			}
			System.out.println("Enter 1 to add another contact, else enter 0: ");
		} while (Integer.parseInt(sc.nextLine()) == 1);
	}

	public static void main(String[] args) {
		System.out.println("Enter the name of the addressbook:");
		String book = sc.nextLine();
		AddressBookMain addressBook = new AddressBookMain(bookname);
		addressBook.addContact();
	}
}
