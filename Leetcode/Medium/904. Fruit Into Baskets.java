class Solution {
    public int totalFruit(int[] fruits) {
        int count=0;
        int maxCount=0;
        int i=0;
        int j=0;
        HashMap<Integer,Integer> map=new HashMap<>();
        while(j<fruits.length){
            map.put(fruits[j],map.getOrDefault(fruits[j],0)+1);
            while(map.size()>2){
                int val=map.get(fruits[i]);
                val--;
                map.put(fruits[i],val);
                if(val==0) map.remove(fruits[i]);
                i++;
                
            }
            
            count=j-i+1;
            maxCount=Math.max(count,maxCount);
            j++;
        }
        return maxCount;
    }
}
