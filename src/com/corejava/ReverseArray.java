package com.corejava;


public class ReverseArray {
    public static void main(String[] args) {
        int[] array = {1, 2, 3, 4, 5}; // Example array
        
        // Printing the original array
        System.out.println("Original array:");
        printArray(array);
        
        // Reversing the array
        reverseArray(array);
        
        // Printing the reversed array
        System.out.println("\nReversed array:");
        printArray(array);
    }
    
    // Method to reverse the array
    public static void reverseArray(int[] arr) {
        int length = arr.length;
        for (int i = 0; i < length / 2; i++) {
            int temp = arr[i];
            arr[i] = arr[length - i - 1];
            arr[length - i - 1] = temp;
        }
    }
    
    // Method to print the array
    public static void printArray(int[] arr) {
        for (int num : arr) {
            System.out.print(num + " ");
        }
        System.out.println(); // Move to the next line after printing the array
    }
}
