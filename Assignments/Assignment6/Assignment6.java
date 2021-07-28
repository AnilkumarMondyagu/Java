public class Assignment6{
	int val;
	String text;
	public Assignment6(){
		val=10;
	}
	public Assignment6(String s){
		this();
		text=s;
		System.out.println(text);
	}
	public static void main(String[] args){
		VampireNumbers test=new VampireNumbers();
		test.printVampireNumbers();
		Assignment6[] objectArray=new Assignment6[3];
		for(int i=0;i<3;i++){
			objectArray[i]=new Assignment6("Object"+i);
		}
	}
}