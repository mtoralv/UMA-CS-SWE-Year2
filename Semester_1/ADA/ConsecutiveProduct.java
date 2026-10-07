
public class ConsecutiveProduct {

	public static void main(String[] args) {
		int n = 24;
		System.out.println(consecutive(n));
		
		System.out.println(consecutiveV2(n));
	}
	
	public static int consecutive(int n) {
		int i = 1;
		while (i*(i+1)*(i+2) < n) {
			++i;
		}
		
		return i*(i+1)*(i+2) == n ? i : -1;
	}
	
	public static int consecutiveV2(int n) {
	    long left = 1;
	    long right = n;
	    
	    while (left <= right) {
	        long mid = left + (right - left) / 2;
	        long mult = mid * (mid + 1) * (mid + 2);
	        
	        if (mult == n) {
	            return (int) mid;
	        } else if (mult < n) {
	            left = mid + 1;
	        } else {
	            right = mid - 1;
	        }
	    }
	    
	    return -1;
	}

}
