package collections;

public class Node<P> {
	private P element;
	private Node<P> nextNode;
	public Node(P newObject) {
		element = newObject;
		nextNode = null;

	}

	public P getElement() {
		return element;
	}

	public Node<P> getNextNode() {
		return nextNode;
	}

	public void setElement(P currentNode) {
		this.element = currentNode;
	}

	public void setNextNode(Node<P> nextObject) {
		this.nextNode = nextObject;
	}

}
