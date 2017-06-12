package its.webservice.util;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.ParsePosition;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;

import org.apache.commons.lang.StringUtils;

public abstract class TimeUtil {   
	  
	  
//	---��ǰ���ڵ��꣬�£��գ�ʱ���֣���   
	public static Calendar now   = Calendar.getInstance();   
	int    year = now.get( Calendar.YEAR );   
	int    date = now.get( Calendar.DAY_OF_MONTH );   
	int    month = now.get( Calendar.MONTH ) + 1;   
	int    hour = now.get( Calendar.HOUR );   
	int    min   = now.get( Calendar.MINUTE );   
	int    sec   = now.get( Calendar.SECOND );   
	  
//	-------------------------------��������ת��---------------------------------------------------------------------------   
	/**  
	* �ַ�������ת��util.Date������  
	* @Param:p_strDate �ַ�������   
	* @param p_format ��ʽ:"yyyy-MM-dd" / "yyyy-MM-dd hh:mm:ss"  
	* @Return:java.util.Date util.Date������  
	* @Throws: ParseException  
	* @Author: zhuqx  
	* @Date:   2006-10-31  
	*/   
	public static java.util.Date toUtilDateFromStrDateByFormat( String p_strDate, String p_format )   
	    throws ParseException {   
	   java.util.Date l_date = null;   
	   java.text.DateFormat df = new java.text.SimpleDateFormat( p_format );   
	   if ( p_strDate != null && ( !"".equals( p_strDate ) ) && p_format != null && ( !"".equals( p_format ) ) ) {   
	    l_date = df.parse( p_strDate );   
	   }   
	   return l_date;   
	}   
	  
	  
	  
	/**  
	* �ַ�������ת����sql.Date������  
	* @param p_strDate    �ַ�������  
	* @return java.sql.Date sql.Date������  
	* @throws ParseException   
	* @Author: zhuqx  
	* @Date:   2006-10-31  
	*/   
	public static java.sql.Date toSqlDateFromStrDate( String p_strDate ) throws ParseException {   
	   java.sql.Date returnDate = null;   
	   java.text.DateFormat sdf = new java.text.SimpleDateFormat();   
	   if ( p_strDate != null && ( !"".equals( p_strDate ) ) ) {   
	    returnDate = new java.sql.Date( sdf.parse( p_strDate ).getTime() );   
	   }   
	   return returnDate;   
	}   
	     
	/**   
	* util.Date������ת��ָ����ʽ���ַ���������  
	* @param   p_date    Date   
	* @param   p_format String   
	* ��ʽ1:"yyyy-MM-dd"   
	* ��ʽ2:"yyyy-MM-dd hh:mm:ss EE"   
	* ��ʽ3:"yyyy��MM��dd�� hh:mm:ss EE"   
	* ˵��: ��-��-�� ʱ:��:�� ���� ע��MM/mm��Сд  
	* @return String   
	* @Author: zhuqx  
	* @Date:   2006-10-31  
	*/   
	public static String toStrDateFromUtilDateByFormat( java.util.Date p_utilDate, String p_format ) throws ParseException {   
	   String l_result = "";   
	   if ( p_utilDate != null ) {   
	    SimpleDateFormat sdf = new SimpleDateFormat( p_format );   
	    l_result = sdf.format( p_utilDate );   
	   }   
	   return l_result;   
	}   
	  
	/**  
	* util.Date������ת��ת����Calendar����  
	* @param p_utilDate Date  
	* @return Calendar  
	* @Author: zhuqx  
	* @Date: 2006-10-31  
	*/   
	public static Calendar toCalendarFromUtilDate(java.util.Date p_utilDate) {   
	   Calendar c = Calendar.getInstance();   
	   c.setTime(p_utilDate);   
	   return c;   
	}   
	  
	/**  
	* util.Date������ת��sql.Date(������)������  
	* @Param: p_utilDate util.Date������  
	* @Return: java.sql.Date sql.Date������  
	* @Author: zhuqx  
	* @Date:   2006-10-31  
	*/   
	public static java.sql.Date toSqlDateFromUtilDate( java.util.Date p_utilDate ) {   
	   java.sql.Date returnDate = null;   
	   if ( p_utilDate != null ) {   
	    returnDate = new java.sql.Date( p_utilDate.getTime() );   
	   }   
	   return returnDate;   
	}   
	  
