import java.util.Arrays;
import java.util.Comparator;

import edu.princeton.cs.algs4.*;

public class Glass
{
	private Point2D[] polygon;
	private int N;
	private double g;
	
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
		g = 9.8;
	}
	
	private boolean abovePoint(Particle p, int i)
	{
		
		double t;
		if (p.vx() == 0.0) t = Double.POSITIVE_INFINITY;
		else			   t = (polygon[i].x() - p.x()) / p.vx();
		
		double y;
		if (t == Double.POSITIVE_INFINITY) y = Double.NEGATIVE_INFINITY;
		else 							   y = p.y() - g*t*t/2 + p.vy()*t;
		
		return y > polygon[i].y();
	}
	
	private Point2D findCrossPoint(Particle p, int low, int high)
	{		
		assert abovePoint(p, low) && !abovePoint(p, high);
		//if (high-low == 1) return
		Point2D crossPoint;
		int mid = (low + high)/2;		
		if (abovePoint(p, mid)) crossPoint = findCrossPoint(p, mid, high);
		else					crossPoint = findCrossPoint(p, low, mid);
		return crossPoint;
	}
	
	private Point2D getCrossPoint(Particle particle)
	{
		Point2D origin = new Point2D(0.0, 0.0);
		Comparator<Point2D> comparator = origin.polarOrder();
		Point2D minPoint = polygon[0];
		int minIndex = 0;
		for (int i = 1; i < N; i++)
			if (comparator.compare(polygon[i], minPoint) < 0) {
				minPoint = polygon[i];
				minIndex = i;
			}
		return findCrossPoint(particle, minIndex, minIndex+N);
	}
	
	private double calcCrossTime(Point2D crossPoint, Particle particle)
	{
		double time = 0.0;
		
		return time;
	}
	
	private double timeToHit(Particle particle)
	{
		Point2D crossPoint = getCrossPoint(particle);
		return calcCrossTime(crossPoint, particle);
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
