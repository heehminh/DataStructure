package ds_week08;

public class Node {
	int parent;
	int rank;
	
	public Node(int newParent, int newRank) {
		this.parent = newParent; this.rank = newRank;
	}
	
	public int getParent() { return this.parent; }
	public int getRank() { return this.rank; }
	
	public void setParent(int newParent) { this.parent = newParent; }
	public void setRank(int newRank) { this.rank = newRank; }

}
