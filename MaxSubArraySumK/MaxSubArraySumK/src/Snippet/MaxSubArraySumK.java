package Snippet;
import java.util.*;

public class MaxSubArraySumK {
	
	public int maxSubArraySumK(int []nums, int k){
		HashMap<Integer, Integer> sumIndex = new HashMap<Integer, Integer>();
		int sum = 0;
		int len = 0;
		sumIndex.put(sum, -1);
		for(int i=0;i<nums.length;i++){
			sum += nums[i];
			int difference = (k-sum);
			if(sumIndex.containsKey(difference)){
				len = Math.max(len, i-(sumIndex.get(difference)));
			}
			sumIndex.put(sum, Math.min(sumIndex.getOrDefault(sum, Integer.MAX_VALUE), i) );
		}
		return len;
	}
	
	
	public static void main(String args[]){
		System.out.println(new MaxSubArraySumK().maxSubArraySumK(new int[]{1, -1, 5, -2, 3}, 3));
	}
	
}