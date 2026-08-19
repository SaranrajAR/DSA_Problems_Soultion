class Solution {
    public int maxNumberOfFamilies(int n, int[][] reservedSeats) {
        Arrays.sort(reservedSeats,(a,b)->{
            if(a[0]==b[0]) return a[1]-b[1];
            return a[0]-b[0];
        });
        HashMap<Integer,List<Integer>> map=new HashMap<>();
        int rem=0;
        for(int[] seat:reservedSeats){
            if(!map.containsKey(seat[0])){
                rem++;
                map.put(seat[0],(new ArrayList<>()));
            }
            map.get(seat[0]).add(seat[1]);
        }
        int res=0;
        res+=(n-rem)*2;
        for(int key:map.keySet()){
            List<Integer> list=map.get(key);
            boolean left=false;
            boolean mid=false;
            boolean right=false;
            for(int num:list){
                if(num>=2 && num<=5) left=true;
                if(num>=4 && num<=7) mid=true;
                if(num>=6 && num<=9) right=true;
            }
            if(!left && !mid && !right) res+=2;
            else if(!left) res+=1;
            else if(!right) res+=1;
            else if(!mid) res+=1;

        }
        return res;
    }
}
