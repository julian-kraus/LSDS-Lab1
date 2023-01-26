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

    public String getLanguage() {
        return language;
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

    public static Optional<SimplifiedTweet> fromJson(String jsonStr) {
        try {
            // new instance of Gson
            Gson gson = new Gson(); 
            // using the argument 
            JsonReader reader = new JsonReader(new FileReader(filename));
            // parses the argument and converts it to SimplifiedTweet if can't (not containing all instance members)
            // then exception
            Optional<SimplifiedTweet> tweet = Optional.ofNullable(gson.fromJson(reader, SimplifiedTweet.class))
            // reader.close();
            return tweet; 

        } catch (JsonParseException e) { // Todo check
            // if raised an exception then as can't return null return empty (not successful passing to SimplifiedTweet)
            // reader.close();
            return Optional.empty();                              
        }finally{
            reader.close();
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