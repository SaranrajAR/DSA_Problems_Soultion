import java.util.Stack;

public class Solution {
	public static void insertAtBottom (Stack<Integer> stack,int ele){
		if(stack.isEmpty()){
			stack.push(ele);
			return;
		}
		int top=stack.pop();
		insertAtBottom(stack,ele);
		stack.push(top);  


	}
    
	public static void reverseStack(Stack<Integer> stack) {
		// write your code here
		if(stack.isEmpty()) return ;
		int ele=stack.pop();
		reverseStack(stack);
		insertAtBottom(stack,ele);
		
	}

}
