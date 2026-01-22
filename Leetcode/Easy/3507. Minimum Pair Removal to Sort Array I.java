class Solution {
    public boolean isSorted(List<Integer> list){
        for(int i = 1; i < list.size(); i++){
            if(list.get(i) < list.get(i - 1)){
                return false;
            }
        }
        return true;
    }
    public int minimumPairRemoval(int[] nums) {
        List<Integer> list=new ArrayList<>();
        for(int num:nums) list.add(num);
        boolean isTrue=false;
        int count=0;
        while(!isTrue){
            if(isSorted(list)){
                isTrue=true;
                break;
            }
            else{
                count++;
                int idx1=-1;
                int idx2=-1;
                int minSum=(int) 1e9;
                for(int i=0;i<list.size()-1;i++){
                    int currSum=list.get(i)+list.get(i+1);
                    if(currSum<minSum){
                        idx1=i;
                        idx2=i+1;
                        minSum=currSum;
                    }
                }
                if(minSum!=(int) 1e9){
                    list.set(idx1,minSum);
                    list.remove(idx2);
                }
            }

        }
        return count;
    }
}
