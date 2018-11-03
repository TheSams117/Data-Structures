package Graph;

public interface DirectedEdge<W,V extends Comparable<V>,K> {
	Node<V,K> getSourceNode();
	Node<V,K> getTargetNode();
	Node<V,K> setSourceNode();
	Node<V,K> setTargetNode();
	W getWeight();
	void switchDirection();
	
	
	
}
