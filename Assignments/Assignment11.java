import edu.duke.FileResource;

import java.io.FileReader;
import java.util.HashMap;

public class Assignment11{
	HashMap<Character,Integer> charsCount;
	public void readTextFile(String file){
		charsCount=new HashMap<Character,Integer>();
		FileResource fr=new FileResource(file);
		for(String line:fr.lines()){
			for(int i=0;i<line.length();i++){
				char ch=line.charAt(i);
				if(charsCount.containsKey(ch)){
					charsCount.put(ch,charsCount.get(ch)+1);
				}
				else{
					charsCount.put(ch,1);
				}
			}
		}
		FileReader newFile=new FileReader("store.txt");
		for(char ch:charsCount.keySet()){
			String charCount=ch+" - "+charsCount.get(ch);
			System.out.println(charCount);
			newFile.write(charCount);
		}
		newFile.close();
	}

	public static void main(String[] args){
		Assignment11 test=new Assignment11();
		test.readTextFile(args[0]);
	}
}