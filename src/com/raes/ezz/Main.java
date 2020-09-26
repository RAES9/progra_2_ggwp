package com.raes.ezz;

public class Main {

    public static void main(String[] args) {
        createContactForm();
    }

    private static void createProject(){
        MatrixOperations project = new MatrixOperations();
        //int[][] a = new int[5][5];
        //int[][] b = new int[3][3];
        int[][] a = project.createSquareMatrix();
        int[][] b = project.createSquareMatrix();
        int[][] result = project.matrixSum(a,b);
        project.printMatrix(result, "Result Sum");
        result = project.matrixSubtraction(a,b);
        project.printMatrix(result,"Result Subtraction");
        result = project.matrixMultiply(a,b);
        project.printMatrix(result, "Result Multiply");
    }

    private static void createCicles(){
        int numbers[] = new int[4];
        //bring cicles
        Cicles c = new Cicles();
        c.ciFor();
        c.ciWhile();
        c.ciDo();
        c.makeArray();
        numbers = c.fillVector(numbers);
        c.calculateAverage(numbers, false);
        c.calculateAverage(numbers, true);
        numbers = c.multiplyNumbers(4,3);
        c.showHigher(numbers);
    }

    private static void createForm(){
        //Bring my form
        Form f = new Form();
        f.setVisible(true);
    }

    private static void createContactForm(){
        //Bring my form
        Contact f = new Contact();
        f.setVisible(true);
    }
}
