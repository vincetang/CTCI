package CTCI_2;

import java.util.Map;

public class CTCI_2 {

	/** 2.1 
	 *	Write code to remove duplicates from an unsorted linked list.
	 *	FOLLOW UP: How would you solve this problem if a temporary buffer is not allowed?
	 */
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

	/** 2.2
	 *	Implement an algorithm to find the kth to last element of a singly linked list. 
	 */
	public int getLength(Node head) {
		int length = 1;
		Node curNode = head;
		while (curNode.next != null) {
			length++;
			curNode = curNode.next;
		}
		return length;
	}

	public Node getKthToLastElement(int k, Node head) {
		int length = getLength(head);

		if (k > (length - 1)) {
			return null;
		}

		Node curNode = head;
		int position = 0;
		while (position < (length - (k+1))) {
			curNode = curNode.next;
			position++;
		}
		return curNode;
	}

	/* recursive solution */
	public Node getKthToLastRecursive(int k, Node head) {
		if (k > this.getLength(head) - 1) {
			return null;
		}
		MapEntry<Node, Integer> ent = getKthHelper(k, head);
		return (Node) ent.getKey();
	}

	public MapEntry<Node, Integer> getKthHelper(int k, Node head) {
		Node curNode = head;

		if (curNode.next == null) {
			return new MapEntry<Node, Integer>(curNode, 0);
		} else {
			MapEntry<Node, Integer> ent = getKthHelper(k, curNode.next);

			if (ent.getValue().intValue() == k)
				return ent;
			else
				return new MapEntry<Node, Integer>(curNode, ent.getValue()+1);
		}
	}

	/** 2.3
	 * Implement an algorithm to delete a node in the middle of a singly linked list,
	 * given only access to that node
	 * EXAMPLE
	 * Input: the node c from the linked list a > b > c > d > e
	 * Result: Nothing is returned, but the new linked list looks like a > b > d > e
	 */
	public void deleteMiddleNode(Node node) {

		Node curNode = node;

		while (curNode.next.next != null) {
			curNode.data = curNode.next.data;
			curNode.next = curNode.next.next;
			curNode = curNode.next;
		}

		curNode.data = curNode.next.data;
		curNode.next = null;

	}

	/** 2.4
	 * Write code to partition a linked list around a value x, such that all nodes less
	 * than x come before all nodes greater than or equal to x
	 */
	public Node partition(int x, Node head) {
		return null;
	}

	/** 2.5
	 * You have two numbers represented by a linked list, where each node contains a
	 * single digit. The digits are stored in reverse order, such that the 1's digit
	 * is at the head of the list. Write a function that adds the two numbers and 
	 * returns the sum as a linked list
	 * EXAMPLE
	 * Input: (7>1>6) + (5>9>2). That is, 617 + 295
	 * Output: 2>1>9. That is, 912
	 * FOLLOW UP
	 * Suppose the digits are stored in forward order. Repeat the above problem
	 * EXAMPLE
	 * Input: (6>1>7) + (2>9>5). That is, 617 + 295.
	 * Output: 9>1>2. That is, 912.
	 */
	public Node sum(Node a, Node b) {
		return null;
	}

	/** 2.6
	 * Given a circular linked list, implement an algorithm which returns the node
	 * of the beginning of the loop
	 * DEFINITION
	 * Circular linked list: A (corrupt) linked list in which a node's next pointer 
	 * points to an earlier node, so as to make a loop in the linked list
	 * EXAMPLE
	 * Input: A>B>C>D>E>C[the same C as earlier]
	 * Output: C
	 */
	public Node findLoopStart(Node head) {
		return null;
	}

	/** 2.7
	 * Implement a function to check if a linked list is a palindrome.
	 */
	public boolean isPalindrome(Node head) {
		return false;
	}
	
	/** Main Function **/
	public static void main(String[] args) {

	}

}
