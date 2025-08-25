class Solution {
    public int numSplits(String s) {
        Map<Character,Integer> right=new HashMap<>();
        Map<Character,Integer> left=new HashMap<>();
        
        for(char c:s.toCharArray()){
            right.put(c,right.getOrDefault(c,0)+1);
        }
        int ans=0;
        for(char c:s.toCharArray()){
            int temp=right.get(c);
            left.put(c,left.getOrDefault(c,0)+1);
            temp--;
            right.put(c,temp);
            if(temp==0) right.remove(c);
            if(left.size()==right.size()) ans++;


        }
        return ans;
    }
}
