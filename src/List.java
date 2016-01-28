public class List<T> {

	private Node<T> head;
	private Node<T> current;
	private int size;

	public List() {
		head = current = null;
		size = 0;
	}

	public boolean empty() {
		return head == null;
	}

	public boolean last() {
		return current.next == null;
	}

	public boolean first() {
		return current.prev == null;
	}

	public boolean full() {
		return false;
	}

	public void findfirst() {
		current = head;
	}

	public void findnext() {
		current = current.next;
	}

	public void findPrevious() {
		current = current.prev;
	}

	public T retrieve() {
		return current.data;
	}

	public void update(T val) {
		current.data = val;
	}

	public void insert(T val) {
		Node<T> tmp = new Node<T>(val);
		if (empty()) {
			current = head = tmp;
		} else {
			tmp.next = current.next;
			tmp.prev = current;
			if (current.next != null)
				current.next.prev = tmp;
			current.next = tmp;
			current = tmp;
		}
		size++;
	}

	public void remove() {
		if (current == head) {
			head = head.next;
			if (head != null)
				head.prev = null;
		} else {
			current.prev.next = current.next;
			if (current.next != null)
				current.next.prev = current.prev;
		}
		if (current.next == null)
			current = head;
		else
			current = current.next;
		size--;
	}

	public boolean endList() {
		
		if (current == null) {
			toLast();
			return true;
		}
		return false;
	}

	public int length() {
		return size;
	}

	public Node<T> takeNode() {
		return current;
	}

	public void toLast() {
		current = head;
		while (current.next != null) {
			current = current.next;
		}
	}

}
