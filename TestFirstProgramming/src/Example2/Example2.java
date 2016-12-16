package Example2;

/*
 * Find the first occurrence of x in sorted array a.
 * @param x value to find
 * @param a array sorted in increasing order (a[0] <= a[1] <= … a[n-1])
 * @return lowest i such that a[i]==x, or -1 if x not found in a. 
 * 
 */
public class Example2 {
	public static int find(int x, int[] a) {
		for (int i = 0; i < a.length; ++i) {
            if (x == a[i]) {
                return i;
            }
        }
        return -1;
	}
}

