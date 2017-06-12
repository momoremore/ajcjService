package its.webservice.util;

import its.webservice.common.AppInitConstants;

import java.io.IOException;
import java.io.InputStream;
import java.util.StringTokenizer;

import org.apache.commons.net.ftp.FTP;
import org.apache.commons.net.ftp.FTPClient;
import org.apache.commons.net.ftp.FTPConnectionClosedException;
import org.apache.commons.net.ftp.FTPReply;
import org.apache.log4j.Logger;

public class FtpUtil {
	/** ��ȡLog4jʵ�� */
    protected static Logger log = Logger.getLogger(FtpUtil.class.getName());
	
	public static FTPClient getFtpClientByIp(String ip) {
		int reply;
		FTPClient ftp = new FTPClient();

		try {
			ftp.connect(ip, Integer.parseInt(AppInitConstants.FTP_PORT));
			reply = ftp.getReplyCode();
			if (!FTPReply.isPositiveCompletion(reply)) {
				ftp.disconnect();
				log.error("FTP������û����Ӧ.");
			}

			// ��¼FTP������
			if (!ftp.login(AppInitConstants.FTP_USER_NAME,
					AppInitConstants.FTP_USER_PASSWORD)) {
				log.error("��¼FTP������ʧ��.");
				ftp.logout();
			}
			//����·��
			ftp.setControlEncoding(AppInitConstants.FTP_ENCODING);
			ftp.setFileType(FTP.BINARY_FILE_TYPE);
			// ftp.setFileType(FTP.ASCII_FILE_TYPE);
			ftp.enterLocalPassiveMode();
			ftp.setFileTransferMode(FTP.STREAM_TRANSFER_MODE);
		} catch (IOException e) {
			log.error(e.getMessage());
			if (ftp.isConnected()) {
				try {
					ftp.disconnect();
				} catch (IOException f) {
					log.error(f.getMessage());
				}
			}
		}
		return ftp;
	}
	
	public static boolean UploadFileByIp(String ip,InputStream inputStream, String remoteDirectory,
			String remoteFileName) {
//		log.debug("ip--------"+ip);
		// �ϴ��Ƿ�ɹ�
		boolean isUploaded = false;
		FTPClient ftp = getFtpClientByIp(ip);

		try {
			makeDirectory(remoteDirectory, ftp);
			// �洢�ļ�
			isUploaded = ftp.storeFile("/" + new String(remoteDirectory.getBytes("GBK"),"iso-8859-1")+ new String(remoteFileName.getBytes("GBK"),"iso-8859-1"),
					inputStream);
			log.debug("�ϴ��ŵ�isUploaded-----"+isUploaded);
			inputStream.close();
			ftp.logout();
		} catch (FTPConnectionClosedException e) {
			log.error(e.getMessage());
		} catch (IOException e) {
			log.error(e.getMessage());
		} finally {
			if (ftp.isConnected()) {
				try {
					ftp.disconnect();
				} catch (IOException f) {
					log.error(f.getMessage());
				}
			}
		}
//		log.debug("isUploaded--------"+isUploaded);
		return isUploaded;
	}
	
	private static void makeDirectory(String filePath, FTPClient ftp)
			throws IOException {
		log.debug("��ʼ����·��---"+filePath);
		String pathName = "";
		if (filePath == null) {
			filePath = "";
		}
		StringTokenizer stringTokenizer = new StringTokenizer(filePath, "/");
		
		while (stringTokenizer.hasMoreElements()) {
			pathName += "/" + stringTokenizer.nextToken();
			ftp.makeDirectory(new String(pathName.getBytes("GBK"),"iso-8859-1"));
		}
		log.debug("��������·��---"+filePath);
	}
	
	/**
	 * �ж�FTP�Ƿ�����
	 */
	public boolean isConnect(String ip){
		boolean b = false;
		FTPClient ftp = this.getFtpClientByIp(ip);
		b = ftp.isConnected();
		return b;
	}
	
}
