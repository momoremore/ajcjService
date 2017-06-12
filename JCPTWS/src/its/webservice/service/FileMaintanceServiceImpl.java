/**
 * Copyright(c) SUPCON 2008-2012. �㽭����п���Ϣ�������޹�˾
 */

package its.webservice.service;

import its.webservice.common.AppInitConstants;
import its.webservice.config.SystemConfig;
import its.webservice.util.DeleteFileUtil;

import java.util.Calendar;
import java.util.Date;
import org.apache.log4j.Logger;

/**
 * ϵͳ���ƣ����ܽ�ͨ����ƽ̨(JCPTWS)
 * ����ģ�飺����ƽ̨ͼƬ�ļ�����
 * �����������Կ��ڡ��羯��ͼƬ�ļ�ά����ɾ����������
 * �ļ�����its.webservice.service.FileMaintanceService.java
 * �汾��Ϣ��1.00
 * 
 * �������ţ��з�����
 * �����ߣ� lzk
 * ����ʱ�䣺2011-10-27 ����1:17:45
 * �޸��ߣ� lzk
 * �޸�ʱ�䣺2011-10-27 ����1:17:45
 */

public class FileMaintanceServiceImpl implements FileMaintanceService {
	
	/** ��ȡLog4jʵ�� */
    protected Logger log = Logger.getLogger(FileMaintanceServiceImpl.class.getName());
	
	/**
	 * ɾ����ʷ����ͼƬ
	 * @param dateStr
	 * @return
	 */
	public boolean deleteHistoryFile(String deleteFileDir) {
		log.debug("FileMaintanceServiceImpl.DeleteHistoryFile() invoked...");
		java.text.SimpleDateFormat sdf = new java.text.SimpleDateFormat("yyyyMMdd");

		Date d = new Date();
		Calendar cal = Calendar.getInstance();
		cal.setTime(d);
		
		String filePath = "";
		
		//Added by Tony Lin on 2013-07-04
		int keep_kk_pic_days = AppInitConstants.SERVER_KEEP_KK_PIC_DAYS;
		int keep_wf_pic_days = AppInitConstants.SERVER_KEEP_DJ_PIC_DAYS;
		//int keep_other_pic_days=30;
		try{
			keep_kk_pic_days = Integer.parseInt(SystemConfig.getConfigInfomation("server_keep_kk_pic_days"));
			keep_wf_pic_days = Integer.parseInt(SystemConfig.getConfigInfomation("server_keep_wf_pic_days"));
			//keep_other_pic_days = Integer.parseInt(SystemConfig.getConfigInfomation("server_keep_other_pic_days"));
		}catch(Exception e){
			e.printStackTrace();
			
		}
		
		//ɾ���羯ͼƬ
		log.debug("��ʼɾ���羯ͼƬStart..............");
		cal.add(Calendar.DAY_OF_MONTH, -keep_wf_pic_days);
		//log.debug(sdf.format(cal.getTime()));
		for(int i = 1; i < 6; i++){//ɾ�����������ļ���
			cal.add(Calendar.DAY_OF_MONTH, -1);
			//log.debug(sdf.format(cal.getTime()));
			filePath = deleteFileDir + AppInitConstants.IMG_SERVER_ABS_FILE_PATH_WF + "/" + sdf.format(cal.getTime());
			DeleteFileUtil.deleteDirectory(filePath);
			i++;
		}
		log.debug("����ɾ���羯ͼƬEnd..............");
		
		//ɾ������ͼƬ
		log.debug("��ʼɾ������ͼƬStart..............");
		cal = Calendar.getInstance();
		cal.setTime(d);
		cal.add(Calendar.DAY_OF_MONTH, -keep_kk_pic_days);
		//log.debug(sdf.format(cal.getTime()));
		for(int i = 1; i < 6; i++){//ɾ�����������ļ���
			cal.add(Calendar.DAY_OF_MONTH, -1);
			//log.debug(sdf.format(cal.getTime()));
			filePath = deleteFileDir + AppInitConstants.IMG_SERVER_ABS_FILE_PATH_KK  + "/" + sdf.format(cal.getTime());
			DeleteFileUtil.deleteDirectory(filePath);
			i++;
		}
		log.debug("����ɾ������ͼƬEnd..............");
		
		//ɾ����ƵΥ��ץ��ͼƬ
		log.debug("��ʼɾ����ƵΥ��ץ��ͼƬStart..............");
		cal = Calendar.getInstance();
		cal.setTime(d);
		cal.add(Calendar.DAY_OF_MONTH, -AppInitConstants.SERVER_KEEP_SP_PIC_DAYS);
		//log.debug(sdf.format(cal.getTime()));
		for(int i = 1; i < 6; i++){//ɾ�����������ļ���
			cal.add(Calendar.DAY_OF_MONTH, -1);
			//log.debug(sdf.format(cal.getTime()));
			filePath = deleteFileDir + AppInitConstants.IMG_SERVER_ABS_FILE_PATH_SP  + "/" + sdf.format(cal.getTime());
			DeleteFileUtil.deleteDirectory(filePath);
			i++;
		}
		log.debug("��ʼɾ����ƵΥ��ץ��ͼƬEnd..............");
		
		//ɾ���˹��ϴ�ͼƬ�������豸���ƶ�����Added on 2012-5-9
		log.debug("��ʼɾ���˹��ϴ�ͼƬStart..............");
		cal = Calendar.getInstance();
		cal.setTime(d);
		cal.add(Calendar.DAY_OF_MONTH, -AppInitConstants.SERVER_KEEP_XC_PIC_DAYS);
		//log.debug(sdf.format(cal.getTime()));
		for(int i = 1; i < 6; i++){//ɾ�����������ļ���
			cal.add(Calendar.DAY_OF_MONTH, -1);
			//log.debug(sdf.format(cal.getTime()));
			filePath = deleteFileDir + AppInitConstants.IMG_SERVER_ABS_FILE_PATH_XC  + "/" + sdf.format(cal.getTime());
			DeleteFileUtil.deleteDirectory(filePath);
			i++;
		}
		log.debug("��ʼɾ���˹��ϴ�ͼƬEnd..............");
		
		log.debug("FileMaintanceServiceImpl.DeleteHistoryFile() invoked...");
		
		return true;
	}

}
