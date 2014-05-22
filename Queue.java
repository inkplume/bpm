public class Queue<Item> {
	private Node head;
	private Node tail;
	private int N;
	private class Node {
		Item item;
		Node next;
	}

	public void enqueue(Item item) {
		Node node = new Node();
		node.item = item;
		node.next = null;
		if (isEmpty()) head = node;
		else tail.next = node;
		tail = node;
		N++;
	}
	public Item dequeue() {
		Item item = head.item;
		head = head.next;
		if (isEmpty()) tail = null;
		N--;
		return item;
	}
	public boolean isEmpty() {return head == null;}
	public int size() {return N;}

	public static void main(String[] args) {
		Queue<String> q = new Queue<String>();

		while (!StdIn.isEmpty()) {
			String item = StdIn.readString();
			if (!item.equals("-"))
				q.enqueue(item);
			else if (!q.isEmpty())
				StdOut.print(q.dequeue() + " ");
		}

		StdOut.println("(" + q.size() + " left on queue)");
	}
}