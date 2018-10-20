package SimpleLinkedListStructures;


import exception.ListException;
import exception.QueueException;
import exception.StackException;

public class SimpleLinkedList <E> implements IStack<E>, IQueue<E>, IList<E>{
	
    private Node<E> firstNode;

    private Node<E> lastNode;

    private int size;

    
    
    public SimpleLinkedList() {
        firstNode = null;
        lastNode = null;
        size = 0;
     
        
    }

    public Node<E> getFirstNode() {
        return firstNode;
    }

    public void setFirstNode(Node<E> firstNode) {
        this.firstNode = firstNode;
    }

    public Node<E> getLastNode() {
		return lastNode;
	}

	public void setLastNode(Node<E> lastNode) {
		this.lastNode = lastNode;
	}

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public boolean isEmpty(){
        return (firstNode==null)? true:false;
    }
    
    public IList<E> getArrayList()throws Exception {
    	if (isEmpty()) {
			throw new Exception("The structure is empty");
		}
    	IList<E> array = this;
    	return array;
    }

//                |----------------------------------|
//----------------|--------------STACK---------------|--------------------------------------------------------------------
//                |----------------------------------|
    
    @Override
    public void push(E element) {

        Node<E> newNode = new Node<E>(element);

        if(isEmpty()){
            firstNode = newNode;
        } else {
            newNode.setNextNode(firstNode);
            firstNode=newNode;
        }

        size+=1;
    }

    @Override
    public void pop() throws StackException{
      
        if(!isEmpty()){
            firstNode = firstNode.getNextNode();
            size-=1;
            
        }else {
        	throw new StackException("The stack is empaty");
        }
    }

	@Override
	public E top() throws StackException {

		if(isEmpty()) {
			
			throw new StackException("The stack is empaty");
		}
		return (E)firstNode.getElement();
	}	

//  			  |----------------------------------|
//----------------|--------------QUEUE---------------|--------------------------------------------------------------------
//  			  |----------------------------------|

	@Override
	public void enqueue(E newElement) {
		Node<E> newNode = new Node<E>(newElement);

		if(isEmpty()) {
			firstNode = newNode;
			lastNode = firstNode;
		}else {
			lastNode.setNextNode(newNode);
			lastNode = lastNode.getNextNode();
		}
		
		size+=1;
	}

	@Override
	public void dequeue() throws QueueException {
		if(isEmpty()) {
			throw new QueueException("The Queue is empaty");
		}else {
			firstNode = firstNode.getNextNode();
			size-=1;
		}
	}

	@Override
	public E front() {
		return (E) firstNode.getElement();
	}

	@Override
	public E back() {
		return (E) lastNode.getElement();
	}
//  			  |----------------------------------|
//----------------|---------------LIST---------------|--------------------------------------------------------------------
//  			  |----------------------------------|

	@Override
	public void add(E newElement) {
		Node<E> newNode = new Node<E>(newElement);
		
		if(isEmpty()) {
			firstNode = newNode;
			lastNode=firstNode;
		}else {
			lastNode.setNextNode(newNode);
			lastNode = lastNode.getNextNode();
		}
		
		size+=1;
	}

	@Override
	public void assign(int pos, E newElement) throws ListException {
		if(isEmpty()) {
			throw new ListException("The list is empaty");
		}else if(pos>=size || pos<0) {
			throw new ListException("The index of income is outside the list");
		}else if(newElement==null) {
			throw new ListException("The object to enter is null");
		}
		
		Node<E> newNode = new Node<E>(newElement);
		
		if(pos==0) {
			newNode.setNextNode(firstNode);
			firstNode = newNode;
			
		}else {
			int accountant = 0;
			
			Node<E> currentNode = firstNode;
			
			while(accountant+1!=pos) {
				currentNode=currentNode.getNextNode();
				accountant+=1;
			}
			
			newNode.setNextNode(currentNode.getNextNode());
			currentNode.setNextNode(newNode);
		}
		size+=1;
		
	}

	@Override
	public void removeElement(int pos) throws ListException {
		if(isEmpty()) {
			throw new ListException("The list is empaty");
		}else if(pos>=size || pos<0) {
			throw new ListException("The index of income is outside the list");
		}
		
		if(pos==0) {
			
			firstNode = firstNode.getNextNode();
			
		}else {
			
			int accountant = 0;
			
			Node<E> currentNode = firstNode;
			
			while(accountant+1!=pos) {
				currentNode=currentNode.getNextNode();
				accountant+=1;
			}
			
			
			currentNode.setNextNode((currentNode.getNextNode().getNextNode()==null)? null:currentNode.getNextNode().getNextNode());

		}
		
		size-=1;
		
	}

	@Override
	public boolean elementInList(E element) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public int searchElement(E element) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public E getElement(int pos) throws ListException {
		
		if(isEmpty()) {
			throw new ListException("The list is empaty");
		}else if(pos>=size || pos<0) {
			throw new ListException("The index of income is outside the list");
		}
		
		int accountant = 0;
		
		Node<E> currentNode = firstNode;
		
		while(accountant!=pos) {
			currentNode=currentNode.getNextNode();
			accountant+=1;
		}
		return currentNode.getElement();
	}

	@Override
	public void deleteAll() {
		firstNode=null;	
		size=0;
	}

	public static void main(String[] arg) throws ListException {
		IList<Integer> list = new SimpleLinkedList<Integer>();
		for (int i = 0; i <= 20; i++) {
			list.add(i);
		}
		list.assign(0, 21312);
		for (int i = 0; i < list.getSize(); i++) {
			System.out.println(list.getElement(i)+"");

		}
		
		System.out.println("Tamaño: "+list.getSize()+"");
		
		
	}

	@Override
	public void remove(E element) {
		// TODO Auto-generated method stub
		
	}
	/* IsBalanced balanced = new IsBalanced();

	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	bw.write("Select the action you want to perform \n -1: Generate cases \n -2: Existing cases \n -3: Enter case \n ");
	bw.flush();

	String ca_se = br.readLine();

	if(ca_se.equals("1")) {
		
		File file = new File("cases/testCases.txt");	      
		
		file.createNewFile();
		
		FileWriter writer = new FileWriter(file); 



		for (int i = 0; i < 50000; i++) {
			
			writer.write(generateRandomInput()+"\n");

		}

		writer.flush();
		writer.close();
		
		FileReader fr = new FileReader("cases/testCases.txt");
		
		BufferedReader br2 = new BufferedReader(fr);
		
		String cadena = "";

		while((cadena = br2.readLine()) != null) {
		
			bw.write(balanced.balanced(cadena)+"\n");
			
		}

		bw.flush();
		
		br2.close();
		
		
		
	}else if(ca_se.equals("2")) {
		
		FileReader fr = new FileReader("cases/testPre-generatedCases.txt");
		
		BufferedReader br3 = new BufferedReader(fr);
		
		String cadena = "";
			
		while((cadena = br3.readLine()) != null) {
		
			bw.write(balanced.balanced(cadena)+"\n");
		}
		bw.flush();
		br3.close();
		
	}else if(ca_se.equals("3")) {
		
		String c = br.readLine();
		
		bw.write(balanced.balanced(c));
		bw.flush();
		
	}else {
		bw.write(ca_se+" is not a valid option");
		bw.flush();
	}
	}*/

	
}
