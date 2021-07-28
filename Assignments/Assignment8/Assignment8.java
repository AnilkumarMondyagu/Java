import java.util.*;

public class Assignment8{
  
    static void validate(int age,String phno,String gmailId)throws InvalidAgeException,InvalidPhoneNumberException,InvalidGmailIdException,NullPointerException{
        if(age<18){  
            throw new InvalidAgeException("Age not valid");
        }
        
        if(phno.length()!=10){
            throw new InvalidPhoneNumberException("Length of PhoneNumber should be 10");
        }
        
        if(!gmailId.matches("^[a-zA-Z0-9]+[a-zA-Z0-9._]*@[a-zA-Z0-9.]+$")){
            throw new InvalidGmailIdException("Gmail Id is not vaild");
        }
        System.out.println("All inputs are valid");
   }  

    public void testExceptions(){
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter Age:");
        int age=sc.nextInt();
        System.out.println("Enter Phone Number:");
        String phoneNumber=sc.next();
        System.out.println("Enter Gmail Id:");
        String gmailId=sc.next(); 
        try{  
            validate(age,phoneNumber,gmailId);  
        }
        catch(Exception message){
            System.out.println("Exception occured:"+message);
        }
        finally{
            System.out.println("Thank you...");
        }
    }

    public static void main(String[] args){
        Assignment8 test=new Assignment8();
        test.testExceptions();
    }
}