class Solution {
    public List<List<String>> wordSquares(String[] words) {
        List<List<String>> res=new ArrayList<>();
        int n=words.length;
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                if(i==j) continue;
                for(int k=0;k<n;k++){
                    if(i==k || j==k) continue;
                    for(int l=0;l<n;l++){
                        if(i==l || j==l || k==l) continue;
                        String top=words[i];
                        String left=words[j];
                        String right=words[k];
                        String bottom=words[l];
                        if((top.charAt(0)==left.charAt(0)) && top.charAt(3)==right.charAt(0)){
                            if(bottom.charAt(0)==left.charAt(3) && bottom.charAt(3)==right.charAt(3)){
                                List<String> list=new ArrayList<>(Arrays.asList(top,left,right,bottom));
                                res.add(list);
                            }
                        }
                    }
                }
            }

        }
        Collections.sort(res,(a,b)->{
            for(int i=0;i<4;i++){
                int val=a.get(i).compareTo(b.get(i);
                if(val!=0) return val;
            }
            return 0;
        });
        return res;
    }
}
