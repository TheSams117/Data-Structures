package com.lab3.FIBA.estructures.RedBlack;


import com.lab3.FIBA.estructures.ABB.ABB;
import com.lab3.FIBA.estructures.ABB.ABBNode;

/**
 * @author KorKux
 *
 * @param <K>
 * @param <V>
 */
@SuppressWarnings("rawtypes")
public class RedBlackTree<K extends Comparable,V> extends ABB<K,V> {
	
	/**
	 * 
	 */
	@SuppressWarnings("unchecked")
	public RedBlackTree(){
		super();
		nil = new RBTNode<>(null, null);
		nil.setParent(nil);
		nil.setRigth(nil);
		nil.setLeft(nil);
		((RBTNode<K, V>) nil).setColor(Color.BLACK);
		root = nil;
	}
	
	/* (non-Javadoc)
	 * @see estructures.ABB.ABB#add(java.lang.Comparable, java.lang.Object)
	 */
	@SuppressWarnings("unchecked")
	@Override
	public void add(K key, V value) {
		if(key!=null && value!=null) {
			RBTNode<K,V> z = new RBTNode<K,V>(key,value);
			add(z);
			insertFixeUp(z);
		}
	}
	
	/**
	 * @param z
	 */
	@SuppressWarnings("unchecked")
	private void insertFixeUp(RBTNode<K, V> z) {
		
		while(((RBTNode<K, V>) z.getParent()).getColor()==Color.RED){
			
			if(z.getParent()==z.getParent().getParent().getLeft()){
				RBTNode<K,V> y =(RBTNode<K, V>) z.getParent().getParent().getRigth();
				
				if (y.getColor() == Color.RED){
					((RBTNode<K, V>) z.getParent()).setColor(Color.BLACK);
					y.setColor(Color.BLACK);
					((RBTNode<K, V>) z.getParent().getParent()).setColor(Color.RED);
					z=(RBTNode<K, V>) z.getParent().getParent();
				}
				else if (z == z.getParent().getRigth()){
					z=(RBTNode<K, V>) z.getParent();
					leftRotate(z);
					
				}
				else{
					((RBTNode<K, V>) z.getParent()).setColor(Color.BLACK);
					((RBTNode<K, V>) z.getParent().getParent()).setColor(Color.RED);
					rightRotate(z.getParent().getParent());
				}
			}
			else{
				RBTNode<K,V> y = (RBTNode<K, V>) z.getParent().getParent().getLeft();
				
				if (y.getColor() == Color.RED){
					((RBTNode<K, V>) z.getParent()).setColor(Color.BLACK);
					y.setColor(Color.BLACK);
					((RBTNode<K, V>) z.getParent().getParent()).setColor(Color.RED);
					z=(RBTNode<K, V>) z.getParent().getParent();
				}
				else if (z == z.getParent().getLeft()){
					z=(RBTNode<K, V>) z.getParent();
					rightRotate(z);
				}
				else{
					((RBTNode<K, V>) z.getParent()).setColor(Color.BLACK);
					((RBTNode<K, V>) z.getParent().getParent()).setColor(Color.RED);
					leftRotate(z.getParent().getParent());
				}
			}
		}
		((RBTNode<K, V>) root).setColor(Color.BLACK);
	}
	
