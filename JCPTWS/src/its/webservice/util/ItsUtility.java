/**
 * Copyright(c) SUPCON 2008-2011. �㽭����п���Ϣ�������޹�˾
 */

package its.webservice.util;

import its.webservice.common.AppInitConstants;
import its.webservice.common.ItsConstants;
import its.webservice.config.SystemConfig;

import java.io.File;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.TimeZone;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.apache.commons.lang.ArrayUtils;
import org.apache.commons.lang.StringUtils;
import org.apache.log4j.Logger;



/**
 * ϵͳ���ƣ����ܽ�ͨWebService����(ITSWebService)
 * ����ģ�飺ϵͳ����
 * ����������ϵͳ������
 * �ļ�����com.supconit.its.util.ItsUtility.java
 * �汾��Ϣ��1.00
 * 
 * �������ţ��з�����
 * �����ߣ� lzk
 * ����ʱ�䣺Jan 26, 2011 12:56:32 PM
 * �޸��ߣ� lzk
 * �޸�ʱ�䣺Jan 26, 2011 12:56:32 PM
 */

public final class ItsUtility {
	protected static Logger log = Logger.getLogger(ItsUtility.class.getName());
	
	private final static byte[] val = {
        0x3F,0x3F,0x3F,0x3F,0x3F,0x3F,0x3F,0x3F,0x3F,0x3F,0x3F,0x3F,0x3F,0x3F,0x3F,0x3F,
        0x3F,0x3F,0x3F,0x3F,0x3F,0x3F,0x3F,0x3F,0x3F,0x3F,0x3F,0x3F,0x3F,0x3F,0x3F,0x3F,
        0x3F,0x3F,0x3F,0x3F,0x3F,0x3F,0x3F,0x3F,0x3F,0x3F,0x3F,0x3F,0x3F,0x3F,0x3F,0x3F,
        0x00,0x01,0x02,0x03,0x04,0x05,0x06,0x07,0x08,0x09,0x3F,0x3F,0x3F,0x3F,0x3F,0x3F,
        0x3F,0x0A,0x0B,0x0C,0x0D,0x0E,0x0F,0x3F,0x3F,0x3F,0x3F,0x3F,0x3F,0x3F,0x3F,0x3F,
        0x3F,0x3F,0x3F,0x3F,0x3F,0x3F,0x3F,0x3F,0x3F,0x3F,0x3F,0x3F,0x3F,0x3F,0x3F,0x3F,
        0x3F,0x0A,0x0B,0x0C,0x0D,0x0E,0x0F,0x3F,0x3F,0x3F,0x3F,0x3F,0x3F,0x3F,0x3F,0x3F,
        0x3F,0x3F,0x3F,0x3F,0x3F,0x3F,0x3F,0x3F,0x3F,0x3F,0x3F,0x3F,0x3F,0x3F,0x3F,0x3F,
        0x3F,0x3F,0x3F,0x3F,0x3F,0x3F,0x3F,0x3F,0x3F,0x3F,0x3F,0x3F,0x3F,0x3F,0x3F,0x3F,
        0x3F,0x3F,0x3F,0x3F,0x3F,0x3F,0x3F,0x3F,0x3F,0x3F,0x3F,0x3F,0x3F,0x3F,0x3F,0x3F,
        0x3F,0x3F,0x3F,0x3F,0x3F,0x3F,0x3F,0x3F,0x3F,0x3F,0x3F,0x3F,0x3F,0x3F,0x3F,0x3F,
        0x3F,0x3F,0x3F,0x3F,0x3F,0x3F,0x3F,0x3F,0x3F,0x3F,0x3F,0x3F,0x3F,0x3F,0x3F,0x3F,
        0x3F,0x3F,0x3F,0x3F,0x3F,0x3F,0x3F,0x3F,0x3F,0x3F,0x3F,0x3F,0x3F,0x3F,0x3F,0x3F,
        0x3F,0x3F,0x3F,0x3F,0x3F,0x3F,0x3F,0x3F,0x3F,0x3F,0x3F,0x3F,0x3F,0x3F,0x3F,0x3F,
        0x3F,0x3F,0x3F,0x3F,0x3F,0x3F,0x3F,0x3F,0x3F,0x3F,0x3F,0x3F,0x3F,0x3F,0x3F,0x3F,
        0x3F,0x3F,0x3F,0x3F,0x3F,0x3F,0x3F,0x3F,0x3F,0x3F,0x3F,0x3F,0x3F,0x3F,0x3F,0x3F
    };
	
