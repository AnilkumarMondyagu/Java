
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
        FileResource resource = new FileResource(filename);
          for(String line: resource.lines()){
              WebLogParser.parseEntry(line);
              records.add(WebLogParser.parseEntry(line));
          }
     }
        
     public void printAll() {
         for (LogEntry le : records) {
             System.out.println(le);
         }
     }
     
     
}
