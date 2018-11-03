package com.lab3.FIBA.estructures.ABB;


/**
 * @author KorKux
 *
 * @param <K>
 * @param <V>
 */
@SuppressWarnings("rawtypes")
public abstract class ABBNode <K extends Comparable, V> implements Comparable{

	
	/**
	 * 
	 */
	private K key;
	
	/**
	 * 
	 */
	private V value;
	
	/**
	 * 
	 */
	public int height;
	
	/**
	 * 
	 */
	private ABBNode<K,V> parent;
	
	/**
	 * 
	 */
	private ABBNode<K,V> rigth;
	
	/**
	 * 
	 */
	private ABBNode<K,V> left;
	
	/**
	 * 
	 */
	private ABBNode<K,V> clon;
	
	/**
	 * @param llave
	 * @param value
	 */
	public ABBNode (K key, V value) {
		this.key = key;
		this.value = value;
	}
	
	/**
	 * @return
	 */
	public K getKey() {
		return key;
	}

	/**
	 * @param key
	 */
	public void setKey(K key) {
		this.key = key;
	}

	/**
	 * @return
	 */
	public V getValue() {
		return value;
	}

	/**
	 * @param value
	 */
	public void setValue(V value) {
		this.value = value;
	}

	/**
	 * @return
	 */
	public ABBNode<K, V> getParent() {
		return parent;
	}

	/**
	 * @param parent
	 */
	public void setParent(ABBNode<K, V> parent) {
		this.parent = parent;
	}

	/**
	 * @return
	 */
	public ABBNode<K, V> getRigth() {
		return rigth;
	}

	/**
	 * @param rigth
	 */
	public void setRigth(ABBNode<K, V> rigth) {
		this.rigth = rigth;
	}

	/**
	 * @return
	 */
	public ABBNode<K, V> getLeft() {
		return left;
	}

	/**
	 * @param left
	 */
	public void setLeft(ABBNode<K, V> left) {
		this.left = left;
	}

	/**
	 * @return
	 */
	public ABBNode<K, V> getClon() {
		return clon;
	}

	/**
	 * @param clon
	 */
	public void setClon(ABBNode<K, V> clon) {
		this.clon = clon;
	}
	
	/**
	 * 
	 */
	public void updateHigth() {
		if(rigth == null && left == null) {
			height=-1;
		}
		else if (rigth == null) {
			height=left.height;
		}
		else if (left == null) {
			height = rigth.height;
		}
		else {
			height = Math.max(rigth.height, left.height);
		}
		height++;
	}
	
	@SuppressWarnings({ "unchecked"})
	public int compareTo(Object o) {
		return key.compareTo(((ABBNode)o).key);
	}
	
}