	/**  
	* util.Date������ת��sql.Time(ʱ����)������  
	* @Param: p_utilDate util.Date������  
	* @Return: java.sql.Time sql.Time������  
	* @Author: zhuqx  
	* @Date:   2006-10-31  
	*/   
	public static java.sql.Time toSqlTimeFromUtilDate( java.util.Date p_utilDate ) {   
	   java.sql.Time returnDate = null;   
	   if ( p_utilDate != null ) {   
	    returnDate = new java.sql.Time( p_utilDate.getTime() );   
	   }   
	   return returnDate;   
	}   
	  
	/**  
	* util.Date������ת��sql.Date(ʱ����)������  
	* @Param: p_utilDate util.Date������  
	* @Return: java.sql.Timestamp sql.Timestamp������  
	* @Author: zhuqx  
	* @Date:   2006-10-31  
	*/   
	public static java.sql.Timestamp toSqlTimestampFromUtilDate( java.util.Date p_utilDate ) {   
	   java.sql.Timestamp returnDate = null;   
	   if ( p_utilDate != null ) {   
	    returnDate = new java.sql.Timestamp( p_utilDate.getTime() );   
	   }   
	   return returnDate;   
	}   
	  
	/**  
	* sql.Date������ת��util.Date������  
	* @Param: sqlDate sql.Date������  
	* @Return: java.util.Date util.Date������  
	* @Author: zhuqx  
	* @Date:   2006-10-31  
	*/   
	public static java.util.Date toUtilDateFromSqlDate( java.sql.Date p_sqlDate ) {   
	   java.util.Date returnDate = null;   
	   if ( p_sqlDate != null ) {   
	    returnDate = new java.util.Date( p_sqlDate.getTime() );   
	   }   
	   return returnDate;   
	}
	
	public static String toStrDateTimeFromCalendarByFormat(Calendar calendar){
		int year =calendar.get(Calendar.YEAR);    
		  
		int month=calendar.get(Calendar.MONTH)+1;    
		  
		int day =calendar.get(Calendar.DAY_OF_MONTH);    
		  
		int hour =calendar.get(Calendar.HOUR_OF_DAY);    
		  
		int minute =calendar.get(Calendar.MINUTE);    
		  
		int seconds =calendar.get(Calendar.SECOND);  
		
		String _yystr = "", _mmstr = "", _ddstr = "", _hourstr = "", _minstr = "",_secondstr = "";
		_yystr = ""+year;
		_mmstr = "" + month;
		if (month < 10) {
            _mmstr = "0" + month;
        }
		_ddstr = ""+day;
		if (day < 10) {
            _ddstr = "0" + day;
        }
		_hourstr = ""+hour;
		if(hour<10){
			_hourstr = "0" + hour;
		}
		_minstr = ""+minute;
		if(minute<10){
			_minstr = "0" + minute;
		}
		_secondstr = ""+seconds;
		if(seconds<10){
			_secondstr = "0" + seconds;
		}
		String time = _yystr+"-"+_mmstr+"-"+_ddstr+" "+_hourstr+":"+_minstr+":"+_secondstr;
		
		return time;
	}
	
	public static String toStrDateFromCalendarByFormat(Calendar calendar){
		int year =calendar.get(Calendar.YEAR);    
		  
		int month=calendar.get(Calendar.MONTH)+1;    
		  
		int day =calendar.get(Calendar.DAY_OF_MONTH);   
		
		String _yystr = "", _mmstr = "", _ddstr = "";
		_yystr = ""+year;
		_mmstr = "" + month;
		if (month < 10) {
            _mmstr = "0" + month;
        }
		_ddstr = ""+day;
		if (day < 10) {
            _ddstr = "0" + day;
        }
		
		String daystr = _yystr+"-"+_mmstr+"-"+_ddstr;
		
		return daystr;
	}
	  
//	-----------------��ȡָ�����ڵ���ݣ��·ݣ��շݣ�Сʱ���֣��룬����----------------------------   
	/**   
	* ��ȡָ�����ڵ����   
	* @param p_date util.Date����   
	* @return int   ���   
	* @author zhuqx  
	* @Date:   2006-10-31  
	*/   
	public static int getYearOfDate( java.util.Date p_date ) {   
	   java.util.Calendar c = java.util.Calendar.getInstance();   
	   c.setTime( p_date );   
	   return c.get( java.util.Calendar.YEAR );   
	}   
	     
