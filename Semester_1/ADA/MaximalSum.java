
public class MaximalSum {

	public static void main(String[] args) {
		Integer[] v = {1, -5, 4, -2, 6, -7, 3};
		System.out.println(maximalSum(v, 0, v.length-1));
	}
	
	public static int maximalSum(Integer[] v, int left, int right) {
		if (left == right) {
			return v[left];
		}
		
		int midIndex = (left+right)/2;
		int leftMax = maximalSum(v, left, midIndex);
		int rightMax = maximalSum(v, midIndex+1, right);
		int disjointMax = leftMax > rightMax ? leftMax : rightMax;
		
		int leftCrossMax = Integer.MIN_VALUE;
		int leftCrossCurr = 0;
		for (int i=midIndex; i>=left; --i) {
			leftCrossCurr += v[i];
			if (leftCrossCurr > leftCrossMax) {
				leftCrossMax = leftCrossCurr;
			}
		}
		int rightCrossMax = Integer.MIN_VALUE;
		int rightCrossCurr = 0;
		for (int i=midIndex+1; i<=right; ++i) {
			rightCrossCurr += v[i];
			if (rightCrossCurr > rightCrossMax) {
				rightCrossMax = rightCrossCurr;
			}
		}
		int crossMax = leftCrossMax + rightCrossMax;
		
		return disjointMax > crossMax ? disjointMax : crossMax;
		
	}

}
