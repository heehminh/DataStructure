package ds_week02;

public class Power {
	// 방법(1) 반복문 O(n) 16번
	public static int power_iter(int x, int n) {
		int result = 1;
		for (int i=0; i<n; i++) {
			result = result * x;
		} return result;
	}
	
	// 방법(2) recursive O(n)=log 2 n =4번
	public static int power(int x, int n) {
		if (n==0) return 1;
		// 짝수일때, 홀수일때 나눠서
		else if (n % 2 == 0) return power(x*x, n/2); 
		else return x*power(x*x, (n-1)/2);
	}

	public static void main(String[] args) {
		System.out.println(power_iter(2,9));
		System.out.println(power_iter(2,10));
		
		System.out.println(power(2,9));
		System.out.println(power(2,10));
	
	}

}
