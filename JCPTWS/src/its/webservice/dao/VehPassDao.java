/**
 * Copyright(c) SUPCON 2008-2011. �㽭����п���Ϣ�������޹�˾
 */

package its.webservice.dao;

import java.util.List;
import java.util.Map;

import its.webservice.entity.WbRecord;
import its.webservice.service.BlackNameInfo;
import its.webservice.service.DeviceStatInfo;
import its.webservice.service.VehicleInfo;

/**
 * ϵͳ���ƣ����ܽ�ͨWebService����(ITSWebService)
 * ����ģ�飺�������ݵ���
 * �����������������ݵ������ݿ�ӿ�
 * �ļ�����com.supconit.its.dao.VehPassDao.java
 * �汾��Ϣ��1.00
 * 
 * �������ţ��з�����
 * �����ߣ� lzk
 * ����ʱ�䣺Jan 25, 2011 4:20:13 PM
 * �޸��ߣ� lzk
 * �޸�ʱ�䣺Jan 25, 2011 4:20:13 PM
 */

public interface VehPassDao {
	
	/**
	 * ��������д��ӿڷ���
	 * @param 
	 * @return String
	 */
	public boolean WriteVehicleInfo(String SBBH,String FXBH,String HPHM,String HPZL,String JGSJ,String CLSD,String HPYS,String CSYS,String CLLX,String TZTP,String QMTP,String HPTP,String CDH,String XS);
	
	/**
	 * ��������(��ͼƬ)д��ӿڷ���
	 * 
	 * @return String
	 */
	public boolean WriteVehicleInfoWithPhoto(String SBBH,String FXBH,String HPHM,String HPZL,String JGSJ,String CLSD,String HPYS,String CSYS,String CLLX,String TZTPFtpPath,String QMTPFtpPath,String HPTPFtpPath,String CDH,String XS);
	
	/**
	 * ���ر�������д��ӿڷ���
	 * @param vehInfo
	 * @return String
	 */
	public boolean WriteAlarmVehInfo(VehicleInfo vehInfo);
	
	/**
	 * ����������д��ӿڷ���
	 * @param blackNameInfo
	 * @return
	 */
	public boolean WriteBlackName(BlackNameInfo blackNameInfo);
	
	/**
	 * ��������豸���/��ԿMap
	 * @return Map<deviceCode,deviceKey>
	 */
	public Map<String,String> getAllDeviceKey();
	
	/**
	 * ��ʼ������д���������
	 * @param deviceCode
	 * @param deviceKey
	 * @return
	 */
	public boolean InitWriteVehInfo(String deviceCode,String deviceKey);
	
	/**
	 * �жϿ���ƽ̨�Ƿ�����Ӹ�·��
	 * @param deviceCode
	 * @return
	 */
	public boolean hasAddedCode(String deviceCode);
	
	/**
	 * �ж��Ƿ��Ѵ��ڸú�����
	 * @param cph
	 * @return
	 */
	public boolean hasThisBlackName(String cph);
	
	/**
	 * �豸״̬д��ӿڷ���
	 * @return
	 */
	public boolean WriteDeviceStat(DeviceStatInfo deviceStatInfo);
	
	/**
	 * �������·����Ϣ��ID,NAME��
	 * @return
	 */
	public List<Map<String,String>> getAllCross();
	
	/**
	 * ��ȡ������Ϣ
	 * @param passID
	 * @return
	 */
	public List<Map<String,String>> getVehicleDetail(String passID);
	
	/**
	 * ��ȡ����������Ϣ
	 * @param crossID
	 * @return
	 */
	public List<Map<String,String>> getCrossDetail(String crossID);
	
	/**
	 * ��ȡͳ����Ϣ
	 * @return
	 */
	public List<Map<String,String>> getStatInfo(String hphm,String clzl,String hpys,String startTime,String endTime,String crossID,String fxList);

	/**
	 * ���ݲ�ѯ�����������
	 * @param hphm
	 * @param cllx
	 * @param hpys
	 * @param startTime
	 * @param endTime
	 * @param crossID
	 * @return
	 */
	public int getPassTotolCount(String hphm, String cllx, String hpys,
			String startTime, String endTime, String crossID);
	
	
	/**
	 * д�����ɳ���
	 * @return
	 */
	public boolean insertFaultCp(VehicleInfo vehInfo);
	
	/**
	 * ��������Ͻ����ѯ����
	 * @param canton
	 * @return
	 */
	public List<Map<String,String>> getCrossByCanton(String canton);
	
	/**
	 * д��Υ����������
	 * @param 
	 * @return
	 */
	public boolean insertWFCLB(String SBBH,String FXBH,String HPHM,String HPZL,String JGSJ,String CLSD,String HPYS,String CSYS,String CLLX,String TZTP,String QMTP,String HPTP,String CDH,String XS);
	/*
	 * д��Υ����������
	 * @param 
	 * @return
	 */
	 
	public boolean insertWFCLBTemp(String SBBH,String FXBH,String HPHM,String HPZL,String JGSJ,String CLSD,String HPYS,String CSYS,String CLLX,String TZTP,String QMTP,String HPTP,String CDH,String XS);
	
