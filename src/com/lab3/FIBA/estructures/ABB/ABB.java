package com.lab3.FIBA.estructures.ABB;

/**
 * @author KorKux
 *
 * @param <K> 
 * @param <V>
 */
@SuppressWarnings("rawtypes")
public abstract class ABB<K extends Comparable, V> implements IABB<K, V> {

	/**
	 * 
	 */
	protected ABBNode<K, V> root;
	
	/**
	 * 
	 */
	protected ABBNode<K, V> nil;

	/**
	 * 
	 */
	public ABB() {
		nil = null;
		root = nil;
	}

	/**
	 * @param z
	 */
	public void add(ABBNode<K, V> z) {
		ABBNode<K, V> y = null;
		
		if (nil != null)
			y = (ABBNode<K, V>) nil;
		
		ABBNode<K, V> x = root;
		
		while (x != nil) {
			y = x;
			
			if (x.compareTo(z) > 0) {   
				
				ABBNode<K, V> parent = x;
				x = x.getLeft();
				
				if (x != nil && parent.height == x.height + 1) {
					parent.height++;
				}
				
				if (parent.getRigth() == nil && x == nil) {
					parent.height++;
				}
				
			} 
			else if (x.compareTo(z) < 0) {
				ABBNode<K, V> parent = x;
				x = x.getRigth();
				
				if (x != nil && parent.height == x.height + 1) {
					parent.height++;
				}
				
				if (parent.getLeft() == nil && x == nil) {
					parent.height++;
				}
			} 
			else {
				ABBNode<K, V> w = x.getClon();
				
				while (w != null) {
					x = w;
					w = w.getClon();
				}
				
				x.setClon(z);
				ABBNode<K, V> p = null;
				
				if (nil != null) {
					p = (ABBNode<K, V>) nil;
				}
					
				z.setRigth(p);
				z.setLeft(p);
				z.setParent(p);
				return;
			}
		}
		z.setParent(y);
		if (y == nil) {
			root = z;
		} 
		else if (y.compareTo(z) > 0) {
			y.setLeft(z);
		} 
		else {
			y.setRigth(z);
		}
		ABBNode<K, V> p = null;
		if (nil != null) {
			p = (ABBNode<K, V>) nil;
		}
			
		z.setRigth(p);
		z.setLeft(p);
	}

	/**
	 * @param key 
	 * @return
	 */
	@SuppressWarnings({ "unchecked", "unused" })
	public ABBNode<K, V> search(K key) {
		if(key == null) {
			return null;
		}
		ABBNode<K, V> y = null;
		
		if (nil != null) {
			y = (ABBNode<K, V>) nil;
		}
			
		ABBNode<K, V> x = root;
		
		while (x != nil) {
			y = x;
			if (x.getKey().compareTo(key) > 0) {
				x = x.getLeft();
			} 
			else if (x.getKey().compareTo(key) < 0) {
				x = x.getRigth();
			} 
			else {
				return x;
			}
		}
		return null;
	}

	/**
	 * @param x
	 */
	public void leftRotate(ABBNode<K, V> x) {
		ABBNode<K, V> y = x.getRigth();
		x.setRigth(y.getLeft());
		if (y.getLeft() != nil) {
			y.getLeft().setParent(x);
		}
		y.setParent(x.getParent());
		if (x.getParent() == nil) {
			root = y;
		} 
		else if (x == x.getParent().getLeft()) {
			x.getParent().setLeft(y);
		} else {
			x.getParent().setRigth(y);
		}
		y.setLeft(x);
		x.setParent(y);
		x.updateHigth();
		y.updateHigth();
	}

	public void rightRotate(ABBNode<K, V> x) {
		ABBNode<K, V> y = x.getLeft();
		x.setLeft(y.getRigth());
		if (y.getRigth() != nil) {
			y.getRigth().setParent(x);
		}
		y.setParent(x.getParent());
		if (x.getParent() == nil) {
			root = y;
		} else if (x == x.getParent().getLeft()) {
			x.getParent().setLeft(y);
		} else {
			x.getParent().setRigth(y);
		}
		y.setRigth(x);
		x.setParent(y);
		x.updateHigth();
		y.updateHigth();
	}

	/**
	 * @return
	 */
	public boolean isEmpty() {
		if (root == null) {
			return true;
		}
		return false;
	}

	/**
	 * @return
	 */
	public ABBNode<K, V> getRoot() {
		return root;
	}

	public void setRoot(ABBNode<K, V> root) {
		this.root = root;
	}
	
	/* (non-Javadoc)
	 * @see estructures.ABB.IABB#add(java.lang.Comparable, java.lang.Object)
	 */
	public abstract void add(K key, V value);
	
	/* (non-Javadoc)
	 * @see estructures.ABB.IABB#remove(java.lang.Comparable)
	 */
	public abstract ABBNode<K,V> remove(K key);

	/**
	 * @param x
	 * @return
	 */
	public ABBNode<K, V> successor(ABBNode<K,V> x) {
		if(x.getRigth() != nil) {
			return min(x.getRigth());
		}
		
		ABBNode<K,V> y=x.getParent();
		
		while(y != nil && x == y.getRigth()) {
			x = y;
			y = y.getParent();
		}
		return y;
	}

	/**
	 * @param d
	 * @return
	 */
	public ABBNode<K, V> min(ABBNode<K, V> d) {
		ABBNode<K,V> temp =d;
		while(temp.getLeft() != nil) {
			temp = temp.getLeft();
		}
		return temp;
	}
	
	/**
	 * @param z
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public ABBNode[] remove(ABBNode<K, V> z) {
		ABBNode<K,V> y = nil;
		if (z.getRigth() == nil || z.getLeft() == nil) {
			y = z;
		}
		else{
			y = successor(z);
		}
		
		ABBNode<K,V> x=nil;
		
		if(y.getLeft()!=nil) {
			x = y.getLeft();
		}
		
		else {
			x = y.getRigth();
		}
		
		if( x != null) {
			x.setParent(y.getParent());	
		}
		
		if(y.getParent()==nil) {
			root=x;
		}
		else {
			if(y == y.getParent().getLeft()) {
				y.getParent().setLeft(x);
			}
			else {
				y.getParent().setRigth(x);
			}
		}
		
		if(nil == null && x == null) {
			x = y.getParent();
		}
		
		if(y!=z) {
			z.setKey(y.getKey());
			z.setValue(y.getValue());
		}
		
		ABBNode<K,V>[]ans = new ABBNode[2];
		
		ans[0] = x;
		ans[1] = y;
		return ans;
	}
}