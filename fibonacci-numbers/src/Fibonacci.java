public class Fibonacci {
	public static int fib(int n) {
		// computes fibonacci function for any non-negative integer n
		if (n <= 1)
			return n;
		return fib(n - 1) + fib(n - 2);
	}
	
	public static int fastFib(int n) {
		int retValue0 = 0;
		int retValue1 = 1;
		int input = 2;
		
		while (input != n+1) {
			if (input%2 == 0) {
				retValue0= retValue0 + retValue1;
			}
			
			if (input%2 == 1) {
				retValue1 = retValue0 + retValue1;
			}
			input++;
		}
		
		if (n%2 == 0) {
			return retValue0;
		}
		else {
			return retValue1;
		}	
	}
	
	public static long longFastFib(int n) {
		long retValue0 = 0;
		long retValue1 = 1;
		long input = 2;
		
		while (input != n+1) {
			if (input%2 == 0) {
				retValue0= retValue0 + retValue1;
			}
			
			if (input%2 == 1) {
				retValue1 = retValue0 + retValue1;
			}
			input++;
		}
		
		if (n%2 == 0) {
			return retValue0;
		}
		else {
			return retValue1;
		}	
	}

	public static void main(String[] args) {
		if (args.length < 1) {
			System.out.println("Needs an integer parameter");
			System.exit(1);
		}

		int n = Integer.parseInt(args[0]);
		System.out.println(longFastFib(n));
	}
}

// Exercise 1: Use this program to find F(10), F(15), and F(20).

/* Answer: F(10) = 55, F(15) = 610, F(20) = 6765 */

// Exercise 2: Explain why this code is correct, using DJW’s three questions for a recursive method

// 1. Does it have a base case, and is the output correct there?

/* Answer: Yes, it has a base case. In the method of fib, when the input n is not greater than 1,
 * the method will not make another recursive call but a non-recursive call. Because the input is
 * any non-negative integer, so the input in the base case could be 0 or 1, which will return 0 or 1 
 * corresponding to the input.
 */

// 2. Does it always make progress toward the base case, given its precondition?
/* Answer: Yes. In the recursive call of the method, each time it calls for a recursive call, the input 
 * will become n-1 and n-2, which is less than n. And because the input is set as a non-negative integer,
 * so we know that the input in the recursive calls will become smaller and closer to 0 or 1. So it always
 * make progress toward the base case, in which the input is 0 or 1.
 */

// 3. If all recursive calls return the correct output, must it also return the correct output?
/* Answer: Yes, it must return the correct output. Assumeing that fib(n-1) and fib(n-2) both return the 
 * correct output, then the result of fib(n) should be fib(n-1) + fib(n-2), which is exactly the fibonacci-number
 * of n. So the answer is yes.
 */

// Exercise 3: For large enough n, this program will return an incorrect output due to integer overflow.
/* Answer: This largest number is 48, the fibonacci-number of 48 is 512559680. The time of this computing is
 * less than 1 minute. The computing costs nearly 22s.
 */

// Exercise 4: Now write a new non-recursive fastFib method (in the Fibonacci class) that runs faster than fib.
/* Answer: The method is listed above.*/

// Exercise 5: With this new method, find the first n that causes integer overflow in the calculation, if you have
// not found it already.
/* Answer: The largest number for n is still 48. And the time of computing is less than 1s.*/


// Exercise 6: Write another new method longFastFib, similar to fastFib but that uses long variables
// in place of int variables to avoid the integer overflow problem.
/* Answer: In the longFastFib, the largest number n of overflow is 164, 
 * and the output is 7278316983633677837
 */ 
