class Solution {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        List<List<Integer>> list=new ArrayList<>();
        int i=0;
        int n=intervals.length;
        while(i<n && intervals[i][1]<newInterval[0]){
            List<Integer> temp=new ArrayList<>();
            temp.add(intervals[i][0]);
            temp.add(intervals[i][1]);
            list.add(new ArrayList<>(temp));
            i++;
        }
        while(i<n && intervals[i][0]<=newInterval[1]){
            newInterval[0]=Math.min(newInterval[0],intervals[i][0]);
            newInterval[1]=Math.max(newInterval[1],intervals[i][1]);
            i++;
        }
        List<Integer> t=new ArrayList<>();
        t.add(newInterval[0]);
        t.add(newInterval[1]);
        list.add(new ArrayList<>(t));
        while(i<n){
            List<Integer> temp=new ArrayList<>();
            temp.add(intervals[i][0]);
            temp.add(intervals[i][1]);
            list.add(new ArrayList<>(temp));
            i++;
        }
        n=list.size();
        int[][] arr=new int[n][2];
        i=0;
        for( i=0;i<n;i++){
            arr[i][0]=list.get(i).get(0);
            arr[i][1]=list.get(i).get(1);
        }
        return arr;
    }
}
