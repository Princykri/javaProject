package EmailBox;



import java.util.*;
import java.io.*;
import java.lang.System;

public class EmailMethods {
    Scanner input = new Scanner(System.in);
       private String fname ;
       private  String Lname;
       private String email;
       private String dept;
       private String password;
       private String alter_mail;
       private int mailcapacity=500;

       // constructor to receive first name and last name
       EmailMethods( String fname,String Lname ){
           this.fname=fname;
           this.Lname=Lname;
           System.out.println("name of new employee is " + this.fname +" " +this.Lname);

           // calling method
           this.dept=this.setdept();
           this.password=this.getPassword(8);
           this.email=this.generate_mail();
       }

       // method to generate  E-mail fname.lname@dept.company.com
       private  String generate_mail (){
           return this.fname.toLowerCase()+"." +this.Lname.toLowerCase()+"@" +this.dept.toLowerCase()+"Company.com";
       }

       //receiving department
        private String setdept(){
            boolean flag=false;
            System.out.println("Department codes \n1  sales  \n2  Development \n3  Accountant  \n4  not Assigned yet ");
            do{
                System.out.println(" Enter your department code :");

                int choies = input.nextInt();
                switch (choies){
                    case 1:
                        return "Sales";
                    case 2:
                        return "Development";
                    case 3:
                        return "Accountant";
                    case 4 :
                        return "  ";
                    default:
                        System.out.println(" invalid ! plz check and enter again ");
                }
                   ;
            }while(!flag);

            return null;
        }

        // password generator method  private -> not for user
       private String getPassword(int length){
           Random r =new Random();
           String Capital_letter="ABCDEFGHIJKLMNOPQRSTUVWXYZ";
           String Small_letter="abcdefghijklmnopqrstuvwxyz";
           String num="0123456789";
           String Symbole ="!@$%^&*";
           String value=Capital_letter+ Small_letter+Symbole+num;
           String password="";
           for(int i=0 ;i<length;i++){
               password=password+value.charAt(r.nextInt(value.length()));
           }
           return password;
       }

       // change password   --> for user
      public void set_password(){
           boolean flag=false;
           do{
               System.out.println("Do you want to change your password ? (Y/N)");
               char choice = input.next().charAt(0);  // is will at the first letter of what user has input
               if(choice== 'y' || choice=='Y'){
                   flag =true;
                   System.out.println("Enter your current Password : ");
                   String temp= input.next();
                   if (temp.equals(this.password)) {
                       System.out.println("Enter your new password");
                       this.password= input.next();
                       System.out.println("Password has successfully changed :)");
                   }else{
                       System.out.println("Incorrect password");
                   }

               } else if(choice =='N' || choice=='n'){
                   flag =true;
                   System.out.println("Passport changed option got canceled ");
               } else{
                   System.out.println("enter valid choies");
               }
           }while(!flag);
      }


      // set mail capacity method
    public void set_mailcapacity(){
        System.out.println("current capacity is " + this.mailcapacity +"mb");
        System.out.println("enter new mail box capacity :");
        this.mailcapacity=input.nextInt();
        System.out.println("mail box capacity has changed");
    }
    // set alternate mail
    public void set_altermail(){
        System.out.println("Enter alternate mail id :");
        this.alter_mail=input.next();
        System.out.println("Alternate mail has been set ");
    }
    // display all the information
    public void info(){
        System.out.println("Name :" +this.fname +" " +this.Lname);
        System.out.println("Department: " +this.dept);
        System.out.println("Email:" +this.email);
        System.out.println("Alternate Email:"+this.alter_mail);
        System.out.println("Password: "+ this.password);
        System.out.println("Mailbox capacity:" +this.mailcapacity +"mb");
    }

    // storing file
    public  void Store_data(){
           try{
               FileWriter r1 =new FileWriter("storage.text");
               r1.write("firstname : " + this.fname);
               r1.append("\n Lastname :  "+ this.Lname);
               r1.append("\n Department : " +this.dept);
               r1.append("\n Email : "+this.email);
               r1.append("\n Alternate email :"+this.alter_mail);
               r1.append("\n Password :"+this.password);
               r1.append("\n Mail Capacity : "  +this.mailcapacity);
               r1.close();
               System.out.println("data Stored");

           }catch(Exception e){
               System.out.println(e);}



    }

    public  void readfile(){
        try{
            FileReader r2 =new FileReader("Storage.text");
            int i;
            while((i=r2.read())!=-1){
                System.out.print((char)i);
            }
            r2.close();


        }catch(Exception e){
            System.out.println(e);}

    }

}
