import edu.duke.*;
import org.apache.commons.csv.*;

public class Exports{
    public String countryInfo(CSVParser parser, String country){
        for(CSVRecord record:parser){
            String current=record.get("Country");
            if(current.equalsIgnoreCase(country)){
                String exports=record.get("Exports");
                String value=record.get("Value (dollars)");
                String info=current+":"+exports+":"+value;
                return info;
            }
        }
        return "Country not found";
    }
    
    public void listExportersTwoProducts(CSVParser parser, String exportItem1, String exportItem2){
         for(CSVRecord record:parser){
            String exports=record.get("Exports");
            if(exports.contains(exportItem1) && exports.contains(exportItem2)){
                String country=record.get("Country");
                System.out.println(country);
            }
        }
    }
    
    public int numberOfExporters(CSVParser parser, String exportItem){
        int countries=0;
        for(CSVRecord record:parser){
            String exports=record.get("Exports");
            if(exports.contains(exportItem)){
                countries++;
            }
        }       
        return countries;
    }
    
    public void bigExporters(CSVParser parser, String amount){
        for(CSVRecord record:parser){
            String current=record.get("Value (dollars)");
            if (current.length()>amount.length()) {
                String country=record.get("Country");
                System.out.println(country+":"+current);
            }
        }
    }
    
    public void tester(){
        FileResource fr=new FileResource();
        CSVParser parser=fr.getCSVParser();
        System.out.println(countryInfo(parser,"namibia"));
        
        parser=fr.getCSVParser();
        listExportersTwoProducts(parser, "gold","diamonds");
        
        parser=fr.getCSVParser();
        System.out.println(numberOfExporters(parser,"gold"));
        
        parser=fr.getCSVParser();
        bigExporters(parser,"$999,999,999");
    }

    public static void main(String[] args){
        Exports exp=new Exports();
        exp.tester();
    }
}