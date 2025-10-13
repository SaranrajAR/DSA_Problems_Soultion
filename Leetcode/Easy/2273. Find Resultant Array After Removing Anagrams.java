class Solution {
    public List<String> removeAnagrams(String[] words) {
        int n=words.length;
        List<String> ans=new ArrayList<>();
        int i=0;
        int j=i+1;
        while(j<n){
            char[] ch1=words[i].toCharArray();
            char[] ch2=words[j].toCharArray();
            Arrays.sort(ch1);
            Arrays.sort(ch2);
            String s1=new String(ch1);
            String s2=new String(ch2);
            if(s1.equals(s2)){
                j++;
            }
            else{
                ans.add(words[i]);
                i=j;
                j++;
            }
        }
        
        ans.add(words[i]);
        
        return ans;
    }
}
