import edu.duke.*;

public class TestCaesarCipher {

    public int[] countLetters(String encryptedString){
        int[] counts=new int[26];
        String alphabet="abcdefghijklmnopqrstuvwxyz";
        for(int i=0;i<encryptedString.length();i++){
            int index=alphabet.indexOf(Character.toLowerCase(encryptedString.charAt(i)));
            if(index!=-1){
                counts[index]++;
            }
        }
        return counts;
    }

    public int maxIndex(int[] values){
        int index=0;
        int maxind=0;
        for(int i=0; i<values.length; i++){
            if(values[i]>maxind){
                maxind=values[i];
                index=i;
            }
        }
        return index;
    }


    public String breakCaesarCipher(String input){
        int[] freqncs=countLetters(input);
        int maxInd=maxIndex(freqncs);
        int key=maxInd-4;
        if(maxInd<4){
            key=26-(4-maxInd);
        }
        CaesarCipher cc=new CaesarCipher(key);
        return cc.decrypt(input);
    }

    public void simpleTests(){
        FileResource resource=new FileResource();
        CaesarCipher cc=new CaesarCipher(17);
        String message=resource.asString();
        String encryptMessage=cc.encrypt(message);
        System.out.println(encryptMessage);
        System.out.println(cc.decrypt(encryptMessage));
        String decryptMessage=this.breakCaesarCipher(encryptMessage);
        System.out.println(decryptMessage);
    }

    public static void main(String[] args){
        TestCaesarCipher tcc=new TestCaesarCipher();
        tcc.simpleTests();
    }
}