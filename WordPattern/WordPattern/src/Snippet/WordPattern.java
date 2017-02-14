package Snippet;
import java.util.*;
import java.util.Map.Entry;

public class WordPattern {
	
	public boolean isValidPattern(String pattern, String text){
		String [] split = text.split(" ");
		if(split.length != pattern.length()){
			return false;
		}
		String patternTemp=""; String textTemp = "";
		LinkedHashMap<String, String> map = new LinkedHashMap<>();
		for(int i=0;i<pattern.length();i++){
			String c = ""+pattern.charAt(i);
			map.put(c, map.getOrDefault(c, "")+i);
		}
		for(Entry<String, String>e: map.entrySet() ){
			patternTemp = patternTemp + e.getValue() + "/";
		}
		map.clear();
		for(int i=0;i<split.length;i++){
			String c = split[i].trim();
			map.put(c, map.getOrDefault(c, "")+i);
		}
		for(Entry<String, String>e: map.entrySet() ){
			textTemp = textTemp + e.getValue()+"/";
		}
		
		return textTemp.equals(patternTemp);
	}
	
	
	
	public static void main(String []args){
		System.out.println(new WordPattern().isValidPattern("abba", "cow dog dog cow"));
	}
	
}
