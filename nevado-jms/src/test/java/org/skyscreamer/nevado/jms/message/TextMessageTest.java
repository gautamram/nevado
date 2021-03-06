package org.skyscreamer.nevado.jms.message;

import org.activemq.message.ActiveMQTextMessage;
import org.junit.Assert;
import org.junit.Test;
import org.skyscreamer.nevado.jms.AbstractJMSTest;
import org.skyscreamer.nevado.jms.util.RandomData;
import org.w3c.dom.Document;
import org.xml.sax.InputSource;

import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.TextMessage;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathFactory;
import java.io.StringReader;

/**
 * Created by IntelliJ IDEA.
 * User: Carter Page
 * Date: 3/22/12
 * Time: 3:22 AM
 */
public class TextMessageTest extends AbstractJMSTest {
    @Test
    public void testTextMessage() throws JMSException {
        TextMessage msg = createSession().createTextMessage();
        testTextMessage(msg);
    }

    @Test
    public void testAlienTextMessage() throws JMSException {
        TextMessage msg = new ActiveMQTextMessage();
        testTextMessage(msg);
    }

    private void testTextMessage(TextMessage msg) throws JMSException {
        String text = "How much wood could a woodchuck chuck?  " + RandomData.readInt() + " logs!";
        msg.setText(text);
        Message msgOut = sendAndReceive(msg);
        Assert.assertTrue("Should be a text message", msgOut instanceof TextMessage);
        Assert.assertEquals("Text should match", text, ((TextMessage)msgOut).getText());
    }

    @Test
    public void testTextMessage2() throws JMSException {
        String text = "How much wood could a woodchuck chuck?  " + RandomData.readInt() + " logs!";
        TextMessage msg = createSession().createTextMessage(text);
        Message msgOut = sendAndReceive(msg);
        Assert.assertTrue("Should be a text message", msgOut instanceof TextMessage);
        Assert.assertEquals("Text should match", text, ((TextMessage)msgOut).getText());
    }
    
    @Test
    public void testXmlMessage() throws Exception {
        String text = "<samplexml><a><b><c x=\"y\">d</c></b></a></samplexml>";
        TextMessage msg = createSession().createTextMessage(text);
        Message msgOut = sendAndReceive(msg);
        Assert.assertTrue("Should be a text message", msgOut instanceof TextMessage);

        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder = factory.newDocumentBuilder();
        InputSource is = new InputSource(new StringReader(((TextMessage)msgOut).getText()));
        Document doc = builder.parse(is);
        XPath xpath = XPathFactory.newInstance().newXPath();
        Assert.assertEquals("d", xpath.evaluate("/samplexml/a/b/c", doc));
        Assert.assertEquals("y", xpath.evaluate("/samplexml/a/b/c/@x", doc));
    }
}
