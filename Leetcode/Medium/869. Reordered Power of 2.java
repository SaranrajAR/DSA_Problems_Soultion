class Solution {
    public boolean isTrue;
    public void swap(int i,int j,StringBuilder sb){
        char temp=sb.charAt(i);
        sb.setCharAt(i,sb.charAt(j));
        sb.setCharAt(j,temp);
    }
    public void helper(StringBuilder sb,int idx){
        if(isTrue) return;
        if(idx==sb.length()){
            if(sb.charAt(0)=='0') return;
            int num=Integer.parseInt(sb.toString());
            if(num >0 && (num &(num-1))==0) isTrue=true;
            return;
        }
        for(int i=idx;i<sb.length();i++){
            swap(i,idx,sb);
            helper(sb,idx+1);
            swap(i,idx,sb);
        }
    }
    public boolean reorderedPowerOf2(int n) {
        isTrue=false;
        StringBuilder sb=new StringBuilder(String.valueOf(n));
        helper(sb,0);
        return isTrue;
    }
}
