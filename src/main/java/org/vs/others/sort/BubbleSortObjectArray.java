package org.vs.others.sort;


public class BubbleSortObjectArray {

    public static void main(String[] args) {

        Employee[] employees = new Employee[]{
                Employee.of("Vishal", 15),
                Employee.of("Nishant", 4),
                Employee.of("Rajat", 12),
                Employee.of("Prashant", 18),
                Employee.of("Puri", 9)
        };

        bubbleSort(employees);
    }

    private static void bubbleSort(Object[] objArray) {
        int length = objArray.length;
        int maxIndex = length - 1;

        for (int i = 0; i < maxIndex; i++) {
            for (int j = 0; j < maxIndex - i; j++) {
                if (((Comparable) objArray[j]).compareTo(objArray[j + 1]) > -1) {
                    swap(objArray, j, j + 1);
                }
            }

            print(objArray);
        }
    }

    private static void print(Object[] objArray) {
        for (int i = 0; i < objArray.length; i++) {
            System.out.print(objArray[i] + " | ");
        }
        System.out.println();
    }

    private static void swap(Object[] objArray, int a, int b) {
        Object temp = objArray[a];
        objArray[a] = objArray[b];
        objArray[b] = temp;
    }

}
