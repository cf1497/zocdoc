package Algorithm;

public class QuickSort {
	 public static void main(String[] args){
		 int[] nums = {2,6,4,3,8,1};
		 quickSort(nums);
		 for(int n:nums){
			 System.out.print(n+" ");
		 }
	 }
	 
	 public static void quickSort(int[] nums){
		 partition(nums, 0, nums.length-1);
		 
	 }
	 
	 public static void partition(int[] nums, int start, int end){
		 
		 if(start>end){
			 return;
		 }
		 
		 int left = start;
		 for(int i=start+1; i<=end; i++){
			 if(nums[i]<nums[start]){
				 left++;
				 swap(nums, left, i	);
			 }
		 }
		 
		 swap(nums,left,start);
		 partition(nums,start,left-1);
		 partition(nums,left+1,end);
	 }
	 
	 public static void swap(int[] nums, int a, int b){
		 int tmp = nums[a];
		 nums[a] = nums[b];
		 nums[b] = tmp;
	 }
	 
	 
}
