public class Main extends ConcreteClass implements CombineInterface{

    public void method1() {
        System.out.println("Method1 of Interface1");
    }

    public void method2() {
        System.out.println("Method2 of Interface1");
    }

    public void method3() {
        System.out.println("Method3 of Interface2");
    }

    public void method4() {
        System.out.println("Method4 of Interface2");
    }

    public void method5() {
        System.out.println("Method5 of Interface3");
    }

    public void method6() {
        System.out.println("Method6 of Interface3");
    }
    
    public void combineMethod() 
    {
        System.out.println("Method of CombineInterface");
    }

    public void Interface1Method(Interface1 i1){
        i1.method1();
    }

    public void Interface2Method(Interface2 i2){
        i2.method3();
    }

    public void Interface3Method(Interface3 i3){
        i3.method5();
    }

    public void CombineInterfaceMethod(CombineInterface ci){
        ci.combineMethod();
    }
    
    public static void main(String[] args){
    	Main test=new Main();
    	test.Interface1Method(test);
    	test.Interface2Method(test);
    	test.Interface3Method(test);
    	test.concreteClassMethod();
    }
}
