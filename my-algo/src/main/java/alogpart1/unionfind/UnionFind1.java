package alogpart1.unionfind;

public class UnionFind1 {
	int idArr[] = null;

	public UnionFind1(int size) {
		/* Initialize array. */
		idArr = new int[size];
		for (int cnt = 0; cnt < idArr.length; cnt++) {
			idArr[cnt] = cnt;
		}
	}

	public int findRoot(int elem) {
		int root = elem;
		while (idArr[root] != root) {
			root = idArr[root];
		}
		return root;
	}

	public void unionElem(int elem1, int elem2) {
		int root1 = findRoot(elem1);
		int root2 = findRoot(elem2);
		if (root1 != root2) {
			idArr[root2] = root1;
			System.out.println("Connected - " + elem1 + "(" + root1 + ")" + " : " + elem2 + "(" + root2 + ") -->" + elem1 + "(" + root1 + ")" + " : " + root2 + "(" + root1 + ") ");
		} else {
			System.out.println("Elements " + elem1 + "(" + root1 + ")" + " : " + elem2 + "(" + root2 + ")" + " are already Connected");
		}

	}

	public boolean isConnected(int elem1, int elem2) {
		if (findRoot(elem1) == findRoot(elem2)) {
			System.out.println("Elements " + elem1 + ", " + elem2 + " are connected.");
			return true;
		} else {
			System.out.println("Elements " + elem1 + ", " + elem2 + " are NOT connected.");
			return false;
		}
	}

	public void printArr() {
		for (int elem : idArr) {
			System.out.print(elem + " ");
		}

	}
}
