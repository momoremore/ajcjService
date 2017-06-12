package its.webservice.util;


	
	import java.io.File;
	import java.io.FileInputStream;
	import java.io.FileOutputStream;
	import java.io.IOException;

	/**
	 * Javaʵ���ļ����ơ����С�ɾ������
	 * �ļ�ָ�ļ����ļ���
	 * �ļ��ָ��ͳһ��"\\"
	 */

	public class TestFile {

	    /**
	     * �����ļ����ļ���
	     * @param srcPath Դ�ļ���Դ�ļ��е�·��
	     * @param destDir Ŀ���ļ����ڵ�Ŀ¼
	     * @return
	     */
	    public static boolean copyGeneralFile(String srcPath, String destDir) {
	        boolean flag = false;
	        File file = new File(srcPath);
	        if(!file.exists()) { // Դ�ļ���Դ�ļ��в�����
	            return false;
	        }

	        if(file.isFile()) {    // �ļ�����
	            flag = copyFile(srcPath, destDir);
	        }
	        else if(file.isDirectory()) { // �ļ��и���
	            flag = copyDirectory(srcPath, destDir);
	        }

	        return flag;
	    }

	    /**
	     * Ĭ�ϵĸ����ļ�������Ĭ�ϻḲ��Ŀ���ļ����µ�ͬ���ļ�
	     * @param srcPath
	     *            Դ�ļ�����·��
	     * @param destDir
	     *            Ŀ���ļ�����Ŀ¼
	     * @return boolean
	     */
	    public static boolean copyFile(String srcPath, String destDir) {
	     return copyFile(srcPath, destDir, true/**overwriteExistFile*/); // Ĭ�ϸ���ͬ���ļ�
	    }

	    /**
	     * Ĭ�ϵĸ����ļ��з�����Ĭ�ϻḲ��Ŀ���ļ����µ�ͬ���ļ���
	     * @param srcPath    Դ�ļ���·��
	     * @param destPath    Ŀ���ļ�������Ŀ¼
	     * @return boolean
	     */
	    public static boolean copyDirectory(String srcPath, String destDir) {
	     return copyDirectory(srcPath, destDir, true/**overwriteExistDir*/);
	    }

	    /**
	     * �����ļ���Ŀ��Ŀ¼
	     * @param srcPath
	     *            Դ�ļ�����·��
	     * @param destDir
	     *            Ŀ���ļ�����Ŀ¼
	     * @param overwriteExistFile
	     *            �Ƿ񸲸�Ŀ��Ŀ¼�µ�ͬ���ļ�
	     * @return boolean
	     */
	    public static boolean copyFile(String srcPath, String destDir, boolean overwriteExistFile) {
	        boolean flag = false;

	        File srcFile = new File(srcPath);
	        if (!srcFile.exists() || !srcFile.isFile()) { // Դ�ļ�������
	            return false;
	        }

	        //��ȡ�������ļ����ļ���
	        String fileName = srcFile.getName();
	        String destPath = destDir + File.separator +fileName;
	        File destFile = new File(destPath);
	        if (destFile.getAbsolutePath().equals(srcFile.getAbsolutePath())) { // Դ�ļ�·����Ŀ���ļ�·���ظ�
	            return false;
	        }
	        if(destFile.exists() && !overwriteExistFile) {    // Ŀ��Ŀ¼������ͬ���ļ��Ҳ�������
	            return false;
	        }

	        File destFileDir = new File(destDir);
	        if(!destFileDir.exists() && !destFileDir.mkdirs()) { // Ŀ¼�����ڲ��Ҵ���Ŀ¼ʧ��ֱ�ӷ���
	         return false;
	        }

	        try {
	            FileInputStream fis = new FileInputStream(srcPath);
	            FileOutputStream fos = new FileOutputStream(destFile);
	            byte[] buf = new byte[1024];
	            int c;
	            while ((c = fis.read(buf)) != -1) {
	                fos.write(buf, 0, c);
	            }
	            fos.flush();
	            fis.close();
	            fos.close();

	            flag = true;
	        } catch (IOException e) {
	            e.printStackTrace();
	        }

	        return flag;
	    }

	    /**
	     * 
	     * @param srcPath    Դ�ļ���·��
	     * @param destPath    Ŀ���ļ�������Ŀ¼
	     * @return
	     */
	    public static boolean copyDirectory(String srcPath, String destDir, boolean overwriteExistDir) {
	        if(destDir.contains(srcPath))
	           return false;
	        boolean flag = false;

	        File srcFile = new File(srcPath);
	        if (!srcFile.exists() || !srcFile.isDirectory()) { // Դ�ļ��в�����
	            return false;
	        }

	        //��ô����Ƶ��ļ��е����֣���������Ƶ��ļ���Ϊ"E:\\dir\\"���ȡ������Ϊ"dir"
	        String dirName = srcFile.getName();

	        //Ŀ���ļ��е�����·��
	        String destDirPath = destDir + File.separator + dirName + File.separator;
	        File destDirFile = new File(destDirPath);
	        if(destDirFile.getAbsolutePath().equals(srcFile.getAbsolutePath())) {
	         return false;
	        }
	        if(destDirFile.exists() && destDirFile.isDirectory() && !overwriteExistDir) {    // Ŀ��λ����һ��ͬ���ļ����Ҳ�������ͬ���ļ��У���ֱ�ӷ���false
	            return false;
	        }

	        if(!destDirFile.exists() && !destDirFile.mkdirs()) {  // ���Ŀ��Ŀ¼�����ڲ��Ҵ���Ŀ¼ʧ��
	         return false;
	        }

	        File[] fileList = srcFile.listFiles();    //��ȡԴ�ļ����µ����ļ������ļ���
	        if(fileList.length==0) {    // ���Դ�ļ���Ϊ��Ŀ¼��ֱ������flagΪtrue����һ���ǳ����Σ�debug�˺ܾ�
	            flag = true;
	        }
	        else {
	            for(File temp: fileList) {
	                if(temp.isFile()) {    // �ļ�
	                    flag = copyFile(temp.getAbsolutePath(), destDirPath, overwriteExistDir);     // �ݹ鸴��ʱҲ�̳и�������
	                }
	                else if(temp.isDirectory()) {    // �ļ���
	                    flag = copyDirectory(temp.getAbsolutePath(), destDirPath, overwriteExistDir);   // �ݹ鸴��ʱҲ�̳и�������
	                }

	                if(!flag) {
	                    break;
	                }
	            }
	        }

	        return flag;
	    }

	    /**
	     * ɾ���ļ����ļ���
	     * @param path
	     *            ��ɾ�����ļ��ľ���·��
	     * @return boolean
	     */
	    public static boolean deleteFile(String path) {
	        boolean flag = false;

	        File file = new File(path);
	        if (!file.exists()) { // �ļ�������ֱ�ӷ���
	            return flag;
	        }
	        flag = file.delete();

	        return flag;
	    }

	    
	    /**
	     * �����淽����������з���������+ɾ��
	     * @param  destDir ͬ��
	     */
	    public static boolean cutGeneralFile(String srcPath, String destDir) {
	     boolean flag = false;
	        if(copyGeneralFile(srcPath, destDir) && deleteFile(srcPath)) { // ���ƺ�ɾ�����ɹ�
	         flag = true;
	        }

	        return flag;
	    }

	    public static void main(String[] args) {
	     /** ���Ը����ļ� */
	     System.out.println(copyGeneralFile("d://test/tt.rar", "d://test1/"));  // һ����������
//	     System.out.println(copyGeneralFile("d://notexistfile", "d://test/"));      // ���Ʋ����ڵ��ļ����ļ���
//	     System.out.println(copyGeneralFile("d://test/test.html", "d://test/"));      // �������ļ���Ŀ���ļ���ͬһĿ¼��
//	     System.out.println(copyGeneralFile("d://test/test.html", "d://test/test/"));  // ����Ŀ��Ŀ¼�µ�ͬ���ļ�
//	     System.out.println(copyFile("d://test/", "d://test2", false)); // ������Ŀ��Ŀ¼�µ�ͬ���ļ�
//	     System.out.println(copyGeneralFile("d://test/test.html", "notexist://noexistdir/")); // �����ļ���һ�������ܴ���Ҳ�����ܴ�����Ŀ¼��

	     System.out.println("---------");

//	     /** ���Ը����ļ��� */
//	     System.out.println(copyGeneralFile("d://test/", "d://test2/"));
//
//	     System.out.println("---------");
//
//	     /** ����ɾ���ļ� */
//	     System.out.println(deleteFile("d://a/"));
	    }

	}

