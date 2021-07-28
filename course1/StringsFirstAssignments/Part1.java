public class Part1 {
    public String findSimpleGene(String dna) {
        String result = "";
        int startIndex = dna.indexOf("ATG");
        if(startIndex == -1) {
            return result;
        }
        int stopIndex = dna.indexOf("TAA", startIndex+3);
        if(stopIndex == -1) {
            return result;
        }
        if((stopIndex-startIndex)%3==0) {
            result=dna.substring(startIndex,stopIndex+3);
        }
        return result;
    }
    
    public void testSimpleGene() {
        String dna1 = "ACATGCACCAACTAGAATAAGAA";
		String dna2 = "ACCATGCAACAATAG";
		String dna3 = "TTGGTCAGGATAAGC";
		String dna4 = "CAAGTATGCAAGTCAGGTAA";
		String dna5 = "ACAGCAGGCCAGTAGCTGAA";
		
		System.out.println("In "+dna1+"/n Gene is:" + findSimpleGene(dna1));
		System.out.println("In "+dna2+"/n Gene is:" + findSimpleGene(dna2));
		System.out.println("In "+dna3+"/n Gene is:" + findSimpleGene(dna3));
		System.out.println("In "+dna4+"/n Gene is:" + findSimpleGene(dna4));
		System.out.println("In "+dna5+"/n Gene is:" + findSimpleGene(dna5));
    }
    
    public static void main (String[] args) {
        Part1 gene = new Part1();
        gene.testSimpleGene();
    }
}