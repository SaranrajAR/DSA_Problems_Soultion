class Solution {
    public int subarrayBitwiseORs(int[] arr) {
        Set<Integer> prevOR=new HashSet<>();
        Set<Integer> ansOR=new HashSet<>();
        for(int x:arr){
            Set<Integer> currOR=new HashSet<>();
            currOR.add(x);
            for(int y:prevOR){
                currOR.add(y|x);
            }
            prevOR=currOR;
            ansOR.addAll(currOR);

        }
        return ansOR.size();
    }
}
