package com.lab3.FIBA.estructures.RedBlack;

import com.lab3.FIBA.estructures.ABB.ABBNode;

/**
 * @author KorKux
 *
 */
enum Color{
	BLACK,RED
}

/**
 * @author ASUS
 *
 * @param <K>
 * @param <V>
 */
@SuppressWarnings("rawtypes")
public class RBTNode<K extends Comparable,V> extends ABBNode {
	
	private Color color;
	
	/**
	 * @param key
	 * @param value
	 */
	@SuppressWarnings("unchecked")
	public RBTNode(K key, V value){
		super(key,value);
		color=Color.RED;
	}
	
	/**
	 * @param string
	 * @param nil
	 */
	@SuppressWarnings("unchecked")
	public void recorrerSubArbol(String string, ABBNode<K,V> nil) {
		
		System.out.println(string+"color: "+color+" "+getValue()+" "+getKey());
		
		if(getLeft() != nil) {
			((RBTNode)getLeft()).recorrerSubArbol(string+"L",nil);
		}

		if(getRigth() != nil) {
			((RBTNode)getRigth()).recorrerSubArbol(string+"R",nil);
		}	
	}
	
	public Color getColor() {
		return color;
	}
	
	public void setColor(Color color) {
		this.color = color;
	}
}