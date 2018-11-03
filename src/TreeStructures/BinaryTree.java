package TreeStructures;
/**
 * @author Sergio Andrés Lozada Sánchez
 *
 * @param <K> represent the key to add the value.
 * @param <V> represent the value to add.
 */
public class BinaryTree <K extends Comparable<K>,V extends Comparable<V>>{
	
	private Node<K,V> root;
	private int treeWeight;
	
	public BinaryTree() {
		root = null;
		treeWeight = 0;
	}
	
	public Node<K,V> getRoot() {
		return root;
	}

	public int getTreeWeight() {
		return treeWeight;
	}
	
	public void add(K key, V value) {
		Node<K,V> newNode = new Node<K,V>(key,value);
		
		if(root == null) {
			root = newNode;
		}else {
			add(newNode,root);
		}
		
		treeWeight+=1;
	}
	
	private void add(Node<K,V> newNode,Node<K,V> currentNode) {
		if(newNode.compareTo(currentNode) == 0) {
			
		}else if(newNode.compareTo(currentNode)>0) {
			if(currentNode.getRight() == null) {
				currentNode.setRight(newNode);
			}else {
				add(newNode,currentNode.getRight());
			}
		}else {
			if(currentNode.getLeft() == null) {
				currentNode.setLeft(newNode);
			}else {
				add(newNode,currentNode.getLeft());
			}
		}
	}
	
	public V search(K key) {
		Node<K,V> nodeToSearch =  new Node<K,V>(key, null);
	
		return search(nodeToSearch,root).getValue();
	}
	
	private Node<K,V> search(Node<K,V> nodeToSearch,Node<K,V> currentNode) {
		
		if(nodeToSearch.compareTo(currentNode) == 0) {
			
			return currentNode;
			
		}else if(nodeToSearch.compareTo(currentNode)>0) {
			
			return (currentNode.getRight() == null)? null:search(nodeToSearch,currentNode.getRight());
			
		}else {
			
			return (currentNode.getLeft() == null)? null:search(nodeToSearch,currentNode.getLeft());
			
		}
	}
	
	public int getWeight() {
		return root.getWeight();
	}
	
	 
	public static void main(String[] args) {
		BinaryTree<Integer,String> a = new BinaryTree<>();
		a.add(1, "3");
	}
}
