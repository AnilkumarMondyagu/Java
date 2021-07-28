import edu.duke.*;

public class WordLengths{
    public void countWordLengths(FileResource resource,int[] counts){
        for(String word:resource.words()){
            int otherCount=0;
            if(!Character.isLetter(word.charAt(0))){
                otherCount++;
            }
            if(!Character.isLetter(word.charAt(word.length() - 1))){
                otherCount++;
            }
            int wordLength=word.length()-otherCount;
            int maxLength=counts.length-1;
            if(wordLength>=maxLength){
                counts[maxLength]++;
            }
            else{
                counts[wordLength]++;            
            }
        }
    }

    public int indexOfMax(int[] values){
        int max=Integer.MIN_VALUE;
        int maxIndex=-1;
        
        for(int i=0;i<values.length;i++){
            if(values[i]>max){
                max=values[i];
                maxIndex=i;
            }
        }
        return maxIndex;
    }
    
    public void testCountWordLengths(){
        FileResource fr=new FileResource();
        int[] counts=new int[31];
        countWordLengths(fr,counts);
        
        for (int i=0;i<counts.length;i++){
            System.out.println("with length "+i+" "+counts[i]+" words");
        }
        
        System.out.println("most common word length:"+indexOfMax(counts));
    }
    
    public static void main(String[] args){
        WordLengths test=new WordLengths();
        test.testCountWordLengths();
    }
    
    
}