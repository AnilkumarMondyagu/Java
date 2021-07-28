public class Part3 {
    public boolean twoOccurrences(String stringa, String stringb) {
        int firstIndex = stringb.indexOf(stringa);
        int secondIndex = stringb.indexOf(stringa, firstIndex+1);
        if(firstIndex!=-1 && secondIndex!=-1) {
            return true;
        } 
        return false;
    }

    public String lastPart(String stringa,String stringb){
        if(stringb.indexOf(stringa)!=-1){
            int index=stringb.indexOf(stringa);
            return stringb.substring(index+stringa.length());
        } 
        else {
            return stringb;
        }
    }
    
    public void testing() {
        System.out.println(twoOccurrences("an", "A and an"));
        System.out.println(twoOccurrences("last", "where did you go last on last sunday"));
        System.out.println(twoOccurrences("no", "i dont know"));
        
        System.out.println(lastPart("anil", "anilkumar"));
        System.out.println(lastPart("zoo", "forest"));
        System.out.println(lastPart("a", "assign"));
    }
    public static void main(String[] args) {
        Part3 occur = new Part3();
        occur.testing();
    }
}