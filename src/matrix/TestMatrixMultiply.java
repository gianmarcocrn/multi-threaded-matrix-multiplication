package matrix;

public class TestMatrixMultiply {
	public static void main(String[] args) {
		int[][] matrix_a = MatrixGenerator.generateMatrix(1000,1001);
		int[][] matrix_b = MatrixGenerator.generateMatrix(1001,1000);
		double start = System.currentTimeMillis();
		MatrixMultiplication.matrixMultiply(matrix_a,matrix_b);
		System.out.println("Matrix Multiplication time: " + ((System.currentTimeMillis()-start)/1000) + " seconds");
		start = System.currentTimeMillis();
		MatrixMultiplication.parallelMatrixMultiply(matrix_a,matrix_b);
		System.out.println("Parallel Matrix Multiplication time: " + ((System.currentTimeMillis()-start)/1000) + " seconds");
	}
}
