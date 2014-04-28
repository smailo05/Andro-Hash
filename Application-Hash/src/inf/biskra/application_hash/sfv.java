package inf.biskra.application_hash;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class sfv {
	

	static ArrayList<String> Nom = new ArrayList<String>();
    static ArrayList<String> Algo = new ArrayList<String>();
    static ArrayList<String> Val = new ArrayList<String>();
    
     
	private static BufferedReader reader;
	
//cette methode pour ouvrir le fichier.sfv
	
	
    public static void getFile(String filePath) throws java.io.IOException
    {
        reader = new BufferedReader(new FileReader(filePath));
        String line;// results = "";
      
       
      
        line = reader.readLine();
        while( line != null){
        	  
        	
        	

        	
        	//on separé la ligne on trois parties
        	 final StringTokenizer stToken = new StringTokenizer(line,"; ");
    	    final String[] splitStr = new String[stToken.countTokens()];
    	 
    	    
    	    int index = 0;
    	    while(stToken.hasMoreElements()) {
    	       splitStr[index] = stToken.nextToken();
    	    	
    	       if(index==0)
    	       Nom.add(splitStr[index]);
    	      
    	    	   if(index==1)
    	    		   Algo.add(splitStr[index]); 
    	    	   if(index==2)
    	    		  Val.add(splitStr[index]);
    	    	   index++;
    	       }
    	    
    	       line = reader.readLine();
        	
     
   		
        
        } 
        
     
    }
 

}
