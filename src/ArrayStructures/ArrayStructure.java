package ArrayStructures;

import java.lang.reflect.Array;
import java.util.Hashtable;

import SimpleLinkedListStructures.IList;
import SimpleLinkedListStructures.SimpleLinkedList;

public class ArrayStructure <T>{
	private IList<T>[] array;
	private Hashtable<Integer,String> a;
	
	public ArrayStructure(int size) {
		array = new SimpleLinkedList[size]; //(T[]) Array.newInstance(clazz,size);	
		a = new Hashtable<>();
	
	}

//	public T[] getArray() {
//		return array;
//	}
//
//	public void setArray(T[] array) {
//		this.array = array;
//	}
	public static void main(String[] args) {
		ArrayStructure<Integer> x = new ArrayStructure<Integer>(147483647);
//		int suma = 0;
//		for (int i = 0; i < 2147483647; i++) {
//			suma++;
//		}
//		
//		System.out.println(suma+"");
	}

}
