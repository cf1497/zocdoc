package Algorithm;

public class PalindromePartitionII {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String s = "abba";
		System.out.println(minCut(s));

	}
	
	public static int minCut(String s){
		if(s==null || s.length()<2){
			return 0;
		}
		
		int[] cut = new int[s.length()];
		boolean[][] dp = new boolean[cut.length][cut.length];
		
		for(int i=0; i<cut.length; i++) cut[i]= i;
		
		for(int i=0; i<s.length(); i++){
			for(int j=0; j<=i; j++){
				if(s.charAt(j)==s.charAt(i) && ((i-j<=1) || dp[i-1][j+1])){
					dp[i][j] = true;
					

					if(j==0){
						cut[i] = 0;
					}else{
						cut[i] = Math.min(cut[i], cut[j-1]+1);
					}
				}
				
			}
		}
		
		return cut[cut.length-1];
	}

}