	private final static String[] hex = {
        "00","01","02","03","04","05","06","07","08","09","0A","0B","0C","0D","0E","0F",
        "10","11","12","13","14","15","16","17","18","19","1A","1B","1C","1D","1E","1F",
        "20","21","22","23","24","25","26","27","28","29","2A","2B","2C","2D","2E","2F",
        "30","31","32","33","34","35","36","37","38","39","3A","3B","3C","3D","3E","3F",
        "40","41","42","43","44","45","46","47","48","49","4A","4B","4C","4D","4E","4F",
        "50","51","52","53","54","55","56","57","58","59","5A","5B","5C","5D","5E","5F",
        "60","61","62","63","64","65","66","67","68","69","6A","6B","6C","6D","6E","6F",
        "70","71","72","73","74","75","76","77","78","79","7A","7B","7C","7D","7E","7F",
        "80","81","82","83","84","85","86","87","88","89","8A","8B","8C","8D","8E","8F",
        "90","91","92","93","94","95","96","97","98","99","9A","9B","9C","9D","9E","9F",
        "A0","A1","A2","A3","A4","A5","A6","A7","A8","A9","AA","AB","AC","AD","AE","AF",
        "B0","B1","B2","B3","B4","B5","B6","B7","B8","B9","BA","BB","BC","BD","BE","BF",
        "C0","C1","C2","C3","C4","C5","C6","C7","C8","C9","CA","CB","CC","CD","CE","CF",
        "D0","D1","D2","D3","D4","D5","D6","D7","D8","D9","DA","DB","DC","DD","DE","DF",
        "E0","E1","E2","E3","E4","E5","E6","E7","E8","E9","EA","EB","EC","ED","EE","EF",
        "F0","F1","F2","F3","F4","F5","F6","F7","F8","F9","FA","FB","FC","FD","FE","FF"
    };

	/**
     * Convert String to Date
	 * @param tmp Ҫת����String
	 * @param df ���ڸ�ʽ yyyy-MM-dd HH:mm:ss
	 * @return Date ����
     */
    public static java.util.Date StringToDate(String tmp, String df) {
        java.util.Date tmpDate = null;
        SimpleDateFormat formatter = new SimpleDateFormat(df);
        formatter.setLenient(false);
        try {
            tmpDate = formatter.parse(tmp.trim());
            return tmpDate;
        } catch (Exception e) {
            return null;
        }
    }
    
    /**
     * Convert Date to String
	 * @param d Ҫת����Date
	 * @param f ת����ĸ�ʽ
     * @return String
     */
    public static String DateToString(java.util.Date d, String f) {
        if (d != null) {
            SimpleDateFormat formatter = new SimpleDateFormat(f);
            String dateString = formatter.format(d);
            return dateString;
        } else {
            return "";
        }
    }

    /**
     * �ж����ڸ�ʽ�Ƿ���ȷ
	 * @param sDate Ҫ�жϵ������ַ���
     * @return boolean
     */
    public static boolean isValidDate(String sDate) {
         String datePattern1 = "\\d{4}-\\d{2}-\\d{2}";
         String datePattern2 = "^((\\d{2}(([02468][048])|([13579][26]))"
                 + "[\\-\\/\\s]?((((0?[13578])|(1[02]))[\\-\\/\\s]?((0?[1-9])|([1-2][0-9])|"
                 + "(3[01])))|(((0?[469])|(11))[\\-\\/\\s]?((0?[1-9])|([1-2][0-9])|(30)))|(0?2[\\-\\/\\s]?"
                 + "((0?[1-9])|([1-2][0-9])))))|(\\d{2}(([02468][1235679])|([13579][01345789]))[\\-\\/\\s]?("
                 + "(((0?[13578])|(1[02]))[\\-\\/\\s]?((0?[1-9])|([1-2][0-9])|(3[01])))|(((0?[469])|(11))[\\-\\/\\s]?"
                 + "((0?[1-9])|([1-2][0-9])|(30)))|(0?2[\\-\\/\\s]?((0?[1-9])|(1[0-9])|(2[0-8]))))))";
         if ((sDate != null)) {
             Pattern pattern = Pattern.compile(datePattern1);
             Matcher match = pattern.matcher(sDate);
             if (match.matches()) {
                 pattern = Pattern.compile(datePattern2);
                 match = pattern.matcher(sDate);
                 return match.matches();
             }
             else {
                 return false;
             }
         }
         return false;
     }
    
