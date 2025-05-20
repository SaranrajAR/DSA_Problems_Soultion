import java.util.ArrayList;
public class Solution {

	public static int[] rangeSum(int[] arr, int[][] queries) {		
	 	// Write your code here
		 int n=arr.length;
		 int[] prefix=new int[n];
		 prefix[0]=arr[0];
		 for(int i=1;i<n;i++){
			 prefix[i]=arr[i]+prefix[i-1];
		 }
		 ArrayList<Integer> list=new ArrayList<>();
		 for(int i=0;i<queries.length;i++){
			 int l=queries[i][0]-1;
			 int r=queries[i][1]-1;
			 int sum=prefix[r];
			 if((l)>0){
				 sum-=prefix[l-1];
			 }
			 list.add(sum);
		 }
		 int[] ans=new int[list.size()];
		 for(int i=0;i<list.size();i++){
			 ans[i]=list.get(i);
		 }
		 return ans;

		 
	}

}
