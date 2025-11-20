class Solution {
    public List<Integer> partitionLabels(String s) {
        int[] last=new int[26];
        int n=s.length();
        for(int i=0;i<n;i++){
            char ch=s.charAt(i);
            last[ch-'a']=i;
        }
        List<Integer> ans=new ArrayList<>();
        int curr=0;
        int Last=0;
        for(int i=0;i<n;i++){
            Last=Math.max(Last,last[s.charAt(i)-'a']);
            curr++;
            if(i==Last) {
                
                ans.add(curr);
                curr=0;
            }
            
                

        }
        
        return ans;

    }
}
