import edu.duke.*;
 
public class TestVigenereCipher{
    
    public int Caesarkey = 5 ;
    public int Vigenerekey[] = {17,14,12,4};
    public String[] theKey = {"flute"};
    VigenereBreaker VigenereBreaker;
    CaesarCracker cck = new CaesarCracker();
    CaesarCipher cc;
    VigenereCipher vc;
    
    public void testCaesarCipher(){
        cc = new CaesarCipher(Caesarkey);
        FileResource fr = new FileResource();
        String message = fr.asString();
        String encrypted =  cc.encrypt(message);
        System.out.println("Caesar Cipher encryption -\n" +encrypted);
        String decrypted = cc.decrypt(encrypted);
        System.out.println("Caesar Cipher decryption -\n "+decrypted+"\n\n");
    }
    
    public void testCaesarCracker(){
        FileResource fr = new FileResource();
        String message = fr.asString();
        String decrypted = cck.decrypt(message);
        System.out.println("CaesarCracker decryption -\n"+decrypted);
        int key = cck.getKey(message);
        System.out.println("CaesarCracker key - "+key+"\n\n");
    }
    
    public void testVigenereCipher(){
        vc = new VigenereCipher(Vigenerekey);
        FileResource fr = new FileResource();
        String message  = fr.asString();
        String encrypted =  vc.encrypt(message);
        System.out.println("Vigenere encryption -\n" +encrypted);
        String decrypted = vc.decrypt(encrypted);
        System.out.println("Vigenere decryption - \n"+decrypted+"\n\n");
    }
    
    public void testSliceString(){
        VigenereBreaker = new VigenereBreaker();
        System.out.println("Should return adgjm = "+VigenereBreaker.sliceString("abcdefghijklm",0,3));
        System.out.println("Should return behk = "+VigenereBreaker.sliceString("abcdefghijklm",1,3));
        System.out.println("Should return cfil = "+VigenereBreaker.sliceString("abcdefghijklm",2,3));
        System.out.println("Should return aeim = "+VigenereBreaker.sliceString("abcdefghijklm",0,4));
        System.out.println("Should return bjf = "+VigenereBreaker.sliceString("abcdefghijklm",1,4));
        System.out.println("Should return cgk = "+VigenereBreaker.sliceString("abcdefghijklm",2,4));
        System.out.println("Should return dhl = "+VigenereBreaker.sliceString("abcdefghijklm",3,4));
        System.out.println("Should return afk = "+VigenereBreaker.sliceString("abcdefghijklm",0,5));
        System.out.println("Should return bgl = "+VigenereBreaker.sliceString("abcdefghijklm",1,5));
        System.out.println("Should return chm = "+VigenereBreaker.sliceString("abcdefghijklm",2,5));
        System.out.println("Should return di = "+VigenereBreaker.sliceString("abcdefghijklm",3,5));
        System.out.println("Should return ej = "+VigenereBreaker.sliceString("abcdefghijklm",4,5));
    }
    
    public void TestTryKeyLength(){
        VigenereBreaker vb = new VigenereBreaker();
        FileResource fr = new FileResource();
        String message  = fr.asString();
        int keyReturn[] = new int[4];
        keyReturn = vb.tryKeyLength(message,4,'e');
        System.out.println("Keys-");
        for (int i =0 ;i < keyReturn.length;i+=1){
            System.out.println(keyReturn[i]);
        }
    }
    
    public void testVigenereBreaker(){
        int keyReturn[] = new int[4];
        String decrypted = new String();
        VigenereBreaker vb= new VigenereBreaker();
        String message = vb.breakVigenere();
        keyReturn = vb.tryKeyLength(message,4,'e');
        VigenereCipher vc = new VigenereCipher(keyReturn) ;
        decrypted += vc.decrypt(message);
        System.out.println("VigenereCipher decryption - \n"+decrypted);
    
    }

    public static void main(String[] args){
        TestVigenereCipher test=new TestVigenereCipher();
        test.testCaesarCipher();
        test.testCaesarCracker();
        test.testVigenereCipher();
        test.testSliceString();
        test.testVigenereBreaker();
    }
}