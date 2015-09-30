package Algorithm;

import java.util.ArrayList;
import java.util.List;

public class MissingRanger {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] nums = {4};
		System.out.println(findMissing(nums, 0, 99));

	}
	
	public static List<String> findMissing(int[] nums, int lower, int upper){
		List<String> result = new ArrayList<String>();
		int first = lower-1;
		for(int i=0; i<=nums.length; i++){
			int cur = (i==nums.length)? upper+1:nums[i];
			if(cur-first>1){
				result.add(getRange(first+1,cur-1));
			}
			first = cur;
		}

		return result;
	}
	
	public static String getRange(int first , int second){	
		return (first==second)?String.valueOf(first): first+"->"+second;
	}

}
