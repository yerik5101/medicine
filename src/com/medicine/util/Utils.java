package com.medicine.util;

import android.content.Context;

public class Utils {

	public static int  getResource(Context context,String imageName){  
		int resId = context.getResources().getIdentifier(imageName, "drawable" , context.getPackageName());  
		return resId;
	}
}
