package its.webservice.util;

import java.io.IOException;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.net.UnknownHostException;
import org.apache.commons.lang.StringUtils;
import org.apache.log4j.Logger;

public class PingNetWork {
	// The default daytime port 445 135 139, Ҫ�������������뿪���������˿�,
	// ���Ĭ��Ҫping�ķ�������������445�˿�
	static int DAYTIME_PORT = 445;
	
    protected static Logger log = Logger.getLogger(PingNetWork.class.getName());


	public static void main(String[] args) {
		try {
			PingNetWork.validateServerConnections("10.10.76.71", "345","ping");
			PingNetWork.validateServerConnections("10.10.76.75", "3000","telnet");
		} catch (InterruptedException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	/**
	 * ��֤��������״̬[ping telnet]
	 * @param  host String
	 * @param  port  String
	 * @param  type  String
	 * @return boolean ���Գɹ�����true, ʧ��false
	 * @author LVHUA 
	 * @date   2012-02-27
	 */
	public static boolean validateServerConnections(String host, String port, String type) throws InterruptedException, IOException {
		Socket server = null;
		InetAddress address = null;
		InetSocketAddress picAddress = null;
		
		if (StringUtils.isNotEmpty(host)) {  	// ����Socket��connect(SocketAddress endpoint, int  timeout)��������ʵ��telnet�Ĺ��ܣ����catch���쳣˵��telnetʧ��
			try {
				server = new Socket();
				picAddress = new InetSocketAddress(host, Integer.valueOf(port));
				server.connect(picAddress, 5000);  // �ȴ�5����
				if (server.isConnected()) {
					log.debug(host + " Telnet�ɹ�!");
					server.close();
					return true;
				} else {
					server.close();
					log.debug(host + " Telnetʧ��!");
					return false;
				}
			} catch (UnknownHostException e) {
				log.debug(host + " Telnetʧ��!");
			} catch (IOException e) {
				log.debug(host + " Telnetʧ��!");
				return false;
			} finally {
				server.close();
			}
		}
		
	/*	if (StringUtils.isNotEmpty(host) && type.equals("ping")) {
			try {
				if (StringUtils.isNotEmpty(host) && type.equals("ping")) {
					address = InetAddress.getByName(host);
					if (address.isReachable(5000)) { //    �ȴ�5���� ����InetAddress��isReachable��������ʵ��ping�Ĺ���
						log.debug(host + " Ping�ɹ�!");
						return true;
					} else {
						log.debug(host + " Pingʧ��!");
						return false;
					}
				}
			} catch (UnknownHostException e) {
				e.printStackTrace();
				log.debug(host + " Pingʧ��!");
			} catch (IOException e) {
				e.printStackTrace();
				log.debug(host + " Pingʧ��!");
			} finally {
				;
			}
		}*/
		return false;
	}

	
	/**
	 * ��֤��������״̬[ping telnet]
	 * @param  host String
	 * @param  port  String
	 * @param  type  String
	 * @return boolean ���Գɹ�����true, ʧ��false
	 * @author LVHUA 
	 * @date   2012-02-27
	 */
	public static  String  pingDeviceWork(String host, String port, String type) throws InterruptedException, IOException {
		Socket server = null;
		InetAddress address = null;
		InetSocketAddress picAddress = null;
		String  flag = "1";
		
		if (StringUtils.isNotEmpty(host)) {  	// ����Socket��connect(SocketAddress endpoint, int  timeout)��������ʵ��telnet�Ĺ��ܣ����catch���쳣˵��telnetʧ��
			try {
				server = new Socket();
				picAddress = new InetSocketAddress(host, Integer.valueOf(port));
				server.connect(picAddress, 5000);  // �ȴ�5����
				if (server.isConnected()) {
					server.close();
					return "0";
				} else {
					server.close();
					return "1";
				}
			} catch (UnknownHostException e) {
				//log.debug(host + " Telnetʧ��!");
				return "1";
			} catch (IOException e) {
				//log.debug(host + " Telnetʧ��!");
				return "1";
			} finally {
				server.close();
			}
		}
		
	/*	if (StringUtils.isNotEmpty(host) && type.equals("ping")) {
			try {
				if (StringUtils.isNotEmpty(host) && type.equals("ping")) {
					address = InetAddress.getByName(host);
					if (address.isReachable(5000)) { //    �ȴ�5���� ����InetAddress��isReachable��������ʵ��ping�Ĺ���
						log.debug(host + " Ping�ɹ�!");
						return "0";
					} else {
						log.debug(host + " Pingʧ��!");
						return "1";
					}
				}
			} catch (UnknownHostException e) {
				e.printStackTrace();
				//log.debug(host + " Pingʧ��!");
				return "1";
			} catch (IOException e) {
				e.printStackTrace();
				//log.debug(host + " Pingʧ��!");
				return "1";
			} finally {
				;
			}
		}*/
		return flag;
	}
}
