package alogpart1.threesum;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Random;

public class BruteForceAlog {
	
	public void readFile(final String filePath) {
		/*File contains integers.*/
		int intArr[] = null;
		String line = null;
		try {
			BufferedReader bufReader = new BufferedReader(new FileReader(filePath));
			for(int cnt =0; (line = bufReader.readLine()) != null ; cnt++) {
				if(line != null && line.trim() != "") {
					int rdInt = Integer.valueOf(line);
					intArr[cnt] = rdInt;				}
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public int[] genIntArr(final int size, final int range) {
		int intArr[] = new int[size];
		 Random random = new Random();
         for(int cnt = 0; cnt < size ; cnt++) {
        	  intArr[cnt] = random.nextInt(range);
         }
         return intArr;
	}

	public void findThreeSum(final int sum) {
		int intArr[] = genIntArr(1000, 500);
		int arrLen = intArr.length;
		int count =0;
		for(int inx1=0; inx1 < arrLen; inx1++) {
			for(int inx2=inx1 + 1; inx2 < arrLen; inx2++) {
				for(int inx3=inx2 + 1; inx3 < arrLen; inx3++) {
					if((intArr[inx1]+intArr[inx2]+intArr[inx3]) == sum) {
						System.out.println(intArr[inx1]+"+"+intArr[inx2]+"+"+intArr[inx3]+"="+sum);
						count++;
					}
				}
			}
		}
		System.out.println("Total count = " + count);
	}
	

	public static void main(String[] args) {
	   BruteForceAlog obj = new BruteForceAlog();
	   obj.findThreeSum(30);
	}

}
