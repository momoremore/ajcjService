// -------------------------------------------------------------
// $Id: ApplicationDao.java, v 1.5 2008/10/22 11:41:18
// $Exp Copyright(c) SUPCON 2008-2011. All Rights Reserved.
// -------------------------------------------------------------
package its.webservice.dao;

import its.webservice.entity.CrossBean;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;



//*****************************************************************************
//�û���            ����
//ϵͳ��           ���ܽ�ͨ����ƽ̨
//��ϵͳ��          ��ͨ
//����              ��Spring����ʱ, ��ʼ��(�����������ݿ�)һЩϵͳ���õļ���.
/**
 * Application DAO service interface<br>
 * 
 * @author Tony Lin
 * @version Version 1.0
 */
//��������
//2008��10��22������
//*****************************************************************************
public interface ApplicationDao {

    /**
     * ���ϵͳ������Ϣ
     * 
     * Tony Lin Added on 2008-11-07
     * @return Map �������APP_CONFIG����key��value��ֵ��
     */
    public Map getAppConfigMap();
    
	/**
	 * �������·���б�
	 * @return
	 */
	public Map<String,String> getAllCrossList();
	
    /**
     * ��ѯa_code���Ӧ���е�typeId��map��code��name���ļ�ֵ��
     * 
     * @author Tony Lin Added on 2008-11-03
     * @return Map
     */
    public List getDictionary();

}
