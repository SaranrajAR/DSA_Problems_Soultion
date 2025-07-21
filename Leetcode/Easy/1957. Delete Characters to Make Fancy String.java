class Solution {
    public String makeFancyString(String s) {
        int count=1;
        int n=s.length();
        if(n<=2) return s;

        StringBuilder sb=new StringBuilder();
        char prev=s.charAt(0);
        sb.append(prev);
        for(int i=1;i<n;i++){
            char ch=s.charAt(i);
            if(ch==prev) count++;
            else count=1;
            if(count==3){
                count--;
                continue;
            }
            sb.append(ch);
            prev=ch;
        }
        return sb.toString();

        
    }
}
