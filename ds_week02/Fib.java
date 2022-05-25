package ds_week02;

public class Fib {
	// 방법(1) recursive
	public static int fib(int n) {
		if (n==0) return 0;
		else if (n==1) return 1;
		else return fib(n-2) + fib(n-1);
	}
	
	// 방법(2)
	public static int fib_iter(int n) {
		if (n<2) return n;
		else {
			int last = 0;
			int current = 1;
			for (int i=2; i<n+1; i++) {
				int tmp = current;
				current += last;
				last = tmp;
			} return current;
		}
	}

	public static void main(String[] args) {
		System.out.println(fib(7));
		
		System.out.println(fib_iter(7));

	}

}
