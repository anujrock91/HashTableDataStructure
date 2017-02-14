package Snippet;
import java.util.*;

public class MinimumWindowSubString {
	
	public String minWindow(String s, String t){
		HashMap<Character,Integer> textRecord = new HashMap<>();
		for(int i=0;i<t.length();i++){
			char c = t.charAt(i);
			textRecord.put(c, textRecord.getOrDefault(c, 0)+1);
		}
		int i=0;
		LinkedList<Integer> q = new LinkedList<>();//Used as a queue
		String minWindow = null;
		
		while(i<s.length()){
			char c = s.charAt(i);
			if(textRecord.containsKey(c)){
				//If further addition is faulty
				if(textRecord.get(c) == 0){
					Integer left =q.removeFirst();
					char leftChar = s.charAt(left);
					textRecord.put(leftChar, textRecord.getOrDefault(leftChar, 0)+1);
				}
				else{
					q.addLast(i);
					textRecord.put(c, textRecord.getOrDefault(c, 0)-1);
					if(q.size() == t.length()){ 
						String tempMin = s.substring(q.getFirst(), q.getLast()+1);
						if(minWindow == null){ minWindow = tempMin; }
						else if(minWindow.length() > tempMin.length()){ minWindow = tempMin; }
						Integer left =q.removeFirst();
						char leftChar = s.charAt(left);
						textRecord.put(leftChar, textRecord.getOrDefault(leftChar, 0)+1);
					}
					++i;
				}
			}//Main if 
			else{
				++i;
			}
		}//End of While
		return minWindow==null?"":minWindow;
	}
	
	
	public static void main(String argsp[]){
		System.out.println(new MinimumWindowSubString().minWindow("ADOBECODEBANC", "ABC"));
	}
	
	
}
