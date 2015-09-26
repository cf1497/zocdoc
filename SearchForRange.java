package Algorithm;

public class SearchForRange {
	
	public static void main(String[] args){
		int[] nums = {3,3,3};
		
		for(int n : searchForRange(nums, 3)){
			System.out.print(n+" ");
		}
		
	}
	
	public static int[] result = {-1,-1};
	public static int[] searchForRange(int[] nums, int target) {

		if(nums.length==0){
			return result;
		}

		binaryS(nums, target,0, nums.length-1);
		return result;
	}

	public static void binaryS(int[] nums, int target, int start, int end){
		if(start>end){
			return ;
		}

		int mid = (start+end)/2;
		if(nums[mid] == target ){
			if(mid>0 && target==nums[mid-1]){
				binaryS(nums,target,start, mid-1);
			}else{
				result[0] = mid;
			}

			if(mid<nums.length-1 && target==nums[mid+1]){
				binaryS(nums,target, mid+1, end);
			}else{
				result[1] = mid;
			}
		}

		else if(nums[mid]>target){
			binaryS(nums, target, start, mid-1);
		}else {
			binaryS(nums, target, mid+1, end);
		}

	}
}
