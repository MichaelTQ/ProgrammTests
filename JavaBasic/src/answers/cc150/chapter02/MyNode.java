package answers.cc150.chapter02;

public class MyNode<T> {
	private T value;
	MyNode<T> next;

	public MyNode () {
		this.next = null;
	}
	public MyNode (T value) {
		this.value = value;
		this.next = null;
	}
	public MyNode (MyNode<T> node) {
		this.value = node.getValue();
	}
	
	public T getValue() {
		return this.value;
	}
	
	public void setValue(T value) {
		this.value = value;
	}
	
	public void setNext(MyNode<T> node) {
		this.next = node;
	}
	
	public MyNode<T> getNextNode() {
		return this.next;
	}
	
	public T getNextNodeValue() {
		return this.next.getValue();
	}
}
