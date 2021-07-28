import edu.duke.*;
import java.util.ArrayList;

public class CharactersInPlay{
    private ArrayList<String> characterNames;
    private ArrayList<Integer> counts;

    public CharactersInPlay(){
        characterNames = new ArrayList<String>();
        counts = new ArrayList<Integer>();
    }

    public void update(String person){

        //person = person.toLowerCase();
        int index=characterNames.indexOf(person);
        if(index==-1){
            characterNames.add(person);
            counts.add(1);
        }
        else{
            int prevCount=counts.get(index);
            counts.set(index,prevCount+1);
        }
    }

    public void findAllCharacters(){
        characterNames.clear();
        counts.clear();

        FileResource resource=new FileResource();
        for (String line: resource.lines()){
            if (line.contains(".")){
                int index=line.indexOf(".");
                String possibleName=line.substring(0,index);
                update(possibleName);
            }
        }
    }
    public void tester(){
        findAllCharacters();
        for(int k=0; k<counts.size();k++){
            if(counts.get(k)>13){
                System.out.println(characterNames.get(k)+"\t"+counts.get(k));
            }
        }
        int num1=14;
        int num2=50;
        charactersWithNumParts(num1,num2);
    }

    public void charactersWithNumParts(int num1,int num2){
        System.out.println("Character between "+num1+" "+num2);
        for(int k=0; k<counts.size();k++){
            if(counts.get(k)>=num1 && counts.get(k)<=num2){
                System.out.println(characterNames.get(k)+"\t"+counts.get(k));
            }
        }
    }

    public static void main(String[] args){
        CharactersInPlay test=new CharactersInPlay();
        test.tester();
    }
}