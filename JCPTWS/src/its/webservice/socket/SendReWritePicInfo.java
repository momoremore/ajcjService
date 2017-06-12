package its.webservice.socket;

import java.io.File;
import java.io.FileOutputStream;

import its.webservice.common.AppInitConstants;
import its.webservice.entity.PicInfo;

import org.apache.log4j.Logger;
import org.codehaus.xfire.util.Base64;

public class SendReWritePicInfo implements Runnable{
	Logger log=Logger.getLogger(SendReWritePicInfo.class);
	
	@Override
	public void run() {
		while(true){
			PicInfo picInfo = null;
			FileOutputStream fos = null;
			File file = null;
			byte[] bytes = null;
			try {
				picInfo = AppInitConstants.picInfoQueue.take();
				if(picInfo!=null){
					file = new File(picInfo.getPicUrl());   
					//����ļ��в����ڣ����ȴ����ļ���
					if(file.isDirectory()){
						log.debug("the directory is exists!");
					}else{
						file.getParentFile().mkdirs();
						log.debug("�½�Ŀ¼��"+file+" �ɹ�");
					}
	        		
	        		bytes = Base64.decode(picInfo.getPicBase64());
		        	fos = new FileOutputStream(file);   
		        	fos.write(bytes);   
		        	fos.flush();   
		        	fos.close();
		        	log.error("��дͼƬ�ɹ�������·����"+picInfo.getPicUrl());
				}
				
			} catch (Exception e) {
				try {
					AppInitConstants.picInfoQueue.put(picInfo);
				} catch (Exception e1) {
					log.error("������쳣",e);
				}
				log.error("��дͼƬʧ�ܣ�������д",e); 
			} finally {
				if (fos != null){
	                 try{
	                	 fos.flush(); 
	                     fos.close();
	                 }
	                 catch (Exception e){
	                	 log.error("",e);
	                 }
	             }
			}
		}
	}
	
}
