import java.util.Arrays;

public class QuickSort {

	public static void main(String[] args) {
		int[] arr = {4, 6, 2, 7, 1, 5, 3, 8, 10, 9};
		QuickSortImp(arr, 0, arr.length-1);
		
		System.out.println(Arrays.toString(arr));
	}
	
	public static void QuickSortImp(int[] arr, int left, int right) {
		if (left < right) {
			int pivot = Divide(arr, left, right);
			
			QuickSortImp(arr, left, pivot-1);
			QuickSortImp(arr, pivot+1, right);
		}
	}
	
	public static int Divide(int[] arr, int left, int right) {
		if (left == right) {
			return left;
		}
		
		int pivot = left;
		
		while (left < right) {
			while (left <= right && arr[left] <= arr[pivot]) {
				left++;
			}
			while (left <= right && arr[right] > arr[pivot]) {
				right--;
			}
			if (left < right) {
				swap(arr, left, right);
			}
		}
		
		swap(arr, right, pivot);
		return right;
	}
	
	public static void swap(int[] arr, int i, int j) {
		int tmp = arr[j];
		arr[j] = arr[i];
		arr[i] = tmp;
	}

}
