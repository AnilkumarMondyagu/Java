public class CycleMain{
	public static void main(String[] args){
		Cycle[] objectArray=new Cycle[3];
		objectArray[0]=new Unicycle();
		objectArray[1]=new Bicycle();
		objectArray[2]=new Tricycle();

		/*for(int i=0;i<2;i++){
			objectArray[i].balance();
		}*/

		Unicycle uc=(Unicycle)objectArray[0];
		Bicycle bic=(Bicycle)objectArray[1];

		uc.balance();
		bic.balance();
	}
}