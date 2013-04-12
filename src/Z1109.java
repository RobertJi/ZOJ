import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

// public class Main
public class Z1109 {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		Map<String, String> mm = new HashMap<String,String>();
		
		for(;;) {
			String s = in.nextLine().trim();
			if (s.isEmpty()) break;
			String s1 = s.substring(0,s.indexOf(' '));
			String s2 = s.substring(s.indexOf(' ')+1);
			mm.put(s2, s1);
		}		
		
		while (in.hasNextLine()) {
			String s = in.nextLine().trim();
			String kk = mm.get(s);
			if ( kk == null) System.out.println("eh");
			else System.out.println(kk);
		}
	}
}