	 /**
	 * 
	 *@��������:insertHbcToWFCLB
	 *@��    ��: 
	 *@��    ����
	 *@��    ��: ������
	 *@��������:2013-8-8
	 *@��������:  �Ʊ공д��Υ�����ݱ�
	 */
	public boolean insertHbcToWFCLB(String SBBH,String FXBH,String HPHM,String HPZL,String JGSJ,String CLSD,String HPYS,
			String CSYS,String CLLX,String TZTP,String QMTP,String HPTP,String CDH,String XS);
	/**
	 * Υ������(�������ڡ��羯)д��ӿ�
	 * @param SBBH
	 * @param FXBH
	 * @param HPHM
	 * @param HPZL
	 * @param JGSJ
	 * @param CLSD
	 * @param HPYS
	 * @param CSYS
	 * @param CLLX
	 * @param CDH
	 * @param XS
	 * @param Cltp1
	 * @param Cltp2
	 * @param Cltp3
	 * @param CltpType
	 * @param CJFS
	 * @return
	 */
	public boolean WriteSurveilInfo(String SBBH,String FXBH,String HPHM,String HPZL,String JGSJ,String CLSD,String HPYS,String CSYS,String CLLX,String CDH,String XS,String Cltp1,String Cltp2,String Cltp3,String CltpType,String VideoFile,String VideoType,String CJFS);
	
	public boolean WriteSurveilInfoExt(String SBBH,String FXBH,String HPHM,String HPZL,String JGSJ,String CLSD,String HPYS,String CSYS,String CLLX,String CDH,String XS,String Cltp1,String Cltp2,String Cltp3,String CltpType,String VideoFile,String VideoType,String CJFS,String RedLightTime,String RedLightDuration,String ViolationType);
	
	/**
	 * ����Ƿ�Ϊ���س���
	 * @param jgsj
	 * @param sbbh
	 * @param hphm
	 * @param csys
	 * @param hpzl
	 * @param cllx
	 * @return
	 */
	public Map<String,String> checkAlarmInfo(String jgsj, String sbbh, String hphm, String csys, String hpzl, String cllx);
	
	/**
	 * �ж��Ƿ���ҪΥ���ɼ�
	 * @param sbbh
	 * @return
	 */
	public boolean isNeedWfcj(String sbbh);
	
	/**
	 * д�벼�ر�����Ϣ
	 * @param SBBH
	 * @param FXBH
	 * @param HPHM
	 * @param HPZL
	 * @param JGSJ
	 * @param CLSD
	 * @param HPYS
	 * @param CSYS
	 * @param CLLX
	 * @param TZTP
	 * @param QMTP
	 * @param HPTP
	 * @param CDH
	 * @param XS
	 * @param BKID
	 * @param BK_TYPE_ID
	 * @return
	 */
	public boolean insertBkAlarmVeh(String SBBH,String FXBH,String HPHM,String HPZL,
			String JGSJ,String CLSD,String HPYS,String CSYS,String CLLX,String TZTP,String QMTP,String HPTP,String CDH,String XS,String BKID,String BK_TYPE_ID);
	
	/**
	 * add by pgh
	 * @param wbReco
	 * @return
	 */
	public int insertWbRecord(WbRecord wbReco);
	/**
	 *@��������:isHbc
	 *@��    ��: 
	 *@��    ����
	 *@��    ��: ������
	 *@��������:2013-8-8
	 *@��������: �ж��Ƿ�Ʊ공  
	 */
	public boolean isHbc(String cph);
	
	/**
	 *@��������:isInWfsj
	 *@��    ��: 
	 *@��    ����
	 *@��    ��: ������
	 *@��������:2013-7-22
	 *@��������: �ж�24Сʱ��Υ�������Ƿ���� 
	 */
	public boolean isInWfsj(String hphm);
	/**
	 *@��������:getSysdate
	 *@��    ��: 
	 *@��    ����
	 *@��    ��: ������
	 *@��������:2013-7-26
	 *@��������:  ��ȡϵͳʱ��
	 *
	 */
	public String getSysdate();
	
	/**
	 *@��������:getEpsNameByCode
	 *@��    ��: 
	 *@��    ����
	 *@��    ��: ������
	 *@��������:2013-10-25
	 *@��������:  �����豸��Ż�ȡ�豸��Ϣ
	 */
	public String getDeviceNameByCode(String sbbh);
	
	public String getTgsNameByCode(String sbbh);

	public boolean WriteVehicleInfoWithPhotoTemp(String SBBH,String FXBH,String HPHM,String HPZL,String JGSJ,String CLSD,String HPYS,String CSYS,String CLLX,String TZTPFtpPath,String QMTPFtpPath,String HPTPFtpPath,String CDH,String XS);

	/**
	 * Υ������(�������ڡ��羯)д��ӿ�(��ʱ��)
	 * @param SBBH
	 * @param FXBH
	 * @param HPHM
	 * @param HPZL
	 * @param JGSJ
	 * @param CLSD
	 * @param HPYS
	 * @param CSYS
	 * @param CLLX
	 * @param CDH
	 * @param XS
	 * @param Cltp1
	 * @param Cltp2
	 * @param Cltp3
	 * @param CltpType
	 * @param CJFS
	 * @return
	 */
	public boolean WriteSurveilInfoTemp(String SBBH,String FXBH,String HPHM,String HPZL,String JGSJ,String CLSD,String HPYS,String CSYS,String CLLX,String CDH,String XS,String Cltp1,String Cltp2,String Cltp3,String CltpType,String VideoFile,String VideoType,String CJFS);

	public boolean WriteSurveilInfoExtTemp(String SBBH,String FXBH,String HPHM,String HPZL,String JGSJ,String CLSD,String HPYS,String CSYS,String CLLX,String CDH,String XS,String Cltp1,String Cltp2,String Cltp3,String CltpType,String VideoFile,String VideoType,String CJFS,String RedLightTime,String RedLightDuration,String ViolationType);

	public boolean WriteBMDVehicleInfoWithPhoto(String SBBH,String FXBH,String HPHM,String HPZL,String JGSJ,String CLSD,String HPYS,String CSYS,String CLLX,String TZTPFtpPath,String QMTPFtpPath,String HPTPFtpPath,String CDH,String XS);
	
}
