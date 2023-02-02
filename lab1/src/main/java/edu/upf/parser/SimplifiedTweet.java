package edu.upf.parser;

import java.util.Optional;
import java.io.FileReader;
import java.io.StringReader;
import java.io.IOException; 

import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.google.gson.stream.JsonReader;
import com.google.gson.JsonParseException;


public class SimplifiedTweet {

    // members
    private final long tweetId;  // the id of the tweet (’id’)
    private final String text;   // the content of the tweet (’text’)
    private final long userId;   // the user id (’user->id’)
    private final String userName; // the user name (’user’->’name’)
    private final String language; // the language of a tweet (’lang’)
    private final long timestampMs; // seconds from epoch (’timestamp_ms’)

    // Constructor
    public SimplifiedTweet(long tweetId, String text, long userId, String userName, String language, long timestampMs) {
            this.tweetId = tweetId;
            this.text = text;
            this.userId = userId;
            this.userName = userName;
            this.language = language;
            this.timestampMs = timestampMs;
        }


    // any other method that might be of use (think of a typical Java Object)

    // getters for each class member
    public long getTweetId() {
        return tweetId;
    }

    public String getText() {
        return text;
    }

    public long getUserId() {
        return userId;
    }

    public String getUserName() {
        return userName;
    }

    public long getTimestampMs() {
        return timestampMs;
    }

    /**
    * Returns a {@link SimplifiedTweet} from a JSON String.
    * If parsing fails, for any reason, return an {@link Optional#empty()}
    *
    * @param jsonStr
    * @return an {@link Optional} of a {@link SimplifiedTweet}
    */

    public static Optional<SimplifiedTweet> fromJson(String jsonStr) throws IOException{
	
        SimplifiedTweet tweet = null;
        
        try{
            
          JsonElement je = JsonParser.parseString(jsonStr);
          Optional <JsonElement> opt_je = Optional.ofNullable(je);
          JsonObject  jo = opt_je.get().getAsJsonObject();
          
          if(jo.has("user")){
            JsonObject userObj = jo.getAsJsonObject("user");
            if(userObj.has("id") && userObj.has("id") && userObj.has("name") && userObj.has("text") && userObj.has("lang") && userObj.has("timestamp_ms")){
              Long userId = userObj.get("id").getAsLong();
              Long tweetId = jo.get("id").getAsLong();
              String userName = userObj.get("name").getAsString();
              String text= jo.get("text").getAsString();
              String lang = jo.get("lang").getAsString();
              Long timeStamp = jo.get("timestamp_ms").getAsLong();
    
              tweet = new SimplifiedTweet(tweetId, text, userId, userName, lang, timeStamp);
            } else {
              return Optional.empty();
            }
          }else{
              return Optional.empty();
          }
          return Optional.ofNullable(tweet);
    
        }catch(Exception e){
          return Optional.empty();
        }
    
      }


    public String getLanguage() {
        return this.language;
    }

    @Override
    public String toString() {
        // Overriding how SimplifiedTweets are printed in console or the output file
        // The following line produces valid JSON as output
        return new Gson().toJson(this);
    }

}