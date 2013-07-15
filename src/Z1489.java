import java.util.Scanner;

// public class Main
public class Z1489 {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		while (in.hasNextInt()) {
			int n = in.nextInt();
			if ( (n % 2) == 0 ) {
				System.out.println("2^? mod " + n + " = 1");
				continue;
			}
			
			long s = 1;
			boolean b = false;
			
			for( int i = 1;i <n;i++) {
				if ( (i * 2 % n) == 1) {
					b = true;
					break;
				}
			}
			
			if ( !b ) {
				System.out.println("2^? mod " + n + " = 1");
				continue;
			}
			
			b = false;
			int i = 0;
			while(true) {
				i++;
				s = s * 2 % n;
				if ( s  == 1) {
					System.out.println("2^" + i + " mod " + n + " = 1");
					b = true;
					break;
				}
			}
			
			if ( b) continue;
			System.out.println("2^? mod " + n + " = 1");
			
		}
	}
}


