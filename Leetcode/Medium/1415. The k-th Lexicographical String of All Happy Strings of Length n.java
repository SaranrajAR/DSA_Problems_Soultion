class Solution {
    public void helper(int n,List<String> list,int idx,StringBuilder sb){
        if(idx==n) {
            list.add(sb.toString());
            return;
        }   
        if(sb.length()==0 || sb.charAt(sb.length()-1)!='a'){
            sb.append("a");
            helper(n,list,idx+1,sb);
            sb.deleteCharAt(sb.length()-1);
        }
        if(sb.length()==0 || sb.charAt(sb.length()-1)!='b'){
            sb.append("b");
            helper(n,list,idx+1,sb);
            sb.deleteCharAt(sb.length()-1);
        }
        if(sb.length()==0 || sb.charAt(sb.length()-1)!='c'){
            sb.append("c");
            helper(n,list,idx+1,sb);
            sb.deleteCharAt(sb.length()-1);
        }

    }
    public String getHappyString(int n, int k) {
        List<String> list=new ArrayList<>();
        helper(n,list,0,new StringBuilder());
        Collections.sort(list);
        if(k>list.size()) return "";
        return list.get(k-1);
    }
}
