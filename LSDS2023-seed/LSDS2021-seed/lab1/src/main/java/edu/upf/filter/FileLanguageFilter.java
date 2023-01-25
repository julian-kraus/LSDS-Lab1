package edu.upf.filter;
import com.google.gson.Gson;

import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;

public class FileLanguageFilter {
    final String inputFile;
    final String outputFile;
}

void filterLanguage(String language) throws Exception {

    BufferedReader br = new BufferedReader(new FileReader(file));  
    String line = null;  
    List<SimplifiedTweet> lTweets = new ArrayList();

    while ((line = br.readLine()) != null)  
    {  
        Optional tweet = SimplifiedTweet.fromJson(line)
        if (tweet.isPresent() && tweet.get().getLanguage().equals(language) {
            lTweets.add(tweet.get())
        }
    } 

    Gson gson = new Gson();

    List<SimplifiedTweet> lTweets = new ArrayList();

    List<SimplifiedTweet> tweets = gson.fromJson(new JsonReader(new FileReader(inputFile)), new TypeToken<List<SimplifiedTweet>>(){}.getType());
    for (int i = 0; i < tweets.size(); i++){
        if tweets.get(i).getLanguage().equals(language) {
            lTweets.add(tweets.get(i))
        }
    }





}
