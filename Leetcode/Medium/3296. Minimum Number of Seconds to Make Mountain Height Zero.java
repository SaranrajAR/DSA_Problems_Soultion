class Solution {
    public long BSearch(int time,long low,long high,long checkValue){
        long k=0;
        while(low<=high){
            long mid=(low+high)/2;
            if((time*(((mid+1)*mid)/2))<=checkValue){
                low=mid+1;
                k=mid;
            }
            else{
                high=mid-1;
            }
        }
        return k;
    }
    public boolean check(long mid,int[] arr,long hUnit){
        int count=0;
        for(int num:arr){
            count+=BSearch(num,1,hUnit,mid);
        }
        return count>=hUnit;
    }
    //main Function
    public long minNumberOfSeconds(int mountainHeight, int[] workerTimes) {
        long max=-1;
        int[] arr=workerTimes;
        for(int num:arr) max=Math.max(max,num);
        long low=1;
        long hUnit=mountainHeight;
        long high=max*((hUnit*(hUnit+1))/2);
        long currAns=-1;
        while(low<=high){
            long mid=(low+high)/2;
            if(check(mid,arr,hUnit)) {
            
                high=mid-1;
                currAns=mid;
            }    
            else low=mid+1;
        }
        return currAns;
    }
}
