import java.util.Scanner;

// public class Main
public class Z1048 {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		double bal = 0;
		while (in.hasNextDouble()) {
			bal = 0;
			for ( int i = 0;i < 12;i++) {
				double a = in.nextDouble();
				bal += a;
				
			}
			bal /= 12;
			System.out.println("$" + String.format("%.2f", bal));
			
		}
	}
}


