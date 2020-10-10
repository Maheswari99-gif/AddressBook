import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Scanner;

public class AddressBookMain {
	private LinkedList<ContactDetails> contactLinkedList;
	private AddressBookMain() {
		contactLinkedList = new LinkedList<>();
	}

	private void addContactToAddressBook(int addressBookNo) {
		Scanner sc = new Scanner(System.in);
		System.out.println("How many Entries  " +addressBookNo);
		int no = sc.nextInt();
		sc.nextLine();
		for(int i = 0; i < no; i++) {
			String firstName, lastName;
			int flag;
			do{
				int count = 0;
				System.out.println("First Name: ");
				firstName = sc.nextLine();
				System.out.println("Last Name: ");
				lastName = sc.nextLine();
				for(int j = 0; j < i; j++) 
					if(contactLinkedList.get(j).firstName.equals(firstName) && contactLinkedList.get(j).lastName.equals(lastName)) {
						count++;
					}
				if(count != 0) {
					System.out.println("This name already exists!");
					flag = 0;
				}
				else
					flag = 1;
			}while(flag == 0);
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
			ContactDetails contactDetail = new ContactDetails();
			contactDetail.setContactDetails(firstName, lastName, address, state, zip, phoneNo, emailId);
			contactLinkedList.add(contactDetail);
		}
	}
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		Map<String, AddressBookMain> addressBookMap = new HashMap<>();
		System.out.println("How many address books need to be created? ");
		int num = sc.nextInt();
		sc.nextLine();
		AddressBookMain[] addressBookArray = new AddressBookMain[num];
		for(int k= 0; k < num; k++) {
			System.out.println("Enter name for Address Book " + (k + 1) + ": ");
			String addressBookName = sc.nextLine();
			addressBookArray[k] = new AddressBookMain();
			addressBookArray[k].addContactToAddressBook(k + 1);
			addressBookMap.put(addressBookName, addressBookArray[k]);
		}
		}
		}
