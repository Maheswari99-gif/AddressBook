import java.util.*;

public class AddressBookMain {
	
	private ArrayList<ContactDetails> contactArrayList;
	private Map<String, ContactDetails> nameToContactDetailsMap;
	private AddressBookMain() {
		contactArrayList = new ArrayList<>(); 
		nameToContactDetailsMap = new HashMap<>();
	}
	
	private void addContactDetails(String firstName, String lastName, String address, String state, int zip, long phoneNo, String emailId) {
		ContactDetails contactDetail = new ContactDetails();
		contactDetail.setContactDetails(firstName, lastName, address, state, zip, phoneNo, emailId);
		contactArrayList.add(contactDetail);
		nameToContactDetailsMap.put(firstName.concat(" " + lastName), contactDetail);
	}
	
	
	
	
	private void viewContactDetails(String name) {
		ContactDetails contactObj =  nameToContactDetailsMap.get(name);
		System.out.println(contactObj);
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		AddressBookMain addressBook = new AddressBookMain();
		System.out.println("No. of contact details to enter: ");
		int numOfContact = sc.nextInt();
		sc.nextLine();
		//adding
		for(int i = 0; i < numOfContact; i++) {
			System.out.println("First Name: ");
			String firstName = sc.nextLine();
			System.out.println("Last Name: ");
			String lastName = sc.nextLine();
			System.out.println("Address: ");
			String address = sc.nextLine();
			System.out.println("State: ");
			String state = sc.nextLine();
			System.out.println("ZIP: " );
			int zip = sc.nextInt();
			System.out.println("Phone No: ");
			long phoneNo = sc.nextLong();
			sc.nextLine();
			System.out.println("Email ID: ");
			String emailId = sc.nextLine();
			addressBook.addContactDetails(firstName, lastName, address, state, zip, phoneNo, emailId);
		}
		//printing by calling key of HashMap
		System.out.println("Enter name of person you want to print contant details of: ");
		String name = sc.nextLine();
		addressBook.viewContactDetails(name);
	}
}