class Solution {
    public int removeCoveredIntervals(int[][] intervals) {
        Arrays.sort(intervals,(a,b)->{
            if(a[0]==b[0]) return b[1]-a[1];
            return a[0]-b[0];
        });
        int c=0;
        int n=intervals.length;
        List<int[]> list=new ArrayList<>();
        list.add(new int[]{intervals[0][0],intervals[0][1]});
        for(int i=1;i<intervals.length;i++){
            int prev11=list.get(list.size()-1)[0];
            int prev12=list.get(list.size()-1)[1];
            int curr11=intervals[i][0];
            int curr12=intervals[i][1];
            if(prev11<=curr11 && prev12>=curr12) c++;
            else list.add(new int[]{curr11,curr12});
        }
        return n-c;
    }
}
