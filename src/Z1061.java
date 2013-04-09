import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

// public class Main
public class Z1061 {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		double bal = 0;
		List<String> ll = new ArrayList<String>();
		ll.add("http://www.acm.org/");
		int llptr = 0;
		int k = in.nextInt();
		in.nextLine();
		
		for (int i =0;i < k;i++) {
			in.nextLine();
			if ( i != 0 ) System.out.println();
			while (in.hasNextLine()) {
				String s = in.nextLine().trim();
				int slen = s.length();
				if ( slen == 0 ) break;
				
				if ( slen == 4) {
					if (s.equals("QUIT")) break;
					if ( s.equals("BACK")) {
						if ( llptr == 0 ) {
							System.out.println("Ignored");
						} else {
							llptr--;
							System.out.println(ll.get(llptr));
						}
					}
				}
				else if ( s.equals("FORWARD")) {
					if (llptr == (ll.size()-1) ) {
						System.out.println("Ignored");
					} else {
						llptr++;
						System.out.println(ll.get(llptr));
					}
				}	
				else if ( s.substring(0,5).equals("VISIT")) {
					String srest = s.substring(5).trim();
					int ss = ll.size();
					for (int j = llptr+1 ;j < ss;j++)
					{
						ll.remove(llptr+1);
					}
					ll.add(srest);
					llptr++;
					System.out.println(srest);
				}
			}
			ll = new ArrayList<String>();
			ll.add("http://www.acm.org/");
			llptr = 0;
		}
	}
}


