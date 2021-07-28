public class CaesarCipher{

    private String alphabet;
    private String shiftedAlphabet;
    private int mainKey;


    public CaesarCipher(int key){
        this.alphabet="ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        this.shiftedAlphabet=this.alphabet.substring(key)+this.alphabet.substring(0,key);
        this.mainKey=key;
    }
    public String encrypt(String input){
        StringBuilder encrypted=new StringBuilder(input);
        for(int i=0; i<encrypted.length(); i++){
            char currentChar=encrypted.charAt(i);
            if(this.alphabet.indexOf(currentChar)!=-1){
                int index=this.alphabet.indexOf(currentChar);
                char newChar=this.shiftedAlphabet.charAt(index);
                encrypted.setCharAt(i,newChar);
            }
        }
        return encrypted.toString();
    }

    public String decrypt(String input){
        CaesarCipher cc=new CaesarCipher(26-mainKey);
        return cc.encrypt(input);
    }
}
