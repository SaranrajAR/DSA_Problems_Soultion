class Solution {
    public int numWaterBottles(int numBottles, int numExchange) {
        int ans=numBottles;
        int empty=numBottles;
        while(empty>=numExchange){
            int drink=empty/numExchange;
            ans+=drink;
            empty=empty%numExchange;
            empty+=drink;
        }
        return ans;


    }
}
