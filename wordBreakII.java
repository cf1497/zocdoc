package Algorithm;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class wordBreakII {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String s = "catsanddog";
		Set<String> dict = new HashSet<String>();
		dict.add("cat");
		dict.add("cats");
		dict.add("and");
		dict.add("sand");
		dict.add("dog");
		
		System.out.println(wordBreakII(s,dict));

	}
	
	public static List<String> wordBreakII(String s,Set<String> dict){
		List<String> result = new ArrayList<String>();
		List<String> list = new ArrayList<String>();
		if(s==null || s.length()==0){
			return result;
		}
		
		rec(result, list,s,dict);
		
		return result;
	}
	
	public static void rec(List<String> result, List<String> list, String s, Set<String> dict){
		if(!canBreak(s,dict)){
			return;
		}
		
		if(s.length()==0){
			StringBuilder sb = new StringBuilder();
			for(int i=0; i<list.size();i++){
				sb.append(list.get(i));
				if(i!=list.size()-1){
					sb.append(" ");
				}
			}
			result.add(sb.toString());
			return;
		}
		
		for(String str : dict){
			if(str.length()>s.length()) continue;
			
			if(str.equals(s.substring(0,str.length()))){
				list.add(str);
				rec(result, list, s.substring(str.length()),dict);
				list.remove(list.size()-1);
			}
		}
		
		
		
		
	}
	
	public static boolean canBreak(String s, Set<String> dict){
		
		boolean[] dp = new boolean[s.length()+1];
		dp[0] = true;
		
		for(int i=1; i<s.length()+1;i++){
			for(int j=0; j<i; j++){
				if(dp[j]&&dict.contains(s.substring(j,i))){
					dp[i] = true;
				}
			}
		}
		
		return dp[dp.length-1];
	}

}
















