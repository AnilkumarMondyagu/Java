import java.util.*;
public class VampireNumbers{
    public void printVampireNumbers(){
        String[] arr1, arr2;
        int product,count=0;
        for (int first = 10; first < 1000; first++) {
            for (int second = first; second< 1000; second++) {
                product = first*second;
                int lengthFirst= String.valueOf(first).length();
                int lengthSecond= String.valueOf(second).length();
                if(product<1000 || lengthFirst!=lengthSecond)
                    continue;
                arr1 = String.valueOf(product).split("");
                arr2 = (String.valueOf(first) + String.valueOf(second)).split("");
                Arrays.sort(arr1);
                Arrays.sort(arr2);
                if(Arrays.equals(arr1,arr2)){
                    count++;
                    System.out.println("Vampire number "+count+": "+product);
                }
                if(count==100){
                    break;
                }
            }
            if(count==100){
                break;
            }
        }
    }
}
