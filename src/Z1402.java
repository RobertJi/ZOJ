import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

// public class Main
public class Z1402 {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		while (in.hasNextLine()) {
			String s = in.nextLine();
			if ( s.equals("0")) break;
			int m = s.charAt(0) - '0';
			int m2 = s.charAt(1) - '0';
			int start = 0;
			if ( (m2 >= 0) && (m2 < 10) ) { m = m*10+m2; start=1;}
			List<Integer> li = new ArrayList<Integer>();
			int sum=0;
			for(int i = 0;i < m;i++) {
				int n = s.charAt(i*2+2+start)-'0';
				li.add(n);
				sum += n;
			}
			
			if ( (sum % 2) != 0  ) {
				System.out.println("No equal partitioning.");
				continue;
			}
			

			int resulti = -1;
			int ss = 0;
			for( int i = 0;i < m;i++) {
				
				
				ss += li.get(i);
				if ( ss == (sum/2) ) {
					resulti = i;
					break;
				}
				if ( ss > (sum/2) ) break;
			}
			
			if ( resulti != -1 ) {
				System.out.println("Sam stops at position " + (resulti+1) + " and Ella stops at position " + (resulti+2) +".");
			} else {
				System.out.println("No equal partitioning.");
			}
		}
	}
}


