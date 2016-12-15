import edu.princeton.cs.algs4.StdDraw;


public class Glass
{
	private double[] polygonX;
	private double[] polygonY;	
	private int N;
	
	public Glass()
	{
		N = 8;
		polygonX = new double[N];
		polygonY = new double[N];
		polygonX[0] = 0.5-0.3;  polygonX[1] = 0.5+0.3;
		polygonX[2] = 0.5+0.05; polygonX[3] = 0.5+0.05;
		polygonX[4] = 0.5+0.3;  polygonX[5] = 0.5-0.3;
		polygonX[6] = 0.5-0.05; polygonX[7] = 0.5-0.05;

		polygonY[0] = 0.5+0.3;  polygonY[1] = 0.5+0.3;
		polygonY[2] = 0.5+0.05; polygonY[3] = 0.5-0.05;
		polygonY[4] = 0.5-0.3;  polygonY[5] = 0.5-0.3;
		polygonY[6] = 0.5-0.05; polygonY[7] = 0.5+0.05;	
	}
	
	void rotate(double angle)
	{
		double cos = Math.cos(angle);
		double sin = Math.sin(angle);
		
		for (int i = 0; i < N; i++) {
			double x = cos*polygonX[i] - sin*polygonY[i]; 
			double y = cos*polygonY[i] + sin*polygonX[i];
			polygonX[i] = x;
			polygonY[i] = y;
		}
	}
	
	void draw()
	{
		StdDraw.setPenColor();
		StdDraw.polygon(polygonX, polygonY);
	}
}
