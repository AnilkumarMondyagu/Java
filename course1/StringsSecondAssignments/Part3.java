public class Part3{
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
    
    public int countGenes(String dna){
        int start=0;
        int count=0;
        while(true){
            String gene=findGene(dna, start);
            
            if(gene.isEmpty()){
                break;
            }
            count++;
            start=dna.indexOf(gene, start)+gene.length();
        }
        return count;
    }
    
    public void testCountGenes() {
        String dna = "ATGTCCTAAATGAACTGAATCATCTACTGATAA";
        System.out.println(countGenes(dna));
    }

    public static void main(String[] args) {
        Part3 gene = new Part3();
        gene.testCountGenes();
    }
}