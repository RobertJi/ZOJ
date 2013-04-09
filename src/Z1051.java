import java.util.Scanner;

// public class Main
public class Z1051 {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int a = in.nextInt();
		int d[] = new int[16];
		int n[][] = new int[20][];
		for ( int i = 0;i < a;i++) {
			if ( i != 0) System.out.println();
			int b = in.nextInt();
			for ( int j = 0;j < 16;j++) {
				d[j] = in.nextInt();
			}
			for ( int k1 = 0;k1 < 20;k1++) {
				n[k1] = new int[20];
				for(int k2 = 0;k2 < 20;k2++) {
					n[k1][k2] = in.nextInt();
				}
			}
			
			
			for (int day = 0;day < b;day++) {
				int p[][] = new int[20][];
				for ( int k1 = 0;k1 < 20;k1++) {
					p[k1] = new int[20];
					for(int k2 = 0;k2 < 20;k2++) {
						int east = (k2==19)?0:n[k1][k2+1];
						int west = (k2==0)?0:n[k1][k2-1];
						int south = (k1==19)?0:n[k1+1][k2];
						int north = (k1==0)?0:n[k1-1][k2];
						int sum = east+west+south+north+n[k1][k2];
						int temp = n[k1][k2] + d[sum];
						if ( temp > 3) temp=3;
						if (temp < 0) temp=0;
						p[k1][k2] = temp;
					}
				}	
				
				for ( int k1 = 0;k1 < 20;k1++) {
					
					for(int k2 = 0;k2 < 20;k2++) {
						n[k1][k2] = p[k1][k2];
					}
				}	
			}
			
			for (int k1= 0;k1<20;k1++) {
				for(int k2=0;k2<20;k2++) {
					switch (n[k1][k2]) {
					case 0: System.out.print("."); break;
					case 1: System.out.print("!"); break;
					case 2: System.out.print("X"); break;
					case 3: System.out.print("#"); break;
					default:;
					}
					
				}
				System.out.println();
			}
		}
		
	}
}


