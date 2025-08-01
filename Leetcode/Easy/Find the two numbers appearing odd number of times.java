class Solution {
    ArrayList<Integer> twoOddNum(int[] arr) {
        // code here
        int xorall=0;
        for(int num:arr){
            xorall^=num;
        }
        int b1=0;
        int b2=0;
        int rightmost=((xorall&(xorall-1))^xorall);
        for(int num:arr){
            if((num & rightmost)!=0) b1^=num;
            else b2^=num;
        }
        ArrayList<Integer> ans=new ArrayList<>();
        ans.add(b2);
        ans.add(b1);
        Collections.sort(ans, Collections.reverseOrder());
        return ans;
    }
}
