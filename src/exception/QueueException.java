package exception;

@SuppressWarnings("serial")
public class QueueException extends Exception {
	public QueueException(String mensaje) {
		super(mensaje);
	}
//	
//	import java.util.Scanner;
//
//	//Uva 10810
//	//https://uva.onlinejudge.org/index.php?option=com_onlinejudge&Itemid=8&page=show_problem&problem=1751
//	public class UltraQuickSort {
//	    static int[] array;
//	    static long swaps = 0;
//	    
//	    public static void main(String[] args) {
//	        Scanner in = new Scanner(System.in);
//	        int N = in.nextInt();
//	        while (N > 0) {
//	        	array = new int[N];
//	        	for (int i = 0; i < N; i++) 
//	        		array[i] = in.nextInt();
//	            
//	            System.out.println(getMinSwaps(array.length));
//	            N = in.nextInt();
//	        }
//	        in.close();
//	    }
//
//	    static long getMinSwaps(int length) {
//	        swaps = 0;
//	        mergeSort(0, length);
//	        return swaps;
//	    }
//
//	    static void mergeSort(int left, int right) {
//	    	if (left <= right) {
//	    		int size = (right-left);
//	    		if (size > 2) {
//	    			mergeSort(left, left + size/2);
//	    			mergeSort((left + size/2), right); 
//	    			merge(left, left+size/2, left+size/2, right);
//	    		}
//	    		else if (size == 2 && array[left]>array[right-1]) {
//	    			int temp = 0;
//	    			temp = array[left];
//	    			array[left] = array[right-1];
//	    			array[right-1] = temp;
//	    			swaps++;
//				}
//			}
//	    }
//
//	    static void merge(int left1, int right1, int left2, int right2) {
//	    	int[] arr = new int[(right1-left1)+(right2-left2)];
//	    	int j1 = left1;
//	    	int j2 = left2;
//	    	
//	    	for (int i = 0; i < arr.length; i++) {
//	    		if (j1 < right1 && j2 < right2 && array[j2]<array[j1]) {
//					arr[i] = array[j2];
//	                swaps += j2 - left1 - i;
//					j2++;
//				}
//	    		else if (j1 < right1 && j2 < right2 && array[j2]>array[j1]) {
//	    			arr[i] = array[j1];
//	    			j1++;
//	    		}
//	    		else if (j2>=right2 && j1<right1) {
//	    			arr[i] = array[j1];
//	    			j1++;
//				}
//	    		else if (j1>=right1 && j2<right2) {
//	    			arr[i] = array[j2];
//	    			j2++;
//	    		}
//			}
//	    	
//	    	j1 = 0;
//	    	for (int i = left1; i < right2; i++) {
//				array[i] = arr[j1];
//				j1++;
//			}
//	    }
//	}
	
//----------------------------------------------------------------	
	
//	public class Secuencia {
//		public static boolean esSierra(int[] A){
//			array =  A;
//			return getMinSwaps(A.length) == A.length/2;
//		}
//		
//		static int[] array;
//		static long swaps = 0;
//		    
//		static long getMinSwaps(int length) {
//	        swaps = 0;
//	        mergeSort(0, length);
//	        return swaps;
//	    }
//
//	    static void mergeSort(int left, int right) {
//	    	if (left <= right) {
//	    		int size = (right-left);
//	    		if (size > 2) {
//	    			mergeSort(left, left + size/2);
//	    			mergeSort((left + size/2), right); 
//	    			merge(left, left+size/2, left+size/2, right);
//	    		}
//	    		else if (size == 2 && array[left]>array[right-1]) {
//	    			int temp = 0;
//	    			temp = array[left];
//	    			array[left] = array[right-1];
//	    			array[right-1] = temp;
//	    			swaps++;
//				}
//			}
//	    }
//
//	    static void merge(int left1, int right1, int left2, int right2) {
//	    	int[] arr = new int[(right1-left1)+(right2-left2)];
//	    	int j1 = left1;
//	    	int j2 = left2;
//	    	
//	    	for (int i = 0; i < arr.length; i++) {
//	    		if (j1 < right1 && j2 < right2 && array[j2]<array[j1]) {
//					arr[i] = array[j2];
//	                swaps += j2 - left1 - i;
//					j2++;
//				}
//	    		else if (j1 < right1 && j2 < right2 && array[j2]>array[j1]) {
//	    			arr[i] = array[j1];
//	    			j1++;
//	    		}
//	    		else if (j2>=right2 && j1<right1) {
//	    			arr[i] = array[j1];
//	    			j1++;
//				}
//	    		else if (j1>=right1 && j2<right2) {
//	    			arr[i] = array[j2];
//	    			j2++;
//	    		}
//			}
//	    	
//	    	j1 = 0;
//	    	for (int i = left1; i < right2; i++) {
//				array[i] = arr[j1];
//				j1++;
//			}
//	    }
//	}

}
