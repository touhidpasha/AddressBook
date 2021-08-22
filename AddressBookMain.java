import java.util.Scanner;

class Contact{
    public String firstname,lastname,city,address,state;
    public int number,zip;
    Scanner sc= new Scanner(System.in);

    public void AddContact(){
        System.out.println("Enter first name");
        firstname =sc.next();
        System.out.println("Enter last name");
        lastname =sc.next();
        System.out.println("Enter city name");
        city =sc.next();
        System.out.println("Enter address");
        address =sc.next();
        System.out.println("Enter state");
        state =sc.next();
    }
}

public class AddressBookMain{
    public static void main(String args[]){

        System.out.println("welcome to address book problem");

        Contact c1=new Contact();
        c1.AddContact();
        
    }
}