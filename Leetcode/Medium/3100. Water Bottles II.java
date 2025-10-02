class Solution {
    public int maxBottlesDrunk(int numBottles, int numExchange) {
        int empty=0;
        int drank=0;
        while(numBottles>0 || empty>=numExchange){
            if(empty>=numExchange){
                numBottles+=1;
                empty-=numExchange;
                numExchange++;
            }
            else if(numBottles>0){
                empty+=numBottles;
                drank+=numBottles;
                numBottles=0;
            }
        }
        return drank;
    }
}
