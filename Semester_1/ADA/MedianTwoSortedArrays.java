
public class MedianTwoSortedArrays {
	public static void main(String[] args) {
		int[] nums1 = {1,2};
		int[] nums2 = {3,4};
		System.out.println(findMedianSortedArrays(nums1, nums2));
	}
	
	public static double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int leftLen = nums1.length;
        int rightLen = nums2.length;
        int leftPointer = 0;
        int rightPointer = 0;
        int[] merged = new int[leftLen+rightLen];

        while (leftPointer < leftLen && rightPointer < rightLen){
            if (nums1[leftPointer] < nums2[rightPointer]){
                merged[leftPointer+rightPointer] = nums1[leftPointer++];
            } else{
                merged[leftPointer+rightPointer] = nums2[rightPointer++];
            }
        }

        for (int i=leftPointer; i<leftLen; ++i){
            merged[leftPointer+rightPointer] = nums1[leftPointer++];
        }

        for (int i=rightPointer; i<rightLen; ++i){
            merged[leftPointer+rightPointer] = nums2[rightPointer++];
        }
        
        for (int i=0; i<merged.length; ++i) {
        	System.out.println(merged[i]);
        }

        if (merged.length%2 == 0){
            return (double)(merged[merged.length/2-1]+merged[merged.length/2])/2;
        } else{
            return(merged[merged.length/2]);
        }
    }
}
