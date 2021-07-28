import java.util.*;
import edu.duke.*;

public class LogAnalyzer
{
     private ArrayList<LogEntry> records;
     WebLogParser WebLogParser = new WebLogParser();
     
     public LogAnalyzer() {
         records = new ArrayList<LogEntry>();
     }
     
     public void readFile(String filename) {
         FileResource resource = new FileResource();
          for(String line: resource.lines()){
              WebLogParser.parseEntry(line);
              records.add(WebLogParser.parseEntry(line));}                        
     }
     
     public int countUniqueIPs(){
        ArrayList<String> uniqueIPs = new ArrayList<String>();
        for(LogEntry le: records){
        String ipAddr = le.getIpAddress();
            if(!uniqueIPs.contains(ipAddr)){
                uniqueIPs.add(ipAddr);
            }
        }
        return uniqueIPs.size();
     }
        
     public void printAllHigherThanNum(int Num) { 
        System.out.println("Status codes freater than "+Num);
        for(LogEntry le: records){
        int statusCode = le.getStatusCode();
            if(statusCode > Num){
                System.out.println(Num);
            }
        }
           
     }   

     public void uniqueIPVisitsOnDay(String someday){
         ArrayList<String> myIPs = new ArrayList<String>();
         String dateString = null;
         
         for(LogEntry le:records) {
             Date d=le.getAccessTime();
             String ipAddr=le.getIpAddress();
             dateString=d.toString();
             if((dateString.contains(someday)) && (!myIPs.contains(ipAddr))){
                    myIPs.add(ipAddr);
                }
         }
         
         for(int k =0; k < myIPs.size();k++){
                System.out.println(myIPs.get(k)+"\t"); 
         }
         System.out.println("IP's on day:"+myIPs.size());           
     }
         
     
     public int countUniqueIPsInRange(int low, int high){
        ArrayList<String> uniqueIPs = new ArrayList<String>();
        for(LogEntry le: records){
            int statusCode=le.getStatusCode();
            String ipAddr=le.getIpAddress();
            if((statusCode>=low) && (statusCode<=high)){
                if(!uniqueIPs.contains(ipAddr)){
                uniqueIPs.add(ipAddr);
                }
            }
        }
        return uniqueIPs.size();
     }
        
     public void printAll() {
         for(LogEntry le : records) {
             System.out.println(le);
         }
     }
       
}