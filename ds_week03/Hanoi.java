// 자료구조 과제 #1 (60200860 김민희)
package ds_week03;

public class Hanoi {
	public static void move(int n, char from, char mid, char to) {
		if(n==1)
			System.out.println("원반 "+n+"을 "+from+"에서 "+to+"로 이동"); 
		else {
			move(n-1, from, to, mid);
			System.out.println("원반 "+n+"을 "+from+"에서 "+to+"로 이동"); 
			move(n-1, mid, from, to);
		}
	}

	public static void main(String[] args) {
		System.out.println("원반이 3개인 경우");
		System.out.println("원반 이름:크기가 작은-큰 순서 1 2 3\n");
		move(3, 'A', 'B', 'C');
		
		System.out.println("\n원반이 4개인 경우");
		System.out.println("원반 이름:크기가 작은-큰 순서 1 2 3 4\n");
		move(4, 'A', 'B', 'C');
		

	}

}
