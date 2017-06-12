/**
 * Copyright(c) SUPCON 2008-2011. �㽭����п���Ϣ�������޹�˾
 */

package its.webservice.service;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import javax.activation.DataHandler;
import javax.jws.WebParam;
import javax.xml.bind.annotation.XmlMimeType;

/**
 * ϵͳ���ƣ����ܽ�ͨ����ƽ̨(ITSWS)
 * ����ģ�飺XXXXXXXXXXXXXX
 * ����������XXXXXXXXXXXXXX
 * �ļ�����its.webservice.service.MTOMServiceImpl.java
 * �汾��Ϣ��1.00
 * 
 * �������ţ��з�����
 * �����ߣ� lzk
 * ����ʱ�䣺2011-10-14 ����1:35:57
 * �޸��ߣ� lzk
 * �޸�ʱ�䣺2011-10-14 ����1:35:57
 */

@javax.xml.ws.soap.MTOM
public class MTOMServiceImpl implements MTOMService {
	
	private static final int BUFFER_SIZE = 1024 * 1024 * 20;

	/**
	 * ����
	 * 
	 * @param fileName
	 *            �����ص��ļ���
	 * @param dataHandler
	 *            ���ݾ��
	 */
	public void upload(
			@WebParam(name = "fileName") String fileName,

			@XmlMimeType("*/*") @WebParam(name = "fileDataHandler") DataHandler dataHandler) {
		try{

		//File depository = getFileDepository();
			File depository = new File("d:\temp\new_" + fileName);

		InputStream in = dataHandler.getInputStream();
		OutputStream out = new FileOutputStream(depository.getAbsolutePath()
				+ File.separatorChar + fileName);

		byte[] buf = new byte[BUFFER_SIZE];
		int read;
		while ((read = in.read(buf)) != -1) {
			out.write(buf, 0, read);
			out.flush();
		}
		in.close();
		out.close();
		}catch(Exception e){
			
		}
	}
	
	/**
	 * ��ȡ��ʱ�����ļ���·��
	 * 
	 * @return ��ʱ�ļ�·��
	 */
	private static File getFileDepository() {
		return new File(System.getProperty("java.io.tmpdir"));
	}


}
