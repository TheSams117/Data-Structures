package SimpleLinkedListStructures;

import exception.ListException;

public interface IList <T> {

      public void add(T newElement);
 
	  public void assign(int pos, T  newElement)throws ListException;
	
	  public void remove(T element);
	
	  public void removeElement(int pos) throws ListException;
	
	  public boolean elementInList(T element);
	
	  public int searchElement(T element);
	
	  public T getElement(int pos)throws ListException;
	  
	  public int getSize();

      public boolean isEmpty();

      public void deleteAll();

}
