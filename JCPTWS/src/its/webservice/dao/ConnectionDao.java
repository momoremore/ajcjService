// -------------------------------------------------------------
// $Id: ConnectionDao.java, v 1.5 2010/01/13 14:23:33
// $Exp Copyright(c) SUPCON 2008-2010. All Rights Reserved.
// -------------------------------------------------------------
package its.webservice.dao;

import its.webservice.entity.ConnectionedBean;
import its.webservice.entity.InsertConnectionedBean;

import java.util.List;

//*****************************************************************************
//�û���            ����
//ϵͳ��           ���ܽ�ͨ����ƽ̨
//��ϵͳ��          ����ά������
//����              PING ���Ե�����״̬��ش���Dao�ӿ�
/**
 * ConnectionDao DAO service interface<br>
 * 
 * @author SUPCON
 * @version Version 1.0
 */
//��������
//2010��01��13������
//*****************************************************************************
public interface ConnectionDao {

    
	
	
	/**
     * ȡ�������豸����״̬CONNECTED��Ϣ
     * @author lvhua
     * @TIME  2011-11-23 
     * @return Map
     */
    @SuppressWarnings("unchecked")
    public List<ConnectionedBean> getAllDeviceInfoList();
    
    
    /**
     * @method �����豸��������״̬
     * @author LvHua
     * @param  selectSql     
     * @return boolean
     * @date   2011-11-28
    */ 
	public  boolean  updateDeviceStatus(String selectSql);
	
	    
	 
       
    /**
	*@method ���������豸������������Ϣ
	*@author LvHua
	*@param  List<InsertConnectionedBean>   
    *@return boolean
    *@date   2012-03-05
    */
	public boolean  addDeviceNetWorkInfo(final List <InsertConnectionedBean> connectionedBeanList );
	
	/**
	*@method ���������豸����������Ϣ
	*@author LvHua
	*@param  List<InsertConnectionedBean>   
    *@return boolean
    *@date   2012-06-26
    */
	public boolean  addDeviceOnLine(final List <InsertConnectionedBean> connectionedBeanList ,String msg );
	
	
	 /**
	 * ������¶�����Ϣ������Ϣ
	 * @param msg
	 * @date  2013-07-16
	 * @return Boolean
	 */
	public boolean writeMobileMessage(String msg);

}
