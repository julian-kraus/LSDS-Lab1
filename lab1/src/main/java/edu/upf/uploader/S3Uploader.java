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
    private final String profile; 

    // constructor 
    public S3Uploader(String bucket, String prefix, String profile) {
        this.bucket = bucket;
        this.prefix = prefix;
        this.profile = profile;
    }


    @Override
    public void upload(List<String> files) {
        Regions clientRegion = Regions.DEFAULT_REGION;
        for (int i = 0; i < files.size(); i++) {
            try {
                String f = files.get(i);
                AmazonS3 s3Client = AmazonS3ClientBuilder.standard()
                        .withRegion(clientRegion)
                        .build();

                // Checking if bucket exists
                if(s3Client.doesBucketExistV2(bucket)) {
                    
                    // sample.bucket/some/prefix/file1
                    PutObjectRequest request = new PutObjectRequest(this.bucket, prefix, new File(f));
                    // Upload
                    s3Client.putObject(request);
                } else {
                    // Bucket does not exist
                    throw new AmazonClientException("Bucket " + bucket + " doesn't exits!!");
                }

            } catch (AmazonClientException e) {
                e.printStackTrace();
                throw e; 
            } 
    }
}
}
