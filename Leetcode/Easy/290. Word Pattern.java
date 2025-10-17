class Solution {
    public boolean wordPattern(String pattern, String s) {
        HashMap<Character,String> map=new HashMap<>();
        String[] S=s.split(" ");
        if(S.length!=pattern.length()) return false;
        Set<String> set=new HashSet<>();
        for(int i=0;i<pattern.length();i++){
            if(!map.containsKey(pattern.charAt(i)) && !set.contains(S[i])){
                map.put(pattern.charAt(i),S[i]);
                set.add(S[i]);
                
                continue;
            }
            
            else if(map.containsKey(pattern.charAt(i)) && map.get(pattern.charAt(i)).equals(S[i])) continue;
            else return false;

        }
        return true;
    }
}
