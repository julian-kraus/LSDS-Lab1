package edu.upf.filter;
import com.google.gson.Gson;
import com.google.gson.stream.JsonReader;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.Reader;

import edu.upf.parser.*;
import java.util.Optional;
import java.util.Scanner;


public class FileLanguageFilter {
    final String inputFile;
    final String outputFile;

    public FileLanguageFilter(String inputFile, String outputFile) {
            this.inputFile = inputFile;
            this.outputFile = outputFile;
        }

    public void filterLanguage(String language) throws Exception {
            try{

            Gson gson = new Gson();
            // read file
            BufferedReader br = new BufferedReader(new FileReader(inputFile));  
            
            // initialization
            String line;  
            BufferedWriter bw = new BufferedWriter(new FileWriter(outputFile)); // where we will write the accepted (line by line)
            
            // List<SimplifiedTweet> lTweets = Files.lines(Paths.get(fileName))).forEach(l -> SimplifiedTweet.fromJson(s)).filter(t -> t.isPresent() && t.get().getLanguage().equals(language).collect(Collectors.toList());
            while ((line = br.readLine()) != null)  // while not end string character 
            {  
                // converting line to SimplifiedTweet
                Optional<SimplifiedTweet> tweet = SimplifiedTweet.fromJson(line);
                // if tweet not empty and correct language add it to lTweets
                if (tweet.isPresent() && tweet.get().getLanguage().equals(language)) {
                    gson.toJson(tweet, bw); // write
                }
            } 
            
            br.close(); // close files
            bw.close();
        
        } catch(Exception e){
            e.printStackTrace();
            throw e; 
            }
            
    }
}

// mvn clean package before submission if not not compiling and then not graded