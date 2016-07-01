package CTCI_2;

public class Node {

	int data;
	Node next = null;
	
	public Node(int d) {
		this.data = d;
	}
	
	public void append(Node n) {
		Node curr = this;
		while (curr.next != null) {
			curr = curr.next;
		}
		curr.next = n;
	}
	
	public Node delete(Node head, int d) {
		Node n = head;
		if (n.data == d) {
			return n.next;
		}
		
		while (n.next != null) {
			if (n.next.data == d) {
				n.next = n.next.next;
			}
			n = n.next;
		}
		
		return head;
	}


	public String toString() {
		StringBuilder sb = new StringBuilder("[");
		Node cur = this;
		while (cur.next != null) {
			sb.append(cur.data + ", ");
			cur = cur.next;
		}
		sb.append(cur.data + "]\n");
		return sb.toString();
	}
}
