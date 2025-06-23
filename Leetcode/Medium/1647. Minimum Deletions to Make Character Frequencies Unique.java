class Solution {
    public int minDeletions(String s) {
        int[] freq=new int[26];
        int n=s.length();
        for(int i=0;i<n;i++){
            freq[s.charAt(i)-'a']++;
        }
        int deletions=0;
        Set<Integer> used=new HashSet<>();
        for(int f:freq){
            while(f>0 && !used.add(f)){
                f--;
                deletions++;
            }
        }
        return deletions;
        
    }
}
