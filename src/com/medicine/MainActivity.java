package com.medicine;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import android.app.Activity;
import android.app.Dialog;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.view.KeyEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.inputmethod.InputMethodManager;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ListView;

import com.medicine.bean.MedicineBean;
import com.medicine.dialog.DialogUtil;
import com.medicine.util.JsonUtil;
import com.medicine.util.StringUtil;

public class MainActivity extends Activity {
	private static final int FILL_DATA = 0x0001;
	private ListView list_view;
	private List<MedicineBean> list,searchList;
	private SearchText search_text;
	private MedicineAdapter medicineAdapter;
	private View conver_nodata;
	private Dialog dialog;
	
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
		dialog = DialogUtil.createLoadingDialog(this, "正在加载数据...");
		dialog.show();
		new Thread(){
			@Override
			public void run(){
				initListData();
			}
		}.start();
	}
	
	Handler myHandler = new Handler(){
		
		@Override
		public void handleMessage(Message msg){
			if(msg!=null&&msg.what==FILL_DATA){
				fillData();
			}
		}
	};
	
	private void initListData(){
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
		String data9 = getString(R.string.data9);
		MedicineBean mb9 = JsonUtil.parseJson(data9, MedicineBean.class);
		System.out.println("json parse 9");
		String data10 = getString(R.string.data10);
		MedicineBean mb10 = JsonUtil.parseJson(data10, MedicineBean.class);
		System.out.println("json parse 10");
		String data11 = getString(R.string.data11);
		MedicineBean mb11 = JsonUtil.parseJson(data11, MedicineBean.class);
		System.out.println("json parse 11");
		String data12 = getString(R.string.data12);
		MedicineBean mb12 = JsonUtil.parseJson(data12, MedicineBean.class);
		System.out.println("json parse 12");
		String data13 = getString(R.string.data13);
		MedicineBean mb13 = JsonUtil.parseJson(data13, MedicineBean.class);
		System.out.println("json parse 13");
		String data14 = getString(R.string.data14);
		MedicineBean mb14 = JsonUtil.parseJson(data14, MedicineBean.class);
		System.out.println("json parse 14");
		String data15 = getString(R.string.data15);
		MedicineBean mb15 = JsonUtil.parseJson(data14, MedicineBean.class);
		String data16 = getString(R.string.data15);
		MedicineBean mb16 = JsonUtil.parseJson(data16, MedicineBean.class);
		String data17 = getString(R.string.data17);
		MedicineBean mb17 = JsonUtil.parseJson(data17, MedicineBean.class);
		String data18 = getString(R.string.data18);
		MedicineBean mb18 = JsonUtil.parseJson(data18, MedicineBean.class);
		String data19 = getString(R.string.data19);
		MedicineBean mb19 = JsonUtil.parseJson(data19, MedicineBean.class);
		String data20 = getString(R.string.data20);
		MedicineBean mb20 = JsonUtil.parseJson(data20, MedicineBean.class);
		String data21 = getString(R.string.data21);
		MedicineBean mb21 = JsonUtil.parseJson(data21, MedicineBean.class);
		String data22 = getString(R.string.data22);
		MedicineBean mb22 = JsonUtil.parseJson(data22, MedicineBean.class);
		String data23 = getString(R.string.data23);
		MedicineBean mb23 = JsonUtil.parseJson(data23, MedicineBean.class);
		String data24 = getString(R.string.data24);
		MedicineBean mb24 = JsonUtil.parseJson(data24, MedicineBean.class);
		String data25 = getString(R.string.data25);
		MedicineBean mb25 = JsonUtil.parseJson(data25, MedicineBean.class);
		String data26 = getString(R.string.data26);
		MedicineBean mb26 = JsonUtil.parseJson(data26, MedicineBean.class);
		String data27 = getString(R.string.data27);
		MedicineBean mb27 = JsonUtil.parseJson(data27, MedicineBean.class);
		String data28 = getString(R.string.data28);
		MedicineBean mb28 = JsonUtil.parseJson(data28, MedicineBean.class);
		String data29 = getString(R.string.data29);
		MedicineBean mb29 = JsonUtil.parseJson(data29, MedicineBean.class);
		String data30 = getString(R.string.data30);
		MedicineBean mb30 = JsonUtil.parseJson(data30, MedicineBean.class);
		list.add(mb1);
		list.add(mb2);
		list.add(mb3);
		list.add(mb4);
		list.add(mb5);
		list.add(mb6);
		list.add(mb7);
		list.add(mb8);
		list.add(mb9);
		list.add(mb10);
		list.add(mb11);
		list.add(mb12);
		list.add(mb13);
		list.add(mb14);
		list.add(mb15);
		list.add(mb16);
		list.add(mb17);
		list.add(mb18);
		list.add(mb19);
		list.add(mb20);
		list.add(mb21);
		list.add(mb22);
		list.add(mb23);
		list.add(mb24);
		list.add(mb25);
		list.add(mb26);
		list.add(mb27);
		list.add(mb28);
		list.add(mb29);
		list.add(mb30);
		
		
		sendFillDataMessage();
	}
	
	private void sendFillDataMessage(){
		Message msg = new Message();
		msg.what = FILL_DATA;
		myHandler.sendMessage(msg);
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
		if(dialog!=null){
			dialog.dismiss();
		}
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
		hideSoftInput();
	}
	
	private void hideSoftInput(){
		search_text.getEt_searchtext_search().clearFocus();
		InputMethodManager imm = (InputMethodManager) getSystemService(INPUT_METHOD_SERVICE);   
		imm.hideSoftInputFromWindow(search_text.getEt_searchtext_search().getWindowToken(), 0);
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
