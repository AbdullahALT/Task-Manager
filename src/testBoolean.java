
public class testBoolean {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		BST<Task> t = new BST<Task>();
		t.insert(11, new Task());
		System.out.println(t.empty());
		System.out.println(t.remove_key(11));
		System.out.println(t.empty());
	}

}
