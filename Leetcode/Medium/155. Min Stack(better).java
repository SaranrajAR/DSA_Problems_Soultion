class Pair<U,V>{
    public U first;
    public V second;
    public Pair(U first,V second){
        this.first=first;
        this.second=second;
    }
}
class MinStack {

    private Stack<Pair<Integer,Integer>> stack;

    public MinStack() {
        stack=new Stack<>();
    }
    
    public void push(int val) {
        if(stack.isEmpty()){
            stack.push(new Pair<>(val,val));
        }
        else {
            Pair<Integer,Integer> top=stack.peek();
            stack.push(new Pair<>(val,Math.min(top.second,val)));
        }
    }
    
    public void pop() {
        stack.pop();
    }
    
    public int top() {
        return stack.peek().first;
    }
    
    public int getMin() {
        return stack.peek().second;
    }
}

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(val);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */
