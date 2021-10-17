package br.com.felipe.aws.sqs;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Service;

@Service
public class SqsProducer {

    @Autowired
    private JmsTemplate jmsTemplate;
    @Value("${aws.sqs.queue}")
    private String queue;

    public void sendMessage(String message) {

        jmsTemplate.convertAndSend(queue, message);

    }
}
