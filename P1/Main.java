import java.io.*;
import java.util.Scanner;

public class Main {

	private static int nPoints;
	
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		
		console(in);
	}

	private static void console(Scanner in) {
		String line = in.nextLine();
		String[] vLine = line.split(" ");
		
		switch(vLine[0]) {
			case "approxPi":
				nPoints = Integer.parseInt(vLine[1]);
				monteCarlo();
			break;
			case "time":
				nPoints = Integer.parseInt(vLine[2]);
				monteCarlo();
				timeStats();
			break;
			default:
				System.out.println("Comando inválido!");
			break;
		}
	}

	private static void monteCarlo() {
		//todo
	}

	private static void timeStats() {
		//todo
	}


}