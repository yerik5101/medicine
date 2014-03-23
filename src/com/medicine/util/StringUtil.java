package com.medicine.util;

public class StringUtil {

	public static boolean isContain(String str1,String str2){
		if(str1==null||str2==null){
			return false;
		}
		if((!str2.trim().equals("")&&str1.contains(str2))||
				(!str1.trim().equals("")&&str2.contains(str1))){
			return true;
		}
		return false;
	}
}
