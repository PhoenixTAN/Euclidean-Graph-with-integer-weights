/*
Author: Ziqi Tan
*/

/**
 * Give an example of a complete Euclidean graph G with 4 vertices, 
 * where all the weights are integers and no two weights are equal.
 * 
 * */
public class Solution {
	
	static class Point {
		int x;
		int y;
		public Point( int _x, int _y ) {
			this.x = _x;
			this.y = _y;
		}
	}
	
	public static boolean findEuclideanGraph() {
		int numOfvertices = 4;
		Point[] points = new Point[numOfvertices];
		int min = 1;
		int max = 101;
		for( int i = 0; i < numOfvertices; i++ ) {
			int x = min+(int)(Math.random()*(max-min+1));
			int y = min+(int)(Math.random()*(max-min+1));
			points[i] = new Point(x, y);
			System.out.println("(" + x + ", " + y + ")");
		}
				
		// if you do not allow that four vertices are in one line.
		if( isLine(points) ) {
			return false;
		}
		
		for( int i = 0; i < numOfvertices-1; i++ ) {
			for( int j = i + 1; j < numOfvertices; j++ ) {
				double dis = Math.sqrt((points[i].x - points[j].x) * (points[i].x - points[j].x) + (points[i].y - points[j].y) * (points[i].y - points[j].y));
				System.out.println(dis);
				if( dis > (int)dis ) {
					return false;
				}
			}
		}
						
		return true;
	}
	
	private static boolean isLine(Point[] points) {
		int numOfvertices = points.length;
		boolean xLine = true;
		boolean yLine = true;
		for( int i = 1, x = points[0].x; i < numOfvertices; i++ ) {
			if( points[i].x != x ) {
				xLine = false;
			}
		}

		for( int i = 1, y = points[0].y; i < numOfvertices; i++ ) {
			if( points[i].y != y ) {
				yLine = false;
			}
		}		
		return xLine || yLine;		
	}
	
	public static void main(String[] args) {
		while( !findEuclideanGraph() ) {};
	}

}
