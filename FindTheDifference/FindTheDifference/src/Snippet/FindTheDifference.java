package Snippet;

public class FindTheDifference {
	
	public char difference(String s, String t){
		char xor = 0;
		for(int i=0;i<s.length();i++){
			xor ^= s.charAt(i);
		}
		for(int i=0;i<t.length();i++){
			xor ^=t.charAt(i);
		}
		return xor; 
	}
	
	
	public static void main(String args[]){
		System.out.println(new FindTheDifference().difference("abcd", "tadbc"));
	}
}
