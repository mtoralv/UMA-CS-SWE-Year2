public class RepeatedElementsArray {
	
	public static void main(String[] args) {
		Integer[] v = {8, 9, 10, 11, 12, 12, 13, 14, 15, 16};
		int result = FindElement(v);
		System.out.println(result);
	}

	//Precondition: There is a single and unique repeated element. v.length >= 2
	public static int FindElement(Integer[] v) {
		return findElementV2(v,0,v.length-1);
	}
	
	private static int findElementV2(Integer[] v, int left, int right) {
		if (left == right) {
			return v[left];
		}
		
		int firstElement = v[left];
		
		int midIndex = (left+right)/2;
		
		if (v[midIndex+1] == firstElement + (midIndex-left+1)) {
			return findElementV2(v, midIndex+1, right);
		} else {
			return findElementV2(v, left, midIndex);
		}
	}
}
