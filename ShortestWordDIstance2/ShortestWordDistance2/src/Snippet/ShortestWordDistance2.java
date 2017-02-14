package Snippet;
import java.util.*;

public class ShortestWordDistance2 {
	HashMap<String, ArrayList<Integer>> wordIndex = new HashMap<>();
	
	public ShortestWordDistance2(String [] arr){
		for(int i=0;i<arr.length;i++){
			if(wordIndex.containsKey(arr[i])){
				wordIndex.get(arr[i]).add(i);
			}
			else{
				ArrayList<Integer> newList = new ArrayList<>();
				newList.add(i);
				wordIndex.put(arr[i], newList);
			}
		}
	}
	
	public int shortestDistance(String word1,String word2){
		ArrayList<Integer> word1list = wordIndex.get(word1);
		ArrayList<Integer> word2list = wordIndex.get(word2);
		int min = Integer.MAX_VALUE;
		int upperPointer = 0;
		int lowerPointer = 0;
		while(upperPointer<word1list.size() && lowerPointer<word2list.size()){
			min = Math.min(min, Math.abs(word1list.get(upperPointer)-word2list.get(lowerPointer))) ;
			if(word1list.get(upperPointer) <= word2list.get(lowerPointer)){ ++upperPointer; }
			else{ ++lowerPointer; }
		}
		return min;
	}
	
	
	
	public static void main(String args[]){
		ShortestWordDistance2 obj = new ShortestWordDistance2(new String[]{"practice", "makes", "perfect", "coding", "makes"});
		System.out.println(obj.shortestDistance("makes", "coding"));
	}
	
	
}