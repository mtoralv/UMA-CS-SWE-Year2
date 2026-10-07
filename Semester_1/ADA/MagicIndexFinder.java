public class MagicIndexFinder {
	
	public static void main(String[] args) {
		Integer[] v = {-5, -2, 0, 3, 7, 9};
		int result = FindMagicIndex(v);
		System.out.println(result);
	}
    
    public static int FindMagicIndex(Integer[] v) {
		return findMagicIndex_Rec(v,0,v.length-1);
	}
	
	private static int findMagicIndex_Rec(Integer[] v, int left, int right) {
		if (left == right) {
			if (v[left] == left) {
				return left;
			} else {
				return -1;
			}
		}
		
		int midIndex = (left+right)/2;
		
		if (v[midIndex] < midIndex) {
			return findMagicIndex_Rec(v, midIndex+1, right);
		} else {
			return findMagicIndex_Rec(v, left, midIndex);
		}
	}
}