package http.count;

import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.json.simple.JSONObject;

/**
 * Servlet implementation class WordCount
 */
public class WordCount extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public WordCount() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		response.setContentType("text/html");  
		PrintWriter out = response.getWriter();  
		
		int count=0;
		String query=request.getParameter("query");
		out.println(query);
		String path = getServletContext().getRealPath("/WEB-INF/files");
		
		File folder = new File(path);
        File[] listOfFiles = folder.listFiles();
    
        if(listOfFiles == null) return;  // Added condition check
        for (File file : listOfFiles)
        {
        	{
        	
        	 count=count+countWord(query,file);
        	
        	}
        }
        //to produce JSON output
        JSONObject obj = new JSONObject();
		obj.put("Count", count);
		out.println(obj);
        out.close();
	}
	// method to find the occurrence of a word 
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
	
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		
	}

}
