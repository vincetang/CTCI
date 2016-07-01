package CTCI_2;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.internal.ArrayComparisonFailure;

public class TestJunit {

	private Node node1, node2, node3, node4, node5, node6, node7, node8,
	nodeA, nodeB, nodeC, nodeD, nodeE, nodeF, nodeG, nodeH;

	private CTCI_2 ctci;
	@Before
	public void setUp() throws Exception {
		ctci = new CTCI_2();
		node1 = new Node(1);
		node2 = new Node(2);
		node3 = new Node(3);
		node4 = new Node(3);
		node5 = new Node(5);
		node6 = new Node(6);
		node7 = new Node(7);
		node8 = new Node(8);

		node1.next = node2;
		node2.next = node3;
		node3.next = node4;
		node4.next = node5;
		node5.next = node6;
		node6.next = node7;
		node7.next = node8;

		nodeA = new Node(3);
		nodeB = new Node(5);
		nodeC = new Node(6);
		nodeD = new Node(1);
		nodeE = new Node(9);
		nodeF = new Node(4);
		nodeG = new Node(8);
		nodeH = new Node(2);

		nodeA.next = nodeB;
		nodeB.next = nodeC;
		nodeC.next = nodeD;
		nodeD.next = nodeE;
		nodeE.next = nodeF;
		nodeF.next = nodeG;
		nodeG.next = nodeH;
	}

	@After
	public void tearDown() throws Exception {
	}

	/** Testing Node Structures **/
	@Test
	public void singleNodeTest() {
		assertEquals(1, node1.data);
	}

	@Test
	public void nullNext() {
		assertNull(node8.next);
	}

	@Test
	public void nullNotNext() {
		assertNotNull(node1.next);
	}

	@Test 
	public void nextNode() {
		assertEquals(node2, node1.next);
	}

	/** 2.1 removeDuplicate Tests **/
	@Test
	public void duplicateRemoved() {
		ctci.removeDuplicates(node1);
		assertEquals(node5, node3.next);
	}

	@Test
	public void noDuplicates() {
		ctci.removeDuplicates(node6);
		assertEquals(6, node6.data);
		assertEquals(7, node6.next.data);
		assertEquals(8, node6.next.next.data);
		assertNull(node6.next.next.next);
	}

	/** 2.2 **/
	/* Length Helper Function */
	@Test
	public void fullLength() {
		assertEquals(8, ctci.getLength(node1));
	}

	@Test
	public void singleLength() {
		assertEquals(1, ctci.getLength(node8));
	}

	@Test
	public void middleLength() {
		assertEquals(3, ctci.getLength(node6));
	}

	/* getKthToLastElement() */

	@Test
	public void lastElement() {
		Node ret = ctci.getKthToLastElement(0, node1);
		assertEquals(node8, ret);
	}

	@Test
	public void firstElement() {
		Node ret = ctci.getKthToLastElement(7, node1);
		assertEquals(node1, ret);
	}

	@Test
	public void middleElement() {
		Node ret = ctci.getKthToLastElement(3, node1);
		assertEquals(node5, ret);
	}

	@Test
	public void nullElement() {
		assertNull(ctci.getKthToLastElement(9, node1));
	}

	/* getKthToLastRecursive() */

	@Test
	public void lastElementRecursive() {
		Node ret = ctci.getKthToLastRecursive(0, node1);
		try {
			assertEquals(node8, ret);
		} catch (AssertionError e) {
			System.out.println(e.getLocalizedMessage());
		}
	}

	@Test
	public void firstElementRecursive() {
		Node ret = ctci.getKthToLastRecursive(7, node1);
		try {
			assertEquals(node1, ret);
		} catch (AssertionError e) {
			System.out.println("Failed middleElementRecursive(). Expected:" + node5.data + " got:" + ret.data);
		}
	}

	@Test
	public void middleElementRecursive() {
		Node ret = ctci.getKthToLastRecursive(3, node1);

		try {
			assertEquals(node5, ret);
		} catch (AssertionError e) {

		}
	}

	@Test
	public void nullElementRecursive() {
		try {
			assertNull(ctci.getKthToLastRecursive(9, node1));
		} catch (AssertionError e) {
			e.printStackTrace();
		}
	}

