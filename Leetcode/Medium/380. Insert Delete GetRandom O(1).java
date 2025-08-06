class RandomizedSet {
    public HashMap<Integer,Integer> map;
    public ArrayList<Integer> list;

    public RandomizedSet() {
        map=new HashMap<>();
        list=new ArrayList<>();
    }
    
    public boolean insert(int val) {
        if(map.containsKey(val)) return false;
        map.put(val,list.size());
        list.add(val);
        return true;
    }
    
    public boolean remove(int val) {
        if(!map.containsKey(val)) return false;
        int last=list.get(list.size()-1);
        if(last==val){
            list.remove(list.size()-1);
            map.remove(last);
            return true;
        }
        int idx=map.get(val);
        list.set(idx,last);
        map.put(last,idx);
        map.remove(val);
        list.remove(list.size()-1);
        return true;
    }
    
    public int getRandom() {
        int randIdx=(int) (Math.random()*list.size());
        return list.get(randIdx);
    }
}

/**
 * Your RandomizedSet object will be instantiated and called as such:
 * RandomizedSet obj = new RandomizedSet();
 * boolean param_1 = obj.insert(val);
 * boolean param_2 = obj.remove(val);
 * int param_3 = obj.getRandom();
 */
