class Solution {
    public int longestKSubstr(String s, int k) {
        // code here
        int ans=-1;
        int r=0;
        int l=0;
        int n=s.length();
        HashMap<Character,Integer> map=new HashMap<>();
        while(r<n){
            char ch=s.charAt(r);
            map.put(ch,map.getOrDefault(ch,0)+1);
            while(map.size()>k){
                char left=s.charAt(l);
                l++;
                int val=map.get(left);
                val--;
                if(val==0) map.remove(left);
                else map.put(left,val);
            }
            if(map.size()==k) ans=Math.max(r-l+1,ans);
            
            r++;
        }
        return ans;
    }
}
