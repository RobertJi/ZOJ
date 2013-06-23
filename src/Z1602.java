import java.util.Scanner;

// public class Main
public class Z1602 {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		while (in.hasNextInt()) {
			int n = in.nextInt();
			int a[] = new int[n];
			for( int i = 0;i < n;i++ ) {
				a[i] = in.nextInt();
			}
			
			int b[][] = new int[n+1][n+1];
			
			
			for( int k = 2;k <= n;k++) {
				for( int i = 0;i < n-k;i++ ) {
					int nn = i + k;
					b[i][nn] = Integer.MAX_VALUE;
					for( int j = i+1 ; j < nn;j++) {
						int tmp = b[i][j] + b[j][nn] + a[i]*a[j]*a[nn];
						if (tmp < b[i][nn]) b[i][nn] = tmp;
					}
				}
			}
			
			System.out.println(b[0][n-1]);
		}
	}
}


