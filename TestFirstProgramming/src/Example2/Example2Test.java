package Example2;

import static org.junit.Assert.*;
import org.junit.Test;
public class Example2Test {
	@Test
	public void test() {
		int[] a1 = {0};
		assertEquals(0, Example2.find(0,a1));

		int[] a2 = {-1,1,3};
		assertEquals(-1, Example2.find(2,a2));
		assertEquals(0, Example2.find(-1,a2));
		assertEquals(1, Example2.find(1,a2));
		assertEquals(2, Example2.find(3,a2));
		
		int[] a3 = {-1,1,2,3};
		assertEquals(3, Example2.find(3,a3));
		
		int[] a4 = {1,1,1};
		assertEquals(0, Example2.find(1,a4));
	}
}

