package Algorithm;

import java.util.TreeSet;

public class containsDuplicatesIII {

	
	public static void main(String[] args){
		int[] nums = {1,4,8,11};
		System.out.println(contains(nums,2,6));
		
	}
	
	public static boolean contains(int[] nums, int k, int t){
		
		TreeSet<Integer> set  = new TreeSet<Integer>();
		for(int i=0; i<nums.length; i++){
			
			int cur = nums[i];
			if((set.floor(cur)!=null && set.floor(cur)+t>=cur) || (set.ceiling(cur)!=null && set.ceiling(cur)-t<=cur) )  return true;
			set.add(cur);
			if(i>=k)  set.remove(nums[i-k]);
		}
		
		return false;
	}
}
