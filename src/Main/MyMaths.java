package Main;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

//A utility class that provides mathematical functions.

public class MyMaths {

	/**
	 * Calculates the Greatest Common Divisor (GCD) of two integers using the Euclidean algorithm.
	 *
	 * @param m The first integer
	 * @param n The second integer
	 * @return The greatest common divisor of m and n
	 * @throws ArithmeticException if both m and n are zero
	 */

	public int gcd(int m, int n) {
		// Handle edge case where both numbers are zero
		if (m == 0 && n == 0) {
			throw new ArithmeticException("GCD is undefined for both values being zero.");
		}

		// If one of the numbers is zero, return the absolute value of the other
		if (m == 0) return Math.abs(n);
		if (n == 0) return Math.abs(m);

		// Ensure m is greater than or equal to n
		if (n > m) {
			int temp = m;
			m = n;
			n = temp;
		}

		// Euclidean algorithm for GCD
		int r = m % n;
		while (r != 0) {
			m = n;
			n = r;
			r = m % n;
		}

		return Math.abs(n); // Return the GCD as a positive number
	}

}
