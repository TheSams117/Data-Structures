package collections;

import exception.StackException;

public interface IStack <T> {

    public void push(T newelement);
    
    public void pop() throws StackException;
    
    public int getSize();
    
    public boolean isEmpty();
    
	public T top() throws StackException;
	
	public IList<T> getArrayList() throws Exception;
	
}
