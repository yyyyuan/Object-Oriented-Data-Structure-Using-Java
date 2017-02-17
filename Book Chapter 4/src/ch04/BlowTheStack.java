package ch04;

public class BlowTheStack {
	private static void explode(int v) {
		System.out.println(v);
		explode(v+1);
	}
	
	public static void main(String[] args) {
		explode(1);
	}
}