    /**
     * ���ַ���ת����MD5�룬��Ҫ�������
     * @param str ��ת����ַ���
     * @return MD5���ַ���
     */
    public static String getMD5String(String str){
    	try{
    		byte psw[] = str.getBytes();
    		MessageDigest md = MessageDigest.getInstance("MD5");
    		md.update(psw);
    		return toHex(md.digest());
    		
    	} catch (IllegalStateException e) {
            return null;
        } catch (NoSuchAlgorithmException e) {
            return null;
        }
    }

    /**
     * ��byte����������ƴ����ַ���
     * @param buffer The byte array to be converted
     * @return String 
     */
    public static String toHex(byte buffer[]) {
        StringBuffer sb = new StringBuffer();
        String s = null;
        for (int i = 0; i < buffer.length; i++) {
            s = Integer.toHexString((int) buffer[i] & 0xff);
            if (s.length() < 2) {
                sb.append('0');
            }
            sb.append(s);
        }
        return sb.toString();
    }
    
    /**
     * �Ƚ�����ʱ���ַ����������
     * @param startDate
     * @param endDate
     * @return
     */
    public static long dateCompare(java.util.Date startDate,java.util.Date endDate){

        long  day = (endDate.getTime() - startDate.getTime())/(24*60*60*1000);

    	return day;
    }
    
    /**
     * �ж��Ƿ�Ϊ������
     * @param number
     * @return
     */
    public static boolean zhengshuValidate(String number) {// �ж� �������ĸ�ʽ 
    	Pattern pattern = Pattern.compile("^\\d+$"); 
    	Matcher mc = pattern.matcher(number); 
    	return mc.matches(); 
    } 

    /**
     * ��ȥ�ո񡢻��н�ʡ�ַ�����
     * ƴ��SQL�е�OR��ѯ������ȡ��IN����߲�ѯ�ٶ�
     *
     * @param fieldStr String �ֶ�����
     * @param arrStr String[] �ֶε�ֵ�ڴ�����֮��
     * @return String
     */
    public static String getSqlOrString(String fieldStr, String[] arrStr) {

        if (StringUtils.isEmpty(fieldStr) || ArrayUtils.isEmpty(arrStr)) {
        	return "";
        }

    	StringBuffer conditionStrb = new StringBuffer("");

        for (int i = 0; i < arrStr.length; i++) {
        	if (i == 0) {
        		conditionStrb.append(" AND (" + fieldStr + "='" + arrStr[i] + "' ");
        		continue;
        	}
        	conditionStrb.append(" OR " + fieldStr + "='" + arrStr[i] + "' ");
        }

        conditionStrb.append(" ) ");

        return conditionStrb.toString();
    }
    
    /**
     * �Ƿ���N����ǰ��ʱ�䣬����������
     * @param dateStr String
     * @return boolean
     */
    public static boolean isNDaysAgo(String dateStr) {
        Calendar cal = Calendar.getInstance(TimeZone.getTimeZone(ItsConstants.TIME_ZONE_CHN));
        
    	SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
    	String nowDate = sdf.format(cal.getTime());
    	long  day = (StringToDate(nowDate,"yyyy-MM-dd").getTime() - StringToDate(dateStr, "yyyy-MM-dd").getTime())/(24*60*60*1000);

    	if(day >= AppInitConstants.GKJ_KEEP_IMG_DAYS){
    		return true;
    	}
    	
    	return false;
    }
    
    /**
     * nullת��Ϊ���ַ���
     * @author Tony Lin Created on 2008-9-10
     * @param value
     * @return ��nullֵ
     */
    public static Object removeNull(Object value){
        if(value == null){
            return "";
        }else{
            return value;
        }   
    }
    
