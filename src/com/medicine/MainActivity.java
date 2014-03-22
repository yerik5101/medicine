package com.medicine;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ListView;

import com.medicine.bean.MedicineBean;
import com.medicine.util.JsonUtil;

public class MainActivity extends Activity {

	private ListView list_view;
	private List<MedicineBean> list;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		initView();
		initData();
	}
	
	private void initView(){
		list_view = (ListView)findViewById(R.id.list_view);
	}
	
	private void initData(){
		list = new ArrayList<MedicineBean>();
		String data1 = getString(R.string.data1);
		MedicineBean mb1 = JsonUtil.parseJson(data1, MedicineBean.class);
		String data2 = getString(R.string.data2);
		MedicineBean mb2 = JsonUtil.parseJson(data2, MedicineBean.class);
		String data3 = getString(R.string.data3);
		MedicineBean mb3 = JsonUtil.parseJson(data3, MedicineBean.class);
		String data4 = getString(R.string.data4);
		MedicineBean mb4 = JsonUtil.parseJson(data4, MedicineBean.class);
		String data5 = getString(R.string.data5);
		MedicineBean mb5 = JsonUtil.parseJson(data5, MedicineBean.class);
		String data6 = getString(R.string.data6);
		MedicineBean mb6 = JsonUtil.parseJson(data6, MedicineBean.class);
		String data7 = getString(R.string.data7);
		MedicineBean mb7 = JsonUtil.parseJson(data7, MedicineBean.class);
		String data8 = getString(R.string.data8);
		MedicineBean mb8 = JsonUtil.parseJson(data8, MedicineBean.class);
		list.add(mb1);
		list.add(mb2);
		list.add(mb3);
		list.add(mb4);
		list.add(mb5);
		list.add(mb6);
		list.add(mb7);
		list.add(mb8);
		fillData();
	}
	
	private void fillData(){
		MedicineAdapter ma = new MedicineAdapter(this,list);
		list_view.setAdapter(ma);
		list_view.setOnItemClickListener(new OnItemClickListener(){

			@Override
			public void onItemClick(AdapterView<?> parent, View view,
					int position, long id) {
				if(list!=null&&list.size()>position){
					MedicineBean bean = list.get(position);
					Intent intent = new Intent(MainActivity.this,MedicineDetailActivity.class);
					Bundle bundle = new Bundle();
					bundle.putSerializable("bean", (Serializable) bean);
					bundle.putInt("position", position);
					intent.putExtra("bundle", bundle);
					startActivity(intent);
				}
			}
			
		});
	}
}
