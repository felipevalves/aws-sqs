package br.com.felipe.aws.sqs;

import lombok.extern.slf4j.Slf4j;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class SqsConsumer {

    @JmsListener(destination = "${aws.sqs.queue}")
    public void receive(String message) {
        log.info("message received {}", message);
    }
}
