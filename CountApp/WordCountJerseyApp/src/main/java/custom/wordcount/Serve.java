/*
* @(#)WordCount.java 6.56 16/03/31
*
* Copyright (c) comes here
*
*/
package custom.wordcount;
import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Properties;
import org.json.simple.JSONObject;
/**
*
Class which compute the output JSON files
*
* @version
1.0 31 Mar 2016
* @author
Deepa Anbalagan
*/
public class Serve {
    void giveResponse(String path)
    {
        {
            // To store the temporary result
            HashMap<String,Integer> hm=new HashMap<String,Integer>();
            // Used to write into the JSON file
            JSONObject obj = new JSONObject();
            try {
                // File folder location
                File folder = new File(path);
                File[] listOfFiles = folder.listFiles();
                String strLine;
                String tokens[] = null;
                /* For each file count will be calculated and stored in JSON output file
                preprocessed result set */
                for (File file : listOfFiles)
                {
                    FileInputStream fstream = new FileInputStream(file);
                    DataInputStream in = new DataInputStream(fstream);
                    BufferedReader br = new BufferedReader(new InputStreamReader(in));
                    {
                        while ((strLine = br.readLine()) != null)  {
                            tokens = strLine.split(" ");
                        }
                        for(int i=0;i<tokens.length;i++)
                        {
                            if(hm.containsKey(tokens[i])&&!hm.isEmpty())
                            {
                                hm.put(tokens[i], hm.get(tokens[i])+1);
                                obj.put(tokens[i], hm.get(tokens[i]));
                            }
                            else
                            {
                                hm.put(tokens[i], 1);
                                obj.put(tokens[i], 1);
                            }
                        }
                    }
                }
                }catch (Exception e) {
                e.printStackTrace();
            }
            // writes the result into the file
            try {
                FileWriter file1 = new FileWriter(path+"\\output.json");
                file1.write(obj.toJSONString());
                file1.flush();
                file1.close();
                } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}