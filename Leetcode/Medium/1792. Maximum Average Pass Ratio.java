class ClassInfo{
    int pass;
    int total;
    ClassInfo(int pass,int total){
        this.pass=pass;
        this.total=total;
    }
    double gain(){
        double  old=(double)pass/total;
        double New=(double)(pass+1)/(total+1);
        return New-old; 
    }
}
class Solution {
    public double maxAverageRatio(int[][] classes, int extraStudents) {
        PriorityQueue<ClassInfo> pq=new PriorityQueue<>((a,b)->Double.compare(b.gain(),a.gain()));
        for(int[] c:classes){
            pq.offer(new ClassInfo(c[0],c[1]));
        }
        for(int i=0;i<extraStudents;i++){
            ClassInfo top=pq.poll();
            top.pass++;
            top.total++;
            pq.offer(top);
        }
        double ans=0;
        while(!pq.isEmpty()){
            ClassInfo top=pq.poll();
            ans+=(double) top.pass/top.total;
        }
        return (double)ans/classes.length;
    }
}