package ArrayStructures;

import java.lang.reflect.Array;

import collections.IList;
import collections.SimpleLinkedList;

public class ArrayStructure <T>{
	private IList<T>[] array;
	
	public ArrayStructure(int size) {
		array = new SimpleLinkedList[size]; //(T[]) Array.newInstance(clazz,size);	
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
