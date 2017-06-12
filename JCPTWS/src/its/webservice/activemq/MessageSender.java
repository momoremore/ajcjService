package its.webservice.activemq;

import its.webservice.common.AppInitConstants;

import org.apache.log4j.Logger;
import org.springframework.jms.JmsException;
import org.springframework.jms.core.JmsTemplate;

public class MessageSender {

	protected static Logger log = Logger.getLogger(MessageSender.class
			.getName());

	private static JmsTemplate jmsTemplate = (JmsTemplate) AppInitConstants.APPLICATIONCONTEXT
			.getBean("vehPassJmsTemplate", JmsTemplate.class);

	/*
	 * ������Ϣ
	 */
	public static boolean sendMessage(String message) {
		try {
			jmsTemplate.send(new TextMessageCreator(message));
		} catch (JmsException e) {
			log.error("������Ϣ����message:" + e.getMessage());
			return false;
		}
		return true;
	}
}