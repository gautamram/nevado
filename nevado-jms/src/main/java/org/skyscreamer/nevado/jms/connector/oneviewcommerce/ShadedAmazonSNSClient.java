package org.skyscreamer.nevado.jms.connector.oneviewcommerce;

import com.amazonaws.ClientConfiguration;
import com.amazonaws.auth.AWSCredentials;
import com.amazonaws.auth.AWSCredentialsProvider;
import com.amazonaws.auth.DefaultAWSCredentialsProviderChain;
import com.amazonaws.metrics.RequestMetricCollector;
import com.amazonaws.services.sns.AmazonSNSClient;

/**
 * Override to change requestHandler resources
 */
public class ShadedAmazonSNSClient extends AmazonSNSClient {

	private final ResourcePathChanger resourcePathChanger = new ResourcePathChanger(requestHandler2s);

	public ShadedAmazonSNSClient() {
		this(new DefaultAWSCredentialsProviderChain(), new ClientConfiguration());
	}

	public ShadedAmazonSNSClient(AWSCredentials awsCredentials) {
		this(awsCredentials, new ClientConfiguration());
	}

	public ShadedAmazonSNSClient(AWSCredentials awsCredentials, ClientConfiguration clientConfiguration) {
		super(awsCredentials, clientConfiguration);
		resourcePathChanger.changeResPath();
	}

	public ShadedAmazonSNSClient(AWSCredentialsProvider awsCredentialsProvider) {
		this(awsCredentialsProvider, new ClientConfiguration());
	}

	public ShadedAmazonSNSClient(AWSCredentialsProvider awsCredentialsProvider, ClientConfiguration clientConfiguration) {
		this(awsCredentialsProvider, clientConfiguration, null);
	}

	public ShadedAmazonSNSClient(AWSCredentialsProvider awsCredentialsProvider, ClientConfiguration clientConfiguration, RequestMetricCollector requestMetricCollector) {
		super(awsCredentialsProvider, clientConfiguration, requestMetricCollector);
		resourcePathChanger.changeResPath();
	}

	public ShadedAmazonSNSClient(ClientConfiguration clientConfiguration) {
		this(new DefaultAWSCredentialsProviderChain(), clientConfiguration);
	}
}
