package Snippet;
import java.util.*;
public class LongestPalindrome {
	
	public int longestPalindrome(String s){
		HashMap<Character, Integer> charCount = new HashMap<>();
		int count = 0;
		for(int i=0;i<s.length();i++){
			char c = s.charAt(i);
			if(charCount.containsKey(c)){ charCount.remove(c); count +=2;}
			else { charCount.put(c, 1); } 
		}
		if(charCount.size() == 0){ return count;}
		else{return count+1; }
	}
	
	public static void main(String args[]){
		System.out.println(new LongestPalindrome().longestPalindrome("aabb"));
	}
	
}
