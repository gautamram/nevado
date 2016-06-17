package org.skyscreamer.nevado.jms.connector.oneviewcommerce;

import com.amazonaws.ClientConfiguration;
import com.amazonaws.auth.AWSCredentials;
import com.amazonaws.auth.AWSCredentialsProvider;
import com.amazonaws.auth.DefaultAWSCredentialsProviderChain;
import com.amazonaws.services.sqs.AmazonSQSAsyncClient;

import java.util.concurrent.ExecutorService;

/**
 * Override to change requestHandler resources
 */
public class ShadedAmazonSQSAsyncClient extends AmazonSQSAsyncClient {

	private final ResourcePathChanger resourcePathChanger = new ResourcePathChanger(requestHandler2s);

	public ShadedAmazonSQSAsyncClient() {
		this(new DefaultAWSCredentialsProviderChain());
	}

	public ShadedAmazonSQSAsyncClient(AWSCredentials awsCredentials) {
		super(awsCredentials);
		resourcePathChanger.changeResPath();
	}

	public ShadedAmazonSQSAsyncClient(AWSCredentials awsCredentials, ClientConfiguration clientConfiguration, ExecutorService executorService) {
		super(awsCredentials, clientConfiguration, executorService);
		resourcePathChanger.changeResPath();
	}

	public ShadedAmazonSQSAsyncClient(AWSCredentials awsCredentials, ExecutorService executorService) {
		this(awsCredentials, new ClientConfiguration(), executorService);
	}

	public ShadedAmazonSQSAsyncClient(AWSCredentialsProvider awsCredentialsProvider) {
		this(awsCredentialsProvider, new ClientConfiguration());
	}

	public ShadedAmazonSQSAsyncClient(AWSCredentialsProvider awsCredentialsProvider, ClientConfiguration clientConfiguration) {
		super(awsCredentialsProvider, clientConfiguration);
		resourcePathChanger.changeResPath();
	}

	public ShadedAmazonSQSAsyncClient(AWSCredentialsProvider awsCredentialsProvider, ClientConfiguration clientConfiguration, ExecutorService executorService) {
		super(awsCredentialsProvider, clientConfiguration, executorService);
		resourcePathChanger.changeResPath();
	}

	public ShadedAmazonSQSAsyncClient(AWSCredentialsProvider awsCredentialsProvider, ExecutorService executorService) {
		this(awsCredentialsProvider, new ClientConfiguration(), executorService);
	}

	public ShadedAmazonSQSAsyncClient(ClientConfiguration clientConfiguration) {
		this(new DefaultAWSCredentialsProviderChain(), clientConfiguration);
	}

	public ShadedAmazonSQSAsyncClient(ClientConfiguration clientConfiguration, ExecutorService executorService) {
		this(new DefaultAWSCredentialsProviderChain(), clientConfiguration, executorService);
	}
}
