package its.webservice.entity;

import java.util.Date;
/**
 * @�� �� ����WbDevice.java
 * @�������ڣ�2013-6-14
 * @��    Ȩ��Copyrigth(c)2010
 * @��˾���ƣ��㽭����п���Ϣ�������޹�˾
 * @������Ա��������
 * @��    ��: 
 * @��    ����΢������
 */
public class WbRecord {
	/** ���к� */
	private String id;
	/** ΢�������� */
	private String wbjc_code;
	/** ������*/
	private String cdh;
	/** ƽ������ */
	private Integer speed_aver;
	/** ����ƽ������ */
	private Integer speed_lon_veh;
	/** �г�ƽ������ */
	private Integer speed_mid_veh;
	/** �̳�ƽ������ */
	private Integer speed_sht_veh;
	/** ��λʱ�䳵���� */
	private Integer volume_veh;
	/** ��λʱ�䳤������ */
	private Integer volume_lon_veh;
	/** ��λʱ���г����� */
	private Integer volume_mid_veh;
	/** ��λʱ��̳����� */
	private Integer volume_sht_veh;
	/** ��ռ���� */
	private Integer occupy_veh;
	/** ����ռ���� */
	private Integer occupy_lon_veh;
	/** �г�ռ���� */
	private Integer occupy_mid_veh;
	/** �̳�ռ���� */
	private Integer occupy_sht_veh;
	/** ��ͷʱ�� */
	private Integer headway_time;
	/** �ɼ�ʱ�� */
	private String gather_time;
	/** �ϴ�ʱ�� */
	private String upload_time;
	
	
	public WbRecord(String id){
		this.id = id;
	}
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getWbjc_code() {
		return wbjc_code;
	}
	public void setWbjc_code(String wbjc_code) {
		this.wbjc_code = wbjc_code;
	}
	public String getCdh() {
		return cdh;
	}
	public void setCdh(String cdh) {
		this.cdh = cdh;
	}
	public Integer getSpeed_aver() {
		return speed_aver;
	}
	public void setSpeed_aver(Integer speed_aver) {
		this.speed_aver = speed_aver;
	}
	public Integer getSpeed_lon_veh() {
		return speed_lon_veh;
	}
	public void setSpeed_lon_veh(Integer speed_lon_veh) {
		this.speed_lon_veh = speed_lon_veh;
	}
	public Integer getSpeed_mid_veh() {
		return speed_mid_veh;
	}
	public void setSpeed_mid_veh(Integer speed_mid_veh) {
		this.speed_mid_veh = speed_mid_veh;
	}
	public Integer getSpeed_sht_veh() {
		return speed_sht_veh;
	}
	public void setSpeed_sht_veh(Integer speed_sht_veh) {
		this.speed_sht_veh = speed_sht_veh;
	}
	public Integer getVolume_veh() {
		return volume_veh;
	}
	public void setVolume_veh(Integer volume_veh) {
		this.volume_veh = volume_veh;
	}
	public Integer getVolume_lon_veh() {
		return volume_lon_veh;
	}
	public void setVolume_lon_veh(Integer volume_lon_veh) {
		this.volume_lon_veh = volume_lon_veh;
	}
	public Integer getVolume_mid_veh() {
		return volume_mid_veh;
	}
	public void setVolume_mid_veh(Integer volume_mid_veh) {
		this.volume_mid_veh = volume_mid_veh;
	}
	public Integer getVolume_sht_veh() {
		return volume_sht_veh;
	}
	public void setVolume_sht_veh(Integer volume_sht_veh) {
		this.volume_sht_veh = volume_sht_veh;
	}
	public Integer getOccupy_veh() {
		return occupy_veh;
	}
	public void setOccupy_veh(Integer occupy_veh) {
		this.occupy_veh = occupy_veh;
	}
	public Integer getOccupy_lon_veh() {
		return occupy_lon_veh;
	}
	public void setOccupy_lon_veh(Integer occupy_lon_veh) {
		this.occupy_lon_veh = occupy_lon_veh;
	}
	public Integer getOccupy_mid_veh() {
		return occupy_mid_veh;
	}
	public void setOccupy_mid_veh(Integer occupy_mid_veh) {
		this.occupy_mid_veh = occupy_mid_veh;
	}
	public Integer getOccupy_sht_veh() {
		return occupy_sht_veh;
	}
	public void setOccupy_sht_veh(Integer occupy_sht_veh) {
		this.occupy_sht_veh = occupy_sht_veh;
	}
	public Integer getHeadway_time() {
		return headway_time;
	}
	public void setHeadway_time(Integer headway_time) {
		this.headway_time = headway_time;
	}
	public String getGather_time() {
		return gather_time;
	}
	public void setGather_time(String gather_time) {
		this.gather_time = gather_time;
	}
	public String getUpload_time() {
		return upload_time;
	}
	public void setUpload_time(String upload_time) {
		this.upload_time = upload_time;
	}
	
	
	
}
