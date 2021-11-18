package matrix;

public class MatrixMultiplication {
	
	public static int[][] matrixMultiply(int[][] matrix1, int[][] matrix2){
		int[][] resultMatrix = new int[matrix1.length][matrix2[0].length];
		// iterating through rows of matrix1
		for (int i = 0; i<matrix1.length; i++) {
			// iterating through columns of matrix2
			for (int j=0; j<matrix2[0].length; j++) {
				int tempSum = 0;
				// iterating through elements in rows of matrix 1 and columns of matrix2
				// to multiply with each other and add to a tempSum
				for (int x=0; x<matrix1[0].length; x++) {
					tempSum += matrix1[i][x] * matrix2[x][j];
				}
				// element in tempSum is added to resultMatrix appropriately 
				resultMatrix[i][j] = tempSum;
			}
		}
		return resultMatrix;
	}
	
	public static int[][] parallelMatrixMultiply(int[][] matrix1, int[][] matrix2) {
		//creating array of MatrixRowMultiplier Objects that will be our threads (1 per row of matrix1)
		MatrixRowMultiplier[] threads = new MatrixRowMultiplier[matrix1.length];
		//initialising matrix where we will store our result
		int[][] resultMatrix = new int[matrix1.length][matrix2[0].length];
		//iterating through the threads
		for (int i=0; i<threads.length; i++) {
			//storing MatrixRowMultiplier result in each thread corresponding to each row of matrix1
			threads[i] = new MatrixRowMultiplier(matrix1[i],matrix2);
			//calling the overridden run method from MatrixRowMultiplier
			threads[i].start();
		}
		//closing threads one by one and storing their results in resultMatrix to recompose the complete result matrix
		for(int i=0; i<threads.length; i++) {
			try {
				threads[i].join();
				resultMatrix[i] = threads[i].getResult();
			} catch(InterruptedException e) {}
		}
		return resultMatrix;
	}
}
