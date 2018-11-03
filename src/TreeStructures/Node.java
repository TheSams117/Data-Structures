package TreeStructures;



/**
 * 
 * @author Sergio Andrés Lozada Sánchez.
 *
 * @param <K>
 * @param <V>
 */
public class Node <K extends Comparable<K>,V extends Comparable<V>> implements Comparable<Node<K,V>>{
	private V value;
	private K key;
	private Node<K,V> left;
	private Node<K,V> right;
	
	public Node(K key,V value) {
		this.key = key;
		this.value = value;
		left = null;
		right = null;
	}

	public void setValue(V value) {
		this.value = value;
	}
	
	public V getValue() {
		return value;
	}
	
	public K getKey() {
		return key;
	}

	public void setKey(K key) {
		this.key = key;
	}

	public Node<K,V> getLeft() {
		return left;
	}

	public void setLeft(Node<K,V> left) {
		this.left = left;
	}

	public Node<K,V> getRight() {
		return right;
	}

	public void setRight(Node<K,V> right) {
		this.right = right;
	}
	
	public boolean isSheet() {
		return left == null && right == null;
	}
	
	public int getWeight() {
		int weightRight = (left == null)? 0:left.getWeight();
		int weightLeft = (right == null)? 0:right.getWeight();
		
		return 1 + weightRight + weightLeft;
	}
	
	public Node<K,V> getSmaller() {
		return (left == null)? this:left.getSmaller();
	}
	
	public Node<K,V> getBigger(){
		return (right == null)? this:right.getSmaller();
	}
	
	public int getHeight() {
		if(isSheet()) {
			return 1;
		}else{
			int heightRight = (left == null)? 0:left.getHeight();
			int heightLeft = (right == null)? 0:right.getHeight(); 
			return 1 + ((heightRight>=heightLeft)? heightRight:heightLeft);
		}
	}
	
	public String toString() {
		return value.toString();
		
	}
	
	public int compareTo(Node<K,V> node) {
		return key.compareTo(node.getKey());
	}
}
