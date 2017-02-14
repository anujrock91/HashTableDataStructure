package Snippet;
import java.util.*;

public class FractionToRecurring {
	
	public String fractionToDecimal(int num,int deno){
		String result = "";
		while(num >= deno){
			result = result+(num/deno);
			num = (num%deno);
		}
		return (num == 0)?result:result+getFractionSmallerNumerator(num, deno);
		
	}
	
	
	public String getFractionSmallerNumerator(int num, int deno){
		HashMap<Integer, Integer> remainderPosition = new HashMap<>();
		ArrayList<Integer> quoList = new ArrayList<>();
		int count = 0;int recPosition=Integer.MIN_VALUE;
		remainderPosition.put(num, 0);
		
		while(num < deno && num != 0){
			num = (num*10);
			if(num<deno){
				++count;
				quoList.add(0);
				if(remainderPosition.containsKey(num)){ recPosition = remainderPosition.get(num); break; }
				else{ remainderPosition.put(num, count); } 
			}
			else{
				quoList.add(num/deno);
				num = (num%deno);
				if( remainderPosition.containsKey(num) ){
					recPosition = remainderPosition.get(num); break;
				}
				else{
					++count;
					remainderPosition.put(num, count);
				}
			}
		}
		//String construction
		String result = ".";
		for(int i=0;i<quoList.size();i++){
			if(i == recPosition){
				result = result+"(";
			}
			result = result+quoList.get(i);
		}
		return (recPosition==Integer.MIN_VALUE)?result:result+")";
	}
	
	public static void main(String args[]){
		System.out.println(new FractionToRecurring().getFractionSmallerNumerator(1, 82));
		System.out.println(new FractionToRecurring().getFractionSmallerNumerator(4, 9));
		System.out.println(new FractionToRecurring().getFractionSmallerNumerator(4, 333));
		System.out.println(new FractionToRecurring().fractionToDecimal(83, 82));
		System.out.println(new FractionToRecurring().fractionToDecimal(1,2));
	}
	
	
}