class Solution {
    public int minDeletion(String s, int k) {
        int[] arr=new int[26];
        Arrays.fill(arr,0);
        for(int i=0;i<s.length();i++){
            arr[s.charAt(i)-'a']++;
        }
        List<Integer> list=new ArrayList<>();
        for(int i=0;i<26;i++){
            if(arr[i]!=0) list.add(arr[i]); 
        }
        if(list.size()<=k) return 0;
        Collections.sort(list);
        int ans=0;
        int toremove=list.size()-k;
        for(int i=0;i<toremove;i++){
            ans+=list.get(i);
        }
        return ans;
        
    }
}
