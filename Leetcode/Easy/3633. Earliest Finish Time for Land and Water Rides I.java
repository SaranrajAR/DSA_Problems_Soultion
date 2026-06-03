class Solution {
    public int earliestFinishTime(int[] landStartTime, int[] landDuration, int[] waterStartTime, int[] waterDuration) {
        int n1=landStartTime.length;
        int n2=waterStartTime.length;
        int res=(int) 1e9;
        for(int i=0;i<n1;i++){
            int lS=landStartTime[i];
            int lD=landDuration[i];
            for(int j=0;j<n2;j++){
                int wS=waterStartTime[j];
                int wD=waterDuration[j];
                int waterTime=wS+wD;
                int landTime=lS+lD;
                if(wS<=landTime) landTime+=wD;
                else landTime=wS+wD;
                if(lS<=waterTime) waterTime+=lD;
                else waterTime=lS+lD;
                res=Math.min(landTime,Math.min(waterTime,res));
            }
        }
        return res;
    }
}
