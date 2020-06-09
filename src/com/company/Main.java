package com.company;

import java.util.Arrays;

public class Main {

    public static void main(String[] args) {
        int[] arr = new int[]{96,5,255,6,39,66,256,18,34,3};
    quickSort(arr,0, arr.length);
        System.out.println(Arrays.toString(arr));
    }

    public static void quickSort(int[] arr, int begin, int end) {
        int pivot = begin + (int) (Math.random()*(end-begin));
        int pivotVal = arr[pivot];
        System.out.print("Pivot: " + pivotVal + " ");
        System.out.print("[ ");
        for(int x : arr) {
            System.out.print(x +" ");
        }
        System.out.println("]");
        swap(arr, pivot, end-1);
        int left = begin;
        int right = end-1;
        LOOP:
        while(true) {
            while(arr[left] <= pivotVal) {
                left++;
                if(left == arr.length) {
                    break LOOP;
                }
            }
            while(arr[right] >= pivotVal) {
                right--;
                if(right == -1) {
                    break LOOP;
                }
            }
            if(left > right) {
                break;
            } else {
                swap(arr, left, right);
                left++;
                right--;
            }
        }
        int i; // Pivot new position
        for(i = begin; i < end; i++) {
            if(arr[i] >= pivotVal) {
                swap(arr, i, end-1);
                break;
            }
        }
        if(i - begin > 1)
            quickSort(arr, begin, i);
        if(end - i - 1 > 1)
            quickSort(arr, i+1, end);
    }

    public static void swap(int[] arr, int first, int second) {
        int temp = arr[first];
        arr[first] = arr[second];
        arr[second] = temp;
    }
}
