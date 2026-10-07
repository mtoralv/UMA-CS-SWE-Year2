
public class BinarySearch {
	
	public static void main(String[] args) {
		int[] arr = {1, 2, 3, 4, 6, 7, 9, 11, 15, 20};
		System.out.println(BinarySearchRec(7, arr, 0, arr.length-1));
	}
	
	public static boolean BinarySearchRec(int e, int[] arr, int left, int right) {
		if (left > right) {
			return false;
		} else if (left == right) {
			return arr[left] == e;
		} else {
			int mid = (left+right)/2;
			if (arr[mid] == e) {
				return true;
			} else if (arr[mid] > e) {
				return BinarySearchRec(e, arr, left, mid-1);
			} else {
				return BinarySearchRec(e, arr, mid+1, right);
			}
		}
	}

}