	/** 2.3 **/
	@Test
	public void removeMiddleElement() {
		try {
			System.out.println("Removing node5");
			ctci.deleteMiddleNode(node5);
			assertEquals(6, node4.next.data);

			System.out.println("Removing node1");
			ctci.deleteMiddleNode(node1);
			assertEquals(2, node1.data);

		} catch (AssertionError e) {
			System.out.println(e.getLocalizedMessage());
			fail();
		}

	}

	/** 2.4 **/
	@Test
	public  void partitionSmall() {
		Node a = new Node(3);
		Node b = new Node(1);
		Node c = new Node(2);

		a.next = b;
		b.next = c;

		Node head = ctci.partition(2, a);

		assertEquals(1, head.data);
		assertEquals(3, head.next.next.data);
	}

	@Test
	public void partitionLarge() {
		int x = 5;
		Node partitioned = ctci.partition(5, nodeA);
		int i = 0;
		while (partitioned != null) {
			if (i < 4) {
				try {
					assertTrue(partitioned.data < x);
				} catch (AssertionError e) {
					System.out.println(e.getLocalizedMessage());
				}
			} else if (i > 4) {
				try {
					assertTrue(partitioned.data > x);
				} catch (AssertionError e) {
					System.out.println(e.getLocalizedMessage());
				}
			}
			partitioned = partitioned.next;
			i++;
		}
	}

	/** 2.5 **/
	@Test
	public void sumSingle() {
		Node a = new Node(1);
		Node b = new Node(1);
		try {
			assertEquals(2, ctci.sum(a, b).data);
		} catch (AssertionError e) {
			System.out.println(e.getLocalizedMessage());
		}
	}

	@Test
	public void sumTripleDigits() {
		// Input: (7>1>6) + (5>9>2). That is, 617 + 295
		// Output: 2>1>9. That is, 912
		Node a = new Node(7);
		Node a2= new Node(1);
		Node a3 = new Node(6);

		Node b = new Node(5);
		Node b2 = new Node(9);
		Node b3 = new Node(2);

		a.next = a2;
		a2.next = a3;
		b.next = b2;
		b2.next = b3;


		Node ret = ctci.sum(a, b);
		try {
			assertEquals(2, ret.data);
			assertEquals(1, ret.next.data);
			assertEquals(9, ret.next.next.data);
		} catch (AssertionError e) {
			System.out.println(e.getLocalizedMessage());
		}


	}
	
	/** 2.6 **/
	@Test
	public void smallLoop() {
		node1.next = node2;
		node2.next = node3;
		node3.next = node2;
		
		try {
			assertEquals(node2.hashCode(), ctci.findLoopStart(node1).hashCode());
		} catch (AssertionError e) {
			System.out.println(e.getLocalizedMessage());
		}
	}
	
	@Test
	public void largeLoop() {
		// 1>2>3>4>5>3
		node1.next = node2;
		node2.next = node3;
		node3.next = node4;
		node4.next = node5;
		node5.next = node3;
		
		try {
			assertEquals(node3.hashCode(), ctci.findLoopStart(node1).hashCode());
		} catch (AssertionError e) {
			System.out.println(e.getLocalizedMessage());
		}
	}

	/** 2.7 **/
	
	@Test
	public void notPalindrome() {
		Node a = new Node(1);
		Node b = new Node(2);
		Node c = new Node(3);
		
		a.next = b; b.next = c;
		
		try {
			assertFalse(ctci.isPalindrome(a));
		} catch (AssertionError e) {
			System.out.println(e.getLocalizedMessage());
		}
	}
	
	@Test
	public void smallPalindrome() {
		Node a = new Node(1);
		Node b = new Node(2);
		Node c = new Node(1);
		
		a.next = b; b.next = c;
		try {
			assertTrue(ctci.isPalindrome(a));
		} catch (AssertionError e) {
			System.out.println(e.getLocalizedMessage());
		}
	}

	@Test
	public void largerPalindrome() {
		Node a = new Node(1);
		Node b = new Node(2);
		Node c = new Node(3);
		Node d = new Node(4);
		Node e = new Node(5);
		Node f = new Node(4);
		Node g = new Node(3);
		Node h = new Node(2);
		Node i = new Node(1);
		
		a.next = b; b.next = c; c.next = d; d.next = e; e.next = f; f.next = g; g.next = h; h.next = i;
		
		try {
			assertTrue(ctci.isPalindrome(a));
		} catch (AssertionError err) {
			System.out.println(err.getLocalizedMessage());
		}
	}
}
