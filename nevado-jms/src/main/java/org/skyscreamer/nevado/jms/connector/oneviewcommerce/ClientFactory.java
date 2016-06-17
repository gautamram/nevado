package org.skyscreamer.nevado.jms.connector.oneviewcommerce;

import com.amazonaws.ClientConfiguration;
import com.amazonaws.auth.AWSCredentials;
import com.amazonaws.services.sns.AmazonSNS;
import com.amazonaws.services.sqs.AmazonSQS;

import java.util.concurrent.ExecutorService;

/**
 * Creates SNS and SQS clients based on XML configuration in an abstract factory pattern.
 */
public interface ClientFactory {

	AmazonSNS getSNSClient(AWSCredentials awsCredentials, ClientConfiguration clientConfiguration);
	AmazonSQS getSQSClient(AWSCredentials awsCredentials, ClientConfiguration clientConfiguration);
	AmazonSNS getAsyncSNSClient(AWSCredentials awsCredentials, ClientConfiguration clientConfiguration, ExecutorService executorService);
	AmazonSQS getAsyncSQSClient(AWSCredentials awsCredentials, ClientConfiguration clientConfiguration, ExecutorService executorService);
}
