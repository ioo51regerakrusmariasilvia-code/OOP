public class Lab1 {
    public static void main(String[] args) {
        try {
            byte[][] matrixB = {
                {1, 2, 3},
                {4, 5, 6},
                {7, 8, 9}
            };

            byte[][] matrixC = transpose(matrixB);

            System.out.println("Транспонована матриця C:");
            printMatrix(matrixC);
            
            int sum = calculateSumOfMinInRows(matrixC);
           
            System.out.println("Сума найменших елементів кожного рядка: " + sum);

        } catch (NullPointerException e) {
            System.out.println("Матриця не існує.");
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Помилка індексу масиву.");
        } catch (Exception e) {
            System.out.println("Помилка: " + e.getMessage());
        }
    }

    public static byte[][] transpose(byte[][] matrix) {
        if (matrix == null || matrix.length == 0 || matrix[0] == null) {
            throw new NullPointerException("Матриця порожня або не існує.");}
        
        byte[][] result = new byte[matrix[0].length][matrix.length];
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                result[j][i] = matrix[i][j];}
        }
        return result;
    }

    public static int calculateSumOfMinInRows(byte[][] matrix) {
        if (matrix == null || matrix.length == 0 || matrix[0] == null) {
            throw new NullPointerException("Матриця порожня або не існує.");}

        int sum = 0;
        for (int i = 0; i < matrix.length; i++) {
            byte min = matrix[i][0];
            for (int j = 1; j < matrix[i].length; j++) {
                if (matrix[i][j] < min) {
                    min = matrix[i][j];}}
            
            sum += min;
        }
        return sum;
    }

    private static void printMatrix(byte[][] matrix) {
        for (byte[] row : matrix) {
            for (byte elem : row) {
                System.out.print(elem + "\t");}
            System.out.println();}
    }
}