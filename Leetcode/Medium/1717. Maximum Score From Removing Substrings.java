class Solution {
    public int maximumGain(String s, int x, int y) {
        char firstChar;
        char secondChar;
        int firstCount;
        int secondCount;
        if(y>x){
            firstChar='b';
            secondChar='a';
            firstCount=y;
            secondCount=x;
        }
        else{
            firstChar='a';
            secondChar='b';
            firstCount=x;
            secondCount=y;
        }
        int count=0;
        Stack<Character> stack=new Stack<>();
        int n=s.length();
        int i=0;
        for( i=0;i<n;i++){
            if(!stack.isEmpty() && stack.peek()==firstChar && s.charAt(i)==secondChar){
                stack.pop();
                count+=firstCount;
                continue;
            }
            stack.push(s.charAt(i));
        }
            
            
        
        StringBuilder sb=new StringBuilder();
        for(char ch:stack){
            sb.append(ch);
        }
        
        stack=new Stack<>();
        for(i=0;i<sb.length();i++){
            if(!stack.isEmpty() && stack.peek()==secondChar && sb.charAt(i)==firstChar){
                stack.pop();
                count+=secondCount;
                continue;
            }
            stack.push(sb.charAt(i));
        }
        return count;

    }
}
