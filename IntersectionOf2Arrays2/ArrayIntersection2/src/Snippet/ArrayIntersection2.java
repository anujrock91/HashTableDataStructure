package Snippet;
import java.util.ArrayList;
import java.util.HashMap;

public class ArrayIntersection2 {
	
	public int [] intersect(int nums1[], int nums2[]){
		HashMap<Integer, Integer>nums1Count = new HashMap<>();
		for(int i: nums1){
			nums1Count.put(i, nums1Count.getOrDefault(i,0)+1);
		}
		ArrayList<Integer> temp = new ArrayList<>();
		for(int i: nums2){
			if(nums1Count.containsKey(i)){
				temp.add(i);
				int value = nums1Count.remove(i);
				--value;
				if(value!=0){ nums1Count.put(i, value); }
			}
		}
		
		int [] res=  new int[temp.size()];
		int count=0;
		for(int i: temp){ res[count] = i; ++count; }
		return res;
	}
	
	public static void main(String args[]){
		int res [] = new ArrayIntersection2().intersect(new int[]{1,2,2,3,1,4}, new int[]{1,1,1,1,1,2,2,22,2});
		for(int i:res){System.out.print(i+" | ");}
	}
}
