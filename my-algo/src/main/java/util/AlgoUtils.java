package util;

import java.util.Random;

public class AlgoUtils {
	
	public static Integer[] getIntArray(int size) {
		Integer[] arr = new Integer[size];
		Random random = new Random();
		for(int cnt=0; cnt<arr.length; cnt++) {
			arr[cnt] = random.nextInt(size);
		}
		return arr;
	}
	
	public static String[] stringSuffix(String str) {
		int strLen = str.length();
		String arr[] = new String[strLen];
		for(int cnt=0; cnt<strLen; cnt++) {
			arr[cnt] = str.substring(cnt, strLen);
		}
		return arr;
	}
	
	public static int longestCommonPrefix(String str1, String str2) {
		int strLen = Math.min(str1.length(), str2.length());
		int prefixEnd = strLen;
		for(int cnt=0; cnt<strLen; cnt++) {
			if(str1.charAt(cnt) != str2.charAt(cnt)) {
				prefixEnd = cnt;
				break;
			}
		}
		return prefixEnd;
	}
	
}
