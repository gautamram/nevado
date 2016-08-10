package org.skyscreamer.nevado.jms.connector.oneviewcommerce;

import org.skyscreamer.nevado.jms.message.NevadoMessage;

import javax.jms.JMSException;

/**
 * Created by ted on 6/16/16.
 */
public interface MessageSerializer {
	String serialize(NevadoMessage message) throws JMSException;

	NevadoMessage deserialize(String serializedMessage) throws JMSException;
}
