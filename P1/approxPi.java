import java.lang.Thread;
import java.util.concurrent.ThreadLocalRandom;

public class approxPi {

	private static int nPoints, radius, nInside, nThreads;
	private static float approxPi;
	
	public static void main(String[] args) throws Exception {
		nPoints = Integer.parseInt(args[0]);
		nThreads = Integer.parseInt(args[1]);
		int nPointsLast = nPoints/nThreads + nPoints % nThreads;
		nInside = 0;
		radius = 1;
		Thread[] threads = new Thread[nThreads];
		for (int i = 0; i < nThreads; i++) {
			Thread thrd;
			if (i+1 == nThreads) {
				thrd= new Thread(new threadProgram(nPointsLast));
			} else {
				thrd= new Thread(new threadProgram(nPoints/nThreads));
			}
			threads[i] = thrd;
			thrd.start();
		}
		
		for (int i = 0; i < nThreads; i++) {
			threads[i].join();
		}
		monteCarlo();
	}

	static class threadProgram implements Runnable {

		private int points;

		public threadProgram(int points) {
			this.points = points;
		}

		public void run() {
			for (int i = 0; i < points; i++) {
				double[] point = new double[2];
				// doesnt matter that the point is always positive
				//because circunference is both x and y simetrical
				Double x = ThreadLocalRandom.current().nextDouble();
				Double y = ThreadLocalRandom.current().nextDouble();
				point[0] = x; point[1] = y;
				if (x*x + y*y <= radius*radius) {
					//inside circle
					nInside++;
				} else {
					//outside circle
				}
			}
		}
	}

	private static void monteCarlo() {
		float rho = ((float)nInside)/((float)nPoints);
		approxPi = 4*rho;
		System.out.println("Total Number of points: " + nPoints);
		System.out.println("Points within the circle: " + nInside);
		System.out.println("Pi estimation: "+ approxPi);
	}


}
