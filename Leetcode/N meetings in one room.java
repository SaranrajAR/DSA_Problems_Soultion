class Pair{
    int left;
    int right;
    Pair(int left,int right){
        this.left=left;
        this.right=right;
    }
}
class Solution {
    // Function to find the maximum number of meetings that can
    // be performed in a meeting room.
    public int maxMeetings(int start[], int end[]) {
        // add your code here
        int n=start.length;
        List<Pair> list=new ArrayList<>();
        for(int i=0;i<start.length;i++){
            Pair temp=new Pair(start[i],end[i]);
            list.add(temp);
        }
        Collections.sort(list,(a,b)->a.right-b.right);
        
        int cnt=1;
        int nxtfreeTime=list.get(0).right;
        for(int i=1;i<n;i++){
            int s=list.get(i).left;
            int e=list.get(i).right;
            if(s > nxtfreeTime){
                cnt++;
                nxtfreeTime=e;
            }
        }
        return cnt;
    }
}
