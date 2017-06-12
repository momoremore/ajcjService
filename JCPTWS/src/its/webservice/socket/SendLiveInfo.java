/**
 * Copyright(c) SUPCON 2008-2011. �㽭����п���Ϣ�������޹�˾
 */

package its.webservice.socket;

import its.webservice.common.AppInitConstants;
import java.net.InetSocketAddress;
import java.util.Date;

import org.apache.log4j.Logger;
import org.apache.mina.core.filterchain.DefaultIoFilterChainBuilder;
import org.apache.mina.core.future.ConnectFuture;
import org.apache.mina.core.service.IoConnector;
import org.apache.mina.filter.codec.ProtocolCodecFilter;
import org.apache.mina.filter.codec.textline.TextLineCodecFactory;
import org.apache.mina.filter.logging.LoggingFilter;
import org.apache.mina.transport.socket.nio.NioSocketConnector;


/**
 * ϵͳ���ƣ����ܽ�ͨ����ƽ̨(SMSS)
 * ����ģ�飺XXXXXXXXXXXXXX
 * ����������XXXXXXXXXXXXXX
 * �ļ�����com.supconit.its.socketproxy.SendLivePassVeh.java
 * �汾��Ϣ��1.00
 * 
 * �������ţ��з�����
 * �����ߣ� lzk
 * ����ʱ�䣺2011-12-12 ����10:09:31
 * �޸��ߣ� lzk
 * �޸�ʱ�䣺2011-12-12 ����10:09:31
 */

public class SendLiveInfo extends Thread {
	
	private final static Logger log = Logger.getLogger(SendLiveInfo.class.getName());
	
	boolean isStillConn = false;
	
	String passInfo = "";
	
	int sleeptime = 1;
	
	NioSocketConnector connector = null;
	DefaultIoFilterChainBuilder chain = null;
	ConnectFuture cf = null;
	
	public SendLiveInfo(){
	}
	
	
	public void run(){
		System.out.println("so+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++");
		connector = new NioSocketConnector();
		chain = connector.getFilterChain();
		chain.addLast( "logger", new LoggingFilter() );
		chain.addLast( "codec", new ProtocolCodecFilter( new TextLineCodecFactory()) );
		connector.setHandler(new SendLiveInfoHandler());
		connector.setConnectTimeoutMillis(500);
		cf = connector.connect(new InetSocketAddress(AppInitConstants.SOCKET_PROXY_SERVER_IP, AppInitConstants.SOCKET_PROXY_SERVER_PORT));//�������� 
		cf.awaitUninterruptibly();//�ȴ����Ӵ������ 
		//����ָ��ʱ����û���ӳɹ������׳��쳣
		if(cf.isDone()){
			try {
				while  (cf.getSession().isConnected()) {
					while  (!AppInitConstants.vehPassInfoQueue.isEmpty() && AppInitConstants.vehPassInfoQueue.size()>0) {
						System.out.println("go+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++");
						log.debug("Live queue remain size : " + AppInitConstants.vehAlarmInfoQueue.size());
						passInfo = AppInitConstants.vehPassInfoQueue.take();
						cf.getSession().write(passInfo);//������Ϣ 
						//cf.getSession().getCloseFuture().awaitUninterruptibly();//�ȴ����ӶϿ�
						//connector.dispose(); 
					//}else{
						//log.error("fail to connect server at " + new Date());
						 //connector.dispose();    //���رյĻ�������һ��ʱ����׳���too many open files�쳣�������޷����� 
					}
					try {
						Thread.sleep(100);
						//log.debug("ʵʱ�������п��У��ȴ��С���");
					} catch (InterruptedException e) {
						e.printStackTrace();
						log.error("send live thread sleep error��"+e.getMessage());
					}
					sleeptime = 1;
				}
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				log.error("send live connect to SMSS error��"+e.getMessage());
				isStillConn = false;
				connector.dispose(); 
			}
		}
		while(true){
			try{
				isStillConn = cf.getSession().isConnected();
				log.debug("send live is connect?"+cf.getSession().isConnected());
			}catch(Exception e){
				//e.printStackTrace();
				log.debug("send live connect to smss has failed ..." + e.getMessage());
				isStillConn = false;
				connector.dispose(); 
			}
			if(!isStillConn){
				log.debug("send live restart connect to smss at " + new Date());
				try {
					Thread.sleep( 60000*sleeptime );
					sleeptime++;
					if(sleeptime >= 60)
						sleeptime = 60;
					//log.debug("send live wait connect to smss...");
				} catch (InterruptedException e) {
					//e.printStackTrace();
					log.error("send live connect to SMSS failed��"+e.getMessage());
				}
				
				this.run();
			}else{
				sleeptime = 1;
			}
		}
		
	}
	
	
	public static void main(String[] args) {
		// �����ͻ���������. 
		//NioSocketConnector connector = new NioSocketConnector(); 
		IoConnector connector = new NioSocketConnector(); 
		connector.getFilterChain().addLast( "logger", new LoggingFilter() ); 
		//connector.getFilterChain().addLast( "codec", new ProtocolCodecFilter( new TextLineCodecFactory( Charset.forName( "UTF-8" )))); //���ñ��������
		//TextLineCodecFactory:ֻҪ�����ĸ��ֽ����ŵ���ASCII ��10��13 �ַ���\r��\n��������Ϊ֮ǰ���ֽھ���һ���ַ�����Ĭ��ʹ��UTF-8 ���룩��
		connector.getFilterChain().addLast( "codec", new ProtocolCodecFilter( new TextLineCodecFactory()));
		//connector.setConnectTimeout(30); 
		connector.setConnectTimeoutMillis(500);
		//SendLiveInfoHandler slpvh = new SendLiveInfoHandler();
		connector.setHandler(new SendLiveInfoHandler());//�����¼�������  
		ConnectFuture cf = connector.connect(new InetSocketAddress(AppInitConstants.SOCKET_PROXY_SERVER_IP, AppInitConstants.SOCKET_PROXY_SERVER_PORT));//�������� 
		cf.awaitUninterruptibly();//�ȴ����Ӵ������ 
		cf.getSession().write("test");//������Ϣ 
		cf.getSession().getCloseFuture().awaitUninterruptibly();//�ȴ����ӶϿ� 
		connector.dispose(); 
		
	}

}
