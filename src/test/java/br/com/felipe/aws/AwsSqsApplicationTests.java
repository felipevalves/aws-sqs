package br.com.felipe.aws;

import br.com.felipe.aws.sqs.SqsConsumer;
import br.com.felipe.aws.sqs.SqsProducer;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDateTime;

@SpringBootTest
class AwsSqsApplicationTests {

	@Autowired
	private SqsProducer producer;


	@Test
	void test_send_message() throws InterruptedException {

		//producer.sendMessage("test_send_message " + LocalDateTime.now());
		Assertions.assertTrue(true);

		Thread.sleep(3 * 1000);

	}

}
