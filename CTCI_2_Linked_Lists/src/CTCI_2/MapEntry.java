package CTCI_2;

import java.util.Map;

public class MapEntry<Node, Integer> implements Map.Entry<Node, Integer> {

	private final Node key;
	private Integer val;
	public MapEntry(Node node, Integer val) {
		this.key = node;
		this.val = val;
	}

	@Override
	public Node getKey() {
		return this.key;
	}

	@Override
	public Integer getValue() {
		return this.val;
	}

	@Override
	public Integer setValue(Integer value) {
		this.val = value;
		return this.val;
	}

}
