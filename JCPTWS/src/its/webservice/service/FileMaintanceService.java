/**
 * Copyright(c) SUPCON 2008-2011. �㽭����п���Ϣ�������޹�˾
 */

package its.webservice.service;

/**
 * ϵͳ���ƣ����ܽ�ͨ����ƽ̨(JCPTWS)
 * ����ģ�飺����ƽ̨ͼƬ�ļ�����
 * �����������Կ��ڡ��羯��ͼƬ�ļ�ά����ɾ����������
 * �ļ�����its.webservice.service.FileMaintanceService.java
 * �汾��Ϣ��1.00
 * 
 * �������ţ��з�����
 * �����ߣ� lzk
 * ����ʱ�䣺2011-10-27 ����1:28:42
 * �޸��ߣ� lzk
 * �޸�ʱ�䣺2011-10-27 ����1:28:42
 */

public interface FileMaintanceService {
	
	/**
	 * ɾ����ʷ����ͼƬ
	 * @param dateStr
	 * @return
	 */
	public boolean deleteHistoryFile(String deleteFileDir);

}
