import java.util.Iterator;
public class Stack<Item> implements Iterable<Item> {
	private Node head;
	private int N;
	private class Node {
		Item item;
		Node next;
	}

	//public Stack() {}
	public void push(Item item) {
		Node node = new Node();
		node.item = item;
		node.next = head;
		head = node;
		N++;
	}
	public Item pop() {
		Item item = head.item;
		head = head.next;
		N--;
		return item;
	}
	public boolean isEmpty() {return N == 0;}
	public int size() {return N;}
	public Iterator<Item> iterator() {return new ListIterator();}
	private class ListIterator implements Iterator<Item> {
		private Node current = head;
		public boolean hasNext() {return current != null;}
		public void remove() {}
		public Item next() {
			Item item = current.item;
			current = current.next;
			return item;
		}
	}

	public static void main(String[] args) {
		Stack<String> s = new Stack<String>();

		while (!StdIn.isEmpty()) {
			String item = StdIn.readString();
			if (!item.equals("-"))
				s.push(item);
			else if (!s.isEmpty())
				StdOut.print(s.pop() + " ");
		}

		StdOut.println("(" + s.size() + " left on stack)");
	}
}