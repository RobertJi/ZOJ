import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;


class Man implements Comparable{
	public String name;
	public Integer weight;
	
	@Override
	public int compareTo(Object other) {
		if ( other == null ) return 0;
		if ( this == other ) return 0;
		Man otherMan = (Man)other;
		return otherMan.weight.compareTo(weight);
	}
	
	@Override
	public String toString() {
		return name;
	}
	
	public Man(String n, int w) {
		name = n;
		weight = w;
	}
}
// public class Main
public class Z1431 {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		List<Man> lm = new ArrayList<Man>();
		boolean p = false;
		while (in.hasNextLine()) {

			String s = in.nextLine();
			if ( s.equals("START")) {
				if ( p == true) 
				{
					System.out.println();
					
				}
				p = true;
				continue;
			}
			if ( s.equals("END")) {
				Collections.sort(lm);
				for( Man m : lm) {
					System.out.println(m);
				}

				lm = new ArrayList<Man>();
				continue;
			}
			String n = "";
			int w = 0;
			int l = 0;
			int i ;
			for( i =0;i < s.length();i++) {
				char c = s.charAt(i);
				if ( c != ' ') n+=c; 
				else { i++; break; }
			}
			
			for( ;i < s.length();i++) {
				char c = s.charAt(i);
				if ( c != ' ') w=w*10+c-'0';
				else { i++; break; };
			}
			
			for( ;i < s.length();i++) {
				char c = s.charAt(i);
				if ( c != ' ') l=l*10+c-'0';
				else {  break; };
			}
			lm.add(new Man(n,l-w));
		}
	}
}


