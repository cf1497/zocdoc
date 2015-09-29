package Algorithm;

import java.util.ArrayList;
import java.util.List;

public class countPrimes {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
	
		System.out.println(countPrimesII(11));
	}
	
	
	//method1: basic, time limited
	public static int countPrimes(int n){
		if(n==1) return 0;
		if(n==2) return 1;
	
		List<Integer> primes = new ArrayList<Integer>();
		primes.add(2);
		
		for(int i=3; i<n; i++){
			boolean isPrime = true;
			for(int p:primes){
				if((i%p)==0) isPrime = false;				
			}
			
			if(isPrime) primes.add(i);
		}
		
		return primes.size();
	}
	
	public static int countPrimesII(int n){
		if(n<=2) return 0;
		
		boolean[] isPrime = new boolean[n];
		for(int i=2; i<n; i++) isPrime[i] = true;
		for(int i=2; i<=Math.sqrt(n);i++){
			if(isPrime[i]){
				for(int j=i+i;j<n; j+=i){
					isPrime[j] = false;
				}
			}
		}
		
		int count = 0;
		for(int i=0; i<n; i++){
			if(isPrime[i]) count++;
		}
		return count;
	}

}
