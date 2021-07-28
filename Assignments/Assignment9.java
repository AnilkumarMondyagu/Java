import java.util.*;
import java.util.regex.*;

public class Assignment9{
	public void testregex(){
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter sentence:");
		String sentence=sc.nextLine();
		Pattern sentencePattern=Pattern.compile("^[A-Z]+[a-zA-Z0-9-, ]*[.]$");
		Matcher m=sentencePattern.matcher(sentence);
		if(m.matches()){
			System.out.println("Sentence starts with Capital Letter and ends with period.");
		}
		else{
			System.out.println("Sentence either doesn't start with Capital letter or doesn't end with a period.");
		}
	}

	public static void main(String[] args){
		Assignment9 test=new Assignment9();
		test.testregex();
	}
}