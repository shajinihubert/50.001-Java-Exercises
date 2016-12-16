public class HailstonesCount{
	public static int Counter(int n) {
		int curr = n;
		int i=0;
		while (curr!=1){
			if (curr%2==0){
				curr /= 2;
				}
			else{
				curr *= 3;
				curr += 1;
				}
			i+=1;
			}
		return i;
		}
}
