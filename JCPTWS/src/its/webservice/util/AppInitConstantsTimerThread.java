package its.webservice.util;

import its.webservice.common.AppInitConstants;
import its.webservice.config.SystemConfig;
import its.webservice.dao.ApplicationDao;

import java.lang.reflect.Field;
import java.util.Map;
import java.util.Timer;

import org.apache.log4j.Logger;


public class AppInitConstantsTimerThread {
	/** ��ȡLog4jʵ�� */
    protected      Logger log = Logger.getLogger(AppInitConstantsTimerThread.class.getName());
    
  
    private ApplicationDao applicationDao;
    
	public ApplicationDao getApplicationDao() {
		return applicationDao;
	}

	public void setApplicationDao(ApplicationDao applicationDao) {
		this.applicationDao = applicationDao;
	}

	static  Timer timer = null;
	static  ReschedulableTimerTask task = null;
	public    void initialize() {
		timer = new Timer();  // ��ʱ��ʼ��AppInitConstants��ʱ��
		   task= new ReschedulableTimerTask() {   
	         @Override  
	         public void run() {   
	        		initializeTimer();
	            }   
	        };   
	        timer.schedule(task, AppInitConstants.RE_APPINT_TIME *1000, AppInitConstants.RE_APPINT_TIME*1000); //����ִ��һ��   
	      }
	
    /**
    *��ʱ��ʼ��AppInitConstants����
    *@author LVHUA
    *@since  2013-07-03
    *@return void
    */	
    public    void initializeTimer(){
    	    task.setPeriod(AppInitConstants.RE_APPINT_TIME*1000);    //�޸Ķ�ʱ��ִ��ʱ��   
    	    log.debug("��ʱ��ʼ��AppInitConstants��ʱ������.....");
    	    try {
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
    	    	
    	    } catch(Exception e) {
    	    	log.error("��ʱ��ʼ�����ܽ�ͨWebService����ϵͳ������Ϣ����"+e.toString());
    	    }
		   
		}

}
