public class WordPlay{
    public boolean isVowel(char ch){
        ch=Character.toLowerCase(ch);
        if(ch=='a' || ch=='i' || ch=='u' || ch=='e' || ch=='o'){
            return true;
        }
        return false;
    }
    
    public String replaceVowels(String phrase, char ch){
        StringBuilder resultPhrase=new StringBuilder();
        for (int i=0;i<phrase.length();i++){
            char currentCharacter=phrase.charAt(i);
            if(isVowel(currentCharacter)){
                resultPhrase.append(ch);
            } 
            else{
                resultPhrase.append(currentCharacter);
            }
        }
        return resultPhrase.toString();
    }
    
    public String emphasize(String phrase, char ch){
        StringBuilder resultPhrase=new StringBuilder();
        for (int i=0;i<phrase.length();i++){
            char currentCharacter=phrase.charAt(i);   
            if (Character.toLowerCase(currentCharacter)==Character.toLowerCase(ch)){
                if(i%2==0){
                    resultPhrase.append('+');
                } 
                else{
                    resultPhrase.append('*');
                }
            } 
            else{
                resultPhrase.append(currentCharacter);
            }
        }
        return resultPhrase.toString();
    }
    

    public static void main(String[] args){
        WordPlay test=new WordPlay();
        System.out.println("HelloWorld after replacing - "+test.replaceVowels("HelloWorld",'*'));
        
        System.out.println("Mary Bella Abracadabra - "+test.emphasize("Mary Bella Abracadabra",'a'));
    }
}