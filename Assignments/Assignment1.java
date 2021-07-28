import java.io.File;
import java.util.Scanner;

public class Assignment1{
	public void matchFiles() throws NullPointerException{
		Scanner sc=new Scanner(System.in);
		File directory=new File("/home/anilmo/Desktop/Internship/Assignments");
		File[] fileList=directory.listFiles();
		System.out.println("Enter Pattern or stop:");
		String pattern=sc.nextLine();
		while(!pattern.equals("stop")){
			for(File f:fileList){
				String fileName=f.getName();
				if(fileName.matches(pattern)){
					System.out.println(f.getAbsolutePath());
				}
			}
			System.out.println("\nEnter Pattern or stop:");
			pattern=sc.nextLine();
		}
	}

	public static void main(String[] args){
		Assignment1 test=new Assignment1();
		test.matchFiles();
	}
}