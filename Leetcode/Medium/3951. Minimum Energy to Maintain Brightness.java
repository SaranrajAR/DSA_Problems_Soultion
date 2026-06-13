class Pair{
    int st;
    int end;
    Pair(int st,int end){
        this.end=end;
        this.st=st;
    }
}
class Solution {
    public long minEnergy(int n, int brightness, int[][] intervals) {
        int minConfig=((brightness-1)/3)+1;
        List<Pair> list=new ArrayList<>();
        Arrays.sort(intervals,(a,b)->{
            int st1=a[0];
            int st2=b[0];
            if(st1==st2) return a[1]-b[1];
            return st1-st2;
        });    
        for(int[] interval:intervals){
            int st=interval[0];
            int end=interval[1];
            if(!list.isEmpty() && list.get(list.size()-1).end>=st){
                int prevSt=list.get(list.size()-1).st;
                int prevEnd=list.get(list.size()-1).end;
                list.get(list.size()-1).end=Math.max(end,prevEnd);
            }
            else if(!list.isEmpty() && list.get(list.size()-1).end>=end){
                continue;
            }
            
            else{
                list.add(new Pair(st,end));
            }
        }
        long res=0;
        for(Pair interval:list){
            int st=interval.st;
            int end=interval.end;
            long curr=end-st+1;
            curr*=(long) minConfig;
            res+=curr;
        }
        return res;
    }
}
