import java.util.Arrays;

public class SortingAlgorithms{
    public static void main(String[] args) {
        int[] arr = {3,3,4,5,6,2,8,9,1,2,3,4,52,3,6,73,4};

        //selectionSort(arr);
        //display(arr);

        //insertionSort(arr);
        //display(arr);
        int[] arr2 = {6,2,10,4,5,6,2,3,};

        Arrays.sort(arr);
        Arrays.sort(arr2);
        display(arr);
        System.out.println();
        display(arr2);

        int[] sortedArray = merge(arr, arr2);
        display(sortedArray);
    }

    private static int[] merge(int[] arr, int[] arr2) {
        int[] temp = new int[arr.length + arr2.length];

        int i = 0;
        int j = 0;

        while(i < arr.length && j < arr2.length){
            if(arr[i] <= arr2[j]){
                temp[i+j] = arr[i];
                i++;
            }else{
                temp[i+j] = arr2[j];
                j++; 
            }

        }

        if(i != arr.length){
            for (; i < arr.length; i++) {
                temp[i+j] = arr[i];
            }     
        }else{
            for (; j < arr2.length; j++) {
                temp[i+j] = arr2[j];
            } 
        }

        return temp;


    }

    private static void insertionSort(int[] arr) {
        for (int i = 1; i < arr.length; i++) {
            int val = arr[i];
            int j;
            for (j = i-1; j >= 0 && val < arr[j] ; j--) {
                arr[j+1] = arr[j];
            }
            //or
            /*int j = i - 1
            while(j >= 0 && val < arr[j]){
                arr[j+1] = arr[j];
                j--
            }*/
            arr[j+1] = val;
            
        }
    }

    private static void display(int[] arr) {
        for (int el : arr) {
            System.out.print(el + " ");
        }
    }

    //look at powerpoint for how it works
    private static void selectionSort(int[] arr) {
        for (int i = 0; i < arr.length-1; i++) { //responsible for the division between sorted and unsorted sides
            //responsible for looking for the smallest on the unsorted side
            int minIndex = i;
            for (int j = i+1; j < arr.length; j++) {
                if(arr[minIndex]>arr[j]){
                    minIndex = j;
                }
            }

            int temp = arr[i];
            arr[i] = arr[minIndex];
            arr[minIndex] = temp;
        }
    }
}