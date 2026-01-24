class Pair{
    int userId;
    int amount;
    Pair(int userId,int amount){
        this.userId=userId;
        this.amount=amount;
    }
}
class AuctionSystem {
    public HashMap<Integer,HashMap<Integer,Pair>> itemUserMap;
    public HashMap<Integer,TreeSet<Pair>> itemMapSet;
    public AuctionSystem() {
        itemUserMap=new HashMap<>();
        itemMapSet=new HashMap<>();
    }
    
    public void addBid(int userId, int itemId, int bidAmount) {
        itemUserMap.putIfAbsent(itemId,new HashMap<>());
        itemMapSet.putIfAbsent(itemId,new TreeSet<>((a,b)->{
            if(a.amount==b.amount) return b.userId-a.userId;
            return b.amount-a.amount;
        }));   
        HashMap<Integer,Pair> userMap=itemUserMap.get(itemId);
        TreeSet<Pair> itemSet=itemMapSet.get(itemId);
        if(userMap.containsKey(userId)){
            Pair temp=userMap.get(userId);
            itemSet.remove(temp);
        }
        Pair newPair=new Pair(userId,bidAmount);
        userMap.put(userId,newPair);
        itemSet.add(newPair);
    }
    
    public void updateBid(int userId, int itemId, int newAmount) {
        HashMap<Integer,Pair> userMap=itemUserMap.get(itemId);
        TreeSet<Pair> itemSet=itemMapSet.get(itemId);
        if(userMap.containsKey(userId)){
            Pair temp=userMap.get(userId);
            itemSet.remove(temp);
        }
        Pair newPair=new Pair(userId,newAmount);
        userMap.put(userId,newPair);
        itemSet.add(newPair);
    }
    
    public void removeBid(int userId, int itemId) {
        HashMap<Integer,Pair> userMap=itemUserMap.get(itemId);
        TreeSet<Pair> itemSet=itemMapSet.get(itemId);
        Pair temp=userMap.get(userId);
        itemSet.remove(temp);
        userMap.remove(userId);
    }
    
    public int getHighestBidder(int itemId) {
        if(!itemMapSet.containsKey(itemId) || itemMapSet.get(itemId).isEmpty()) return -1;
        TreeSet<Pair> itemSet=itemMapSet.get(itemId);
        return itemSet.first().userId;
        
    }
}

/**
 * Your AuctionSystem object will be instantiated and called as such:
 * AuctionSystem obj = new AuctionSystem();
 * obj.addBid(userId,itemId,bidAmount);
 * obj.updateBid(userId,itemId,newAmount);
 * obj.removeBid(userId,itemId);
 * int param_4 = obj.getHighestBidder(itemId);
 */
