
import java.util.*;

public class Tester
{
    public void testLogEntry() {
        System.out.println("LogEntry:");
        LogEntry le = new LogEntry("1.2.3.4", new Date(), "example request", 200, 500);
        System.out.println(le);
        LogEntry le2 = new LogEntry("1.2.100.4", new Date(), "example request 2", 300, 400);
        System.out.println(le2);
    }
    
    public void testLogAnalyzer() {
        LogAnalyzer La = new LogAnalyzer();
        La.readFile("short-test_log");
        La.printAll();
    }

    public void testUniqIP() {
        LogAnalyzer la=new LogAnalyzer();
        la.readFile("short-test_log");
        int uniqueIPsCount=la.countUniqueIPs();
        System.out.println(uniqueIPsCount+" unique IPs");
    }
    
    public void testprintAllHigherthanNum() {
        LogAnalyzer la=new LogAnalyzer();
        la.readFile("weblog1_log");
        la.printAllHigherThanNum(200);
    }
    
    public void testuniqueIPVisitsOnDay() {
        LogAnalyzer la=new LogAnalyzer();
        la.readFile("weblog1_log");
        la.uniqueIPVisitsOnDay("Sep 14");
    }
    
    public void testcountUniqueIPsInRange() {
        LogAnalyzer la= new LogAnalyzer();
        la.readFile("weblog1_log");
        int countinRange=la.countUniqueIPsInRange(200, 299);
        System.out.println(countinRange + " IPs");
    }

    public static void main(String[] args){
        Tester t=new Tester();
        t.testLogAnalyzer();
        t.testLogEntry();
        t.testUniqIP();
        t.testuniqueIPVisitsOnDay();
        t.testprintAllHigherthanNum();
        t.testcountUniqueIPsInRange();
    }
}
