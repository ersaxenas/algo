package com.lrn.prc2018.sort;

import com.lrn.prc2018.util.SortUtils;

public class ShellSort<T extends Comparable<T>> {

	SortUtils<T> sortUtils = new SortUtils<>();

	public void sortArray(T[] array) {
		int arrayLenght = array.length;
		int decrementFac = 1;
		while(decrementFac < arrayLenght/3 ) {
			decrementFac = 3*decrementFac + 1;
		}
		System.out.println("Increment factor:"+decrementFac);
		/*iterate over incrementfactor in decresing order of 1/3, last iteration will be 1*/
		while(decrementFac >= 1) {
			//-------------------------------
			        /*insertion sort algo here*/
			       for(int cnt1=decrementFac; cnt1<arrayLenght; cnt1++) {
			    	       for(int cnt2=cnt1; cnt2>=decrementFac; cnt2= cnt2-decrementFac) {
			    	    	      if(sortUtils.isLess(array[cnt2], array[cnt2-decrementFac])) {
			    	    	    	    sortUtils.exch(array, cnt2, cnt2-decrementFac);
			    	    	      } else {
			    	    	    	  break;
			    	    	      }
			    	       }
			       }
			
			//-------------------------------
			       decrementFac = decrementFac/3;
		}
		
		
	}

}
