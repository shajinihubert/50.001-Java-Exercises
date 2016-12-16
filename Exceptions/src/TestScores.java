public class TestScores{
    public void testScores(double[] s){

    	 for (int i=1; i <= s.length ; i++){
    	 if (s[i] < 0 || s[i] > 100) {
    	      throw new IllegalArgumentException("Element:" + i + "  Score:" + s[i]) ;
    	    }
    	 }
    }
}