import java.util.*;

public class Assignment2{

   int index=-1;

   public boolean containsAllaToz(String inputString){
      boolean[] alphabhet=new boolean[26];
      for(char c:inputString.toCharArray()){
         if(c>='a' && c<='z'){
            index=c-'a';
            alphabhet[index]=true;
         }
      }
      for(boolean letter:alphabhet){
         if(letter==false){
            return false;
         }
      }
      return true;
   }

   public void testContainsAllaToz(){
      System.out.println("Enter text:");
      Scanner sc=new Scanner(System.in);
      String input=sc.nextLine();
      boolean result=containsAllaToz(input);
      if(result){
         System.out.println("Contains all a to z");
      }
      else{
         System.out.println("Doesn't contain all a to z");
      }
   }
   
   public static void main(String[] args) {
      Assignment2 test=new Assignment2();
      test.testContainsAllaToz();
   }
}

//Time Complexity - O(n)
//Space Complexity - O(n)