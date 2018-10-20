package TreeStructures;

public class Node <T extends Comparable>{
	private T key;
	private Node left;
	private Node right;
	
	public Node(T key) {
		this.key=key;
		left = null;
		right = null;
	}

	public T getKey() {
		return key;
	}

	public void setKey(T key) {
		this.key = key;
	}

	public Node getLeft() {
		return left;
	}

	public void setLeft(Node left) {
		this.left = left;
	}

	public Node getRight() {
		return right;
	}

	public void setRight(Node right) {
		this.right = right;
	}
}
