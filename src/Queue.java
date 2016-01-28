

public class Queue<T> {
	private Node<T> head, tail;
	private int size;

	/** Creates a new instance of LinkedQueue */
	public Queue() {
		head = tail = null;
		size = 0;
	}

	public boolean full() {
		return false;
	}

	public int length() {
		return size;
	}

	public void enqueue(T e) {
		if (tail == null) {
			head = tail = new Node<T>(e);
		} else {
			tail.next = new Node<T>(e);
			tail = tail.next;
		}
		size++;
	}

	public T serve() {
		T x = head.data;
		head = head.next;
		size--;
		if (size == 0)
			tail = null;
		return x;
	}

	public void exchange(int i, int j) {
		// I dont have to exchange nodes loch
		Node<T> current = head;
		Node<T> I = null;
		T tmp1 = null, tmp2 = null;
		for (int k = 0; k < size; k++) {
			if (k == i){
				tmp1 = current.data;
				I = current;
			}
			else if (k == j) {
				tmp2 = current.data;
				current.data = tmp1;
			}
			current = current.next;
		}
		I.data = tmp2;

	}

}
