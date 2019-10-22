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
	
	public static boolean findEuclideanGraph(int N) {
		int numOfvertices = 4;
		Point[] points = new Point[numOfvertices];
		int min = 1;
		int max = 101;
		// initialize the points
		for( int i = 0; i < numOfvertices; i++ ) {
			int x = min+(int)(Math.random()*(max-min+1));
			int y = min+(int)(Math.random()*(max-min+1));
			points[i] = new Point(x, y);
			// System.out.println("(" + x + ", " + y + ")");
		}
		
		// if you do not allow that any two vertices are at the same position.
		if( samePoint(points) ) {
			return false;
		}
		
		// if you do not allow that four vertices are in one line.
		// Use slope
		if( isLine(points) ) {
			return false;
		}
		// calculate the distances between every two points
		for( int i = 0; i < numOfvertices-1; i++ ) {
			for( int j = i + 1; j < numOfvertices; j++ ) {
				double dis = Math.sqrt((points[i].x - points[j].x) * (points[i].x - points[j].x) 
						+ (points[i].y - points[j].y) * (points[i].y - points[j].y));
				// System.out.println(dis);
				if( dis > (int)dis ) {
					return false;
				}
			}
		}
		
		print(points);
		return true;
	}
	
	private static boolean isLine(Point[] points) {
		int numOfvertices = points.length;
		// use slope
		// (y1-y0)*(x2-x1)=(y2-y1)*(x1-x0)
		int y10 = points[1].y - points[0].y;
		int x21 = points[2].x - points[1].x;
		
		int y21 = points[2].y - points[1].y;
		int x10 = points[1].x - points[0].x;
		
		if( y10*x21 != y21*x10 ) {
			return false;
		}
		
		// for point 4
		// (y2-y1)*(x3-x2) = (y3-y2)*(x2-x1)
		// y21 * x32 = y32 * x21
		boolean rollingFlag = true; 
		for( int i = 3; i < numOfvertices; i++ ) {
			if( rollingFlag ) {
				y10 = points[i].y - points[i-1].y;
				x10 = points[i].x - points[i-1].x;
				if( y10*x21 != y21*x10 ) {
					return false;
				}
				rollingFlag = !rollingFlag;
			}
			else {				
				y21 = points[i].y - points[i-1].y;
				x21 = points[i].x - points[i-1].x;
				if( y10*x21 != y21*x10 ) {
					return false;
				}
				rollingFlag = !rollingFlag;
			}
		}
		
		return true;
	}
	
	private static boolean samePoint(Point[] points) {
		int numOfvertices = points.length;
		for( int i = 0; i < numOfvertices-1; i++ ) {
			for( int j = i+1; j < numOfvertices; j++ ) {
				if( points[i].x == points[j].x && points[i].y == points[j].y ) {
					return true;
				}
			}
		}
		return false;
	}
	
	// print points and distances
	private static void print(Point[] points) {
		int numOfvertices = points.length;
		System.out.println("Result: ");
		for( int i = 0; i < numOfvertices; i++ ) {
			System.out.println("(" + points[i].x + ", " + points[i].y + ")");
		}
		// distance
		for( int i = 0; i < numOfvertices-1; i++ ) {
			for( int j = i + 1; j < numOfvertices; j++ ) {
				double dis = Math.sqrt((points[i].x - points[j].x) * (points[i].x - points[j].x) 
						+ (points[i].y - points[j].y) * (points[i].y - points[j].y));
				System.out.println("Distance between Point " + i + " and Point " + j + " " + dis);
			}
		}
		
		// matlab code
		System.out.println();
		System.out.println("%% Matlab Visualization code");
		System.out.print("x = [ ");
		for( int i = 0; i < numOfvertices; i++ ) {
			System.out.print(points[i].x + " ");
		}
		System.out.print("];\n");
		
		System.out.print("y = [ ");
		for( int i = 0; i < numOfvertices; i++ ) {
			System.out.print(points[i].y + " ");
		}
		System.out.print("];\n");
		
		System.out.print("distanceMat = pdist( [ \n" );
		for( int i = 0; i < numOfvertices; i++ ) {
			System.out.print( points[i].x + ", " + points[i].y + ";\n");
		}
		System.out.print("] )\n" );
		System.out.println("scatter(x, y);");
	}
	
	public static void main(String[] args) {
		int N = 4;  // N has to be more than 3
		while( !findEuclideanGraph(N) ) {};
	}

}
