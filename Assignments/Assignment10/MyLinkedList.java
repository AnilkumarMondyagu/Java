class LLNode<E> 
{
	LLNode<E> next;
	E data;

	public LLNode()
	{
		this.data = null;
		this.next = null;
	}

	public LLNode(E e) 
	{
		this.data = e;
		this.next = null;
	}

}

public class SList<E>{
	LLNode<E> head;
	LLNode<E> temp;
	int size;

	public SList() {
		size = 0;
		head = new LLNode<E>(null);
		head.next = null;
		temp = head;
	}
	
	
	class SListIterator{
	    LLNode<E> temp;
	    int curr;
	    SListIterator(){
	        temp = head.next;
	        curr=0;
	    }
	    
	    public boolean hasNext(){
	        if(curr<size){
	            return true;
	        }
	        return false;
	    }
	    
	    public E next(){
	        E val=temp.data;
	        temp=temp.next;
	        curr++;
	        return val;
	    }
	    
	    public boolean add(E element ){
	        LLNode<E> temp1 = head;
    		for (int i = 0; i < size; i++) {
    			temp1 = temp1.next;
    		}
    		LLNode<E> n = new LLNode<E>(element);
    		temp1.next=n;
    		temp1=n;
    		size++;
    		return true;
    	}
    	
    	public E remove(){
    		LLNode<E> n = head;
    		for (int i = 0; i < size-1; i++){
    			n = n.next;
    		}
    		E val=n.next.data;
    		n.next=n.next.next;
    		size--;
    		return val;
    	}
	    
	}
	

	public int size() 
	{
		return size;
	}

	public void display(){
	    LLNode<E> temp = head.next;
	    System.out.println("Display:");
	    while(temp!=null){
	        System.out.print(temp.data+"\t");
	        temp=temp.next;
	    }
	    System.out.println();
	}

	public static void main(String[] args){
		SList<Integer> sll=new SList<Integer>();
		SList<Integer>.SListIterator itr;
		itr= sll.new SListIterator();
		itr.add(10);
		itr.add(30);
		sll.display();
		itr.add(40);
		sll.display();
		System.out.println("Element removed:"+itr.remove());
		sll.display();
		System.out.println("Size :"+sll.size());
		itr= sll.new SListIterator();
		while(itr.hasNext()){
		    System.out.println(itr.next());
		}
		
	}
}









