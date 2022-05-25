package ds_week02;

public class Factorial {
	public static int factorial(int num) {
		if(num==1) return 1;
		else return num*factorial(--num);
	}

	public static void main(String[] args) {
		System.out.println(factorial(4));

	}

}
