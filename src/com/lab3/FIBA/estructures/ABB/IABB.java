package com.lab3.FIBA.estructures.ABB;

/**
 * This interface is for decoupling of the ABB Class
 * @author KorKux
 *	
 * @param <K>
 * @param <V>
 */
@SuppressWarnings("rawtypes")
public interface IABB <K extends Comparable, V> {

	/**
	 * Add a item in the tree
	 * @param key
	 * @param value
	 */
	public void add(K key, V value);
	
	/**
	 * Remove a item in the tree
	 * @param key
	 * @return
	 */
	public ABBNode<K,V> remove(K key);
}
