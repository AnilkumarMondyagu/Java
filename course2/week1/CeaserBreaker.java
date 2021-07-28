import edu.duke.*;

public class CeaserBreaker{
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
    
    public int maxIndex(int[] freqncs){
        int max=Integer.MIN_VALUE;
        int maxIndex=-1;
        for(int i=0;i<freqncs.length;i++){
            if(freqncs[i]>max){
                max=freqncs[i];
                maxIndex=i;
            }
        }
        return maxIndex;
    }
    
    public String decrypt(String encryptedString){
        CeaserCipher ob=new CeaserCipher();
        return ob.encrypt(encryptedString,26-getKey(encryptedString));
    }
    
    public void testDecrypt(){
        String message="COBB ZXHB FK QEB ZLKCBOBKZB OLLJ!";
        System.out.println("decrypted "+decrypt(message));
    }
    
    public String halfOfString(String message, int start){
        StringBuilder halvedMessage=new StringBuilder();
        for(int i=start;i<message.length();i+=2){
            halvedMessage.append(message.charAt(i));
        }
        return halvedMessage.toString();
    }
    
    public void testHalfOfString(){
        String message="Qbkm Zgis";
        int start=0;
        System.out.println("Halved message "+halfOfString(message,start));
        
        message="Qbkm Zgis";
        start=1;
        System.out.println("Halved message "+halfOfString(message, start));
    }
    public int getKey(String s){
        int[] freqncs=countLetters(s);
        int maxInd=maxIndex(freqncs);
        int key=maxInd-4;
        if(maxInd<4){
            key=26-(4-maxInd);
        }
        return key;
    }
    
    public String decryptTwoKeys(String encrypted){
        CeaserCipher cc=new CeaserCipher();
        String odd=halfOfString(encrypted, 0);
        String even=halfOfString(encrypted, 1);
        int key1=getKey(odd);
        int key2=getKey(even);
        System.out.println("key1 "+key1);
        System.out.println("key2 "+key2);
        return cc.encryptTwoKeys(encrypted,26-key1,26-key2);
    }
    
    public void testDecryptTwoKeys(){
        
        String message="Kl jxqqbo texq vlr jxv exsb ebxoa, qebob fp kl zxhb";
        System.out.println("Decrypted message "+decryptTwoKeys(message));
    }

    public static void main(String[] args){
        CeaserBreaker test=new CeaserBreaker();
        test.testDecrypt();
        test.testHalfOfString();
        test.testDecryptTwoKeys();
    }
}