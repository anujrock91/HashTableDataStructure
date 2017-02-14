package Snippet;
import java.util.*;
import java.util.Map.Entry;


public class TopKTerms {

	//Approach-1 using a count array O(highest frequency space) O(n)-time
	public List<Integer> getTopKArray(int []nums, int k){
		HashMap<Integer,Integer> numCount = new HashMap<>();
		for(int i: nums){
			numCount.put(i, numCount.getOrDefault(i,0)+1);
		}
		
		for(Entry <Integer,Integer>e: numCount.entrySet()){
			System.out.println(e.getKey() + " = " + e.getValue());
		}
		
		int max = Integer.MIN_VALUE;
		for(Entry <Integer,Integer>e: numCount.entrySet()){
			max = Math.max(max, e.getValue());
		}
		
		String maxCount[] = new String[max+1];
		for(Entry <Integer,Integer>e: numCount.entrySet()){
			String temp = (maxCount[e.getValue()]==null)?""+e.getKey():maxCount[e.getValue()]+"#"+e.getKey();
			maxCount[e.getValue()] = temp;
		}
		ArrayList<Integer> result = new ArrayList<>();
		int toAdd = k;
		
		for(int i=maxCount.length-1;i>=0;i--){
			if(maxCount != null){
				String [] temp = maxCount[i].split("#");
				int count = Math.min(toAdd, temp.length);
				for(int j=0;j<count;j++){
					result.add( Integer.parseInt(temp[j]) );
					--toAdd;
				}
				if(result.size() == k){ break; }
			}
		}
		
		return result;
	}
	
	
	//Approach-2 Using Priority Queue min heap O(nlogK)-time O(k) space
	public List<Integer> getTopKPriorityQueue(int []nums, int k){
		HashMap<Integer,Integer> numCount = new HashMap<>();
		for(int i: nums){
			numCount.put(i, numCount.getOrDefault(i,0)+1);
		}
		
		PriorityQueue<Integer> minQue = new PriorityQueue<>(new Comparator<Integer>() {
			@Override
			public int compare(Integer o1, Integer o2) {
				if(numCount.get(o1) != numCount.get(o2)){
					return (numCount.get(o1) - numCount.get(o2));
				}
				return 0;
			}
		});
		
		for(Entry <Integer,Integer>e: numCount.entrySet()){
			minQue.add(e.getKey());
			if(minQue.size() > k){
				minQue.remove();
			}
		}
		List<Integer> res = new ArrayList<>();
		while(!minQue.isEmpty()){
			res.add(minQue.remove());
		}
		return res; 
	}
	
	
	
	public static void main(String args[]){
		List<Integer> res = new ArrayList<>();
		res = new TopKTerms().getTopKArray(new int[]{1,2,2,3,3,3,4,4,2,2,1,1,15,5,5,5,6,3,3,2,2,7,7,7,8,8,10,11,1,10,11}, 8);
		System.out.println(res);
		
		res = new TopKTerms().getTopKPriorityQueue(new int[]{1,2,2,3,3,3,4,4,2,2,1,1,15,5,5,5,6,3,3,2,2,7,7,7,8,8,10,11,1,10,11}, 8);
		System.out.println(res);
		
	}
	
}
