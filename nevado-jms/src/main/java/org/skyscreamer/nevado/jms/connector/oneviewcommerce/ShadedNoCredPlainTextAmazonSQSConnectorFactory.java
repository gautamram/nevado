package org.skyscreamer.nevado.jms.connector.oneviewcommerce;

import org.skyscreamer.nevado.jms.connector.amazonaws.AmazonAwsSQSConnector;
import org.skyscreamer.nevado.jms.connector.amazonaws.AmazonAwsSQSConnectorFactory;

/**
 * Creates a connector that uses plain text serialization and environment based credentials in a shaded context.
 */
public class ShadedNoCredPlainTextAmazonSQSConnectorFactory extends AmazonAwsSQSConnectorFactory {

	@Override
	protected AmazonAwsSQSConnector createConnector(String awsAccessKey, String awsSecretKey) {
		return new OVCAmazonSQSConnector(null, null, _isSecure, _receiveCheckIntervalMs,
				_useAsyncSend, new PlainTextSerializer(), new ShadedNoCredClientFactory());
	}
}
