// User function Template for Java

class Solution {
    public static void helper(int n,String current,char lastChar,List<String> result){
        if(n==0){
            result.add(current);
            return;
        }
        helper(n-1,current+"0",'0',result);
        if(lastChar=='0'){
            helper(n-1,current+"1",'1',result);
        }
    }
    public static List<String> generateBinaryStrings(int n) {
        // code here
        List<String> result=new ArrayList<>();
        helper(n,"",'0',result);
        return result;
        
    }
}
