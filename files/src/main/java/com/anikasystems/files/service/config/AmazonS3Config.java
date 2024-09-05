package com.anikasystems.files.service.config;

import com.amazonaws.auth.AWSStaticCredentialsProvider;
import com.amazonaws.auth.BasicAWSCredentials;
import com.amazonaws.auth.SystemPropertiesCredentialsProvider;
import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.AmazonS3ClientBuilder;

import jakarta.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AmazonS3Config {

    @Value("${aws.accessKeyId}")
    private String accessKeyId;

    @Value("${aws.secretKey}")
    private String secretKey;

    @Value("${aws.region.static}")
    private String region;

    @Bean
    public AmazonS3 S3Client() {
        BasicAWSCredentials credentials = new BasicAWSCredentials(accessKeyId, secretKey);
        return AmazonS3ClientBuilder
                .standard()
                .withCredentials(new AWSStaticCredentialsProvider(credentials))
                .withRegion(region)
                .build();
    }

    @PostConstruct
    public void setSystemProperty() {
        SystemPropertiesCredentialsProvider systemPropertiesCredentialsProvider = new SystemPropertiesCredentialsProvider();

        System.setProperty("aws.accessKeyId", accessKeyId);
        System.setProperty("aws.secretAccessKey", secretKey);
    }
}
