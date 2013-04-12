import java.util.Scanner;

// public class Main
public class Z1093 {
	
	static int a = 0;
	static int x[];
	static int y[];
	static int z[];
	
	static int x1[];
	static int y1[];
	static int z1[];
	
	static int cc=0;
	
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int ca = 0;
		while (in.hasNextInt()) {
			ca++;
			a = in.nextInt();
			if ( a == 0 ) break;
			x = new int[a * 3];
			y = new int[a * 3];
			z = new int[a * 3];
			
			for ( int i = 0;i < a;i++) {
				int m1 = in.nextInt();
				int m2 = in.nextInt();
				int m3 = in.nextInt();
				
				x[i*3] = m1;x[i*3+1] = m2;x[i*3+2] = m3;
				y[i*3] = m2;y[i*3+1] = m3;y[i*3+2] = m1;
				z[i*3] = m3;z[i*3+1] = m1;z[i*3+2] = m2;
			}
			
			for ( int i = 0;i < a*3;i++) { 
				if ( x[i] < y[i] ) {
					int temp = x[i];
					x[i] = y[i];
					y[i] = temp;
				}
			}
			
			for ( int i = 0;i < a*3-1;i++) {
				for(int j = i+1;j < a*3;j++) {
					if (  (x[i] > x[j]) 
					      || ((x[i] == x[j])&&(y[i]>y[j] )) 
					      || ( (x[i]==x[j]) && (y[i]==y[j]) &&(z[i]>z[j])  ) 
					   )  {
						int sw1 = x[i];
						int sw2 = y[i];
						int sw3 = z[i];
						x[i] = x[j];
						y[i] = y[j];
						z[i] = z[j];
						x[j] = sw1;
						y[j] = sw2;
						z[j] = sw3;
					}
				}
			}
			
			cc = 1;
			x1 = new int[a * 3];
			y1 = new int[a * 3];
			z1 = new int[a * 3];
			x1[0] = x[0];
			y1[0] = y[0];
			z1[0] = z[0];
			for ( int i = 1;i < a*3;i++) {
				if ( (x[i] == x[i-1]) && (y[i] == y[i-1]) && (z[i] == z[i-1])  ) continue;
				else {x1[cc] = x[i];y1[cc] = y[i];z1[cc] = z[i];cc++;}
			}
			// End for Sorting
			
			int h[] = new int[cc];
			//for (int i = 0;i < cc;i++) {
				h[0] = z1[0];
			//}
			
			for ( int i = 1;i < cc;i++){
				int maxn = z1[i];
				for ( int j = 0;j < i;j++) {
					if ( (x1[i] > x1[j]) && (y1[i] > y1[j]) ) {
						int height = z1[i] + h[j];
						if ( height > maxn) maxn=height;
					}
				}
				h[i] = maxn;
			}
			
			int maxa = -1;
			for ( int i = 0;i < cc;i++)
			{
				if (h[i] > maxa) maxa=h[i];
			}
			
			System.out.println("Case " + ca + ": maximum height = " + maxa);
			// Start Searching...
//			int maxx = -1;
//			boolean flag = false;
//			for ( int i = 0;i < cc ;i++) 
//			{
//				for ( int kk = 0;kk<i;kk++) { 
//					if (y1[i] > y1[kk]) { flag = true; break;}
//					flag = false;
//				}
//				if ( flag ) break; 
//				int p = piter(0,i)+z1[i];
//				if ( p > maxx ) maxx = p;
//			}
//			System.out.println("Case " + ca + ": maximum height = " + maxx);
			
			// End Searching..
		}
	}
	
//	private static int piter(int sum, int n) {
//		if ( n == (cc-1) ) return sum;
//		int maxsum = sum;
//		for ( int i = n+1;i < cc;i++) {
//			int xsum = sum;
//			
//			if ( (x1[n] > x1[i]) && (y1[n] > y1[i]) ) {
//				xsum += z1[i] ;
//				xsum = piter(xsum,i);
//				if ( xsum > maxsum) maxsum = xsum;
//			}
//		}
//		return maxsum;
//	}
}


