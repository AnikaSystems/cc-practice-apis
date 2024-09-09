package com.anikasystems.files.service.config;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.amazonaws.regions.Regions;
import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.AmazonS3ClientBuilder;

import jakarta.annotation.PostConstruct;

@Configuration
public class AppServiceConfiguration {

	private static Logger logger = LoggerFactory.getLogger(AppServiceConfiguration.class);

	@PostConstruct
	public void checkIfYamlIsLoaded() {
		logger.debug("APP YAML configuration loaded successfully!");
	}


	@Bean
	public AmazonS3 S3Client() {		
		/**
		 * can have multiple profiles in your credentials file, which can be added or edited using aws configure --profile PROFILE_NAME to select the profile to configure.
		 */
		logger.debug("Creating s3 client");
		return  AmazonS3ClientBuilder.standard().withRegion(Regions.US_EAST_1).build();		
	}
}
