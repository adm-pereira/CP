public class approxPi {

	private static int nPoints, radius, nInside;
	private static float approxPi;
	
	public static void main(String[] args) {
		nPoints = Integer.parseInt(args[0]);
		nInside = 0;
		radius = 1;
		monteCarlo();
	}

	private static void monteCarlo() {
		for (int i = 0; i < nPoints; i++) {
			double[] point = new double[2];
			// doesnt matter that the point is always positive
			//because circunference is both x and y simetrical
			Double x = Math.random();
			Double y = Math.random();
			point[0] = x; point[1] = y;
			if (x*x + y*y <= radius*radius) {
				//inside circle
				nInside++;
			} else {
				//outside circle
			}
		}
		float rho = ((float)nInside)/((float)nPoints);
		approxPi = 4*rho;
		System.out.println("Total Number of points: " + nPoints);
		System.out.println("Points within the circle: " + nInside);
		System.out.println("Pi estimation: "+ approxPi);
	}


}
