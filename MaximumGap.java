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
		
		double interval = (double)nums.length/(max-min);
		
		for(int n: nums){
			int index = (int)((n-min)*interval);
			
			if(buckets[index].low==-1){
				buckets[index].low = n;
				buckets[index].high = n;
			}else{
				buckets[index].low = Math.min(buckets[index].low, n);
				buckets[index].high = Math.max(buckets[index].high, n);
			}
		}
		
		int pre = buckets[0].high,result = 0;
		for(int i=1; i<buckets.length; i++){
			if(buckets[i].low!=-1){
				result = Math.max(result, buckets[i].low-pre);
				pre = buckets[i].high;
			}
		}
		
		
		return result;
	}

}
