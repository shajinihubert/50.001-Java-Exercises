package Procrastination;

public class Plan {
	
	public static int time;
	public static int[] timeArray = new int[10];
	public static int finalT;

	public static int procrastination(MyTask[] assignments) {
		
		for (int i = 0; i<assignments.length;i++){
			time = assignments[i].xi;
			timeArray[i] = time;
		}
		
		int i = 0;
		while(i < 10) {
		   finalT += timeArray[i];
		   i++;
		}
		
		if (finalT <= assignments[0].ti)
			return assignments[0].ti - finalT;
		else
			return -1;
	}

}
