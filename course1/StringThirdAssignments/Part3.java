import edu.duke.*;
import java.lang.Math;

public class Part3{
    public int findStopCodon(String dna, int startIndex, String stopCodon){
        int index=0;
        while(true){
            index=dna.toUpperCase().indexOf(stopCodon, startIndex + 3);
            if(index==-1 || (index-startIndex)%3==0){
                break;
            }
            startIndex+=3;
        }
        if(index!=-1){
            return index;
        }
        else{
            return dna.length();            
        }
    }
    
    public String findGene(String dna, int start){
        int startIndex=dna.toUpperCase().indexOf("ATG", start);
        if (startIndex==-1) {
            return "";
        }
        int taaIndex=findStopCodon(dna, startIndex, "TAA");
        int tagIndex=findStopCodon(dna, startIndex, "TAG");
        int tgaIndex=findStopCodon(dna, startIndex, "TGA");
        
        int minIndex = Math.min(taaIndex, Math.min(tagIndex, tgaIndex));
        
        if (minIndex == dna.length()) {
            return "";
        } else {
            return dna.substring(startIndex, minIndex + 3);
        }
    }

    public StorageResource getAllGenes(String dna){
        int start=0;
        StorageResource geneList=new StorageResource();
        while (true){
            String gene=findGene(dna, start);
            if(gene.isEmpty()){
                break;
            } else {
                geneList.add(gene);
            }
            start=dna.indexOf(gene, start)+gene.length();
        }
        return geneList;
    }
    
    public float cgRatio(String dna) {
        int occurences=0;
        dna=dna.toUpperCase();
        for (int i=0;i<dna.length();i++){
            if (dna.charAt(i)=='C' || dna.charAt(i)=='G'){
                occurences++;
            }
        }
        return ((float)occurences)/dna.length();
    }
    
    private void processGenes(StorageResource sr) {
        int count=0;
        int cgCount=0;
        int longest=Integer.MIN_VALUE;

        for(String gene:sr.data()){
            int currentLength=gene.length();
            float cgRatio=cgRatio(gene);
            System.out.println("CG Ratio is"+cgRatio);
            if(currentLength>60){
                System.out.println("Having more than 60 chars "+gene);
                count++;
            }
            if(cgRatio>0.35){
                System.out.println("CG ratio more than 0.35 "+gene);
                cgCount++;
            }
            longest=Math.max(longest,currentLength);
        }

        System.out.println("Number of gene longer than 60 characters "+count);
        System.out.println("Number of gene with CG ratio higher than 0.35 "+cgCount);
        System.out.println("Length of longest dna: "+longest);
    }
    
    public void testProcessGenes() {
        FileResource fr=new FileResource("brca1line.fa");
        String dna=fr.asString();
        StorageResource geneList=getAllGenes(dna);
        processGenes(geneList);
    }

    public static void main(String[] args){
        Part3 gene=new Part3();
        gene.testProcessGenes();
    }
}