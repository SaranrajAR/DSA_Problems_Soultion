class Solution {
    public boolean isValid(String s){
        if(s.length()==0) return false;
        for(char ch:s.toCharArray()){
            if(Character.isDigit(ch) || Character.isLetter(ch) || ch=='_') {
                continue;
            }
            return false;
        }
        return true;
    }
    public List<String> validateCoupons(String[] code, String[] businessLine, boolean[] isActive) {
        int n=code.length;
        List<String> list=new ArrayList<>();
        TreeMap<String,PriorityQueue<String>> map=new TreeMap<>();
        map.put("electronics",new PriorityQueue<>());
        map.put("grocery",new PriorityQueue<>());
        map.put("pharmacy",new PriorityQueue<>());
        map.put("restaurant",new PriorityQueue<>());
        for(int i=0;i<n;i++){
            if(!isActive[i] || !isValid(code[i]) || !map.containsKey(businessLine[i])) continue;
            map.get(businessLine[i]).add(code[i]);
        }
        for(String key:map.keySet()){
            PriorityQueue<String> pq=map.get(key);
            while(!pq.isEmpty()) list.add(pq.poll());
        }
        return list;

        
    }
}
