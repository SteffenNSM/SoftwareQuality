package Test;

import Main.MyMaths;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 * Test class for the MyMaths class.
 * Contains unit tests to verify the correctness of the gcd method.
 */


public class MyMathsTest {

    private MyMaths myMaths;

    /**
     * Set up method to initialize the MyMaths instance before each test.
     */
    @Before
    public void setUp() {
        myMaths = new MyMaths();
    }

    /**
     * Tests for the GCD method with various cases to ensure correctness.
     */
    @Test
    public void testGcd1() {
        Assert.assertEquals(6, myMaths.gcd(48, 18)); // GCD of 48 and 18 is 6
    }

    @Test
    public void testGcd2() {
        Assert.assertEquals(6, myMaths.gcd(18, 48)); // GCD of 18 and 48 is 6 (order doesn't matter)
    }

    @Test
    public void testGcd3() {
        Assert.assertEquals(5, myMaths.gcd(0, 5)); // GCD of 0 and 5 is 5
    }

    @Test
    public void testGcd4() {
        Assert.assertEquals(5, myMaths.gcd(5, 0)); // GCD of 5 and 0 is 5
    }

    @Test(expected = ArithmeticException.class)
    public void testGcd5() {
        myMaths.gcd(0, 0); // Expect an exception when both values are zero
    }

    /**
     * Boundary tests to check the behavior at the limits.
     */
    @Test
    public void testBoundaryInterior1() {
        Assert.assertEquals(1, myMaths.gcd(1, 1)); // GCD of 1 and 1 is 1
    }

    @Test
    public void testBoundaryInterior2() {
        Assert.assertEquals(1, myMaths.gcd(1, 2)); // GCD of 1 and 2 is 1
    }

    @Test
    public void testBoundaryInterior3() {
        Assert.assertEquals(2, myMaths.gcd(2, 4)); // GCD of 2 and 4 is 2
    }

}
