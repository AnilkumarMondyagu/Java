import edu.duke.*;
import java.util.*;
import java.io.*;

public class WordsInFiles{
    private HashMap<String, ArrayList<String>> wordCounts;
    
    public WordsInFiles(){
        wordCounts=new HashMap<String, ArrayList<String>>();
    }
    
    private void addWordsFromFile(File f){
        FileResource fr=new FileResource(f);
        String currentFileName=f.getName();
        for(String word:fr.words()){
            if(wordCounts.containsKey(word)){
                ArrayList<String> fileNames=wordCounts.get(word);
                if(!fileNames.contains(currentFileName)){
                    fileNames.add(currentFileName);
                    wordCounts.put(word,fileNames);
                }
            }
            else{
                ArrayList<String> fileNames=new ArrayList<String>();
                fileNames.add(f.getName());
                wordCounts.put(word,fileNames);
            }
        }
    }
    
    private void buildWordFileMap(){
        wordCounts.clear();
        DirectoryResource dr=new DirectoryResource();
        for(File f:dr.selectedFiles()){
            addWordsFromFile(f);
        }
    }
    
    private int maxNumber(){
        int maxCount=Integer.MIN_VALUE;
        for (String word:wordCounts.keySet()) {
            int currentCount=wordCounts.get(word).size();
            if(currentCount>maxCount){
                maxCount=currentCount;
            }
        }
        return maxCount;
    }
    
    private ArrayList<String> wordsInNumFiles(int number){
        ArrayList<String> words=new ArrayList<String>();
        for (String word:wordCounts.keySet()) {
            int currentCount=wordCounts.get(word).size();
            if (currentCount==number){
                words.add(word);
            }
        }
        return words;
    }
    
    private void printFilesIn(String word){
        ArrayList<String> fileNames=wordCounts.get(word);
        for(String fileName:fileNames){
            System.out.println(fileName);
        }
    }
    
    public void tester(){
        buildWordFileMap();
        int maxOccurences=maxNumber();
        System.out.println("Maximum number of files with common word:"+maxOccurences);
        ArrayList<String> wordFiles= wordsInNumFiles(maxOccurences);
        System.out.println("Words that are in the maximum number of files:");  
        for(String word:wordFiles){
            System.out.println(word+"--");
            printFilesIn(word);
        }
    } 

    public static void main(String[] args){
        WordsInFiles test=new WordsInFiles();
        test.tester();
    }
}