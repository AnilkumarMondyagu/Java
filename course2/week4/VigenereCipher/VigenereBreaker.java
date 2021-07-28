import java.util.*;
import edu.duke.*;

public class VigenereBreaker {
    public String sliceString(String message, int whichSlice, int totalSlices) {
        StringBuilder slicing = new StringBuilder(message);
        String result = new String();
        for(int k = whichSlice;k<slicing.length();k+=totalSlices){
            result += slicing.charAt(k);
        } 
        return result;
    }

    public int[] tryKeyLength(String encrypted, int klength, char mostCommon) {
        CaesarCracker csrcrkr= new CaesarCracker('e');
        int aKey;
        int[] key = new int[klength];
        for(int k =0;k<klength;k++){
           aKey = csrcrkr.getKey(sliceString(encrypted,k,klength));
           key[k] = aKey;
        }
        return key;
    }

    public String breakVigenere() {
        FileResource resource = new FileResource();
        String message = resource.asString();
        return message;
    }
    
}
