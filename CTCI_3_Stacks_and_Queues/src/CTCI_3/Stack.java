package CTCI_3;

public class Stack {

	private StackNode top;
	private int size;
	
	public Stack(StackNode top) {
		this.top = top;
		this.size = 1;
	}
	
	public StackNode pop() {
		StackNode ret = this.top;
		this.top = this.top.next;
		if (ret != null) {
			this.size -= 1;
		}
		return ret;
	}
	
	public  void push(StackNode node) {
		node.next = this.top;
		this.top = node;
		this.size += 1;
	}
	
	public int size() {
		return this.size;
	}

	public String toString() {
		StackNode cur = this.top;
		StringBuilder stackString = new StringBuilder();

		if (this.size > 0) {
			stackString.append("[");
			while (cur != null) {
				stackString.append(cur.data + ",");
				cur = cur.next;
			}
			stackString.replace(stackString.lastIndexOf(","), stackString.lastIndexOf(",") + 1, "]");
		
			return stackString.toString();
		} else {
			return "empty";
		}
	}
	
}
