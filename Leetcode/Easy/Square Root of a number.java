import java.util.* ;
import java.io.*; 

public class Solution {

	public static int sqrtN(long N) {
		/*
		 * Write your code here
		 */
		 long low=0;
		 long high=N;
		 long ans=0;

		 while(low<=high){
			 long mid=(low+high)/2;
			 if((mid*mid)<=N){
				 ans=mid;
				 low=mid+1;
			 }
			 else{
				 high=mid-1;
			 }
		 }
		 return (int)ans;
	}
}
