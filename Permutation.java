package Algorithm;

import java.util.ArrayList;
import java.util.List;

public class Permutation {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String s = "aabc";
		System.out.println(permutation(s));

	}
	
	public static List<String> permutation(String s){
		List<String> result = new ArrayList<String>();
		StringBuilder sb = new StringBuilder();
		
		rec(result, sb, s);
		
		return result;
	}
	
	public static void rec(List<String> result,StringBuilder sb, String s){
		if(s.length()==0){
			result.add(sb.toString());
			return;
		}
		
		for(int i=0; i<s.length(); i++){
			char cur = s.charAt(i);
			sb.append(cur);
			rec(result,sb,s.substring(0,i)+s.substring(i+1));
			sb.deleteCharAt(sb.length()-1);
			
			while(i<s.length()-1 && s.charAt(i)==s.charAt(i+1)){
				i++;
			}
		}
		
	}

}
