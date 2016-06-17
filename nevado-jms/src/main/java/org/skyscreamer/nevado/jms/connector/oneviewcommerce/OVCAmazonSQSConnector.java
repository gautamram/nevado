package org.skyscreamer.nevado.jms.connector.oneviewcommerce;

import org.skyscreamer.nevado.jms.connector.amazonaws.AmazonAwsSQSConnector;
import org.skyscreamer.nevado.jms.message.NevadoMessage;

import javax.jms.JMSException;

/**
 * Overrides the serialisation handling from AbstractSQSConnector so that raw
 * text messages can be received/sent without wrapping.
 *
 * @author qi.chen
 */
public class OVCAmazonSQSConnector extends AmazonAwsSQSConnector {

	private final MessageSerializer messageSerializer;

	public OVCAmazonSQSConnector(String awsAccessKey, String awsSecretKey, boolean isSecure,
	                             long receiveCheckIntervalMs, boolean isAsync, MessageSerializer messageSerializer,
	                             ClientFactory clientFactory) {

		super(awsAccessKey, awsSecretKey, isSecure, receiveCheckIntervalMs, isAsync, clientFactory);
		this.messageSerializer = messageSerializer;
	}

	@Override
	protected String serializeMessage(NevadoMessage message) throws JMSException {
		if (messageSerializer != null) {
			return messageSerializer.serialize(message);
		} else {
			return super.serializeMessage(message);
		}
	}

	@Override
	protected NevadoMessage deserializeMessage(String serializedMessage) throws JMSException {
		if (messageSerializer != null) {
			return messageSerializer.deserialize(serializedMessage);
		} else {
			return super.deserializeMessage(serializedMessage);
		}
	}

}
