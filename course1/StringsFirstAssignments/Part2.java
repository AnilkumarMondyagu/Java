public class Part2{
    public String findSimpleGene(String dna, String startCodon, String stopCodon){
        String result="";
        if(Character.isUpperCase(dna.charAt(0))){
            startCodon=startCodon.toUpperCase();
            stopCodon=stopCodon.toUpperCase();
        }
        else{
            startCodon=startCodon.toLowerCase();
            stopCodon=stopCodon.toLowerCase();
        }
        
        int startIndex=dna.indexOf(startCodon);
        if(startIndex==-1) {
            return result;
        }
        
        int stopIndex=dna.indexOf(stopCodon, startIndex+3);
        if(stopIndex==-1){
            return result;
        }
        
        if((stopIndex-startIndex)%3==0){
            result=dna.substring(startIndex,stopIndex+3);
        }
        return result;
    }

    public void testSimpleGene() {
        String dna1="ACATGCACCAACTAGAATAAGAA";
        String dna2="ACAATGCAGCGATAG";
        String dna3="GTAATACGATCCGA";
        String dna4="caagtatgccagtgagctaag";
        String dna5="agctgcatttaagtc";
        
        System.out.println("In "+dna1+"\n Gene is:" + findSimpleGene(dna1,"ATG","TAA"));
        System.out.println("In "+dna2+"\n Gene is:" + findSimpleGene(dna2,"ATG","TAG"));
        System.out.println("In "+dna3+"\n Gene is:" + findSimpleGene(dna3,"gta","tcc"));
        System.out.println("In "+dna4+"\n Gene is:" + findSimpleGene(dna4,"ATG","TAA"));
        System.out.println("In "+dna5+"\n Gene is:" + findSimpleGene(dna5,"ATT","TAC"));
    }
    
    public static void main (String[] args) {
        Part2 gene = new Part2();
        gene.testSimpleGene();
    }
}