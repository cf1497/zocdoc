package Algorithm;

import java.util.ArrayList;
import java.util.List;

public class PalindromePartition {
	
	public static void main(String[] args){
		String s = "aab";
		System.out.println(partition(s));
		
	}
	
	public static List<List<String>> partition(String s) {
		List<List<String>> result = new ArrayList<List<String>>();
		List<String> list = new ArrayList<String>();
		
		if(s==null || s.length()==0) return result;
		
		rec(result,list,s);
		
		
		return result;
	}
	
	public static void rec(List<List<String>> result, List<String> list, String s){
		if(s.length()==0){
			result.add(new ArrayList<String>(list));
			return;
		}
		
		for(int i=1; i<=s.length(); i++){
			String cur = s.substring(0,i);
			if(isPalindrome(cur)){
				list.add(cur);
				rec(result,list,s.substring(i));
				list.remove(list.size()-1);
			}
		}
	}
	
	
	public static boolean isPalindrome(String s){
		int start = 0, end = s.length()-1;
		while(start<=end){
			if(s.charAt(start)!=s.charAt(end)){
				return false;
			
			}
			start++;
			end--;
		}
		
		return true;
	}
}
