import edu.duke.*;
import org.apache.commons.csv.*;
import java.io.*;

public class BabyNames{
	public void totalBirths(FileResource fr){
		int totalBirths=0;
		int totalGirls=0;
		int totalBoys=0;
		CSVParser parser=fr.getCSVParser(false);
		for(CSVRecord record:parser) {
			int numBirths=Integer.parseInt(record.get(2));
			String gender=record.get(1);
			totalBirths+=numBirths;
			if(gender.equals("M")){
				totalBoys+=numBirths;
			}
			else{
				totalGirls+=numBirths;
			}
		}
		System.out.println("Total Births:"+totalBirths);
		System.out.println("Boys:"+totalBoys);
		System.out.println("Girls:"+totalGirls);
	}

	public long getRank(int year, String name, String gender){
		long rank=-1;
		FileResource fr=new FileResource("us_babynames/us_babynames_by_year/yob"+year+".csv");
		CSVParser parser=fr.getCSVParser(false);
		for(CSVRecord record:parser){
			String currentName=record.get(0);
			String currentGender=record.get(1);
			if(currentGender.equals(gender) && currentName.equals(name)){
				rank=record.getRecordNumber();
			}
		}
		return rank;
	}

	public String getName(int year, int rank, String gender){
		String name="";
		FileResource fr=new FileResource("us_babynames/us_babynames_by_year/yob"+year+".csv");
		CSVParser parser=fr.getCSVParser(false);
		for(CSVRecord record:parser){
			String currentName=record.get(0);
			String currentGender=record.get(1);
			long currentRank=record.getRecordNumber();
			if(currentRank==rank && currentGender.equals(gender)){
				name=currentName;
				break;
			}
		}
		if(!name.equals("")){
			return name;
		}
		return "NO NAME";
	}

	public void whatIsNameInYear(String name, int year, int newYear, String gender){
		FileResource fr=new FileResource("us_babynames/us_babynames_by_year/yob"+year+".csv");
		FileResource newFr=new FileResource("us_babynames/us_babynames_by_year/yob"+newYear+".csv");
		CSVParser parser1=fr.getCSVParser(false);
		CSVParser parser2=newFr.getCSVParser(false);
		String newName="";
		long rank=0;
		for(CSVRecord record:parser1) {
			String currentName=record.get(0);
			String currentGender=record.get(1);
			if(currentName.equals(name) && currentGender.equals(gender)){
				rank=record.getRecordNumber();
				break;
			}
		}
		for(CSVRecord record:parser2) {
			String currentGender=record.get(1);
			long currentRank=record.getRecordNumber();
			if(currentGender.equals(gender) && rank==currentRank){
				newName=record.get(0);
			}
		}
		System.out.println(name+" born in "+year+" would be "+newName+" if she was born in "+newYear);
	}

	public int yearOfHighestRank(String name, String gender){
		long highestRank=0;
		int yearOfHighestRank=-1;
		String fileName="";
		DirectoryResource dr=new DirectoryResource();
		for(File f:dr.selectedFiles()){
			FileResource fr=new FileResource(f);
			CSVParser parser=fr.getCSVParser(false);
			for(CSVRecord record:parser){
				String currentName=record.get(0);
				String currentGender=record.get(1);
				if(currentName.equals(name) && currentGender.equals(gender)){
					long rank=record.getRecordNumber();
					if(highestRank==0){
						highestRank=rank;
						fileName=f.getName();
					}
					else if(highestRank>rank){
						highestRank=rank;
						fileName=f.getName();
					}
				}
			}
		}
		fileName = fileName.substring(3,7);
		yearOfHighestRank = Integer.parseInt(fileName);
		return yearOfHighestRank;
	}
  
	public double getAverageRank(String name, String gender){
		DirectoryResource dr=new DirectoryResource();
		double sumRanks=0.0;
		int count=0;
		for(File f:dr.selectedFiles()){
			FileResource fr=new FileResource(f);
			CSVParser parser=fr.getCSVParser(false);
			for(CSVRecord record:parser){
				String currentName=record.get(0);
				String currentGender=record.get(1);
				if(currentName.equals(name) && currentGender.equals(gender)){
					long currentRank=record.getRecordNumber();
					sumRanks+=(double)currentRank;
					count++;
				}
			}
		}
		double averageRank=sumRanks/count;
		return averageRank;
	}
  
	public int getTotalBirthsRankedHigher(int year, String name, String gender){
		int totalBirths=0;
		long rank=getRank(year,name,gender);
		FileResource fr=new FileResource("us_babynames/us_babynames_by_year/yob"+year+".csv");
		CSVParser parser=fr.getCSVParser(false);
		for(CSVRecord record:parser) {
			int births=Integer.parseInt(record.get(2));
			String currentGender=record.get(1);
			long currentRank=record.getRecordNumber();
			if(gender.equals(currentGender) && rank>currentRank){
				totalBirths+=births;
			}
		}
		return totalBirths;
	}

	public void test(){
		FileResource fr=new FileResource();
		totalBirths(fr);

		long rank=getRank(2012,"Ethan","M");
		System.out.println("Rank is: "+rank);

		String name=getName(2012,20,"F");
		System.out.println("Name: "+name);

		whatIsNameInYear("Isabella",2012,2014,"F");

		int yearOfHighestRank=yearOfHighestRank("Isabella","F");
		System.out.println("Highest rank year:"+yearOfHighestRank);

		double averageRank=getAverageRank("Sophia","F");
		System.out.println("Average rank:"+averageRank);

		long total=getTotalBirthsRankedHigher(2012,"Isabella","F");
		System.out.println("Total higher:"+total);
	}

	public static void main(String[] args){
		BabyNames test=new BabyNames();
		test.test();
	}
}