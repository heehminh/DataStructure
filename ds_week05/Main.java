// 자료구조 과제 #4(60200860 김민희)
package ds_week05;

public class Main {
	public static void change(String s) {
		ListStack<Character> stack = new ListStack<>();
		String result = "";
		
		for (char ch: s.toCharArray() ) {
			switch(ch) {
			case '(': stack.push(ch); break;
			case ')': 
				while(!stack.isEmpty()) {
					char op = stack.pop();
					if (op == '(') break;
					else result += op;
				}
				break;
			case '+':
			case '-':
			case '*':
			case '/': while(!stack.isEmpty()) {
				char op = stack.pop();
				if (priority(ch) <= priority(op)) {
					result += stack.pop();
				} 
				else break;	
				// 위치 어디?
			} 
			stack.push(ch); break; 
			default: result+=ch;
			}
		}
		while (!stack.isEmpty()) {
			result += stack.pop();
		}

//        for (int i = 0; i < str.length(); i++) {
//            char c = str.charAt(i);
//
//            switch (c){
//                case '+':
//                case '-':
//                case '*':
//                case '/':
//                    while (!stack.isEmpty() && priority(stack.peek()) >= priority(c)) {
//                    	result += stack.peek();
//                        stack.pop();
//                    }
//                    stack.push(c);
//                    break;
//                case '(':
//                    stack.push(c);
//                    break;
//                case ')':
//                    while(!stack.isEmpty() && stack.peek() != '('){
//                        result += stack.peek();
//                    	stack.pop();
//                    }
//                    stack.pop();
//                    break;
//                default:
//                	result += c;
//            }
//        }
//
//        while (!stack.isEmpty()) {
//            result += stack.peek();
//        	stack.pop();
//        }
//
//        return result;
    }

    public static int priority(char ch){

//        if(operator=='(' || operator==')'){
//            return 1;
//        } else if (operator == '+' || operator == '-') {
//            return 2;
//        } else if (operator == '*' || operator == '/') {
//            return 3;
//        }
//        return 0;
    	
    	if(ch=='(') return 0;
    	if(ch=='+' || ch=='-') return 1;
    	else return 2;
	}
	
	public static void main(String[] args) {
		String str = "A+B*C-D";
		System.out.println(str);
//		System.out.println("---> "+change(str)+"\n");
		change(str);
		System.out.println();
		change("A-B*C+D/E-F");
        
//        String a = "A-B+C/D";
//        System.out.println(a);
//        System.out.println("---> "+change(a)+"\n");
//                
//        String b = "A/B-C*D";
//        System.out.println(b);
//        System.out.println("---> "+change(b)+"\n");
//        
//        String c = "A-B*C+D/E-F";
//        System.out.println(c);
//        System.out.println("---> "+change(c)+"\n");
//        
//        String d = "(A-B)*C-(D/(E+F))";
//        System.out.println(d);
//        System.out.println("---> "+change(d)+"\n");
//        
//        String d1 = "A*(B-(C/D))+(E+(F*G))/H";
//        System.out.println(d1);
//        System.out.println("---> "+change(d1)+"\n");
//        
	}

}
