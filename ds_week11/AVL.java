package ds_week11;

import java.util.LinkedList;
import java.util.Queue;

public class AVL<Key extends Comparable<Key>, Value> {
	public Node root;
	
	private Node rotateRight(Node n) {
		Node x = n.left;
		n.left = x.right;
		x.right = n;
		
		n.height = tallerHeight(height(n.left), height(n.right)) +1;
		x.height = tallerHeight(height(x.left), height(x.right)) +1;
		
		return x;
	}
	
	// 오른쪽이 더 높앗
	private Node rotateLeft(Node n) {
		Node x = n.right;
		n.right = x.left;
		x.left = n;
		
		n.height = tallerHeight(height(n.left), height(n.right)) +1;
		x.height = tallerHeight(height(x.left), height(x.right)) +1;
		
		return x;
	}
	
	public void put(Key k, Value v) { root = put(root, k, v); }
	
	private Node put(Node n, Key k, Value v) {
		if (n==null) return new Node(k, v, 1);
		
		int t = k.compareTo((Key)n.id);
		if (t<0) n.left=put(n.left, k, v);
		else if (t>0) n.right= put(n.right, k, v);
		else { 
			n.name=v; return n; 
		}
		n.height = tallerHeight(height(n.left), height(n.right))+1;
		
		return balance(n);
	}
	
	private Node balance(Node n) {
		
		if (bf(n)>1) {
			if (bf(n.left)<0) {
				n.left = rotateLeft(n.left);
			}
			n = rotateRight(n);
		}
		else if (bf(n)<-1) {
			if (bf(n.right)>0) {
				n.right= rotateRight(n.right);
			}
			n = rotateLeft(n);
		}
		return n;
	}
	

	private int bf(Node n) {
		return height(n.left) - height(n.right);
	}
	
	public int height(Node n) {
		if (n==null) return 0;
		return n.height;
	}
	
	private int tallerHeight(int x, int y) {
		if (x>y) return x;
		else return y;
	}
	
	// 삭제연산
	public void delete(Key k) { root = delete(root, k); }
	
	private Node delete(Node n, Key k) {
		if (n==null) return null;
		int t = k.compareTo((Key)n.id);
		
		if(t<0) n.left = delete(n.left, k);
		else if (t>0) n.right = delete(n.right, k);
		else {
			if (n.left==null) return n.right;
			else if (n.right==null) return n.left;
			else {
			Node target = n;
			n = min(target.right);
			n.right = deleteMin(target.right);
			n.left = target.left;
			}
		}
		n.height = tallerHeight(height(n.left), height(n.right)) +1;
		return balance(n);
	}
	
	public void deleteMin() {
		if (root==null) System.out.println("empty 트리");
		root = deleteMin(root);
	}
	
	public Node deleteMin(Node n) {
		if(n.left==null) return n.right;
		
		n.left = deleteMin(n.left);
		n.height = tallerHeight(height(n.left), height(n.right)) + 1;
		
		return balance(n);
	}
	
	public Key min() {
		if (root==null) return null;
		return (Key) min(root).id;
	}
	
	public Node min(Node n) {
		if(n.left==null) return n;
		return min(n.left);
	}
	
	public void print(Node root) {
		System.out.printf("\ninorder:\n");
		inorder(root);
		
		System.out.printf("\npreorder:\n");
		preorder(root);
		
		System.out.printf("\nlevel order:\n");
		levelorder(root);
	}
	
	// 전위 순회
	public void preorder(Node n) {
		if (n != null) {
			System.out.print(n.id+" "); // 노드 n 방문
			preorder(n.left);
			preorder(n.right);
		}
	}
		
	// 중위 순회
	public void inorder(Node n) {
		if (n != null) {
			inorder(n.left);
			System.out.print(n.id+" ");
			inorder(n.right);
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
			System.out.print(t.id+" ");
			
			if (t.left != null) q.add(t.left);
			if (t.right != null) q.add(t.right);
		}
	}

}
