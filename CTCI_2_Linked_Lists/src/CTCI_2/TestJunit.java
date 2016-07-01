package CTCI_2;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class TestJunit {

	@Before
	public void setUp() throws Exception {
		Node node1 = new Node(1);
		Node node2 = new Node(2);
		Node node3 = new Node(4);
		Node node4 = new Node(5);
		Node node6 = new Node(7);
		Node node8 = new Node(8);
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void test() {
		fail("Not yet implemented");
	}

}
