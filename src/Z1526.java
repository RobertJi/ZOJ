import java.util.Scanner;

// public class Main
public class Z1526 {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		for( int i = 0;i < n;i++) {
			int a = in.nextInt();
			double h=1;
			int c = 1;
			for( int k = 2;k <= a;k++) {
				h*=k;
				while( h > 10 ) {
					h/=10;
					c++;
				}
			}
			System.out.println(c);
			
		}
	}
}


