
public class RoundRobin {

	public static void main(String[] args) {
		int k = 3;
		
		int[][] table = generateTable(k);
		int size = Math.powExact(2, k);
		
		for (int i=0; i<size; ++i) {
			for (int j=0; j<size-1; ++j) {
				System.out.print(table[i][j] + " ");
			}
			System.out.println("");
		}
	}
	
	public static int[][] generateTable(int k){
		if (k == 1) {
			return new int[][] {{2}, {1}};
		}
		
		
		int size = Math.powExact(2, k);
		
		int[][] prevTable = generateTable(k-1);
		int[][] result = new int[size][size-1];
		for (int i=0; i<prevTable.length; ++i) {
			for (int j=0; j<prevTable.length-1; ++j) {
				result[i][j]= prevTable[i][j];
				result[i+size/2][j+size/2] = prevTable[i][j];
				result[i+size/2][j] = prevTable[i][j]+size/2;
				result[i][j+size/2] = prevTable[i][j]+size/2;
			}
		}
		
		for (int i=0; i<result.length; ++i) {
			result[i][size/2-1] = (size/2+i+1) % (size) != 0 ? (size/2+i+1) % (size) : size;
		}
		
		return result;
	}

}
