class Solution {
    public int maximizeSquareHoleArea(int n, int m, int[] hBars, int[] vBars) {
        int x=0;
        Arrays.sort(hBars);
        Arrays.sort(vBars);
        int count=1;
        for(int i=0;i<hBars.length;i++){
            if(i>0 && hBars[i-1]+1==hBars[i]) count++;
            else count=1;
            x=Math.max(count,x);
        }
        x+=1;
        count=1;
        int y=0;
        for(int i=0;i<vBars.length;i++){
            if(i>0 && vBars[i-1]+1==vBars[i]) count++;
            else count=1;
            y=Math.max(y,count);
        }
        y+=1;
        int a=Math.min(x,y);
        return a*a;
    }
}
