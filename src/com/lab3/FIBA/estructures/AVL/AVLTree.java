package com.lab3.FIBA.estructures.AVL;

import com.lab3.FIBA.estructures.ABB.ABB;
import com.lab3.FIBA.estructures.ABB.ABBNode;

/**
 * @author KorKux
 *
 * @param <K>
 * @param <V>
 */
@SuppressWarnings("rawtypes")
public class AVLTree<K extends Comparable,V> extends ABB<K,V> {
	
	/* (non-Javadoc)
	 * @see estructures.ABB.ABB#add(java.lang.Comparable, java.lang.Object)
	 */
	@SuppressWarnings("unchecked")
	@Override
	public void add(K key, V value) {
		if(key!=null && value!=null) {
			AVLNode<K,V> z=new AVLNode<K,V>(key,value);
			add(z);
			insertFixeUp(z);
		}
	}
	
	/**
	 * @param z
	 */
	@SuppressWarnings({ "unchecked"})
	private void insertFixeUp(AVLNode<K, V> z) {
		AVLNode<K,V> N = z;
		AVLNode<K,V> P = (AVLNode<K, V>) z.getParent();
		if(P!=null) {
			do {
		
				AVLNode<K,V> left = (AVLNode<K, V>) P.getLeft();
				
				 if (left != null && N.compareTo(left)==0) {  
					 
					 if (P.balanceFactor() == 1) { 
						
						 if (N.balanceFactor() == -1) { 
							 leftRotate(N); 
							 N.updateFactorBalance();
							 ((AVLNode)N.getParent()).updateFactorBalance();
						 }
			
						 rightRotate(P);
						 
						 P.updateFactorBalance();
						 
						 ((AVLNode)P.getParent()).updateFactorBalance();
						 break; 
					 }
					 if (P.balanceFactor() == -1) {
						 P.setBalanceFactor(0); 
						 break; 
					 }
					 
					 P.setBalanceFactor(1); 
				 } 
				 else { 
					 if (P.balanceFactor() == -1) { 
						 
						 if (N.balanceFactor() == 1) { 
							 rightRotate(N); 
							 N.updateFactorBalance();
							 ((AVLNode)N.getParent()).updateFactorBalance();
						 }
						
						 leftRotate(P);
						 P.updateFactorBalance();
						 ((AVLNode)P.getParent()).updateFactorBalance();
						 break; 
					 }
					 if (P.balanceFactor() == 1) {
						 P.setBalanceFactor(0); 
						 break; 
					 }
					 P.setBalanceFactor(-1); 
				 }
				 N = P;
				 P = (AVLNode<K, V>) N.getParent();
			}while(P!=null);
		}
	}
	
	/* (non-Javadoc)
	 * @see estructures.ABB.ABB#remove(java.lang.Comparable)
	 */
	@SuppressWarnings("unchecked")
	@Override
	public ABBNode<K, V> remove(K key) {
		if(key==null) {
			return null;
		}
		ABBNode<K,V>z = search(key);
		ABBNode[] params = null;
		
		if(z!=null) {
			params = remove(z);
		}else {
			return null;
		}
		deleteFixeUp((AVLNode)params[0]);
		return params[1];
	}
	
	
	/*public static void main(String[] args) {
		
		
		AVLTree<Integer, Integer> avl = new AVLTree<>();
		int[] data = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20 };
		for (int i = 0; i < data.length; i++) {
			avl.add(new AVLNode<Integer, Integer>(data[i], data[i]));			
		}
		avl.inOrden((AVLNode) avl.getRoot());
		System.out.println("__");
		
		avl.remove(1);
		avl.inOrden((AVLNode) avl.getRoot());
		System.out.println("__");
		avl.remove(3);
		avl.inOrden((AVLNode) avl.getRoot());
		System.out.println("__");
		avl.remove(5);
		avl.inOrden((AVLNode) avl.getRoot());
		System.out.println("__");
		avl.inOrden((AVLNode) avl.getRoot());
		avl.remove(2);
		avl.inOrden((AVLNode) avl.getRoot());
		System.out.println("__");
		avl.remove(6);
		avl.inOrden((AVLNode) avl.getRoot());
		System.out.println("__");
		avl.remove(4);
		avl.inOrden((AVLNode) avl.getRoot());
		System.out.println("__");
		
	}*/
	
	/**
	 * @param x
	 */
	public void inOrden(AVLNode x) {
		if (x != nil) {
			inOrden( (AVLNode) x.getLeft());
			String papa = null;
			if(x.getParent() != null) {
				papa = x.getParent().getValue()+"";
			}
			System.out.println(x.getValue() + " papa: "+ papa);			
			inOrden((AVLNode) x.getRigth());
		}
	}
	
	/**
	 * @param N
	 */
	@SuppressWarnings("unchecked")
	private void deleteFixeUp(AVLNode N) {
		AVLNode G = null;
		for(AVLNode X = (AVLNode) N.getParent(); X != null; X = G) { 
		    G = (AVLNode) X.getParent(); 
		    if (N == X.getLeft()) {
		        if (X.balanceFactor() < 0) { 
		        	AVLNode Z = (AVLNode) X.getRigth();
		            int b = Z.balanceFactor();
		            if (b > 0) {
		            	rightRotate(Z);
		            	Z.updateFactorBalance();
		            	leftRotate(X);
		            	X.updateFactorBalance();
		            }else {
		            	System.out.println("HERE");
		            	leftRotate(X);
		            	X.updateFactorBalance();
		            }
		        } else {
		            if (X.balanceFactor() == 0) {
		                X.setBalanceFactor(-1);
		                break; 
		            }
		            N = X;
		            N.setBalanceFactor(0);
		            continue;
		        }
		    } else { 
		        if (X.balanceFactor() > 0) {
		            AVLNode Z = (AVLNode) X.getLeft();
		            int b = Z.balanceFactor();
		            if (b < 0) {
		            	leftRotate(Z);
		            	Z.updateFactorBalance();
		            	rightRotate(X);
		            	X.updateFactorBalance();
		            }else {
		            	rightRotate(X);
		            	X.updateFactorBalance();
		            }
		        } else {
		            if (X.balanceFactor() == 0) {
		            	X.setBalanceFactor(1);
		                break; 
		            }
		            N = X;
		            N.setBalanceFactor(0);
		            continue;
		        }
		    }
		}
	}
}
