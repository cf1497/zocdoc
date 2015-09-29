package Algorithm;

public class OneEditDistance {

	
	public static void main(String[] args){
		String s = "aa";
		String t = "b";
		System.out.println(isOneEdit(s,t));
	}
	
	public static boolean isOneEdit(String s, String t){
		int m = s.length();
		int n= t.length();
		if(m<n) return isOneEdit(t,s);
		int i=0;
		
		if(m-n>1) return false;
		
		int shift = m-n;
		while(i<n &&s.charAt(i)==t.charAt(i)) i++;
		if(i==n) return shift==1;
		
		if(shift==0){
			i++;
			while(i<n && s.charAt(i+1)==t.charAt(i)) i++;
		}
		
		
		
		
		return i==n;
	}
}
