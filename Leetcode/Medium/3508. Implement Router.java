class Router {
    int maxLimit;
    Deque<List<Integer>> queue;
    Set<List<Integer>> set;
    HashMap<Integer,List<Integer>> destMap;
    HashMap<Integer,Integer> destMapStIndex;
    public Router(int memoryLimit) {
        maxLimit=memoryLimit;
        queue=new ArrayDeque<>();
        set=new HashSet<>();
        destMap=new HashMap<>();
        destMapStIndex=new HashMap<>();
    }
    
    public boolean addPacket(int source, int destination, int timestamp) {
        List<Integer> temp=Arrays.asList(source,destination,timestamp);
        if(set.contains(temp)) return false;
        if(set.size()>=maxLimit){
            List<Integer> old=queue.pollLast();
            set.remove(old);
            int oldDest=old.get(1);
            destMapStIndex.put(oldDest,destMapStIndex.get(oldDest)+1);
        }
        set.add(temp);
        queue.offerFirst(temp);
        destMap.putIfAbsent(destination,new ArrayList<>());
        destMap.get(destination).add(timestamp);
        destMapStIndex.putIfAbsent(destination,0);
        return true;
    }
    
    public int[] forwardPacket() {
        if(set.size()<=0) return new int[]{};
        List<Integer> old=queue.pollLast();
        set.remove(old);
        int oldDest=old.get(1);
        destMapStIndex.put(old.get(1),destMapStIndex.get(old.get(1))+1);
        return new int[]{old.get(0),old.get(1),old.get(2)};
        
    }
    
    public int getCount(int destination, int startTime, int endTime) {
        if(!destMap.containsKey(destination)) return 0;
        List<Integer> arr=destMap.get(destination);
        int index=destMapStIndex.get(destination);
        if(index>=arr.size()) return 0;

        int left=lowerBound(arr,index,startTime);
        int right=upperBound(arr,index,endTime);
        return right-left;


    }
    public int lowerBound(List<Integer> arr,int low,int x){
        int high=arr.size()-1;
        while(low<=high){
            int mid=(low+high)/2;
            if(arr.get(mid)>=x) high=mid-1;
            else low=mid+1; 

        }
        return low;
    }
    public int upperBound(List<Integer> arr,int low,int x){
        int high=arr.size()-1;
        while(low<=high){
            int mid=(low+high)/2;
            if(arr.get(mid)>x) high=mid-1;
            else low=mid+1;
        }
        return low;
    }
}

/**
 * Your Router object will be instantiated and called as such:
 * Router obj = new Router(memoryLimit);
 * boolean param_1 = obj.addPacket(source,destination,timestamp);
 * int[] param_2 = obj.forwardPacket();
 * int param_3 = obj.getCount(destination,startTime,endTime);
 */
