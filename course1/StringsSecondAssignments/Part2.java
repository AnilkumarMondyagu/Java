public class Part2{
    public int howMany(String stringa, String stringb){
        int occurences=0;
        int startIndex=0;
        while(true){
            int currentIndex=stringb.indexOf(stringa, startIndex);
            if(currentIndex==-1){
                break;
            }
            occurences++;
            startIndex=currentIndex+stringa.length();
        }
        return occurences;
    }
    
    public void testHowMany(){
        String stringa="ATG";
        String stringb="ATGATTGAATGATGA";
        System.out.println(howMany(stringa, stringb));
        
        stringa="TAA";
        stringb="ATGTAAATGTCA";
        System.out.println(howMany(stringa, stringb));

        stringa="TAG";
        stringb="ATGTAAATGTCA";
        System.out.println(howMany(stringa, stringb));
    }

    public static void main(String[] args){
        Part2 test=new Part2();
        test.testHowMany();
    }
}