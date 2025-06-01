class Solution {
    public int[] shortestToChar(String s, char c) {
        List<Integer> index=new ArrayList<>();
        int n=s.length();
        int[] ans=new int[n];
        for(int i=0;i<n;i++){
            if(s.charAt(i)==c) index.add(i);
        }
        for(int i=0;i<n;i++){
            List<Integer> temp=new ArrayList<>();
            for(int ind:index){
                temp.add(Math.abs(ind-i));
            }
            int minDist=Collections.min(temp);
            ans[i]=minDist;
        }
        return ans;
        
    }
}
