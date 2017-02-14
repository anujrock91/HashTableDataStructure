package Snippet;
import java.util.*;

public class LineReflection {
	
	public boolean isReflected(int [][] points){
		int [] arr = points[0];
		double max= Double.MIN_VALUE;
		double min= Double.MAX_VALUE;
		for(int i=0;i<points.length;i++){
			if(arr[1] == points[i][1]){ 
				min = Math.min(points[i][0], min);
				max = Math.max(max, points[i][0]);
			}
		}
		double ref = ((min+max)/2.);
		HashMap<String, Integer> pointMap = new HashMap<>();
		for(int [] point: points){
			String pattern = point[0]+","+point[1];
			pointMap.put(pattern, 1);
		}
		
		for(int [] point: points){
			if(point[0] == ref){ continue; }
			else{
				double initX = point[0];
				double X = (initX < ref)?((int)(point[0]+2*(ref-point[0]))):((int)(point[0]-2*(point[0]-ref)));
				String pattern = ((int)X)+","+point[1];
				if(!pointMap.containsKey(pattern)){ return false; }
			}
		}
		return true; 
	}
	
	
	public static void main(String args[]){
		int [][] points = new int[][]{{3,2},{4,2},{6,2},{7,2},{1,1},{9,1}};
		System.out.println(new LineReflection().isReflected(points));
	}
	
}
