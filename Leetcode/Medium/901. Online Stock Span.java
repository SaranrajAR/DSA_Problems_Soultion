class Pair{
    int x,y;
    Pair(int x,int y){
        this.x=x;
        this.y=y;
    }
}

class StockSpanner {
    public List<Integer> list;
    public Stack<Pair> stack;
    public int idx;

    public StockSpanner() {
        list=new ArrayList<>();
        stack=new Stack<>();
        idx=-1;
    }
    
    
    public int next(int price) {
        idx++;
        int count=0;
        while(!stack.isEmpty() && stack.peek().y<=price){
            stack.pop();
        }
        count+=stack.isEmpty()? idx+1:idx-stack.peek().x;
        stack.push(new Pair(idx,price));

        return count;
    }
}

/**
 * Your StockSpanner object will be instantiated and called as such:
 * StockSpanner obj = new StockSpanner();
 * int param_1 = obj.next(price);
 */
