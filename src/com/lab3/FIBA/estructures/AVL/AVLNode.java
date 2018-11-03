package com.lab3.FIBA.estructures.AVL;

import com.lab3.FIBA.estructures.ABB.ABBNode;


/**
 * @author ASUS
 *
 * @param <K>
 * @param <V>
 */
@SuppressWarnings("rawtypes")
public class AVLNode<K,V> extends ABBNode {
	
	/**
	 * 
	 */
	private int balanceFactor;
	
	/**
	 * @param key
	 * @param value
	 */
	@SuppressWarnings("unchecked")
	public AVLNode(K key, V value){
		super((Comparable) key, value);
		
		balanceFactor=0;
	}
	
	
	/**
	 * @return
	 */
	public int balanceFactor() {
		if(getRigth() == null && getLeft() == null) {
			
		}
		return balanceFactor;
	}
	
	/**
	 * @param t
	 */
	public void setBalanceFactor(int t){
		balanceFactor=t;
	}
	
	/**
	 * 
	 */
	public void updateFactorBalance() {
		if(getRigth() == null && getLeft() == null) {
			balanceFactor = 0;
		}
		else if(getRigth() == null) {
			balanceFactor = getLeft().height;
		}
		else if(getLeft() == null) {
			balanceFactor = -getRigth().height;
		}
		else {
			balanceFactor = getLeft().height-getRigth().height;
		}
	}
	
	/**
	 * @param string
	 * @param nil
	 */
	public void recorrerSubArbol(String string, AVLNode nil) {
		System.out.println(string+"color: "+getValue()+" "+getKey());
		if( getLeft() != nil) {
			((AVLNode)getLeft()).recorrerSubArbol(string+"L",nil);
		}
		if( getRigth() != nil) {
			((AVLNode)getRigth()).recorrerSubArbol(string+"R",nil);

		}
	}
}
