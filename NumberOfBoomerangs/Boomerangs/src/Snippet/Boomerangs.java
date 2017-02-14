package Snippet;
import java.util.*;

public class Boomerangs {
	
	public int numBoomerangs(int [][] points){
		HashMap<Double, Integer> distanceCount = new HashMap<>();
		int result = 0;
		for(int i=0;i<points.length;i++){
			for(int j=0;j<points.length;j++){
				if(i==j){ continue; }
				double d = getDistance(points[i], points[j]);
				if(distanceCount.containsKey(d)){
					int mul = (2*distanceCount.get(d));
					result += mul;
					distanceCount.put(d, distanceCount.getOrDefault(d, 0)+1 );
				}
				else{ distanceCount.put(d, 1); }
			}
			System.out.println(result);
			distanceCount.clear();
		}
		return result;
	}
	
	private double getDistance(int a[], int []b){
		return Math.sqrt(Math.pow(a[0]-b[0],2)+Math.pow(a[1]-b[1],2));
	}
	
	
	public static void main(String args[]){
		int [][] points = new int[][]{{0,0},{1,0},{0,1},{0,-1},{-1,0}};
		new Boomerangs().numBoomerangs(points);
	}
}
