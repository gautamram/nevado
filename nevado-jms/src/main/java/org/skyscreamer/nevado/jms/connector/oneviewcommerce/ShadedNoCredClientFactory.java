package org.skyscreamer.nevado.jms.connector.oneviewcommerce;

import com.amazonaws.ClientConfiguration;
import com.amazonaws.auth.AWSCredentials;
import com.amazonaws.services.sns.AmazonSNS;
import com.amazonaws.services.sqs.AmazonSQS;

import java.util.concurrent.ExecutorService;

/**
 * Creates shaded clients that authenticate using the environment rather than provided credentials.
 */
public class ShadedNoCredClientFactory implements ClientFactory {
	@Override
	public AmazonSNS getSNSClient(AWSCredentials awsCredentials, ClientConfiguration clientConfiguration) {
		return new ShadedAmazonSNSClient(clientConfiguration);
	}

	@Override
	public AmazonSQS getSQSClient(AWSCredentials awsCredentials, ClientConfiguration clientConfiguration) {
		return new ShadedAmazonSQSClient(clientConfiguration);
	}

	@Override
	public AmazonSNS getAsyncSNSClient(AWSCredentials awsCredentials, ClientConfiguration clientConfiguration, ExecutorService executorService) {
		return new ShadedAmazonSNSAsyncClient(clientConfiguration, executorService);
	}

	@Override
	public AmazonSQS getAsyncSQSClient(AWSCredentials awsCredentials, ClientConfiguration clientConfiguration, ExecutorService executorService) {
		return new ShadedAmazonSQSAsyncClient(clientConfiguration, executorService);
	}
}
