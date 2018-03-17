/*
 * @author = Jeevan sirela
 * @class = Fizz
 * 
 * Calculates fizzbuzz string for any given input number;
 */
package serviceflow;
import java.util.Date; 

// Thread Class
class LargeDiv extends Thread{
	
	static String[] results;
	private final int max_index;
	private final int min_index;
	
	LargeDiv(int min_index,int max_index){
		this.max_index=max_index;
		this.min_index=min_index;
	}
	
	public void run() {
		for(int i=min_index+1;i<=max_index;i++) {		
			results[i-1]=fizzbuzz(i);
		}
	}
	
	private String fizzbuzz(int N) {
		if(N%3==0 && N%5==0)
			return "Fizz Buzz";
		if(N%3==0)
			return "Fizz";
		if(N%5==0)
			return "Buzz";
		return Integer.toString(N);
	}
}

//Main Fizz class
public class Fizz {
	
	private final int number;
	private final String[] fizzbuzz;
	
	//constructor - itself calls the game method.
	public Fizz(String number) throws InterruptedException{
		this.number=Integer.parseInt(number);
		this.fizzbuzz=game();
	}
	
	public int getNum() {
		return number;
	}
	
	public String[] getFizzbuzz() {
		return fizzbuzz;
	}
	
	/*looping each number to construct the string array, We didn't use direct string because,
	 *  string length at max can be Integer.Max_value. It reaches the limitation very quickly.
	 */
	private String[] game() throws InterruptedException{
		LargeDiv.results=new String[number];
		int threads;
		if(number<1000)
			threads=1;
		else if(number<10000 && number>=1000)
			threads=10;
		else if(number<100000 && number>=10000)
			threads=100;
		else
			threads=1000;
		Date start=new Date();
		LargeDiv[] arr=new LargeDiv[threads];
		int thread_division=number/threads; //each thread does thread division numbers
		
		for(int i=1;i<=threads;i++) {	
			if(i!=threads) {
				arr[i-1]=new LargeDiv(thread_division*(i-1),thread_division*i);
				arr[i-1].start();	
			}else {
				arr[i-1]=new LargeDiv(thread_division*(i-1),number);
				arr[i-1].start();	
			}
		}
		for(int i=0;i<threads;i++) {
			arr[i].join();
		}	
		Date end=new Date();
		System.out.println("Time="+(end.getTime()-start.getTime()));
		return LargeDiv.results;
	}
	
	//calculates the string for every number.
	private String fizzbuzz(int N) {
		if(N%3==0 && N%5==0)
			return "Fizz Buzz";
		if(N%3==0)
			return "Fizz";
		if(N%5==0)
			return "Buzz";
		return Integer.toString(N);
	}
}
