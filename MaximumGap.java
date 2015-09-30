package Algorithm;

public class MaximumGap {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] nums = {5,6,4,1,2};
		System.out.println(maximumGap(nums));
		

	}
	
	
	public static class Bucket{
		int low ;
		int high;
		public Bucket(){
			low = -1;
			high = -1;
		}	
	}
	
	public static int maximumGap(int[] nums){
		if(nums.length<=1) return 0;
		
		Bucket[] buckets  = new Bucket[nums.length+1];
		for(int i=0; i<buckets.length; i++){
			buckets[i] = new Bucket();
		}
		
		int max = nums[0], min = nums[0];
		for(int n: nums){
			max = Math.max(n, max);
			min = Math.min(n, min);
		}
		
		double interval = (max-min)/nums.length;
		
		for(int n: nums){
			int index = (int)((n-min)*interval);
			
			if(buckets[index].low==-1){
				buckets[index].low = n;
				buckets[index].high = n;
			}else{
				buckets[index].low = Math.min(min, n);
				buckets[index].high = Math.max(max, n);
			}
		}
		
		int pre = 0,result = 0;
		for(int i=0; i<buckets.length; i++){
			if(buckets[i].low!=-1){
				result = Math.max(result, buckets[i].low-pre);
				pre = buckets[i].high;
			}
		}
		
		
		return result;
	}
	
	
	
	

}
