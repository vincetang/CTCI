package CTCI_2;

public class CTCI_2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Node node1 = new Node(1);
		Node node2 = new Node(2);
		Node node3 = new Node(3);
		
		node1.append(node2);
		node1.append(node3);
		
//		node1.delete(node1, 2);

		Node n2 = node1.testDelete(node1);
		String s = "node1: " + node1.toString();
		
		System.out.println(s);
		
		String s2 = "n2: " + n2.toString();
		System.out.println(s2);
	}

}
