class Solution {
    public String[] divideString(String s, int k, char fill) {
        int n=s.length();
        int r=n%k;
        int groupSize=n/k;
        if(r>0) groupSize+=1;

        String[] arr=new String[groupSize];
        int plus=0;
        if(r>0) plus=k-r;

        StringBuilder sb=new StringBuilder(s);
        for(int i=0;i<plus;i++){
            sb.append(fill);
        }

        int index=0;
        for(int i=0;i<groupSize;i++){
            arr[i]=sb.substring(index,index+k);
            index+=k;
        }
        return arr;
        


    }
}
