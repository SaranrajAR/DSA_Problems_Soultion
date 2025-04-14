class Solution {
    public int countGoodSubstrings(String s) {
        HashMap<Character,Integer> map=new HashMap<>();
        int count=0;
        int l=0,r=0;
        if(s.length()<3) return 0;
        while(r<s.length()){
            map.put(s.charAt(r),map.getOrDefault(s.charAt(r),0)+1);
            if(r-l+1 == 3){
                if(map.size()==3) count++;
                char leftchar=s.charAt(l);
                map.put(leftchar,map.get(leftchar)-1);
                if(map.get(leftchar)==0) map.remove(leftchar);
                l++;
            } 
           

            r++;
        }
        return count;
        
        
        
    }
}
