/**
 * Copyright(c) SUPCON 2008-2011. �㽭����п���Ϣ�������޹�˾
 */

package its.webservice.dao.impl;

import its.webservice.dao.UserDao;

import org.apache.log4j.Logger;
import org.springframework.jdbc.core.JdbcTemplate;


/**
 * ϵͳ���ƣ����ܽ�ͨWebService����(ITSWebService)
 * ����ģ�飺ϵͳ����
 * �����������û��������ݿ�ӿ�ʵ����
 * �ļ�����com.supconit.its.dao.impl.UserDaoImpl.java
 * �汾��Ϣ��1.00
 * 
 * �������ţ��з�����
 * �����ߣ� lzk
 * ����ʱ�䣺Jan 25, 2011 3:10:35 PM
 * �޸��ߣ� lzk
 * �޸�ʱ�䣺Jan 25, 2011 3:10:35 PM
 */

public class UserDaoImpl extends JdbcTemplate implements UserDao {

	/** ��ȡLog4jʵ�� */
    protected Logger log = Logger.getLogger(UserDaoImpl.class.getName());
	
	public int test(String id) {
		log.debug("UserDaoImpl.test Start.......");
		String sql = "select count(*) from its_user where id = " + id;
		int rowNum  = this.queryForInt(sql);
		
		log.debug("UserDaoImpl.test End.......");
		return rowNum;
	}

}
