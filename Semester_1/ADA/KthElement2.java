
public class Solution {
	
	public static void main(String[] args) {
		int[] v = {3, 2, 1, 5, 6, 4};
		
		System.out.println(findKthLargest(v, 2));
	}
	
	public static int findKthLargest(int[] nums, int k) {
        int[] sorted = mergeSort(nums, 0, nums.length-1);
        
        for (int i=0; i<sorted.length; ++i) {
        	System.out.println(sorted[i]);
        }
        
        return sorted[sorted.length-k];
    }

    public static int[] mergeSort(int[] nums, int left, int right){
        if (left == right){
            int[] element = {nums[left]};
            return element;
        }

        int midIndex = (left+right)/2;

        int[] sortedLeft = mergeSort(nums, left, midIndex);
        int[] sortedRight = mergeSort(nums, midIndex+1, right);
        return merge(sortedLeft, sortedRight);
    }

    public static int[] merge(int[] left, int[] right){
        int leftPointer = 0;
        int rightPointer = 0;
        int leftLen = left.length;
        int rightLen = right.length;
        int[] merged = new int[leftLen+rightLen];
        int count = 0;

        while (leftPointer < leftLen && rightPointer < rightLen){
            if (left[leftPointer] < right[rightPointer]){
                merged[count++] = left[leftPointer++];
            } else{
                merged[count++] = right[rightPointer++];
            }
        }

        for (int i=leftPointer; i<leftLen; ++i){
            merged[count++] = left[i];
        }
        for (int i=rightPointer; i<rightLen; ++i){
            merged[count++] = right[i];
        }

        return merged;
    }

}
