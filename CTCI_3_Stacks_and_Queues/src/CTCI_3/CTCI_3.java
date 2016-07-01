package CTCI_3;

public class CTCI_3 {
	public static void main(String[] args) {
		Stack stack = new Stack(new StackNode(3));
		System.out.println("pop: " + stack.pop().data);
		stack.push(new StackNode(4));
		stack.push(new StackNode(5));
		System.out.println(stack.toString());
	}
}
