/**
 * Copyright(c) SUPCON 2008-2011. �㽭����п���Ϣ�������޹�˾
 */

package its.webservice.service;

import javax.activation.DataHandler;
import javax.jws.WebParam;
import javax.xml.bind.annotation.XmlMimeType;

/**
 * ϵͳ���ƣ����ܽ�ͨ����ƽ̨(ITSWS)
 * ����ģ�飺XXXXXXXXXXXXXX
 * ����������XXXXXXXXXXXXXX
 * �ļ�����its.webservice.service.MTOMService.java
 * �汾��Ϣ��1.00
 * 
 * �������ţ��з�����
 * �����ߣ� lzk
 * ����ʱ�䣺2011-10-14 ����1:34:40
 * �޸��ߣ� lzk
 * �޸�ʱ�䣺2011-10-14 ����1:34:40
 */

public interface MTOMService {
	
	public void upload(@WebParam(name = "fileName") String fileName,

			@XmlMimeType("*/*") @WebParam(name = "fileDataHandler") DataHandler dataHandler);

}