	/**   
	* ��ȡָ�����ڵ��·�   
	* @param p_date util.Date����   
	* @return int   �·�   
	* @author zhuqx  
	* @Date:   2006-10-31  
	*/   
	public static int getMonthOfDate( java.util.Date p_date ) {   
	   java.util.Calendar c = java.util.Calendar.getInstance();   
	   c.setTime( p_date );   
	   return c.get( java.util.Calendar.MONTH ) + 1;   
	}   
	  
	/**   
	* ��ȡָ�����ڵ��շ�   
	* @param p_date util.Date����   
	* @return int   �շ�   
	* @author zhuqx  
	* @Date:   2006-10-31  
	*/   
	public static int getDayOfDate( java.util.Date p_date ) {   
	   java.util.Calendar c = java.util.Calendar.getInstance();   
	   c.setTime( p_date );   
	   return c.get( java.util.Calendar.DAY_OF_MONTH );   
	}   
	  
	/**   
	* ��ȡָ�����ڵ�Сʱ   
	* @param p_date util.Date����   
	* @return int   �շ�   
	* @author zhuqx  
	* @Date:   2006-10-31  
	*/   
	public static int getHourOfDate( java.util.Date p_date ) {   
	   java.util.Calendar c = java.util.Calendar.getInstance();   
	   c.setTime( p_date );   
	   return c.get( java.util.Calendar.HOUR_OF_DAY );   
	}   
	     
	/**   
	* ��ȡָ�����ڵķ���   
	* @param p_date util.Date����   
	* @return int   ����   
	* @author zhuqx  
	* @Date:   2006-10-31  
	*/   
	public static int getMinuteOfDate( java.util.Date p_date ) {   
	   java.util.Calendar c = java.util.Calendar.getInstance();   
	   c.setTime( p_date );   
	   return c.get( java.util.Calendar.MINUTE );   
	}   
	     
	/**   
	* ��ȡָ�����ڵ�����   
	* @param p_date util.Date����   
	* @return int   ����   
	* @author zhuqx  
	* @Date:   2006-10-31  
	*/   
	public static int getSecondOfDate( java.util.Date p_date ) {   
	   java.util.Calendar c = java.util.Calendar.getInstance();   
	   c.setTime( p_date );   
	   return c.get( java.util.Calendar.SECOND );   
	}   
	     
	/**   
	* ��ȡָ�����ڵĺ���     
	* @param p_date util.Date����   
	* @return long   ����     
	* @author zhuqx  
	* @Date:   2006-10-31  
	*/   
	public static long getMillisOfDate( java.util.Date p_date ) {   
	   java.util.Calendar c = java.util.Calendar.getInstance();   
	   c.setTime( p_date );   
	   return c.getTimeInMillis();   
	}   
	  
//	-----------------��ȡ��ǰ/ϵͳ����(ָ�����ڸ�ʽ)-----------------------------------------------------------------------------------   
	/**  
	* ��ȡָ�����ڸ�ʽ��ǰ���ڵ��ַ�������  
	* @param p_format ���ڸ�ʽ  
	* ��ʽ1:"yyyy-MM-dd"   
	* ��ʽ2:"yyyy-MM-dd hh:mm:ss EE"   
	* ��ʽ3:"yyyy��MM��dd�� hh:mm:ss EE"   
	* ˵��: ��-��-�� ʱ:��:�� ���� ע��MM/mm��Сд  
	* @return String ��ǰʱ���ַ���  
	* @author zhuqx  
	* @Date:   2006-10-31  
	*/   
	public static String getNowOfDateByFormat( String p_format ) {   
	   Date d = new Date();   
	   SimpleDateFormat sdf = new SimpleDateFormat( p_format );   
	   String dateStr = sdf.format( d );   
	   return dateStr;   
	}   
	  
	/**  
	* ��ȡָ�����ڸ�ʽϵͳ���ڵ��ַ�������  
	* @param p_format ���ڸ�ʽ  
	* ��ʽ1:"yyyy-MM-dd"   
	* ��ʽ2:"yyyy-MM-dd hh:mm:ss EE"   
	* ��ʽ3:"yyyy��MM��dd�� hh:mm:ss EE"   
	* ˵��: ��-��-�� ʱ:��:�� ���� ע��MM/mm��Сд  
	* @return String ϵͳʱ���ַ���  
	* @author zhuqx  
	* @Date:   2006-10-31  
	*/   
	public static String getSystemOfDateByFormat( String p_format ) {   
	   long time = System.currentTimeMillis();   
	   Date d = new Date( time );   
	   SimpleDateFormat sdf = new SimpleDateFormat( p_format );   
	   String dateStr = sdf.format( d );   
	   return dateStr;   
	}   
	  
