import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

class SC implements Comparator<String> {
	@Override
	public int compare(String arg0, String arg1) {
		// TODO Auto-generated method stub
		return arg0.toLowerCase().compareTo(arg1.toLowerCase());
	}
}

// public class Main
public class Z1225 {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		while (in.hasNextLine()) {
			String s = in.nextLine();
			if ( s.equals(".")) break;
			List<String> ls = new ArrayList<String>();
			List<Integer> li = new ArrayList<Integer>();
			List<Boolean> lb = new ArrayList<Boolean>();
			StringBuilder sb = new StringBuilder();
			boolean firstFlag = true;
			boolean isNum = true;
			for ( int i = 0;i<s.length();i++) {
				char c = s.charAt(i);
				if ( (c == ',') || (c=='.') ) {
					i++;
					lb.add(isNum);
					if ( isNum ) {
						li.add(Integer.valueOf(sb.toString()));
					} else {
						ls.add(sb.toString());
					}
					sb = new StringBuilder();
					firstFlag = true;
					isNum = true;
					continue;
				}
				
				/// IS Num?
				if ( firstFlag ) {
					if ( (c =='-') || (c >= '0' && c <= '9') ) {  }
					else { isNum = false; }
				} else {
					if (  (c >= '0') && (c <= '9') ) {  }
					else { isNum = false; }
				}
				firstFlag = false;
				
				sb.append(c);
			}
	
			Collections.sort(ls,new SC());
			Collections.sort(li);
			
			int ii = 0;
			int kk = 0;
			for( int i = 0;i < lb.size();i++) {
				if ( i != 0 ) {
					System.out.print(", ");
				}
				
				Boolean b = lb.get(i);
				if (b.booleanValue()) {
					System.out.print(li.get(ii));
					ii++;
				} else {
					System.out.print(ls.get(kk));
					kk++;
				}
			}
			System.out.println(".");
			
		}
	}
}


