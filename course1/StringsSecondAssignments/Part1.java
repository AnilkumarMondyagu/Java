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

    public void testFindStopCodon() {
        String dna = "ATGTACGTTTAAACCTGATAG";
        
        int stop = findStopCodon(dna, 0,"TAA");
        System.out.println(stop);

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

    public void testFindGene() {
        String dna1 = "ATFAGGCGTACTTAAACTTAG";
        String dna2 = "ATGCGTACGTAGTAA";
        String dna3 = "ATGGCTATCTAATAG";
        String dna4 = "TTAATGACTTACTGAACTTAGCCC";

        System.out.println(findGene(dna1,0));
        System.out.println(findGene(dna2,0));
        System.out.println(findGene(dna3,0));
        System.out.println(findGene(dna4,0));
    }

    public void printAllGenes(String dna){
        int start=0;
        while(true){
            String gene=findGene(dna,start);
            if(gene.isEmpty()){
                break;
            } 
            else{
                System.out.println(gene);
            }
            start = dna.indexOf(gene, start) + gene.length();
        }
    } 

    public static void main(String[] args) {
        Part1 gene = new Part1();
        gene.testFindStopCodon();
        gene.testFindGene();
        gene.printAllGenes("ATGCGGTAATACATGCATTAA");
    }
}