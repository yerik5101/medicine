package com.medicine;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.inputmethod.InputMethodManager;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ListView;

import com.medicine.bean.MedicineBean;
import com.medicine.util.JsonUtil;
import com.medicine.util.StringUtil;

public class MainActivity extends Activity {

	private ListView list_view;
	private List<MedicineBean> list,searchList;
	private SearchText search_text;
	private MedicineAdapter medicineAdapter;
	private View conver_nodata;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		initView();
		initData();
	}
	
	private void initView(){
		list_view = (ListView)findViewById(R.id.list_view);
		search_text = (SearchText)findViewById(R.id.search_text);
		search_text.getIb_searchtext_delete().setOnClickListener(new OnClickListener(){
			@Override
			public void onClick(View v) {
				cannelSearch();
			}
		});
		conver_nodata = findViewById(R.id.conver_nodata);
		search_text.setCallback(new WaterChangedCallback(){
			@Override
			public void changedCallback(String str) {
				if(medicineAdapter==null){
					return;
				}
				if(str==null||str.trim().equals("")){
					if(medicineAdapter.getList()!=null&&list!=null&&
							medicineAdapter.getList().size()!=list.size()){
						medicineAdapter.setList(list);
						medicineAdapter.notifyDataSetChanged();
					}
					conver_nodata.setVisibility(View.GONE);
					return;
				}
				searchList = filterList(str);
				if(searchList!=null&&searchList.size()>0){
					conver_nodata.setVisibility(View.GONE);
					medicineAdapter.setList(searchList);
					medicineAdapter.notifyDataSetChanged();
				}else{
					conver_nodata.setVisibility(View.VISIBLE);
				}
			}
		});
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
		medicineAdapter = new MedicineAdapter(this,list);
		list_view.setAdapter(medicineAdapter);
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
	
	public interface WaterChangedCallback{
		void changedCallback(String str);
	}
	
	private List<MedicineBean> filterList(String searchText){
		List<MedicineBean> searchList = new ArrayList<MedicineBean>();
		if(searchText==null||searchText.trim().equals("")){
			return null;
		}
		searchText = searchText.trim();
		if(list!=null){
			for(int i=0;i<list.size();i++){
				MedicineBean mb = list.get(i);
				String name = mb.getName();
				String autoSearchText = mb.getAutoSearchStr();
				if(StringUtil.isContain(name, searchText)||
						StringUtil.isContain(autoSearchText, searchText)){
					searchList.add(mb);
				}
			}
		}
		return searchList;
	}
	
	private void cannelSearch(){
		search_text.getEt_searchtext_search().setText("");
		InputMethodManager imm = (InputMethodManager) getSystemService(INPUT_METHOD_SERVICE);   
		imm.toggleSoftInput(0, InputMethodManager.HIDE_NOT_ALWAYS);
	}
	
	@Override  
    public boolean onKeyDown(int keyCode, KeyEvent event) {  
        if (keyCode == KeyEvent.KEYCODE_BACK) {  
             if(search_text!=null&&search_text.getIb_searchtext_delete().getVisibility()==View.VISIBLE){
            	 cannelSearch();
            	 return true;
             }
            return super.onKeyDown(keyCode, event);
        } else  
            return super.onKeyDown(keyCode, event);  
    }
}
