public class SecondClass extends FirstClass{
	int outerSecond=2;
	class SecondInnerClass extends FirstInnerClass{
		int innerSecond;
		public SecondInnerClass(int val1,int val2){
			new FirstClass().super(val1);
			innerSecond=val2;
		}
	}
	public static void main(String[] args){
		SecondClass sc=new SecondClass();
		SecondClass.SecondInnerClass sic=sc.new SecondInnerClass(11,22);
		System.out.println(sic.innerSecond);
		System.out.println(sic.innerFirst);
	}
}