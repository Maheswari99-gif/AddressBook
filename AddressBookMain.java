import java.util.*;

public class AddressBookMain {
	private ArrayList<ContactDetails> contactArrayList;
	private Map<String, ContactDetails> nameToContactDetailsMap;

	private AddressBookMain() {
		contactArrayList = new ArrayList<>();
		nameToContactDetailsMap = new HashMap<>();
	}

	/**
	 * @param firstName
	 * @param lastName
	 * @param address
	 * @param state
	 * @param zip
	 * @param phoneNo
	 * @param emailId
	 */
	private void addContactDetails(String firstName, String lastName, String address, String state, int zip,
			long phoneNo, String emailId) {
		ContactDetails contactDetail = new ContactDetails();
		contactDetail.setContactDetails(firstName, lastName, address, state, zip, phoneNo, emailId);
		contactArrayList.add(contactDetail);
		nameToContactDetailsMap.put(state, contactDetail);
		nameToContactDetailsMap.put(address, contactDetail);
	}

	/**
	 * @param name
	 */
	int count=0;
	private void searchbyCity(String address) {
		ContactDetails contactObj = nameToContactDetailsMap.get(address);
		count++;
		System.out.println(contactObj);
	
	if(count==0) {
		System.out.println("No persons");
	}
	else
		System.out.println(" "+count+ "Persons are there in this address");
	}

	/**
	 * @param state
	 */
	private void searchbyState(String state) {
		ContactDetails contactObj = nameToContactDetailsMap.get(state);
		count++;
		System.out.println(contactObj);
		if(count==0) {
			System.out.println("No persons");
		}
		else
			System.out.println(" "+count+ "Persons are there in this state");
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		AddressBookMain addressBook = new AddressBookMain();
		System.out.println("No. of contact details to enter: ");
		int numOfContact = sc.nextInt();
		sc.nextLine();
		for (int i = 0; i < numOfContact; i++) {
			System.out.println("First Name: ");
			String firstName = sc.nextLine();
			System.out.println("Last Name: ");
			String lastName = sc.nextLine();
			System.out.println("Address: ");
			String address = sc.nextLine();
			System.out.println("State: ");
			String state = sc.nextLine();
			System.out.println("ZIP: ");
			int zip = sc.nextInt();
			System.out.println("Phone No: ");
			long phoneNo = sc.nextLong();
			sc.nextLine();
			System.out.println("Email ID: ");
			String emailId = sc.nextLine();
			addressBook.addContactDetails(firstName, lastName, address, state, zip, phoneNo, emailId);
		}
		System.out.println("Enter name of city you want to persons of: ");
		String city = sc.nextLine();
		addressBook.searchbyCity(city);
		System.out.println("Enter name of state you want to persons of: ");
		String state = sc.nextLine();
		addressBook.searchbyState(state);
	}
}