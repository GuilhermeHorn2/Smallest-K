package misc;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Random;


public class main_misc {
	
	
	public static final int MAX = 1_000_000;
	
	
	
	public static void main(String[] args) {
		
		List<Integer> arr = new ArrayList<>(Arrays.asList(7,1,3,2,7,4));
		
		System.out.println(smallest_k(arr,4));

		
	}
	
	private static void swap(List<Integer> aux,int a,int b){
		
		int tmp = aux.get(a);
		aux.set(a, aux.get(b));
		aux.set(b, tmp);
		
		
	}
	
	private static List<Integer> smallest_k(List<Integer> arr,int k){
		
		//the value kth value or the last will be allways on top for comparisons
		
		List<Integer> aux = new ArrayList<>();
		
		int c = 0;
		for(int i = 0;i < arr.size();i++){
			
			int x = arr.get(i);
			
			if(c == 0){
				aux.add(x);
				c++;
			}
			else if(c < k){
				
				aux.add(x);
				c++;
				if(aux.get(c-2) > aux.get(c-1)){
					swap(aux,c-1,c-2);
				}
				
			}
			else {
				
				if(x < aux.get(c-1)){
					aux.remove(c-1);
					aux.add(x);
					
					if(aux.get(c-2) > aux.get(c-1)){
						swap(aux,c-1,c-2);
					}
				}
				
			}
			
		}
		
		return aux;
	}
	
		
}
