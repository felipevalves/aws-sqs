package br.com.felipe.aws.sqs.config;

import com.amazonaws.services.sqs.AmazonSQS;
import com.amazonaws.services.sqs.AmazonSQSClientBuilder;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Slf4j
@Configuration
public class AwsConfig {

    @Value("${aws.sqs.region}")
    private String region;

    @Bean
    public AmazonSQS sqsAuthentication() {
        log.info("sQsAuthentication...");

        return AmazonSQSClientBuilder
                .standard()
                .withRegion(region)
                .build();
    }

}
