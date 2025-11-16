class Solution {
    public int numSub(String s) {
        int mod=(int) 1e9+7;
        List<Integer> list=new ArrayList<>();
        int count=0;
        for(char ch:s.toCharArray()){
            if(ch =='1') count++;
            else{
                if(count>0) list.add(count);
                count=0;
            }
        }
        if(count>0) list.add(count);
        long ans=0;
        for(int num:list){
            long curr=(long) num*(num+1);
            curr=(curr/2)%mod;
            ans=(ans+curr)%mod; 
        }
        return (int) ans;
    }
}
