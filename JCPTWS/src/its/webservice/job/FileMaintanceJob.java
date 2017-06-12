/**
 * Copyright(c) SUPCON 2008-2012. �㽭����п���Ϣ�������޹�˾
 */

package its.webservice.job;


import org.apache.log4j.Logger;

import its.webservice.common.AppInitConstants;
import its.webservice.config.SystemConfig;
import its.webservice.service.FileMaintanceService;
import its.webservice.util.ItsUtility;

/**
 * ϵͳ���ƣ����ܽ�ͨ����ƽ̨(JCPTWS)
 * ����ģ�飺�ļ�����ģ��
 * �����������ļ�����job
 * �ļ�����its.webservice.job.FileMaintanceJob.java
 * �汾��Ϣ��1.00
 * 
 * �������ţ��з�����
 * �����ߣ� lzk
 * ����ʱ�䣺2012-3-2 ����9:59:46
 * �޸��ߣ� lzk
 * �޸�ʱ�䣺2012-3-2 ����9:59:46
 */

public class FileMaintanceJob {
	
	/** ��ȡLog4jʵ�� */
    protected static Logger log = Logger.getLogger(FileMaintanceJob.class.getName());
	
	public FileMaintanceService getFileMaintanceService() {
		return fileMaintanceService;
	}

	public void setFileMaintanceService(FileMaintanceService fileMaintanceService) {
		this.fileMaintanceService = fileMaintanceService;
	}

	private FileMaintanceService fileMaintanceService;
	
	/*
	 * ͼƬ�������洢ͼƬ·��ǰ׺����D:/picserver
	 * ��ֵ�������ļ��д���
	 */
	private String imaPath = "";
	
	public String getImaPath() {
		return imaPath;
	}

	public void setImaPath(String imaPath) {
		this.imaPath = imaPath;
	}

	/**
	 * ����ͼƬ�ļ�ɾ��
	 */
	public void deleteHistoryFile(){
		
		String currentTimeStr = ItsUtility.getCurrentFormattedDateTime();
        log.info("����ͼƬ�ļ�ɾ������ʼ: Started at: " + currentTimeStr + "......");
        
        long start = System.currentTimeMillis();
		long total = 0;
		
		try{
			if("".equals(imaPath)){
				imaPath = AppInitConstants.IMG_SERVER_ABS_FILE_PATH;
			}
			fileMaintanceService.deleteHistoryFile(imaPath);
			
			//��ȡ���д洢·��ǰ׺  Added by Tony Lin on 2013-06-14
			//����Υ��ͼƬ
			int EnabledwfImagePathNum = Integer.parseInt(SystemConfig.getConfigInfomation("EnabledwfImagePathNum"));
			for(int i = 1; i <= EnabledwfImagePathNum; i++){
				fileMaintanceService.deleteHistoryFile(SystemConfig.getConfigInfomation("wfImagePath" + i));
			}
			//������ͼƬ
			int EnabledkkImagePathNum = Integer.parseInt(SystemConfig.getConfigInfomation("EnabledkkImagePathNum"));
			for(int i = 1; i <= EnabledkkImagePathNum; i++){
				fileMaintanceService.deleteHistoryFile(SystemConfig.getConfigInfomation("kkImagePath" + i));
			}
			
		}catch(Exception e){
			log.error("����ͼƬ�ļ�ɾ������ʧ�ܣ�����ִ�н�����������Ϣ���£�"+e.getMessage());
		}
		
		long end = System.currentTimeMillis();
		total = end - start;
		long sec = total / 1000;
		
		currentTimeStr = ItsUtility.getCurrentFormattedDateTime();
		
		log.info("����ͼƬ�ļ�ɾ�����������Ended at "+ currentTimeStr + "......");
		log.info("���������ܹ���ʱ�� " + sec / 60 + " �� " + sec % 60 + " ��" + total%1000 + "���롣");
		
	}
	
}
