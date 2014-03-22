package com.medicine.bean;

import java.io.Serializable;

public class MedicineBean implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String id;						
	private String name;					//药品名称
	private String outward;					//药品外观
	private String suitSymptom;				//适应症状
	private String noSuitSymptom;			//禁忌症
	private String useAndQuantity;			//用法用量
	private String badSymptom;				//不良反应
	private String precautions;				//注意事项
	private String mateForbid;				//配伍禁忌
	private String observation;				//观察要点
	private String pic;						//图片
	private String category;				//药品类别
	private String subject;					//子类别
	private String autoSearchStr;			//搜索匹配
	
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
			trans = "药品名称";
		}else if(key.equals("outward")){
			trans = "药品外观";
		}else if(key.equals("suitSymptom")){
			trans = "适应症状";
		}else if(key.equals("noSuitSymptom")){
			trans = "禁忌症";
		}else if(key.equals("useAndQuantity")){
			trans = "用法用量";
		}else if(key.equals("badSymptom")){
			trans = "不良反应";
		}else if(key.equals("precautions")){
			trans = "注意事项";
		}else if(key.equals("mateForbid")){
			trans = "配伍禁忌";
		}else if(key.equals("observation")){
			trans = "观察要点";
		}else if(key.equals("pic")){
			trans = "图片";
		}else if(key.equals("category")){
			trans = "药品类别";
		}else if(key.equals("subject")){
			trans = "子类别";
		}
		return trans;
	}
}
