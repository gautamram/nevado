package org.skyscreamer.nevado.jms.connector.oneviewcommerce;

import com.amazonaws.ClientConfiguration;
import com.amazonaws.auth.AWSCredentials;
import com.amazonaws.auth.AWSCredentialsProvider;
import com.amazonaws.auth.DefaultAWSCredentialsProviderChain;
import com.amazonaws.services.sns.AmazonSNSAsyncClient;

import java.util.concurrent.ExecutorService;

/**
 * Override to change requestHandler resources
 */
public class ShadedAmazonSNSAsyncClient extends AmazonSNSAsyncClient {

	private ResourcePathChanger resourcePathChanger = new ResourcePathChanger(requestHandler2s);

	public ShadedAmazonSNSAsyncClient() {
		this(new DefaultAWSCredentialsProviderChain());
	}

	public ShadedAmazonSNSAsyncClient(AWSCredentials awsCredentials) {
		super(awsCredentials);
		resourcePathChanger.changeResPath();
	}

	public ShadedAmazonSNSAsyncClient(AWSCredentials awsCredentials, ClientConfiguration clientConfiguration, ExecutorService executorService) {
		super(awsCredentials, clientConfiguration, executorService);
		resourcePathChanger.changeResPath();
	}

	public ShadedAmazonSNSAsyncClient(AWSCredentials awsCredentials, ExecutorService executorService) {
		this(awsCredentials, new ClientConfiguration(), executorService);
	}

	public ShadedAmazonSNSAsyncClient(AWSCredentialsProvider awsCredentialsProvider) {
		this(awsCredentialsProvider, new ClientConfiguration());
	}

	public ShadedAmazonSNSAsyncClient(AWSCredentialsProvider awsCredentialsProvider, ClientConfiguration clientConfiguration) {
		super(awsCredentialsProvider, clientConfiguration);
		resourcePathChanger.changeResPath();
	}

	public ShadedAmazonSNSAsyncClient(AWSCredentialsProvider awsCredentialsProvider, ClientConfiguration clientConfiguration, ExecutorService executorService) {
		super(awsCredentialsProvider, clientConfiguration, executorService);
		resourcePathChanger.changeResPath();
	}

	public ShadedAmazonSNSAsyncClient(AWSCredentialsProvider awsCredentialsProvider, ExecutorService executorService) {
		this(awsCredentialsProvider, new ClientConfiguration(), executorService);
	}

	public ShadedAmazonSNSAsyncClient(ClientConfiguration clientConfiguration, ExecutorService executorService) {
		this(new DefaultAWSCredentialsProviderChain(), clientConfiguration, executorService);
	}

	public ShadedAmazonSNSAsyncClient(ClientConfiguration clientConfiguration) {
		this(new DefaultAWSCredentialsProviderChain(), clientConfiguration);
	}
}
