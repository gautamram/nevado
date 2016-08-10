package org.skyscreamer.nevado.jms.connector.oneviewcommerce;

import org.skyscreamer.nevado.jms.connector.amazonaws.AmazonAwsSQSConnector;
import org.skyscreamer.nevado.jms.connector.amazonaws.AmazonAwsSQSConnectorFactory;

/**
 * Creates a connector that uses plain text serialization and provided credentials in a non-shaded context.
 */
public class PlainTextAmazonSQSConnectorFactory extends AmazonAwsSQSConnectorFactory {

    @Override
    protected AmazonAwsSQSConnector createConnector(String awsAccessKey, String awsSecretKey) {
        return new OVCAmazonSQSConnector(awsAccessKey, awsSecretKey, _isSecure, _receiveCheckIntervalMs,
                _useAsyncSend, new PlainTextSerializer(), null);
    }

}
