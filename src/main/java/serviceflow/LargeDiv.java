package serviceflow;

class LargeDiv implements Runnable{
	
	static String[] results;
	private final int max_index;
	private final int min_index;
	
	//constructor
	LargeDiv(int min_index,int max_index){
		this.max_index=max_index;
		this.min_index=min_index;
	}
	
	/* @method - run() - thread run
	 * @desc - Each thread loop through min index to
	 * max index and modifies class variable results
	 */
	public void run() {
		for(int i=min_index+1;i<=max_index;i++) {		
			results[i-1]=fizzbuzz(i);
		}
	}
	
	/* @method - fizzbuzz
	 * @params - integer
	 * @desc - returns fizz or buzz if it's divisible by
	 * 3 or 5 if both fizz buzz else just the number.
	 */
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
