package Snippet;
import java.util.*;
import java.util.Map.Entry;

public class Rearrange {
	
	public String rearrangeKDistance(String s, int k){
		HashMap<Character, Integer> charCount = new HashMap<>();
		for(int i=0;i<s.length();i++){
			char c = s.charAt(i);
			charCount.put(c, charCount.getOrDefault(c, 0)+1);
		}
		
		PriorityQueue<Character> queue = new PriorityQueue<Character>(new Comparator<Character>() {
			@Override
			public int compare(Character o1, Character o2) {
				// TODO Auto-generated method stub
				if(charCount.get(o2).intValue()!=charCount.get(o1).intValue()){
	                return charCount.get(o2)-charCount.get(o1);
	            }else{
	                return o1.compareTo(o2);
	            }
			}
		});
		
		for(Entry<Character, Integer> e: charCount.entrySet()){
			queue.add(e.getKey());
		}
		System.out.println(queue);
		
		int length = s.length();
		StringBuilder sb = new StringBuilder();
		
		while(!queue.isEmpty()){
			int count = Math.min(length, k); 
			ArrayList<Character> temp = new ArrayList<>();
			for(int i=0;i<count;i++){
				if(queue.isEmpty()){ return ""; }
				
				char c = queue.poll();
				sb.append(c);
				
				charCount.put(c, charCount.get(c)-1);
				if(charCount.get(c) >0 ){ temp.add(c); }
				--length;
			}
			
			for(Character c: temp){ queue.add(c); }
		}
		
		return sb.toString();
	}
	
	
	public static void main(String args[]){
		System.out.println(new Rearrange().rearrangeKDistance("abcabc",3));
	}
	
}
