/*
 * @author = Jeevan sirela
 * @class = Fizz
 * 
 * Calculates fizzbuzz string for any given input number;
 */
package serviceflow;
 
import serviceflow.LargeDiv;

//Main Fizz class
public class Fizz {
	
	private final int number;
	private final String[] fizzbuzz;
	
	//constructor - itself calls the game method.
	public Fizz(String number) throws InterruptedException{
		this.number=Integer.parseInt(number);
		this.fizzbuzz=game();
	}
	
	//accessor methods
	public int getNum() {
		return number;
	}
	
	public String[] getFizzbuzz() {
		return fizzbuzz;
	}
	
	/* @method = game()
	 * @exception - interrupted exception
	 * @params 
	 * 	@threads - number of threads needed
	 * 	@thread_division - fixed range of numbers each thread will handle
	 * 	@arr - Array of threads
	 * 	@LargeDiv - Class which implements Runnable
	 */
	private String[] game() throws InterruptedException{
		//static variable results will be initialized
		LargeDiv.results=new String[number];
		
		int threads=ThreadReq();
		Thread[] arr=new Thread[threads];
		int thread_division=number/threads;
		//Each Thread starts and runs
		for(int i=1;i<=threads;i++) {
			if(i!=threads) {
				arr[i-1]=new Thread(new LargeDiv(thread_division*(i-1),thread_division*i));
				arr[i-1].start();	
			}else {
				arr[i-1]=new Thread(new LargeDiv(thread_division*(i-1),number));
				arr[i-1].start();	
			}
		}
		// Loop to make sure to return results after each thread completed its execution
		for(int i=0;i<threads;i++) {
			arr[i].join();
		}
		return LargeDiv.results;
	}
	/*
	 * @method - ThreadReq
	 * @desc - will return an integer indicating number
	 * of threads required.
	 */
	private int ThreadReq() {
		if(number<100000)
			return 1;
		else if(number<10000 && number>=1000)
			return 10;
		else if(number<100000 && number>=10000)
			return 100;
		else
			return 1000;
	}
}
