package com.raes.ezz;
import java.util.Random;
import java.util.Scanner;

public class Cicles {

    public void ciFor(){
        System.out.println("-------For-------");
        int t = 0;
        for (int i = 1; i<=100; i++){
            t+=i;
        }
        System.out.println(t);
    }

    public void ciWhile(){
        System.out.println("-------While-------");
        int t = 0;
        int i = 1;
        while (i<=50) {
            t+=i;
            i++;
        }
        System.out.println(t);
    }

    public void ciDo(){
        System.out.println("-------Do-------");
        int t = 0;
        int i = 1;
        do {
            t+=i;
            i++;
        } while (i<=1000);
        System.out.println(t);
    }

    public void makeArray(){
        System.out.println("-------Vectors-------");
        int numbers[] = new int[5];
        Random r = new Random();
        for (int i = 0; i<5; i++){
            numbers[i] = r.nextInt();
            System.out.println(numbers[i]);
        }
    }

    public static int[] fillVector(int[] vector){
        Scanner in = new Scanner(System.in);
        for (int i = 0; i < vector.length; i++){
            System.out.println("Set number " + (i+1));
            vector[i] = in.nextInt();
        }
        return vector;
    }

    public void calculateAverage(int[] vector, Boolean withWhile){
        float average = 0;
        if (!withWhile) {
            for (int i = 0; i < vector.length; i++){
                average = average + vector[i];
            }
            average = average / vector.length;
            System.out.println("The average with FOR is: " + average);
        }else {
            int i = 0;
            while (i < vector.length) {
                average = average + vector[i];
                i++;
            }
            average = average / vector.length;
            System.out.println("The average with cicle WHILE is: " + average);
        }
    }

    public static int[] multiplyNumbers(int sizeVector, int qtyMultipliers){
        Scanner in = new Scanner(System.in);
        int vector[] = new int[sizeVector];
        for (int i = 0; i < vector.length; i++){
            int totalMulti = 1;
            System.out.println("----------Set numbers to multiply " + (i + 1) +"----------");
            for (int ii = 0; ii < qtyMultipliers; ii++) {
                System.out.println("Set number " + (ii + 1));
                int currentNumber = in.nextInt();
                totalMulti = totalMulti * currentNumber;
            }
            vector[i] = totalMulti;
        }
        return vector;
    }

    public void showHigher(int[] vector){
        System.out.print("To vector with numbers: ");
        int max = vector[0];
        for (int i = 0; i < vector.length; i++){
            System.out.print(vector[i] + " ");
            if (vector[i] > max) {
                max = vector[i];
            }
        }
        System.out.println("The higher is: " + max);
    }
}
