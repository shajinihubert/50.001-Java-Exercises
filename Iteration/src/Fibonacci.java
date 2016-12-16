public class Fibonacci{
	public static String fibonacci(){
		 int n1=0;
		 int n2=1;
		 int n3; 
		 int count=20; 

		 String list = Integer.toString(n1);
		 list += "," + Integer.toString(n2);  
		    
		 for(int i=2;i<count;++i)
		 {    
		  n3=n1+n2;    
		  list += "," + Integer.toString(n3);
		  n1=n2;    
		  n2=n3;    
		 } 
		 
		 System.out.print(list);
		 return list;
	
	}
	}