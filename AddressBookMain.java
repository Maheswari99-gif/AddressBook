import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeMap;
import java.util.stream.Collectors;

public class AddressBookMain {
	private static final String CITY = "CITY";
	private static final String STATE = "STATE";
	static Scanner sc = new Scanner(System.in);
	public static String bookname;
	public static String name;
	public List<ContactDetails> contacts;
	public Map<String, ContactDetails> nameToContactMap;
	static Map<String, AddressBookMain> nameToAddressBookMap = new HashMap<String, AddressBookMain>();
	public Map<String, List<ContactDetails>> cityToContactsMap;
	public Map<String, List<ContactDetails>> stateToContactsMap;

	public AddressBookMain(String name) {
		super();
		this.bookname = name;
		this.contacts = new LinkedList<ContactDetails>();
		this.nameToContactMap = new LinkedHashMap<String, ContactDetails>();
		this.cityToContactsMap = new TreeMap<String, List<ContactDetails>>();
		this.stateToContactsMap = new TreeMap<String, List<ContactDetails>>();
	}

	// usecase7//
	/**
	 * 
	 */

	public void addContact() {
		do {
			System.out.println("Enter the contact details in the given order:\nfirstname\nlastname");
			ContactDetails checkContact = new ContactDetails(sc.nextLine(), sc.nextLine());
			if (contacts.stream().anyMatch(contact -> contact.equals(checkContact))) {
				System.out.println("Same entry already present.");
			} else {
				System.out.println(
						"Enter the contact details in the given order:\nfirstname\nlastname\naddress\nstate\nzip\nphone no.\nemail");
				ContactDetails newContact = new ContactDetails(sc.nextLine(), sc.nextLine(), sc.nextLine(),
						sc.nextLine(), Integer.parseInt(sc.nextLine()), Long.parseLong(sc.nextLine()), sc.nextLine());
				this.contacts.add(newContact);
				this.nameToContactMap.put(newContact.getFirstName() + " " + newContact.getLastName(), newContact);
			}
			System.out.println("Enter 1 to add another contact, else enter 0: ");
		} while (Integer.parseInt(sc.nextLine()) == 1);
	}

	// usecase8//
	public static void getPersonsByCityOrState() {
		System.out.println("Choose \n1 To search by city\n2 To search by state\nEnter your choice: ");
		String option = (Integer.parseInt(sc.nextLine()) == 1) ? CITY : STATE;
		System.out.println("Enter the name of " + option + ": ");
		String cityOrStateName = sc.nextLine();
		nameToAddressBookMap.keySet().stream().forEach(addressBookName -> {
			AddressBookMain addressBook = nameToAddressBookMap.get(addressBookName);
			System.out.println("Persons in the " + option + " " + cityOrStateName + " in the address book "
					+ addressBookName + " are: ");
			addressBook.contacts.stream().filter(
					contact -> ((option == CITY ? contact.getAddress() : contact.getState()).equals(cityOrStateName)))
					.forEach(contact -> System.out.println(contact));
			System.out.println("");
		});
	}

	// usecase9//
	/**
	 * 
	 */
	public void generateContactsListByCityAndState() {
		Set<String> cityNames = contacts.stream().map(contact -> contact.getAddress()).collect(Collectors.toSet());
		Set<String> stateNames = contacts.stream().map(contact -> contact.getState()).collect(Collectors.toSet());
		this.cityToContactsMap = cityNames.stream().collect(Collectors.toMap(cityName -> cityName, cityName -> {
			return contacts.stream().filter(contact -> contact.getAddress().equals(cityName)).sorted((c1, c2) -> {
				return c1.getFirstName().compareTo(c2.getFirstName());
			}).collect(Collectors.toList());
		}));
		this.stateToContactsMap = stateNames.stream().collect(Collectors.toMap(stateName -> stateName, stateName -> {
			return contacts.stream().filter(contact -> contact.getState().equals(stateName)).sorted((c1, c2) -> {
				return c1.getFirstName().compareTo(c2.getFirstName());
			}).collect(Collectors.toList());
		}));
	}

	public static void viewPersonsByCityOrState() {
		System.out.println("Choose \n1 To view by city\n2 To view by state\nEnter your choice: ");
		String option = (Integer.parseInt(sc.nextLine()) == 1) ? CITY : STATE;
		nameToAddressBookMap.keySet().stream().forEach(addressBookName -> {
			AddressBookMain addressBook = nameToAddressBookMap.get(addressBookName);
			addressBook.generateContactsListByCityAndState();
			System.out.println("In the address book " + addressBookName);
			System.out.println("");
			(option == CITY ? addressBook.cityToContactsMap.keySet() : addressBook.stateToContactsMap.keySet()).stream()
					.forEach(cityOrStateName -> {
						System.out.println(option + ": " + cityOrStateName);
						(option == CITY ? addressBook.cityToContactsMap.get(cityOrStateName)
								: addressBook.stateToContactsMap.get(cityOrStateName)).stream()
										.forEach(contact -> System.out.println(contact));
						System.out.println("");
					});
			System.out.println("");
		});
	}

	public static void addAddressBooks() {
		int choice = 1;
		while (choice == 1) {
			System.out.println("Enter your choice 1 or 0 or 2: ");
			choice = Integer.parseInt(sc.nextLine());
			if (choice == 1) {
				System.out.println("Enter name of the address book");
				String name = sc.nextLine();
				nameToAddressBookMap.put(name, new AddressBookMain(name));
			} else if (choice == 2)
				break;
			else {
				System.out.println("Invalid");
			}
		}
	}

	public static void main(String[] args) {
		addAddressBooks();
		do {
			System.out.println("Enter the name of the address book to continue: ");
			AddressBookMain addressBook = nameToAddressBookMap.get(sc.nextLine());
			addressBook.addContact();
			System.out.println(addressBook);
			System.out.println("Enter 1 to continue with another address book, else enter 0: ");
		} while (Integer.parseInt(sc.nextLine()) == 1);
		getPersonsByCityOrState();
		 viewPersonsByCityOrState()
		sc.close();
	}

}
