import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.*;

public class Assignment4{
	public static void main(String[] args){
		Scanner sc=new Scanner(System.in);
		DateTimeFormatter format=DateTimeFormatter.ofPattern("dd-MM-yyyy");
		LocalDate signupDate;
		LocalDate currentDate;
		LocalDate startDate;
		LocalDate endDate;
		System.out.println("Enter number of cases:");
		int testCases=sc.nextInt();
		for(int i=0;i<testCases;i++){
			String signupDateString=sc.next();
			String currentDateString=sc.next();
			signupDate=LocalDate.parse(signupDateString,format);
			currentDate=LocalDate.parse(currentDateString,format);
			
			startDate=signupDate.minusDays(30);
			endDate=signupDate.plusDays(30);
			
			if((startDate.getMonthValue()>currentDate.getMonthValue()) || ((startDate.getMonthValue()==currentDate.getMonthValue()) && (startDate.getDayOfMonth()>=currentDate.getDayOfMonth()))){
			    System.out.println("No Range");
			    continue;
			}
			int startYear=signupDate.getYear();
			int currentYear=currentDate.getYear();
			startDate=startDate.plusYears(currentYear-startYear);
			
			if((endDate.getMonthValue()>currentDate.getMonthValue()) || ((endDate.getMonthValue()==currentDate.getMonthValue()) && (endDate.getDayOfMonth()>currentDate.getDayOfMonth()))){
			    System.out.println(startDate+" "+currentDate);
			}
			else{
			    System.out.println(startDate+" "+endDate);
			}
		}
	}
}