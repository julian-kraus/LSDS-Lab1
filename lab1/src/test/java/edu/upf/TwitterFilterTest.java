package edu.upf;

import org.junit.Test;

import edu.upf.parser.SimplifiedTweet;

import static org.junit.Assert.*;

import java.util.Optional;

import java.io.IOException;

/**
 * Unit test for simple App.
 */
public class TwitterFilterTest
{
    
    /**
     * Rigorous Test :-)
     */
    @Test
    public void shouldAnswerWithTrue()
    {
        assertTrue( true );
    }


    // Place your code here

    // Has structure of a SimplifiedTweet?

    // Test 1 : has all the elements and returns tweet

    @Test
    public void shouldReturnTweet() throws IOException, Exception
    {
            String hello = "{\"tweetId\":0,\"text\":\"test test\",\"userId\":123,\"userName\":\"test\",\"language\":\"es\",\"timestampMs\":15}";
            // Give valid Json String
            Optional<SimplifiedTweet> tweet = SimplifiedTweet.fromJson(hello);
            // OK?         
            // assertE
            SimplifiedTweet tweeter = new SimplifiedTweet(0, "test test", 123, "test", "es", 15);
            String bye = tweeter.toString();
            String bye2 = tweet.get().toString();
            assertEquals("shouldReturnTweet WORKS!", bye, bye2);

    }

    // Test 2 : Returns empty if missing some of the class members

    @Test
    public void shouldReturnEmptyUser() throws IOException
    {
        String hello2 = "{\"user\": ,\"id\": 1,\"name\":\"test\",\"text\":\"hello world\",\"lang\":\"es\",\"timestamp_ms\":15}";;
        // Give valid Json String
        Optional<SimplifiedTweet> tweet2 = SimplifiedTweet.fromJson(hello2);
        // OK?         
        // assertE
        assertEquals("shouldReturnEmpty WORKS!", Optional.empty(), tweet2);
    }

    @Test
    public void shouldReturnEmptyId() throws IOException
    {
        String hello2 = "{\"user\": 1,\"id\": ,\"name\":\"test\",\"text\":\"hello world\",\"lang\":\"es\",\"timestamp_ms\":15}";;
        // Give valid Json String
        Optional<SimplifiedTweet> tweet2 = SimplifiedTweet.fromJson(hello2);
        // OK?         
        // assertE
        assertEquals("shouldReturnEmpty WORKS!", Optional.empty(), tweet2);
    }

    @Test
    public void shouldReturnEmptyName() throws IOException
    {
        String hello2 = "{\"user\": 1,\"id\": 1,\"name\":,\"text\":\"hello world\",\"lang\":\"es\",\"timestamp_ms\":15}";;
        // Give valid Json String
        Optional<SimplifiedTweet> tweet2 = SimplifiedTweet.fromJson(hello2);
        // OK?         
        // assertE
        assertEquals("shouldReturnEmpty WORKS!", Optional.empty(), tweet2);
    }

    @Test
    public void shouldReturnEmptyText() throws IOException
    {
        String hello2 = "{\"user\": 1,\"id\": 1,\"name\":\"test\",\"text\":,\"lang\":\"es\",\"timestamp_ms\":15}";;
        // Give valid Json String
        Optional<SimplifiedTweet> tweet2 = SimplifiedTweet.fromJson(hello2);
        // OK?         
        // assertE
        assertEquals("shouldReturnEmpty WORKS!", Optional.empty(), tweet2);
    }

    @Test
    public void shouldReturnEmptyLang() throws IOException
    {
        String hello2 = "{\"user\": 1,\"id\": 1,\"name\":\"test\",\"text\":\"hello world\",\"lang\":,\"timestamp_ms\":15}";;
        // Give valid Json String
        Optional<SimplifiedTweet> tweet2 = SimplifiedTweet.fromJson(hello2);
        // OK?         
        // assertE
        assertEquals("shouldReturnEmpty WORKS!", Optional.empty(), tweet2);
    }

    @Test
    public void shouldReturnEmptyTms() throws IOException
    {
        String hello2 = "{\"user\": 1,\"id\": 1,\"name\":\"test\",\"text\":\"hello world\",\"lang\":\"es\",\"timestamp_ms\":}";;
        // Give valid Json String
        Optional<SimplifiedTweet> tweet2 = SimplifiedTweet.fromJson(hello2);
        // OK?         
        // assertE
        assertEquals("shouldReturnEmpty WORKS!", Optional.empty(), tweet2);
    }

    // Test 3 : testToString()
    
    @Test
    public void testToString() 
    {
        // Creating a tweet to apply toString()
        SimplifiedTweet tweet = new SimplifiedTweet(0, "test test", 123, "test", "es", 15);

        // Give valid Json String
        String hello = tweet.toString();

        // OK?
        assertEquals("testToString WORKS!", hello, "{\"tweetId\":0,\"text\":\"test test\",\"userId\":123,\"userName\":\"test\",\"language\":\"es\",\"timestampMs\":15}");
    }

}
