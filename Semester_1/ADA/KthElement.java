public class KthElement {
	
	public static void main(String[] args) {
		Integer[] v = {1, 5, 6, 2, 4, 7, 0, 3, -1};
		
		System.out.println(FindKth(v, 3));
	}

	public static int FindKth(Integer[] v, int k) {
		return findKth(v, k, 0, v.length - 1);
	}

	private static int findKth(Integer[] v, int k, int left, int right) {
		mergeSort(v, left, right);
		
		return v[k];
	}
	
	private static void mergeSort(Integer[] v, int left, int right) {
		if (left == right) {return;}
		if (right == left + 1) {
			if (v[left] > v[right]) {
				int tmp = v[right];
				v[right] = v[left];
				v[left] = tmp;
			}
		} else {		
			int halfSize = (right-left)/2;
			System.out.println("(" + left + ", " + (left+halfSize) + ")");
			System.out.println("(" + (left+halfSize+1) + ", " + right + ")");
			mergeSort(v, left, left+halfSize);
			mergeSort(v, left+halfSize+1, right);
			
			int leftPointer = left;
			int rightPointer = left+halfSize+1;
			
			Integer[] result = new Integer[right-left+1];
			int count = 0;
			
			while (leftPointer <= left+halfSize && rightPointer <= right) {
				if (v[leftPointer] < v[rightPointer]) {
					result[count++] = v[leftPointer];
					leftPointer++;
				} else {
					result[count++] = v[rightPointer];
					rightPointer++;
				}
			}

			for (int i=leftPointer; i<=left+halfSize; ++i) {
				result[count++] = v[i];
			}
			for (int i=rightPointer; i<=right; ++i) {
				result[count++] = v[i];
			}
			
			for (int i=0; i<result.length; ++i) {
				System.out.println(result[i]);
			}
			for (int i=0; i<right-left+1; ++i) {
				v[left+i] = result[i];
			}
		}
	}
}