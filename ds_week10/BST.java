package ds_week10;

import java.util.LinkedList;
import java.util.Queue;

public class BST<Key extends Comparable<Key>, Value> {
	public Node root;
	public Node getRoot() { return root; }
	
	public BST(Key newId, Value newName) {
		root = new Node(newId, newName);
	}

	// get, put, min, deleteMin, delete, deleteMax
	
	// 탐색연산 
	public Value get(Key k) { return get(root, k); }
	
	public Value get(Node n, Key k) {
		if (n==null) return null;
		
		int t = n.getKey().compareTo(k);
		
		if (t>0) // if(k<노드 n의 id) 왼쪽 서브 트리 탐색
			return get(n.getLeft(), k);
		else if (t<0) // if(k>노드n의 id) 오른쪽 서브 트리 탐색
			return get(n.getRight(), k);
		else // k를 가진 노드 발견
			return (Value) n.getValue();
	}
	
	// 삽입연산
	// 트리에 노드(k, v)를 삽입
	public void put(Key k, Value v) {
		root = put(root, k, v);
	}
	
	public Node put(Node n, Key k, Value v) {
		if (n==null) return new Node(k, v);
		
		int t = n.getKey().compareTo(k);
		
		if (t>0) n.setLeft(put(n.getLeft(), k, v));
		else if(t<0) n.setRight(put(n.getRight(), k, v));
		else n.setValue(v);
		
		return n;
	}
	
	// 최솟값 찾기
	public Key min() {
		if (root == null) return null;
		return (Key) min(root).getKey();
	}
	
	private Node min(Node n) {
		if (n.getLeft()==null) return n;
		return min(n.getLeft());
	}
	
	// 최솟값 삭제 연산
	public void deleteMin() {
		if (root==null) System.out.println("empty 트리");
		root = deleteMin(root);
	}
	
	public Node deleteMin(Node n) {
		// n의 왼쪽자식==null -> n의 오른쪽 자식 리턴 
		if(n.getLeft()==null) return n.getRight();
		
		n.setLeft(deleteMin(n.getLeft()));
		return n;
	}
	
	// 최댓값 삭제 연산
	public void deleteMax() {
		if (root==null) System.out.println("empty 트리");
		root = deleteMax(root);
	}
	
	public Node deleteMax(Node n) {
		// n의 오른쪽자식==null -> n의 왼쪽 자식 리턴 
		if(n.getRight()==null) return n.getLeft();
		
		n.setRight(deleteMax(n.getRight()));
		return n;
	}
	
	// 삭제 연산
	public void delete(Key k) {
		root = delete(root, k);
	}
	
	public Node delete(Node n, Key k) {
		if(n==null) return null;
		
		int t = n.getKey().compareTo(k);
		
		if(t>0) n.setLeft(delete(n.getLeft(), k));
		else if(t<0) n.setRight(delete(n.getRight(), k));
		// 삭제할 경우 
		else {
			if (n.getRight()==null) return n.getLeft(); // case0, 1
			if (n.getLeft()==null) return n.getRight(); // case 1
			
			Node target = n; // case 2
			// 삭제할 노드 자리로 옮겨올 노드 찾아서 n이 가리키게함
			n = min(target.getRight());
			n.setRight(deleteMin(target.getRight()));
			n.setLeft(target.getLeft());
		}
		return n;
	}
	
	public int height() {
		return height(root)+1;
	}
	private int height(Node n) {
		if(n==null) return -1;
		
		return 1+Math.max(height(n.getLeft()), height(n.getRight()));
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
}