    /**
     * nullת��Ϊ���ַ���
     * @author Tony Lin Created on 2008-9-10
     * @param value
     * @return ��nullֵ
     */
    public static String removeNull(String value){
        if(value == null){
            return "";
        }else{
            return value;
        }   
    }
	
    /**
     * judge a value whether in a array
     * @param argArray String[]
     * @param argValue String
     * @return true or false
     */
    public static boolean arrayContainsIgnoreCase(String[] argArray, String argValue) {
        boolean result = false;
        if (argArray == null) {
            return result;
        }
        for (int i = 0; i < argArray.length; i++) {
            if (argValue.equalsIgnoreCase(argArray[i])) {
                result = true;
                break;
            }
        }
        return result;
    }
    
    /**
     * �жϳ����Ƿ�Ϊ�ٳ���(�ߺ�����ʹ��)
     * �����ƺ������λΪ>=F,<=Zʱ����Ϊ�����ɼٳ���
     * 
     */
    public static boolean isFaultCP(char cp){
    	if(cp >= 'F' && cp <= 'Z'){
    		return true;
    	}
    	return false;
    }
    
    /**
     * Convert to Date object / Date format checking
     * @author Tony Lin create on 2009-9-8
     */
    public static Date convertToDate(String sEntry, String sDateFmt) {
        SimpleDateFormat sdf = new SimpleDateFormat(sDateFmt);
        sdf.setLenient(false);

        try {
            return (sdf.parse(sEntry));
        } catch (Exception e) {
            return null;
        }
    }
    
    /**
     * �h���ļ��У��������ļ���
     * @param folder
     * @return
     */
     public boolean deleteFolder(File   folder)     {
         boolean  result  =   false ;
         try  {
              String   childs[]    =    folder.list();  
               if    (childs    ==     null     ||    childs.length    <=     0 )     {  
                         if (folder.delete())  {
                            result  =   true ;
                        }
               }   else  {
                   for    ( int    i    =     0 ;   i    <    childs.length;   i ++ )     {
                          String   childName    =    childs[i];  
                          String   childPath    =   
                          folder.getPath()    +    File.separator    +    childName;  
                          File   filePath    =     new    File(childPath);  
                           if    (filePath.exists()    &&    filePath.isFile())     { 
                                 if (filePath.delete())  {
                                    result  =   true ;
                                } else  {
                                    result  =   false ;
                                     break ;
                                } 
                          }   
                           else     if    (filePath.exists()    &&    filePath.isDirectory())     {
                                 if (deleteFolder(filePath))  {
                                    result  =   true ;
                                } else  {
                                    result  =   false ;
                                     break ;
                                } 
                          }   
                  } 
                }
       
              folder.delete();  
          } catch (Exception e)  {
              e.printStackTrace();
              result  =   false ;
          } 
         return  result;
    }
     
     /**
      * ��ѯa_code������Ҫ��key��value��ֵ��map
      * 
      * @author Tony Lin
      * @param typeId
      * @return map
      */
     public static Map getDictionary(String typeId){
     	List rowList = AppInitConstants.DICTIONARY_LIST;
     	LinkedHashMap<String,String> codeNameMap = new LinkedHashMap<String,String>();
 		Iterator rowIterator = rowList.iterator();
 		String type_id = "";
         while (rowIterator.hasNext()) {
             Map rowMap = (Map)rowIterator.next();
             type_id = rowMap.get("type_id").toString();
             if(typeId.equals(type_id)){
             	codeNameMap.put(rowMap.get("code").toString(),rowMap.get("name").toString());
             }
         }
     	return codeNameMap;
     }
     
