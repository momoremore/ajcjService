package its.webservice.entity;


/**
 * ϵͳ���ƣ�����ƽ̨(JCPT)
 * ����ģ�飺���ֳ�Υ�����ݴ���
 * ����������CCTV�豸bean
 * �ļ�����com.supcon.supconit.its.business.jcj.entity.CctvInfoBean.java
 * �汾��Ϣ��1.00
 * 
 * �������ţ��з�����
 * �����ߣ� ������
 * ����ʱ�䣺2011-08-15
 */
public class EpsInfoBean{
	
	//�豸ID
	private String device_id;
	//�豸Code
	private String device_code;
	//�豸����
	private String device_name;
	//Υ����·���
	private String road_name;
	//Υ��·�α��
	private String cross_id;
	
	

	public String getDevice_id() {
		return device_id;
	}

	public void setDevice_id(String deviceId) {
		device_id = deviceId;
	}

	public String getDevice_code() {
		return device_code;
	}

	public void setDevice_code(String deviceCode) {
		device_code = deviceCode;
	}

	public String getDevice_name() {
		return device_name;
	}

	public void setDevice_name(String deviceName) {
		device_name = deviceName;
	}


	public String getRoad_name() {
		return road_name;
	}

	public void setRoad_name(String roadName) {
		road_name = roadName;
	}

	public String getCross_id() {
		return cross_id;
	}

	public void setCross_id(String crossId) {
		cross_id = crossId;
	}


}
