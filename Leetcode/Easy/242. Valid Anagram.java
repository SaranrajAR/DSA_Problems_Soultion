class Solution {
    public boolean isAnagram(String s, String t) {
        if(s.length()!=t.length()) return false;
        HashMap<Character,Integer> map=new HashMap<>();
        for(int i=0;i<t.length();i++){
            map.put(t.charAt(i),map.getOrDefault(t.charAt(i),0)+1);
        }
        for(int i=0;i<s.length();i++){
            char ch=s.charAt(i);
            if(map.containsKey(ch)){
                int count=map.get(ch);
                count--;
                if(count==0) map.remove(ch);
                else map.put(ch,count);
                
            }
            else{
                return false;
            }
        }
        if(map.size()>0) return false;
        
        return true;
        
    }
}
