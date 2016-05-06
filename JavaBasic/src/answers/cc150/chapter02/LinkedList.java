package answers.cc150.chapter02;

public class LinkedList<T> {
	private MyNode<T> head;
	private MyNode<T> tail;
	private int size;
	
	public MyNode<T> getHead() {
		return this.head;
	}
	
	public MyNode<T> getTail() {
		return this.tail;
	}
	
	public int size() {
		return this.size;
	}
	
	public LinkedList() {
		this.head = null;
		this.tail = null;
		this.size = 0;
	}
	
	public LinkedList(MyNode<T> node) {
		if(node == null) {
			throw new RuntimeException("Cannot add null value");
		}
		this.head = node;
		this.tail = node;
		this.size = 1;
	}
	
	public void addVal(T val) {
		if(this.size == 0) {
			this.head = new MyNode<T>(val);
			this.tail = head;
			this.size++;
		} else {
			MyNode<T> newTail = new MyNode<T>(val);
			this.tail.setNext(newTail);
			this.tail = newTail;
			this.size++;
		}
	}
	
	public void printList(int width) {
		MyNode<T> tmpNode = this.head;
		System.out.print("index: ");
		for(int i = 0; i < this.size; i++) {
			System.out.print(String.format("%"+width+"d | ", i));
		}
		System.out.println();
		System.out.print("value: ");
		while(tmpNode != null) {
			System.out.print(String.format("%"+width+"s | ", tmpNode.getValue()));
			tmpNode = tmpNode.next;
		}
		System.out.println();
	}
	
	public class LinkedListBuilder {
		private LinkedList<T> list;
		
		public LinkedListBuilder() {
			this.list = new LinkedList<T>();
		}
		
		public LinkedList<T> buildList() {
			return this.list;
		}
		
		public LinkedListBuilder addVal(T val) {
			list.addVal(val);
			return this;
		}
	}
	
}
