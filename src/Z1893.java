import java.util.Scanner;

// public class Main
public class Z1893 {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		while (in.hasNextInt()) {
			int a = in.nextInt();
			int k = 0;
			while( a > 18  ) {
				if ( (a % 18) == 0 ) {
					a /= 18;					
				} else {
					a /= 18;
					a++;
				}
			}
			
			if ( a <= 9 ) {
				System.out.println("Stan wins.");
			} else {
				System.out.println("Ollie wins.");
			}
		}
	}
}


