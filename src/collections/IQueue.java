package collections;

public interface IQueue <T> {
	public void enqueue(T newElement);
	
	public void dequeue()throws QueueException;
	
	public boolean isEmpaty();
	
	public int getSize();
	
	public T front()throws QueueException;
	
	public T back()throws QueueException;
	
	public IList<T> getArrayList()throws Exception;
}
