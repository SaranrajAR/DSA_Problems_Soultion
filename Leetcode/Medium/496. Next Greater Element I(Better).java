import java.util.*;
class Solution {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        Stack<Integer> stack=new Stack<>();
        HashMap<Integer,Integer> map=new HashMap<>();
        int n=nums2.length;
        int[] nge=new int[n];
        for(int i=n-1;i>=0;i--){
            if(stack.isEmpty()) {
                stack.push(nums2[i]);
                nge[i]=-1;
                map.put(nums2[i],-1);
            }    
            else if(stack.peek()>nums2[i]){
                nge[i]=stack.peek();
                map.put(nums2[i],stack.peek());
                stack.push(nums2[i]);
            }
            else{
                while(!stack.isEmpty() && stack.peek()<=nums2[i]){
                    stack.pop();
                }
                if(!stack.isEmpty()) {
                    nge[i]=stack.peek();
                    map.put(nums2[i],stack.peek());
                    stack.push(nums2[i]);
                    
                }    
                else{
                    nge[i]=-1;
                    stack.push(nums2[i]);
                    map.put(nums2[i],-1);
                }
            }
        }
        n=nums1.length;
        
        int ans[]=new int[n];
        for(int i=0;i<n;i++){
            ans[i]=map.get(nums1[i]);
        }

        return ans;
        
    }
}
