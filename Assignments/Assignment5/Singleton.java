

public class Singleton{
	String stringMember;
	 /*public static Singleton initialize(String s){
	 	stringMember=s;
	 	//non-static variable stringMember cannot be referenced from a static context
	 	return this;
	 	//non-static variable this cannot be referenced from a static context
	 }*/
	 public void print(){
	 	System.out.println(stringMember);
	 }

}