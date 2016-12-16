import java.util.*;

public class SongCard {
    
    private int songs;
    private boolean activated;
    
    
    public SongCard(int n) {
       songs = n;
    }
    
    public void activate(){
       activated = true;
    }
    
    
    public void buyASong()
    throws CardNotActivatedException, CardEmptyException {
        	if (songs == 0){
        		throw new CardEmptyException();
        		}
        	else if (activated == false){
        		throw new CardNotActivatedException();
        	}
        	else
        		songs = songs - 1;
        }
    
    public int songsRemaining(){
       return songs;
    		}
    
    public String toString(){
    	if (activated == true){
    	return ("Card has " + songs + " songs and is activated");
    		}
    	return ("Card has " + songs + " songs and is not activated");
    }
    public static void main(String[] args) {
        SongCard sc = new SongCard(10);
        sc.activated=false;
        int a = 1;
        	try{
        		
              System.out.println(sc);  
              System.out.println("Trying to buy a song");
        		
              System.out.println(sc); 
              System.out.println("Activating the card");
              sc.activate();
              System.out.println(sc);
              System.out.println("Buying songs");
                
            while (a==1){
            sc.buyASong();
            System.out.println("Bought a song: " + sc);
        	}}
        	catch (CardEmptyException e){
            System.out.println("Caught error: " +e.getMessage() );
        	} catch (CardNotActivatedException e){
            System.out.println("Caught error: " +e.getMessage() );
        	}  
        	System.out.println(sc);
        }

 class CardNotActivatedException extends Exception{
    public CardNotActivatedException(){};
    public String getMessage(){
    	return ("Card not activated");
    }
    }

 class CardEmptyException extends Exception{
	 public CardEmptyException(){};
	    public String getMessage(){
	    	return ("No more songs on the card");
	    }
    }
    
 }