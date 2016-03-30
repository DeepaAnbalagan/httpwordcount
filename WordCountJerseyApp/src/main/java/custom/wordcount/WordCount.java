package custom.wordcount;

/**
 * Class which finds the occurrences of the word
 *
 */

import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.PathParam;
import java.util.HashMap;

@Path("/wordcount")
public class WordCount {
	//HashMap is to cache the search
	static HashMap<String,Integer> hm=new HashMap<String,Integer>();
	@GET
	@Path("/{message}")
	@Produces(MediaType.APPLICATION_JSON)
	public String printWord(@PathParam("message") String message) throws IOException
	{
		String input=App.inputPath;
		int count=0;
		String output="";
		if(!hm.isEmpty()&&hm.containsKey(message))
		{
			
			output="{count:"+hm.get(message)+"}";
			return output;
		}
		else
		{
		 
		
		try {
			
		File folder = new File(input);
		File[] listOfFiles = folder.listFiles();
        if(listOfFiles == null) return null;  // Added condition check
        for (File file : listOfFiles)
        {
        	{
        	
        	 count=count+countWord(message,file);
        	
        	}
        }
        //to produce JSON output
        output="{count:"+count+"}";
		hm.put(message,count);
		}catch (Exception e) {
			e.printStackTrace();
		}
		//return output;
		return output;
		
		
        
    }
	}
	//Function is to return number of occurrences
	public int countWord(String word, File file) throws IOException {
		int count = 0;
		FileInputStream fstream = new FileInputStream(file);
        DataInputStream in = new DataInputStream(fstream);
        BufferedReader br = new BufferedReader(new InputStreamReader(in));
        String strLine;
        String tokens[] = null;
        while ((strLine = br.readLine()) != null)   {
        	tokens = strLine.split(" ");
 		
        }
        for(int i=0;i<tokens.length;i++)
        {
        	if(tokens[i].equalsIgnoreCase(word))
        	{
        		count+=1;
        	}
        }
        return count;
	}
	
	
}