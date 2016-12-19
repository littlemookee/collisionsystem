import edu.princeton.cs.algs4.StdDraw;

import java.util.Arrays;

import edu.princeton.cs.algs4.*;

public class Glass
{
	private Point2D[] polygon;
	private int N;
	
	private double timeToHit(Particle particle)
	{
		double time = 0.0;
		
		Point2D origin = new Point2D(0.0, 0.0);
		Arrays.sort(polygon, origin.polarOrder());
		Arrays
			
		return time;		
	}
	
	public Glass()
	{
		
		N = 8;
		polygon = new Point2D[N];
		polygon[0] = new Point2D(-0.3,  0.3);
		polygon[1] = new Point2D( 0.3,  0.3);
		polygon[2] = new Point2D( 0.05, 0.05);
		polygon[3] = new Point2D( 0.05,-0.05);
		polygon[4] = new Point2D( 0.3, -0.3);
		polygon[5] = new Point2D(-0.3, -0.3);
		polygon[6] = new Point2D(-0.05,-0.05);
		polygon[7] = new Point2D(-0.05, 0.05);
	}
	
	public void rotate(double angle)
	{
		double cos = Math.cos(angle);
		double sin = Math.sin(angle);
		
		for (int i = 0; i < N; i++) {
			double x = polygon[i].x()*cos - polygon[i].y()*sin; 
			double y = polygon[i].y()*cos + polygon[i].x()*sin;
			polygon[i] = new Point2D(x, y);
		}
	}
	
	public void draw()
	{
		for (int i = 0; i < N; i++)
        	StdDraw.line(polygon[i].x()+0.5, polygon[i].y()+0.5,
        	 polygon[(i+1)%N].x()+0.5, polygon[(i+1)%N].y()+0.5);
	}
}
