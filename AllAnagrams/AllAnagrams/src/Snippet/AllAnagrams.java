package Snippet;
import java.util.*;


public class AllAnagrams {
	
	public List<Integer> findAnagrams(String s, String p) {
		long start = System.nanoTime();
		if(s == null || p == null){ return null; }
		else if(s.length() < p.length()){ return null; }
		else{
			int[] pat = new int[26];
			int[] temp = new int[26];
			for(int i=0;i<p.length();i++){ ++pat[(p.charAt(i)-'a')]; ++temp[s.charAt(i)-'a']; }
			List<Integer> result = new ArrayList<>();
			int left = 0;
			int right = p.length();
			while(right < s.length()){
				if(isEqualArray(pat, temp)){
					result.add(left);
				}
				char cLeft = s.charAt(left);
				char cRight = s.charAt(right);
				--temp[cLeft-'a'];
				++temp[cRight-'a'];
				++left;
				++right;
			}
			if(isEqualArray(pat, temp)){ result.add(left); }
			long end = System.nanoTime();
			System.out.println(end-start);
			return result;
		}
	}
	
	private boolean isEqualArray(int []a, int []b){
		for(int i=0;i<a.length;i++){
			if(a[i] != b[i]){ return false; }
		}
		return true;
	}
	
	
	public static void main(String [] args){
		List<Integer> result = new AllAnagrams().findAnagrams("ababa", "ab");
		System.out.println(result);
	}
}
