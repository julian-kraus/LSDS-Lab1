package edu.upf.uploader;

import java.util.List;
import edu.upf.uploader.*;
import java.io.IOException;
import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.AmazonClientException;
import com.amazonaws.auth.profile.ProfileCredentialsProvider;
import com.amazonaws.services.s3.AmazonS3ClientBuilder;
import com.amazonaws.regions.Regions;
import com.amazonaws.services.s3.model.PutObjectRequest;
import java.util.List;
import java.io.File;

public class S3Uploader implements Uploader {

    private final String bucket;
    private final String prefix; 
    private AmazonS3 client;

    // constructor 
    public S3Uploader(String bucket, String prefix, String credentials) {
        this.bucket = bucket;
        this.prefix = prefix;
        this.client = AmazonS3ClientBuilder.standard().withCredentials(new ProfileCredentialsProvider(credentials))
        .withRegion(Regions.US_EAST_1).build();
    }


    @Override
    public void upload(List<String> files) {
        for (int i = 0; i < files.size(); i++) {
            try {
                String f = files.get(i);


                // Checking if bucket exists
                if(client.doesBucketExistV2(bucket)) {
                    
                    // sample.bucket/some/prefix/file1
                    PutObjectRequest request = new PutObjectRequest(this.bucket, prefix, new File(f));
                    // Upload
                    client.putObject(request);
                } else {
                    // Bucket does not exist
                    throw new AmazonClientException("Bucket " + bucket + " doesn't exits");
                }

            } catch (AmazonClientException e) {
                e.printStackTrace();
                throw e; 
            } 
    }
}
}
