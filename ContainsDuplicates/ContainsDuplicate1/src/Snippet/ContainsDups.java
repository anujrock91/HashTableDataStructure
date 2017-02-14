package Snippet;
import java.util.*;

public class ContainsDups {
	
	public boolean isDups(int nums[]){
		HashSet<Integer> elements = new HashSet<>();
		for(int i: nums){
			if(elements.contains(i)){return true;}
			else{ elements.add(i); }
		}
		return false; 
	}
	
	public static void main(String args[]){
		System.out.println(new ContainsDups().isDups(new int[]{1,2,3,4,0,2}));
	}
}