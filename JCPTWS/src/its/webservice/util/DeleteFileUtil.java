/**
 * Copyright(c) SUPCON 2008-2012. �㽭����п���Ϣ�������޹�˾
 */

package its.webservice.util;

/**
 * ϵͳ���ƣ����ܽ�ͨ����ƽ̨(JCPTWS)
 * ����ģ�飺�ļ�����ģ��
 * ����������ɾ���ļ�������
 * �ļ�����its.webservice.util.DeleteFileUtil.java
 * �汾��Ϣ��1.00
 * 
 * �������ţ��з�����
 * �����ߣ� lzk
 * ����ʱ�䣺2012-3-2 ����9:51:00
 * �޸��ߣ� lzk
 * �޸�ʱ�䣺2012-3-2 ����9:51:00
 */

import java.io.File;   

import org.apache.log4j.Logger;
  
/**  
 * ɾ���ļ���Ŀ¼  
 */  
public class DeleteFileUtil {   
	
	/** ��ȡLog4jʵ�� */
    protected static Logger log = Logger.getLogger(DeleteFileUtil.class.getName());
    
    /**  
     * ɾ���ļ��������ǵ����ļ����ļ���  
     * @param   fileName    ��ɾ�����ļ���  
     * @return �ļ�ɾ���ɹ�����true,���򷵻�false  
     */  
    public static boolean delete(String fileName){   
        File file = new File(fileName);   
        if(!file.exists()){   
        	log.error("ɾ���ļ�ʧ�ܣ�"+fileName+"�ļ�������");   
            return false;   
        }else{   
            if(file.isFile()){   
                   
                return deleteFile(fileName);   
            }else{   
                return deleteDirectory(fileName);   
            }   
        }   
    }   
       
    /**  
     * ɾ�������ļ�  
     * @param   fileName    ��ɾ���ļ����ļ���  
     * @return �����ļ�ɾ���ɹ�����true,���򷵻�false  
     */  
    public static boolean deleteFile(String fileName){   
        File file = new File(fileName);   
        if(file.isFile() && file.exists()){   
            file.delete();   
           log.debug("ɾ�������ļ�"+fileName+"�ɹ���");   
            return true;   
        }else{   
        	log.error("ɾ�������ļ�"+fileName+"ʧ�ܣ�");   
            return false;   
        }   
    }   
       
    /**  
     * ɾ��Ŀ¼���ļ��У��Լ�Ŀ¼�µ��ļ�  
     * @param   dir ��ɾ��Ŀ¼���ļ�·��  
     * @return  Ŀ¼ɾ���ɹ�����true,���򷵻�false  
     */  
    public static boolean deleteDirectory(String dir){   
        //���dir�����ļ��ָ�����β���Զ�����ļ��ָ���   
        if(!dir.endsWith(File.separator)){   
            dir = dir+File.separator;   
        }   
        File dirFile = new File(dir);   
        //���dir��Ӧ���ļ������ڣ����߲���һ��Ŀ¼�����˳�   
        if(!dirFile.exists() || !dirFile.isDirectory()){   
        	log.error("ɾ��Ŀ¼ʧ��"+dir+"Ŀ¼�����ڣ�");   
            return false;   
        }   
        boolean flag = true;   
        //ɾ���ļ����µ������ļ�(������Ŀ¼)   
        File[] files = dirFile.listFiles();   
        for(int i=0;i<files.length;i++){   
            //ɾ�����ļ�   
            if(files[i].isFile()){   
                flag = deleteFile(files[i].getAbsolutePath());   
                if(!flag){   
                    break;   
                }   
            }   
            //ɾ����Ŀ¼   
            else{   
                flag = deleteDirectory(files[i].getAbsolutePath());   
                if(!flag){   
                    break;   
                }   
            }   
        }   
           
        if(!flag){   
        	log.error("ɾ��Ŀ¼ʧ��");   
            return false;   
        }   
           
        //ɾ����ǰĿ¼   
        if(dirFile.delete()){   
        	log.info("ɾ��Ŀ¼"+dir+"�ɹ���");   
            return true;   
        }else{   
        	log.error("ɾ��Ŀ¼"+dir+"ʧ�ܣ�");   
            return false;   
        }   
    }   
       
    /**
     * ����
     * @param args
     */
    public static void main(String[] args) {   
        //String fileName = "g:/temp/xwz.txt";   
        //DeleteFileUtil.deleteFile(fileName);   
        String fileDir = "D:/ftpserver/picserver/wf_pic/20120223";   
        //DeleteFileUtil.deleteDirectory(fileDir);   
        DeleteFileUtil.deleteDirectory(fileDir);   
           
    }   
}  