	/**  
	* ��ȡ�ַ�����һ���µ�����  
	* @param p_date  
	* @return ����  
	* @author zhuqx  
	*/   
	public static long getDayOfMonth( Date p_date ) throws ParseException {   
	   int year = getYearOfDate(p_date);   
	   int month = getMonthOfDate( p_date )-1;   
	   int day = getDayOfDate( p_date );   
	   int hour = getHourOfDate( p_date );   
	   int minute = getMinuteOfDate( p_date );   
	   int second = getSecondOfDate( p_date );   
	   Calendar l_calendar = new GregorianCalendar(year,month,day,hour,minute,second);   
	   return l_calendar.getActualMaximum( Calendar.DAY_OF_MONTH );   
	}   
	  
//	 -----------------��ȡָ���·ݵĵ�һ��,���һ�� ---------------------------------------------------------------------------   	
	/**   
	* ��ȡָ���·ݵĵ�һ��   
	* @param p_strDate ָ���·�  
	* @param p_formate ���ڸ�ʽ  
	* @return String ʱ���ַ���  
	* @author zhuqx  
	* @Date:   2006-10-31  
	*/   
	public static String getDateOfMonthBegin( String p_strDate, String p_format ) throws ParseException {   
	   java.util.Date date = toUtilDateFromStrDateByFormat( p_strDate,p_format );   
	   return toStrDateFromUtilDateByFormat( date,"yyyy-MM" ) + "-01";   
	}   
	     
	/**   
	* ��ȡָ���·ݵ����һ��   
	* @param p_strDate ָ���·�  
	* @param p_formate ���ڸ�ʽ  
	* @return String ʱ���ַ���  
	* @author zhuqx  
	* @Date:   2006-10-31  
	*/   
	public static String getDateOfMonthEnd( String p_strDate, String p_format ) throws ParseException {   
	   java.util.Date date = toUtilDateFromStrDateByFormat( getDateOfMonthBegin( p_strDate,p_format ),p_format );   
	   Calendar calendar = Calendar.getInstance();   
	   calendar.setTime( date );   
	   calendar.add( Calendar.MONTH,1 );   
	   calendar.add( Calendar.DAY_OF_YEAR,-1 );   
	   return toStrDateFromUtilDateByFormat( calendar.getTime(),p_format );   
	}   
	
	/**
	 * ��ȡָ����ݵĵ�һ��   
	 * @param p_strDate  ָ�����
	 * @param p_format
	 * @return
	 * @throws ParseException
	 */
	public static String getDateOfYearBegin( String p_strDate, String p_format ) throws ParseException {   
		   java.util.Date date = toUtilDateFromStrDateByFormat( p_strDate,p_format );   
		   return toStrDateFromUtilDateByFormat(date,"yyyy") + "-01-01";   
	}
	
	/**   
	* ��ȡָ����ݵ����һ��   
	* @param p_strDate ָ���·�  
	* @param p_formate ���ڸ�ʽ  
	* @return String ʱ���ַ���  
	* @author zhuqx  
	* @Date:   2006-10-31  
	*/   
	public static String getDateOfYearEnd( String p_strDate, String p_format ) throws ParseException {   
	   java.util.Date date = toUtilDateFromStrDateByFormat( getDateOfYearBegin( p_strDate,p_format ),p_format );   
	   Calendar calendar = Calendar.getInstance();   
	   calendar.setTime( date );   
	   calendar.add( Calendar.YEAR,1 );   
	   calendar.add( Calendar.DAY_OF_YEAR,-1 );   
	   return toStrDateFromUtilDateByFormat( calendar.getTime(),p_format );   
	} 
	
	/**
	 * ��ȡ��ǰ��ݼ�֮ǰ5�� ����б�
	 * @param n ��ǰ�����ǰ�����
	 * @return
	 */
	public static List<Integer> getYearList(int n){
		Calendar calendar = Calendar.getInstance();
		List<Integer> yearList = new ArrayList<Integer>();
		int nowYear = calendar.get(Calendar.YEAR);
		for(int i=0;i<n+1;i++){
			yearList.add(nowYear-i);
		}
		return yearList;
	}
	
