package Snippet;
import java.util.*;
import java.util.Map.Entry;

class Point {
	 	int x;
	    int y;
	    Point() { x = 0; y = 0; }
	    Point(int a, int b) { x = a; y = b; }
}

public class MaxPoints {
	
	 public int maxPoints(Point[] points) {
		 
		 HashMap<Double, Integer> slopeCount = new HashMap<>();
		 int max = 0;
		 //For each point i
		 for(int i=0;i<points.length-1;i++){
			 int vertical = 0;
			 int duplicates = 0;
			 int tempMax = 0;
			 //For each point (j) other than (i)
			 for(int j=i+1;j<points.length;j++){
				 Double slope = getSlope(points[i],points[j]);
				 if(points[i].x == points[j].x && points[i].y == points[j].y){ 
					 ++duplicates; continue;
				 }
				 
				 if(slope == null){
					 ++vertical;
					 continue; 
				 }
				 slopeCount.put(slope, slopeCount.getOrDefault(slope, 0)+1);
			 }
			 //Getting the max value for the point i
			 for(Entry<Double,Integer> e: slopeCount.entrySet()){
				 tempMax = Math.max(tempMax, e.getValue()+duplicates);
			 }
			 tempMax = Math.max(tempMax, duplicates+vertical);
			 max = Math.max(max, tempMax+1);
			 //Clearing the map
			 slopeCount.clear();
		 }
		 return max;
     }
	 
	 public Double getSlope(Point p1, Point p2){
		 int x1 = p1.x;
		 int x2 = p2.x;
		 int y1 = p1.y;
		 int y2 = p2.y;
		 if(x1 == x2){
			 return null;
		 }
		 else{
			 return ((double)(y2-y1)/(double)(x2-x1));
		 }
	 }
     
     public static void main(String args[]){
    	 Point p1 = new Point(1, 1);Point p5 = new Point(1, 2);
    	 Point p2 = new Point(2, 3);Point p6 = new Point(2, 2);
    	 Point p3 = new Point(5, 5);Point p7 = new Point(3, 2);
    	 Point p4 = new Point(3, 2);Point p8 = new Point(1, 1);
    	 Point[] points = new Point[]{p1,p2,p3,p4,p5,p6,p7,p8};
    	 System.out.println(new MaxPoints().maxPoints(points));
     }
}