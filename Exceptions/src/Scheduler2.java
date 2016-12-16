import java.util.*;

public class Scheduler2   {
    
    public static void main(String[] args) {
        System.out.println("Welcome to the Appointment Scheduler");
        System.out.println("You can schedule an appointment at 1 or 2 pm.");
        
        Scanner reader = new Scanner(System.in);
        
        String appointments[] = new String[2];
        int appointmentsMade = 0;
        
        while (appointmentsMade < 2){
        	try{
        		System.out.print("What is your name?:\t");
            	String name = reader.nextLine();
            	System.out.print("What time would you like the appointment?:\t");
            	String timein = reader.nextLine();
            	int time = Integer.parseInt(timein);
            	if (time != 1 && time != 2){
            		throw new InvalidTimeException();
        			}
            	else if (time == 1 || time == 2){
                    if (time == 1 && appointments[0] == null){
                    	appointments[0] = name;
                    	appointmentsMade++;
                    }
                    else if (time == 2 && appointments[1] == null){
                    	appointments[1] = name;
                    	appointmentsMade++;
                    }
                    else {
                    	throw new TimeInUseException();
                    	}
            	}//else if
        	}//try
        	catch (InvalidTimeException e) {
	             System.out.println("Sorry, that is not a legal time\nTime value not in range"); 
				}
        	 catch (TimeInUseException e) {
	             System.out.print("Appointment already made at that time\nSorry, that time is already in use\n"); 
	             }
        	}System.out.print("All appointments made\n");
            System.out.print("At 1 pm: " + appointments[0] + "\n");
            System.out.print("At 2 pm: " + appointments[1] + "\n");
        }

static class InvalidTimeException extends Exception{
	public InvalidTimeException(String message) {
		super(message);
		}

	public InvalidTimeException() {}
	}
static class TimeInUseException extends Exception{
	//Scanner scanner = new Scanner(System.in);
	public TimeInUseException(String message) {
		super(message);
		}
	public TimeInUseException() {}
    }
}