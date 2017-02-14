package Snippet;
import java.util.*;

public class FourSum2 {
	
	public int fourSumCount(int[] A, int[] B, int[] C, int[] D){
		HashMap<Integer, Integer> record = new HashMap<>();
		int count = 0;
		for(int i=0;i<A.length;i++){
			for(int j=0;j<B.length;j++){
				int sum = (A[i]+B[j]);
				if(record.containsKey(sum)){ int value = record.remove(sum)+1; record.put(sum, value); }
				else{ record.put(sum, 1); } 
			}
		}
		
		for(int i=0;i<C.length;i++){
			for(int j=0;j<D.length;j++){
				int sum  = ((-1)*(C[i]+D[j]));
				if(record.containsKey(sum)){ count = count+record.get(sum); }
			}
		}
		return count; 
	}
	
	
	public static void main(String args[]){
		int A[] = new int[]{1, 2};
		int B[] = new int[]{-1, -2};
		int C[] = new int[]{-1, 2};
		int D[] = new int[]{0, 2};
		System.out.println(new FourSum2().fourSumCount(A, B, C, D));
	}
	
}
