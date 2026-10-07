import java.util.Arrays;

public class MergeSort {

	public static void main(String[] args) {
		int[] arr = {4, 6, 2, 7, 1, 5, 3, 8, 10, 9};
		int[] sorted = MergeSortImp(arr, 0, arr.length-1);
		
		System.out.println(Arrays.toString(sorted));
	}
	
	public static int[] MergeSortImp(int[] arr, int left, int right) {
		if (left == right) {
			return new int[] {arr[left]};
		}
		
		int mid = (left+right)/2;
		
		int[] sortedLeft = MergeSortImp(arr, left, mid);
		int[] sortedRight = MergeSortImp(arr, mid+1, right);
		
		return Merge(sortedLeft, sortedRight);
	}
	
	public static int[] Merge(int[] left, int[] right) {
		int leftPointer = 0;
		int rightPointer = 0;
		int counter = 0;
		int[] merged = new int[left.length+right.length];
		
		while (leftPointer < left.length && rightPointer < right.length) {
			if (left[leftPointer] < right[rightPointer]) {
				merged[counter++] = left[leftPointer++];
			} else {
				merged[counter++] = right[rightPointer++];
			}
		}
		
		for (int i=leftPointer; i<left.length; ++i) {
			merged[counter++] = left[i];
		}
		for (int i=rightPointer; i<right.length; ++i) {
			merged[counter++] = right[i];
		}
		
		return merged;
	}

}
