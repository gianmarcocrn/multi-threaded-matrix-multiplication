package matrix;

public class MatrixRowMultiplier extends Thread{
	private int[] row;
	private int[][] matrix;
	private int[] resultRow;
	
	//constructor
	public MatrixRowMultiplier(int[] row, int[][] matrix) {
		this.row = row;
		this.matrix = matrix;
	}
	
	public void multiplyByRow() {
		int[] resultRow = new int[matrix[0].length];
		for (int i=0; i<matrix[0].length; i++) {
			int tempSum = 0;
			// iterating through elements in rows of matrix 1 and columns of matrix2
			// to multiply with each other and add to a tempSum
			for (int x=0; x<row.length; x++) {
				tempSum += row[x] * matrix[x][i];
			}
			// element in tempSum is added to resultMatrix appropriately 
			resultRow[i] = tempSum;
		}
		this.resultRow = resultRow;
	}
	
	public int[] getResult() {
		return this.resultRow;
	}
	
	//overridden run method of Thread class, will be called with Thread.start()
	public void run() {
		this.multiplyByRow();
	}
}
