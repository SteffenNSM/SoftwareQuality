import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class MyMaths {
	
	public int gcd(int m, int n) {
		
		int r;
		if (n>m) {
			
			r = m;
			m = n;
			n = r;
		}
		
		r = m % n;
		while (r != 0) {
			
			m = n;
			n = r;
			r = m % n;
		}		
		return n;
	}

	@Before
	public void setUp() {
		// Hier könnten gemeinsame Initialisierungen vorgenommen werden, wenn nötig.
	}

	@Test
	public void testGcd1() {
		Assert.assertEquals(6, gcd(48, 18));
	}

	@Test
	public void testGcd2() {
		Assert.assertEquals(6, gcd(18, 48));
	}

	@Test
	public void testGcd3() {
		Assert.assertEquals(5, gcd(0, 5));
	}

	@Test
	public void testGcd4() {
		Assert.assertEquals(5, gcd(5, 0));
	}

	@Test(expected = ArithmeticException.class)
	public void testGcd5() {
		gcd(0, 0); // Wir erwarten eine Ausnahme bei der Berechnung von gcd(0, 0)
	}

	@Test
	public void testBoundaryInterior1() {
		Assert.assertEquals(1, gcd(1, 1));
	}

	@Test
	public void testBoundaryInterior2() {
		Assert.assertEquals(1, gcd(1, 2));
	}

	@Test
	public void testBoundaryInterior3() {
		Assert.assertEquals(2, gcd(2, 4));
	}
}
