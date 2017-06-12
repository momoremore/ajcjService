package its.webservice.socket;

import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;

import its.webservice.activemq.MessageSender;
import its.webservice.common.AppInitConstants;
import its.webservice.common.ItsConstants;

/**
 *@author zhangxiaoqiang
 *@date 2015����11:18:57
 *@description ����MQ�߳�
 */
public class SendMQInfo implements Runnable{
	Logger log=Logger.getLogger(SendMQInfo.class);
	@Override
	public void run() {
		while(true){
			int mqQueueSize = AppInitConstants.sendMQQueue.size();
			if (mqQueueSize>0) {
				boolean a= MessageSender.sendMessage(AppInitConstants.sendMQQueue.poll());
				if (a) {
					log.debug("���η���ʵʱ�������ݵ�MQ�ɹ������г��ȣ�"+mqQueueSize);
					log.error("���η���ʵʱ�������ݵ�MQ�ɹ������г��ȣ�"+mqQueueSize);
				}
			}else if(mqQueueSize==ItsConstants.MAX_STAY_MSG){
				AppInitConstants.sendMQQueue.poll();
			}else {
				try {
					TimeUnit.SECONDS.sleep(1);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
			
		}
	}

}
