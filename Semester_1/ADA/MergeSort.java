import java.util.Arrays;

public class MergeSort {

	public static void main(String[] args) {
		int[] arr = {7, 4, 1, 2, 5, 3, 8, 10, 6, 9};
		int[] sorted = MergeSortImp(arr, 0, arr.length-1);
		System.out.println(Arrays.toString(sorted));
	}
	
	public static int[] MergeSortImp(int[] arr, int left, int right) {
		if (right > left) {
			int mid = (left+right)/2;
			int[] sortedLeft = MergeSortImp(arr, left, mid);
			int[] sortedRight = MergeSortImp(arr, mid+1, right);
			
			return Merge(sortedLeft, sortedRight);
		} else {
			return new int[] {arr[left]};
		}
	}
	
	public static int[] Merge(int[] left, int[] right) {
		int[] merged = new int[left.length+right.length];
		
		int leftPointer = 0;
		int rightPointer = 0;
		int counter = 0;
		
		while (leftPointer < left.length && rightPointer < right.length) {
			if (left[leftPointer] < right[rightPointer]) {
				merged[counter++] = left[leftPointer++];
			} else {
				merged[counter++] = right[rightPointer++];
			}
		}
		
		while (leftPointer < left.length) {
			merged[counter++] = left[leftPointer++];
		}
		while (rightPointer < right.length) {
			merged[counter++] = right[rightPointer++];
		}
		
		
		return merged;
	}

}
