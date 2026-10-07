public class FindMedian {

	public static void main(String[] args) {
		int[] arr = {5, 6, 4, 2};
		if (arr.length % 2 == 0) {
			int m1 = getMedian(arr.clone(), 0, arr.length-1, arr.length/2-1);
			int m2 = getMedian(arr.clone(), 0, arr.length-1, arr.length/2);
			System.out.println((double)(m1+m2)/2);
		} else {
			System.out.println(getMedian(arr, 0, arr.length-1, arr.length/2));
		}
	}
	
	public static int getMedian(int[] arr, int left, int right, int targetIndex) {
		int pivot = divide(arr, left, right);
		if (pivot == targetIndex) {
			return arr[pivot];
		} else if (pivot > targetIndex) {
			return getMedian(arr, left, pivot-1, targetIndex);
		} else {
			return getMedian(arr, pivot+1, right, targetIndex);
		}
	}
	
	public static int divide(int[] arr, int left, int right) {
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
