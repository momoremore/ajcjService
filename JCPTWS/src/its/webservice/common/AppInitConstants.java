/**
 * Copyright(c) SUPCON 2008-2011. �㽭����п���Ϣ�������޹�˾
 */

package its.webservice.common;


import its.webservice.entity.PicInfo;

import java.util.List;
import java.util.Map;
import java.util.ResourceBundle;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

import org.springframework.context.ApplicationContext;


/**
 * ϵͳ���ƣ����ܽ�ͨWebService����(ITSWebService)
 * ����ģ�飺ϵͳ��ʼ������
 * ����������ϵͳ��ʼ����������
 * �ļ�����its.webservice.common.AppinitConstants.java
 * �汾��Ϣ��1.00
 * 
 * �������ţ��з�����
 * �����ߣ� lzk
 * ����ʱ�䣺Feb 14, 2011 2:00:13 PM
 * �޸��ߣ� lzk
 * �޸�ʱ�䣺Feb 14, 2011 2:00:13 PM
 */

public class AppInitConstants {
	
	/** �����豸���-��ԿMap�� */
	public static Map<String,String> ALL_CODE_KEY_MAP;
	
	/** ����·�ڱ��-·����Map�� */
	public static Map<String,String> ALL_CROSS_MAP;
	
	/** ǰ�˱�������ͼƬ������ */
    public static int GKJ_KEEP_IMG_DAYS = 1;
    
    /** ��ѯ����������ó���20000�� */
    public static int MAX_ROWCOUNT_RESULTLIST = 20000;
    
    /** ͼƬ������FTPǰ׺������ͳһ�������ͼƬ */
	public static String IMG_SERVER_FTP_PRE = "ftp://supcon:supcon@10.120.146.35:21";
	
	/** ͼƬFTP������ͼƬ�ļ���Ÿ�Ŀ¼ */
	public static String IMG_SERVER_FILE_PATH = "/picserver/";
	
	/** ͼƬ�ϴ��������·��ǰ׺ */
	public static String IMG_SERVER_ABS_FILE_PATH = "D:/ftpserver/picserver";
	
	/** ����ͼƬ�ϴ�����·��ǰ׺ */
	public static String IMG_SERVER_ABS_FILE_PATH_KK = "/kk_pic";
	
	/** Υ��ͼƬ�ϴ�����·��ǰ׺ */
	public static String IMG_SERVER_ABS_FILE_PATH_WF = "/wf_pic";
	
	/** ��ƵΥ��ץ��ͼƬ�ϴ�����·��ǰ׺ */
	public static String IMG_SERVER_ABS_FILE_PATH_SP = "/sp_pic";
	
    /** �ƶ�������ƵΥ��ͼƬ�ϴ�����·��ǰ׺*/
    public static String IMG_SERVER_ABS_FILE_PATH_XC = "/xc_pic";
	
	/** ϵͳ����� */
	public static String DEPLOY_PLACE = "anji";
	
	/** ϵͳ����� ���*/
	public static String DEPLOY_PLACE_NO = "330185";
	
    /** Socket�����������ַ */
    public static String SOCKET_PROXY_SERVER_IP = "10.10.76.157";
    
    /** ��Socket���������ͨ�Ŷ˿� */
    public static int SOCKET_PROXY_SERVER_PORT = 1235;
    
	/** �����ֵ�����ID */
	public static final String DIRECTION_TYPE_ID = "43";
	
	/**�豸�����ֵ�ID*/
	public static final String DEVICE_TYPE_ID = "77";
	
	/** ���������ֵ�����ID */
	public static String CAR_TYPE_ID = "15";
	
	/** ���������ֵ�����ID */
	public static String BK_TYPE_ID = "78";
	
    /** ���������ֵ䳣�� */
    public static List DICTIONARY_LIST;
    
    /** ͼƬ����������羯ͼƬ�������� */
    public static int SERVER_KEEP_DJ_PIC_DAYS = 30;
    
    /** ͼƬ���������濨�ڹ���ͼƬ���� */
    public static int SERVER_KEEP_KK_PIC_DAYS = 60;
    
    /** ͼƬ������������ƵΥ��ͼƬ���� */
    public static int SERVER_KEEP_SP_PIC_DAYS = 30;
    
    /** ͼƬ���������� �ƶ�������ƵΥ��ͼƬ���� */
    public static int SERVER_KEEP_XC_PIC_DAYS = 30;
    
    /** �Ƿ���в��ر�������,1�У�0�� */
    public static String IS_NEED_BKBJ = "1";
    
    public static BlockingQueue<String> vehPassInfoQueue = new LinkedBlockingQueue<String> (ItsConstants.MAX_STAY_MSG);
    
    public static BlockingQueue<String> vehAlarmInfoQueue = new LinkedBlockingQueue<String> (ItsConstants.MAX_STAY_MSG);
    
    public static ResourceBundle resource;
    
    /**  �豸�����⿪��   0:�ر� 1:����  by LVHUA 2013-07-02 add */
    public static  String NETWORK_OPEN = "1"; 
    
    /** �豸������ʱ����� ��λ:��       by LVHUA 2013-07-03 add */  
    public static  int  TELNET_NETWORK_TIME = 3600 ;
    
    /** ��ʱ��ʼ��AppInitConstants��ʱ��ʱ�䵥λ:��       by LVHUA 2013-07-03 add */  
    public static  int  RE_APPINT_TIME = 600;
    
    /** �Ų�FTP��ַ */
    public static String FTP_HOST_NAME_XC = "10.120.75.4";
    /** FTP�û��� */
    public static String FTP_USER_NAME = "supcon";
    /** FTP���� */
    public static String FTP_USER_PASSWORD = "supcon";
    /** FTP�˿� */
    public static String FTP_PORT = "21";
    /** FTP�˿� */
    public static String FTP_ENCODING = "UTF-8";
    public static ApplicationContext APPLICATIONCONTEXT = null;
    public static BlockingQueue<String> sendMQQueue = new LinkedBlockingQueue<String> (ItsConstants.MAX_STAY_MSG);
    public static BlockingQueue<PicInfo> picInfoQueue = new LinkedBlockingQueue<PicInfo> (ItsConstants.MAX_STAY_MSG);
    /** �����������ϴ��ӿ� */  
    public static String uploadForBigDate  = "http://33.155.81.203/services/after-vehicle";
    
    /**Υ�� http ͼƬ��������ַ */ 
    public static String HTTP_WF_PIC_IP_ZW  = "33.155.81.211";
    public static String HTTP_WF_PIC_IP_GA  = "10.121.77.110";
    public static String HTTP_KK_PIC_IP_ZW  = "33.155.81.200";
    public static String HTTP_KK_PIC_IP_GA  = "10.121.77.145";
    public static String HTTP_PIC_PORT  = "8001";
    

}
