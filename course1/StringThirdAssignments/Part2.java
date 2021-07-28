public class Part2{
    public double cgRatio(String dna){
        int occurences=0;
        dna=dna.toUpperCase();
        for (int i=0;i<dna.length();i++){
            if (dna.charAt(i)=='C' || dna.charAt(i)=='G'){
                occurences++;
            }
         } 
         return ((float)occurences)/dna.length();
    }
    
    public void testCGRatio(){
        String dna="ATCCGTATGTAACTCGTA";
        System.out.println(cgRatio(dna));
    }
    
    public int countCTG(String dna){
        int occurences=0;
        int start=0;
        while(true){
            int index = dna.toUpperCase().indexOf("CTG", start);
            if (index == -1){
                break;
            }
            occurences++;
            start=index+3;
        }
        return occurences;
    }
    
    public void testCountCTG(){
        String dna = "CTGTAAATGCTGTCACTG";
        System.out.println(countCTG(dna));
    }

    public static void main(String[] args){
        Part2 test=new Part2();
        test.testCGRatio();
        test.testCountCTG();
    }
}