/*
 * @(#)WordCount.java        6.56 16/03/31
 *
 * Copyright (c) comes here
 * 
 */

package custom.wordcount;

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

/**
 *  
         Class which return the occurrences of a search keyword
 *
 * @version      
         1.0 31 Mar 2016 
 * @author          
         Deepa Anbalagan 
*/


@Path("/wordcount")
public class WordCount {
	//HashMap is to cache the search
	static HashMap<String,Integer> hm=new HashMap<String,Integer>();
	@GET
	@Path("/{message}")
	@Produces(MediaType.APPLICATION_JSON)
	public String printWord(@PathParam("message") String message) throws IOException
	{
		// input variable stores the file folder path
		String input=App.inputPath;
		// stores the occurrences
		int count=0;
		// to store the result in string format 
		String output="";
		// to check whether result is already cached or not
		if(!hm.isEmpty()&&hm.containsKey(message))
		{
			
			output="{count:"+hm.get(message)+"}";
			return output;
		}
		else
		{
		
		try 
		
		{
		// folder gets the path of the input file folder	
		File folder = new File(input);
		// array to store the individual file in the folder
		File[] listOfFiles = folder.listFiles();
        if(listOfFiles == null) 
			return null;  // Added condition check
        for (File file : listOfFiles)
        {
        	{
			//recursive call to find the occurrences in all the files
        	 count=count+countWord(message,file);
        	
        	}
        }
        //to produce JSON output
        output="{count:"+count+"}";
		/* synchronized block to avoid from more than one thread accessing object at a time */
		synchronized(this)
		{
			hm.put(message,count);
		}
		}catch (Exception e) 
		{
			e.printStackTrace();
		}
		// return output;
		return output;
		
		
        
    }
}
	//Function is to return number of occurrences
	public int countWord(String word, File file) throws IOException {
		// to store the result of the search in a file
		int count = 0;
		// to open a file and read the contents
		FileInputStream fstream = new FileInputStream(file);
        DataInputStream in = new DataInputStream(fstream);
        BufferedReader br = new BufferedReader(new InputStreamReader(in));
		// to store the result of the input file 
        String strLine;
		// stores each and every word in a file
        String tokens[] = null;
		// to split the string based on the space
        while ((strLine = br.readLine()) != null)   {
        	tokens = strLine.split(" ");
 		
        }
		// loop is to generate the count
        for(int i=0;i<tokens.length;i++)
        {
        	if(tokens[i].equalsIgnoreCase(word))
        	{
        		count+=1;
        	}
        }
		// return count
        return count;
	}
	
	
}