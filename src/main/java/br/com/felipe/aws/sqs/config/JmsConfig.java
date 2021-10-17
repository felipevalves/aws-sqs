package br.com.felipe.aws.sqs.config;


import com.amazon.sqs.javamessaging.ProviderConfiguration;
import com.amazon.sqs.javamessaging.SQSConnectionFactory;
import com.amazonaws.services.sqs.AmazonSQS;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jms.annotation.EnableJms;
import org.springframework.jms.config.DefaultJmsListenerContainerFactory;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.jms.support.destination.DynamicDestinationResolver;


import javax.annotation.PostConstruct;
import javax.jms.Session;


@Configuration
@EnableJms
@Slf4j
public class JmsConfig {

    @Autowired
    private AmazonSQS sqsClient;
    private SQSConnectionFactory connectionFactory;

    @PostConstruct
    public void init() {
        log.info("init SQSConnectionFactory");
        connectionFactory = new SQSConnectionFactory(new ProviderConfiguration(), sqsClient);

    }

    @Bean
    public DefaultJmsListenerContainerFactory jmsListenerContainerFactory() {
        DefaultJmsListenerContainerFactory factory = new DefaultJmsListenerContainerFactory();
        factory.setConnectionFactory(this.connectionFactory);
        factory.setDestinationResolver(new DynamicDestinationResolver());
        factory.setSessionAcknowledgeMode(Session.AUTO_ACKNOWLEDGE);

        return factory;
    }

    @Bean
    public JmsTemplate defaultJmsTemplate(){
        return new JmsTemplate(this.connectionFactory);
    }

}
