import java.util.ArrayList;
import java.util.List;

public class Permutation {
	   private final String in;
	   private ArrayList<String> a = new ArrayList<String>();
	   private String perm;
	    Permutation(final String str){
	        in = str;
	        perm = "";
	    }

	    public void permute(){
	        if (a.size()>rfact(in.length())){ //stop permuting
	        }
	        
	        if(a.isEmpty()){
	        	System.out.print("hi");
	        	a.add(in);
	        	Permutation p = new Permutation(in);
		        p.permute();
	        }
	        
	        if (a.get(a.size()-1).charAt(0) == a.get(a.size()-1).charAt(0)){ //move first index to the end
	        	perm = in.substring(1) + String.valueOf(in.charAt(0));
	        	a.add(perm);
	        	Permutation p = new Permutation(perm);
		        p.permute();
	        }
	        if (a.get(a.size()-1).charAt(0) != a.get(a.size()-1).charAt(0)){ //reverse order
	        	perm =  String.valueOf(in.charAt(in.length()))+String.valueOf(in.charAt(in.length()-1))+String.valueOf(in.charAt(in.length()-2));
	        	a.add(perm);
	        	Permutation p = new Permutation(perm);
		        p.permute();
	        }
	        

	    }
	    
	    public static int rfact (int k) {
	        int temp;
			if (k == 0 ) return 1;
		    else  
		    return temp = (k * rfact (k-1)); 
	    	}

	    public ArrayList<String> getA(){
	        return a;
	    }
	    
	    
	    public static void main(String[] args) {
	        ArrayList<String> v;
	        Permutation p = new Permutation("hat");
	        p.permute();
	        v = p.getA();
	        System.out.print(v);
	    }
	
}
