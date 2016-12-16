public class RecursiveFactorial{
    public static long mcn(int m, int n) {
    	return rfact(m) / ((rfact(n)*rfact(m-n)));
    	}
    public static int rfact (int k) {
        int temp;
		if (k == 0 ) return 1;
	    else  
	    return temp = (k * rfact (k-1)); 
    	}

    }