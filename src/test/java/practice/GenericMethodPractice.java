package practice;

public class GenericMethodPractice {
	//ts1
	public static void main(String[] args) { //caller function
		
		int sum = add(10,20);
		System.out.println(sum);
		System.out.println(add(sum,30));
		System.out.println(add(30,40));
		System.out.println(add(40,sum));
		
		int res = add(30, 50);
		System.out.println(res);
		
		
		
	}//100 ts - addition

	public static int add(int a, int b) //Called function - generic - resuable
	{
		int c = a+b;
		return c;
	}
}
