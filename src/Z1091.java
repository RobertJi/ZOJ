import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

// public class Main
public class Z1091 {
	
	private static int m[][]; 
	
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		while (in.hasNextLine()) {
			init();
			String  s = in.nextLine().trim();
			int x1 = s.charAt(0) - 'a';
			int y1 = s.charAt(1) - '1';
			int x2 = s.charAt(3) - 'a';
			int y2 = s.charAt(4) - '1';
			
			List<Integer> ll = new ArrayList<Integer>();
			m[x1][y1] = 2;
			ll.add(x1*8+y1);
			int cc = 0;
			while ( m[x2][y2] == -1 ) {
				List<Integer> another = new ArrayList<Integer>();
				cc++;
				for ( int i = 0;i < ll.size();i++) {
					int a = ll.get(i);
					int x = a / 8;
					int y = a % 8;
					if ( (x >= 2) && (y >= 1) ) 
						{ m[x-2][y-1] = 2; another.add( (x-2)*8+y-1  );}
					if ( (x >= 1) && (y >= 2) ) 
						{ m[x-1][y-2] = 2; another.add( (x-1)*8+y-2  );}
					if ( (x < 6) && (y >= 1) ) 
						{ m[x+2][y-1] = 2; another.add( (x+2)*8+y-1  );}
					if ( (x < 7) && (y >= 2) ) 
						{ m[x+1][y-2] = 2; another.add( (x+1)*8+y-2  );}
					if ( (x >= 2) && (y < 7) ) 
						{ m[x-2][y+1] = 2; another.add( (x-2)*8+y+1  );}
					if ( (x >= 1) && (y < 6) ) 
						{ m[x-1][y+2] = 2; another.add( (x-1)*8+y+2  );}
					if ( (x < 6) && (y < 7) ) 
						{ m[x+2][y+1] = 2; another.add( (x+2)*8+y+1  );}
					if ( (x < 7) && (y < 6) ) 
						{ m[x+1][y+2] = 2; another.add( (x+1)*8+y+2  );}
				}
				ll = another;
			}
			System.out.println("To get from " + s.substring(0,2) + " to " + s.substring(3, 5) + " takes " + cc + " knight moves.");
		}
	}
	
	private static void init() {
		m = new int[8][];
		for ( int i = 0;i < 8;i++) {
			m[i] = new int[8];
			for(int j =0;j < 8;j++) {
				m[i][j] = -1;
			}
		}
	}
}


