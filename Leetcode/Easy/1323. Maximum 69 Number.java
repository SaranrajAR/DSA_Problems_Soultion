class Solution {
    public int maximum69Number (int num) {
        StringBuilder sb=new StringBuilder(Integer.toString(num));
        int max=num;
        for(int i=0;i<sb.length();i++){
            char c=sb.charAt(i);
            char temp=c;
            if(c=='9') c='6';
            else c='9';
            sb.setCharAt(i,c);
            max=Math.max(max,Integer.parseInt(sb.toString()));
            sb.setCharAt(i,temp);
            
        }
        return max;
    }
}
