import java.util.*;
import edu.duke.*;

public class LogAnalyzer
{
     private ArrayList<LogEntry> records;
     private ArrayList<String> mostDates;
     private ArrayList<String> mostIps;
     private ArrayList<Integer> counts;
     WebLogParser WebLogParser = new WebLogParser(); 
     
     public LogAnalyzer() {
         records = new ArrayList<LogEntry>();
         mostDates = new ArrayList<String>();
         mostIps = new ArrayList<String>();
         counts = new ArrayList<Integer>();
     }
     
     public void readFile(String filename) {
         FileResource resource = new FileResource();
          for(String line: resource.lines()){
              WebLogParser.parseEntry(line);
              records.add(WebLogParser.parseEntry(line));
          }                        
     }
     
     public int countUniqueIPs() {
        ArrayList<String> uniqueIPs = new ArrayList<String>();
        for (LogEntry le: records) {
        String ipAddr = le.getIpAddress();
            if(!uniqueIPs.contains(ipAddr)) {
                uniqueIPs.add(ipAddr);
            }
        }
        return uniqueIPs.size();
     }
        
     public void printAllHigherThanNum(int Num) {  
        System.out.println("Satus codes > "+Num);
        for(LogEntry le: records) {
        int statusCode = le.getStatusCode();
            if(statusCode > Num) {
                System.out.println(Num);
            }
        }
           
     }   
     
     
     public ArrayList<String> uniqueIPVisitsOnDay(String someday){
         ArrayList<String> dayIPs = new ArrayList<String>();
         String myString = null;
         for(LogEntry le: records) {
             Date d = le.getAccessTime();
             String ipAddr = le.getIpAddress();
             myString = d.toString();
             int index = dayIPs.indexOf(ipAddr);
             if((myString.contains(someday)) && (!dayIPs.contains(ipAddr))){
                   dayIPs.add(ipAddr);
                   counts.add(1);
             }
         
         for (int k =0; k < dayIPs.size();k++) {
             System.out.println(dayIPs.get(k)+"\t"); 
         }
         System.out.println("IPs on that day "+dayIPs.size());   
        }
        return dayIPs; 
     } 
     
     public int countUniqueIPsInRange(int low, int high){
        ArrayList<String> uniqueIPs = new ArrayList<String>();
        for(LogEntry New: records) {
        int statusCode = New.getStatusCode();
        String ipAddr = New.getIpAddress();
            if((statusCode >= low) && (statusCode <= high)) {
                if(!uniqueIPs.contains(ipAddr)) {
                uniqueIPs.add(ipAddr);
                }
            }
        }
        return uniqueIPs.size();
     }
     
     public HashMap<String,Integer> countVisitsPerIP() {
        HashMap<String,Integer> counts = new HashMap<String, Integer>();
        for (LogEntry le: records) {
            String ip = le.getIpAddress();
            if (!counts.containsKey(ip)) {
                counts.put(ip,1);
            }
            else {
                 counts.put(ip,counts.get(ip) + 1);
            }
       }
       return counts;
     }
     
    public ArrayList<String> iPsMostVisits(HashMap<String,Integer> addressNumberTime){   
    ArrayList<String> mostIps = new ArrayList<String>();    
    int greatest;
    greatest = mostNumberVisitsByIP(addressNumberTime);
    for (String s: addressNumberTime.keySet()) {
            if (addressNumberTime.get(s) == greatest) {
                mostIps.add(s);
            }
    }
    return mostIps;
    }
     
     public HashMap<String,ArrayList<String>> iPsForDays(){
     HashMap<String,ArrayList<String>> dayIpThatDay = new HashMap<String,ArrayList<String>>();
     ArrayList<String> dayIPs = new ArrayList<String>();
     String myString = null;
         for (LogEntry le: records) {
             Date d = le.getAccessTime();
             String ipAddr = le.getIpAddress();
             myString = d.toString();
             dayIPs = uniqueIPVisitsOnDay(myString);
             dayIpThatDay.put(myString,dayIPs);  
         }
     return dayIpThatDay;
    }
    
    public int findMax(){
        int theMax = counts.get(0);
        int maxIndex = 0;
        for(int k=0; k < counts.size(); k++){
            if (counts.get(k) > theMax){
              theMax = counts.get(k);
              maxIndex = k;
            }
        }
        return maxIndex;
    }
   
    public String dayWithMostIPVisits(HashMap<String,ArrayList<String>> dayIPs){
      String date;  
      String mostKeyDate= null;
      for (String s : dayIPs.keySet()) {
          int index = mostDates.indexOf(s);
          if (index == -1) {
             mostDates.add(s);
             counts.add(1);
          }
          else {
              int freq = counts.get(index);
              counts.set(index,freq+1);
               }
       }
       
       int max = findMax();
       System.out.println("most Date "+ mostDates.get(max)+" most visit "+ counts.get(max));
       return mostDates.get(max);
    }
    
    public ArrayList<String> iPsWithMostVisitsOnDay(HashMap<String,ArrayList<String>> dayandIPs, String aDay){
        counts.clear();
        ArrayList<String> mostIPs = new ArrayList<String>();
        mostIPs = uniqueIPVisitsOnDay(aDay);
        HashMap<String,Integer> counts = new HashMap<String,Integer>();      
        
        for (int k=0;k<mostIPs.size();k++) {
          String s = mostIPs.get(k) ; 
          if (!counts.containsKey(s)) {
                 counts.put(s,1);
             }
             else {
                 int freq = counts.get(s);
                 counts.put(s,freq+1);
             }
       }
       return iPsMostVisits(counts);
    }
    
    public int mostNumberVisitsByIP(HashMap<String,Integer> myCounts){ 
       int max = 0;
       for (String s: myCounts.keySet()){
            int currentNum = myCounts.get(s);
            if (currentNum > max) {
                max = currentNum;
            }
        }
        return max; 
    }
     
    public void printAll() {
         for(LogEntry le : records) {
             System.out.println(le);
         }
     }
         
}