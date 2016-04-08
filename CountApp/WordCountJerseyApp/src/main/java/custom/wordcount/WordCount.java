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
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.PathParam;
import java.util.HashMap;
import java.io.FileReader;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
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
    @GET
    @Path("/{message}")
    @Produces(MediaType.APPLICATION_JSON)
    public String printWord(@PathParam("message") String message) throws IOException {
        // input variable stores the file folder path
        String input = App.inputPath;
        // stores the occurrences
        int count = 0;
        // to store the result in string format
        long output = 0;
        String result = "";
        File outputFile = new File(input + "\\output.json");
        if (!outputFile.exists()) {
            Serve s = new Serve();
            s.giveResponse(input);
            output = response(input, message);
            } else {
            output = response(input, message);
        }
        result = "{count:" + output + "}";
        return result;
    }
    long response(String path, String query) {
        long count = 0;
        try {
            JSONParser parser = new JSONParser();
            Object obj = parser.parse(new FileReader(path + "\\output.json"));
            JSONObject jsonObject = (JSONObject) obj;
            if (jsonObject.get(query) == null) {
                count = 0;
            }
            else
            count = (Long) jsonObject.get(query);
        }
        catch (Exception e) {
            System.out.println(e);
        }
        return count;
    }
}