package Algorithm;

public class FindMinmumInRotatedArray {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
         int[] nums = {5,5,5,5,5,1,2,3,5,5};
         System.out.println(findMinII(nums));
	}
	
	public static int findMin(int[] nums){
		
		int start = 0, end = nums.length-1;
		while(start<end){
			int mid = (start+end)/2;
			if(nums[mid]>nums[end]){
				start = mid+1;
			}else{
				end = mid;
			}
		}
		
		return nums[start];	
	}
	
	public static int findMinII(int[] nums){
		int start = 0, end = nums.length-1;
		
		while(start<end){
			int mid = (start+end)/2;
			if(nums[mid]>nums[end]){
				start = mid+1;
			}else if(nums[mid]<nums[end]){
				end = mid;
			}else{
				if(nums[mid]==nums[start]){
					start++;
					end--;
				}else{
					end = mid;
				}
			}
			
		}
		
		
		return nums[start];
		
	}

}
