# LSDS2021-seed
Seed for labs

# Extensions
For the testing we have decided to use AssertEquals to check if the output we expected was equal to the one we decided: 
- We have created 6 functions with 3 different purposes these will test Simplified tweet: 
CORRECT TWEET, RETURNS TWEET
1. ShouldReturnTweet(): parses a tweet that has a correct structure we have decided not to use a line from our twitter collection. But to create another more simple one. As we thought that our code would be clearer with a more simple and shorter one with the same struct. 
RETURNS OPTIONAL.EMPTY()
2. shouldReturnEmptyUser(): A field is missing then it will return an Optional.empty() as this tweet should be discarded
3. shouldReturnSomethingMissing(): a test that parses valid JSON where one of the fields is missing
    IT PARSES INVALID JSON
3. shouldReturnWrongJsonString(): Not correctly expressed 
4. testSomethingHasTheWrongFormat(): The order of instance members is not right
CHECKS THAT THE FUNCTION TO STRING WORKS CORRECTLY
4. testToString(): as it was used in some of the test we thought it would be good to include it 