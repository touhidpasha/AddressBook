
import java.util.*;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.Map;
import java.util.Scanner;

public class MultipleAddressBooks {

    /*
     * @method to perform some operation takes userChoice and specific address book
     * object as parameters
     */
    public static void userChoice(int userChoice, AddressBooks object) {
        switch (userChoice) {
            case 1:
                object.insertContact(); // add a new contact into address book
                break;

            case 2:
                object.editContact(); // editContact existing contact
                break;

            case 3:
                object.deleteContact(); // deleteContact the selected contact
                break;

            case 4:
                object.displayContacts(); // to displayContacts(); desired contact
                break;

            case 5:
                object.displayAddressBook(); // to displayContacts(); entire address book
                break;
        }

    }

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        Scanner sc = new Scanner(System.in);
        Hashtable<String, AddressBooks> multipleAddressBook = new Hashtable<String, AddressBooks>(); // dictionary for
                                                                                                     // mapping
                                                                                                     // different
                                                                                                     // address book
                                                                                                     // with key i.e
                                                                                                     // unique name
        AddressBooks address_book = new AddressBooks(); // first address book object

        String tempStr = "";
        String firstAddressBook = "AddressBook1";
        multipleAddressBook.put(firstAddressBook, address_book); // put the first address book into dictionary

        while (true) {
            System.out.println(
                    "Enter your userChoice ,by entering below numbers\n1.add contact\n2.editContact contact\n3.Delete contact\n4.Display contact\n5.Display addressbook\n6.Create another address book\n7.exit\n8.seach people from,by place name\n9.count persons by place\n10.Sort by names \n11.Sort by City or State or zip\n12.to create new directory and text fiel within the same directory\n13.to read data from file\n"); // options
            // for
            // different
            // operations
            // for
            // different
            // actions
            int userChoice = sc.nextInt();
            if (userChoice == 6) // to create a new address book
            {
                System.out.println("Enter the name of the addressbook");
                tempStr = sc.next();
                AddressBooks object1 = new AddressBooks(); // a new address book object is created
                multipleAddressBook.put(tempStr, object1);

            } else if (userChoice == 7) // to exist from the program
                System.exit(0);
            else if (userChoice == 8) {
                System.out.println("Enter the name of city or state");
                String place = sc.next();
                System.out.println("Persons whose state or city is " + place);
                for (Map.Entry<String, AddressBooks> entry : multipleAddressBook.entrySet()) {
                    AddressBooks object1 = entry.getValue();
                    object1.search(place);
                }

            } else if (userChoice == 9) {
                System.out.println("Enter the name of city or state");
                String place = sc.next();
                System.out.println("Persons whose state or city is " + place);
                for (Map.Entry<String, AddressBooks> entry : multipleAddressBook.entrySet()) {
                    AddressBooks object1 = entry.getValue();
                    object1.countByPlace(place);
                }

            } else if (userChoice == 10) {
                int count = 0;
                for (Map.Entry<String, AddressBooks> entry : multipleAddressBook.entrySet()) {
                    AddressBooks temp = entry.getValue();
                    System.out.println("AddressBook " + (++count) + " details:");
                    temp.sortByName();
                }
            }

            else if (userChoice == 11) {
                System.out.println(
                        "Enter the number to select the sort by option\n" + "1.City\n" + "2.State\n" + "3.zip");
                int option = sc.nextInt();
                for (Map.Entry<String, AddressBooks> checkEntry : multipleAddressBook.entrySet()) {
                    AddressBooks tempObject = checkEntry.getValue();
                    System.out.println(checkEntry.getKey() + " details:");
                    tempObject.sortByCityStateZip(option);
                }
            }
            else if(userChoice==12){
                AddressBooks object1 = new AddressBooks(); //
                object1.createDirectoryAndTextFile();
            }
            else if(userChoice==13){
                AddressBooks object1 = new AddressBooks(); //
                object1.readDataFromFile();
            }
          
             else {
                System.out.println("Enter the addressbook where you want to insert or modify the  contact!!");
                tempStr = sc.next();
                userChoice(userChoice, multipleAddressBook.get(tempStr)); // to perform required operation on desired address book
            }
        }
    }
}