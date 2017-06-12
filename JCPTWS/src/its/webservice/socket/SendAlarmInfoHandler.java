/**
 * Copyright(c) SUPCON 2008-2011. �㽭����п���Ϣ�������޹�˾
 */

package its.webservice.socket;

import java.net.InetSocketAddress;

import org.apache.log4j.Logger;
import org.apache.mina.core.service.IoHandlerAdapter;
import org.apache.mina.core.session.IdleStatus;
import org.apache.mina.core.session.IoSession;


/**
 * ϵͳ���ƣ����ܽ�ͨ����ƽ̨(SMSS)
 * ����ģ�飺�������-���ع�������
 * �������������ع������ݷ���
 * �ļ�����com.supconit.its.socketproxy.SendLivePassVehHandler.java
 * �汾��Ϣ��1.00
 * 
 * �������ţ��з�����
 * �����ߣ� lzk
 * ����ʱ�䣺2011-12-12 ����10:15:09
 * �޸��ߣ� lzk
 * �޸�ʱ�䣺2011-12-12 ����10:15:09
 */

public class SendAlarmInfoHandler extends IoHandlerAdapter{
	
	 private final Logger log = Logger.getLogger(SendAlarmInfoHandler.class.getName());
	 
	//6000s
	//private final int IDLE = 6000;
	
	 /**
	     *  ���캯��
	     */
	public SendAlarmInfoHandler(){
	}
	
	@Override
    public void exceptionCaught(IoSession session, Throwable cause)
            throws Exception {
        //session.close();
		//���ڹر�IoSession���ò���Ҳ���첽�ģ�����ָ��true ��ʾ�����رգ�����������е�д������flush ֮���ٹرա�
        session.close(true);
        //log.debug("session occured exception, so close it.");
        log.debug("pass alarm client session occured exception, so close it." + cause.getMessage());
    }
	
	@Override
	public void sessionCreated(IoSession session) {
		// 
		log.debug("pass alarm Connect to Server ["+session.getServiceAddress().toString()+"] success.");
		//session.write("Connected!");
	}
	
	@Override
	public void messageReceived(IoSession session, Object message)
			throws Exception {
		String str = message.toString();
		log.debug("pass alarm Client receive Message ..." + str);
		log.debug("������"+((InetSocketAddress) session.getServiceAddress()).getAddress().getHostAddress()+"���ӳɹ���");
		
	}

	@Override
	public void sessionClosed(IoSession session) throws Exception {
		 log.debug("pass alarm client sessionClosed.");
	}

	@Override
	public void sessionIdle(IoSession session, IdleStatus status)
			throws Exception {
		log.debug("pass alarm client session idle, so disconnecting......");
        //session.close();
        session.close(true);
        log.debug("pass alarm client disconnected.");
	}
	
	// 
	@Override
	public void messageSent(IoSession session, Object message) throws Exception {
		 log.debug("pass alarm message has Sent.");
		// disconnect an idle client
		//session.close();
    }
	
	@Override
    public void sessionOpened(IoSession session) throws Exception {
		log.debug("pass alarm client sessionOpened.");
        //void setIdleTime(IdleStatus status,int idleTime)������������ù�����ͨ���ϵĶ���д�����Ƕ�д�¼���ָ��ʱ����δ��������ͨ���ͽ����
		//��״̬��һ�����������������ÿ��idleTime ����ص���������IoHandler �е�sessionIdle()
		//������
        //session.getConfig().setIdleTime(IdleStatus.BOTH_IDLE, IDLE);
    }

}