	/**
	 * ��ȡ�·��б�
	 * @return
	 */
	public static List<String> getMonthList(){
		List<String> monthList = new ArrayList<String>();
		for(int i=0;i<12;i++){
			monthList.add(StringUtils.repeat(i+1+"", 2));
		}
		return monthList;
	}
	/**
	 * ��ȡСʱ�б�
	 * @return
	 */
	public static List<String> getHourList(){
		List<String> hourList = new ArrayList<String>();
		for(int i=-1;i<23;i++){
			hourList.add(StringUtils.repeat(i+1+"", 2));
		}
		return hourList;
	}
	
	//**********************************************00 2010-05-30����***********************************************************
	
    //����ȫ�ֿ��� ��һ�ܣ����ܣ���һ�ܵ������仯     
    private static int weeks = 0;     
//    private static int MaxDate;//һ���������     
//    private static int MaxYear;//һ���������  
	 /**    
        * �õ��������ڼ�ļ������    
        */     
    public static String getTwoDay(String sj1, String sj2) {     
        SimpleDateFormat myFormatter = new SimpleDateFormat("yyyy-MM-dd");     
        long day = 0;     
        try {     
         java.util.Date date = myFormatter.parse(sj1);     
         java.util.Date mydate = myFormatter.parse(sj2);     
         day = (date.getTime() - mydate.getTime()) / (24 * 60 * 60 * 1000);     
        } catch (Exception e) {     
         return "";     
        }     
        return day + "";     
    }     
     
     
    /**    
        * ����һ�����ڣ����������ڼ����ַ���          
        */     
    public static String getWeek(String sdate) {     
        // ��ת��Ϊʱ��     
        Date date = TimeUtil.strToDate(sdate);     
        Calendar c = Calendar.getInstance();     
        c.setTime(date);     
        return new SimpleDateFormat("EEEE").format(c.getTime());     
    }     
     
    /**    
        * ����ʱ���ʽ�ַ���ת��Ϊʱ�� yyyy-MM-dd 
        */     
    public static Date strToDate(String strDate) {     
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");     
        ParsePosition pos = new ParsePosition(0);     
        Date strtodate = formatter.parse(strDate, pos);     
        return strtodate;     
    }     
     
    /**    
        * ����ʱ��֮������� 
        */     
    public static long getDays(String date1, String date2) {     
        if (date1 == null || date1.equals(""))     
         return 0;     
        if (date2 == null || date2.equals(""))     
         return 0;     
        // ת��Ϊ��׼ʱ��     
        SimpleDateFormat myFormatter = new SimpleDateFormat("yyyy-MM-dd");     
        java.util.Date date = null;     
        java.util.Date mydate = null;     
        try {     
         date = myFormatter.parse(date1);     
         mydate = myFormatter.parse(date2);     
        } catch (Exception e) {     
        }     
        long day = (date.getTime() - mydate.getTime()) / (24 * 60 * 60 * 1000);     
        return day;     
    }     
     
     
     
         
    // ���㵱�����һ��,�����ַ���     
    public static String getDefaultDay(){       
       String str = "";     
       SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");         
     
       Calendar lastDate = Calendar.getInstance();     
       lastDate.set(Calendar.DATE,1);//��Ϊ��ǰ�µ�1��     
       lastDate.add(Calendar.MONTH,1);//��һ���£���Ϊ���µ�1��     
       lastDate.add(Calendar.DATE,-1);//��ȥһ�죬��Ϊ�������һ��     
            
       str=sdf.format(lastDate.getTime());     
       return str;       
    }     
         
    // ���µ�һ��     
    public static String getPreviousMonthFirst(){       
       String str = "";     
       SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");         
     
       Calendar lastDate = Calendar.getInstance();     
       lastDate.set(Calendar.DATE,1);//��Ϊ��ǰ�µ�1��     
       lastDate.add(Calendar.MONTH,-1);//��һ���£���Ϊ���µ�1��     
        str=sdf.format(lastDate.getTime());     
       return str;       
    }     
         
