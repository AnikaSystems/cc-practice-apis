/*
 * package com.anikasystems.casemanagement.service.files;
 * 
 * import java.util.List;
 * 
 * 
 * 
 * public class S3ClientService {
 * 
 * private final AmazonS3 amazonS3Client =
 * AmazonS3ClientBuilder.standard().build();
 * 
 * public static void main(String[] args) { Region region = Region.US_EAST_1;
 * S3Client s3 = S3Client.builder() .region(region) .build();
 * 
 * listBuckets(s3); }
 * 
 * public static void listBuckets(S3Client s3) { try { ListBucketsResponse
 * response = s3.listBuckets(); List<Bucket> bucketList = response.buckets();
 * bucketList.forEach(bucket -> { System.out.println("Bucket Name: " +
 * bucket.name()); });
 * 
 * } catch (S3Exception e) {
 * System.err.println(e.awsErrorDetails().errorMessage()); System.exit(1); } }
 * 
 * }
 */