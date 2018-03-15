package serviceflow;

import java.util.*;
public class Fizz {

	private final long number;
	private final ArrayList<String>[] fizzbuzz;
	
	public Fizz(String number){
		this.number=Long.parseLong(number);
		this.fizzbuzz=game();
	}
	
	public long getNum() {
		return number;
	}
	
	public ArrayList<String>[] getFizzbuzz() {
		return fizzbuzz;
	}
	
	private ArrayList<String>[] game(){
		long limit = (long)Integer.MAX_VALUE;
		long div = number/limit;
		long rem = number%limit;
		long arrays_required;
		if(rem==0)
			arrays_required=div;
		else
			arrays_required=div+1;
		ArrayList<String>[] result=new ArrayList[(int)arrays_required]; // limits the div to int max - hence max number = (MAX_INT)**2 
		for(int i=1;i<=arrays_required;i++) {
			ArrayList<String> current;
			if(i!=arrays_required) {
				current=new ArrayList<>();
				for(int j=1;j<=Integer.MAX_VALUE;j++) {
				current.add(fizzbuzz((i-1)*limit+j));					
				}
			}else {
				current=new ArrayList<>();
				for(int j=1;j<=(int)rem;j++) {
					current.add(fizzbuzz((i-1)*limit+j));					
				}
			}
			result[i-1]=current;
		}
		return result;
	}
	
	private String fizzbuzz(long N) {
		if(N%3==0 && N%5==0)
			return "Fizz Buzz";
		if(N%3==0)
			return "Fizz";
		if(N%5==0)
			return "Buzz";
		return Long.toString(N);
	}
}