    //��ȡ���µ�һ��     
    public static String getFirstDayOfMonth(){       
       String str = "";     
       SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");         
     
       Calendar lastDate = Calendar.getInstance();     
       lastDate.set(Calendar.DATE,1);//��Ϊ��ǰ�µ�1��     
       str=sdf.format(lastDate.getTime());     
       return str;       
    }    
         
         
    //��ȡ����ʱ��      
    public static String getNowTime(String dateformat){     
        Date   now   =   new   Date();        
        SimpleDateFormat   dateFormat   =   new   SimpleDateFormat(dateformat);//���Է�����޸����ڸ�ʽ        
        String hehe = dateFormat.format(now);        
        return hehe;     
    }     
    
  //��ȡ����ʱ��      
    public static String returnNowDate(String dateformat ){
    	Calendar calendar_now = Calendar.getInstance();
    	SimpleDateFormat   sdf = new  SimpleDateFormat (dateformat);
    	String now_date_str =   sdf.format(calendar_now.getTime());
    	return  now_date_str;
    }
    
         
    // ��õ�ǰ�����뱾������������     
    private static int getMondayPlus() {     
        Calendar cd = Calendar.getInstance();     
        // ��ý�����һ�ܵĵڼ��죬�������ǵ�һ�죬���ڶ��ǵڶ���......     
        int dayOfWeek = cd.get(Calendar.DAY_OF_WEEK)-1;         //��Ϊ���й����һ��Ϊ��һ�����������1  
        //System.out.println("�������:"+dayOfWeek);     
        if (dayOfWeek == 1) {     
            return 0;     
        } else {     
            return 1 - dayOfWeek;     
        }     
    }     
         
    //��ñ���һ������     
    public static String getMondayOFWeek(){
         int mondayPlus = getMondayPlus();     
         GregorianCalendar currentDate = new GregorianCalendar();     
         currentDate.add(GregorianCalendar.DATE, mondayPlus);     
         Date monday = currentDate.getTime();     
              
         DateFormat df = DateFormat.getDateInstance();     
         String preMonday = df.format(monday);     
         return preMonday;     
    }     
         
    //�����Ӧ�ܵ�����������     
    public static String getSaturday() {     
        int mondayPlus = getMondayPlus();     
        GregorianCalendar currentDate = new GregorianCalendar();     
        currentDate.add(GregorianCalendar.DATE, mondayPlus + 7 * 0 + 6);     
        Date monday = currentDate.getTime();     
        DateFormat df = DateFormat.getDateInstance();     
        String preMonday = df.format(monday);     
        return preMonday;     
    }          
         
    // ��ñ��������յ�����       
    public static String getCurrentWeekday() {
        int mondayPlus = getMondayPlus();     
        GregorianCalendar currentDate = new GregorianCalendar();     
        currentDate.add(GregorianCalendar.DATE, mondayPlus+6);     
        Date monday = currentDate.getTime();     
             
        DateFormat df = DateFormat.getDateInstance();     
        String preMonday = df.format(monday);     
        return preMonday;     
    } 
         
    // ������������յ�����     
    public static String getPreviousWeekSunday() {  
        int mondayPlus = getMondayPlus();     
        GregorianCalendar currentDate = new GregorianCalendar();     
        currentDate.add(GregorianCalendar.DATE, mondayPlus+weeks);     
        Date monday = currentDate.getTime();     
        DateFormat df = DateFormat.getDateInstance();     
        String preMonday = df.format(monday);     
        return preMonday;     
    }     
     
    // �����������һ������     
    public static String getPreviousWeekday() {  
        int mondayPlus = getMondayPlus();     
        GregorianCalendar currentDate = new GregorianCalendar();     
        currentDate.add(GregorianCalendar.DATE, mondayPlus + 7 * weeks);     
        Date monday = currentDate.getTime();     
        DateFormat df = DateFormat.getDateInstance();     
        String preMonday = df.format(monday);     
        return preMonday;     
    }     
         
    // �����������һ������     
    public static String getNextMonday() {     
        int mondayPlus = getMondayPlus();     
        GregorianCalendar currentDate = new GregorianCalendar();     
        currentDate.add(GregorianCalendar.DATE, mondayPlus + 7);     
        Date monday = currentDate.getTime();     
        DateFormat df = DateFormat.getDateInstance();     
        String preMonday = df.format(monday);     
        return preMonday;     
    }
	//*******************************************************************************************************************
}