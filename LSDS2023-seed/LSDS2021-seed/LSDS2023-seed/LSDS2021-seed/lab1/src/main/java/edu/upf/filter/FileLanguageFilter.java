package edu.upf.filter;
import com.google.gson.Gson;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.Reader;

public class FileLanguageFilter {
    final String inputFile;
    final String outputFile;

void filterLanguage(String language) throws Exception {
        try{
        // read file
        BufferedReader br = new BufferedReader(new FileReader(file));  
        
        // initialization
        String line;  
        BufferedWriter bw = new BufferedWriter(new FileWriter(outputFile)); // where we will write the accepted (line by line)

        // List<SimplifiedTweet> lTweets = Files.lines(Paths.get(fileName))).forEach(l -> SimplifiedTweet.fromJson(s)).filter(t -> t.isPresent() && t.get().getLanguage().equals(language).collect(Collectors.toList());
        while ((line = br.readLine()) != null)  // while not end string character 
        {  
            // converting line to SimplifiedTweet
            Optional<SimplifiedTweet> tweet = SimplifiedTweet.fromJson(line)
            // if tweet not empty and correct language add it to lTweets
            if (tweet.isPresent() && tweet.get().getLanguage().equals(language)) {
                gson.toJson(tweet, bw); // write
            }
        } 
        // save the list to a file
        
        br.close(); // close files
        bw.close();
    
    } catch(Exception e){
        e.printStrackTrace();
        throw e; 
    }finally{
        br.close(); // close files
        bw.close();
    }
    }
}
