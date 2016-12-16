public class BubbleSort {

	public static int[] bubbleSort(int[] inarray){

		    int n, c, d, swap;
		    for (c = 0; c < (inarray.length - 1 ); c++) {
		      for (d = 0; d < inarray.length - c - 1; d++) {
		        if (inarray[d] > inarray[d+1])
		        {
		          swap       = inarray[d];
		          inarray[d]   = inarray[d+1];
		          inarray[d+1] = swap;;
		        }
		      }
		    }
		    //int[] finallist = new int[inarray.length];
		    //for (c = 0; c < inarray.length;c++){
		      //finallist[c] = inarray[c];}
		    return inarray;
	}
}

