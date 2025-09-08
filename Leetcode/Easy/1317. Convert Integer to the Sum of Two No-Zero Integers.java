class Solution {
    public int[] getNoZeroIntegers(int n) {
        int[] arr=new int[2];
        for(int i=1;i<=n;i++){
            int a=i;
            int b=n-i;
            String A=Integer.toString(a);
            String B=Integer.toString(b);
            if(!A.contains("0") && !B.contains("0")){
                arr[0]=a;
                arr[1]=b;
                break;
            }
        }
        return arr;
    }
}
