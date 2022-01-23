package EmailBox;
import java.util.*;

public class main {
    public static void main(String[] args) {
        Scanner input =new Scanner(System.in);
        System.out.println("Enter the First name");
        String F_name=input.next();
        System.out.println("Enter the Second name");
        String L_name=input.next();


        //object for EmailMethod
        EmailMethods obj=new EmailMethods(F_name,L_name);
        int choice=-1;
        do{
            System.out.println("***********   Enter your choices  **************");
            System.out.println("1 Show information \n2  Alternate Mail \n3 Change Password \n4 Check Mail Capacity \n5 Store data to file  \n6 Display data from file \n 7 Exit ");
             choice =input.nextInt();
            switch(choice){
                case 1:
                   obj.info();
                   break;
                case 2:
                    obj.set_altermail();
                    break;
                case 3:
                    obj.set_password();
                    break;
                case 4:
                    obj.set_mailcapacity();
                    break;
                case 5:
                     obj.Store_data();
                     break;
                case 6:
                    obj.readfile();
                    break;

                case 7:
                    System.out.println("Thank you :)");
                    break;
                default:
                    System.out.println("Invalid Choice \n  Plz check it and try again ");
            }

        }while(choice!=5);

    }
}
