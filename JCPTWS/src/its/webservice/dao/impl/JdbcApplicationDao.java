// $Id: JdbcApplicationDao.java, v 1.5 2008/10/22 11:41:18
// $Exp Copyright(c) SUPCON 2008-2011. All Rights Reserved.
// -----------------------------------------------------------------
package its.webservice.dao.impl;

import its.webservice.common.BaseRowMapper;
import its.webservice.dao.ApplicationDao;
import its.webservice.entity.CrossBean;

import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.springframework.jdbc.core.JdbcTemplate;



//*****************************************************************************
//�û���            ����
//ϵͳ��           ���ܽ�ͨ����ƽ̨
//��ϵͳ��          ��ͨ
//����              ��Spring����ʱ, ��ʼ��(�����������ݿ�)һЩϵͳ���õļ���.
/**
 * Application DAO Implementation Class<br>
 * 
 * @author lzk
 * @version Version 1.0
 */
//��������
//2008��10��22������
//*****************************************************************************
public class JdbcApplicationDao extends JdbcTemplate implements ApplicationDao {

    
    /**
     * ���ϵͳ������Ϣ
     * 
     * Tony Lin Added on 2008-11-07
     * @return Map �������APP_CONFIG����key��value��ֵ��
     */
    public Map getAppConfigMap(){
    	logger.debug("JdbcApplicationDao.getAppConfigMap() invoked...");
    	String sql = "select t.key,t.value from app_config t ";
    	Map<String,String> configMap = new HashMap<String,String>();
    	List rowList = this.queryForList(sql);
		Iterator rowIterator = rowList.iterator();
        while (rowIterator.hasNext()) {
            Map rowMap = (Map)rowIterator.next();
            configMap.put(rowMap.get("KEY").toString(),rowMap.get("VALUE") == null ? "" : rowMap.get("VALUE").toString());
        }
    	
    	return configMap;
    }
    
	/**
	 * �������·���б�
	 * @return List<CrossBean>
	 */
    @SuppressWarnings("unchecked")
	public Map<String,String> getAllCrossList() {
		logger.debug("JdbcApplicationDao.getAllCrossList() start...");

		String sql = "\n SELECT DEVICE_CODE,DEVICE_NAME \n"            + 
                       "  FROM DEVICE_TGS_INFO \n"        + 
                       "  UNION SELECT DEVICE_CODE,DEVICE_NAME FROM DEVICE_EPS_INFO WHERE DEVICE_MODE = '1' \n";
		
		Map<String,String> crossMap = new HashMap<String,String>();
    	List rowList = this.queryForList(sql);
    	if(null!=rowList && rowList.size()>0){
    		Iterator rowIterator = rowList.iterator();
            while (rowIterator.hasNext()) {
                Map rowMap = (Map)rowIterator.next();
                crossMap.put(rowMap.get("DEVICE_CODE").toString(),rowMap.get("DEVICE_NAME") == null ? "" : rowMap.get("DEVICE_NAME").toString());
            }
    	}		
		logger.debug("JdbcApplicationDao.getAllCrossList() End.");
		return crossMap;
	}
    
    /**
     * ��ѯa_code���Ӧ���е�typeId��map��code��name���ļ�ֵ��
     * 
     * @author Tony Lin Added on 2008-11-03
     * @return List
     */
    public List getDictionary(){
    	logger.debug("JdbcApplicationDao.getDictionary() invoked...");
    	String sql = "select t.type_id, t.code, t.name from a_code t order by t.type_id,t.code ";

    	return (List)this.queryForList(sql);
    }

}
