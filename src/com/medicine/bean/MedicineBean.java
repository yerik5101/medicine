package com.medicine.bean;

import java.io.Serializable;

public class MedicineBean implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String id;						
	private String name;					//ҩƷ����
	private String outward;					//ҩƷ���
	private String suitSymptom;				//��Ӧ֢״
	private String noSuitSymptom;			//����֢
	private String useAndQuantity;			//�÷�����
	private String badSymptom;				//������Ӧ
	private String precautions;				//ע������
	private String mateForbid;				//�������
	private String observation;				//�۲�Ҫ��
	private String pic;						//ͼƬ
	private String category;				//ҩƷ���
	private String subject;					//�����
	private String autoSearchStr;			//����ƥ��
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getOutward() {
		return outward;
	}
	public void setOutward(String outward) {
		this.outward = outward;
	}
	public String getSuitSymptom() {
		return suitSymptom;
	}
	public void setSuitSymptom(String suitSymptom) {
		this.suitSymptom = suitSymptom;
	}
	public String getNoSuitSymptom() {
		return noSuitSymptom;
	}
	public void setNoSuitSymptom(String noSuitSymptom) {
		this.noSuitSymptom = noSuitSymptom;
	}
	public String getUseAndQuantity() {
		return useAndQuantity;
	}
	public void setUseAndQuantity(String useAndQuantity) {
		this.useAndQuantity = useAndQuantity;
	}
	public String getBadSymptom() {
		return badSymptom;
	}
	public void setBadSymptom(String badSymptom) {
		this.badSymptom = badSymptom;
	}
	public String getPrecautions() {
		return precautions;
	}
	public void setPrecautions(String precautions) {
		this.precautions = precautions;
	}
	public String getMateForbid() {
		return mateForbid;
	}
	public void setMateForbid(String mateForbid) {
		this.mateForbid = mateForbid;
	}
	public String getObservation() {
		return observation;
	}
	public void setObservation(String observation) {
		this.observation = observation;
	}
	public String getPic() {
		return pic;
	}
	public void setPic(String pic) {
		this.pic = pic;
	}
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	public String getSubject() {
		return subject;
	}
	public void setSubject(String subject) {
		this.subject = subject;
	}
	public String getAutoSearchStr() {
		return autoSearchStr;
	}
	public void setAutoSearchStr(String autoSearchStr) {
		this.autoSearchStr = autoSearchStr;
	}
	
	public static String getTranslation(String key){
		String trans = "";
		if(key==null||key.equals("")){
			return trans;
		}
		if(key.equals("id")){
			trans = key;
		}else if(key.equals("name")){
			trans = "ҩƷ����";
		}else if(key.equals("outward")){
			trans = "ҩƷ���";
		}else if(key.equals("suitSymptom")){
			trans = "��Ӧ֢״";
		}else if(key.equals("noSuitSymptom")){
			trans = "����֢";
		}else if(key.equals("useAndQuantity")){
			trans = "�÷�����";
		}else if(key.equals("badSymptom")){
			trans = "������Ӧ";
		}else if(key.equals("precautions")){
			trans = "ע������";
		}else if(key.equals("mateForbid")){
			trans = "�������";
		}else if(key.equals("observation")){
			trans = "�۲�Ҫ��";
		}else if(key.equals("pic")){
			trans = "ͼƬ";
		}else if(key.equals("category")){
			trans = "ҩƷ���";
		}else if(key.equals("subject")){
			trans = "�����";
		}
		return trans;
	}
}
