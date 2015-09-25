package Algorithm;

import java.util.HashSet;
import java.util.Set;

public class WordBreakI {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String s = "leetcode";
		Set<String> dict = new HashSet<String>();
		dict.add("Leet");
		dict.add("code");
		dict.add("le");
		dict.add("etcode");
		System.out.println(wordBreak(s,dict));

	}
	
	public static boolean wordBreak(String s, Set<String> dict){
		if(s==null || s.length()==0) return true;
		if(dict.size()==0) return false;
		
		boolean[] dp = new boolean[s.length()+1];
		dp[0] = true;
		
		int i,j;
		for(i=1; i<dp.length; i++){
			for(j=0; j<i;j++){
				if(dp[j]&&dict.contains(s.substring(j,i))){
					dp[i] = true;
				}
			}
		}
		
		return dp[dp.length-1];
	}
	
	

}
