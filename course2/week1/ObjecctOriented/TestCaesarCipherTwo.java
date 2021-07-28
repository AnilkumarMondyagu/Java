import edu.duke.*;

public class TestCaesarCipherTwo{
    public String halfOfString(String message, int start){
        String temp="";
        for(int i=start; i<message.length(); i+=2){
            temp=temp+message.charAt(i);
        }
        return temp;
    }

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


    public String breakCaesarCipher(String input) {
        String message1=halfOfString(input, 0);
        String message2=halfOfString(input, 1);
        
        int[] freqncs1 = countLetters(message1);
        int maxind1=maxIndex(freqncs1);
        int key1=maxind1-4;
        if(maxind1<4){
            key1=26-(4-maxind1);
        }

        int[] freqncs2=countLetters(message2);
        int maxind2=maxIndex(freqncs2);
        int key2=maxind2-4;
        if(maxind2<4){
            key1=26-(4-maxind2);
        }

        CaesarCipherTwo cc=new CaesarCipherTwo(key1,key2);
        return cc.decrypt(input);
    }

    public void simpleTests(){
        FileResource resource=new FileResource();
        CaesarCipherTwo cc=new CaesarCipherTwo(17,3);
        String message=resource.asString();
        String encryptMessage=cc.encrypt(message);
        System.out.println(encryptMessage);
        System.out.println(cc.decrypt(encryptMessage));
        String decryptMessage=this.breakCaesarCipher(encryptMessage);
        System.out.println(decryptMessage);
    }

    public static void main(String[] args){
        TestCaesarCipherTwo tcc=new TestCaesarCipherTwo();
        tcc.simpleTests();
    }
}