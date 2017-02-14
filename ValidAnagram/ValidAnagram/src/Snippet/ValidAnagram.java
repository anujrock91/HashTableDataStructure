package Snippet;
import java.util.*;

public class ValidAnagram {
	
	public boolean isValidAnagram(String pattern, String text){
		HashMap<Character,Integer> charCount = new HashMap<>();
		if(pattern.length() != text.length()){ return false; }
		for(int i=0;i<pattern.length();i++){
			char c = pattern.charAt(i);
			charCount.put(c, charCount.getOrDefault(c, 0)+1);
		}
		
		for(int i=0;i<text.length();i++){
			char c = text.charAt(i);
			if(!charCount.containsKey(c)){ return false; }
			else{
				int value = charCount.remove(c);
				--value;
				if(value==0){}
				else{ charCount.put(c, value); } 
			}
		}
		
		if(charCount.size()==0){ return true; }
		else{ return false; }
	}
	
	
	public static void main(String args[]){
		System.out.println(new ValidAnagram().isValidAnagram("rat", "rac"));
	}
	
	
}
