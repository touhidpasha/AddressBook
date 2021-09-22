import java.util.Scanner;



class Contact{
    public String firstname,lastname,city,address,state;
    public int number,zip;
    Scanner sc= new Scanner(System.in);

    public void addContact(){
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
        System.out.println("Enter phone number");
        number =sc.nextInt();
        System.out.println("Enter zip");
        zip =sc.nextInt();
    }

    public void editContact(){
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
        System.out.println("Enter phone number");
        number =sc.nextInt();
        System.out.println("Enter zip");
        zip =sc.nextInt();
    }
}

public class AddressBookMain{
    public static void main(String args[]){
        Scanner sc= new Scanner(System.in);
        int flag,count=0,count2=0,choice;
        String tempName;
        System.out.println("welcome to address book problem");

        Contact contact[]=new Contact[20];
        Contact contact2[]=new Contact[20];

        while(true){   
                                    
            //this infinite loop will help in adding multipe persons details
            System.out.println("press 1 to add to phonebook1 ,press anythong to add phonrbook2");
            choice=sc.nextInt();
            if(choice==1){
            System.out.println("press 1 to add new contact");
            System.out.println("press 2 to edit new contact");
            System.out.println("press 3 to delete contact");
            flag =sc.nextInt();
            if(flag==1)
            {
                contact[count]=new Contact();
                contact[count].addContact();
                count++;
            }
            else if(flag==2) {
                System.out.println("enter name for editing");
                for(int i=0;i<count;i++)
                {
                    System.out.println(contact[i].firstname);   
                }
                tempName =sc.next();
                int i;
                for(i=0;i<count;i++)
                {
                    if(contact[i].firstname.equals(tempName))
                    break; 
                }
                contact[i].editContact();
            }
            else{

                System.out.println("enter name for deleting");
                for(int i=0;i<count;i++)
                {
                    System.out.println(contact[i].firstname);   
                }
                tempName =sc.next();
                int i;
                for(i=0;i<count;i++)
                {
                    if(contact[i].firstname.equals(tempName))
                    break; 
                }
                int j;
                for(j=i;j<count-1;j++)
                {
                    contact[j]=contact[j+1];
                    
                }
                contact[++j]=null;

            }
        }
        else{
            System.out.println("press 1 to add new contact");
            System.out.println("press 2 to edit new contact");
            System.out.println("press 3 to delete contact");
            flag =sc.nextInt();
            if(flag==1)
            {
                contact2[count2]=new Contact();
                contact2[count2].addContact();
                count2++;
            }
            else if(flag==2) {
                System.out.println("enter name for editing");
                for(int i=0;i<count2;i++)
                {
                    System.out.println(contact2[i].firstname);   
                }
                tempName =sc.next();
                int i;
                for(i=0;i<count2;i++)
                {
                    if(contact2[i].firstname.equals(tempName))
                    break; 
                }
                contact2[i].editContact();
            }
            else{

                System.out.println("enter name for deleting");
                for(int i=0;i<count2;i++)
                {
                    System.out.println(contact2[i].firstname);   
                }
                tempName =sc.next();
                int i;
                for(i=0;i<count2;i++)
                {
                    if(contact2[i].firstname.equals(tempName))
                    break; 
                }
                int j;
                for(j=i;j<count2-1;j++)
                {
                    contact2[j]=contact2[j+1];
                    
                }
                contact2[++j]=null;

            }
        }

        }
        
        
    }
}