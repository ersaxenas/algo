package alogpart1.unionfind;

public class UnionFind2 {
	 /*Algo with size optimization*/
	int idArr[] = null;
	int idArrSize[] = null;
	
	public UnionFind2(int size) {
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
