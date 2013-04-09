import java.util.Scanner;

// public class Main
public class Z3693 {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		while (in.hasNextInt()) {
			int a = in.nextInt();
			double b = in.nextDouble();
			int c = in.nextInt();
			
			int people = a + 2;
			int mian = people / c;
			double yuan = b*(people-mian);
			double d = yuan / 2;
			System.out.println(String.format("%.2f", d));
		}
	}
}


