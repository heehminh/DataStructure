// 자료구조 과제#5 (60200860 김민희)
package ds_week07;
import java.util.*;

public class BinaryTree<Key extends Comparable<Key>> {
	private Node root;
	
	public BinaryTree() { root=null; }
	
	public Node getRoot() { return root; }
	public void setRoot(Node newRoot) { root=newRoot; }
	
	public boolean isEmpty() { return root==null; }
	
	// 전위 순회
	public void preorder(Node n) {
		if (n != null) {
			System.out.print(n.getKey()+" "); // 노드 n 방문
			preorder(n.getLeft());
			preorder(n.getRight());
		}
	}
	
	// 중위 순회
	public void inorder(Node n) {
		if (n != null) {
			inorder(n.getLeft());
			System.out.print(n.getKey()+" ");
			inorder(n.getRight());
		}
	}
	
	// 후위 순회
	public void postorder(Node n) {
		if (n != null) {
			postorder(n.getLeft());
			postorder(n.getRight());
			System.out.print(n.getKey()+" ");
		}
	}
	
	// 레벨 순회
	public void levelorder(Node root) {
		// 큐 자료구조 이용
		Queue<Node> q = new LinkedList<Node>();
		Node t;
		
		q.add(root); // 루트 노드를 큐에 삽입
		while (!q.isEmpty()) {
			t=q.remove(); // 큐의 맨앞노드제거
			System.out.print(t.getKey()+" ");
			
			if (t.getLeft() != null) q.add(t.getLeft());
			if (t.getRight() != null) q.add(t.getRight());
		}
	}
	// size(후위순회), height(후위순회), isEqual 메소드 추가
	// n을 루트로 하는 (서브)트리의 노드 수
	public int size(Node n) {
		if (n==null) return 0;
		else return (1+size(n.getLeft())+size(n.getRight()));
		// 1+root노드의 left subtree에 있는 노드수+right subtree에 있는 노드수
	}
	
	// n을 루트로 하는 (서브)트리의 높이
	public int height(Node n) {
		if (n==null) return 0;
		else return (1+Math.max(height(n.getLeft()), height(n.getRight())));
	}
	
	public static boolean isEqual(Node n, Node m) {
		// 둘다 null이면 true, 아니면 false
		if (n==null || m==null) return n==m; //true
		
		// 둘다 null이 아니면 item 비교
		if (n.getKey().compareTo(m.getKey()) != 0) return false;
		
		// itme이 같으면 왼쪽/오른쪽 자식으로 재귀호출
		return (isEqual(n.getLeft(), m.getLeft()) && 
				isEqual(n.getRight(), m.getRight()));
	}
	
	// 복사 
	public static Node copyTree(Node root) {
//		if (root == null) return null;
//		
//		Node newTree = new Node(root.getKey(), root.getLeft(), root.getRight());
//		
//		return newTree;	
		
		Node left, right;
		if(root==null) return null;
		else {
			left = copyTree(root.getLeft());
			right = copyTree(root.getRight());
			return new Node(root.getKey(), left, right);
		}
	}
	
	// 이진탐색: 5장 탐색트리
	public static int binarySearch(int[] a, int first, int last, int target) {
		if (first > last) return -1; // 탐색 실패(target)이 없음
		
		int mid = (first+last)/2; // 배열에서 탐색할 중간 원소의 인덱스 계산
		
		if (a[mid] == target) return mid;
		else if (a[mid]>target) return binarySearch(a, first, mid-1, target);
		else return binarySearch(a, mid+1, last, target);
	}
}
