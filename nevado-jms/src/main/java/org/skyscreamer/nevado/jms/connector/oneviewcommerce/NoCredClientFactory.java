package org.skyscreamer.nevado.jms.connector.oneviewcommerce;

import com.amazonaws.ClientConfiguration;
import com.amazonaws.auth.AWSCredentials;
import com.amazonaws.auth.DefaultAWSCredentialsProviderChain;
import com.amazonaws.services.sns.AmazonSNS;
import com.amazonaws.services.sns.AmazonSNSAsyncClient;
import com.amazonaws.services.sns.AmazonSNSClient;
import com.amazonaws.services.sqs.AmazonSQS;
import com.amazonaws.services.sqs.AmazonSQSAsyncClient;
import com.amazonaws.services.sqs.AmazonSQSClient;

import java.util.concurrent.ExecutorService;

/**
 * Creates non-shaded clients that authenticate using the environment rather than provided credentials.
 */
class NoCredClientFactory implements ClientFactory {
	@Override
	public AmazonSNS getSNSClient(AWSCredentials awsCredentials, ClientConfiguration clientConfiguration) {
		return new AmazonSNSClient(clientConfiguration);
	}

	@Override
	public AmazonSQS getSQSClient(AWSCredentials awsCredentials, ClientConfiguration clientConfiguration) {
		return new AmazonSQSClient(clientConfiguration);
	}

	@Override
	public AmazonSNS getAsyncSNSClient(AWSCredentials awsCredentials, ClientConfiguration clientConfiguration, ExecutorService executorService) {
		return new AmazonSNSAsyncClient(new DefaultAWSCredentialsProviderChain(), clientConfiguration, executorService);
	}

	@Override
	public AmazonSQS getAsyncSQSClient(AWSCredentials awsCredentials, ClientConfiguration clientConfiguration, ExecutorService executorService) {
		return new AmazonSQSAsyncClient(new DefaultAWSCredentialsProviderChain(), clientConfiguration, executorService);
	}
}
