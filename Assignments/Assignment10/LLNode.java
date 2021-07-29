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

