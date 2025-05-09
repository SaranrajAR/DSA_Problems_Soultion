class Solution {
    public boolean rotateString(String s, String goal) {
        int n=s.length();
        if(n!=goal.length()) return false;
        StringBuffer given=new StringBuffer(s);
        if(given.toString().equals(goal)) return true;
        for(int i=0;i<n-1;i++){
            char last=given.charAt(n-1);
            given.deleteCharAt(n-1);
            given.insert(0,last);
            
            
            if(given.toString().equals(goal)) return true;
        }
        return false;
        
        

        
    }
}
