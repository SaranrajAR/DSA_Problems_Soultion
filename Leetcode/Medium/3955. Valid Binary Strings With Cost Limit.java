class Solution {
    public void helper(char[] binString,int k,Set<String> set,int idx,int cost,int n){
        if(idx==n-1 || idx==k){
            if(cost<=k) set.add(new String(binString));
            if((idx!=0 && idx<n && binString[idx-1]=='0') || idx==0){
                binString[idx]='1';
                cost+=idx;
                if(cost<=k) set.add(new String(binString));
                binString[idx]='0';
            }
            return;
        }
        helper(binString,k,set,idx+1,cost,n);
        if(idx==0 || binString[idx-1]=='0'){
            binString[idx]='1';
            helper(binString,k,set,idx+1,cost+idx,n);
            binString[idx]='0';
        }
    }
    public List<String> generateValidStrings(int n, int k) {
        char[] binString=new char[n];
        Arrays.fill(binString,'0');
        Set<String> set=new HashSet<>();
        helper(binString,k,set,0,0,n);
        List<String> list=new ArrayList<>(set);
        return list;

    }
}
