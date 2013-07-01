import java.io.StringReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

// public class Main
public class Z1797 {
	
	public static long zuida(long a,long b) {
		if ( a < b ) {
			long c = a;
			a = b;
			b = c;
		}
		
		while ( (a % b) != 0 ) {
			long c = a % b;
			b = c;
			a = b;
		}
		return b;
	}
	
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		in.nextLine();
		for( int i = 0;i < n;i++) {
			String s = in.nextLine();
			Scanner in2 = new Scanner(new StringReader(s) );
			List<Long> ll = new ArrayList<Long>();
			long res = 1;
			while(in2.hasNextInt()) {
				int p = in2.nextInt();
				long zd = zuida(res,p);
				res = res/zd*p;
			}

			System.out.println(res);
		}
	}
}


