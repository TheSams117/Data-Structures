package Graph;

import java.util.ArrayList;
import java.util.HashMap;

public class Node<W,V extends Comparable<V>,K> {
	private ArrayList<Edges<W,V,K>> edges;
	private V value;
	private K key;

	public Node() {
		
	}

}
