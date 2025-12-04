class Solution {
    public int countCollisions(String directions) {
        Stack<Character> stack=new Stack<>();
        int count=0;
        int n=directions.length();
        stack.push(directions.charAt(0));
        for(int i=1;i<n;i++){
            char ch=directions.charAt(i);
            char top=stack.peek();
            if(top=='R' && ch=='L'){
                count+=2;
                stack.pop();
                while(!stack.isEmpty() && stack.peek()=='R'){
                    count++;
                    stack.pop();
                }
                stack.push('S');
            }
            else if(top=='R' && ch=='S'){
                count+=1;
                stack.pop();
                while(!stack.isEmpty() && stack.peek()=='R'){
                    count++;
                    stack.pop();
                }
                stack.push('S');
            }
            else if(top=='S' && ch=='L'){
                count+=1;
                
            }
            else stack.push(ch);
        }
        return count;
    }
}
