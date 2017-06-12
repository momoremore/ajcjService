/**
 * Copyright(c) SUPCON 2008-2011. �㽭����п���Ϣ�������޹�˾
 */

package its.webservice.service;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Calendar;

import javax.activation.DataHandler;
import javax.activation.FileDataSource;
import javax.annotation.Resource;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;
import javax.xml.bind.annotation.XmlMimeType;
import javax.xml.ws.WebServiceContext;

/**
 * ϵͳ���ƣ����ܽ�ͨ����ƽ̨(ITSWS) ����ģ�飺XXXXXXXXXXXXXX ����������XXXXXXXXXXXXXX
 * �ļ�����its.webservice.service.MTOMServer.java �汾��Ϣ��1.00
 * 
 * �������ţ��з����� �����ߣ� lzk ����ʱ�䣺2011-10-14 ����1:07:39 �޸��ߣ� lzk �޸�ʱ�䣺2011-10-14
 * ����1:07:39
 */

@javax.xml.ws.soap.MTOM
//@WebService(name = "MTOMServerService", portName = "MTOMServer")
public class MTOMServer {
	private static final int BUFFER_SIZE = 1024 * 1024 * 20;
	@Resource
	private WebServiceContext serviceContext;

	/**
	 * �����ļ�
	 * 
	 * @return ���ݾ��
	 */
	@WebResult
	@XmlMimeType("*/*")
	public DataHandler download(@WebParam(name = "fileName") String fileName)
			throws FileNotFoundException {
		if (fileName == null || fileName.isEmpty())
			throw new FileNotFoundException("file name is empty");

		File dir = getFileDepository();
		File downloadFile = new File(dir.getAbsolutePath() + File.separatorChar
				+ fileName);
		if (!downloadFile.exists())
			throw new FileNotFoundException(fileName + " does not exist");

		return new DataHandler(new FileDataSource(downloadFile) {
			public String getContentType() {
				return "application/octet-stream";
			}
		});
	}

	@WebResult
	@XmlMimeType("*/*")
	public DataHandler[] downloadMulti() throws FileNotFoundException {
		final File[] files = getFileDepository().listFiles();
		DataHandler[] handlers = new DataHandler[files.length];

		for (int i = 0, j = files.length; i < j; i++) {
			final String fileName = files[i].getName();
			handlers[i] = new DataHandler(new FileDataSource(files[i])) {
				public String getName() {
					return fileName;
				}
			};
		}
		return handlers;
	}

	/**
	 * ����
	 * 
	 * @param fileName
	 *            �����ص��ļ���
	 * @param dataHandler
	 *            ���ݾ��
	 * @throws IOException
	 *             IO�쳣
	 */
	public void upload(
			@WebParam(name = "fileName") String fileName,

			@XmlMimeType("*/*") @WebParam(name = "fileDataHandler") DataHandler dataHandler)
			throws IOException {

		File depository = getFileDepository();

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
	}

	/**
	 * �б��ļ��嵥
	 * 
	 * @return �ļ��嵥
	 */
	/*public java.util.List<FileDescription> listFiles() {
		File fileDepository = getFileDepository();
		java.util.List<FileDescription> L = new java.util.ArrayList<FileDescription>(
				0);

		for (File f : fileDepository.listFiles()) {

			FileDescription fds = new FileDescription();

			Calendar cal = Calendar.getInstance();
			cal.setTimeInMillis(f.lastModified());

			fds.setModifiedDate(cal);
			fds.setFileName(f.getName());
			fds.setLength(f.length());
			L.add(fds);
		}

		return L;
	}*/

	/**
	 * ��ȡ��ʱ�����ļ���·��
	 * 
	 * @return ��ʱ�ļ�·��
	 */
	private static File getFileDepository() {
		return new File(System.getProperty("java.io.tmpdir"));
	}
}
