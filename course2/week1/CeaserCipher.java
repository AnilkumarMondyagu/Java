import edu.duke.*;
import java.util.*;

public class CeaserCipher{
    public String encrypt(String input,int key){
        StringBuilder encryptedMessage=new StringBuilder();
        String alphabet="ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        String encryptedAlphabet=alphabet.substring(key)+alphabet.substring(0,key);
        for(int i=0;i<input.length();i++){
            char currentCharacter=input.charAt(i);
            int index=alphabet.toLowerCase().indexOf(Character.toLowerCase(currentCharacter));
            
            if(index!=-1){
                if(Character.isLowerCase(currentCharacter)){
                    encryptedMessage.append(Character.toLowerCase(encryptedAlphabet.charAt(index)));
                }
                else{
                    encryptedMessage.append(encryptedAlphabet.charAt(index));
                }
            }
            else{
                encryptedMessage.append(currentCharacter);
            }
        }
        return encryptedMessage.toString();
    }
    
    public void testEncrypt() {
        FileResource fr=new FileResource();
        String message=fr.asString();
        int key=23;
        String encryptedMessage=encrypt(message,key);
        System.out.println("After encryption: "+encryptedMessage);
    }
    
    public String encryptTwoKeys(String input, int key1, int key2){
        String alphabet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        String firstAlphabet=alphabet.substring(key1)+alphabet.substring(0,key1);
        String secondAlphabet=alphabet.substring(key2)+alphabet.substring(0,key2);
        StringBuilder encryptedMessage=new StringBuilder();
        for(int i=0;i<input.length();i++){
            char currentCharacter=input.charAt(i);
            int index=alphabet.toLowerCase().indexOf(Character.toLowerCase(currentCharacter));
            if(index!=-1){
                if(i%2==0){
                    if(Character.isLowerCase(currentCharacter)){
                    encryptedMessage.append(Character.toLowerCase(firstAlphabet.charAt(index)));                
                    }
                    else{
                    encryptedMessage.append(firstAlphabet.charAt(index));
                    }
                }
                else{
                    if (Character.isLowerCase(currentCharacter)){
                        encryptedMessage.append(Character.toLowerCase(secondAlphabet.charAt(index)));                
                    }
                    else{
                        encryptedMessage.append(secondAlphabet.charAt(index));
                    }
                } 
            }
            else{
                encryptedMessage.append(currentCharacter);
            }
        } 
        return encryptedMessage.toString();
    }
    
    public void testEncryptTwoKeys(){
        String message="First Legion";
        int key1=23;
        int key2=17;
        String encryptedMessage=encryptTwoKeys(message, key1, key2);
        System.out.println("Encrypted with two keys: "+encryptedMessage);
    }

    public static void main(String[] args){
        CeaserCipher test=new CeaserCipher();
        test.testEncrypt();
        test.testEncryptTwoKeys();
    }
}