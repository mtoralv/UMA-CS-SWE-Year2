public class InversionsCounter {
	
	public static void main(String[] args) {
		Integer[] v = {1, 8, 8, 7, -6};
		
		System.out.println(CountInversions(v));
	}
	
	public static int CountInversions(Integer[] v) {
		return countInv(v,0,v.length-1);
	}
	
	private static int countInv(Integer[] a, int left, int right) {
		int finalInversions = 0;
		if (left >= right) {
			finalInversions = 0;
		} else {
			int midIndex = (left+right)/2;
			int invLeft = countInv(a, left, midIndex);
			int invRight = countInv(a, midIndex+1, right);
			finalInversions = invLeft + invRight;
			
			int pointerLeft = left;
			int pointerRight = midIndex+1;
			Integer[] temp = new Integer[right-left+1];
			int count = 0;
			while (pointerLeft <= midIndex && pointerRight <= right) {
				if (a[pointerLeft] < a[pointerRight]) {
					temp[count++] = a[pointerLeft];
					pointerLeft++;
				} else {
					finalInversions += (midIndex - pointerLeft + 1);
					temp[count++] = a[pointerRight];
					pointerRight++;
				}
			}
			while (pointerLeft <= midIndex) {
				temp[count++] = a[pointerLeft++];
			}
			
			while (pointerRight <= right) {
				temp[count++] = a[pointerRight++];
			}
			
			for (int i=left, k=0; k<temp.length; ++i, ++k) {
				a[i] = temp[k];
			}
		}
		
		return finalInversions;
	}
	
}