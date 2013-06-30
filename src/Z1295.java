import java.util.Scanner;

// public class Main
public class Z1295 {
	public static void main(String[] args) {
		int n ;
		
		Scanner in = new Scanner(System.in);
		n = in.nextInt();
		in.nextLine();
		for(int i = 0;i < n;i++) {
			String s = in.nextLine();
			char c[] = s.toCharArray();
			for(int j = c.length-1;j>=0;j--) {
				System.out.print(c[j]);
			}
			System.out.println();
		}
	}
}


