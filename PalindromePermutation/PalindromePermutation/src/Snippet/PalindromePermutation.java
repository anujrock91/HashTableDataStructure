package Snippet;

public class PalindromePermutation {
	
	public boolean isPalindromePermutation(String s){
		int xor = 0;
		for(int i=0;i<s.length();i++){
			char c = s.charAt(i);
			int num = getCharNumber(c);
			xor = (xor^(1<<num));
		}
		if(xor == 0){ return true; }
		else if( (xor&(xor-1)) == 0){ return true;	}
		else{ return false; }
	}
	
	public int getCharNumber(char c){
		return c-'a';
	}
	
	public static void main(String args[]){
		System.out.println(new PalindromePermutation().isPalindromePermutation("aababa"));
	}
	
	
}