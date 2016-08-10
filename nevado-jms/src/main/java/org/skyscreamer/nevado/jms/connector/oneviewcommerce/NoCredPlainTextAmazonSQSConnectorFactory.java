package org.skyscreamer.nevado.jms.connector.oneviewcommerce;

import org.skyscreamer.nevado.jms.connector.amazonaws.AmazonAwsSQSConnector;
import org.skyscreamer.nevado.jms.connector.amazonaws.AmazonAwsSQSConnectorFactory;

/**
 * Creates a connector that uses plain text serialization and environment based credentials in a non-shaded context.
 */
public class NoCredPlainTextAmazonSQSConnectorFactory extends AmazonAwsSQSConnectorFactory {

	@Override
	protected AmazonAwsSQSConnector createConnector(String awsAccessKey, String awsSecretKey) {
		return new OVCAmazonSQSConnector(awsAccessKey, awsSecretKey, _isSecure, _receiveCheckIntervalMs,
				_useAsyncSend, new PlainTextSerializer(), new NoCredClientFactory());
	}
}
