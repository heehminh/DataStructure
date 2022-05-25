//자료구조 과제 #3 (60200860 김민희)
package ds_week05;

public class Main3 {
	// 과제 #3 소스코드
	public static void test(String testArray) {
	      
	      ListStack<String> stack = new ListStack<String>();
	      String[] arr = testArray.split(" ");
	      boolean error = false; // 괄호 짝이 맞는지 아닌지 (error=true이면 안맞는것)
	      String point = ""; // 괄호 짝이 맞지 않는 부분 (괄호 출력)
	      
	      for (String str: arr) {
	         // 여는 괄호라면 stack에 push
	         if (str.equals("{") || str.equals("(")) stack.push(str);
	         
	         // 닫는 괄호라면 stack 최상단에 여는 괄호와 비교
	         else {
	            String input = stack.pop();
	            if( (input.equals("(") && str.equals("}")) || (input.equals("{") && str.equals(")")) ) {
	               error = true;
	               point = input; // error 부분 지정 
	               break;
	            }   
	         }
	      }
	      if (error) System.out.println(point+" 에서 짝이 맞지 않습니다.");
	      else System.out.println("괄호 짝이 맞습니다.");
	   }
	
	public static void main(String[] args) {
		// ArrayStack<String> stack = new ArrayStack<String>();
	    ListStack<String> stack = new ListStack<String>();
	      
	      stack.push("apple");
	      stack.push("orange");
	      stack.push("cherry");
	      stack.print(); 
	      
	      System.out.println(stack.peek()); 
	      stack.push("pear"); 
	      stack.print(); 
	      
	      stack.pop();
	      stack.print(); 
	      
	      System.out.println(stack.peek()); 
	      stack.push("grape");
	      stack.print();
	     
	    // 과제#3
	      
		String s1 = "{ { ( ) { ( ) } } }";
		String s2 = "{ { ( ) { ( ) } ) ( ) }";
		
		System.out.println(s1);
		test(s1);
		
		System.out.println("\n"+s2);
		test(s2);

	}

}
