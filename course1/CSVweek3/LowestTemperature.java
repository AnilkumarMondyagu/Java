import edu.duke.*;
import org.apache.commons.csv.*;
import java.io.*;

public class LowestTemperature{
	public CSVRecord coldestHourInFile(CSVParser parser){
		CSVRecord coldest=null;
		for(CSVRecord currentRecord:parser){
			if(coldest==null){
				coldest=currentRecord;
			} 
			else{
				double currentTemp=Double.parseDouble(currentRecord.get("TemperatureF"));
				double lowestTemp=Double.parseDouble(coldest.get("TemperatureF"));
				if(currentTemp<lowestTemp){
					coldest=currentRecord;
				}
			}
		}
		return coldest;
	}

	public void testColdestHourInFile() {
		FileResource f=new FileResource();
		CSVParser parser=f.getCSVParser();
		CSVRecord coldest=coldestHourInFile(parser);
		System.out.println(coldest.get("TemperatureF")+" on "+coldest.get("DateUTC"));
	}

	public String fileWithColdestTemperature(){
		File file=null;
		CSVRecord coldest=null;

		DirectoryResource dr = new DirectoryResource();
		for (File f:dr.selectedFiles()) {
			FileResource fr=new FileResource(f);
			CSVParser parser=fr.getCSVParser();
			CSVRecord current=coldestHourInFile(parser);
			
			if(coldest==null){
				coldest=current;
				file=f;
			} 
			else 
			{
				double currentTemp=Double.parseDouble(current.get("TemperatureF"));
				double lowestTemp=Double.parseDouble(coldest.get("TemperatureF"));
				if(currentTemp<lowestTemp){//<-50
					coldest=current;
					file=f;
				}
			}
		}
		return file.getAbsolutePath();
	}

	public void testFileWithColdestTemperature(){
		String fileWithColdestTemp=fileWithColdestTemperature();
		File f=new File(fileWithColdestTemp);
		String fileName=f.getName();

		System.out.println("Coldest day :"+fileName);

		FileResource fr=new FileResource(f);
		CSVParser parser=fr.getCSVParser();
		CSVRecord lowestTemp=coldestHourInFile(parser);

		System.out.println("Lowest Temperature:"+lowestTemp.get("TemperatureF"));

		System.out.println("All Temperatures on coldest day:");
		parser=fr.getCSVParser();
		for(CSVRecord record:parser) {
			double temp=Double.parseDouble(record.get("TemperatureF"));
			System.out.println(temp);
		}
	}

	public CSVRecord lowestHumidityInFile(CSVParser parser) {
		CSVRecord lowest=null;
		int currentHumidity;
		for(CSVRecord record:parser) {
			if(lowest == null) {
				lowest = record;
			} 
			else {
				if(!(record.get("Humidity").equals("N/A") || lowest.get("Humidity").equals("N/A"))){
					currentHumidity=Integer.parseInt(record.get("Humidity"));
					int lowestHumidity = Integer.parseInt(lowest.get("Humidity"));
					if(currentHumidity<lowestHumidity){
						lowest=record;
					}
				}
			}
		}
		return lowest;
	}

	public void testLowestHumidityInFile(){
		FileResource fr=new FileResource();
		CSVParser parser=fr.getCSVParser();
		CSVRecord lowestHumdity=lowestHumidityInFile(parser);
		System.out.println(lowestHumdity.get("DateUTC")+" with "+lowestHumdity.get("Humidity"));
	}

	public CSVRecord lowestHumidityInManyFiles(){
		CSVRecord lowest=null;

		DirectoryResource dr = new DirectoryResource();
		for (File f : dr.selectedFiles()) {
			FileResource fr = new FileResource(f);
			CSVParser parser=fr.getCSVParser();
			CSVRecord record=lowestHumidityInFile(parser);
			
			if(lowest==null) {
				lowest=record;
			} 
			else {
				if(!(record.get("Humidity").equals("N/A") || lowest.get("Humidity").equals("N/A"))){
					int currentHumidity=Integer.parseInt(record.get("Humidity"));
					int lowestHumidity=Integer.parseInt(lowest.get("Humidity"));
					
					if(currentHumidity<lowestHumidity){
						lowest=record;
					}
				}
			}
		}
		return lowest;
	}

	public void testLowestHumidityInManyFiles(){
		CSVRecord record=lowestHumidityInManyFiles();
		System.out.println("Lowest Humidity was "+record.get("Humidity")+" at "+record.get("DateUTC"));
	}

	public double averageTemperatureInFile(CSVParser parser){
		double numTemp=0.0;
		double sumTemp=0.0;
		for(CSVRecord record:parser){
			double temp=Double.parseDouble(record.get("TemperatureF"));
			sumTemp+=temp;
			numTemp++;
		}
		double averageTemp=sumTemp/numTemp;
		return averageTemp;
	}

	public void testAverageTemperatureInFile() {
		FileResource fr=new FileResource();
		CSVParser parser=fr.getCSVParser();
		double averageTemp=averageTemperatureInFile(parser);

		System.out.println("Average temperature in file is " + averageTemp);
	}

	public double averageTemperatureWithHighHumidityInFile(CSVParser parser, int value){
		double numTemp=0.0;
		double sumTemp=0.0;

		for(CSVRecord record:parser) {
			double temp=Double.parseDouble(record.get("TemperatureF"));
			int humidity=Integer.parseInt(record.get("Humidity"));
			if(humidity>=value) {
				sumTemp+=temp;
				numTemp++;
			}
		}

		double averageTemp=sumTemp/numTemp;
		return averageTemp;
	}

	public void testAverageTemperatureWithHighHumidityInFile(){
		FileResource fr = new FileResource();
		CSVParser parser=fr.getCSVParser();
		double average=averageTemperatureWithHighHumidityInFile(parser, 80);

		if(average!=0.0) {
			System.out.println("Average temperature with high Humidity is "+average);
		} else {
			System.out.println("No Temperatures with that humidity");
		}
	}
	public static void main(String[] args){
		LowestTemperature test=new LowestTemperature();
		test.testFileWithColdestTemperature();
	}
}