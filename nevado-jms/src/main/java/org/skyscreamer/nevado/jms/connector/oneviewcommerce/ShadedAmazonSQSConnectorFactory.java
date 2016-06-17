package org.skyscreamer.nevado.jms.connector.oneviewcommerce;

import org.skyscreamer.nevado.jms.connector.amazonaws.AmazonAwsSQSConnector;
import org.skyscreamer.nevado.jms.connector.amazonaws.AmazonAwsSQSConnectorFactory;

/**
 * Creates a connector that uses Hessian serialization and provided credentials in a shaded context.
 */
public class ShadedAmazonSQSConnectorFactory extends AmazonAwsSQSConnectorFactory {

	@Override
	protected AmazonAwsSQSConnector createConnector(String awsAccessKey, String awsSecretKey) {
		return new OVCAmazonSQSConnector(awsAccessKey, awsSecretKey, _isSecure, _receiveCheckIntervalMs,
				_useAsyncSend, null, new ShadedClientFactory());
	}
}
