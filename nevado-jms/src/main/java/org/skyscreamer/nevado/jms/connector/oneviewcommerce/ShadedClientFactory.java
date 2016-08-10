package org.skyscreamer.nevado.jms.connector.oneviewcommerce;

import com.amazonaws.ClientConfiguration;
import com.amazonaws.auth.AWSCredentials;
import com.amazonaws.services.sns.AmazonSNS;
import com.amazonaws.services.sqs.AmazonSQS;

import java.util.concurrent.ExecutorService;

/**
 * Creates shaded clients which require AWSCredentials
 */
public class ShadedClientFactory implements ClientFactory {

	@Override
	public AmazonSNS getAsyncSNSClient(AWSCredentials awsCredentials, ClientConfiguration clientConfiguration, ExecutorService executorService) {
		checkCredentialsExist(awsCredentials);
		return new ShadedAmazonSNSAsyncClient(awsCredentials, clientConfiguration, executorService);
	}

	private void checkCredentialsExist(AWSCredentials awsCredentials) {
		if (awsCredentials == null) {
			throw new IllegalArgumentException("AWS credentials are required and not provided");
		}
	}

	@Override
	public AmazonSNS getSNSClient(AWSCredentials awsCredentials, ClientConfiguration clientConfiguration) {
		checkCredentialsExist(awsCredentials);
		return new ShadedAmazonSNSClient(awsCredentials, clientConfiguration);
	}

	@Override
	public AmazonSQS getSQSClient(AWSCredentials awsCredentials, ClientConfiguration clientConfiguration) {
		checkCredentialsExist(awsCredentials);
		return new ShadedAmazonSQSClient(awsCredentials, clientConfiguration);
	}

	@Override
	public AmazonSQS getAsyncSQSClient(AWSCredentials awsCredentials, ClientConfiguration clientConfiguration, ExecutorService executorService) {
		return new ShadedAmazonSQSAsyncClient(awsCredentials, clientConfiguration, executorService);
	}
}
