package com.capgemini.addressbook;
import java.util.*;
import java.util.Scanner;
public class AddressBook {
	private ArrayList<ContactDetails> contactArray;
	private AddressBook() {
		contactArray = new ArrayList<>(); 
	}
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		AddressBook addressBook = new AddressBook();
		System.out.println("No. of contact details to enter: ");
		int numOfCon = sc.nextInt();
		sc.nextLine();
		for(int i = 0; i < numOfCon; i++) {
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
			addressBook.addContactDetails(firstName, lastName, address, state, zip,phoneNo, emailId);
		}}
	/**
	 * @param firstName
	 * @param lastName
	 * @param address
	 * @param state
	 * @param zip
	 * @param phoneNo
	 * @param emailId
	 */
	private void addContactDetails(String firstName, String lastName, String address, String state, int zip, long phoneNo, String emailId) {
		ContactDetails contactDetail = new ContactDetails();
		contactDetail.setContactDetails(firstName, lastName, address, state, zip, phoneNo,emailId);
		if(!contactArray.add(contactDetail))
			System.out.println("Sorry! The contact already exists");
		else
			contactArray.add(contactDetail);
	}
}
