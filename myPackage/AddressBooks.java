//package myPackage;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.stream.*;
import java.util.*;
import java.util.function.Predicate;

public class AddressBooks {
	public ArrayList<AddressBooks> person = new ArrayList<AddressBooks>(); // collection class
																			// array list is used to
																			// store objects of
																			// address book

	public static Scanner sc = new Scanner(System.in);
	// variables declara
	private String firstName;
	private String lastName;
	private String address;
	private String city;
	private String state;
	private String zip;
	private String phoneNumber;
	private String email;

	public AddressBooks() {
		System.out.println("Welcome to address book program"); // welcome message
	}

	// method for searching a person in by city or state
	public void search(String place) {

		for (int j = 0; j < person.size(); j++) {
			AddressBooks object = person.get(j);
			if (object.city.equals(place) || object.state.equals(place)) {
				System.out.println(object.firstName + " " + object.lastName);
			}
		}
	}

	public void countByPlace(String place) {
		int count = 0;
		for (int j = 0; j < person.size(); j++) {
			AddressBooks object = person.get(j);
			if (object.city.equals(place) || object.state.equals(place)) {

				count++;
			}
		}
		System.out.println("number of persons from " + place + " are " + count);
	}

	// constructors initialized during object creation
	public AddressBooks(String firstName, String lastName, String address, String city, String state, String zip,
			String number, String email) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.address = address;
		this.city = city;
		this.state = state;
		this.zip = zip;
		this.phoneNumber = number;
		this.email = email;
	}

	// @method to insert person details to specific address book
	public void insertContact() {
		System.out.println("first Name:");
		firstName = sc.next();
		check(firstName);// calling method to check for dulplicate value
		if (check(firstName) == true) {
			System.out.println("last name:");
			lastName = sc.next();
			System.out.println("address:");
			address = sc.next();
			System.out.println("city:");
			city = sc.next();
			System.out.println("state:");
			state = sc.next();
			System.out.println("zip:");
			zip = sc.next();
			System.out.println("phone number");
			phoneNumber = sc.next();
			System.out.println("E-mail:");
			email = sc.next();
			person.add(new AddressBooks(firstName, lastName, address, city, state, zip, phoneNumber, email)); // object
																												// creation
		} else {
			System.out.println("this contact already exist");
		}

	}

	// methos implementation for checking duplicate values
	public boolean check(String tname) {

		for (AddressBooks name : person) {
			if (name.firstName.equals(firstName)) {
				return false;
			}
		}

		return true;
	}

	// @method for displaying attributes
	public void displayContacts() {
		System.out.println("Enter the person's first name:"); // case to displayContacts a contact
		String name3 = sc.next();
		for (int j = 0; j < person.size(); j++) {
			AddressBooks address_book = person.get(j); // get method takes an index to look for an object in
														// collection list
			if (address_book.firstName.equals(name3)) {
				System.out.println("First Name: " + firstName);
				System.out.println("Last Name: " + lastName);
				System.out.println("Address: " + address);
				System.out.println("City: " + city);
				System.out.println("State: " + state);
				System.out.println("Zip: " + zip);
				System.out.println("Phone Number: " + phoneNumber);
				System.out.println("E-mail: " + email);

			}

		}

	}

	// @method to displayContacts all contents in the address book
	public void displayAddressBook() {
		if (person.size() == 0) {
			System.out.println("No Contacts in the address book!!!");
		} else {
			System.out.println("Address book contains following contacts!!!");

			for (int j = 0; j < person.size(); j++) {
				AddressBooks object = person.get(j);
				System.out.println("Contact details of person" + j);
				System.out.println("first Name:" + object.firstName);
				System.out.println("last name:" + object.lastName);
				System.out.println("address:" + object.address);
				System.out.println("city:" + object.city);
				System.out.println("state:" + object.state);
				System.out.println("zip:" + object.zip);
				System.out.println("phone number:" + object.phoneNumber);
				System.out.println("E-mail:" + object.email);
			}
		}
	}

	// @method for editing details
	public void editContact() {
		System.out.println("Enter the person whose contact to be edited"); // to editContact existing address
		String name = sc.next();
		for (int j = 0; j < person.size(); j++) {
			AddressBooks address_book = person.get(j);
			if (address_book.firstName.equals(name)) {

				System.out.println("Enter first Name:");
				address_book.firstName = sc.next();
				System.out.println("Enter last name:");
				address_book.lastName = sc.next();
				System.out.println("Enter the address:");
				address_book.address = sc.next();
				System.out.println("Enter the city:");
				address_book.city = sc.next();
				System.out.println("Enter the state:");
				address_book.state = sc.next();
				System.out.println("Enter zip:");
				address_book.zip = sc.next();
				System.out.println("Enter the phone number:");
				address_book.phoneNumber = sc.next();
				System.out.println("E-mail address:");
				address_book.email = sc.next();

			}
		}
	}

	// @method for deleting objects
	public void deleteContact() {
		System.out.println("Enter the person whose contact to be deleteContactd");
		String name2 = sc.next(); // input is taken from console

		for (int j = 0; j < person.size(); j++) {
			AddressBooks object = person.get(j);
			if (object.firstName.equals(name2)) {

				person.remove(object); // array list has built in method to remove objects

			}
		}
	}

	// @method to sort the entries based on person's name using java stream
	public void sortByName() {
		List<AddressBooks> sortedNames = new ArrayList<AddressBooks>();
		sortedNames = person.stream().sorted(Comparator.comparing(a -> a.firstName)).collect(Collectors.toList());

		sortedNames.forEach(n -> System.out.println(n));
	}

	// method to sort entries by city state or zip
	public void sortByCityStateZip(int choice) {
		List<AddressBooks> sorted = new ArrayList<AddressBooks>();

		if (choice == 1) {
			sorted = person.stream().sorted(Comparator.comparing(a -> a.city)).collect(Collectors.toList());
		} else if (choice == 2) {
			sorted = person.stream().sorted(Comparator.comparing(a -> a.state)).collect(Collectors.toList());
		} else {
			sorted = person.stream().sorted(Comparator.comparing(a -> a.zip)).collect(Collectors.toList());
		}
		sorted.forEach(n -> System.out.println(n));
	}

	public String toString() {
		return "Firstname: " + firstName + "\n" + "Lastname: " + lastName + "\n" + "Address: " + address + "\n"
				+ "City :" + city + "\n" + "State: " + state;
	}
}