	/**
	 * @param x
	 */
	@SuppressWarnings("unchecked")
	private void deleteFixeUp(RBTNode<K,V> x) {
		while(x != root && x.getColor() == Color.BLACK) {
			if(x == x.getParent().getLeft()) {
				RBTNode<K, V> w=(RBTNode<K, V>)x.getParent().getRigth();
				if (w.getColor() == Color.RED) {
					w.setColor(Color.BLACK);
					((RBTNode<K,V>)x.getParent()).setColor(Color.RED);
					leftRotate(x.getParent());
					w=((RBTNode<K,V>)x.getParent().getRigth());
				}
				if(((RBTNode<K,V>)w.getLeft()).getColor()==Color.BLACK &&
						((RBTNode<K,V>)w.getRigth()).getColor()==Color.BLACK) {
					w.setColor(Color.RED);
					x=(RBTNode<K,V>)x.getParent();
				}else{
					if(((RBTNode<K,V>)w.getRigth()).getColor()==Color.BLACK) {
						((RBTNode<K,V>)w.getLeft()).setColor(Color.BLACK);
						w.setColor(Color.RED);
						rightRotate(w);
						w=(RBTNode<K, V>) x.getParent().getRigth();
					}
					w.setColor(((RBTNode<K, V>)x.getParent()).getColor());
					((RBTNode<K, V>)x.getParent()).setColor(Color.BLACK);
					((RBTNode<K, V>)w.getRigth()).setColor(Color.BLACK);
					leftRotate(x.getParent());
					x=(RBTNode<K, V>) root;
				}
			}else {
				RBTNode<K, V> w=(RBTNode<K, V>)x.getParent().getLeft();
				if(w.getColor()==Color.RED) {
					w.setColor(Color.BLACK);
					((RBTNode<K,V>)x.getParent()).setColor(Color.RED);
					rightRotate(x.getParent());
					w=((RBTNode<K,V>)x.getParent().getLeft());
				}
				if(((RBTNode<K,V>)w.getRigth()).getColor()==Color.BLACK &&
						((RBTNode<K,V>)w.getLeft()).getColor()==Color.BLACK) {
					w.setColor(Color.RED);
					x=(RBTNode<K,V>)x.getParent();
				}else {
					if(((RBTNode<K,V>)w.getLeft()).getColor()==Color.BLACK) {
						((RBTNode<K,V>)w.getRigth()).setColor(Color.BLACK);
						w.setColor(Color.RED);
						leftRotate(w);
						w=(RBTNode<K, V>) x.getParent().getLeft();
					}
					w.setColor(((RBTNode<K, V>)x.getParent()).getColor());
					((RBTNode<K, V>)x.getParent()).setColor(Color.BLACK);
					((RBTNode<K, V>)w.getLeft()).setColor(Color.BLACK);
					rightRotate(x.getParent());
					x=(RBTNode<K, V>) root;
				}
			}
		}
		x.setColor(Color.BLACK);
	}
	
	/**
	 * @param key
	 * @return
	 */
	@SuppressWarnings({"unchecked" })
	@Override
	public ABBNode<K, V> remove(K key) {
		ABBNode<K,V> z = search(key);
		ABBNode[] params = null;
		if(z != null) {
			params = remove(z);
		}
		else {
			return null;
		}
		if (((RBTNode)params[1]).getColor() == Color.BLACK) {
			deleteFixeUp((RBTNode)params[0]);
		}
		return params[1];
	}
	
	public static void main(String[] args) {
		RedBlackTree<Integer, Integer> redBlackTree = new RedBlackTree<>();
		redBlackTree.add(1,1);
		redBlackTree.add(1,1);
		redBlackTree.add(1,1);
		redBlackTree.add(1,1);

		/*
		redBlackTree.add(2, 2);
		redBlackTree.add(14, 14);
		redBlackTree.add(1, 1);
		redBlackTree.add(7, 7);
		redBlackTree.add(5, 5);
		redBlackTree.add(8, 8);
		redBlackTree.add(4, 4);*/
		
		redBlackTree.remove(4);
		redBlackTree.remove(2);

		redBlackTree.inOrden((RBTNode) redBlackTree.getRoot());
	}
	
	public void inOrden(RBTNode x) {
		if (x != nil) {
			inOrden( (RBTNode) x.getLeft());
			String papa = null;
			if(x.getParent() != null) {
				papa = x.getParent().getValue()+"";
			}
			System.out.println(x.getValue() + " papa: "+ papa +" color: " + x.getColor());			
			inOrden((RBTNode) x.getRigth());
		}
	}
}