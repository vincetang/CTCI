package CTCI_2;

public class CTCI_2 {

	// 2.1
	public void removeDuplicates(Node head) {
		Node curNode = head;
		
		while (curNode != null) {
			Node runner = curNode;
			
			while (runner.next != null) {
				if (runner.next.data == curNode.data)
					runner.next = runner.next.next;
				runner = runner.next;
			}
			curNode = curNode.next;
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Node node1 = new Node(1);
		Node node2 = new Node(2);
		Node node3 = new Node(3);
                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                 
		node1.append(node2);
		node1.append(node3);

	}

}
