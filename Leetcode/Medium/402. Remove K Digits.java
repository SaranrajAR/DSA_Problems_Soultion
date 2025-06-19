class Solution {
    public String removeKdigits(String num, int k) {
        Stack<Character> stack=new Stack<>();
        for(int i=0;i<num.length();i++){
            while(!stack.isEmpty() && k>0 && (stack.peek()-'0')>(num.charAt(i)-'0')){
                stack.pop();
                k--;
            }
            stack.push(num.charAt(i));
        }
        while(k>0){
            stack.pop();
            k--;
        }
        if(stack.isEmpty()) return "0";
        StringBuilder sb=new StringBuilder();
        for(char ch:stack){
            sb.append(ch);
        }
        while(sb.length()>0 && sb.charAt(0)=='0') sb.deleteCharAt(0);
        return sb.length()==0 ? "0" :sb.toString(); 
        
    }
}
