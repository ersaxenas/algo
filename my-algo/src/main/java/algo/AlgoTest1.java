package algo;

public class AlgoTest1 {

	public void strUniqueChars() {
		/*find if all the chars are unique in the string.*/
		String tststr = "qpwoeirutymvnjslhd";
		boolean arr[] = new boolean[256];
		for(int cnt =0; cnt< tststr.length(); cnt++) {
			if(arr[((int)tststr.charAt(cnt))]) {
				System.out.println("Duplicate found:"+tststr.charAt(cnt));
				return;
			}
			else {
				arr[((int)tststr.charAt(cnt))] = true;
			}
		}
		System.out.println("Duplicate not found");
	}
	
	public void reverseStr() {
		/*reverse the string*/
		String tststr = "abcdefgh";
		int lnth = tststr.length();
		for(int cnt=0; cnt<lnth; cnt++) {
			System.out.println(":"+tststr.substring(lnth -cnt -1 , lnth - cnt));
		}
	}
	
	
	public void removeDuplicatesFromString() {
		char tststr[] = "abb".toCharArray();
		int lstindex = 1;
		int loop1, loop2;
		
		for(loop1 = 1; loop1 < tststr.length; loop1++) {
			for(loop2=0; loop2 <= lstindex; loop2++ ) {
				if(tststr[loop1] == tststr[loop2]) {
					//match found
					break;
				}
			}
			if(loop2 == lstindex) {
				tststr[lstindex] = tststr[loop1];
				lstindex++;
			}
			
		}
		tststr[lstindex] = '0';
		
		System.out.println(tststr);
	}
	
	public void twoStringsAreAnagrams() {
		String str1="abcc", str2="cbad";
		if(str1.length() != str2.length()) {
			System.out.println("NOT anagrams");
		}
		int uniquechar =0;
		int letters[] = new int[256];
		char[] chararr = str1.toCharArray();
		for(int c: chararr) {
			if(letters[c] == 0) {
				uniquechar++;
			}
			letters[c]++;
		}
		System.out.println(letters);
		for(int c: str2.toCharArray()) {
			if(letters[c] == 0) {
				System.out.println("NOT anagrams");
				return;
			}
			letters[c]--;
			if(letters[c] == 0) {
				uniquechar--;
			}
			if(uniquechar < 0) {
				System.out.println("NOT anagrams");
				return;
			}
		}
		System.out.println("String are Anagrams");
		
	}
	
	public void replaceSpace() {
		char[] carr = "ad kd sd de".toCharArray();
		int noOfSpaces = 0;
		for(int loop1=0; loop1<carr.length; loop1++) {
			if(carr[loop1] == ' ') {
				noOfSpaces++;
			}
		}
		
		int chglen = carr.length + noOfSpaces*2;
		carr[chglen] = '\0';
		
		for(int loop2=carr.length-1; loop2>=0; loop2--) {
			if(carr[loop2] == ' '){
				chglen = chglen -1;
				carr[chglen] = '0';
				chglen = chglen -1;
				carr[chglen] = '2';
				chglen = chglen -1;
				carr[chglen] = '%';
			}
			else {
				chglen = chglen -1;
				carr[chglen] = carr[loop2]; 
			}
		}
		System.out.println(carr);
	}
	
	
	
	
	
	public static void main(String args[]) {
		AlgoTest1 obj = new AlgoTest1();
		obj.replaceSpace();
	}
}