     /**
      * ��ѯa_code���ض�Ӧcode��nameֵ
      * 
      * @author Tony Lin
      * @param typeId
      * @param code
      * @return string
      */
     public static String getDictionaryValue(String typeId,String code){
     	if(code == null || "".equals(code)){
     		return "";
     	}else{
 	    	List rowList = AppInitConstants.DICTIONARY_LIST;
 	    	Iterator rowIterator = rowList.iterator();
 	    	String type_id = "";
 	    	String codeTemp = "";
 	    	String name = "";
 	    	while (rowIterator.hasNext()) {
 	            Map rowMap = (Map)rowIterator.next();
 	            type_id = rowMap.get("TYPE_ID").toString();
 	            codeTemp = rowMap.get("CODE").toString();
 	            if(typeId.equals(type_id)){
 		            if(code.equals(codeTemp)){
 		            	name = rowMap.get("NAME").toString();
 		            	
 		            	break;
 		            }
 	            }
 	        }
 	    	return name;
     	}
     }
     
     //***************************************************************************
     /**
      * ��ȡ��ʽ���ĵ�ǰϵͳ���ں�ʱ��
      * @author xujin.jiao
      * @return String ��ʽ���˵�����ʱ���ַ���
      */
     //***************************************************************************
     public static String getCurrentFormattedDateTime() {
         String currentDateTimeStr = "";
         Calendar cal = Calendar.getInstance(TimeZone.getTimeZone(ItsConstants.TIME_ZONE_CHN));
         SimpleDateFormat sdf = new SimpleDateFormat(ItsConstants.DATETIME_FORMAT_CHN);
         sdf.setTimeZone(TimeZone.getTimeZone(ItsConstants.TIME_ZONE_CHN));
         currentDateTimeStr = sdf.format(cal.getTime());
         return currentDateTimeStr;
     }
     
     /**
      * JavaScript escape������ Java ʵ��
      * @param s ��ת�����ַ���
      * @return String ת�����Unicode�����ַ���
      * @author Tony Lin
      */
     public static String escape(String s) {
         if (s == null)
           return s;

         StringBuffer sbuf = new StringBuffer();
         int len = s.length();

         for (int i = 0; i < len; i++) {
             int ch = s.charAt(i);
             if (ch == ' ') {                        // space : map to '+'
                 sbuf.append('+');
             } else if ('A' <= ch && ch <= 'Z') {    // 'A'..'Z' : as it was
                 sbuf.append((char)ch);
             } else if ('a' <= ch && ch <= 'z') {    // 'a'..'z' : as it was
                 sbuf.append((char)ch);
             } else if ('0' <= ch && ch <= '9') {    // '0'..'9' : as it was
                 sbuf.append((char)ch);
             } else if (ch == '-' || ch == '_'       // unreserved : as it was
                 || ch == '.' || ch == '!'
                 || ch == '~' || ch == '*'
                 || ch == '\'' || ch == '('
                 || ch == ')') {
                 sbuf.append((char)ch);
             } else if (ch <= 0x007F) {              // other ASCII : map to %XX
                 sbuf.append('%');
                 sbuf.append(hex[ch]);
             } else {                                // unicode : map to %uXXXX
                 sbuf.append('%');
                 sbuf.append('u');
                 sbuf.append(hex[(ch >>> 8)]);
                 sbuf.append(hex[(0x00FF & ch)]);
             }
         }
         return sbuf.toString();
     }

     /**
      * JavaScript unescape������ Java ʵ��
      * @param s ��ת�����ַ���(Unicode����)
      * @return String ת���������(����)
      * @author Tony Lin
      */
     public static String unescape(String s) {

         if (s == null)
           return s;

         StringBuffer sbuf = new StringBuffer();
         int i = 0;
         int len = s.length();

         while (i < len) {
             int ch = s.charAt(i);
             if (ch == '+') {                        // + : map to ' '
                 sbuf.append(' ');
             } else if ('A' <= ch && ch <= 'Z') {    // 'A'..'Z' : as it was
                 sbuf.append((char)ch);
             } else if ('a' <= ch && ch <= 'z') {    // 'a'..'z' : as it was
                 sbuf.append((char)ch);
             } else if ('0' <= ch && ch <= '9') {    // '0'..'9' : as it was
                 sbuf.append((char)ch);
             } else if (ch == '-' || ch == '_'       // unreserved : as it was
                 || ch == '.' || ch == '!'
                 || ch == '~' || ch == '*'
                 || ch == '\'' || ch == '('
                 || ch == ')') {
                 sbuf.append((char)ch);
             } else if (ch == '%') {
                 int cint = 0;
                 if ('u' != s.charAt(i+1)) {         // %XX : map to ascii(XX)
                     cint = (cint << 4) | val[s.charAt(i+1)];
                     cint = (cint << 4) | val[s.charAt(i+2)];
                     i+=2;
                 } else {                            // %uXXXX : map to unicode(XXXX)
                     cint = (cint << 4) | val[s.charAt(i+2)];
                     cint = (cint << 4) | val[s.charAt(i+3)];
                     cint = (cint << 4) | val[s.charAt(i+4)];
                     cint = (cint << 4) | val[s.charAt(i+5)];
                     i+=5;
                 }
                 sbuf.append((char)cint);
             }
             i++;
         }
         return sbuf.toString();
     }
     
