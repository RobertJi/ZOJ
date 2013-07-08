import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

class Q {
	public double x1;
	public double x2;
	public double y1;
	public double y2;
}

// public class Main
public class Z1128 {
	public static final double diff = 1e-5;
	
	public static boolean eq(double a,double b) {
		if (  (a > (b-diff)) && ( a < (b+diff)) ) {
			return true;
		}
		return false;
	}
	
	public static int eqm ( List<Double> l, double a) {
		for( int i = 0;i < l.size();i++) {
			if ( eq(l.get(i), a)) return i;
		}
		return -1;
	}
	
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int cc = 0;
		while (in.hasNextInt()) {
			cc++;
			int n = in.nextInt();
			if ( n == 0 ) break;
			
			int[][] nn = new int[3*n][3*n];
			List<Q> lq = new ArrayList<Q>();
			
			List<Double> lx = new ArrayList<Double>();
			List<Double> ly = new ArrayList<Double>();
			
			for( int i = 0;i < n;i++) {
				Q q = new Q();
				q.x1 = in.nextDouble();
				q.y1 = in.nextDouble();
				q.x2 = in.nextDouble();
				q.y2 = in.nextDouble();
				lx.add(q.x1);
				lx.add(q.x2);
				ly.add(q.y1);
				ly.add(q.y2);
				lq.add(q);
			}

			Collections.sort(lx);
			Collections.sort(ly);
			for( int i = 0;i < n;i++) {
				Q q = lq.get(i);
				// x1 < x2, y1 < y2, guaranteed
				int x1 = eqm(lx, q.x1);
				int x2 = eqm(lx, q.x2);
				int y1 = eqm(ly, q.y1);
				int y2 = eqm(ly, q.y2);
				
				for ( int k = x1; k < x2;k++) {
					for ( int j = y1; j < y2;j++) {
						nn[k][j] = 1;
					}
				}
			}
			
			double area = 0;
			for ( int i = 0;i < nn.length;i++) {
				for( int k = 0;k < nn[i].length;k++) {
					if ( nn[i][k] == 1 ) {
						area += (lx.get(i+1) - lx.get(i)) * (ly.get(k+1) - ly.get(k));
					}
				}
			}
			System.out.println("Test case #" + cc);
			System.out.println("Total explored area: " + String.format("%.2f",area));
			System.out.println();
			
		}
	}
}


