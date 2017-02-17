package ch06;

public class UseFigs
{
	public static void main(String[] args)
	{
		Circle c1 = new Circle(5);
		Circle c2 = new Circle(5);
		Circle c3 = new Circle(15);
		Circle c4 = null;
		
		System.out.println(c1 == c1);
		System.out.println(c1 == c2);
		System.out.println(c1 == c3);
		System.out.println(c1 == c4);
		System.out.println(c1.equals(c1));
		System.out.println(c1.equals(c2));
		System.out.println(c1.equals(c3));
		System.out.println(c1.equals(c4));				
	}
}