     /**
      * ���������ļ��漴��ȡͼƬ�洢�ľ���·��������·��  Added by Tony Lin on 2013-06-14
      */
     public static Map<String,String> getRandomImgPath(String imgType){
    	 Map<String,String>  ImgPathMap = new HashMap<String,String>();
    	 try{
    		 int EnabledImagePathNum = Integer.parseInt(SystemConfig.getConfigInfomation("Enabled"+imgType+"ImagePathNum"));
    		 Random rnd = new Random();
        	 int p = rnd.nextInt(9);//0~9�����
        	 //System.out.println(p%3);
        	 String ImagePath = imgType + "ImagePath" + (p%EnabledImagePathNum + 1);
        	 String VirtualRoute = imgType + "VirtualRoute" + (p%EnabledImagePathNum + 1);
        	//�����ļ���kkVirtualRoute5=kkftpserver5��������Ǽ�EnabledkkImagePathNum=5������伸���м�ע�͵��Ļ�pass��
         	if ("".equals(SystemConfig.getConfigInfomation(ImagePath))||"".equals(SystemConfig.getConfigInfomation(VirtualRoute))) {
         		 log.debug("++++++++"+ImagePath+"δ���ã���������ѡ��·��+++++++++");
         		 log.error("++++++++"+ImagePath+"δ���ã���������ѡ��·��+++++++++");
         		return getRandomImgPath(imgType);
 			}
        	 ImgPathMap.put("ImagePath",SystemConfig.getConfigInfomation(ImagePath));
        	 ImgPathMap.put("VirtualRoute", SystemConfig.getConfigInfomation(VirtualRoute));
        	 ImgPathMap.put("ftpPre", SystemConfig.getConfigInfomation("ftpPre"));
    	 }catch(Exception e){
    		 e.printStackTrace();
    		 
    	 }
    	 
    	 return ImgPathMap;
     }
     
     
     /**
      * test
      * @param args
      */
     public static void main(String[] args) {
    	 /*DateFormat df=DateFormat.getDateTimeInstance();
    	 Date endDate = new Date();
    	 String now=df.format(endDate); 
    	 System.out.println("����ʱ��:"+now);

    	 Date startDate;
		try {
			startDate = df.parse("2012-7-25 15:00:00");
			long n = (endDate.getTime() - startDate.getTime())/(60*60*1000);
			 System.out.println(n);
			 if(n < 2){
				 System.out.println("234234");
			 }
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}*/
    String str = "$%u6D59F3263D$02$330523021003$1$02$2012-08-1 15:18:22$80$ftp://supcon:supcon@10.10.76.33:21/picserver//kk_pic/20120801/330523021003/02/1/1343808616680_TZTP.jpg$ftp://supcon:supcon@10.10.76.33:21/picserver//kk_pic/20120801/330523021003/02/1/1343808616680_QMTP.jpg$ftp://supcon:supcon@10.10.76.33:21/picserver//kk_pic/20120801/330523021003/02/1/1343808616680_HPTP.jpg$2$%u5B89%u5409%u738B%u5BB6%u5E84%u5361%u70B9(S306%u7701%u905374KM%2B920M)$%u897F%u5411%u4E1C$%u5C0F%u578B%u6C7D%u8F66$";	 
   String nst = ItsUtility.unescape(str);   
   System.out.println(nst);
   String ww = "@"; 
   String ee = ItsUtility.unescape(ww);    
   
     }
}
