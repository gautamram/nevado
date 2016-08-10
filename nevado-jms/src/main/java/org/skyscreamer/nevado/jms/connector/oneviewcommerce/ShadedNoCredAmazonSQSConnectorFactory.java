package org.skyscreamer.nevado.jms.connector.oneviewcommerce;

import org.skyscreamer.nevado.jms.connector.amazonaws.AmazonAwsSQSConnector;
import org.skyscreamer.nevado.jms.connector.amazonaws.AmazonAwsSQSConnectorFactory;

/**
 * Creates a connector that uses Hessian serialization and environment credentials in a shaded context.
 */
public class ShadedNoCredAmazonSQSConnectorFactory extends AmazonAwsSQSConnectorFactory {

	@Override
	protected AmazonAwsSQSConnector createConnector(String awsAccessKey, String awsSecretKey) {
		return new OVCAmazonSQSConnector(awsAccessKey, awsSecretKey, _isSecure, _receiveCheckIntervalMs,
				_useAsyncSend, null, new ShadedNoCredClientFactory());
	}
}
