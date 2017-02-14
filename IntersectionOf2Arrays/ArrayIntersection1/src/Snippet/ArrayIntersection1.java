package Snippet;
import java.util.*;

public class ArrayIntersection1 {
	
	public int[] intersect(int [] nums1, int[] nums2){
		HashSet<Integer> set1 = new HashSet<>();
		for(int i: nums1){
			set1.add(i);
		}
		
		HashSet<Integer> set2 = new HashSet<>();
		for(int i: nums2){
			if(set1.contains(i)){ set2.add(i); }
		}
		
		int [] res = new int[set2.size()];
		int count = 0;
		for(int i: set2){ res[count] = i; ++count;}
		return res;
	}
	
	
	public static void main(String args[]){
		int [] res = new ArrayIntersection1().intersect(new int[]{1,2,2,3,1}, new int[]{1,2,2,2,1});
		for(int i: res){ System.out.print(i+"|");}System.out.println();
	}
}
