/* SUPCON Confidential */
package its.webservice.entity;

import java.util.List;

// *****************************************************************************
//�û���      ����
//ϵͳ��      ���ܽ�ͨ����ƽ̨
//��ϵͳ��    ϵͳ����
//����       ��B_CODE_TYPE
/**
* 
* 
* @author Xiangliang Kong Created on 2011-09-23
* 
*/


// *****************************************************************************

public class InsertConnectionedBean {

	    private String device_code;        //������
		private String connected;   //����״̬  0-���� 1-�Ͽ�
	    private  String  deviceNameType;  //�豸��������
	    private  String  cj_time;            //�ɼ�ʱ��  lvhua2012-0-05
	    private  String  check_source;  // �����Դ
	    private  String  device_name;  // �豸���� 
	    public String getDevice_name() {
			return device_name;
		}

		public void setDevice_name(String device_name) {
			this.device_name = device_name;
		}

		public String getCheck_source() {
			return check_source;
		}

		public void setCheck_source(String check_source) {
			this.check_source = check_source;
		}

		public String getDevice_code() {
			return device_code;
		}

		public void setDevice_code(String device_code) {
			this.device_code = device_code;
		}

		public String getCj_time() {
			return cj_time;
		}

		public void setCj_time(String cj_time) {
			this.cj_time = cj_time;
		}

		public String getDeviceNameType() {
			return deviceNameType;
		}

		public void setDeviceNameType(String deviceNameType) {
			this.deviceNameType = deviceNameType;
		}


	   public String getConnected() {
				return connected;
			}

	  public void setConnected(String connected) {
				this.connected = connected;
	  }

	 
    
}