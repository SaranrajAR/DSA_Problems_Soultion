class Solution {
    public int countLargestGroup(int n) {
        int max=0;
        HashMap<Integer,Integer> mpp=new HashMap<>();
        for(int i=1;i<=n;i++){
            int j=i;
            int sum=0;
            while(j>0){
                sum+=j%10;
                j=j/10;
            }

            mpp.put(sum,mpp.getOrDefault(sum,0)+1);
            max=Math.max(max,mpp.get(sum));
        }
        int count=0;

        for(int key:mpp.keySet()){
            if(mpp.get(key)==max) count++;
        }

        return count;

        
    }
}
