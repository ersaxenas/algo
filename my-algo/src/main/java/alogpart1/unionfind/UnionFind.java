package alogpart1.unionfind;

import java.util.Random;

public class UnionFind {


	public static void main(String args[]) {
		 int initializer = 10;
         UF2 uf1 = new UF2(initializer);
        
         Random random = new Random();
         int elem1 = 0, elem2 =0;
       /*  for(int cnt = 0; cnt < initializer ; cnt++) {
        	elem1 = random.nextInt(initializer);
        	elem2 = random.nextInt(initializer);
        	if(elem1 != elem2) {
        		uf1.unionElem(elem1, elem2);
        	}
         }
         for(int cnt = 0; cnt < 30 ; cnt++) {
         	elem1 = random.nextInt(initializer);
         	elem2 = random.nextInt(initializer);
         	uf1.isConnected(elem1,elem2);
          } */
         uf1.unionElem(8, 9);
         uf1.unionElem(7, 1);
         uf1.unionElem(3, 7);
         uf1.unionElem(2, 6);
         uf1.unionElem(4, 7);
         uf1.unionElem(1, 5);
         uf1.unionElem(8, 2);
         uf1.unionElem(1, 2);
         uf1.unionElem(5, 0);
         uf1.printArr();
	}

}

class UF1 {

	int idArr[] = null;
	
	public UF1(int size) {
        /*Initialize array.*/
		idArr = new int[size];
		for(int cnt = 0; cnt< idArr.length ; cnt ++) {
			idArr[cnt] = cnt;
		}
	}
	
	public int findRoot(int elem) {
		int root = elem;
		while(idArr[root] != root) {
			root = idArr[root];
		}
		return root;
	}
	
	public void unionElem(int elem1, int elem2) {
		int root1 = findRoot(elem1);
		int root2 = findRoot(elem2);
		if(root1 != root2) {
			idArr[root2] = root1; 
			System.out.println("Connected - " + elem1 +"("+root1+")" + " : " + elem2 + "("+root2+") -->" +  elem1 +"("+root1+")" + " : " + root2 + "("+root1+") " );
		}
		else {
			System.out.println("Elements " + elem1 + "("+root1+")" +" : " + elem2 + "("+root2+")" + " are already Connected" );
		}
		
	}
	
	public boolean isConnected(int elem1, int elem2) {
		if(findRoot(elem1) == findRoot(elem2)) {
			System.out.println("Elements "+ elem1 + ", " + elem2 + " are connected.");
		    return true;
		}
		else {
			System.out.println("Elements "+ elem1 + ", " + elem2 + " are NOT connected.");
			return false;
		}
	}
	
	public void printArr() {
		for(int elem : idArr) {
			System.out.print(elem + " ");	
		}
		
	}
	
}
	
	class UF2 {
        /*Algo with size optimization*/
		int idArr[] = null;
		int idArrSize[] = null;
		
		public UF2(int size) {
	        /*Initialize array.*/
			idArr = new int[size];
			idArrSize = new int[size];
			for(int cnt = 0; cnt< idArr.length ; cnt ++) {
				idArr[cnt] = cnt;
				idArrSize[cnt] = 1;
			}
		}
		
		public int findRoot(int elem) {
			int root = elem;
			while(idArr[root] != root) {
				root = idArr[root];
			}
			return root;
		}
		
		public void unionElem(int elem1, int elem2) {
			int root1 = findRoot(elem1);
			int root1Size = getSize(root1);
			int root2 = findRoot(elem2);
			int root2Size = getSize(root2);
			if(root1 != root2) {
				if(root1Size >= root2Size) {
					idArr[root2] = root1;
					idArrSize[root1] =  idArrSize[root1] + idArrSize[root2];
				}
				else {
					idArr[root1] = root2;
					idArrSize[root2] =  idArrSize[root1] + idArrSize[root2];
				}
				System.out.println("Connected - " + elem1 + "("+root1+"-"+root1Size+") : " + elem2 + "("+root2+"-"+root2Size+") -->" +  elem1 +"("+findRoot(elem1)+"-"+getSize(findRoot(elem1))+") : " + elem2 + "("+findRoot(elem2)+"-"+getSize(findRoot(elem2))+") " );
			}
			else {
				System.out.println("Elements " + elem1 + "("+root1+"-"+root1Size+") : " + elem2 + "("+root2+"-"+root2Size+") are already Connected" );
			}
			
		}
		
		private int getSize(int elem) {
			return idArrSize[elem];
		}
		
		public boolean isConnected(int elem1, int elem2) {
			if(findRoot(elem1) == findRoot(elem2)) {
				System.out.println("Elements "+ elem1 + ", " + elem2 + " are connected.");
			    return true;
			}
			else {
				System.out.println("Elements "+ elem1 + ", " + elem2 + " are NOT connected.");
				return false;
			}
		}
		
		public void printArr() {
			for(int elem : idArr) {
				System.out.print(elem + " ");	
			}
		}
		public void printSizeArr() {
			for(int elem : idArrSize) {
				System.out.print(elem + " ");	
			}
		}

}