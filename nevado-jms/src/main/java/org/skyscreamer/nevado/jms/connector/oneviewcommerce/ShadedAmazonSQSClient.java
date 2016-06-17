package org.skyscreamer.nevado.jms.connector.oneviewcommerce;

import com.amazonaws.ClientConfiguration;
import com.amazonaws.auth.AWSCredentials;
import com.amazonaws.auth.AWSCredentialsProvider;
import com.amazonaws.auth.DefaultAWSCredentialsProviderChain;
import com.amazonaws.metrics.RequestMetricCollector;
import com.amazonaws.services.sqs.AmazonSQSClient;

/**
 * Override to change requestHandler resources
 */
public class ShadedAmazonSQSClient extends AmazonSQSClient {

	private final ResourcePathChanger resourcePathChanger = new ResourcePathChanger(requestHandler2s);

	public ShadedAmazonSQSClient() {
		this(new DefaultAWSCredentialsProviderChain(), new ClientConfiguration());
	}

	public ShadedAmazonSQSClient(AWSCredentials awsCredentials) {
		this(awsCredentials, new ClientConfiguration());
	}

	public ShadedAmazonSQSClient(AWSCredentials awsCredentials, ClientConfiguration clientConfiguration) {
		super(awsCredentials, clientConfiguration);
		resourcePathChanger.changeResPath();
	}

	public ShadedAmazonSQSClient(AWSCredentialsProvider awsCredentialsProvider) {
		this(awsCredentialsProvider, new ClientConfiguration());
	}

	public ShadedAmazonSQSClient(AWSCredentialsProvider awsCredentialsProvider, ClientConfiguration clientConfiguration) {
		this(awsCredentialsProvider, clientConfiguration, null);
	}

	public ShadedAmazonSQSClient(AWSCredentialsProvider awsCredentialsProvider, ClientConfiguration clientConfiguration, RequestMetricCollector requestMetricCollector) {
		super(awsCredentialsProvider, clientConfiguration, requestMetricCollector);
		resourcePathChanger.changeResPath();
	}

	public ShadedAmazonSQSClient(ClientConfiguration clientConfiguration) {
		this(new DefaultAWSCredentialsProviderChain(), clientConfiguration);
	}
}
