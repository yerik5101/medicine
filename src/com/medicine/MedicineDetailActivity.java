package com.medicine;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.actionbarsherlock.app.ActionBar;
import com.actionbarsherlock.view.MenuItem;
import com.medicine.bean.MedicineBean;

public class MedicineDetailActivity extends BaseActivity{

	private MedicineBean medicine;
	private TextView detail_medicine_name;
	private LinearLayout detail_content;
	
	@Override
	public void onCreate(Bundle b){
		super.onCreate(b);
		setContentView(R.layout.medicine_detail);
		ActionBar actionBar = super.getSupportActionBar();
		actionBar.setDisplayHomeAsUpEnabled(true);
		initParams();
		initView();
	}
	
	private void initParams(){
		Bundle bundle = getIntent().getBundleExtra("bundle");
		medicine = (MedicineBean) bundle.getSerializable("bean");
	}
	
	private void initView(){
		initTop();
		initContent();
	}
	
	private void initTop(){
		detail_medicine_name = (TextView)findViewById(R.id.detail_medicine_name);
		detail_medicine_name.setText(medicine.getName());
	}
	
	private void initContent(){
		detail_content = (LinearLayout)findViewById(R.id.detail_content);
		Class clzss = medicine.getClass();
		Field[] fields = clzss.getDeclaredFields();
		System.out.println("fields length is:"+fields.length);
		for(int i=0;i<fields.length;i++){
			Field field = fields[i];
			String name = field.getName();
			System.out.println("name is:"+name);
			if(name.equals("name")||
					name.equals("pic")||
					name.equals("category")||
					name.equals("subject")||
					name.equals("autoSearchStr")||
					name.equals("id")||
					name.equals("serialVersionUID")){
				continue;
			}
			String key = MedicineBean.getTranslation(name);
			String value = "";
			Method method = getGetMethod(clzss,name);
			try {
				value = method.invoke(medicine).toString();
			} catch (IllegalArgumentException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IllegalAccessException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (InvocationTargetException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			if(value==null||value.trim().equals("")){
				continue;
			}
			System.out.println("key is:"+key+"   value is:"+value);
			View view = getItemView(key,value);
			detail_content.addView(view);
		}
	}
	
	private View getItemView(String key,String value){
		View view = this.getLayoutInflater().inflate(R.layout.medicine_detail_item, null);
		TextView detail_item_key = (TextView)view.findViewById(R.id.detail_item_key);
		TextView detail_item_value = (TextView)view.findViewById(R.id.detail_item_value);
		key = "¡¾"+key+"¡¿";
		detail_item_key.setText(key);
		detail_item_value.setText(value);
		return view;
	}
	
	public static Method getGetMethod(Class<MedicineBean> objectClass, String fieldName) {       
	    StringBuffer sb = new StringBuffer();       
	    sb.append("get");       
	    sb.append(fieldName.substring(0, 1).toUpperCase());       
	    sb.append(fieldName.substring(1));       
	    try {       
	        return objectClass.getMethod(sb.toString());       
	    } catch (Exception e) {       
	    	e.printStackTrace();
	    }       
	    return null;       
	}       
	
	@Override
    public boolean onOptionsItemSelected(MenuItem item){
		System.out.println("item id is:"+item.getItemId());
		if(item.getItemId() == android.R.id.home){
            finish();
            return true;
        }
		return super.onOptionsItemSelected(item);
	}
}
