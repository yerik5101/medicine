package com.medicine;

import java.util.List;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.medicine.bean.MedicineBean;
import com.medicine.util.Utils;

public class MedicineAdapter extends BaseAdapter{
	
	private Context context;
	private List<MedicineBean> list;
	
	public MedicineAdapter(Context context,List<MedicineBean> list){
		this.context = context;
		this.list = list;
	}
	
	@Override
	public int getCount() {
		// TODO Auto-generated method stub
		if(list!=null){
			return list.size();
		}
		return 0;
	}

	@Override
	public Object getItem(int position) {
		// TODO Auto-generated method stub
		return position;
	}

	@Override
	public long getItemId(int position) {
		// TODO Auto-generated method stub
		return position;
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		// TODO Auto-generated method stub
		ViewHolder holder;
		if(convertView==null){
			LayoutInflater inflater = LayoutInflater.from(context);
			convertView = inflater.inflate(R.layout.medicine_list,null);
            holder = new ViewHolder();
            holder.medicine_name = (TextView) convertView.findViewById(R.id.medicine_name);
            holder.medicine_suit_symptom = (TextView) convertView.findViewById(R.id.medicine_suit_symptom);
            holder.medicine_pic = (ImageView) convertView.findViewById(R.id.medicine_pic);
            convertView.setTag(holder);
		}else{
			holder = (ViewHolder) convertView.getTag();
		}
		MedicineBean mb = list.get(position);
		System.out.println("holder is:"+holder+"  mb is:"+mb+" postion is:"+position);
		holder.medicine_name.getPaint().setFakeBoldText(true);
		holder.medicine_name.setText(mb.getName());
		holder.medicine_suit_symptom.setText(mb.getSuitSymptom());
		int picId = Utils.getResource(context, "pic_"+(position+1));
		holder.medicine_pic.setImageResource(picId);
		return convertView;
	}
	
	static class ViewHolder {
        TextView medicine_name;
        ImageView medicine_pic;
        TextView medicine_suit_symptom;
    }
	
}
