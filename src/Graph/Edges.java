package Graph;

public class Edges<W,V extends Comparable<V>,K> implements DirectedEdge<W,V,K> {
	
	private W weight;
	private Node<V,K> nodeOne;
	private Node<V,K> nodeTwo;
	
	public Edges(Node<V,K> nodeOne,Node<V,K> nodeTwo,W weight) {
		this.weight =  weight;
		this.nodeOne = nodeOne;
		this.nodeTwo = nodeTwo;
	
	}
	
	public W getWeight() {
		return weight;
	}
// ------- Indirect Edge--------------
	public void setWeight(W weight) {
		this.weight = weight;
	}

	public Node<V,K> getNodeOne() {
		return nodeOne;
	}

	public void setNodeOne(Node<V,K> nodeOne) {
		this.nodeOne = nodeOne;
	}

	public Node<V,K> getNodeTwo() {
		return nodeTwo;
	}

	public void setNodeTwo(Node<V,K> nodeTwo) {
		this.nodeTwo = nodeTwo;
	}

	@Override
	public Node<V,K> getSourceNode() {
		
		return nodeOne;
	}

	@Override
	public Node<V,K> getTargetNode() {
		// TODO Auto-generated method stub
		return nodeTwo;
	}

	@Override
	public Node<V, K> setSourceNode() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Node<V, K> setTargetNode() {
		// TODO Auto-generated method stub
		return null;
	}
	
	@Override
	public void switchDirection() {
		
	}
}
