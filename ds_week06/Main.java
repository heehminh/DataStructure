package ds_week06;

public class Main {

	public static void main(String[] args) {
		// ArrayQueue<String> queue = new ArrayQueue<String>();
		ListQueue<String> queue = new ListQueue<String>();
		
		queue.add("apple"); queue.print();
		queue.add("orange"); queue.print();
		queue.add("cherry"); queue.print();
		queue.add("pear"); queue.print();
		
		queue.remove(); queue.print();
		queue.remove(); queue.print();
		queue.remove(); queue.print();
	    queue.remove(); queue.print();
		
		queue.add("grape"); queue.print();
		

	}

}
