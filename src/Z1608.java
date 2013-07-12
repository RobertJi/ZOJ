import java.util.Scanner;

// public class Main
public class Z1608 {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		while (in.hasNextDouble()) {
			double a = in.nextDouble();
			double b = in.nextDouble();
			double r1 = in.nextDouble();
			double r2 = in.nextDouble();
			
			double mm = a > b ? b : a;
			if ( (r1*2 > mm) || (r2*2 > mm) ) {
				System.out.println("No");
				continue;
			}
			
			double p1 = a-r2;
			double p2 = b-r2;
			
			double dis = Math.pow(   ((p1 - r1) * (p1-r1) + (p2-r1) * (p2-r1)), 0.5);
			if ( dis + 0.01 > r1+r2  ) {
				System.out.println("Yes");
			} else {
				System.out.println("No");
			}
		}
	}
}


