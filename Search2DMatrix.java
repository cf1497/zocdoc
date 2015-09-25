package Algorithm;

public class Search2DMatrix {
	
	public static void main(String[] args){
//		int[][] matrix  = { {1,   4,  7, 11, 15},
//				            {2,   5,  8, 12, 19},
//				            {3,   6,  9, 16, 22},
//				            {10, 13, 14, 17, 24},
//				            {18, 21, 23, 26, 30}};
		
		int[][] matrix = {{1,3,5,7},
				          {10,11,16,20},
				          {23,30,34,50}};
		
		System.out.println(searchMatrixII(matrix,15));
		
	}
	
	//method1 : binarySeach
	public static boolean searchMatrix(int[][] matrix, int target){
		
		int row = matrix.length;
		int col = matrix[0].length;
		
		int start = 0, end = row-1;
		int mid = 0;
		while(start<=end){
			//System.out.println(start+"  "+end);
			mid = (start+end)/2;
			if(matrix[mid][0]==target){
				return true;
			}else if(matrix[mid][0]<target){
				start = mid+1;
			}else{
				end = mid-1;
			}
		}
		if(matrix[mid][0]>=target){
			row = mid-1;
		}else{
			row = mid;
		}
		
		
		start = 0;
		end =col-1;
		while(start<end){
			mid = (start+end)/2;
			if(matrix[row][mid]==target){
				return true;
			}else if(matrix[row][mid]<target){
				start = mid+1;
			}else{
				end = mid-1;
			}
		}
		
		return false;
	}
	
	//Method2: Start from the right-up corner of the matrix
	
	public static boolean searchMatrixII(int[][] matrix, int target){
		int row = 0, col = matrix[0].length-1;
		while(row<matrix.length && col>=0){
			if(target == matrix[row][col]){
				return true;
			}
			else if(target>matrix[row][col]){
				row++;
			}else{
				col--;
			}
		}
		
		return false;
	}

}























