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

/**
 * @author: fangtinghua
 * @date: 2013-07-23
 * @description: ���ڹ����࣬�������ں��ַ���֮���໥ת��
 */
public class DateUtil {
	public static final String Y = "yyyy";
	public static final String dd = "dd";
	public static final String MD= "MM-dd";
	public static final String MDD= "MMdd";
	public static final String M = "MM";
	public static final String MM = "yyyyMM";
	public static final String DD = "yyyyMMdd";
	public static final String H = "HH:00";
	public static final String HM = "HH:mm";
	public static final String HMS = "HH:mm:ss";
	public static final String YM = "yyyy-MM";
	public static final String YMD = "yyyy-MM-dd";
	public static final String YMDH = "yyyy-MM-dd HH";
	public static final String YMDHM = "yyyy-MM-dd HH:mm";
	public static final String DEFAULT = "yyyy-MM-dd HH:mm:ss";
	public static final String LONGDATE = "yyyyMMddHHmmss";
	public static final String TABLENAME = "yyyyMMdd";
	private static final GregorianCalendar GC = new GregorianCalendar();

	/**
	 * ��Ĭ�ϸ�ʽ�����ַ�������
	 * 
	 * @param date
	 * @return Date
	 */
	public static Date parse(String date) {
		DateFormat format = new SimpleDateFormat(DEFAULT);
		try {
			return format.parse(date);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return null;
	}

	/**
	 * ��ָ����ʽ�����ַ�������
	 * 
	 * @param date
	 * @return Date
	 */
	public static Date parse(String date, String format) {
		DateFormat fmt = new SimpleDateFormat(format);
		try {
			return fmt.parse(date);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return null;
	}

	/**
	 * ��Ĭ�ϸ�ʽ���������ַ���
	 * 
	 * @param date
	 * @return Date
	 */
	public static String format(Date date) {
		DateFormat format = new SimpleDateFormat(DEFAULT);
		return format.format(date);
	}

	/**
	 * ��ָ����ʽ���������ַ���
	 * 
	 * @param date
	 * @return Date
	 */
	public static String format(Date date, String format) {
		DateFormat fmt = new SimpleDateFormat(format);
		return fmt.format(date);
	}
	/**
	 * ��ǰʱ��+-
	 * @param date
	 * @param offset
	 * @param type
	 * @return
	 */
	public static String nowDatePlus(int offset,String format) {
		Calendar nowtime = Calendar.getInstance();
		nowtime.add(Calendar.MINUTE, offset);
		return DateUtil.format(nowtime.getTime(), format);
	}
	/**
	 * offsetΪ��������,Ϊ������ǰ
	 * 
	 * @param date
	 * @param offset
	 * @param type
	 * @return
	 */
	public static Date subtract(Date date, int offset, int type) {
		GC.setTime(date);
		GC.add(type, offset);
		return GC.getTime();
	}

	/**
	 * �ӿ�ʼ���������ڣ��������ڷ��������б�
	 * 
	 * @param startTime
	 * @param endTime
	 * @param cycle
	 * @return
	 */
	public static List<String> getTimeSpace(Date startTime, Date endTime,
			int cycle, int type, String format) {
		List<String> resultList = new ArrayList<String>();
		while (startTime.before(endTime)) {
			resultList.add(format(startTime, format));
			startTime = subtract(startTime, cycle, type);
		}
		return resultList;
	}
	
	public static List<String> getTimeSpaceMM(Date startTime, Date endTime,
			int cycle, int type, String format) {
		List<String> resultList = new ArrayList<String>();
		resultList.add(format(startTime, format));
		if (!startTime.equals(endTime)) {
			do{
				startTime = subtract(startTime, cycle, type);
				resultList.add(format(startTime, format));
			}while (startTime.before(endTime));
		}
		return resultList;
	}
	
	public static boolean isSameTime(Date date1,Date date2) {
		if (date1.getTime()==date2.getTime()) {
			return true;
		}else {
			return false;
		}
	}
	
	public static Date getDateofPreMonth(Date date) {
		long datelong = date.getTime()/1000-60*60*24*365;
		date.setTime(datelong*1000);
		return date;
	}
	
	
	/**
	    * ����һ�����ڣ����������ڼ����ַ���
	    *
	    * @param sdate
	    * @return
	    */
		public static String getWeek(String sdate) {
		    // ��ת��Ϊʱ��
		    Date date = strToDate(sdate);
		    Calendar c = Calendar.getInstance();
		    c.setTime(date);
		    // int hour=c.get(Calendar.DAY_OF_WEEK);
		    // hour�д�ľ������ڼ��ˣ��䷶Χ 1~7
		    // 1=������ 7=����������������
		    return new SimpleDateFormat("EEEE").format(c.getTime());
		}
		/**
		 * ����ʱ���ʽ�ַ���ת��Ϊʱ�� yyyy-MM-dd
		 *
		 * @param strDate
		 * @return
		 */
		public static Date strToDate(String strDate) {
			SimpleDateFormat formatter = new SimpleDateFormat(YMD);
			ParsePosition pos = new ParsePosition(0);
			Date strtodate = formatter.parse(strDate, pos);
			return strtodate;
		}
}
