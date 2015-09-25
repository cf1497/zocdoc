package Algorithm;

public class KthLargestElement {
	
	public static void main(String[] args){
		int[] nums = {2,1,5,4,3};
		System.out.println(quickSortKth(nums,5));
	}
	
	public static int quickSortKth(int[] nums, int k){
		
		 k = nums.length-k;
		return partition(nums,0,nums.length-1,k);
	}
	
	public static int partition(int[] nums, int start, int end, int k){
		if(start>end){
			return -1;
		}
		
		int left = start;
		
		for(int i=start+1; i<=end; i++){
			if(nums[i]<nums[start]){
				left++;
				swap(nums,left,i);
			}
		}
		
		swap(nums, left, start);
		if(left==k){
			return nums[left];
		}else if(left<k){
			return partition(nums,left+1,end,k);
		}else{
			return partition(nums,start,left-1,k);
		}
	}
	
	public static void swap(int[] nums, int a, int b){
		int tmp = nums[a];
		nums[a] = nums[b];
		nums[b] = tmp;
	}
}
