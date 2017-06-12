/**
 * Copyright(c) SUPCON 2008-2011. �㽭����п���Ϣ�������޹�˾
 */

package its.webservice.appinit;


import its.webservice.activemq.ServiceTest;
import its.webservice.common.AppInitConstants;
import its.webservice.config.SystemConfig;
import its.webservice.dao.ApplicationDao;
import its.webservice.socket.SendAlarmInfo;
import its.webservice.socket.SendLiveInfo;
import its.webservice.socket.SendMQInfo;
import its.webservice.socket.SendReWritePicInfo;
import its.webservice.util.ItsUtility;

import java.lang.reflect.Field;
import java.util.Map;

import org.apache.log4j.Logger;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;


/**
 * ϵͳ���ƣ����ܽ�ͨWebService����(ITSWebService)
 * ����ģ�飺ϵͳ��ʼ��
 * ����������ϵͳ����ʱ��ʼ��
 * �ļ�����its.webservice.control.AppInitController.java
 * �汾��Ϣ��1.00
 * 
 * �������ţ��з�����
 * �����ߣ� lzk
 * ����ʱ�䣺Feb 14, 2011 1:15:35 PM
 * �޸��ߣ� lzk
 * �޸�ʱ�䣺Feb 14, 2011 1:15:35 PM
 */

public class AppInition implements InitializingBean,ApplicationContextAware{
	
	/** ��ȡLog4jʵ�� */
    protected Logger log = Logger.getLogger(AppInition.class.getName());
	
    private ApplicationDao applicationDao;
    
	public ApplicationDao getApplicationDao() {
		return applicationDao;
	}

	public void setApplicationDao(ApplicationDao applicationDao) {
		this.applicationDao = applicationDao;
	}
	
	@Override
	public void afterPropertiesSet() throws Exception {
	//	log.debug("App.afterPropertiesSet init Start .....................");
	//	SendLiveInfo liveInfo = new SendLiveInfo();
	//	liveInfo.start();
	//	log.error("ʵʱ���������߳���������");
    //	SendAlarmInfo alarmInfo = new SendAlarmInfo();
    //	alarmInfo.start();
    //	log.error("ʵʱ���������߳���������");
	//	log.debug("App.afterPropertiesSet init End .....................");
		
	//	SendMQInfo mqSend=new SendMQInfo();
	//	new Thread(mqSend).start();
	//	log.error("ʵʱ������ͼƬ����MQ��������");
		
		log.error("��дͼƬ�߳�����");
		SendReWritePicInfo reWritePicInfo = new SendReWritePicInfo();
		new Thread(reWritePicInfo).start();
		
	}
    
	protected void initialize() {
	    log.debug("AppInition.initialize() Start...");
	    
	    /** ��ʼ�������ֵ� */
    	AppInitConstants.DICTIONARY_LIST = applicationDao.getDictionary();
	    
	  //��ʼ��·���б�, ��·�ڱ䶯ʱ, ��Ҫ��ʱ����ñ�����ֵ
    	AppInitConstants.ALL_CROSS_MAP = applicationDao.getAllCrossList();
	    
	    /** ��ʼ��ϵͳ������Ϣ */
	    try {
	    	log.info("���ܽ�ͨWebService�����ʼ��ϵͳ������Ϣ��ʼ......");
	    	//���ݿ���������ϢMap
	    	Map configMap = applicationDao.getAppConfigMap();
	    	//���AppInitConstants���������ֶ�
	    	Field fieldList[] = AppInitConstants.class.getDeclaredFields();
	    	log.debug("��ʼ��AppInitConstants��Ϣ......");
	    	for(int i = 0; i < fieldList.length; i++){
	    		Field field = fieldList[i];
	    		//log.debug("field.toString===================="+field.getName());
	    		//�����ݿ��ֶ�����������ֶ���ͬ
	    		if(configMap.containsKey(field.getName())){
	    			Class type = field.getType();
	    			log.debug("field.getType()========="+type);
	    			//��ָ����������ϴ� Field �����ʾ���ֶ�����Ϊָ������ֵ
	    			if(type.isInstance("")){
	    				field.set(AppInitConstants.class,configMap.get(field.getName()));
	    			}else if(type.toString().indexOf("int") != -1
                            || type.toString().indexOf("Integer") != -1){
	    				field.set(AppInitConstants.class,Integer.parseInt((String) configMap.get(field.getName())));
	    			}else if(type.toString().indexOf("Double") != -1
                            || type.toString().indexOf("double") != -1){
	    				field.set(AppInitConstants.class,(Double.valueOf((String)configMap.get(field.getName()))));
	    			}else if(type.toString().indexOf("Date") != -1){
	    				field.set(AppInitConstants.class,(ItsUtility.convertToDate((String)configMap.get(field.getName()),"yyyy-MM-dd")));
	    			}else if(type.toString().indexOf("Float") != -1
                            || type.toString().indexOf("float") != -1){
	    				field.set(AppInitConstants.class,(Float.valueOf((String)configMap.get(field.getName()))));
	    			}else if(type.toString().indexOf("String") != -1){
	    				field.set(AppInitConstants.class,(String)configMap.get(field.getName()));
	    			}else if(type.isInstance(Long.decode("1"))){
	    				field.set(AppInitConstants.class,(Long.valueOf((String)configMap.get(field.getName()))));
	    			}
	    			log.debug(field.toString()+"="+field.get(AppInitConstants.class));
	    		}
	    	}
	    	//�������ļ���ȡ��add by Tony Lin on 2013-05-16
	    	if(!"".equals(SystemConfig.getConfigInfomation("app.socketserverip"))){
	    		AppInitConstants.SOCKET_PROXY_SERVER_IP = SystemConfig.getConfigInfomation("app.socketserverip");
	    	}
	    	if(!"".equals(SystemConfig.getConfigInfomation("app.socketserverport"))){
	    		AppInitConstants.SOCKET_PROXY_SERVER_PORT = Integer.parseInt(SystemConfig.getConfigInfomation("app.socketserverport"));
	    	}
	    	AppInitConstants.resource  = SystemConfig.getTgsConfigInfomation();  // by lvhua 2013-6-27  add
	    	log.info("���ܽ�ͨWebService�����ʼ��ϵͳ������Ϣ����......"); 
	    } catch(Exception e) {
	    	log.error("���ܽ�ͨWebService�����ʼ��ϵͳ������Ϣ����"+e.toString());
	    }
	    
	    log.debug("AppInition.initialize() End.");
	}

	@Override
	public void setApplicationContext(ApplicationContext applicationContext)
			throws BeansException {
		AppInitConstants.APPLICATIONCONTEXT = applicationContext;
		
	}

}
