

public class Node<Type> {
	public Type data;
	public Node<Type> next;
	public Node<Type> prev;

	public Node() {
		data = null;
		prev = next = null;
	}

	public Node(Type val) {
		data = val;
		next = prev = null;
	}

}
