import edu.duke.*;
import java.util.*;

public class CodonCount{
    private HashMap<String,Integer> codonCounts;
    
    public CodonCount(){
        codonCounts=new HashMap<String,Integer>();
    }
    
    private void buildCodonMap(int start,String dna){
        codonCounts.clear();
        for(int i=start;i<(dna.length()-3);i+=3){
            String codon=dna.substring(i,i+3);
            if(codonCounts.containsKey(codon)){
                codonCounts.put(codon,codonCounts.get(codon)+1);
            }
            else{
                codonCounts.put(codon,1);
            }
        }
    }
    
    private String getMostCommonCodon(){
        int maxCount=Integer.MIN_VALUE;
        String mostCommonCodon="";        
        for(String codon:codonCounts.keySet()){
            int currCount=codonCounts.get(codon);
            if(currCount>maxCount){
                maxCount=currCount;
                mostCommonCodon=codon;
            }
        }
        return mostCommonCodon;
    }
    
    private void printCodonCounts(int start, int end) {
        for (String codon:codonCounts.keySet()) {
            int currCount=codonCounts.get(codon);
            if(currCount>=start && currCount<=end) {
                System.out.println(codon+"-"+currCount);
            }
        }
    }
    
    public void tester() {
        FileResource resource=new FileResource();
        String dna=resource.asString().toUpperCase();
        
        int start = 0;
        buildCodonMap(start,dna);
        System.out.println("Reading frame starting with "+start+" results in "+codonCounts.size()+" unique codons");
        System.out.println("and most common codon is "+getMostCommonCodon()+" with count "+codonCounts.get(getMostCommonCodon()));
        System.out.println("Counts of codons between 2 and 6 inclusive are:");
        printCodonCounts(2,6);
        
        start = 1;
        buildCodonMap(start, dna);
        System.out.println("Reading frame starting with " + start + " results in " + codonCounts.size() + " unique codons");
        System.out.println("and most common codon is " + getMostCommonCodon() + " with count " + codonCounts.get(getMostCommonCodon()));
        System.out.println("Counts of codons between 2 and 4 inclusive are:");
        printCodonCounts(2,4);
        
        start = 2;
        buildCodonMap(start, dna);
        System.out.println("Reading frame starting with " + start + " results in " + codonCounts.size() + " unique codons");
        System.out.println("and most common codon is " + getMostCommonCodon() + " with count " + codonCounts.get(getMostCommonCodon()));
        System.out.println("Counts of codons between 1 and 6 inclusive are:");
        printCodonCounts(1,6);
    }

    public static void main(String[] args){
        CodonCount test=new CodonCount();
        test.tester();
    }
}