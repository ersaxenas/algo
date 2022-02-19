package algo.sorting.comaprables;

public class Date implements Comparable<Date>{

	private int year, month, day;
	
	public Date(int year, int month, int day) {
		this.year = year;
		this.month = month;
		this.day = day;
	}
	public int compareTo(Date oDate) {
		int result = 0;
		if(year < oDate.year){result = -1;}
		else if(year > oDate.year) {result = 1;}
		else if(month < oDate.month) {result = -1;}
		else if(month > oDate.month) {result = 1;}
		else if(day < oDate.day) {result = -1;}
		else if(day > oDate.day) {result = 1;}
		return result;
	}
}
