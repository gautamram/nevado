package org.skyscreamer.nevado.jms.connector.oneviewcommerce;

import org.skyscreamer.nevado.jms.message.NevadoMessage;
import org.skyscreamer.nevado.jms.message.NevadoTextMessage;

import javax.jms.JMSException;
import javax.jms.TextMessage;

/**
 * Supports converting TextMessages to and from their plain text representation
 */
class PlainTextSerializer implements MessageSerializer {

	@Override
	public String serialize(NevadoMessage message) throws JMSException {
		if (message instanceof TextMessage) {
			return ((TextMessage) message).getText();
		} else {
			throw new UnsupportedOperationException(getClass().getSimpleName() + " does not support " + message);
		}
	}

	@Override
	public NevadoMessage deserialize(String serializedMessage) throws JMSException {
		NevadoTextMessage out = new NevadoTextMessage();
		out.setText(serializedMessage);
		return out;
	}
}
