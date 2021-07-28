import edu.duke.*;

public class Part1{
    public int findStopCodon(String dna, int startIndex, String stopCodon) {
        int currentIndex=dna.indexOf(stopCodon, startIndex + 3);
        while(currentIndex!=-1) {
            int dif=currentIndex - startIndex;
            if(dif%3==0) {
                return currentIndex;
            } 
            else{
                currentIndex=dna.indexOf(stopCodon, currentIndex + 1);
            }
        }
        return dna.length();
    }

    public String findGene(String dna, int start) {
        int startIndex=dna.indexOf("ATG",start);
        if(startIndex==-1) {
            return "";
        }
        int taaIndex=findStopCodon(dna, startIndex, "TAA");
        int tagIndex=findStopCodon(dna, startIndex, "TAG");
        int tgaIndex=findStopCodon(dna, startIndex, "TGA");

        int minIndex=0;
        if(taaIndex==-1 || (tagIndex!=-1 && tagIndex<taaIndex)) {
            minIndex=tagIndex;
        } 
        else{
            minIndex=taaIndex;
        }

        if(minIndex==-1 || (tgaIndex!=-1 && tgaIndex<minIndex)) {
            minIndex=tgaIndex;
        }

        if(minIndex==-1) {
            return "";
        }

        return dna.substring(startIndex, minIndex + 3);
    }

    public StorageResource getAllGenes(String dna) {
        int start = 0;
        StorageResource geneList=new StorageResource();
        while (true) {
            String gene = findGene(dna, start);
            if (gene.isEmpty()) {
                break;
            } else {
                geneList.add(gene);
            }
            start = dna.indexOf(gene, start) + gene.length();
        }
        return geneList;
    } 

     public void testGetAllGenes(){
        String dna="ATGCGGTAATACATGCATTAA";
        StorageResource geneList=getAllGenes(dna);
        
        for(String gene:geneList.data()) {
            System.out.println(gene);
        }
    }

    public static void main(String[] args) {
        Part1 gene = new Part1();
        gene.testGetAllGenes();
    }
}