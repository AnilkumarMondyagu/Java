public class RodentMain{
	public static void main(String[] args){
		Rodent[] rodents=new Rodent[2];
		rodents[0]=new Mouse();
		rodents[0].tail();
		rodents[0].identification();
		System.out.println("\n\n");
		rodents[1]=new Hamster();
		rodents[1].tail();
		rodents[1].identification();
	}
}