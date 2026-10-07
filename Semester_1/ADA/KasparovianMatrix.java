import java.util.Arrays;

public class KasparovianMatrix {
	
	public static void main(String[] args) {
		int n = 2;
		
		int[][] matrix = getKasparovianProduct(n);
		System.out.println(Arrays.deepToString(matrix));
	}
	
	public static int[][] getKasparovianProduct(int n){
		if (n==0) {
			return new int[][]{{1}};
		}
		
		int[][] prevProductMat = getKasparovianProduct(n-1);
		
		int size = Math.powExact(2, n);
		int[][] result = new int[size][size];
		
		for (int i=0; i<size; ++i) {
			for (int j=0; j<size; ++j) {
				result[i][j] = 2*prevProductMat[i % (size/2)][j % (size/2)];
				if ((i <= (size/2-1) && j >= (size/2)) || (i >= (size/2) && j <= (size/2-1))) result[i][j] = -result[i][j];
			}
		}
		
		return result;
	}

}
