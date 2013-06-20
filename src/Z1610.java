import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

class Pointer {
	public int l;
	public int r;
	public int color;
	
	public Pointer(int l_in, int r_in, int color_in) {
		l = l_in;
		r = r_in;
		color = color_in;
	}
}

class TTree {
	public int[] nums = new int[8001];
	
	public void init() {
		nums = new int[8001];
		Arrays.fill(nums, -1);
		lptr = new LinkedList<Pointer>();
		lptr.add(new Pointer(0,8000,-1));
	}
	
	public int findleftPos(int l ) {
		int index = 0;
		Pointer pprev = null;
		for( Iterator<Pointer> i = lptr.iterator();i.hasNext();) {
		
			Pointer p = i.next();
			
			if ( p.l > l) return index; 
			index++;
			
		}
		
		return index;
	}
	
	public void paint(int l, int r, int color) {
		int index = findleftPos(l) - 1;
		
		for ( ;index < lptr.size();) {
			Pointer p = lptr.get(index);
			if ( p.color == color) {
				// Left string is fully covered
				p.r = r;
				for( int k = index+1;k < lptr.size();) {
					Pointer p2 = lptr.get(k);
					if ( p2.r <= r ) {
						lptr.remove(k);
						continue;
					}
					p2.l = r+1;
					
				}
			} else if (p.l < l ){
				
				p.r = l-1;
				lptr.add(index+1, new Pointer(l,r,color));
				for( int k = index+2;k<lptr.size();) {
					Pointer p2 = lptr.get(k);
					if ( p2.r <= r ) {
						lptr.remove(k);
						continue;
					}
					p2.l = r+1;
				}
			}
		}
	}
	
	private List<Pointer> lptr = null;
	
	public void printpaint() {
		int[] is = new int[8001];
		for( int i = 0;i < lptr.size();i++) {
			Pointer p = lptr.get(i);
			if ( p.color == -1 ) continue;
			is[p.color]++;
		}
		
		for( int i = 0;i < 8001;i++) {
			if ( is[i] != 0) {
				System.out.println("" + i + " " + is[i]);
			}
		}
	}
}

// public class Main
public class Z1610 {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		
		TTree tree = new TTree();
		
		boolean ini = false;
		while (in.hasNextInt()) {
			if ( ini ) System.out.println();
			ini = true;
			int n = in.nextInt();
			tree.init();
			for(int i = 0;i < n;i ++ ){
				int a = in.nextInt();
				int b = in.nextInt();
				int c = in.nextInt();
				tree.paint(a,b,c);
			}
			tree.printpaint();
			
			//System.out.println(a + b);
		}
	}
}


