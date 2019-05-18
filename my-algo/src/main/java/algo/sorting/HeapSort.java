package algo.sorting;

import java.util.Arrays;

import algo.sorting.utils.SortUtils;

public class HeapSort<T extends Comparable<T>> {
	
	/**
	 * for a k node:
	 * parent is at k/2 node
	 * two child are at 2*k, 2*k+1 nodes
	 */

	public void sink(T[] arr, int k, int N) {
		/*node moving down in the tree*/
		int j = 0;
		while (2 * k <= N) { /* child index should be less then array upper bound */
			j = 2 * k; /* first child will be 2*k and second child will be (2*k)+1 i.e. next to first */
			if (j < N && less(arr,j,j+1)) {/* choose/select bigger of two child nodes (j,j+1), keeping in mind that j is less then upper array bound. */
				j++; /* if second child is bigger then increment the j to point to 2nd child else let it point to first child (2*k) */
			}
			if (less(arr,k,j)) { /* if parent is less then child then exchange parent with child */
				exch(arr, k, j);
			} else { /* since both the child nodes are less then parent then no need to traverse down */
				break; /* stop the loop */
			}
			k = j; /* now take the replaced the child node and compare with its child - sink once again : loop continues with child as new parent */
		}

	}

	public void swim(T[] arr, int k, int N) {
		/*node moving up in the tree*/
		int j = k;
		while (j > 1) { /* check if j is at the root of the node */
			if (less(arr,(j/2),j)) { /* compare parent (j/2) with child j and if parent is less then exchange with child */
				exch(arr, (j/2), j); /* exchange parent with child */
			} else { /* if parent is not less then child so no need to swim up anymore. */
				break; /* break the loop */
			}
			j = j/2; /* move to the parent node, treat it as child and compare with its parent : loop continues */
		}
	}

	public void sort(T[] arr) {
		int N = arr.length;
		/* build a heap out of array */
		for (int k = N / 2; k >= 1; k--) { /* Since it is binary heap start at the mid of the array. */
			sink(arr, k, N);
		}
		System.out.println("heap:" + Arrays.asList(arr));
		/* Sort the array by moving elements from the bottom of tree to top and sinking it to correct place. */
		while (N > 1) {
			/* move bottom element to top and leave bottom untouched. So exchange 1 with N and decrement N by one */
			exch(arr, 1, N);
			sink(arr, 1, --N);
		}
	}

	private boolean less(Comparable[] pq, int i, int j) {
		return pq[i - 1].compareTo(pq[j - 1]) < 0;
	}

	private  void exch(Object[] pq, int i, int j) {
		Object swap = pq[i - 1];
		pq[i - 1] = pq[j - 1];
		pq[j - 1] = swap;
	}

}
