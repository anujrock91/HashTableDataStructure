package Snippet;
import java.util.*;

public class SubStringWithConcatenation {
	
	public List<Integer> findSubString(String s, String []words){
		HashMap<String, Integer> givenWords = new HashMap<>();
		ArrayList<Integer> result = new ArrayList<>();
		for(String word: words){
			givenWords.put(word, 1);
		}
		int len = words[0].length();
		
		//Looping for length times
		for(int i=0;i<len;i++){
			HashMap<String, Integer> wordCount = new HashMap<>();
			int start = i;
			int count = 0;
			for(int j=i;j<s.length();j=j+len){
				String section = s.substring(j,((j+len)>s.length()?s.length():j+len));
				//Either it is a valid string to consider or Not
				if(givenWords.containsKey(section)){
					++count;
					wordCount.put(section, wordCount.getOrDefault(section, 0)+1);
					
					if(wordCount.get(section) > givenWords.get(section)){
						--count;
						j = j-len;
						int value = (wordCount.get(section)-1); wordCount.put(section, value);
						String left = s.substring(start,start+len);
						value = (wordCount.get(left)-1); wordCount.put(left, value);
						start = start+len;
						--count;
					}
					
					if(count == words.length){ result.add(start); } 
					
				}
				else{
					wordCount.clear();
					start = j+len;
					count = 0;
				}
			}//End of inner for loop
		}//End of for loop
		return result;
	}
	
	
	public static void main(String args[]){
		List<Integer> l = new SubStringWithConcatenation().findSubString("abarfoofoobarman", new String[]{"foo", "bar"});
		System.out.println(l);
	}
	
}