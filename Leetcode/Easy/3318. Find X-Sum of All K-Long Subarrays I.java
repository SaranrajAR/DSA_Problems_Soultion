class Pair{
    int key;
    int val;
    Pair(int key,int val){
        this.key=key;
        this.val=val;
    }
}
class Solution {
    public int func(int l,int r,int[] nums,int x){
        HashMap<Integer,Integer> map=new HashMap<>();
        for(int i=l;i<r;i++){
            map.put(nums[i],map.getOrDefault(nums[i],0)+1);
        }
        PriorityQueue<Pair> pq=new PriorityQueue<>((a,b)->{
            if(a.val!=b.val){
                return b.val-a.val;
            }
            return b.key-a.key;
        });
        for(int key:map.keySet()){
            pq.offer(new Pair(key,map.get(key)));
        }
        int ans=0;
        while(x-- > 0 && !pq.isEmpty()){
            Pair temp=pq.poll();
            ans+=temp.key*temp.val;
        }
        return ans;
        
    }
    public int[] findXSum(int[] nums, int k, int x) {
        List<Integer> ans=new ArrayList<>();
        int n=nums.length;
        for(int i=0;i<=n-k;i++){
            int l=i;
            int r=i+k;
            int count=func(l,r,nums,x);
            ans.add(count);
        }
        n=ans.size();
        int[] res=new int[n];
        for(int i=0;i<n;i++){
            res[i]=ans.get(i);
        }
        return res;
    }
}
