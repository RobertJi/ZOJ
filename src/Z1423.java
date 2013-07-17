import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;
import java.util.Set;

// public class Main
public class Z1423 {
	
	public static String pre(String s) {
		while( s.charAt(0) == '+') {
			s =s.substring(1);
		}
		
		s = s.replace("(+", "(");
		
		while(true) {
			boolean d = true;
			for( int i = 0;i < s.length();i++) {
				char c = s.charAt(i);
				if ( (c=='(') && (s.charAt(i+2) == ')') ) {
					s = s.substring(0, i) + s.charAt(i+1) + s.substring(i+3);
					d = false;
					break;
				}
			}
			
			
			if ( d ) break;
		}

		while(true) {
			boolean d = true;
			for( int i = 0;i < s.length();i++) {
				char c = s.charAt(i);
				if ( (c=='(') && (s.charAt(i+1)=='(')&& (s.charAt(i+4) == ')') && (s.charAt(i+5) == ')') ) {
					String s1 = s.substring(0,i+1);
					char c2 = s.charAt(i+2);
					char c3 = s.charAt(i+3);
					String s2 = s.substring(i+5);
					s = s.substring(0, i+1) + s.charAt(i+2) + s.charAt(i+3) + s.substring(i+5);
					d = false;
					break;
				}
			}
			
			
			if ( d ) break;
		}

		return s;
	}
	
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		in.nextLine();
		for( int aa = 0;aa < n ;aa++) {
			String s = in.nextLine();
			s=s.replaceAll(" ", "");
			
			s=pre(s);
			
			// State Machine
			List<Integer> dl = new ArrayList<Integer>(s.length());
			List<Integer> dr = new ArrayList<Integer>(s.length());
			List<Integer> db = new ArrayList<Integer>(s.length());
			List<Boolean> dw = new ArrayList<Boolean>(s.length());
			//Deque<Integer> dbr = new ArrayDeque<Integer>(s.length());
			int state = -1;
			boolean bflag = true; // ), false (
			boolean vflag = true; // fuhao inside ()?
			// state = 0 means no need to add a (
			// state = 1 means need to add a (
			// 
			Set<Integer> si = new HashSet<Integer>();

			
			for( int i = 0;i < s.length();i++) {
				char c = s.charAt(i);
				if ( c == '+' || c== '-') {
					vflag = true;
				}
				
				if ( (c == '+') && (s.charAt(i-1) == '(' ) ) {
					si.add(i);
				}
				if( c == '(') {
					vflag = false;
					dl.add(i);
					state = -1;
					//if ( s.charAt(i+1) == '(' ) state =-1; // 重复的括号
					if ( (i != 0) && (s.charAt(i-1)=='-' ) ) {
						String subs = s.substring(i);
						
						if (subs.contains("-") || subs.contains("+") ) state = 1;
					}
					if ( s.charAt(i+1) == '-' ) state =1; // 括号为负数
					
					
					db.add(state);
					dw.add(false);
					bflag = false;
				}
				
				if ( c == ')') {
					if ( bflag) { // last bracket is )
						for( int k = dw.size()-1;k>=0;k--) {
							if( !dw.get(k) ) {
								dw.set(k, true);
								dr.add(k);
								break;
							}
						}
						
						
					} else {
						dr.add(dl.size()-1 );
						dw.set(dw.size()-1, true);
					}
					bflag = true;
				}
			}
			
			int sl = 0;
			int sr = 0;
			for ( int i = 0;i < s.length();i++) {
				char c = s.charAt(i); 
				switch(c) {
				case '(': if ( db.get(sl) == 1 ) {
							System.out.print(c);
							}
				          sl++; break;
				case ')' : if ( db.get( dr.get(sr) )== 1 ) {
						  System.out.print(c);
						   }
				          sr++;break;
				case ' ' : break;
				default: if ( !si.contains( i ) )System.out.print(c);
				 
				}
			}
			System.out.println();
		}
	}
}


